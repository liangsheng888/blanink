package com.blanink.activity.flow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.FlowData;
import com.blanink.pojo.FlowDetail;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 使用本流程
 */
public class FlowUseTheFlow extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order_detail_rl)
    RelativeLayout comeOrderDetailRl;
    @BindView(R.id.activity_flow_use_the_flow)
    RelativeLayout activityFlowUseTheFlow;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        setContentView(R.layout.activity_flow_use_the_flow);
        ButterKnife.bind(this);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        receiveData();
        initData();
    }

    private void receiveData() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
    }

    private void initData() {
        loadData();
    }

    @Override
    protected void onDestroy() {
        myActivityManager.popOneActivity(this);
        super.onDestroy();
    }

    public void loadData() {
        if (!ExampleUtil.isConnected(this)) {
            Toast.makeText(this, "请检查你的网络！", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "flow/getCommon");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("id", id + "");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("FlowUseTheFlow", result);
                Gson gson = new Gson();
                FlowDetail flowDetail = gson.fromJson(result, FlowDetail.class);
                String flowData = flowDetail.getResult().getFlowData();
                Log.e("FlowUseTheFlow", "flowData:" + flowData);
                FlowData flow = gson.fromJson(flowData, FlowData.class);
                Log.e("FlowUseTheFlow", "flow:" + flow.toString());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

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

    @OnClick(R.id.iv_last)
    public void onClick() {
        finish();
    }


}
