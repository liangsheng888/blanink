package com.blanink.activity.flow;

import android.app.Dialog;
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
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.FlowSort;
import com.blanink.utils.DateUtils;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.OrderProductStateUtils;
import com.blanink.utils.StringToListUtils;
import com.blanink.utils.XUtilsImageUtils;
import com.blanink.view.LoadingDialog;
import com.blanink.view.UpLoadListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/****
 * 已派流程 产品列表
 */
public class FlowSortCompleted extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order_detail_rl)
    RelativeLayout comeOrderDetailRl;
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
    private MyActivityManager instance;
    private SharedPreferences sp;
    private Integer pageNo = 1;
    private List<FlowSort.ResultBean.RowsBean> rowsBeanList = new ArrayList<>();
    private boolean isHasData = true;
    private OrderProductAdapter adapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv.completeRefresh(isHasData);
            if (adapter != null) {
                Log.e("Fow", "界面刷新了");
                adapter.notifyDataSetChanged();
            } else {
                rlNotData.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_sort_completed);
        ButterKnife.bind(this);
        instance = MyActivityManager.getInstance();
        instance.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        loadData();
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
        //刷新
        //刷新
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
                pageNo = 1;
                refreshData();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("FlowSort", "点击了" + position + "----" + rowsBeanList.get(position).toString());
                Intent intent = new Intent(FlowSortCompleted.this, FlowSortCompletedProductDetail.class);
                if (rowsBeanList.get(position).getOrderProduct() != null) {
                    intent.putExtra("productId", rowsBeanList.get(position).getOrderProduct().getId());
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable("orderProduct", rowsBeanList.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance.popOneActivity(this);
    }

    public void refreshData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "flow/sortCompletedList");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        Log.e("FlowSort", NetUrlUtils.NET_URL + "flow/sortCompletedList?userId=" + sp.getString("USER_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();
                FlowSort flow = gson.fromJson(result, FlowSort.class);
                rowsBeanList.clear();

                rowsBeanList.addAll(flow.getResult().getRows());
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

    public void loadData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "flow/sortCompletedList");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        Log.e("@@@@", NetUrlUtils.NET_URL + "flow/sortCompletedList?userId=" + sp.getString("USER_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e("@@@@", result);

                Gson gson = new Gson();
                FlowSort flow = gson.fromJson(result, FlowSort.class);
                if (flow.getResult().getRows().size() == 0) {
                    isHasData = false;
                } else {
                    rowsBeanList.addAll(flow.getResult().getRows());
                    if (adapter == null) {
                        adapter = new OrderProductAdapter();
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
                rlLoadFail.setVisibility(View.VISIBLE);
                Log.e("@@@@", ex.toString());

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
            return rowsBeanList.size();
        }

        @Override
        public Object getItem(int position) {
            return rowsBeanList.get(position);
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
                convertView = View.inflate(FlowSortCompleted.this, R.layout.item_come_order_detail_product, null);
                viewHolder.order_product_state = (TextView) convertView.findViewById(R.id.order_product_state);
                viewHolder.come_order_detail_single_price = (TextView) convertView.findViewById(R.id.come_order_detail_single_price);
                viewHolder.come_order_detail_tv_endDateHand = (TextView) convertView.findViewById(R.id.come_order_detail_tv_endDateHand);
                viewHolder.come_order_detail_tv_num = (TextView) convertView.findViewById(R.id.come_order_detail_tv_num);
                viewHolder.tv_product_name = (TextView) convertView.findViewById(R.id.tv_product_name); //
                viewHolder.proCateGory = (TextView) convertView.findViewById(R.id.proCateGory);
                viewHolder.iv=(ImageView)convertView.findViewById(R.id.iv);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            //添加备注
            //编辑订单产品

            //下发产品
            if (rowsBeanList.get(position).getOrderProduct() != null) {
                viewHolder.come_order_detail_single_price.setText(rowsBeanList.get(position).getOrderProduct().getPrice());

                viewHolder.come_order_detail_tv_endDateHand.setText(rowsBeanList.get(position).getOrderProduct().getDeliveryTime());

                viewHolder.come_order_detail_tv_num.setText(rowsBeanList.get(position).getOrderProduct().getAmount());
                String orderProductState = OrderProductStateUtils.orderProductStatus(rowsBeanList.get(position).getOrderProduct().getOrderProductStatus());
                viewHolder.order_product_state.setText(orderProductState);
                viewHolder.proCateGory.setText(rowsBeanList.get(position).getOrderProduct().getCompanyCategory().getName());
                viewHolder.tv_product_name.setText(rowsBeanList.get(position).getOrderProduct().getProductName());
                GlideUtils.glideImageView(FlowSortCompleted.this,viewHolder.iv,rowsBeanList.get(position).getOrderProduct().getCompanyCategory().getCompany().getPhoto(),true);

            }
            return convertView;
        }
    }

    static class ViewHolder {
        TextView order_product_state;//订单状态
        TextView come_order_detail_single_price;//单价
        TextView come_order_detail_tv_endDateHand;//交货时间
        TextView come_order_detail_tv_num;//数量
        TextView proCateGory;//产品类
        TextView tv_product_name;//产品规格
        public ImageView iv;
    }

}
