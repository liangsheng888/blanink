package com.blanink.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blanink.R;
import com.blanink.utils.AutoAdvertise;
import com.blanink.utils.MyActivityManager;

import java.util.ArrayList;
import java.util.List;

/***
 * 任务反馈列表
 */
public class TaskResponseQueue extends AppCompatActivity {

    private static final int BACK_TASK = 0;
    private ImageView workStepQueue_iv_last;
    private MyActivityManager myActivityManager;
    private ViewPager viewPager;
    private LinearLayout ll_viewpager_bottom;
    private List<Integer> drawableLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_step_queue);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initView();
        initData();
    }
    private void initView() {
        workStepQueue_iv_last = ((ImageView) findViewById(R.id.workStepQueue_iv_last));
        viewPager = ((ViewPager) findViewById(R.id.viewPager));
        ll_viewpager_bottom = ((LinearLayout) findViewById(R.id.ll_viewpager_bottom));
    }

    private void initData() {
        drawableLists=new ArrayList<>();
        drawableLists.add(R.drawable.guanggao);
        drawableLists.add(R.drawable.guanggao1);
        drawableLists.add(R.drawable.guanggao2);
        drawableLists.add(R.drawable.guanggao3);

        AutoAdvertise autoAdvertise=new AutoAdvertise(this,viewPager,ll_viewpager_bottom,drawableLists);
        autoAdvertise.pictureRoll();//广告轮播
        workStepQueue_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TaskResponseQueue.this,MainActivity.class);
                intent.putExtra("DIRECT",BACK_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
        Intent intent=new Intent(TaskResponseQueue.this,MainActivity.class);
        intent.putExtra("DIRECT",BACK_TASK);
        startActivity(intent);
    }
}
