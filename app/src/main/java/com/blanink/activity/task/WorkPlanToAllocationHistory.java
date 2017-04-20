package com.blanink.activity.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.WorkPlanToAllocation;
import com.blanink.utils.MyActivityManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 去分配 更多历史分配记录
 */
public class WorkPlanToAllocationHistory extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.task_response_rl)
    RelativeLayout taskResponseRl;
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
    @BindView(R.id.activity_more_response_note_activty)
    RelativeLayout activityMoreResponseNoteActivty;
    private MyActivityManager myActivityManager;
    private com.blanink.pojo.WorkPlanToAllocation workPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_plan_to_allocation_history);
        ButterKnife.bind(this);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        receiveData();
        initData();
    }

    private void initData() {
        lv.setAdapter(new CommonAdapter<WorkPlanToAllocation.ResultBean.WorkPlanListBean>(WorkPlanToAllocationHistory.this, workPlan.getResult().getWorkPlanList(), R.layout.item_work_plan_history_allocated) {
            @Override
            public void convert(ViewHolder viewHolder, WorkPlanToAllocation.ResultBean.WorkPlanListBean workPlanBean, int position) {
                workPlanBean = workPlan.getResult().getWorkPlanList().get(position);
                TextView tv_allocation_time = viewHolder.getViewById(R.id.tv_allocation_time);
                TextView tv_task_person = viewHolder.getViewById(R.id.tv_task_person);
                TextView tv_allocation_num = viewHolder.getViewById(R.id.tv_allocation_num);
                tv_allocation_time.setText(workPlanBean.getCreateDate());
                tv_task_person.setText(workPlanBean.getWorker().getName());
                tv_allocation_num.setText(workPlanBean.getAchieveAmount());
            }
        });

    }

    private void receiveData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        workPlan = (WorkPlanToAllocation) bundle.getSerializable("workPlan");
        if (workPlan != null) {
            llLoad.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    @OnClick(R.id.iv_last)
    public void onClick() {
        //返回
        finish();
    }
}
