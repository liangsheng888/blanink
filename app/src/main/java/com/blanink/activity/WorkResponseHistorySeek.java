package com.blanink.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.task.WorkResponseHistoryDetail;
import com.blanink.adapter.ResponseAdapter;
import com.blanink.pojo.ResponseHistory;
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

public class WorkResponseHistorySeek extends AppCompatActivity {


    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.receive)
    RelativeLayout receive;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.et_seek)
    EditText etSeek;
    @BindView(R.id.rl_seek)
    RelativeLayout rlSeek;
    @BindView(R.id.ll_seek)
    LinearLayout llSeek;
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
    private String etCotent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_response_history_seek);
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
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < rows.size()) {
                    Intent intent = new Intent(WorkResponseHistorySeek.this, WorkResponseHistoryDetail.class);
                    intent.putExtra("Detail", rows.get(position));
                    startActivity(intent);
                }
            }
        });

        etSeek.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                etCotent = etSeek.getText().toString().trim();
                rows.clear();
                isHasData=true;
                rlNotData.setVisibility(View.GONE);
                if (TextUtils.isEmpty(etCotent)) {
                    return;
                }
                loadData(etCotent);
            }

        });
        lv.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {
            @Override
            public void onLoadingMore() {
                pageNo++;
                loadData(etCotent);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    public void loadData(String etCotent) {
        //http://127.0.0.1:8080/blanink-api/processFeedback/getOfficeList?
        // company.id=f541afa391974409ba680e9bd9a394fd&userId=d6c8e9bc4c2b476ba84b962c27882f41
        String url = NetUrlUtils.NET_URL + "processFeedback/getOfficeList";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("company.id", sp.getString("COMPANY_ID", null))
                .add("userId", sp.getString("USER_ID", null))

                .add("pageNo", pageNo + "")
                .add("mobileSearch", etCotent)
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
                        llLoad.setVisibility(View.GONE);
                        if (rh.getResult().getTotal() == 0) {
                            rlNotData.setVisibility(View.VISIBLE);//没有数据
                            tvNot.setText("没有找到你要搜索的数据");
                        }else {
                            rlNotData.setVisibility(View.GONE);//没有数据

                        }
                        if (rh.getResult().getRows().size() == 0) {
                            isHasData = false;
                        } else {
                            rows.addAll(rh.getResult().getRows());
                            if (adapter == null) {
                                adapter = new ResponseAdapter(WorkResponseHistorySeek.this, rows);
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
}
