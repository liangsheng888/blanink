package com.blanink.activity.bidTender;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.TenderAndBid;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;

import java.util.Date;

/***
 * 符合招标列表   招标详情
 */
public class TenderDetail extends AppCompatActivity {
    private TenderAndBid.Result.Row row = new TenderAndBid.Result.Row();
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private TextView back;
    private TextView tv_product_name;
    private TextView tv_bids_num;
    private TextView tv_total_price;
    private TextView tv_company;
    private TextView tv_url;
    private TextView tv_single_price;
    private TextView tv_purchase_num;
    private TextView tv_first_pay;
    private TextView tv_end_date;
    private TextView tv_note_content;
    private TextView tv_attachment;
    private TextView tv_publish_date;
    private Button bt_bid;
    private Button btn_chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_detail);
        myActivityManager = MyActivityManager.getInstance();
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager.pushOneActivity(this);
        receivedIntentInfo();
        initView();
        initData();
    }

    private void receivedIntentInfo() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        row = (TenderAndBid.Result.Row) bundle.getSerializable("TenderDetail");
        Log.e("TenderDetail", row.toString());
    }

    private void initView() {
        back = ((TextView) findViewById(R.id.bid_detail_iv_last));
        tv_product_name = ((TextView) findViewById(R.id.tv_product_name));
        tv_bids_num = ((TextView) findViewById(R.id.tv_bids_num));
        tv_total_price = ((TextView) findViewById(R.id.tv_total_price));
        tv_company = ((TextView) findViewById(R.id.tv_company));
        tv_url = ((TextView) findViewById(R.id.tv_url));
        tv_single_price = ((TextView) findViewById(R.id.tv_single_price));
        tv_purchase_num = ((TextView) findViewById(R.id.tv_purchase_num));
        tv_first_pay = ((TextView) findViewById(R.id.tv_first_pay));
        tv_end_date = ((TextView) findViewById(R.id.tv_end_date));
        tv_note_content = ((TextView) findViewById(R.id.tv_note_content));
        tv_attachment = ((TextView) findViewById(R.id.tv_attachment));
        tv_publish_date = ((TextView) findViewById(R.id.tv_publish_date));
        bt_bid = ((Button) findViewById(R.id.bt_bid));

    }

    private void initData() {

        //set data
        tv_product_name.setText(row.buyProductName);
        tv_bids_num.setText(row.bidList.size() + "");
        tv_total_price.setText((Double.parseDouble(row.targetPrice)*row.count)+"");
        tv_company.setText(row.inviteCompany.name);
        tv_single_price.setText(row.targetPrice);//单价
        tv_purchase_num.setText(row.count + "");
        tv_note_content.setText(row.remarks);
        tv_first_pay.setText(row.downPayment + "%");
        tv_publish_date.setText(row.inviteDate);
        tv_end_date.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(row.expireDate)));

        //附件浏览
        tv_attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //返回
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //我要投标
        Log.e("TenderDetail", "TenderId:" + row.inviteCompany.id);
        Log.e("TenderDetail", "BidId:" + sp.getString("COMPANY_ID", null));
        if (row.inviteCompany.id.equals(sp.getString("COMPANY_ID", null))) {
            bt_bid.setText("该招标信息是你公司发布的，不能投标");
            bt_bid.setEnabled(false);
            bt_bid.setBackgroundColor(Color.GRAY);
        }
        //如果已失效 ，不能投标
        if (ExampleUtil.compare_date(row.expireDate,ExampleUtil.dateToString(new Date(System.currentTimeMillis())))<0){
            bt_bid.setText("本次招标已失效，你不能投标！");
            bt_bid.setEnabled(false);
            bt_bid.setBackgroundColor(Color.GRAY);
        }
        //如果投标公司的id 在bidList 中 表明 已投标 不能再次投标
        if (row.bidList.size() > 0) {
            for (int i = 0; i < row.bidList.size(); i++) {
                if (sp.getString("COMPANY_ID", null).equals(row.bidList.get(i).bidCompany.id)) {
                    bt_bid.setText("你已经投过标了，不能再次投标");
                    bt_bid.setEnabled(false);
                    bt_bid.setBackgroundColor(Color.GRAY);
                }
            }
        }
        bt_bid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TenderDetail.this, BidApplication.class);
                intent.putExtra("userId", sp.getString("USER_ID", null));
                intent.putExtra("inviteBid.id", row.id);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
