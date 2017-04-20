package com.blanink.activity.order;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.Order;
import com.blanink.pojo.OrderDetail;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.OrderStatuUtils;
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

/***
 * 来单订单详情
 */
public class ComeOrderDetailActivity extends AppCompatActivity {


    @BindView(R.id.come_order_detail_tv_seek)
    TextView comeOrderDetailTvSeek;
    @BindView(R.id.come_order_detail_iv_last)
    TextView comeOrderDetailIvLast;
    @BindView(R.id.come_order_detail_rl)
    RelativeLayout comeOrderDetailRl;
    @BindView(R.id.come_order_detail_lv)
    UpLoadListView comeOrderDetailLv;
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
    TextView tvProductNum;
    private MyActivityManager myActivityManager;
    private Order.Result.Rows order;
    private SharedPreferences sp;
    private List<OrderDetail.ResultBean.RowsBean> orderDetails = new ArrayList<>();
    private OrderProductAdapter adapter;
    public Boolean isHasData = true;
    private int pageNo = 1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (adapter == null) {
                rlNotData.setVisibility(View.VISIBLE);
            } else {
                comeOrderDetailLv.completeRefresh(isHasData);
                adapter.notifyDataSetChanged();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_order_detail);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        receiveData();
        initData();
    }

    private void receiveData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        order = (Order.Result.Rows) bundle.getSerializable("orderDetail");
    }

    private void initData() {
        getDatafromServer();
        //返回
        comeOrderDetailIvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //初始化数据
        //添加头部
        addHeaderView();
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        swipeRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                RefreshDatafromServer();

            }
        });

        //加载更多
        comeOrderDetailLv.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {
            @Override
            public void onLoadingMore() {
                pageNo++;
                getDatafromServer();
            }
        });

        //跳转到详情
        comeOrderDetailLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position>0&&position < orderDetails.size()+1) {
                    Intent intent = new Intent(ComeOrderDetailActivity.this, ComeOrderProductDetail.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("orderProduct", orderDetails.get(position-1));
                    intent.putExtras(bundle);
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

    //订单详情
    public void getDatafromServer() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/orderDetail");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("order.id", order.id);
        rp.addBodyParameter("pageNo", pageNo + "");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("ComeOrderDetailActivity", result);
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                OrderDetail orderDetail = gson.fromJson(result, OrderDetail.class);
                Log.e("ComeOrderDetailActivity", orderDetail.toString());
                //设置订单产品数量
                tvProductNum.setText("(" + orderDetail.getResult().getTotal() + ")");
                if (orderDetail.getResult().getTotal() <= orderDetails.size()) {
                    isHasData = false;
                } else {
                    orderDetails.addAll(orderDetail.getResult().getRows());
                    if (adapter == null) {
                        adapter = new OrderProductAdapter();
                        comeOrderDetailLv.setAdapter(adapter);
                    } else {
                        adapter.notifyDataSetChanged();
                    }
                }
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                llLoad.setVisibility(View.GONE);
                rlLoadFail.setVisibility(View.VISIBLE);
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

    @OnClick(R.id.rl_load_fail)//加载失败 重新加载
    public void onClick() {
        rlLoadFail.setVisibility(View.GONE);
        llLoad.setVisibility(View.VISIBLE);
        getDatafromServer();
    }

    public void RefreshDatafromServer() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/orderDetail");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("order.id", order.id);
        rp.addBodyParameter("pageNo", pageNo + "");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("ComeOrderDetailActivity", result);
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                OrderDetail orderDetail = gson.fromJson(result, OrderDetail.class);
                Log.e("ComeOrderDetailActivity", orderDetail.toString());
                //设置订单产品数量
                tvProductNum.setText("(" + orderDetail.getResult().getTotal() + ")");
                if (orderDetail.getResult().getTotal() <= orderDetails.size()) {
                    Toast.makeText(ComeOrderDetailActivity.this, "没有刷新出新的数据", Toast.LENGTH_SHORT).show();
                } else {
                    orderDetails.addAll(0, orderDetail.getResult().getRows());
                    Toast.makeText(ComeOrderDetailActivity.this, "刷新出来" + orderDetail.getResult().getRows().size() + "条数据", Toast.LENGTH_SHORT).show();
                }
                swipeRefreshLayout.setRefreshing(false);
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                llLoad.setVisibility(View.GONE);
                rlLoadFail.setVisibility(View.VISIBLE);
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

    public class OrderProductAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return orderDetails.size();
        }

        @Override
        public Object getItem(int position) {
            return orderDetails.get(position);
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
                convertView = View.inflate(ComeOrderDetailActivity.this, R.layout.item_come_order_detail_product, null);
                viewHolder.order_detail_tv_proCateGory = (TextView) convertView.findViewById(R.id.proCateGory);
                viewHolder.order_detail_ll_proCateGory_ruler = (TextView) convertView.findViewById(R.id.order_detail_ll_proCateGory_ruler);
                viewHolder.come_order_detail_single_price = (TextView) convertView.findViewById(R.id.come_order_detail_single_price);
                viewHolder.come_order_detail_tv_endDateHand = (TextView) convertView.findViewById(R.id.come_order_detail_tv_endDateHand);
                viewHolder.order_detail_tv_note = (TextView) convertView.findViewById(R.id.order_detail_tv_note);
                viewHolder.come_order_detail_tv_num = (TextView) convertView.findViewById(R.id.come_order_detail_tv_num);
                viewHolder.come_order_detail_tv_mine_priority = (TextView) convertView.findViewById(R.id.come_order_detail_tv_mine_priority);
                viewHolder.tv_add_note = (TextView) convertView.findViewById(R.id.tv_add_note);//添加备注
                viewHolder.tv_modify = (TextView) convertView.findViewById(R.id.tv_modify);//编辑
                viewHolder.tv_down_send = (TextView) convertView.findViewById(R.id.tv_down_send);//下发
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            //添加备注
            //编辑订单产品

            //下发产品

            viewHolder.order_detail_tv_proCateGory.setText(orderDetails.get(position).getCompanyCategory().getName());
            viewHolder.order_detail_ll_proCateGory_ruler.setText(orderDetails.get(position).getProductName());

            viewHolder.come_order_detail_single_price.setText(orderDetails.get(position).getPrice());

            viewHolder.come_order_detail_tv_endDateHand.setText(orderDetails.get(position).getDeliveryTime());

            viewHolder.order_detail_tv_note.setText(orderDetails.get(position).getProductDescription());

            viewHolder.come_order_detail_tv_mine_priority.setText(orderDetails.get(position).getCompanyAPriority());
            viewHolder.come_order_detail_tv_num.setText(orderDetails.get(position).getAmount());
            return convertView;
        }
    }

    static class ViewHolder {
        TextView order_detail_tv_proCateGory;
        TextView order_detail_ll_proCateGory_ruler;
        TextView come_order_detail_single_price;
        TextView come_order_detail_tv_endDateHand;
        TextView order_detail_tv_note;
        TextView come_order_detail_tv_num;
        TextView come_order_detail_tv_mine_priority;
        TextView tv_add_note;
        TextView tv_modify;
        TextView tv_down_send;
    }

    //添加头部
    public void addHeaderView() {

        View view = View.inflate(ComeOrderDetailActivity.this, R.layout.layout_header_order_product, null);
        TextView orderDetailRlTvOrderState = (TextView) view.findViewById(R.id.order_detail_rl_tv_orderState);//订单状态
        TextView orderDetailRlLlCompanyName = (TextView) view.findViewById(R.id.order_detail_rl_ll_companyName);//公司名称
        TextView tvOrdera = (TextView) view.findViewById(R.id.tv_ordera);
        TextView tvOrderDate = (TextView) view.findViewById(R.id.tv_orderDate);
        TextView tvEndTime = (TextView) view.findViewById(R.id.tv_end_time);
        TextView tvNote = (TextView) view.findViewById(R.id.tv_note);
        TextView tvContact = (TextView) view.findViewById(R.id.tv_contact);
        TextView tvPhone = (TextView) view.findViewById(R.id.tv_phone);
        TextView tvOrderNumberB = (TextView) view.findViewById(R.id.tv_order_numberB);
        TextView tvAddress = (TextView) view.findViewById(R.id.tv_address);
        tvProductNum = (TextView) view.findViewById(R.id.tv_product_num);


        comeOrderDetailLv.addHeaderView(view);
        orderDetailRlLlCompanyName.setText(order.aCompany.name);
        tvOrdera.setText(order.aOrderNumber);//甲方订单编号
        tvOrderDate.setText(order.takeOrderTime);
        tvEndTime.setText(order.delieverTime);
        tvNote.setText(order.remarks);
        tvContact.setText(order.aCompany.master);
        tvPhone.setText(order.aCompany.phone);
        tvOrderNumberB.setText(order.bOrderNumber);
        tvAddress.setText(order.aCompany.address);
        orderDetailRlTvOrderState.setText(OrderStatuUtils.orderStatus(order.orderStatus));
        //编辑订单


    }
}
