package com.blanink.activity.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.WorkPlaned;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 任务分配详情
 */
public class WorkPlanAllocationDetail extends AppCompatActivity {


    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.rl_activity_work_plan_allocation_detail)
    RelativeLayout rlActivityWorkPlanAllocationDetail;
    @BindView(R.id.tv_companyName)
    TextView tvCompanyName;
    @BindView(R.id.master)
    TextView master;
    @BindView(R.id.tv_master)
    TextView tvMaster;
    @BindView(R.id.order_item_ll)
    LinearLayout orderItemLl;
    @BindView(R.id.tv_woker)
    TextView tvWoker;
    @BindView(R.id.tv_woker_name)
    TextView tvWokerName;
    @BindView(R.id.priority)
    TextView priority;
    @BindView(R.id.tv_priority)
    TextView tvPriority;
    @BindView(R.id.ll_woker)
    LinearLayout llWoker;
    @BindView(R.id.tv_pro_category)
    TextView tvProCategory;
    @BindView(R.id.order_item_ll2_guigeName)
    TextView orderItemLl2GuigeName;
    @BindView(R.id.tv_pro_name)
    TextView tvProName;
    @BindView(R.id.order_item_ll2)
    LinearLayout orderItemLl2;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.finish)
    TextView finish;
    @BindView(R.id.tv_finish)
    TextView tvFinish;
    @BindView(R.id.order_item)
    LinearLayout orderItem;
    @BindView(R.id.tv_order_time)
    TextView tvOrderTime;
    @BindView(R.id.tv_take_order_time)
    TextView tvTakeOrderTime;
    @BindView(R.id.ll_date)
    LinearLayout llDate;
    @BindView(R.id.note)
    TextView note;
    @BindView(R.id.tv_note)
    TextView tvNote;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.activity_work_plan_allocation_detail)
    RelativeLayout activityWorkPlanAllocationDetail;
    @BindView(R.id.tv_category)
    TextView tvCategory;
    @BindView(R.id.achieveAmount)
    TextView achieveAmount;
    @BindView(R.id.tv_achieveAmount)
    TextView tvAchieveAmount;
    private MyActivityManager myActivityManager;
    private WorkPlaned.ResultBean.Rows workPlanAllocationDetail;
    private List<WorkPlaned.ResultBean.Rows> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_plan_allocation_detail);
        ButterKnife.bind(this);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        receiveDataFromWorkPlanAllocation();
        initData();
    }

    private void receiveDataFromWorkPlanAllocation() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        workPlanAllocationDetail = ((WorkPlaned.ResultBean.Rows) bundle.getSerializable("WorkPlanAllocationDetail"));
        Log.e("AllocationDetail", workPlanAllocationDetail.toString());
        list.add(workPlanAllocationDetail);
    }

    private void initData() {
        tvCompanyName.setText(workPlanAllocationDetail.getCompanyA().getName());
        tvMaster.setText(workPlanAllocationDetail.getCompanyBOwner().getName());
        tvPriority.setText(workPlanAllocationDetail.getWorkPlan().getPriority());
        tvProCategory.setText(workPlanAllocationDetail.getCompanyCategory().getName());
        tvProName.setText(workPlanAllocationDetail.getProductName());
        tvFinish.setText(workPlanAllocationDetail.getRelFlowProcess().getTotalCompletedQuantity() + "/" + workPlanAllocationDetail.getRelFlowProcess().getTarget());
        tvTakeOrderTime.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(workPlanAllocationDetail.getWorkPlan().getCreateDate())));
        tvNum.setText(workPlanAllocationDetail.getAmount());
        tvWokerName.setText(workPlanAllocationDetail.getWorkPlan().getWorker().getName());
        tvNote.setText(workPlanAllocationDetail.getWorkPlan().getRemarks());
        tvAchieveAmount.setText(workPlanAllocationDetail.getWorkPlan().getAchieveAmount());


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    @OnClick(R.id.iv_last)
    public void onClick() {
        finish();
    }
}
