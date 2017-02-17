package com.blanink.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.utils.MyActivityManager;

/***
 * 来单列表
 */
public class ComeOrderActivity extends AppCompatActivity {

    private ImageView come_order_iv_last;
    private final static int BACK_TASK=0;
    private MyActivityManager myActivityManager;
    private Button come_order_btn_newAddOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_order);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initView();
        initData();
    }


    private void initView() {
        come_order_iv_last = ((ImageView) findViewById(R.id.come_order_iv_last));
        come_order_btn_newAddOrder = ((Button) findViewById(R.id.come_order_btn_newAddOrder));//新增订单
    }
    private void initData() {
        //返回task
        come_order_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ComeOrderActivity.this,MainActivity.class);
                intent.putExtra("DIRECT",BACK_TASK);
                startActivity(intent);
                finish();
            }
        });
        come_order_btn_newAddOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ComeOrderActivity.this,ComeOrderNewAddInfoActivity.class);//跳转到新增订单
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent=new Intent(ComeOrderActivity.this,MainActivity.class);
        intent.putExtra("DIRECT",BACK_TASK);
        startActivity(intent);
        myActivityManager.popOneActivity(this);
    }
}
