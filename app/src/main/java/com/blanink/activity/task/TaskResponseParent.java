package com.blanink.activity.task;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.fragment.TaskResponseHistory;
import com.blanink.fragment.TaskResponseMyTask;
import com.blanink.fragment.TaskResponseNotAllocation;
import com.blanink.utils.MyActivityManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//任务详情
public class TaskResponseParent extends AppCompatActivity {
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
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.activity_task_response_list_planed_task)
    RelativeLayout activityTaskResponseListPlanedTask;
    private String processId;
    private SharedPreferences sp;
    private MyActivityManager myActivityManager;
    private List<Fragment> fragmentList;
    private int newIndex;//下一个即将可见的
    private int oldIndex;//当前可见的碎片
    private List<RadioButton> radioButtons;

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
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //初始化数据
        fragmentList = new ArrayList<>();
        fragmentList.add(new TaskResponseMyTask());
        fragmentList.add(new TaskResponseNotAllocation());
        fragmentList.add(new TaskResponseHistory());
        radioButtons=new ArrayList<>();
        radioButtons.add(rbMine);
        radioButtons.add(rbNot);
        radioButtons.add(rbHistory);

        //切换界面
        rgTask.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_mine://我的任务
                        newIndex = 0;
                        break;
                    case R.id.rb_not://未分配
                        newIndex = 1;
                        break;
                    case R.id.rb_history://历史
                        newIndex = 2;
                        break;
                }
                viewPager.setCurrentItem(newIndex);

            }
        });

        initLine(fragmentList);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

        viewPager.setCurrentItem(0);//默认选中第一个
        LineChange(fragmentList);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioButtons.get(position).setChecked(true);
                //radioButtons.get(position).setTextSize(18);
                LineChange(fragmentList);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置适配

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
    //底部直线选中状态切换
    private void LineChange(List<Fragment> fragmentLists) {
        Log.e("@@@@", "LineChange: " + fragmentLists.size());
        int currentPage = viewPager.getCurrentItem() % fragmentLists.size();
        for (int i = 0; i < fragmentLists.size(); i++) {
            llBottom.getChildAt(i).setEnabled(currentPage == i);
        }
    }

    //底部直线动态初始化
    private void initLine(List<Fragment> fragmentLists) {
        Log.e("@@@@", "initLine: " + fragmentLists.size());
        if (fragmentLists == null) {
            fragmentLists = new ArrayList<>();
        }

        for (int i = 0; i < fragmentLists.size(); i++) {
            View view = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            //设置控件的显示位置,相当于控件的layout_gravity属性
            params.gravity = Gravity.CENTER;


            params.leftMargin = 50;
            params.rightMargin = 50;
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.selector_line);
            llBottom.addView(view);
        }
    }

}
