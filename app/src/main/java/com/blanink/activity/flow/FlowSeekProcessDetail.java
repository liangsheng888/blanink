package com.blanink.activity.flow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.RelFlow;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.PriorityUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 查看 工序
 */
public class FlowSeekProcessDetail extends AppCompatActivity {

    @BindView(R.id.tv_set)
    TextView tvSet;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.tv_amount)
    TextView tvAmount;
    @BindView(R.id.tv_priority)
    TextView tvPriority;
    @BindView(R.id.tv_isPublic)
    TextView tvIsPublic;
    @BindView(R.id.tv_note)
    TextView tvNote;
    @BindView(R.id.ll)
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_seek_detail);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        loadProcess(getIntent().getStringExtra("flowId"),getIntent().getStringExtra("processId"));
    }

    private void loadProcess(String flowId,String processId) {
        RequestParams rp=new RequestParams(NetUrlUtils.NET_URL+"process/getRelFlowProcess");
        rp.addBodyParameter("flow.id",flowId);
        rp.addBodyParameter("process.id",processId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
             Gson gson=new Gson();
                RelFlow rel= gson.fromJson(result, RelFlow.class);
                tvAmount.setText(rel.getResult().getTarget()+"");
                tvIsPublic.setText(rel.getResult().getIsPublic().equals("0")?"公开":"不公开");
                tvPriority.setText(PriorityUtils.getPriority(rel.getResult().getProcessPriority()));
                tvNote.setText(rel.getResult().getRemarks());
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
}
