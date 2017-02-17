package com.blanink.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blanink.R;
import com.blanink.fragment.AfterSaleHandleFinished;
import com.blanink.fragment.AfterSaleNotHandle;
import com.blanink.fragment.SeekFragment;
import com.blanink.fragment.TaskFragment;
import com.blanink.utils.MyActivityManager;

/***
 * 售后列表
 */
public class AfterSaleQueue extends AppCompatActivity {

    private ImageView customer_apply_iv_last;
    private RadioGroup rg_after_sale;
    private MyActivityManager myActivityManager;
    private int newIndex;//下一个即将可见的
    private int oldIndex;//当前可见的碎片
    private Fragment[] fragments=new Fragment[2];
    private RadioButton[] buttons=new RadioButton[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sale_queue);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initView();
        initData();
    }

    private void initView() {
        customer_apply_iv_last = ((ImageView) findViewById(R.id.after_sale_queue_iv_last));
        rg_after_sale = ((RadioGroup) findViewById(R.id.rg_after_sale));
    }

    private void initData() {
        fragments[0]=new AfterSaleNotHandle();
        fragments[1]=new AfterSaleHandleFinished();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_after_sale,fragments[0]).commit();

        customer_apply_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rg_after_sale.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_not_handle:
                        //待处理
                        newIndex=0;
                        break;
                    case R.id.rb_handle_finished:
                        //已处理
                        newIndex=1;
                        break;
                }
                changeFragments(newIndex);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
        Intent intent=new Intent(AfterSaleQueue.this,MainActivity.class);
        intent.putExtra("DIRECT",0);
        startActivity(intent);
    }
    //切换界面
    private void changeFragments(int newIndex) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(newIndex!=oldIndex){
            ft.hide(fragments[oldIndex]);//隐藏当前的界面
            if(!fragments[newIndex].isAdded()){//如果没有添加则添加
                ft.add(R.id.fl_after_sale,fragments[newIndex]);
            }
            ft.show(fragments[newIndex]).commit();//显示
        }
        //改变当前的选中项
        oldIndex=newIndex;
    }
}
