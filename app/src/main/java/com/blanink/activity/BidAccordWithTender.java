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
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

import static com.blanink.R.id.lv_tender;

/***
 * 投标 符合招标信息
 */
public class BidAccordWithTender extends AppCompatActivity {

    private static final int BACK_TASK = 0;
    private MyActivityManager myActivityManager;
    private ImageView bid_accord_with_tender_iv_last;
    private TextView tv_sort;
    private LinearLayout ll_load;
    private RelativeLayout rl_load_fail;
    private RelativeLayout rl_load;
    private RefreshListView lv_tender_info_queue;
    private int pageNo = 1;
    private MyAdapter myAdapter;
    private SharedPreferences sp;
    private boolean isHasData = true;
    private List<TenderAndBid.Result.Row> rowList=new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv_tender_info_queue.completeRefresh(isHasData);
            myAdapter.notifyDataSetChanged();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bid_accord_with_tender);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        loadDataFromServer();
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);

        initView();
        initData();
    }

    private void initView() {
        bid_accord_with_tender_iv_last = ((ImageView) findViewById(R.id.bid_accord_with_tender_iv_last));
        tv_sort = ((TextView) findViewById(R.id.tv_sort));
        ll_load = ((LinearLayout) findViewById(R.id.ll_load));
        rl_load_fail = ((RelativeLayout) findViewById(R.id.rl_load_fail));
        rl_load = ((RelativeLayout) findViewById(R.id.rl_load));
        lv_tender_info_queue = ((RefreshListView) findViewById(R.id.lv_tender_info_queue));
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
        bid_accord_with_tender_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //排序
        tv_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // PopupWindow pop=new PopupWindow()
                Toast.makeText(BidAccordWithTender.this, "选择了排序", Toast.LENGTH_SHORT).show();

            }
        });
        //刷新 加载更多
        lv_tender_info_queue.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
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
        //招标详情
        lv_tender_info_queue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TenderAndBid.Result.Row row=rowList.get(position-1);
                Intent intent=new Intent(BidAccordWithTender.this,TenderDetail.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("TenderDetail",row);
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
        intent.putExtra("DIRECT", BACK_TASK);
        startActivity(intent);

    }

    public void loadDataFromServer() {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/allList");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo",pageNo+"");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                ll_load.setVisibility(View.GONE);
                rl_load.setVisibility(View.GONE);
                Log.e("BidAccordWithTender", "result+++++" + result);
                Gson gson = new Gson();
                TenderAndBid tender = gson.fromJson(result, TenderAndBid.class);
                Log.e("BidAccordWithTender", "tender+++++" + tender.toString());

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
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.tv_company.setText(rowList.get(position).inviteCompany.name);
            viewHolder.tv_tag.setText(rowList.get(position).buyProductName);
            viewHolder.tv_purchase_num.setText(rowList.get(position).count + "");
            int total = Integer.parseInt(rowList.get(position).targetPrice);
            int count = rowList.get(position).count;
            DecimalFormat df = new DecimalFormat("0.00");
            viewHolder.tv_single_price.setText(df.format(total / count * 1.0) + "");
            viewHolder.tv_first_pay.setText(rowList.get(position).downPayment+"%");
            viewHolder.tv_note_content.setText(rowList.get(position).remarks);
            viewHolder.tv_useful_time.setText(rowList.get(position).expireDate);
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
    }
}
