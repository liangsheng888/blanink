package com.blanink.activity.bidtender;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.TenderAndBid;
import com.blanink.utils.CommonUtil;
import com.blanink.utils.DateUtils;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.LoadListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 招标 搜索
 */
public class BidSeekTender extends AppCompatActivity implements LoadListView.ILoadListener {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.bid_seek)
    RelativeLayout bidSeek;
    @BindView(R.id.come_order_tv)
    TextView comeOrderTv;
    @BindView(R.id.et_seek)
    EditText etSeek;
    @BindView(R.id.tv_seek)
    TextView tvSeek;
    @BindView(R.id.rl_seek)
    RelativeLayout rlSeek;
    @BindView(R.id.lv)
    LoadListView lv;
    @BindView(R.id.activity_bid_seek_tender)
    RelativeLayout activityBidSeekTender;
    @BindView(R.id.tv_not)
    TextView tvNot;
    @BindView(R.id.ll_load)
    LinearLayout llLoad;
    @BindView(R.id.seek_not_data)
    RelativeLayout rlNotData;
    private MyActivityManager myActivityManager;
    private String title;
    private SharedPreferences sp;
    private List<TenderAndBid.Result.Row> rowList = new ArrayList<>();
    private MyAdapter adapter;
    private int pageNo = 1;
    private boolean isHasData = true;
    private SparseArray<View> viewSparseArray;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv.loadComplete(isHasData);
            if (adapter == null){
                Log.e("BidSeekTender","adapter==null");
                rlNotData.setVisibility(View.VISIBLE);
            }else {
            adapter.notifyDataSetChanged();}
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        setContentView(R.layout.activity_bid_seek_tender);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        ButterKnife.bind(this);
        lv.setInterface(this);
        initData();
    }

    private void initData() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TenderAndBid.Result.Row row = rowList.get(position);
                Intent intent = new Intent(BidSeekTender.this, TenderDetail.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("TenderDetail", row);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        etSeek.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                rlNotData.setVisibility(View.GONE);
                if (adapter != null) {
                    isHasData = true;  //底部状态消失
                    rowList.clear();
                    handler.sendEmptyMessage(0);//通知更新界面
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    @OnClick({R.id.iv_last, R.id.tv_seek})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_last:
                finish();
                break;
            case R.id.tv_seek:
                //搜索
                title = etSeek.getText().toString().trim();
                if (TextUtils.isEmpty(title)) {
                    Toast.makeText(this, "请输入搜索关键字段", Toast.LENGTH_SHORT).show();
                    return;
                }
                rowList.clear();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                llLoad.setVisibility(View.VISIBLE);
                findContentFromServer();
                break;
        }
    }

    private void findContentFromServer() {
        // http://localhost:8088/blanink-api/inviteBid/findInviteBid?
        // userId=fec25c7f7634448581e21876ef517c57&
        // remarks=12321321&title=萨达撒旦撒&
        // buyProductName=嘻嘻
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/findInviteBid");
        rp.addBodyParameter("title", title);
        rp.addBodyParameter("remarks", title);
        rp.addBodyParameter("buyProductName", title);
        rp.addBodyParameter("pageNo", pageNo + "");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e("BidSeekTender", result.toString());
                Gson gson = new Gson();
                TenderAndBid tb = gson.fromJson(result, TenderAndBid.class);
                Log.e("BidSeekTender", tb.toString());
                if(tb.getResult().total==0){
                    rlNotData.setVisibility(View.VISIBLE);
                }
                if (tb.getResult().total <=rowList.size()) {
                    isHasData = false;
                } else {
                    rowList.clear();
                    rowList.addAll(tb.getResult().rows);
                    if (adapter == null) {
                        adapter = new MyAdapter();
                        lv.setAdapter(adapter);
                    } else {
                        adapter.notifyDataSetChanged();
                    }

                }
                handler.sendEmptyMessage(0);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                llLoad.setVisibility(View.GONE);
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
    private void findContentFromServer2() {
        // http://localhost:8088/blanink-api/inviteBid/findInviteBid?
        // userId=fec25c7f7634448581e21876ef517c57&
        // remarks=12321321&title=萨达撒旦撒&
        // buyProductName=嘻嘻
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/findInviteBid");
        rp.addBodyParameter("title", title);
        rp.addBodyParameter("remarks", title);
        rp.addBodyParameter("buyProductName", title);
        rp.addBodyParameter("pageNo", pageNo + "");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e("BidSeekTender", result.toString());
                Gson gson = new Gson();
                TenderAndBid tb = gson.fromJson(result, TenderAndBid.class);
                Log.e("BidSeekTender", tb.toString());
                if (tb.getResult().total <=rowList.size()) {
                    isHasData = false;
                } else {
                    rowList.addAll(tb.getResult().rows);
                    if (adapter == null) {
                        adapter = new MyAdapter();
                        lv.setAdapter(adapter);
                    } else {
                        adapter.notifyDataSetChanged();
                    }

                }
                handler.sendEmptyMessage(0);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                llLoad.setVisibility(View.GONE);
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
    @Override
    public void onLoad() {
        pageNo++;
        findContentFromServer2();
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
            viewSparseArray=new SparseArray<>();
            ViewHolder viewHolder = null;
            if (viewSparseArray.get(position,null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(BidSeekTender.this, R.layout.item_my_tender, null);
                viewHolder.tv_company = (TextView) convertView.findViewById(R.id.tv_company);
                viewHolder.tv_tag = (TextView) convertView.findViewById(R.id.tv_tag);
                viewHolder.tv_purchase_num = (TextView) convertView.findViewById(R.id.tv_tender_purchase_num);
                viewHolder.tv_single_price = (TextView) convertView.findViewById(R.id.tv_single_price);
                viewHolder.tv_useful_time = (TextView) convertView.findViewById(R.id.tv_useful_time);
                viewHolder.tv_single_price = (TextView) convertView.findViewById(R.id.tv_single_price);
                viewHolder.tv_note_content = (TextView) convertView.findViewById(R.id.tv_note_content);
                viewHolder.tv_first_pay = (TextView) convertView.findViewById(R.id.tv_first_pay);
                viewHolder.tv_publish = (TextView) convertView.findViewById(R.id.tv_publish);
                viewHolder.iv_out_of_date=(ImageView)convertView.findViewById(R.id.iv_out_of_date);
                viewHolder.iv=(ImageView)convertView.findViewById(R.id.iv);

                viewSparseArray.put(position,convertView);
                convertView.setTag(viewHolder);
            } else {
                convertView=viewSparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.tv_company.setText(rowList.get(position).inviteCompany.name);
            viewHolder.tv_tag.setText(rowList.get(position).buyProductName);
            viewHolder.tv_purchase_num.setText(rowList.get(position).count + "");
            Integer count = rowList.get(position).count;
            viewHolder.tv_single_price.setText(rowList.get(position).targetPrice);
            viewHolder.tv_first_pay.setText(rowList.get(position).downPayment + "%");
            viewHolder.tv_note_content.setText(rowList.get(position).remarks);
            viewHolder.tv_useful_time.setText(CommonUtil.dateToString(CommonUtil.stringToDate(rowList.get(position).expireDate)));
            viewHolder.tv_publish.setText(DateUtils.format(CommonUtil.stringToDate(rowList.get(position).createDate)));
            //设置失效显示
            if (CommonUtil.compare_date(rowList.get(position).expireDate, CommonUtil.dateToString(new Date(System.currentTimeMillis())))<0){
                viewHolder.iv_out_of_date.setVisibility(View.VISIBLE);
            }
            GlideUtils.glideImageView(BidSeekTender.this,viewHolder.iv,rowList.get(position).inviteCompany.photo,true);

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
        public ImageView iv;
    }
}
