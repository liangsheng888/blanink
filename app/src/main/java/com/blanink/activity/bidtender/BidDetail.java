package com.blanink.activity.bidTender;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.BidDetailInfo;
import com.blanink.pojo.BidTender;
import com.blanink.pojo.TenderAndBid;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/***
 * 投标详情
 */
public class BidDetail extends AppCompatActivity {
    private TenderAndBid.Result.Row row = new TenderAndBid.Result.Row();
    private BidDetailInfo bidinfo = new BidDetailInfo();
    private TextView tv_company;
    private TextView tv_product_name;
    private TextView tv_single_price;
    private TextView tv_purchase_num;
    private TextView tv_first_pay;
    private TextView tv_useful_time;
    private TextView tv_note_content;
    private TextView tv_publish_date;
    private TextView bid_detail_iv_last;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private TextView tv_name;
    private TextView tv_company_name;
    private TextView tv_bid_date;
    private TextView tv_single_cost;
    private TextView tv_date_of_delivery;
    private TextView tv_area;
    private TextView tv_note_detail_content;
    private TextView tv_talk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_detail);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        receivedDataFromMyBidQueue();
        initView();
        initData();
    }

    private void receivedDataFromMyBidQueue() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        row = (TenderAndBid.Result.Row) bundle.getSerializable("BidDetailInfo");

    }

    private void initView() {
        bid_detail_iv_last = ((TextView) findViewById(R.id.bid_detail_iv_last));
        tv_company = ((TextView) findViewById(R.id.tv_company));
        tv_product_name = ((TextView) findViewById(R.id.tv_product_name));
        tv_single_price = ((TextView) findViewById(R.id.tv_single_price));
        tv_purchase_num = ((TextView) findViewById(R.id.tv_purchase_num));
        tv_first_pay = ((TextView) findViewById(R.id.tv_first_pay));
        tv_useful_time = ((TextView) findViewById(R.id.tv_useful_time));
        tv_note_content = ((TextView) findViewById(R.id.tv_note_content));
        tv_publish_date = ((TextView) findViewById(R.id.tv_publish_date));
        tv_name = ((TextView) findViewById(R.id.tv_name));
        tv_company_name = ((TextView) findViewById(R.id.tv_company_name));
        tv_bid_date = ((TextView) findViewById(R.id.tv_bid_date));
        tv_single_cost = ((TextView) findViewById(R.id.tv_single_cost));
        tv_date_of_delivery = ((TextView) findViewById(R.id.tv_date_of_delivery));
        tv_area = ((TextView) findViewById(R.id.tv_area));
        tv_note_detail_content = ((TextView) findViewById(R.id.tv_note_detail_content));
        tv_talk = ((TextView) findViewById(R.id.tv_talk));
    }

    private void initData() {
        //
        if (row != null) {
            tv_company.setText(row.inviteCompany.name);
            tv_product_name.setText(row.buyProductName);
            tv_single_price.setText(row.targetPrice);
            tv_purchase_num.setText(row.count + "");
            tv_first_pay.setText(row.downPayment + "%");
            tv_publish_date.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(row.inviteDate)));
            tv_useful_time.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(row.expireDate)));
            tv_note_detail_content.setText(row.remarks);
        }
        //返回
        bid_detail_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        loadDataFromServer();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    public void loadDataFromServer() {
        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/bidDetail");
        requestParams.addBodyParameter("userId", sp.getString("USER_ID", null));

        requestParams.addBodyParameter("id", row.id);

        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("BidDetail", "result:" + result.toString());
                Gson gson = new Gson();
                bidinfo = gson.fromJson(result, BidDetailInfo.class);
                Log.e("BidDetail", "bidinfo:" + bidinfo.toString());
                tv_name.setText(bidinfo.result.bidCompany.master);
                tv_company_name.setText(bidinfo.result.bidCompany.name);
                tv_bid_date.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(bidinfo.result.bidDate)));
                tv_single_cost.setText(bidinfo.result.bidPrice);
                String date = "";
                if (bidinfo.result.productionCycleUnit == 5) {
                    date = bidinfo.result.productionCycle + "年";
                }
                if (bidinfo.result.productionCycleUnit == 4) {
                    date = bidinfo.result.productionCycle + "个月";
                }
                if (bidinfo.result.productionCycleUnit == 3) {
                    date = bidinfo.result.productionCycle + "周";
                }
                if (bidinfo.result.productionCycleUnit == 2) {
                    date = bidinfo.result.productionCycle + "天";
                }
                if (bidinfo.result.productionCycleUnit == 1) {
                    date = bidinfo.result.productionCycle + "个小时";
                }
                tv_date_of_delivery.setText(date);
                tv_area.setText(bidinfo.result.bidCompany.address);
                tv_note_content.setText(bidinfo.result.remarks);

                tv_talk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(BidDetail.this, BidDetailChatHistory.class);
                        intent.putExtra("bid.id", bidinfo.result.id);
                        intent.putExtra("inviteBid.id", row.id);
                        intent.putExtra("createBy", row.createBy.id);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }


}
