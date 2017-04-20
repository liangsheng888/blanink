package com.blanink.activity.notify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.utils.MyActivityManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 其它通知详情
 */
public class OtherNotifyDetail extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.customer_apply_iv_last)
    TextView customerApplyIvLast;
    @BindView(R.id.last_family_manage_customer_apply_rl)
    RelativeLayout lastFamilyManageCustomerApplyRl;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_send)
    TextView tvSend;
    @BindView(R.id.send)
    TextView send;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.activity_last_family_manage_customer_supplier_invite)
    RelativeLayout activityLastFamilyManageCustomerSupplierInvite;
    @BindView(R.id.tv_receive)
    TextView tvReceive;
    @BindView(R.id.receive)
    TextView receive;
    private MyActivityManager myActivityManager;
    private String sender;
    private String time;
    private String company;
    private String content;
    private String id;
    private String title1;
    private String receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_notify_detail);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        ButterKnife.bind(this);
        receiveData();
        initData();
    }

    private void initData() {
        tvContent.setText(content);
        tvSend.setText(sender);
        tvTitle.setText(title1);
        tvTime.setText(time);
        receive.setText(receiver);
    }

    private void receiveData() {
        Intent intent = getIntent();
        content = intent.getStringExtra("content");
        id = intent.getStringExtra("referrenceObjectId");
        title1 = intent.getStringExtra("title");
        sender = intent.getStringExtra("sender");
        time = intent.getStringExtra("time");
        company = intent.getStringExtra("company");
        receiver = intent.getStringExtra("receiver");
        if(receiver==null||receiver==""){
            tvReceive.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.customer_apply_iv_last)
    public void onClick() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
