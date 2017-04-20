package com.blanink.activity.bidTender;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

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
 * 我 发布的招标 招标管理
 */
public class MyTender extends AppCompatActivity {

    private TextView tender_manager_iv_last;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private RefreshListView lv_tender;
    private LinearLayout ll_load;
    private RelativeLayout rl_load_fail;
    private RelativeLayout rl_load;
    private RelativeLayout rl_not_data;
    private Spinner sp_sort;
    private Spinner sp_expire;
    private int pageNo = 1;
    private List<TenderAndBid.Result.Row> rowList = new ArrayList<>();
    private boolean isHasData = true;
    private MyAdapter myAdapter;
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

    private String sort = "1";
    private String expire = "";
    private SparseArray<View> viewArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_manage);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);

        initView();
        initData();
    }


    private void initView() {
        tender_manager_iv_last = ((TextView) findViewById(R.id.tender_manager_iv_last));//返回
        lv_tender = ((RefreshListView) findViewById(R.id.lv_tender));
        ll_load = ((LinearLayout) findViewById(R.id.ll_load));
        rl_load_fail = ((RelativeLayout) findViewById(R.id.rl_load_fail));
        rl_load = ((RelativeLayout) findViewById(R.id.rl_load));
        rl_not_data = ((RelativeLayout) findViewById(R.id.rl_not_data));
        sp_sort = ((Spinner) findViewById(R.id.sp_sort));
        sp_expire = ((Spinner) findViewById(R.id.sp_expire));

    }

    private void initData() {
        sort(sort,expire);
        //重新加载
        rl_load_fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl_load_fail.setVisibility(View.GONE);
                ll_load.setVisibility(View.VISIBLE);

                    sort(sort,expire);

            }
        });
        tender_manager_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回
                finish();
            }
        });

        //
        lv_tender.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onPullRefresh() {
                sort(sort,expire);
            }

            @Override
            public void onLoadingMore() {
                pageNo++;
                sort(sort,expire);
            }
        });
        //详情
        lv_tender.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position<rowList.size()+1) {
                    Intent intent = new Intent(MyTender.this, TenderBidQueue.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("TenderBid", rowList.get(position - 1));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        sp_sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("MyTender","sort position:"+position);
                pageNo = 1;

                switch (position) {
                    case 0:
                        break;
                    case 1:
                        rowList.clear();
                        rl_load.setVisibility(View.VISIBLE);
                        ll_load.setVisibility(View.VISIBLE);
                        sort = "1";
                        sort(sort,expire);
                        break;
                    case 2:
                        rowList.clear();
                        rl_load.setVisibility(View.VISIBLE);
                        ll_load.setVisibility(View.VISIBLE);
                        sort = "2";
                        sort(sort,expire);
                        break;
                    case 3:
                        rowList.clear();
                        rl_load.setVisibility(View.VISIBLE);
                        ll_load.setVisibility(View.VISIBLE);
                        sort = "3";
                        sort(sort,expire);
                        break;
                    case 4:
                        rowList.clear();
                        rl_load.setVisibility(View.VISIBLE);
                        ll_load.setVisibility(View.VISIBLE);
                        sort = "4";
                        sort(sort,expire);
                        break;

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp_expire.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("MyTender","expire position:"+position);
                pageNo = 1;
                switch (position) {
                    case 0:
                        expire="";
                        break;
                    case 1:
                        rowList.clear();
                        rl_load.setVisibility(View.VISIBLE);
                        ll_load.setVisibility(View.VISIBLE);
                        expire = "1";
                        sort(sort,expire);
                        break;
                    case 2:
                        rowList.clear();
                        rl_load.setVisibility(View.VISIBLE);
                        ll_load.setVisibility(View.VISIBLE);
                        expire = "2";
                        sort(sort,expire);
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("DIRECT",4);
        startActivity(intent);
    }
    private void sort(final String sort,String expire) {
        String path = NetUrlUtils.NET_URL + "inviteBid/myInviteBidSort";
        RequestParams rp = new RequestParams(path);
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("sort", sort);
        rp.addBodyParameter("expire", expire);
        Log.e("MyTender", " userId" + sort +sp.getString("USER_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                rl_load.setVisibility(View.GONE);
                Log.e("MyTender", " sort result+++++" + sort + "----" + result);
                Gson gson = new Gson();
                TenderAndBid tender = gson.fromJson(result, TenderAndBid.class);
                Log.e("MyTender", "sort tender+++++" + tender.toString());
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
            viewArray = new SparseArray<>();
            ViewHolder viewHolder = null;
            if (viewArray.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(MyTender.this, R.layout.item_my_publish_tender, null);
                viewHolder.bid_num = (TextView) convertView.findViewById(R.id.tv_bid_num);
                viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                viewHolder.tv_purchase_num = (TextView) convertView.findViewById(R.id.tv_purchase_num);
                viewHolder.tv_single_price = (TextView) convertView.findViewById(R.id.tv_single_price);
                viewHolder.tv_useful_time = (TextView) convertView.findViewById(R.id.tv_end_date);
                viewHolder.tv_single_price = (TextView) convertView.findViewById(R.id.tv_single_price);
                viewHolder.tv_total = (TextView) convertView.findViewById(R.id.tv_total);
                viewHolder.tv_first_pay = (TextView) convertView.findViewById(R.id.tv_first_pay);
                viewHolder.iv_out_of_date = (ImageView) convertView.findViewById(R.id.iv_out_of_date);
                convertView.setTag(viewHolder);
                viewArray.put(position, convertView);
            } else {
                convertView = viewArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.bid_num.setText(rowList.get(position).bidList.size() + "");
            viewHolder.tv_title.setText(rowList.get(position).title);
            viewHolder.tv_purchase_num.setText(rowList.get(position).count + "");
            Integer count = rowList.get(position).count;
            viewHolder.tv_single_price.setText(rowList.get(position).targetPrice);
            viewHolder.tv_first_pay.setText(rowList.get(position).downPayment + "%");
            viewHolder.tv_useful_time.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(rowList.get(position).expireDate)));
            viewHolder.tv_total.setText(count * Double.parseDouble(rowList.get(position).targetPrice) + "元");
            //设置失效显示
            if (ExampleUtil.compare_date(rowList.get(position).expireDate, ExampleUtil.dateToString(new Date(System.currentTimeMillis()))) < 0) {
                viewHolder.iv_out_of_date.setVisibility(View.VISIBLE);
            }
            return convertView;
        }
    }

    static class ViewHolder {
        public TextView bid_num;
        public TextView tv_title;
        public TextView tv_purchase_num;
        public TextView tv_single_price;
        public TextView tv_useful_time;
        public TextView tv_total;
        public TextView tv_first_pay;
        public ImageView iv_out_of_date;
    }

}
