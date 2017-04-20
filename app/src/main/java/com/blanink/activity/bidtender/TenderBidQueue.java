package com.blanink.activity.bidTender;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.TenderAndBid;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;
import com.blanink.view.NoScrollListview;

import java.util.ArrayList;
import java.util.List;

/***
 * 招标  投标列表
 */
public class TenderBidQueue extends AppCompatActivity {
    private MyActivityManager myActivityManager;
    private TextView bid_detail_iv_last;
    private TenderAndBid.Result.Row row = new TenderAndBid.Result.Row();
    private TextView tv_name;
    private TextView tv_bids_num;
    private TextView tv_bid_date;
    private TextView tv_single_cost;
    private TextView tv_purchase_num;
    private TextView tv_first_cost;
    private TextView tv_note_detail_content;
    private TextView tv_publish_time;
    private TextView btn_update;
    private TextView tv_total_price;
    private NoScrollListview lv_tender;
    private List<TenderAndBid.Result.Row.Bid> bidList = new ArrayList<>();
    private RelativeLayout rl_not_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_reply_detail);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        receivedDataFromTenderManage();
        initView();
        initData();
    }

    //接收  MyTender 界面的数据
    private void receivedDataFromTenderManage() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        row = (TenderAndBid.Result.Row) bundle.getSerializable("TenderBid");
        Log.e("TenderBidQueue", row.toString());
        bidList.addAll(row.bidList);
    }

    private void initView() {
        bid_detail_iv_last = ((TextView) findViewById(R.id.bid_detail_iv_last));//返回
        tv_name = ((TextView) findViewById(R.id.tv_name));//采购名称
        tv_bids_num = ((TextView) findViewById(R.id.tv_bids_num));//投标数
        tv_bid_date = ((TextView) findViewById(R.id.tv_bid_date));//有效时间
        tv_single_cost = ((TextView) findViewById(R.id.tv_single_cost));//单价
        tv_purchase_num = ((TextView) findViewById(R.id.tv_purchase_num));//数量
        tv_first_cost = ((TextView) findViewById(R.id.tv_first_cost));//预付定金
        tv_note_detail_content = ((TextView) findViewById(R.id.tv_note_detail_content));//备注
        tv_publish_time = ((TextView) findViewById(R.id.tv_publish_time));//发布时间
        btn_update = ((TextView) findViewById(R.id.btn_update));//编辑
        tv_total_price = ((TextView) findViewById(R.id.tv_total_price));//总价
        lv_tender = ((NoScrollListview) findViewById(R.id.lv_tender));//投标人列表
        rl_not_data = ((RelativeLayout) findViewById(R.id.rl_not_data));
    }

    private void initData() {
        //setData
        tv_name.setText(row.buyProductName);
        tv_bids_num.setText(row.bidList.size() + "");
        tv_bid_date.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(row.expireDate)));
        tv_single_cost.setText(row.targetPrice);
        tv_purchase_num.setText(row.count + "个");
        tv_note_detail_content.setText(row.remarks);
        tv_publish_time.setText(row.inviteDate);
        tv_total_price.setText(row.count*Double.parseDouble(row.targetPrice) + "元");
        tv_first_cost.setText(row.downPayment + "%");
        //附件
        uploadAttachment();
        //返回
        bid_detail_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //投标列表
        lv_tender.setAdapter(new BidQueueAdapter());

        lv_tender.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(TenderBidQueue.this,TenderBidAccord.class) ;
                Bundle bundle=new Bundle();
                bundle.putSerializable("BidCompany",bidList.get(position));
                intent.putExtra("downPayment",row.downPayment+"");
                intent.putExtra("count",row.count+"");
                intent.putExtra("inviteCompany.id",row.inviteCompany.id);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        //如果有投标，不能编辑
        if(row.bidList.size()>0){
            btn_update.setEnabled(false);
            btn_update.setBackgroundColor(getResources().getColor(R.color.colorBackGround));
        }
        else {
            rl_not_data.setVisibility(View.VISIBLE);
        }
        //编辑
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(TenderBidQueue.this,TenderModify.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("TenderDetail",row);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

    private void uploadAttachment() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    public class BidQueueAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return bidList.size();
        }

        @Override
        public Object getItem(int position) {
            return bidList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder=new ViewHolder();
                convertView = View.inflate(TenderBidQueue.this, R.layout.item_bid_list, null);
                viewHolder.tv_master = (TextView) convertView.findViewById(R.id.tv_master);
                viewHolder.tv_company_name = (TextView) convertView.findViewById(R.id.tv_company_name);
                viewHolder.tv_bid_date = (TextView) convertView.findViewById(R.id.tv_bid_date);
                viewHolder.tv_single_price = (TextView) convertView.findViewById(R.id.tv_single_price);
                viewHolder.tv_hand_date = (TextView) convertView.findViewById(R.id.tv_hand_date);
                viewHolder.tv_address = (TextView) convertView.findViewById(R.id.tv_address);
                convertView.setTag(viewHolder);
            } else {
                viewHolder =(ViewHolder) convertView.getTag();
            }
            TenderAndBid.Result.Row.Bid bid=bidList.get(position);
            viewHolder.tv_master.setText(bid.bidCompany.master);
            viewHolder.tv_company_name.setText(bid.bidCompany.name);
            viewHolder.tv_bid_date.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(bid.bidDate)));
            viewHolder.tv_single_price.setText(bid.bidPrice);
            String productionCycle="";
            if (bid.productionCycle.equals("1")){
                productionCycle="个小时";

            } if (bid.productionCycle.equals("2")){
                productionCycle="天";
            }
            if (bid.productionCycle.equals("3")){
                productionCycle="周";

            }
            if (bid.productionCycle.equals("4")){
                productionCycle="个月";
            }
            if (bid.productionCycle.equals("5")){
                productionCycle="年";
            }

            viewHolder.tv_hand_date.setText(bid.productionCycleUnit+productionCycle);//
            viewHolder.tv_address.setText(bid.bidCompany.address);
            return convertView;
        }
    }

    static class ViewHolder {
        TextView tv_master;
        TextView tv_company_name;
        TextView tv_bid_date;
        TextView tv_single_price;
        TextView tv_hand_date;
        TextView tv_address;
    }
}