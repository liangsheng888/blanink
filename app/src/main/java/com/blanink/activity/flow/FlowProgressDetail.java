package com.blanink.activity.flow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.FlowProgress;
import com.blanink.utils.FlowProcessStatusUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.SysConstants;
import com.blanink.view.RoundProgressBar;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FlowProgressDetail extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    @BindView(R.id.lv)
    ListView lv;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_progress_detail);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        postAsynOkHttp();
        //
        rlLoadFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlLoadFail.setVisibility(View.GONE);
                llLoad.setVisibility(View.VISIBLE);
                postAsynOkHttp();
            }
        });
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void postAsynOkHttp() {
        String url = "";
        OkHttpClient okHttpClient = new OkHttpClient();

        if ("FLOW_SORTED".equals(getIntent().getStringExtra("flag"))) {
            url = NetUrlUtils.NET_URL + "flow/getOwnCompanyProgress";
        } else {
            url = NetUrlUtils.NET_URL + "flow/getProgress";
        }

        FormBody formBody = new FormBody.Builder()
                .add("id", getIntent().getStringExtra("flowId"))
                .add("currentUser.id", sp.getString("USER_ID", null))
                .add("notOwnCompany",getIntent().getStringExtra("notOwnCompany")==null?"":getIntent().getStringExtra("notOwnCompany"))
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Log.e("FlowProgress", url + "?id=" + getIntent().getStringExtra("flowId") + "&currentUser.id=" + sp.getString("USER_ID", null));
        okHttpClient.newCall(request).enqueue(new Callback() {
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
                String str = response.body().string();
                Gson gson = new Gson();
                final FlowProgress flowProgress = gson.fromJson(str, FlowProgress.class);
                Log.e("FlowProgress",flowProgress.toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if ("00000".equals(flowProgress.getErrorCode())) {
                            llLoad.setVisibility(View.GONE);
                            if (flowProgress.getResult().size() == 0) {
                                rlNotData.setVisibility(View.VISIBLE);
                                tvNot.setText("流程暂无进度");
                            } else {
                                rlNotData.setVisibility(View.GONE);

                            }
                            lv.setAdapter(new CommonAdapter<FlowProgress.ResultBean>(FlowProgressDetail.this, flowProgress.getResult(), R.layout.item_flow_progress) {
                                @Override
                                public void convert(ViewHolder viewHolder, FlowProgress.ResultBean resultBean, int position) {
                                    TextView processName = viewHolder.getViewById(R.id.tv_process);
                                    TextView progress = viewHolder.getViewById(R.id.tv_progress);
                                    TextView tv_state = viewHolder.getViewById(R.id.tv_state);
                                    TextView tv_bad = viewHolder.getViewById(R.id.tv_faultAmount);
                                    TextView bad = viewHolder.getViewById(R.id.bad);
                                     RoundProgressBar rb=viewHolder.getViewById(R.id.pb_progress);
                                    rb.setMax(flowProgress.getResult().get(position).getTarget());
                                    rb.setRoundWidth(5.0f);
                                    rb.setTextColor(getResources().getColor(R.color.colorAccent));
                                    rb.setCricleColor(getResources().getColor(R.color.colorBackGround));
                                    rb.setCricleProgressColor(getResources().getColor(R.color.colorAccent));
                                    rb.setProgress(flowProgress.getResult().get(position).getTotalCompletedQuantity());
                                    processName.setText(flowProgress.getResult().get(position).getProcess().getName());
                                    progress.setText(flowProgress.getResult().get(position).getTotalCompletedQuantity() + "/" + flowProgress.getResult().get(position).getTarget());
                                    tv_state.setText(FlowProcessStatusUtils.getProcessStatus(flowProgress.getResult().get(position).getStatus()));
                                    if (flowProgress.getResult().get(position).getLatestFeedback() != null) {
                                        tv_bad.setText(flowProgress.getResult().get(position).getLatestFeedback().getFaultAmount() + "");
                                    }else {
                                        bad.setVisibility(View.GONE);
                                        tv_bad.setVisibility(View.GONE);
                                    }
                                }
                            });
                            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(FlowProgressDetail.this, FlowProgressDetailHistory.class);
                                    intent.putExtra("flowId", flowProgress.getResult().get(position).getFlow().getId());
                                    intent.putExtra("processId", flowProgress.getResult().get(position).getProcess().getId());
                                    startActivity(intent);
                                }
                            });
                        } else {
                            llLoad.setVisibility(View.GONE);
                            Toast.makeText(FlowProgressDetail.this, "加载失败", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }
        });
    }
}
