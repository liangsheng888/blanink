package com.blanink.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.flow.FlowOrder;
import com.blanink.activity.task.TaskResponseProcessQueue;
import com.blanink.activity.task.WorkPlanProcessQueue;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/1/7.
 */
public class SecondPageFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.tv_workPlan)
    TextView tvWorkPlan;
    @BindView(R.id.tv_fr_task_response)
    TextView tvFrTaskResponse;
    @BindView(R.id.framgent_task_rl_ll)
    LinearLayout framgentTaskRlLl;
    Unbinder unbinder;
    @BindView(R.id.tv_flow)
    TextView tvFlow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_second_page, null);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }


    private void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_workPlan, R.id.tv_fr_task_response,R.id.tv_flow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //工作反馈
            case R.id.tv_fr_task_response:
                Intent intentTaskResponse = new Intent(getActivity(), TaskResponseProcessQueue.class);
                startActivity(intentTaskResponse);
                break;

            //任务分工
            case R.id.tv_workPlan:
                Intent intentworkPlan = new Intent(getActivity(), WorkPlanProcessQueue.class);
                startActivity(intentworkPlan);
                break;
            case R.id.tv_flow:
                Intent intentFlow = new Intent(getActivity(), FlowOrder.class);
                startActivity(intentFlow);
                break;
        }
    }
}
