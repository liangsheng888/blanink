package com.blanink.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.bean.TenderAndBid;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;

import java.text.DecimalFormat;

/***
 * 符合招标列表   招标详情
 */
public class TenderDetail extends AppCompatActivity {
    private TenderAndBid.Result.Row row=new TenderAndBid.Result.Row();
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private ImageView back;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_detail);
        myActivityManager = MyActivityManager.getInstance();
        sp=getSharedPreferences("DATA",MODE_PRIVATE);
        myActivityManager.pushOneActivity(this);
        receivedIntentInfo();
        initView();
        initData();
    }

    private void receivedIntentInfo() {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        row=(TenderAndBid.Result.Row) bundle.getSerializable("TenderDetail");
        Log.e("TenderDetail",row.toString());
    }

    private void initView() {
        back = ((ImageView) findViewById(R.id.bid_detail_iv_last));
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
        tv_bids_num.setText(row.bidList.size()+"");
        tv_total_price.setText(row.targetPrice);
        tv_company.setText(row.inviteCompany.name);
        tv_single_price.setText(new DecimalFormat("0.00").format(Integer.parseInt(row.targetPrice)/row.count*1.0));//单价
        tv_purchase_num.setText(row.count+"");
        tv_note_content.setText(row.remarks);
        tv_first_pay.setText(row.downPayment+"%");
        tv_publish_date.setText(row.inviteDate);
        tv_end_date.setText(row.expireDate);
        //附件
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
        Log.e("TenderDetail","TenderId:"+row.inviteCompany.id);
        Log.e("TenderDetail","BidId:"+sp.getString("COMPANY_ID",null));
        if(row.inviteCompany.id.equals(sp.getString("COMPANY_ID",null))){
            bt_bid.setText("你已经投过标了");
            bt_bid.setEnabled(false);
            bt_bid.setBackgroundColor(Color.GRAY);
        }
        bt_bid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(TenderDetail.this,BidApplication.class);
                intent.putExtra("userId",sp.getString("USER_ID",null));
                intent.putExtra("inviteBid.id",row.id);
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
