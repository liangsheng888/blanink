package com.blanink.activity.order;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.PurchaseProduct;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.StringToListUtils;
import com.blanink.utils.XUtilsImageUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 去单的来单 采购记录
 */
public class GoOrderAddProductHistory extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order_detail_rl)
    RelativeLayout comeOrderDetailRl;
    @BindView(R.id.lv)
    ListView lv;
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
    private List<PurchaseProduct.ResultBean> purList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_order_add_product_history);
        instance = MyActivityManager.getInstance();
        instance.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        loadHistory();
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
                loadHistory();
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rlNotData.setVisibility(View.GONE);
                purList.clear();
                loadHistory();

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance.popOneActivity(this);
    }

    public void loadHistory() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/go_preAddOrder_lists");
        rp.addBodyParameter("companyId", sp.getString("COMPANY_ID", null));
        rp.addBodyParameter("type", "1");
        rp.addBodyParameter("orderProdId", getIntent().getStringExtra("orderProductId"));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(final String result) {
                llLoad.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
                Gson gson = new Gson();
                final PurchaseProduct pur = gson.fromJson(result, PurchaseProduct.class);
                if(pur.getResult().size()==0){
                    rlNotData.setVisibility(View.VISIBLE);
                }else {
                    rlNotData.setVisibility(View.GONE);
                }
                purList.addAll(pur.getResult());
                lv.setAdapter(new CommonAdapter<PurchaseProduct.ResultBean>(GoOrderAddProductHistory.this, purList, R.layout.item_purchase_product) {
                    @Override
                    public void convert(ViewHolder viewHolder, PurchaseProduct.ResultBean resultBean, int position) {
                        resultBean = purList.get(position);
                        TextView tv_product_category = viewHolder.getViewById(R.id.tv_product_category);


                        ImageView iv = viewHolder.getViewById(R.id.iv);
                        TextView tv_time = viewHolder.getViewById(R.id.tv_time);
                        TextView tv_product_name = viewHolder.getViewById(R.id.tv_product_name);
                        TextView tv_price = viewHolder.getViewById(R.id.tv_price);
                        TextView tv_amount = viewHolder.getViewById(R.id.tv_amount);
                        if (resultBean.getImages() != null) {
                            XUtilsImageUtils.display(iv, StringToListUtils.stringToList(resultBean.getImages(), "\\|").get(0));
                        }
                        tv_time.setText(resultBean.getCreateDate());
                        tv_product_name.setText(resultBean.getProductName());
                        tv_amount.setText(resultBean.getAmount()+"");
                        tv_price.setText(resultBean.getPrice());
                        tv_product_category.setText(resultBean.getCompanyCategory().getName());
                    }
                });
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                llLoad.setVisibility(View.GONE);
                rlLoadFail.setVisibility(View.VISIBLE);
                Log.e("GoOrder",ex.toString());
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
