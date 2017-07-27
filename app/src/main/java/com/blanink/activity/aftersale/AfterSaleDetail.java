package com.blanink.activity.aftersale;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.adapter.AfterSaleAdapter;
import com.blanink.pojo.AfterSaleHistory;
import com.blanink.pojo.AfterSales;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.UpLoadListView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/***
 * 售后处理记录
 */
public class AfterSaleDetail extends AppCompatActivity {

    @BindView(R.id.after_sale_queue_iv_last)
    TextView afterSaleQueueIvLast;
    @BindView(R.id.rl_after_sale_queue)
    RelativeLayout rlAfterSaleQueue;
    @BindView(R.id.lv_after_sale)
    UpLoadListView lvAfterSale;
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
    private AfterSaleAdapter adapter;
    private List<AfterSaleHistory.ResultBean.RowsBean> rowsBeanList = new ArrayList<>();
    private boolean isHasData = true;
    private int pageNo = 1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lvAfterSale.completeRefresh(isHasData);
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sale_detail);
        sp=getSharedPreferences("DATA",MODE_PRIVATE);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        loadData();
        afterSaleQueueIvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lvAfterSale.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {
            @Override
            public void onLoadingMore() {
                pageNo++;
                loadData();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }

    public void loadData() {
        String url = NetUrlUtils.NET_URL + "afterSales/getAfterSalesHandleList";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("currentUser.id", sp.getString("USER_ID", null))
                .add("afterSales.id", getIntent().getStringExtra("id")).add("pageNo", pageNo + "").build();
        Request request = new Request.Builder().post(body).url(url).build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        llLoad.setVisibility(View.GONE);
                        rlLoadFail.setVisibility(View.VISIBLE);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final AfterSaleHistory af = gson.fromJson(result, AfterSaleHistory.class);

                if (af.getResult().getRows().size() == 0) {
                    isHasData = false;
                } else {
                    rowsBeanList.addAll(af.getResult().getRows());
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        llLoad.setVisibility(View.GONE);
                        if (af.getResult().getTotal() == 0) {
                            rlNotData.setVisibility(View.VISIBLE);
                            tvNot.setText("暂无售后需求");
                        }
                        if (adapter == null) {
                            adapter = new AfterSaleAdapter(AfterSaleDetail.this, rowsBeanList);
                            lvAfterSale.setAdapter(adapter);
                        } else {
                            adapter.notifyDataSetChanged();
                        }
                        handler.sendEmptyMessage(0);
                    }
                });

            }
        });
    }
}
