package com.blanink.activity.task;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.fragment.TaskResponseMyTask;
import com.blanink.fragment.TaskResponseNotAllocation;
import com.blanink.fragment.WorkPlanAllocation;
import com.blanink.fragment.WorkPlanNotAllocation;
import com.blanink.utils.MyActivityManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 任务分配详情
 */
public class WorkPlanDetail extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.rl_workStepQueue)
    RelativeLayout rlWorkStepQueue;
    @BindView(R.id.rb_not_work)
    RadioButton rbNotWork;
    @BindView(R.id.rb_worked)
    RadioButton rbWorked;
    @BindView(R.id.rg_task)
    RadioGroup rgTask;
    @BindView(R.id.fl_task)
    FrameLayout flTask;
    @BindView(R.id.activity_work_plan_detail)
    RelativeLayout activityWorkPlanDetail;
    private String processId;
    private SharedPreferences sp;
    private MyActivityManager myActivityManager;
    private List<Fragment> fragmentList;
    private int newIndex;//下一个即将可见的
    private int oldIndex;//当前可见的碎片
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_plan_detail);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

        //初始化数据
        fragmentList=new ArrayList<>();
        fragmentList.add(new WorkPlanNotAllocation());
        fragmentList.add(new WorkPlanAllocation());
        //默认显示我的任务
        getSupportFragmentManager().beginTransaction().add(R.id.fl_task,fragmentList.get(0)).commit();
        //切换界面
        rgTask.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_not_work://待分配
                        newIndex=0;
                        break;
                    case R.id.rb_worked://已分配
                        newIndex=1;
                        break;
                }
                changeFragments(newIndex);
            }
        });
    }

    @OnClick({R.id.iv_last, R.id.rl_workStepQueue})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_last:
                finish();
                break;
            case R.id.rl_workStepQueue:
                break;
        }
    }
    //切换界面
    private void changeFragments(int newIndex) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(newIndex!=oldIndex){
            ft.hide(fragmentList.get(oldIndex));//隐藏当前的界面
            if(!fragmentList.get(newIndex).isAdded()){//如果没有添加则添加
                ft.add(R.id.fl_task,fragmentList.get(newIndex));
            }
            ft.show(fragmentList.get(newIndex)).commit();//显示

        }
        //改变当前的选中项
        oldIndex=newIndex;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
