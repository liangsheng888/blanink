package com.blanink.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.bean.TenderAndBid;
import com.blanink.utils.MyActivityManager;

/***
 * 招标  确定合作
 */
public class TenderBidAccord extends AppCompatActivity {
    private MyActivityManager myActivityManager;
    private TenderAndBid.Result.Row.Bid bidCompany;
    private TextView tv_name;
    private TextView tv_company_name;
    private TextView tv_bid_date;
    private TextView tv_single_cost;
    private TextView tv_purchase_num;
    private TextView tv_first_cost;
    private TextView tv_total;
    private TextView tv_note_detail_content;
    private TextView btn_become_partner;
    private String downPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_bid_detail);
        receivedData();
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initView();
        initData();
    }

    private void initView() {
        tv_name = ((TextView) findViewById(R.id.tv_name));//负责人
        tv_company_name = ((TextView) findViewById(R.id.tv_company_name));//公司名称
        tv_bid_date = ((TextView) findViewById(R.id.tv_bid_date));//投标日期
        tv_single_cost = ((TextView) findViewById(R.id.tv_single_cost));//单件
        tv_purchase_num = ((TextView) findViewById(R.id.tv_purchase_num));//采购数量
        tv_first_cost = ((TextView) findViewById(R.id.tv_first_cost));//预付定金
        tv_total = ((TextView) findViewById(R.id.tv_total));//总价
        tv_note_detail_content = ((TextView) findViewById(R.id.tv_note_detail_content));//备注
        btn_become_partner = ((TextView) findViewById(R.id.btn_become_partner));//合作
    }
    private void initData(){
        //set data
        tv_name.setText(bidCompany.bidCompany.master);
        tv_company_name.setText(bidCompany.bidCompany.name);
        tv_bid_date.setText(bidCompany.bidDate);
        tv_purchase_num.setText(bidCompany.inviteBid.count+"");
        tv_total.setText((Integer.parseInt(bidCompany.bidPrice)*bidCompany.inviteBid.count)+"元");
        tv_note_detail_content.setText(bidCompany.remarks);
        tv_first_cost.setText(downPayment+"%");

    }

    private void receivedData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        bidCompany = (TenderAndBid.Result.Row.Bid) bundle.getSerializable("BidCompany");
        downPayment = intent.getStringExtra("downPayment");
        Log.e("TenderBidAccord", bidCompany.toString());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
