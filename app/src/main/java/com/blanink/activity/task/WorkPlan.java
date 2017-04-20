package com.blanink.activity.task;

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

import com.blanink.R;
import com.blanink.activity.MainActivity;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.ProcessFeedback;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.MyViewPager;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 任务表
 */
public class WorkPlan extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.rl_workStepQueue)
    RelativeLayout rlWorkStepQueue;
    @BindView(R.id.myViewPager)
    MyViewPager myViewPager;
    @BindView(R.id.rl_work_plan)
    RelativeLayout rlWorkPlan;
    @BindView(R.id.workStepQueue_lv_taskQueue)
    ListView workStepQueueLvTaskQueue;
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
    @BindView(R.id.activity_work_plan)
    RelativeLayout activityWorkPlan;
    private MyActivityManager myActivityManager;
    private List<Integer> drawableLists;
    private SharedPreferences sp;
    private CommonAdapter<ProcessFeedback.Result> commonAdapter;
    private List<ProcessFeedback.Result> processFeedbackList = new ArrayList<>();
    private static final int BACK_TASK=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_plan);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        loadDatafromServer();
        drawableLists = new ArrayList<>();
        drawableLists.add(R.drawable.guanggao);
        drawableLists.add(R.drawable.guanggao1);
        drawableLists.add(R.drawable.guanggao2);
        drawableLists.add(R.drawable.guanggao3);

        myViewPager.pictureRoll(drawableLists);

        workStepQueueLvTaskQueue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(WorkPlan.this, WorkPlanDetail.class);
                intent.putExtra("processId", processFeedbackList.get(position).id);
                startActivity(intent);
            }
        });
    }

    @OnClick({R.id.iv_last, R.id.rl_load_fail})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_last://返回
                finish();
                break;
            case R.id.rl_load_fail://重新加载
                llLoad.setVisibility(View.VISIBLE);
                rlLoadFail.setVisibility(View.GONE);
                loadDatafromServer();
                break;
        }
    }

    public void loadDatafromServer() {
        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "workPlan/listProcess");
        requestParams.addBodyParameter("userId", sp.getString("USER_ID", null));
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e("WorkPlan","result:"+ result);
                Gson gson = new Gson();
                ProcessFeedback pf = gson.fromJson(result, ProcessFeedback.class);
                if (pf.result.size() == 0) {
                    rlNotData.setVisibility(View.VISIBLE);
                }
                Log.e("WorkPlan","解析后:"+ pf.toString());
                processFeedbackList.addAll(pf.result);
                if (commonAdapter == null) {
                    commonAdapter = new CommonAdapter<ProcessFeedback.Result>(WorkPlan.this, processFeedbackList, R.layout.item_work_plan_queue) {
                        @Override
                        public void convert(ViewHolder viewHolder, ProcessFeedback.Result processFeedback, int position) {
                            processFeedback = processFeedbackList.get(position);
                            TextView tv = viewHolder.getViewById(R.id.tv_process);
                            tv.setText(processFeedback.name);
                        }
                    };
                    workStepQueueLvTaskQueue.setAdapter(commonAdapter);
                } else {
                    commonAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                llLoad.setVisibility(View.GONE);
                rlLoadFail.setVisibility(View.VISIBLE);
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
        myActivityManager.popOneActivity(this);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("DIRECT", BACK_TASK);
        startActivity(intent);
    }
}
