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
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.ComeOder;
import com.blanink.pojo.OrderProductSpecifications;
import com.blanink.utils.DateUtils;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.OrderStateUtils;
import com.blanink.utils.XUtilsImageUtils;
import com.blanink.view.UpLoadListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 订单搜索内容
 */
public class OrderSeekContent extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    @BindView(R.id.lv)
    UpLoadListView lv;
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
    private String aCompanyId;
    private String bCompanyId;
    private String productName;
    private String aOrderNumber;
    private String bOrderNumber;
    private String companyCategoryId;
    private String bCompanyOrderOwnerUserId;
    private String orderProductStatus;
    private String source;
    private SharedPreferences sp;
    private MyActivityManager instance;
    private List<ComeOder.ResultBean.RowsBean> rowsList = new ArrayList<>();
    List<OrderProductSpecifications> orderProductSpecificationsList=new ArrayList<>();
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
    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_seek_content);
        ButterKnife.bind(this);
        instance = MyActivityManager.getInstance();
        instance.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        aCompanyId = intent.getStringExtra("aCompanyId");
        bCompanyId = intent.getStringExtra("bCompanyId");
        productName = intent.getStringExtra("productName");
        aOrderNumber = intent.getStringExtra("aOrderNumber");
        bOrderNumber = intent.getStringExtra("bOrderNumber");
        companyCategoryId = intent.getStringExtra("companyCategoryId");
        bCompanyOrderOwnerUserId = intent.getStringExtra("bCompanyOrderOwnerUserId");
        orderProductStatus = intent.getStringExtra("orderProductStatus");
        source = intent.getStringExtra("source");
        flag = intent.getStringExtra("flag");
        String orderProductSpecificationsListJson = intent.getStringExtra("orderProductSpecificationsList");
        orderProductSpecificationsList = new Gson().fromJson(orderProductSpecificationsListJson, new TypeToken<List<OrderProductSpecifications>>() {
        }.getType());
        Log.e("ComeOrder",orderProductSpecificationsList.toString());
        for (OrderProductSpecifications ops : orderProductSpecificationsList) {

        }
        loadData();
        //重新加载
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
                if (position < rowsList.size()) {
                    Intent intent = new Intent(OrderSeekContent.this, ComeOrderProductActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("orderDetail", rowsList.get(position));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }

    private void loadData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/listJson_coming");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("flag", flag);
        rp.addBodyParameter("aCompany.id", aCompanyId);
        rp.addBodyParameter("bCompany.id", bCompanyId);
        rp.addBodyParameter("orderProductList[0].productName", productName);
        rp.addBodyParameter("aOrderNumber", aOrderNumber);
        rp.addBodyParameter("bOrderNumber", bOrderNumber);
        rp.addBodyParameter("orderProductList[0].companyCategory.id", companyCategoryId);
        rp.addBodyParameter("bCompanyOrderOwnerUser.id", bCompanyOrderOwnerUserId);
        rp.addBodyParameter("orderProductList[0].orderProductStatus", orderProductStatus);
        rp.addBodyParameter("orderProductList[0].source", source);
        for (int i=0;i<orderProductSpecificationsList.size();i++){
            rp.addBodyParameter("orderProductList[0].orderProductSpecificationList["+i+"].attributeSearchType",orderProductSpecificationsList.get(i).getAttributeSearchType());
            rp.addBodyParameter("orderProductList[0].orderProductSpecificationList["+i+"].attribute.id", orderProductSpecificationsList.get(i).getAttribute().getId());
            rp.addBodyParameter("orderProductList[0].orderProductSpecificationList["+i+"].attributeValue",orderProductSpecificationsList.get(i).getAttributeValue());
        }

        rp.addBodyParameter("pageSize", "10");
        rp.addBodyParameter("pageNo", pageNo+"");
        rp.addBodyParameter("sortOrder", "asc");
        //  orderProductList[0].orderProductSpecificationList[0].attributeSearchType
        //  orderProductList[0].orderProductSpecificationList[0].attribute.id
        //  orderProductList[0].orderProductSpecificationList[0].attributeValue
        Log.e("OrderSeekContent",NetUrlUtils.NET_URL + "order/listJson_coming?userId="+sp.getString("USER_ID", null)+"&flag=0&" +
                "aCompany.id="+aCompanyId+"&bCompany.id="+bCompanyId+"&orderProductList[0].productName"+productName+"&aOrderNumber="+aOrderNumber
        +"&bOrderNumber="+bOrderNumber+"&orderProductList[0].companyCategory.id="+companyCategoryId+"&bCompanyOrderOwnerUser.id="+bCompanyOrderOwnerUserId
        +"&orderProductList[0].orderProductStatus="+orderProductStatus+"&orderProductList[0].source="+source+"&pageSize=10"+"&pageNo="+pageNo+"&sortOrder=asc");

        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e("OrderSeekContent", result);
                Gson gson=new Gson();
                ComeOder  order=gson.fromJson(result, ComeOder.class);
                Log.e("OrderSeekContent","解析："+ order.toString());
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
                llLoad.setVisibility(View.GONE);
                rlLoadFail.setVisibility(View.VISIBLE);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance.popOneActivity(this);
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
            ComeOder.ResultBean.RowsBean order = rowsList.get(position);
            sparseArray = new SparseArray<>();
            ViewHolder viewHolder = null;
            if (sparseArray.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(OrderSeekContent.this, R.layout.item_comeorder, null);
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
            viewHolder.tv_remark.setText(order.getRemarks());
            GlideUtils.glideImageView(OrderSeekContent.this,viewHolder.iv_log,order.getACompany().getPhoto(),true);
            viewHolder.tv_date.setText(DateUtils.format(DateUtils.stringToDate(order.getCreateDate())));
            viewHolder.tv_state.setText(OrderStateUtils.orderStatus(order.getOrderStatus()));
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
}
