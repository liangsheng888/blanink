package com.blanink.activity.order;

import android.content.BroadcastReceiver;
import android.content.Context;
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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.GoOrderDown;
import com.blanink.utils.DateUtils;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.OrderStateUtils;
import com.blanink.utils.SysConstants;
import com.blanink.utils.XUtilsImageUtils;
import com.blanink.view.RefreshListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 收货列表
 */
public class ReceiveGoods extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.receive)
    RelativeLayout receive;
    @BindView(R.id.lv)
    RefreshListView lv;
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
    private SharedPreferences sp;
    private int pageNo = 0;
    private boolean isHasData = true;
    private List<GoOrderDown.ResultBean.RowsBean> rowsList = new ArrayList<>();
    private MyAdapter adapter;
    private SparseArray<View> sparseArray;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv.completeRefresh(isHasData);

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

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_goods);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        loadData();
        rlLoadFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlLoadFail.setVisibility(View.GONE);
                llLoad.setVisibility(View.VISIBLE);
                loadData();
            }
        });
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //加载更多，刷新
        lv.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onPullRefresh() {
                pageNo = 1;
                RefreshData();
            }

            @Override
            public void onLoadingMore() {
                pageNo++;
                loadData();
            }
        });
        //详情
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if ( position < rowsList.size() + 1) {
                    Intent intent = new Intent(ReceiveGoods.this, ReceiveGoodsProduct.class);
                    intent.putExtra("orderId",rowsList.get(position-1).getId());
                    startActivity(intent);
                }
            }
        });
    }

    //访问服务器
    public void loadData() {
        if (!ExampleUtil.isConnected(ReceiveGoods.this)) {
            llLoad.setVisibility(View.GONE);
            Toast.makeText(ReceiveGoods.this, "请检查你的网络！", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/listJson_going");
        rp.addBodyParameter("flag", "2");
        rp.addBodyParameter("aCompany.id", sp.getString("COMPANY_ID", null));
        rp.addBodyParameter("pageSize", "10");
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("sortOrder", "asc");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e("ComeOrderActivity", result);
                Gson gson = new Gson();
                GoOrderDown order = gson.fromJson(result, GoOrderDown.class);
                Log.e("ComeOrderActivity", "order;" + order.toString());
                if (order.getResult().getTotal() <= rowsList.size()) {
                    isHasData = false;
                } else {
                    rlNotData.setVisibility(View.GONE);
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


    private void RefreshData() {
        if (!ExampleUtil.isConnected(ReceiveGoods.this)) {
            llLoad.setVisibility(View.GONE);
            Toast.makeText(ReceiveGoods.this, "请检查你的网络！", Toast.LENGTH_SHORT).show();
            return;
        }

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/listJson_going");
        rp.addBodyParameter("aCompany.id", sp.getString("COMPANY_ID", null));
        rp.addBodyParameter("flag", "2");
        rp.addBodyParameter("pageSize", "10");
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("sortOrder", "asc");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e("ComeOrderActivity", result);
                Gson gson = new Gson();
                rowsList.clear();
                GoOrderDown order = gson.fromJson(result, GoOrderDown.class);
                Log.e("ComeOrderActivity", "order;" + order.toString());

                rowsList.addAll(order.getResult().getRows());
                Toast.makeText(ReceiveGoods.this, "已刷新", Toast.LENGTH_SHORT).show();

                handler.sendEmptyMessage(0);//通知ui界面更新
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(ReceiveGoods.this, "服务器异常", Toast.LENGTH_SHORT).show();
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
        public View getView(int position, View convertView, ViewGroup parent) {
            final GoOrderDown.ResultBean.RowsBean order = rowsList.get(position);
            sparseArray = new SparseArray<>();
            ViewHolder viewHolder = null;
            if (sparseArray.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(ReceiveGoods.this, R.layout.item_receive, null);
                viewHolder.tv_company = (TextView) convertView.findViewById(R.id.tv_company);
                viewHolder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);
                viewHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
                viewHolder.tv_remark = (TextView) convertView.findViewById(R.id.tv_remark);
                viewHolder.tv_modify = (TextView) convertView.findViewById(R.id.tv_modify);
                viewHolder.iv_log = (ImageView) convertView.findViewById(R.id.iv_log);
                convertView.setTag(viewHolder);
                sparseArray.put(position, convertView);
            } else {
                convertView = sparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            Log.e("ComeOrderActivity", "标题:");
            viewHolder.tv_company.setText(order.getBCompany().getName());
            //产品类
            viewHolder.tv_date.setText(DateUtils.format(DateUtils.stringToDate(order.getCreateDate())));
            viewHolder.tv_state.setText(OrderStateUtils.orderStatus(order.getOrderStatus()));
            viewHolder.tv_remark.setText(order.getRemarks());
            GlideUtils.glideImageView(ReceiveGoods.this,viewHolder.iv_log, order.getBCompany().getPhoto(), true);
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

}
