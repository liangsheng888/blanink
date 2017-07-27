package com.blanink.activity.task;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
 * 任务 反馈列表
 */
public class TaskResponseProcessQueue extends AppCompatActivity {

    private static final int BACK_TASK = 0;
    @BindView(R.id.workStepQueue_iv_last)
    TextView workStepQueueIvLast;
    @BindView(R.id.rl_workStepQueue)
    RelativeLayout rlWorkStepQueue;
    @BindView(R.id.myViewPager)
    MyViewPager myViewPager;
    @BindView(R.id.rl_task)
    RelativeLayout rlTask;
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
    private MyActivityManager myActivityManager;
    private List<Integer> drawableLists;
    private SharedPreferences sp;
    private CommonAdapter<ProcessFeedback.Result> commonAdapter;
    private List<ProcessFeedback.Result> processFeedbackList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_step_queue);
        ButterKnife.bind(this);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
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
        workStepQueueIvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskResponseProcessQueue.this, MainActivity.class);
                intent.putExtra("DIRECT", BACK_TASK);
                startActivity(intent);
                finish();
            }
        });
        workStepQueueLvTaskQueue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;

                intent = new Intent(TaskResponseProcessQueue.this, TaskResponseParent.class);
                intent.putExtra("processType", processFeedbackList.get(position).type);
                intent.putExtra("processId", processFeedbackList.get(position).id);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
        Intent intent = new Intent(TaskResponseProcessQueue.this, MainActivity.class);
        intent.putExtra("DIRECT", BACK_TASK);
        startActivity(intent);
    }

    public void loadDatafromServer() {
        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/listProcess");
        requestParams.addBodyParameter("userId", sp.getString("USER_ID", null));
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                ProcessFeedback pf = gson.fromJson(result, ProcessFeedback.class);
                Log.e("TaskResponse",pf.result.toString());
                if (pf.result.size() == 0) {
                    rlNotData.setVisibility(View.VISIBLE);
                }
                processFeedbackList.addAll(pf.result);
                if (commonAdapter == null) {
                    commonAdapter = new CommonAdapter<ProcessFeedback.Result>(TaskResponseProcessQueue.this, processFeedbackList, R.layout.item_task_response_queue) {
                        @Override
                        public void convert(ViewHolder viewHolder, ProcessFeedback.Result processFeedback, int position) {
                            processFeedback = processFeedbackList.get(position);
                            TextView tv = viewHolder.getViewById(R.id.tv_process);
                            TextView tv_state = viewHolder.getViewById(R.id.tv_state);
                            tv.setText(processFeedback.name);
                            if ("3".equals(processFeedback.type)) {
                                tv_state.setText("发货");
                            }
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

    @OnClick(R.id.rl_load_fail)
    public void onClick() {
        llLoad.setVisibility(View.VISIBLE);
        rlLoadFail.setVisibility(View.GONE);
        loadDatafromServer();
    }
}
