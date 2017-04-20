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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.task.WorkPlanToAllocation;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.WorkPlan;
import com.blanink.utils.ExampleUtil;
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
 * Created by Administrator on 2017/3/16.
 * 任务分陪  待分配
 */

public class WorkPlanNotAllocation extends Fragment {
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
    @BindView(R.id.fl_load)
    FrameLayout flLoad;
    private String processId;
    private SharedPreferences sp;
    private CommonAdapter<WorkPlan.ResultBean> commonAdapter;
    private List<WorkPlan.ResultBean> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_my_task, null);
        sp=getActivity().getSharedPreferences("DATA",getActivity().MODE_PRIVATE);
        ButterKnife.bind(this, view);
        receivedData();
        return view;
    }
    private void receivedData() {
        Intent intent = getActivity().getIntent();
        processId = intent.getStringExtra("processId");
        Log.e("TaskResponse", "processId:" + processId + ",userId:" + sp.getString("USER_ID", null));
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),WorkPlanToAllocation.class);
                intent.putExtra("processId",list.get(position).getRelFlowProcess().getProcess().getId());
                intent.putExtra("flowId",list.get(position).getRelFlowProcess().getFlow().getId());
                startActivity(intent);
                Log.e("WorkPlanNotAllocation","process.id:"+list.get(position).getRelFlowProcess().getProcess().getId()+",flow.id:"+list.get(position).getRelFlowProcess().getFlow().getId());
            }
        });
    }

    @OnClick(R.id.rl_load_fail)//加载失败 点击重新加载
    public void onClick() {
        rlLoadFail.setVisibility(View.GONE);
        loadData();
    }


    public void loadData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "workPlan/listCanPlanTask");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("process.id", processId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("WorkPlanNotAllocation", result);
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                WorkPlan listPlanedTask = gson.fromJson(result, WorkPlan.class);
                Log.e("WorkPlanNotAllocation","解析完成:"+listPlanedTask.toString());
                if (listPlanedTask.getResult().size()==0){
                    rlNotData.setVisibility(View.VISIBLE);
                }
                list = new ArrayList<WorkPlan.ResultBean>();
                list.addAll(listPlanedTask.getResult());
                Log.e("TaskResponse", listPlanedTask.toString());
                if (commonAdapter == null) {
                    commonAdapter = new CommonAdapter<WorkPlan.ResultBean>(getActivity(), list, R.layout.item_work_plan_can_allocation) {
                        @Override
                        public void convert(ViewHolder viewHolder, WorkPlan.ResultBean result, int position) {
                            result = list.get(position);
                            TextView tv_companyName = viewHolder.getViewById(R.id.tv_companyName);
                            TextView tv_time = viewHolder.getViewById(R.id.tv_take_order_time);
                            TextView tv_master = viewHolder.getViewById(R.id.tv_master);
                            TextView tv_pro_name = viewHolder.getViewById(R.id.tv_pro_name);//规格名称
                            TextView tv_pro_category = viewHolder.getViewById(R.id.tv_pro_category);//产品类
                            TextView tv_num = viewHolder.getViewById(R.id.tv_num);
                            TextView tv_priority = viewHolder.getViewById(R.id.tv_priority);
                            TextView tv_note = viewHolder.getViewById(R.id.tv_note);
                            tv_companyName.setText(result.getCompanyA().getName());
                            tv_time.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(result.getCreateDate())));
                            tv_master.setText(result.getCompanyBOwner().getName());
                            tv_pro_name.setText(result.getProductName());
                            tv_pro_category.setText(result.getCompanyCategory().getName());
                            tv_num.setText(result.getRelFlowProcess().getTarget()+"");//数量
                            tv_note.setText(result.getProductDescription());
                            tv_priority.setText(result.getRelFlowProcess().getProcessPriority());


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
}
