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
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.ComeOder;
import com.blanink.pojo.Order;
import com.blanink.utils.CommonUtil;
import com.blanink.utils.DateUtils;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.OrderStateUtils;
import com.blanink.utils.SysConstants;
import com.blanink.utils.XUtilsImageUtils;
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
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
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
    @BindView(R.id.activity_flow_order)
    RelativeLayout activityFlowOrder;
    @BindView(R.id.tv_sorted)
    TextView tvSorted;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private List<Order.Result.Rows> rowsList = new ArrayList<>();
    private List<ComeOder.ResultBean.RowsBean> currentRowsList = new ArrayList<>();
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
                tvNot.setText("暂无可排订单");
            }
        }
    };
    private EditText et_seek;

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
        addSeekHeader();
        //历史排流程
        tvSorted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FlowOrder.this,FlowSortCompleted.class);
                startActivity(intent);
            }
        });
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

                pageNo++;
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

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(FlowOrder.this, FlowProduct.class);
                intent.putExtra("orderId", currentRowsList.get(position - 1).getId());
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    public void loadDataRefresh() {
        if (!CommonUtil.isConnected(this)) {
            llLoad.setVisibility(View.GONE);
            Toast.makeText(this, "请检查你的网络！", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/listJson_coming");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("flag", "1");
        rp.addBodyParameter("bCompany.id", sp.getString("COMPANY_ID", null));
        rp.addBodyParameter("pageSize", "10");
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("sortOrder", "asc");
        Log.e("ComeOrderActivity", "pageNo:" + pageNo);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e("ComeOrderActivity", result);
                Gson gson = new Gson();
                ComeOder order = gson.fromJson(result, ComeOder.class);
                List<ComeOder.ResultBean.RowsBean> orderList = new ArrayList<ComeOder.ResultBean.RowsBean>();
                for (int i = 0; i < order.getResult().getRows().size(); i++) {
                    //过滤订单产品
                    for (int j = 0; j < order.getResult().getRows().get(i).getOrderProductList().size(); j++) {
                        if ("7".equals(order.getResult().getRows().get(i).getOrderProductList().get(j).getOrderProductStatus())) {
                            orderList.add(order.getResult().getRows().get(i));
                            continue;
                        }
                    }
                }
                if (orderList.size() == 0) {
                    pageNo--;
                } else {
                    currentRowsList.addAll(0, orderList);
                    rlNotData.setVisibility(View.GONE);
                }
                Toast.makeText(FlowOrder.this, "已刷新", Toast.LENGTH_SHORT).show();

                srl.setRefreshing(false);
                handler.sendEmptyMessage(0);//通知ui界面更新
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                pageNo--;
                srl.setRefreshing(false);
                Toast.makeText(FlowOrder.this, "服务器异常", Toast.LENGTH_SHORT).show();
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

    //访问服务器
    public void loadData() {
        if (!CommonUtil.isConnected(this)) {
            llLoad.setVisibility(View.GONE);
            Toast.makeText(this, "请检查你的网络！", Toast.LENGTH_SHORT).show();
            return;
        }


        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/listJson_coming");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("flag", "1");
        rp.addBodyParameter("bCompany.id", sp.getString("COMPANY_ID", null));
        rp.addBodyParameter("pageSize", "10");
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("sortOrder", "asc");
        Log.e("ComeOrderActivity", "pageNo:" + pageNo);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e("ComeOrderActivity", result);
                Gson gson = new Gson();
                ComeOder order = gson.fromJson(result, ComeOder.class);
                List<ComeOder.ResultBean.RowsBean> orderList = new ArrayList<ComeOder.ResultBean.RowsBean>();
                for (int i = 0; i < order.getResult().getRows().size(); i++) {
                    //过滤订单产品
                    for (int j = 0; j < order.getResult().getRows().get(i).getOrderProductList().size(); j++) {
                        if (SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_DISTRIBUTE.equals(order.getResult().getRows().get(i).getOrderProductList().get(j).getOrderProductStatus())) {
                            orderList.add(order.getResult().getRows().get(i));
                            continue;
                        }
                    }
                }
                Log.e("ComeOrderActivity", "order;" + order.toString());
                if (orderList.size() == 0) {
                    pageNo--;
                    isHasData = false;
                } else {
                    currentRowsList.addAll(orderList);
                    if (adapter == null) {
                        adapter = new MyAdapter();
                        lv.setAdapter(adapter);
                    } else {
                        adapter.notifyDataSetChanged();
                    }

                }
                handler.sendEmptyMessage(0);//通知ui界面更新
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                pageNo--;
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
            return currentRowsList.size();
        }

        @Override
        public Object getItem(int position) {
            return currentRowsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ComeOder.ResultBean.RowsBean order = currentRowsList.get(position);
            sparseArray = new SparseArray<>();
            ViewHolder viewHolder = null;
            if (sparseArray.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(FlowOrder.this, R.layout.item_go_comeorder, null);
                viewHolder.tv_company = (TextView) convertView.findViewById(R.id.tv_company);
                viewHolder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);
                viewHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
                viewHolder.tv_remark = (TextView) convertView.findViewById(R.id.tv_remark);
                viewHolder.iv_log = (ImageView) convertView.findViewById(R.id.iv_log);

                convertView.setTag(viewHolder);
                sparseArray.put(position, convertView);
            } else {
                convertView = sparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            Log.e("ComeOrderActivity", "标题:");
            viewHolder.tv_company.setText(order.getACompany().getName());
            //产品类
            viewHolder.tv_date.setText(DateUtils.format(DateUtils.stringToDate(order.getCreateDate())));
            viewHolder.tv_state.setText(OrderStateUtils.orderStatus(order.getOrderStatus()));
            viewHolder.tv_remark.setText(order.getRemarks());
            GlideUtils.glideImageView(FlowOrder.this,viewHolder.iv_log, order.getACompany().getPhoto(), true);
            return convertView;
        }
    }

    static class ViewHolder {
        TextView tv_company;
        TextView tv_state;
        TextView tv_date;
        ImageView iv_log;
        TextView tv_remark;
    }

    public void addSeekHeader() {
        View view = View.inflate(this, R.layout.layout_header_order, null);
        et_seek = ((EditText) view.findViewById(R.id.et_seek));
        lv.addHeaderView(view);
        et_seek.clearFocus();
        et_seek.setCursorVisible(false);
        et_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_seek.setFocusable(true);
                et_seek.setCursorVisible(true);
            }
        });
        //设立焦点改变监听事件
        et_seek.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //跳到搜索界面
                    Log.e("HomeFragment", "焦点:" + hasFocus);
                    et_seek.setCursorVisible(true);
                    Intent intent = new Intent(FlowOrder.this, FlowSeek.class);
                    intent.putExtra("flag", "1");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    et_seek.setCursorVisible(false);
                }
            }
        });
    }
}
