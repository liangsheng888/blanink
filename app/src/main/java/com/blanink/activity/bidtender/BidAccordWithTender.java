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
import android.widget.EditText;
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
 * 投标 符合招标信息
 */
public class BidAccordWithTender extends AppCompatActivity {

    private static final int BACK_TASK = 0;
    private MyActivityManager myActivityManager;
    private TextView bid_accord_with_tender_iv_last;
    private LinearLayout ll_load;
    private RelativeLayout rl_load_fail;
    private RelativeLayout rl_load;
    private RefreshListView lv_tender_info_queue;
    private RelativeLayout rl_not_data;
    private Spinner sp_sort;
    private Spinner sp_expire;
    private MyAdapter myAdapter;
    private SharedPreferences sp;
    private boolean isHasData = true;
    private List<TenderAndBid.Result.Row> rowList = new ArrayList<>();
    private int value;
    private EditText et_seek;
    private TextView tv_seek;
    private String sort = "1";
    private String expire = "";
    private int pageNo = 1;
    private SparseArray<View> viewSparseArray;
    private Boolean isExipre = false;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv_tender_info_queue.completeRefresh(isHasData);
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
        Intent intent = getIntent();
        value = intent.getIntExtra("VALUE", 0);
        setContentView(R.layout.activity_bid_accord_with_tender);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initView();
        initData();
    }

    private void initView() {
        bid_accord_with_tender_iv_last = ((TextView) findViewById(R.id.bid_accord_with_tender_iv_last));
        ll_load = ((LinearLayout) findViewById(R.id.ll_load));
        rl_load_fail = ((RelativeLayout) findViewById(R.id.rl_load_fail));
        rl_load = ((RelativeLayout) findViewById(R.id.rl_load));
        lv_tender_info_queue = ((RefreshListView) findViewById(R.id.lv_tender_info_queue));
        rl_not_data = ((RelativeLayout) findViewById(R.id.rl_not_data));
        et_seek = ((EditText) findViewById(R.id.et_seek));
        tv_seek = ((TextView) findViewById(R.id.tv_seek));
        sp_sort = ((Spinner) findViewById(R.id.sp_sort));
        sp_expire = ((Spinner) findViewById(R.id.sp_expire));
    }

    private void initData() {
        sort(sort, expire);
        //重新加载
        rl_load_fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl_load_fail.setVisibility(View.GONE);
                ll_load.setVisibility(View.VISIBLE);
                sort(sort, expire);

            }
        });
        bid_accord_with_tender_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //刷新 加载更多
        lv_tender_info_queue.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onPullRefresh() {
                sortRefresh(sort, expire);

            }

            @Override
            public void onLoadingMore() {
                pageNo++;
                sort(sort, expire);

            }
        });
        //招标详情
        lv_tender_info_queue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 1 && position < rowList.size()+1) {
                    TenderAndBid.Result.Row row = rowList.get(position - 1);
                    Intent intent = new Intent(BidAccordWithTender.this, TenderDetail.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("TenderDetail", row);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });

        //搜索
        et_seek.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Intent intent = new Intent(BidAccordWithTender.this, BidSeekTender.class);
                    startActivity(intent);
                }
            }
        });
        tv_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BidAccordWithTender.this, BidSeekTender.class);
                startActivity(intent);
            }
        });
        et_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_seek.setFocusable(true);
            }
        });
        sp_sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pageNo = 1;
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        rowList.clear();
                        rl_load.setVisibility(View.VISIBLE);
                        ll_load.setVisibility(View.VISIBLE);
                        sort = "1";
                        sort(sort, expire);
                        break;
                    case 2:
                        rowList.clear();
                        rl_load.setVisibility(View.VISIBLE);
                        ll_load.setVisibility(View.VISIBLE);
                        sort = "2";
                        sort(sort, expire);
                        break;
                    case 3:
                        rowList.clear();
                        rl_load.setVisibility(View.VISIBLE);
                        ll_load.setVisibility(View.VISIBLE);
                        sort = "3";
                        sort(sort, expire);
                        break;
                    case 4:
                        rowList.clear();
                        rl_load.setVisibility(View.VISIBLE);
                        ll_load.setVisibility(View.VISIBLE);
                        sort = "4";
                        sort(sort, expire);
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
                pageNo = 1;
                switch (position) {
                    case 0:
                        expire = "";
                        break;
                    case 1:
                        rowList.clear();
                        rl_load.setVisibility(View.VISIBLE);
                        ll_load.setVisibility(View.VISIBLE);
                        expire = "1";
                        sort(sort, expire);
                        break;
                    case 2:
                        rowList.clear();
                        rl_load.setVisibility(View.VISIBLE);
                        ll_load.setVisibility(View.VISIBLE);
                        expire = "2";
                        sort(sort, expire);
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        et_seek.clearFocus();//清除焦点
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
        if (value == 0) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("DIRECT", BACK_TASK);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("DIRECT", 4);
            startActivity(intent);
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
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
            viewSparseArray = new SparseArray<>();
            ViewHolder viewHolder = null;
            if (viewSparseArray.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(BidAccordWithTender.this, R.layout.item_my_tender, null);
                viewHolder.tv_company = (TextView) convertView.findViewById(R.id.tv_company);
                viewHolder.tv_tag = (TextView) convertView.findViewById(R.id.tv_tag);
                viewHolder.tv_purchase_num = (TextView) convertView.findViewById(R.id.tv_tender_purchase_num);
                viewHolder.tv_single_price = (TextView) convertView.findViewById(R.id.tv_single_price);
                viewHolder.tv_useful_time = (TextView) convertView.findViewById(R.id.tv_useful_time);
                viewHolder.tv_single_price = (TextView) convertView.findViewById(R.id.tv_single_price);
                viewHolder.tv_note_content = (TextView) convertView.findViewById(R.id.tv_note_content);
                viewHolder.tv_attachment = (TextView) convertView.findViewById(R.id.tv_attachment);
                viewHolder.tv_first_pay = (TextView) convertView.findViewById(R.id.tv_first_pay);
                viewHolder.tv_publish = (TextView) convertView.findViewById(R.id.tv_publish);
                viewHolder.iv_out_of_date = (ImageView) convertView.findViewById(R.id.iv_out_of_date);
                viewSparseArray.put(position, convertView);
                convertView.setTag(viewHolder);
            } else {
                convertView = viewSparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.tv_company.setText(rowList.get(position).inviteCompany.name);
            viewHolder.tv_tag.setText(rowList.get(position).buyProductName);
            viewHolder.tv_purchase_num.setText(rowList.get(position).count + "");
            viewHolder.tv_single_price.setText(rowList.get(position).targetPrice);
            viewHolder.tv_first_pay.setText(rowList.get(position).downPayment + "%");
            viewHolder.tv_note_content.setText(rowList.get(position).remarks);
            viewHolder.tv_useful_time.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(rowList.get(position).expireDate)));
            viewHolder.tv_publish.setText(rowList.get(position).createDate);
            //设置失效显示
            if (ExampleUtil.compare_date(rowList.get(position).expireDate, ExampleUtil.dateToString(new Date(System.currentTimeMillis()))) < 0) {
                viewHolder.iv_out_of_date.setVisibility(View.VISIBLE);
            }
            return convertView;
        }
    }

    static class ViewHolder {
        public TextView tv_company;
        public TextView tv_tag;
        public TextView tv_purchase_num;
        public TextView tv_single_price;
        public TextView tv_useful_time;
        public TextView tv_note_content;
        public TextView tv_attachment;
        public TextView tv_first_pay;
        public TextView tv_publish;
        public ImageView iv_out_of_date;
    }

    //排序
    private void sort(final String sort, String expire) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/inviteBidSort");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("sort", sort);
        rp.addBodyParameter("expire", expire);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                rl_load.setVisibility(View.GONE);
                Log.e("BidAccordWithTender", " sort result+++++" + sort + "----" + result);
                Gson gson = new Gson();
                TenderAndBid tender = gson.fromJson(result, TenderAndBid.class);
                Log.e("BidAccordWithTender", "sort tender+++++" + tender.toString());
                if (tender.getResult().total <= rowList.size()) {
                    isHasData = false;
                } else {
                    rowList.addAll(tender.getResult().rows);
                    if (myAdapter == null) {
                        myAdapter = new MyAdapter();
                        lv_tender_info_queue.setAdapter(myAdapter);
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
    private void sortRefresh(final String sort, String expire) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/inviteBidSort");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("sort", sort);
        rp.addBodyParameter("expire", expire);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                rl_load.setVisibility(View.GONE);
                Log.e("BidAccordWithTender", " sort result+++++" + sort + "----" + result);
                Gson gson = new Gson();
                TenderAndBid tender = gson.fromJson(result, TenderAndBid.class);
                Log.e("BidAccordWithTender", "sort tender+++++" + tender.toString());
                if (tender.getResult().total <= rowList.size()) {
                    isHasData = false;
                } else {
                    rowList.addAll(0,tender.getResult().rows);
                    if (myAdapter == null) {
                        lv_tender_info_queue.setAdapter(myAdapter);
                    } else {
                        myAdapter.notifyDataSetChanged();
                    }
                    myAdapter = new MyAdapter();
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

}
