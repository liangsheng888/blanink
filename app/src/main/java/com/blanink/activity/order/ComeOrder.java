package com.blanink.activity.order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
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
import com.blanink.utils.DateUtils;
import com.blanink.utils.ExampleUtil;
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

public class ComeOrder extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    @BindView(R.id.lv)
    UpLoadListView lv;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
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
    private final static int BACK_TASK = 0;
    @BindView(R.id.iv_last)
    TextView ivLast;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private List<ComeOder.ResultBean.RowsBean> rowsList = new ArrayList<>();
    private boolean isHasData = true;
    private Integer pageNo = 1;
    private SparseArray<View> sparseArray;
    private MyAdapter adapter;
    private static String flag;

    private EditText etSeek;
    private boolean isGetData = false;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv.completeRefresh(isHasData);
            if (msg.what == 100) {
                Log.e("ComeOrderActivity", "刷新");

                rowsList = (List<ComeOder.ResultBean.RowsBean>) msg.obj;
                if (rowsList.size() == 0) {
                    rlNotData.setVisibility(View.VISIBLE);
                }
                lv.setAdapter(new MyAdapter());
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                Log.e("ComeOrderActivity", "刷新over");

            } else {
                if (adapter != null) {
                    Log.e("ComeOrderActivity", "adapter!=null");
                    if (adapter.getCount() == 0) {
                        rlNotData.setVisibility(View.VISIBLE);
                    } else {
                        rlNotData.setVisibility(View.GONE);
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e("ComeOrderActivity", "adapter==null");
                    rlNotData.setVisibility(View.VISIBLE);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_order);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        initData();

    }

    private void initData() {
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //初始化数据
        loadData();
        addHeaderView();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rlNotData.setVisibility(View.GONE);
                pageNo = 1;
                RefreshData();
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
        //添加订单
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComeOrder.this, ComeOrderNewAddInfoActivity.class);
                startActivity(intent);
            }
        });
        //订单详情
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < rowsList.size() + 1) {
                    Intent intent = new Intent(ComeOrder.this, ComeOrderProductActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("orderDetail", rowsList.get(position - 1));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
        rlLoadFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlLoadFail.setVisibility(View.GONE);
                llLoad.setVisibility(View.VISIBLE);
                loadData();
            }
        });
    }

    private void RefreshData() {
        if (!ExampleUtil.isConnected(ComeOrder.this)) {
            llLoad.setVisibility(View.GONE);
            Toast.makeText(ComeOrder.this, "请检查你的网络！", Toast.LENGTH_SHORT).show();
            return;
        }

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/listJson_coming");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("flag", 0 + "");
        rp.addBodyParameter("bCompany.id", sp.getString("COMPANY_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("pageSize", "10");
        rp.addBodyParameter("sortOrder", "asc");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                rowsList.clear();
                llLoad.setVisibility(View.GONE);
                Log.e("ComeOrderActivity", result);
                Gson gson = new Gson();
                ComeOder order = gson.fromJson(result, ComeOder.class);
                Log.e("ComeOrderActivity", "order;" + order.toString());
                rowsList.addAll(order.getResult().getRows());
                Toast.makeText(ComeOrder.this, "刷新成功", Toast.LENGTH_SHORT).show();

                swipeRefreshLayout.setRefreshing(false);
                handler.sendEmptyMessage(0);//通知ui界面更新
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(ComeOrder.this, "服务器异常", Toast.LENGTH_SHORT).show();
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
    public void onStart() {
        Log.e("@@@@", "onstart");
        if (etSeek != null) {
            etSeek.clearFocus();
            etSeek.setCursorVisible(false);
        }
        if ("REFRESH".equals(flag)) {
            Log.e("ComeOrderActivity", "刷新开始");
            load();
        }
        super.onStart();

    }

    @Override
    public void onPause() {
        Log.e("@@@@", "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e("@@@@", "onStop");
        super.onStop();
    }

    @OnClick(R.id.rl_load_fail)
    public void onClick() {
        rlLoadFail.setVisibility(View.GONE);
        llLoad.setVisibility(View.VISIBLE);
        rowsList.clear();
        loadData();
    }

    //访问服务器
    public void loadData() {
        if (!ExampleUtil.isConnected(ComeOrder.this)) {
            llLoad.setVisibility(View.GONE);
            Toast.makeText(ComeOrder.this, "请检查你的网络！", Toast.LENGTH_SHORT).show();
            return;
        }
        //http://192.168.199.147:8080/blanink-api/order/listJson_coming?flag=0&bCompany.id=9ce7467e94884e7192a14ad3c29c554d&pageSize=10&pageNo=1
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/listJson_coming");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("flag", 0 + "");
        rp.addBodyParameter("bCompany.id", sp.getString("COMPANY_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("pageSize", "10");
        rp.addBodyParameter("sortOrder", "asc");
        Log.e("ComeOrderActivity", "pageNo:" + pageNo);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e("ComeOrderActivity", result);
                Gson gson = new Gson();
                ComeOder order = gson.fromJson(result, ComeOder.class);
                Log.e("ComeOrderActivity", "order;" + order.toString());
                if (order.getResult().getTotal() <= rowsList.size()) {
                    isHasData = false;
                    pageNo--;
                } else {
                    rowsList.addAll(order.getResult().getRows());
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
                Log.e("OrderFragment", ex.toString());
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ComeOder.ResultBean.RowsBean order = rowsList.get(position);
            sparseArray = new SparseArray<>();
            ViewHolder viewHolder = null;
            if (sparseArray.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(ComeOrder.this, R.layout.item_comeorder, null);
                viewHolder.tv_company = (TextView) convertView.findViewById(R.id.tv_company);
                viewHolder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);
                viewHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
                viewHolder.tv_remark = (TextView) convertView.findViewById(R.id.tv_remark);
                viewHolder.iv_log = (ImageView) convertView.findViewById(R.id.iv_log);
                viewHolder.tv_modify = (TextView) convertView.findViewById(R.id.tv_modify);

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
            XUtilsImageUtils.display(viewHolder.iv_log, order.getACompany().getPhoto(), true);

            //都等于5 no ,有一个在7-14,23 no,
            int size = 0;
            for (int i = 0; i < order.getOrderProductList().size(); i++) {
                if (
                        SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_DISTRIBUTE.equals(order.getOrderProductList().get(i).getOrderProductStatus()) || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_FLOW_CREATED.equals(order.getOrderProductList().get(i).getOrderProductStatus())
                                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_FLOW_PULISHED.equals(order.getOrderProductList().get(i).getOrderProductStatus())
                                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_PRODUCTION_END.equals(order.getOrderProductList().get(i).getOrderProductStatus())
                                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_DELIEVERY_PART.equals(order.getOrderProductList().get(i).getOrderProductStatus())
                                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_DELIEVERY_OVER.equals(order.getOrderProductList().get(i).getOrderProductStatus())
                                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_RECEIVED_PART.equals(order.getOrderProductList().get(i).getOrderProductStatus())
                                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_RECEIVED_OVER.equals(order.getOrderProductList().get(i).getOrderProductStatus())
                                || SysConstants.ORDER_PRODUCT_SRTATUS_REJECT.equals(order.getOrderProductList().get(i).getOrderProductStatus())
                        ) {
                    viewHolder.tv_modify.setVisibility(View.GONE);
                    break;
                } else if ((SysConstants.ORDER_PRODUCT_STATUS_BACK_TO_A.equals(order.getOrderProductList().get(i).getOrderProductStatus())
                )) {
                    size++;
                    if (size == order.getOrderProductList().size()) {
                        viewHolder.tv_modify.setVisibility(View.GONE);
                    }
                }
            }
            viewHolder.tv_modify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int length = 0;
                    for (int i = 0; i < order.getOrderProductList().size(); i++) {
                        if (
                                SysConstants.ORDER_PRODUCT_STATUS_BACK_TO_A.equals(order.getOrderProductList().get(i).getOrderProductStatus())
                                ) {//订单产品状态都是4可以选修改客户
                            length++;
                            if (length == order.getOrderProductList().size()) {
                                Intent intent = new Intent(ComeOrder.this, ComeOrderModify.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("OrderDetail", rowsList.get(position));
                                intent.putExtras(bundle);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }

                        } else {
                            Intent intent = new Intent(ComeOrder.this, ComeOrderModifyNoModifyCustomer.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("OrderDetail", rowsList.get(position));
                            intent.putExtras(bundle);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    }


                }
            });
            return convertView;
        }
    }

    static class ViewHolder {
        TextView tv_company;
        TextView tv_state;
        TextView tv_date;
        ImageView iv_log;
        TextView tv_remark;
        TextView tv_modify;
    }

    public void addHeaderView() {
        View view = View.inflate(ComeOrder.this, R.layout.layout_header_order, null);
        lv.addHeaderView(view);
        etSeek = (EditText) view.findViewById(R.id.et_seek);
        etSeek.clearFocus();
        etSeek.setCursorVisible(false);
        etSeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSeek.setFocusable(true);
                etSeek.setCursorVisible(true);
            }
        });
        //设立焦点改变监听事件
        etSeek.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //跳到搜索界面
                    Log.e("HomeFragment", "焦点:" + hasFocus);
                    etSeek.setCursorVisible(true);
                    Intent intent = new Intent(ComeOrder.this, OrderSeek.class);
                    intent.putExtra("flag", "0");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    etSeek.setCursorVisible(false);
                }
            }
        });
    }

    private void load() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/listJson_coming");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("flag", 0 + "");
        rp.addBodyParameter("bCompany.id", sp.getString("COMPANY_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("pageSize", "10");
        rp.addBodyParameter("sortOrder", "asc");
        Log.e("ComeOrderActivity", "pageNo:" + pageNo);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("ComeOrderActivity", result);
                Gson gson = new Gson();
                ComeOder order = gson.fromJson(result, ComeOder.class);
                Log.e("ComeOrderActivity", "order;" + order.toString());
                if (order.getResult().getRows().size() == 0) {
                    rowsList.clear();
                    pageNo--;
                } else {
                    rlNotData.setVisibility(View.GONE);
                    rowsList.clear();
                    rowsList.addAll(order.getResult().getRows());

                }
                Message msg = new Message();
                msg.obj = rowsList;
                msg.what = 100;
                handler.sendMessage(msg);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
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

    public static class RefreshBroReceiver extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("Order", "收到刷新广播了");
            flag = intent.getStringExtra("flag");
        }


    }
}
