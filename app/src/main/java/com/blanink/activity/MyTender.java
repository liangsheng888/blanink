package com.blanink.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.bean.TenderAndBid;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.RefreshListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/***
 * 我 发布的招标 招标管理
 */
public class MyTender extends AppCompatActivity {

    private ImageView tender_manager_iv_last;
    private TextView tv_publish;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private RefreshListView lv_tender;
    private LinearLayout ll_load;
    private RelativeLayout rl_load_fail;
    private RelativeLayout rl_load;
    private int pageNo = 1;
    private List<TenderAndBid.Result.Row> rowList = new ArrayList<>();
    private boolean isHasData = true;
    private MyAdapter myAdapter;
    private RelativeLayout rl_not_data;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv_tender.completeRefresh(isHasData);
            if (myAdapter != null) {
                myAdapter.notifyDataSetChanged();
            } else {
                rl_not_data.setVisibility(View.VISIBLE);
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_manage);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        loadDataFromServer();
        initView();
        initData();
    }


    private void initView() {
        tender_manager_iv_last = ((ImageView) findViewById(R.id.tender_manager_iv_last));//返回
        tv_publish = ((TextView) findViewById(R.id.tv_publish));//发布招标
        lv_tender = ((RefreshListView) findViewById(R.id.lv_tender));
        ll_load = ((LinearLayout) findViewById(R.id.ll_load));
        rl_load_fail = ((RelativeLayout) findViewById(R.id.rl_load_fail));
        rl_load = ((RelativeLayout) findViewById(R.id.rl_load));
        rl_not_data = ((RelativeLayout) findViewById(R.id.rl_not_data));
    }

    private void initData() {
        //重新加载
        rl_load_fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl_load_fail.setVisibility(View.GONE);
                ll_load.setVisibility(View.VISIBLE);
                loadDataFromServer();
            }
        });
        tender_manager_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回
                finish();
            }
        });

        tv_publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyTender.this, TenderPublish.class);
                startActivity(intent);
            }
        });
        //
        lv_tender.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onPullRefresh() {
                loadDataFromServer();
            }

            @Override
            public void onLoadingMore() {
                pageNo++;
                loadDataFromServer();

            }
        });
        //详情
        lv_tender.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MyTender.this, TenderBidQueue.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("TenderBid", rowList.get(position - 1));
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("DIRECT", 0);
        startActivity(intent);
    }

    public void loadDataFromServer() {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/list");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                ll_load.setVisibility(View.GONE);
                rl_load.setVisibility(View.GONE);
                Log.e("MyTender", "result+++++" + result);
                Gson gson = new Gson();
                TenderAndBid tender = gson.fromJson(result, TenderAndBid.class);
                Log.e("MyTender", "tender+++++" + tender.toString());

                if (tender.getResult().total <= rowList.size()) {
                    isHasData = false;
                } else {
                    rowList.addAll(tender.getResult().rows);
                    if (myAdapter == null) {
                        myAdapter = new MyAdapter();
                        lv_tender.setAdapter(myAdapter);
                    } else {
                        myAdapter.notifyDataSetChanged();
                    }
                }
                handler.sendEmptyMessage(0);//发送消息通知更新界面

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ll_load.setVisibility(View.GONE);
                rl_load_fail.setVisibility(View.VISIBLE);
                pageNo--;
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

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return rowList.size();
        }

        @Override
        public Object getItem(int position) {
            return rowList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(MyTender.this, R.layout.item_my_publish_tender, null);
                viewHolder.bid_num = (TextView) convertView.findViewById(R.id.tv_bid_num);
                viewHolder.tv_product = (TextView) convertView.findViewById(R.id.tv_product);
                viewHolder.tv_purchase_num = (TextView) convertView.findViewById(R.id.tv_purchase_num);
                viewHolder.tv_single_price = (TextView) convertView.findViewById(R.id.tv_single_price);
                viewHolder.tv_useful_time = (TextView) convertView.findViewById(R.id.tv_end_date);
                viewHolder.tv_single_price = (TextView) convertView.findViewById(R.id.tv_single_price);
                viewHolder.tv_total = (TextView) convertView.findViewById(R.id.tv_total);
                viewHolder.tv_first_pay = (TextView) convertView.findViewById(R.id.tv_first_pay);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.bid_num.setText(rowList.get(position).bidList.size() + "");
            viewHolder.tv_product.setText(rowList.get(position).buyProductName);
            viewHolder.tv_purchase_num.setText(rowList.get(position).count + "");
            int total = Integer.parseInt(rowList.get(position).targetPrice);
            int count = rowList.get(position).count;
            DecimalFormat df = new DecimalFormat("0.00");
            viewHolder.tv_single_price.setText(df.format(total / count * 1.0) + "");
            viewHolder.tv_first_pay.setText(rowList.get(position).downPayment + "%");
            viewHolder.tv_useful_time.setText(rowList.get(position).expireDate);
            viewHolder.tv_total.setText(rowList.get(position).targetPrice + "元");
            return convertView;
        }
    }

    static class ViewHolder {
        public TextView bid_num;
        public TextView tv_product;
        public TextView tv_purchase_num;
        public TextView tv_single_price;
        public TextView tv_useful_time;
        public TextView tv_total;
        public TextView tv_first_pay;
    }
}
