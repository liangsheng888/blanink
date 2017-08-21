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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.task.TaskNotAllocationToResponse;
import com.blanink.activity.task.TaskResponseDeliver;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.WorkedTask;
import com.blanink.utils.CommonUtil;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/8.
 * 待分配的任务
 */

public class TaskResponseNotAllocation extends Fragment {
    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.ll_load)
    LinearLayout llLoad;
    @BindView(R.id.rl_load_fail)
    RelativeLayout rlLoadFail;
    @BindView(R.id.rl_not_data)
    RelativeLayout rlNotData;
    private String processId;
    private SharedPreferences sp;
    private CommonAdapter<WorkedTask.ResultBean> commonAdapter;
    private List<WorkedTask.ResultBean> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout_header_order for this fragment
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
        receivedData();
        View view = inflater.inflate(R.layout.fragment_my_task, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if ("3".equals(getActivity().getIntent().getStringExtra("processType"))) {
                    Intent intent = new Intent(getActivity(), TaskResponseDeliver.class);
                    intent.putExtra("processId", processId);
                    if (list.get(position).getACompany() != null) {
                        intent.putExtra("companyId", list.get(position).getACompany().getId());
                    }
                    intent.putExtra("flowId", list.get(position).getRelFlowProcess().getFlow().getId());
                    startActivity(intent);

                } else {
                    Intent intent = new Intent(getActivity(), TaskNotAllocationToResponse.class);
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

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/listTask");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("process.id", processId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e("TaskResponse", result);
                Gson gson = new Gson();
                WorkedTask listPlanedTask = gson.fromJson(result, WorkedTask.class);
                if (listPlanedTask.getResult().size() == 0) {
                    rlNotData.setVisibility(View.VISIBLE);
                }
                list = new ArrayList<WorkedTask.ResultBean>();

                list.addAll(listPlanedTask.getResult());
                Log.e("TaskResponse", listPlanedTask.toString());
                if (commonAdapter == null) {
                    commonAdapter = new CommonAdapter<WorkedTask.ResultBean>(getActivity(), list, R.layout.item_not_task) {
                        @Override
                        public void convert(ViewHolder viewHolder, WorkedTask.ResultBean result, int position) {
                            result = list.get(position);
                            TextView tv_companyName = viewHolder.getViewById(R.id.tv_companyName);
                            TextView tv_time = viewHolder.getViewById(R.id.tv_time);
                            TextView tv_master = viewHolder.getViewById(R.id.tv_master);
                            TextView tv_pro_name = viewHolder.getViewById(R.id.tv_pro_name);//规格名称
                            TextView tv_pro_category = viewHolder.getViewById(R.id.tv_pro_category);//产品类
                            TextView tv_num = viewHolder.getViewById(R.id.tv_num);
                            TextView tv_note = viewHolder.getViewById(R.id.tv_note);
                            TextView tv_finished_percent = viewHolder.getViewById(R.id.tv_finished_percent);
                            tv_companyName.setText(result.getCompanyA().getName());
                            tv_time.setText(CommonUtil.dateToString(CommonUtil.stringToDate(result.getCreateDate())));
                           // tv_master.setText(result.getCompanyBOwner().getName());
                            tv_pro_name.setText(result.getProductName());
                            tv_pro_category.setText(result.getCompanyCategory().getName());
                            tv_num.setText(result.getAmount() + "");//数量
                            tv_note.setText(result.getProductDescription());
                            tv_finished_percent.setText((result.getRelFlowProcess().getTotalCompletedQuantity()) + "/" + result.getRelFlowProcess().getTarget());
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
                Log.e("TaskResponse", ex.toString());

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

    @OnClick(R.id.rl_load_fail)//加载失败，点击重新加载
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
