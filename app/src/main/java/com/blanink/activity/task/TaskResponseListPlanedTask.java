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
import com.blanink.fragment.TaskResponseHistory;
import com.blanink.utils.MyActivityManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//任务详情
public class TaskResponseListPlanedTask extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.rl_workStepQueue)
    RelativeLayout rlWorkStepQueue;
    @BindView(R.id.rb_mine)
    RadioButton rbMine;
    @BindView(R.id.rb_not)
    RadioButton rbNot;
    @BindView(R.id.rb_history)
    RadioButton rbHistory;
    @BindView(R.id.rg_task)
    RadioGroup rgTask;
    @BindView(R.id.fl_task)
    FrameLayout flTask;
    @BindView(R.id.activity_task_response_list_planed_task)
    RelativeLayout activityTaskResponseListPlanedTask;
    private String processId;
    private SharedPreferences sp;
    private MyActivityManager myActivityManager;
    private List<Fragment> fragmentList;
    private int newIndex;//下一个即将可见的
    private int oldIndex;//当前可见的碎片
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_response_list_planed_task);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        //初始化数据
        fragmentList=new ArrayList<>();
        fragmentList.add(new TaskResponseMyTask());
        fragmentList.add(new TaskResponseNotAllocation());
        fragmentList.add(new TaskResponseHistory());
        //默认显示我的任务
        getSupportFragmentManager().beginTransaction().add(R.id.fl_task,fragmentList.get(0)).commit();
        //切换界面
        rgTask.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_mine://我的任务
                        newIndex=0;
                        break;
                    case R.id.rb_not://未分配
                        newIndex=1;
                        break;
                    case R.id.rb_history://历史
                        newIndex=2;
                        break;
                }
                changeFragments(newIndex);
            }
        });
    }


   //点击事件
    @OnClick({R.id.iv_last})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_last:
                finish();//返回
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
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

}
