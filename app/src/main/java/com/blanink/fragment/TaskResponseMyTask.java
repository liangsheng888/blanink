package com.blanink.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.task.TaskResponseDeliver;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.OrderProduct;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.PriorityUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 我的任务
 */
public class TaskResponseMyTask extends Fragment {

    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.ll_load)
    LinearLayout llLoad;
    @BindView(R.id.loading_error_img)
    ImageView loadingErrorImg;
    @BindView(R.id.rl_load_fail)
    RelativeLayout rlLoadFail;
    @BindView(R.id.tv_not)
    TextView tvNot;
    @BindView(R.id.rl_not_data)
    RelativeLayout rlNotData;
    private String processId;
    private SharedPreferences sp;
    private CommonAdapter<OrderProduct.Result> commonAdapter;
    private List<OrderProduct.Result> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout_header_order for this fragment
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
        View view = View.inflate(getActivity(), R.layout.fragment_my_task, null);
        receivedData();
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //我的任务详情
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if ("3".equals(getActivity().getIntent().getStringExtra("processType"))) {
                    Intent intent = new Intent(getActivity(), TaskResponseDeliver.class);
                    intent.putExtra("processId",processId);
                    intent.putExtra("companyId", list.get(position).companyA.id);
                    intent.putExtra("flowId",list.get(position).relFlowProcess.flow.id);
                    startActivity(intent);

                } else {
                    Intent intent = new Intent(getActivity(), com.blanink.activity.task.TaskResponseMyTask.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("TaskDetail", list.get(position));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }

    private void receivedData() {
        Intent intent = getActivity().getIntent();
        processId = intent.getStringExtra("processId");
        Log.e("TaskResponse", "processId:" + processId + ",userId:" + sp.getString("USER_ID", null));
    }

    public void loadData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/listPlanedTask");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("process.id", processId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e("TaskResponse", result);
                Gson gson = new Gson();
                OrderProduct listPlanedTask = gson.fromJson(result, OrderProduct.class);
                if (listPlanedTask.result.size() == 0) {
                    rlNotData.setVisibility(View.VISIBLE);
                }
                list = new ArrayList<OrderProduct.Result>();
                list.addAll(listPlanedTask.result);
                Log.e("TaskResponse", listPlanedTask.toString());
                if (commonAdapter == null) {
                    commonAdapter = new CommonAdapter<OrderProduct.Result>(getActivity(), list, R.layout.item_planed_task) {
                        @Override
                        public void convert(ViewHolder viewHolder, OrderProduct.Result result, int position) {
                            result = list.get(position);
                            TextView tv_companyName = viewHolder.getViewById(R.id.tv_companyName);
                            TextView tv_time = viewHolder.getViewById(R.id.tv_time);
                            TextView tv_master = viewHolder.getViewById(R.id.tv_master);
                            TextView tv_pro_name = viewHolder.getViewById(R.id.tv_pro_name);
                            TextView tv_priority = viewHolder.getViewById(R.id.tv_priority);
                            TextView tv_pro_category = viewHolder.getViewById(R.id.tv_pro_category);
                            TextView tv_response = viewHolder.getViewById(R.id.tv_response);
                            TextView tv_my_task_num = viewHolder.getViewById(R.id.tv_my_task_num);
                            TextView tv_num = viewHolder.getViewById(R.id.tv_num);
                            tv_companyName.setText(result.companyA.name);
                            tv_time.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(result.createDate)));
                          //  tv_master.setText(result.companyBOwner.name);
                            tv_pro_name.setText(result.productName);
                            tv_pro_category.setText(result.companyCategory.name);
                            tv_response.setText((result.finishedAmount == null ? 0 : result.finishedAmount) + "");//我的反馈
                            tv_my_task_num.setText(result.workPlan.achieveAmount);//我的任务
                            tv_num.setText(result.amount);//订单产品数量
                            tv_priority.setText(PriorityUtils.getPriority(result.workPlan.priority));

                        }
                    };
                    lv.setAdapter(commonAdapter);
                } else {
                    commonAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                llLoad.setVisibility(View.GONE);
                rlLoadFail.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }

    @OnClick(R.id.rl_load_fail)
    public void onClick() {
        llLoad.setVisibility(View.VISIBLE);
        rlLoadFail.setVisibility(View.GONE);
        loadData();
    }

    @Override
    public void onStart() {
        super.onStart();
        loadData();
    }
}
