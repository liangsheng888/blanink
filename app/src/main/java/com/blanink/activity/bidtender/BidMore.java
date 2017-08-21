package com.blanink.activity.bidtender;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.BidTender;
import com.blanink.utils.CommonUtil;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.UpLoadListView;
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

public class BidMore extends AppCompatActivity {


    @BindView(R.id.bid_accord_with_tender_iv_last)
    TextView bidAccordWithTenderIvLast;
    @BindView(R.id.bid_accord_with_tender_rl)
    RelativeLayout bidAccordWithTenderRl;
    @BindView(R.id.lv_tender_info_queue)
    UpLoadListView lvTenderInfoQueue;
    @BindView(R.id.ll_load)
    LinearLayout llLoad;
    @BindView(R.id.loading_error_img)
    ImageView loadingErrorImg;
    @BindView(R.id.rl_load_fail)
    RelativeLayout rlLoadFail;
    @BindView(R.id.tv_not)
    TextView tvNot;
    @BindView(R.id.rl_not_data)
    RelativeLayout rlNotData;
    @BindView(R.id.fl_load)
    FrameLayout flLoad;
    @BindView(R.id.activity_bid_accord_with_tender)
    RelativeLayout activityBidAccordWithTender;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private SparseArray<View> viewSparseArray;
    private Boolean isExipre = false;
    private MyAdapter adapter;
    private List<BidTender.ResultBean.ListBean> bidTenderList = new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lvTenderInfoQueue.completeRefresh(isHasData);
            adapter.notifyDataSetChanged();
        }
    };
    private String content;
    private Boolean isHasData = true;
    private int pageNo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        content = intent.getStringExtra("content");
        setContentView(R.layout.activity_bid_more);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initData();

    }

    private void initData() {
        loadData();
        lvTenderInfoQueue.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {
            @Override
            public void onLoadingMore() {
                pageNo++;
                loadData();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        //招标详情
        lvTenderInfoQueue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < bidTenderList.size()) {
                    BidTender.ResultBean.ListBean row = bidTenderList.get(position );
                    Intent intent = new Intent(BidMore.this, TenderDetail.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("BidDetail", row);
                    intent.putExtra("flag",1);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });
    }

    @OnClick({R.id.bid_accord_with_tender_iv_last, R.id.rl_load_fail})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bid_accord_with_tender_iv_last:
                finish();
                break;
            case R.id.rl_load_fail:
                rlLoadFail.setVisibility(View.GONE);
                llLoad.setVisibility(View.VISIBLE);
                loadData();
                break;
        }
    }


    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return bidTenderList.size();
        }

        @Override
        public Object getItem(int position) {
            return bidTenderList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            viewSparseArray = new SparseArray<>();
            BidAccordWithTender.ViewHolder viewHolder = null;
            if (viewSparseArray.get(position, null) == null) {
                viewHolder = new BidAccordWithTender.ViewHolder();
                convertView = View.inflate(BidMore.this, R.layout.item_my_tender, null);
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
                viewHolder = (BidAccordWithTender.ViewHolder) convertView.getTag();
            }
            viewHolder.tv_company.setText(bidTenderList.get(position).getInviteBid().getInviteCompany().getName());
            viewHolder.tv_tag.setText(bidTenderList.get(position).getInviteBid().getBuyProductName());
            viewHolder.tv_purchase_num.setText(bidTenderList.get(position).getInviteBid().getCount() + "");
            viewHolder.tv_single_price.setText(bidTenderList.get(position).getInviteBid().getTargetPrice());
            viewHolder.tv_first_pay.setText(bidTenderList.get(position).getInviteBid().getDownPayment() + "%");
            viewHolder.tv_note_content.setText(bidTenderList.get(position).getInviteBid().getRemarks());
            viewHolder.tv_useful_time.setText(CommonUtil.dateToString(CommonUtil.stringToDate(bidTenderList.get(position).getInviteBid().getExpireDate())));
            viewHolder.tv_publish.setText(bidTenderList.get(position).getInviteBid().getCreateDate());
            //设置失效显示
            if (CommonUtil.compare_date(bidTenderList.get(position).getInviteBid().getExpireDate(), CommonUtil.dateToString(new Date(System.currentTimeMillis()))) < 0) {
                viewHolder.iv_out_of_date.setVisibility(View.VISIBLE);
            }
            GlideUtils.glideImageView(BidMore.this,viewHolder.iv,bidTenderList.get(position).getInviteBid().getInviteCompany().getPhoto(),true);

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

    public void loadData() {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "search/bigSearch");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("office.name", content);
        rp.addBodyParameter("companyProduct.productName", content);
        rp.addBodyParameter("inviteBid.title", content);
        rp.addBodyParameter("financing.title", content);
        rp.addBodyParameter("pageNo", pageNo + "");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                BidTender bid = gson.fromJson(result, BidTender.class);
                if (bid.getResult().get(2).getCount() <= bidTenderList.size()) {
                    isHasData = false;
                } else {
                    if (adapter == null) {
                        adapter = new MyAdapter();
                        lvTenderInfoQueue.setAdapter(adapter);
                    } else {
                        adapter.notifyDataSetChanged();
                    }
                    bidTenderList.addAll(bid.getResult().get(2).getList());

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
}
