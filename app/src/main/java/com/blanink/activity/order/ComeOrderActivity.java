package com.blanink.activity.order;

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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.activity.MainActivity;
import com.blanink.pojo.Order;
import com.blanink.utils.ExampleUtil;
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
 * 来单列表
 */
public class ComeOrderActivity extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.come_order_iv_last)
    TextView comeOrderIvLast;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.rl_seek)
    RelativeLayout rlSeek;
    @BindView(R.id.unsorted_product)
    Spinner unsortedProduct;
    @BindView(R.id.rl_sorted)
    TextView rlSorted;
    @BindView(R.id.come_order_handed_product)
    TextView comeOrderHandedProduct;
    @BindView(R.id.rl_unsorted)
    LinearLayout rlUnsorted;
    @BindView(R.id.lv)
    UpLoadListView lv;
    private final static int BACK_TASK = 0;
    @BindView(R.id.rl_not_data)
    RelativeLayout rlNotData;
    @BindView(R.id.ll_load)
    LinearLayout llLoad;
    @BindView(R.id.rl_load_fail)
    RelativeLayout rlLoadFail;
    @BindView(R.id.rl_load)
    RelativeLayout rlLoad;
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
        setContentView(R.layout.activity_come_order);
        ButterKnife.bind(this);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }


    private void initData() {
        //初始化数据
        loadData();
        //返回task
        comeOrderIvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComeOrderActivity.this, MainActivity.class);
                intent.putExtra("DIRECT", BACK_TASK);
                startActivity(intent);
                finish();
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
        //添加订单
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComeOrderActivity.this, ComeOrderNewAddInfoActivity.class);
                startActivity(intent);
            }
        });
        //订单详情
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < rowsList.size()) {
                    Intent intent = new Intent(ComeOrderActivity.this, ComeOrderDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("orderDetail", rowsList.get(position));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(ComeOrderActivity.this, MainActivity.class);
        intent.putExtra("DIRECT", BACK_TASK);
        startActivity(intent);
        myActivityManager.popOneActivity(this);
    }

    //访问服务器
    public void loadData() {
        if (!ExampleUtil.isConnected(ComeOrderActivity.this)) {
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

    @OnClick(R.id.rl_load_fail)
    public void onClick() {
        rlLoadFail.setVisibility(View.GONE);
        llLoad.setVisibility(View.VISIBLE);
        loadData();
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
                convertView = View.inflate(ComeOrderActivity.this, R.layout.item_comeorder, null);
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
            Log.e("ComeOrderActivity","标题:");
            viewHolder.tv_company.setText(order.aCompany.name);
            //产品类
            viewHolder.tv_title.setText(order.name==null?"无标题":order.name);
            viewHolder.tv_date.setText(order.takeOrderTime);
            viewHolder.tv_master.setText(order.aCompany.master);
            viewHolder.tv_state.setText(OrderStatuUtils.orderStatus(order.orderStatus));
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
