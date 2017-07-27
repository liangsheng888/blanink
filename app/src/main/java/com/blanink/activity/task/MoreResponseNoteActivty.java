package com.blanink.activity.task;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.blanink.pojo.FeedBackingTask;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 更多反馈记录
 */
public class MoreResponseNoteActivty extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.task_response_rl)
    RelativeLayout taskResponseRl;
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
    @BindView(R.id.activity_more_response_note_activty)
    RelativeLayout activityMoreResponseNoteActivty;
    private SharedPreferences sp;
    private String processId;
    private String flowId;
    private CommonAdapter<FeedBackingTask.ResultBean.ProcessFeedbackListBean> commonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_response_note_activty);
        sp=getSharedPreferences("DATA",MODE_PRIVATE);
        ButterKnife.bind(this);
        receiveData();
        initData();
    }

    private void receiveData() {
        Intent intent=getIntent();
        processId = intent.getStringExtra("process.id");
        flowId = intent.getStringExtra("flow.id");
    }

    private void initData() {
        loadData();

    }

    @OnClick({R.id.iv_last, R.id.rl_load_fail})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_last:
                finish();
                break;
            case R.id.rl_load_fail:
                break;
        }
    }

    public void loadData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/listFeedbackingTask");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("process.id", processId);
        rp.addBodyParameter("flow.id", flowId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e("TaskResponse", "我反馈过的:" + result);
                Gson gson = new Gson();
                final FeedBackingTask feedbackingTask = gson.fromJson(result, FeedBackingTask.class);
                Log.e("TaskResponse", "我反馈过的2:" + feedbackingTask.toString());
                commonAdapter = new CommonAdapter<FeedBackingTask.ResultBean.ProcessFeedbackListBean>(MoreResponseNoteActivty.this, feedbackingTask.getResult().getProcessFeedbackList(), R.layout.item_history_note_response) {
                    @Override
                    public void convert(ViewHolder viewHolder,FeedBackingTask.ResultBean.ProcessFeedbackListBean processFeedbackUser, int position) {
                        processFeedbackUser = feedbackingTask.getResult().getProcessFeedbackList().get(position);
                        TextView date = viewHolder.getViewById(R.id.tv_date);
                        TextView tv_master = viewHolder.getViewById(R.id.tv_master);
                        TextView tv_finished = viewHolder.getViewById(R.id.tv_finished);
                        TextView tv_bad = viewHolder.getViewById(R.id.tv_bad);
                        tv_master.setText(processFeedbackUser.getFeedbackUser().getName());
                        date.setText(feedbackingTask.getResult().getProcessFeedbackList().get(position).getCreateDate());
                        tv_finished.setText((feedbackingTask.getResult().getProcessFeedbackList().get(position).getAchieveAmount() + "个"));
                        tv_bad.setText((feedbackingTask.getResult().getProcessFeedbackList().get(position).getFaultAmount() + "个"));
                    }
                };
                lv.setAdapter(commonAdapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
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

}
