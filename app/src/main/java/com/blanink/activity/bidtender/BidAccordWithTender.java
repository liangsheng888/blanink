package com.blanink.activity.bidtender;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
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
import com.blanink.utils.CommonUtil;
import com.blanink.utils.DateUtils;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.UpLoadListView;
import com.google.gson.Gson;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 投标 符合招标信息
 */
public class BidAccordWithTender extends AppCompatActivity {

    private static final int BACK_TASK = 0;
    @BindView(R.id.bid_accord_with_tender_iv_last)
    TextView bidAccordWithTenderIvLast;
    @BindView(R.id.bid_accord_with_tender_rl)
    RelativeLayout bidAccordWithTenderRl;
    @BindView(R.id.sp_sort)
    Spinner spSort;
    @BindView(R.id.sp_expire)
    Spinner spExpire;
    @BindView(R.id.ll_seek)
    LinearLayout llSeek;
    @BindView(R.id.lv_tender_info_queue)
    UpLoadListView lvTenderInfoQueue;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.tv_not)
    TextView tvNot;
    @BindView(R.id.rl_not_data)
    RelativeLayout rlNotData;
    @BindView(R.id.ll_load)
    LinearLayout llLoad;
    @BindView(R.id.loading_error_img)
    ImageView loadingErrorImg;
    @BindView(R.id.rl_load_fail)
    RelativeLayout rlLoadFail;
    @BindView(R.id.rl_load)
    RelativeLayout rlLoad;
    @BindView(R.id.activity_bid_accord_with_tender)
    RelativeLayout activityBidAccordWithTender;
    private MyActivityManager myActivityManager;
    private TextView bid_accord_with_tender_iv_last;
    private LinearLayout ll_load;
    private RelativeLayout rl_load_fail;
    private RelativeLayout rl_load;
    private UpLoadListView lv_tender_info_queue;
    private RelativeLayout rl_not_data;
    private Spinner sp_sort;
    private Spinner sp_expire;
    private EditText et_seek;
    private TextView tv_seek;
    private MyAdapter myAdapter;
    private SharedPreferences sp;
    private boolean isHasData = true;
    private List<TenderAndBid.Result.Row> rowList = new ArrayList<>();
    private int value;
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

            }
        }
    };
    private LinearLayout ll_seek;
    private Spinner sp_sort_hid;
    private Spinner sp_expire_hid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        value = intent.getIntExtra("VALUE", 0);
        setContentView(R.layout.activity_bid_accord_with_tender);
        ButterKnife.bind(this);
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
        lv_tender_info_queue = ((UpLoadListView) findViewById(R.id.lv_tender_info_queue));
        rl_not_data = ((RelativeLayout) findViewById(R.id.rl_not_data));
        ll_seek = ((LinearLayout) findViewById(R.id.ll_seek));
        sp_sort_hid = ((Spinner) findViewById(R.id.sp_sort));
        sp_expire_hid = ((Spinner) findViewById(R.id.sp_expire));
    }

    private void initData() {
        //刷新
        //设置 Header 为 水波

        sort(sort, expire);
        addHeaderView();
        //重新加载
        WaveSwipeHeader waveSwipeHeader= new WaveSwipeHeader(this);
        waveSwipeHeader.setColorSchemeColors(Color.WHITE, Color.WHITE);
        smartRefreshLayout.setRefreshHeader(waveSwipeHeader);
        smartRefreshLayout.setFooterHeight(0);
        //刷新
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNo=1;
                rowList.clear();
                sort(sort, expire);

            }
        });
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
        lv_tender_info_queue.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {

            @Override
            public void onLoadingMore() {
                pageNo++;
                sort(sort, expire);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem >= 1) {
                    ll_seek.setVisibility(View.VISIBLE);
                } else {
                    ll_seek.setVisibility(View.GONE);
                }
            }
        });
        //招标详情
        lv_tender_info_queue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < rowList.size() + 1) {
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
        sp_sort_hid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        sp_expire_hid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        if (value == 0) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("DIRECT", BACK_TASK);
            startActivity(intent);
            myActivityManager.popOneActivity(this);
        } else {
            myActivityManager.popOneActivity(this);

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
                viewHolder.tv_first_pay = (TextView) convertView.findViewById(R.id.tv_first_pay);
                viewHolder.tv_publish = (TextView) convertView.findViewById(R.id.tv_publish);
                viewHolder.iv_out_of_date = (ImageView) convertView.findViewById(R.id.iv_out_of_date);
                viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv);

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
            viewHolder.tv_useful_time.setText(CommonUtil.dateToString(CommonUtil.stringToDate(rowList.get(position).expireDate)));
            viewHolder.tv_publish.setText(DateUtils.format(CommonUtil.stringToDate(rowList.get(position).updateDate)));
            //设置失效显示
            if (CommonUtil.compare_date(rowList.get(position).expireDate, CommonUtil.dateToString(new Date(System.currentTimeMillis()))) < 0) {
                viewHolder.iv_out_of_date.setVisibility(View.VISIBLE);
            }
            GlideUtils.glideImageView(BidAccordWithTender.this, viewHolder.iv, rowList.get(position).inviteCompany.photo, true);
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
        public ImageView iv;
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
                smartRefreshLayout.finishRefresh();
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
                    rowList.addAll(0, tender.getResult().rows);
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

    public void addHeaderView() {
        View view = View.inflate(this, R.layout.layout_bid_header, null);
        sp_sort = ((Spinner) view.findViewById(R.id.sp_sort));
        sp_expire = ((Spinner) view.findViewById(R.id.sp_expire));
        et_seek = (EditText) view.findViewById(R.id.et_seek);
        tv_seek = ((TextView) view.findViewById(R.id.tv_seek));
        lv_tender_info_queue.addHeaderView(view);
    }
}
