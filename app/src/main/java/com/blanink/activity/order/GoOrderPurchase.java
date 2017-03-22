package com.blanink.activity.order;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.blanink.R;
import com.blanink.activity.MainActivity;
import com.blanink.utils.MyActivityManager;

/***
 * 去单采购/去单列表
 */
public class GoOrderPurchase extends AppCompatActivity {

    private static final int BACK_TASK = 0;
    private ImageView go_order_purchase_iv_last;
    private MyActivityManager myActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_order_purchase);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);

        initView();
        initData();
    }
    private void initView() {
        go_order_purchase_iv_last = ((ImageView) findViewById(R.id.go_order_purchase_iv_last));
    }
    private void initData() {
        //返回
        go_order_purchase_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GoOrderPurchase.this,MainActivity.class);
                intent.putExtra("DIRECT",BACK_TASK);
                startActivity(intent);

                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        myActivityManager.popOneActivity(this);
        Intent intent=new Intent(GoOrderPurchase.this,MainActivity.class);
        intent.putExtra("DIRECT",BACK_TASK);
        startActivity(intent);
        super.onDestroy();
    }
}
