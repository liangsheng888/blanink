package com.blanink.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.order.OrderSeek;
import com.blanink.activity.task.WorkResponseHistoryDetail;
import com.blanink.adapter.ResponseAdapter;
import com.blanink.pojo.ResponseHistory;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.UpLoadListView;
import com.google.gson.Gson;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.header.StoreHouseHeader;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

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
 * 工作记录
 */
public class WorkResponseHistory extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.receive)
    RelativeLayout receive;
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
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    private SharedPreferences sp;
    private List<ResponseHistory.ResultBean.RowsBean> rows = new ArrayList<>();
    private boolean isHasData = true;
    private ResponseAdapter adapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv.completeRefresh(isHasData);
            if (adapter == null) {
                rlNotData.setVisibility(View.VISIBLE);
            } else {
                if (adapter.getCount() == 0) {
                    rlNotData.setVisibility(View.VISIBLE);
                }
                adapter.notifyDataSetChanged();
            }
        }
    };
    private int pageNo = 1;
    private EditText etSeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_response_history);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        loadData();
        addHeaderView();
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
        //设置 Header 为 水波
        WaveSwipeHeader waveSwipeHeader= new WaveSwipeHeader(this);
        waveSwipeHeader.setPrimaryColors(getResources().getColor(R.color.colorOrange));
        waveSwipeHeader.setColorSchemeColors(Color.WHITE, Color.WHITE);
        smartRefreshLayout.setRefreshHeader(waveSwipeHeader);
        smartRefreshLayout.setEnableLoadmore(false);//是否开启加上拉加载功能（默认true）
        smartRefreshLayout.setEnableHeaderTranslationContent(false);//拖动Header的时候是否同时拖动内容（默认true）
        smartRefreshLayout.setDisableContentWhenRefresh(true);//是否在刷新的时候禁止内容的一切手势操作（默认false）
//设置 Footer 为 球脉冲
       // smartRefreshLayout.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
        //刷新
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNo=1;
                rows.clear();
                loadData();
            }
        });

       /* smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
            }

        });*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < rows.size()+1) {
                    Intent intent = new Intent(WorkResponseHistory.this, WorkResponseHistoryDetail.class);
                    intent.putExtra("Detail", rows.get(position-1));
                    startActivity(intent);
                }
            }
        });
    }

    public void loadData() {
        //http://127.0.0.1:8080/blanink-api/processFeedback/getOfficeList?
        // company.id=f541afa391974409ba680e9bd9a394fd&userId=d6c8e9bc4c2b476ba84b962c27882f41
        String url = NetUrlUtils.NET_URL + "processFeedback/getOfficeList";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("company.id", sp.getString("COMPANY_ID", null))
                .add("userId", sp.getString("USER_ID", null))
                .add("pageNo", pageNo + "")
                .build();
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
                final ResponseHistory rh = gson.fromJson(result, ResponseHistory.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        smartRefreshLayout.finishRefresh();
                        llLoad.setVisibility(View.GONE);
                        if (rh.getResult().getTotal() == 0) {
                            rlNotData.setVisibility(View.VISIBLE);//没有数据
                            tvNot.setText("暂无员工反馈");
                        }
                        if (rh.getResult().getRows().size() == 0) {
                            isHasData = false;
                        } else {
                            rows.addAll(rh.getResult().getRows());
                            if (adapter == null) {
                                adapter = new ResponseAdapter(WorkResponseHistory.this, rows);
                                lv.setAdapter(adapter);
                            } else {
                                adapter.notifyDataSetChanged();
                            }
                        }
                        handler.sendEmptyMessage(0);
                    }
                });
            }
        });
    }
    public void addHeaderView() {
        View view = View.inflate(WorkResponseHistory.this, R.layout.layout_header_order, null);
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
                    Intent intent = new Intent(WorkResponseHistory.this, WorkResponseHistorySeek.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    etSeek.setCursorVisible(false);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        etSeek.clearFocus();
        etSeek.setCursorVisible(false);
    }
}
