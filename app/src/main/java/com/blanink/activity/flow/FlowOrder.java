package com.blanink.activity.flow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.Order;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.UpLoadListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//排流程 订单列表
public class FlowOrder extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.come_order_iv_last)
    TextView comeOrderIvLast;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    @BindView(R.id.lv)
    UpLoadListView lv;
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
    @BindView(R.id.activity_flow_order)
    RelativeLayout activityFlowOrder;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private List<Order.Result.Rows> rowsList = new ArrayList<>();
    private boolean isHasData = true;
    private Integer pageNo = 1;
    private SparseArray<View> sparseArray;
    private MyAdapter adapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv.completeRefresh(isHasData);
            if (adapter != null) {
                Log.e("ComeOrderActivity", "界面刷新了");
                adapter.notifyDataSetChanged();
            } else {
                rlNotData.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_order);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        //初始化 加载数据
        loadData();
        //刷新
        srl.setProgressBackgroundColorSchemeResource(android.R.color.white);
        srl.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        srl.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadDataRefresh();
            }
        });
        //加载更多
        lv.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {
            @Override
            public void onLoadingMore() {
                pageNo++;
                loadData();
            }
        });

        //跳转到详情 排流程
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < rowsList.size()) {
                    Intent intent = new Intent(FlowOrder.this, FlowOftenUse.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    public void loadDataRefresh() {

        if (!ExampleUtil.isConnected(this)) {
            llLoad.setVisibility(View.GONE);
            Toast.makeText(this, "请检查你的网络！", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/orderList");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        Log.e("ComeOrderActivity", "pageNo:" + pageNo);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                rlLoad.setVisibility(View.GONE);
                Log.e("ComeOrderActivity", result);
                Gson gson = new Gson();
                Order order = gson.fromJson(result, Order.class);
                Log.e("ComeOrderActivity", "order;" + order.toString());
                if (rowsList.size() >= order.result.total) {
                    Toast.makeText(FlowOrder.this, "没有刷新出来数据", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(FlowOrder.this, "刷新出来" + order.result.rows.size() + "条数据", Toast.LENGTH_SHORT).show();
                    rowsList.addAll(0, order.result.rows);
                    Log.e("ComeOrderActivity", "rowList.size():" + rowsList.toString());
                    if (adapter == null) {
                        adapter = new MyAdapter();
                    } else {
                        Log.e("ComeOrderActivity", "commonAdapter!=null");
                        adapter.notifyDataSetChanged();
                    }
                    lv.setAdapter(adapter);
                }
                srl.setRefreshing(false);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                rlLoadFail.setVisibility(View.VISIBLE);
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

    public void loadData() {

        if (!ExampleUtil.isConnected(this)) {
            llLoad.setVisibility(View.GONE);
            Toast.makeText(this, "请检查你的网络！", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/orderList");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        Log.e("ComeOrderActivity", "pageNo:" + pageNo);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                rlLoad.setVisibility(View.GONE);
                Log.e("ComeOrderActivity", result);
                Gson gson = new Gson();
                Order order = gson.fromJson(result, Order.class);
                Log.e("ComeOrderActivity", "order;" + order.toString());
                if (order.result.total <= rowsList.size()) {
                    isHasData = false;
                } else {
                    rowsList.addAll(order.result.rows);
                    Log.e("ComeOrderActivity", "rowList.size():" + rowsList.toString());
                    if (adapter == null) {
                        adapter = new MyAdapter();
                        lv.setAdapter(adapter);
                    } else {
                        Log.e("ComeOrderActivity", "commonAdapter!=null");
                        adapter.notifyDataSetChanged();
                    }

                }
                handler.sendEmptyMessage(0);//通知ui界面更新
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                rlLoadFail.setVisibility(View.VISIBLE);
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

    @OnClick({R.id.come_order_iv_last, R.id.rl_load_fail})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.come_order_iv_last://返回
                finish();
                break;
            case R.id.rl_load_fail://重新加载
                loadData();
                break;
        }
    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return rowsList.size();
        }

        @Override
        public Object getItem(int position) {
            return rowsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Order.Result.Rows order = rowsList.get(position);
            sparseArray = new SparseArray<>();
            ViewHolder viewHolder = null;
            if (sparseArray.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(FlowOrder.this, R.layout.item_comeorder, null);
                viewHolder.tv_company = (TextView) convertView.findViewById(R.id.tv_company);
                viewHolder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);
                viewHolder.tv_master = (TextView) convertView.findViewById(R.id.tv_master);
                viewHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
                viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_tile);
                convertView.setTag(viewHolder);
                sparseArray.put(position, convertView);

            } else {
                convertView = sparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();

            }
            viewHolder.tv_company.setText(order.aCompany.name);
            //产品类
            viewHolder.tv_title.setText(order.name);
            viewHolder.tv_date.setText(order.takeOrderTime);
            viewHolder.tv_master.setText(order.aCompany.master);
            //tv_proCate.setText();
            if ("01".equals(order.orderStatus)) {
                //甲方“去单产品”刚刚创建，但还没有形成订单下发
                viewHolder.tv_state.setText("未下发");
            }
            if ("02".equals(order.orderStatus)) {
                //甲方“去单产品”已经创建，且已经绑定订单，但还没有发送出去
                viewHolder.tv_state.setText("已绑定");
            }
            if ("03".equals(order.orderStatus)) {
                //甲方“去单产品"已经组合成订单，发送给乙方
                viewHolder.tv_state.setText("待乙方接收");
            }
            if ("4".equals(order.orderStatus)) {
                //乙方“来单"已经创建
                viewHolder.tv_state.setText("待甲方确认");
            }
            if ("5".equals(order.orderStatus)) {
                //乙方“来单"已经创建（或者编辑甲方发来的产品信息）,并打回甲方确认中
                viewHolder.tv_state.setText("甲方确认中");
            }
            if ("6".equals(order.orderStatus)) {
                //乙方“来单"已经创建（或者编辑甲方发来的产品信息）,并打回甲方确认后，
                // 甲方已经确认，并重新发送给已方
                viewHolder.tv_state.setText("待下发");
            }
            if ("7".equals(order.orderStatus)) {
                //乙方内部下发生产中
                viewHolder.tv_state.setText("生产中");
            }
            if ("8".equals(order.orderStatus)) {
                //乙方内部流程已创建，未发布
                viewHolder.tv_state.setText("生产中");
            }
            if ("9".equals(order.orderStatus)) {
                //乙方内部流程已创建，并且已发布
                viewHolder.tv_state.setText("生产中");
            }
            if ("10".equals(order.orderStatus)) {
                //乙方内部生产已经完成，未发货-----在反馈任务，改变flow_process状态时候，进行修改本状态
                viewHolder.tv_state.setText("未发货");
            }
            if ("11".equals(order.orderStatus)) {
                //部分发货
                viewHolder.tv_state.setText("部分发货");
            }
            if ("12".equals(order.orderStatus)) {
                // 全部发货完成
                viewHolder.tv_state.setText("全部发货");
            }
            if ("13".equals(order.orderStatus)) {
                //   部分发货，并且已经确认收到
                viewHolder.tv_state.setText("甲方部分收货");
            }
            if ("14".equals(order.orderStatus)) {
                //全部发货完成，并且已经确认收到
                viewHolder.tv_state.setText("甲方全部收货");
            }
            if ("15".equals(order.orderStatus)) {
                // 本订单产品的售后已经发起，等待答复
                viewHolder.tv_state.setText("售后处理，等待答复");
            }
            if ("16".equals(order.orderStatus)) {
                // 本订单产品的售后正在处理中
                viewHolder.tv_state.setText("生产中");
            }
            if ("17".equals(order.orderStatus)) {
                viewHolder.tv_state.setText("售后处理结束");
                //   本订单产品的售后处理结束
            }
            if ("18".equals(order.orderStatus)) {
                viewHolder.tv_state.setText("售后处理结束");
                //本订单产品的售后处理结束,并被确认ok
            }
            if ("19".equals(order.orderStatus)) {
                viewHolder.tv_state.setText("发起还款");
                // 本订单产品的还款已经发起
            }
            if ("20".equals(order.orderStatus)) {
                // 本订单产品的还款已经确认
                viewHolder.tv_state.setText("还款已确认");
            }
            return convertView;
        }
    }

    static class ViewHolder {
        TextView tv_company;
        TextView tv_state;
        TextView tv_master;
        TextView tv_date;
        TextView tv_title;
    }

}
