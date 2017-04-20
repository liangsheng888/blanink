package com.blanink.activity.bidTender;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.activity.MainActivity;
import com.blanink.pojo.TenderAndBid;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.RefreshListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * 我的投标
 */
public class MyBidQueue extends AppCompatActivity {
    private SharedPreferences sp;
    private TextView bid_iv_last;
    private RefreshListView lv_my_bid;
    private MyBidAdapter adapter;
    private LinearLayout ll_load;
    private RelativeLayout rl_load_fail;
    private RelativeLayout rl_load;
    private RelativeLayout rl_not_data;
    private List<TenderAndBid.Result.Row> myBidList = new ArrayList<>();
    private boolean isHasData = true;
    private int pageNo = 1;
    private SparseArray<View> viewSpare;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (adapter != null) {
                lv_my_bid.completeRefresh(isHasData);
                adapter.notifyDataSetChanged();
            } else {
                rl_not_data.setVisibility(View.VISIBLE);
            }
        }
    };
    private MyActivityManager myActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bid_queue);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initView();
        initData();
    }


    private void initView() {
        bid_iv_last = ((TextView) findViewById(R.id.bid_iv_last));
        lv_my_bid = ((RefreshListView) findViewById(R.id.lv_my_bid));
        ll_load = ((LinearLayout) findViewById(R.id.ll_load));
        rl_load_fail = ((RelativeLayout) findViewById(R.id.rl_load_fail));
        rl_load = ((RelativeLayout) findViewById(R.id.rl_load));
        rl_not_data = ((RelativeLayout) findViewById(R.id.rl_not_data));
    }


    private void initData() {
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        loadDataFromServer();
        //返回
        bid_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //重新加载
        rl_load_fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl_load_fail.setVisibility(View.GONE);
                ll_load.setVisibility(View.VISIBLE);
                loadDataFromServer();
            }
        });
        //刷新，加载更多
        lv_my_bid.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
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
        //点击跳转到详情
        lv_my_bid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < myBidList.size() + 1) {
                    Intent intent = new Intent(MyBidQueue.this, BidDetail.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("BidDetailInfo", myBidList.get(position - 1));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
        //去投标
        rl_not_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyBidQueue.this, BidAccordWithTender.class);
                intent.putExtra("VALUE", 1);
                startActivity(intent);
            }
        });
    }

    //加载数据
    private void loadDataFromServer() {
        if (!ExampleUtil.isConnected(MyBidQueue.this)) {
            Toast.makeText(this, "检查你的网络", Toast.LENGTH_SHORT).show();

        } else {
            RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/bidlist");
            rp.addBodyParameter("userId", sp.getString("USER_ID", null));
            rp.addBodyParameter("pageNo", pageNo + "");
            x.http().post(rp, new Callback.CacheCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    ll_load.setVisibility(View.GONE);
                    rl_load.setVisibility(View.GONE);
                    Log.e("MyBidQueue", "result:" + result);
                    Gson gson = new Gson();
                    TenderAndBid tb = gson.fromJson(result, TenderAndBid.class);
                    Log.e("MyBidQueue", "tb:" + tb.toString());
                    if (tb.getResult().total <= myBidList.size()) {
                        isHasData = false;
                    } else {
                        myBidList.addAll(tb.getResult().rows);
                        if (adapter == null) {
                            adapter = new MyBidAdapter();
                            lv_my_bid.setAdapter(adapter);
                        } else {
                            adapter.notifyDataSetChanged();
                        }
                    }
                    handler.sendEmptyMessage(0);

                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {
                    ll_load.setVisibility(View.GONE);
                    rl_load_fail.setVisibility(View.VISIBLE);
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

    class MyBidAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return myBidList.size();
        }

        @Override
        public Object getItem(int position) {
            return myBidList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            viewSpare = new SparseArray<>();
            if (viewSpare.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(MyBidQueue.this, R.layout.item_my_bid, null);
                viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
                viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                viewHolder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);
                viewHolder.tv_single_price = (TextView) convertView.findViewById(R.id.tv_single_price);
                viewHolder.tv_purchase_num = (TextView) convertView.findViewById(R.id.tv_purchase_num);
                viewHolder.tv_first_pay = (TextView) convertView.findViewById(R.id.tv_first_pay);
                viewHolder.tv_publish_person = (TextView) convertView.findViewById(R.id.tv_publish_person);
                convertView.setTag(viewHolder);
                viewSpare.put(position, convertView);
            } else {
                convertView = viewSpare.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            TenderAndBid.Result.Row row = myBidList.get(position);
            viewHolder.tv_name.setText(row.inviteCompany.name + "");
            viewHolder.tv_title.setText(row.title);
            viewHolder.tv_single_price.setText(row.targetPrice);
            viewHolder.tv_publish_person.setText(row.inviteCompany.master);
            viewHolder.tv_first_pay.setText(row.downPayment + "%");
            viewHolder.tv_purchase_num.setText(row.count + "");
            if (row.bidStatus.equals("0")) {
                viewHolder.tv_state.setText("沟通中");
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorTheme));
            }
            if (row.bidStatus.equals("1")) {
                viewHolder.tv_state.setText("已通过");
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorBlue));
            }
            int index = ExampleUtil.compare_date(row.expireDate, ExampleUtil.dateToString(new Date(System.currentTimeMillis())));
            if (index == -1) {
                viewHolder.tv_state.setText("已失效");
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorRed));
            }

            return convertView;
        }
    }

    static class ViewHolder {
        TextView tv_name;//
        TextView tv_title;
        TextView tv_state;
        TextView tv_single_price;
        TextView tv_purchase_num;
        TextView tv_first_pay;
        TextView tv_publish_person;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
        Intent intent = new Intent(MyBidQueue.this, MainActivity.class);
        intent.putExtra("DIRECT", 4);
        startActivity(intent);

    }
}
