package com.blanink.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blanink.R;
import com.blanink.utils.MyActivityManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 * 高级查看
 */
public class LookSuperSeek extends Activity {
    private static final int SEEK = 1;
    private ImageView super_seek_iv_last;
    MyActivityManager activityManager;
    private EditText super_seek_rulerName;
  //private RollPagerView rollPagerView;
    private ViewPager viewPager;
    private LinearLayout ll_viewpager_bottom;
    private List<Integer> drawableLists;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.super_seek);
        activityManager= MyActivityManager.getInstance();
        activityManager.pushOneActivity(this);
       /* rollPagerView=(RollPagerView) this.findViewById(R.id.super_seek_guangao);
        AdvertiseUtils.pictureRoll(this,rollPagerView);*/
        viewPager=(ViewPager) this.findViewById(R.id.super_seek_guangao);
        ll_viewpager_bottom = ((LinearLayout) this.findViewById(R.id.ll_viewpager_bottom));
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
        //清空super_seek_rulerName的焦点
        super_seek_rulerName.clearFocus();
        super_seek_rulerName.setCursorVisible(false);
        super_seek_rulerName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    super_seek_rulerName.setCursorVisible(true);
                }else{
                    super_seek_rulerName.setCursorVisible(false);
                    super_seek_rulerName.clearFocus();
                }
            }
        });
        //返回
        super_seek_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LookSuperSeek.this,MainActivity.class);
                intent.putExtra("DIRECT",SEEK);
                startActivity(intent);

            }
        });
    }

    private void initView() {
        super_seek_iv_last = ((ImageView) findViewById(R.id.super_seek_iv_last));
        super_seek_rulerName = ((EditText) findViewById(R.id.super_seek_rulerName));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LookSuperSeek","onDestroy");
        activityManager.popOneActivity(this);
        Intent intent=new Intent(LookSuperSeek.this,MainActivity.class);
        intent.putExtra("DIRECT",SEEK);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        super_seek_rulerName.setCursorVisible(false);
        super_seek_rulerName.clearFocus();

    }
}
