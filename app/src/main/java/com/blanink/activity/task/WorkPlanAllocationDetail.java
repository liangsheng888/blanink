package com.blanink.activity.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.AttachmentBrow;
import com.blanink.pojo.FeedBackingTaskHistory;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.StringToListUtils;
import com.google.gson.Gson;

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
    @BindView(R.id.tv_pro_category)
    TextView tvProCategory;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.order_item_ll2)
    RelativeLayout orderItemLl2;
    @BindView(R.id.order_item_ll2_guigeName)
    TextView orderItemLl2GuigeName;
    @BindView(R.id.tv_pro_name)
    TextView tvProName;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.task)
    TextView task;
    @BindView(R.id.tv_target)
    TextView tvTarget;
    @BindView(R.id.response)
    TextView response;
    @BindView(R.id.tv_response)
    TextView tvResponse;
    @BindView(R.id.tv_my_task)
    TextView tvMyTask;
    @BindView(R.id.bad_num)
    TextView badNum;
    @BindView(R.id.attactment)
    TextView attactment;
    @BindView(R.id.tv_attactment)
    TextView tvAttactment;
    @BindView(R.id.rl_down)
    RelativeLayout rlDown;
    @BindView(R.id.note)
    TextView note;
    @BindView(R.id.tv_note)
    TextView tvNote;
    @BindView(R.id.activity_work_plan_allocation_detail)
    RelativeLayout activityWorkPlanAllocationDetail;
    private MyActivityManager myActivityManager;
    private FeedBackingTaskHistory.ResultBean.ProcessFeedbackListBean workPlanAllocationDetail;

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
        workPlanAllocationDetail = ((FeedBackingTaskHistory.ResultBean.ProcessFeedbackListBean) bundle.getSerializable("ResopnseDetail"));
        Log.e("AllocationDetail", workPlanAllocationDetail.toString());
    }

    private void initData() {
        tvTarget.setText(workPlanAllocationDetail.getTarget() + "");
        tvResponse.setText(workPlanAllocationDetail.getAchieveAmount() + "");
        badNum.setText(workPlanAllocationDetail.getFaultAmount() + "");
        tvNote.setText(workPlanAllocationDetail.getRemarks());
        tvTime.setText(workPlanAllocationDetail.getCreateDate());
        tvProName.setText(getIntent().getStringExtra("productName"));
        tvProCategory.setText(getIntent().getStringExtra("productCategory"));
        tvNum.setText(getIntent().getStringExtra("productNum"));
        List<String> arrayList=null;
        Log.e("WorkPlanAllocationDetail", workPlanAllocationDetail.getFeedbackAttachmentStr().toString());
        if (workPlanAllocationDetail.getFeedbackAttachmentStr() != null && workPlanAllocationDetail.getFeedbackAttachmentStr() != ""&&!workPlanAllocationDetail.getFeedbackAttachmentStr().equals("")) {
             arrayList = StringToListUtils.stringToList(workPlanAllocationDetail.getFeedbackAttachmentStr(), ",");
        }else {
            arrayList=new ArrayList<>();
        }
        final List<String> finalArrayList = arrayList;
        tvAttactment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkPlanAllocationDetail.this, AttachmentBrow.class);
                intent.putExtra("imageList", new Gson().toJson(finalArrayList));
                startActivity(intent);
            }
        });


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
