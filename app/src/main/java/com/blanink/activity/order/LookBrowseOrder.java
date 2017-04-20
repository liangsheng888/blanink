package com.blanink.activity.order;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blanink.R;
import com.blanink.activity.MainActivity;
import com.blanink.utils.MyActivityManager;

import java.util.ArrayList;
import java.util.List;

/***
 * 查看 浏览订单
 */
public class LookBrowseOrder extends AppCompatActivity {

    private ImageView findOrder_iv_last;
    private static final int FIND_ORDER = 1;
    private MyActivityManager activityManager;
   // private RollPagerView rollViewPager;
    private ViewPager viewPager;
    private List<Integer> drawableLists;
    private LinearLayout viewpager_bottom_oval;
    private ViewPager findOrder_guangao;
    private LinearLayout ll_viewpager_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_order);
        activityManager= MyActivityManager.getInstance();
        activityManager.pushOneActivity(this);
        initView();
        initData();
    }

    private void initData() {
        //将图片添加到集合中
        drawableLists=new ArrayList<>();
        drawableLists.add(R.drawable.guanggao);
        drawableLists.add(R.drawable.guanggao1);
        drawableLists.add(R.drawable.guanggao2);
        drawableLists.add(R.drawable.guanggao3);
        //初始化得到autoAdvertise对象
        findOrder_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LookBrowseOrder.this,MainActivity.class);
                intent.putExtra("DIRECT",FIND_ORDER);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        findOrder_iv_last = ((ImageView) findViewById(R.id.findOrder_iv_last));
        viewPager = ((ViewPager) findViewById(R.id.findOrder_guangao));
        ll_viewpager_bottom = ((LinearLayout) findViewById(R.id.ll_viewpager_bottom));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LookBrowseOrder","onDestroy");
        activityManager.popOneActivity(this);//出栈
        Intent intent=new Intent(LookBrowseOrder.this,MainActivity.class);
        intent.putExtra("DIRECT",FIND_ORDER);
        startActivity(intent);

    }
}
