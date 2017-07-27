package com.blanink.activity.task;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.AttachmentBrow;
import com.blanink.pojo.FeedPrcessDetail;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.StringToListUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 历史分配详情
 */
public class TaskResponseHistoryDetail extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    @BindView(R.id.tv_pro_category)
    TextView tvProCategory;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.order_item_ll2)
    RelativeLayout orderItemLl2;
    @BindView(R.id.order_item_ll2_guigeName)
    TextView orderItemLl2GuigeName;
    @BindView(R.id.tv_pro_name)
    TextView tvProName;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.task)
    TextView task;
    @BindView(R.id.tv_target)
    TextView tvTarget;
    @BindView(R.id.response)
    TextView response;
    @BindView(R.id.tv_response)
    TextView tvResponse;
    @BindView(R.id.tv_my_task)
    TextView tvMyTask;
    @BindView(R.id.bad_num)
    TextView badNum;
    @BindView(R.id.attactment)
    TextView attactment;
    @BindView(R.id.tv_attactment)
    TextView tvAttactment;
    @BindView(R.id.rl_down)
    RelativeLayout rlDown;
    @BindView(R.id.note)
    TextView note;
    @BindView(R.id.tv_note)
    TextView tvNote;
    private SharedPreferences sp;
    FeedPrcessDetail feed;
    private Handler hander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_response_history_detail);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        loadResponseDetail();

        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void loadResponseDetail() {
        //processFeedback/listFeedbackingTask?userId=447e4526d22045f59ed58250046b3842&process.id=1a9090dd4dbe4808a921900d7b64db01&flow.id=2695060d06604c7e98f007e06592d22b
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/viewOneHistoryTask");
        Log.e("TaskResponse",NetUrlUtils.NET_URL + "processFeedback/viewOneHistoryTask?id="+ getIntent().getStringExtra("id"));
        rp.addBodyParameter("id", getIntent().getStringExtra("id"));

        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                feed = gson.fromJson(result, FeedPrcessDetail.class);
                tvTarget.setText(feed.getResult().getTarget() + "");
                tvResponse.setText(feed.getResult().getAchieveAmount() + "");
                badNum.setText(feed.getResult().getFaultAmount() + "");
                tvNote.setText(feed.getResult().getRemarks());
                tvTime.setText(feed.getResult().getCreateDate());
                tvProName.setText(getIntent().getStringExtra("productName"));
                tvProCategory.setText(getIntent().getStringExtra("productCategory"));
                tvNum.setText(getIntent().getStringExtra("productNum"));
                List<String> arrayList=null;
                if (feed.getResult().getFeedbackAttachmentStr()!= null && feed.getResult().getFeedbackAttachmentStr() != ""&&!"".equals(feed.getResult().getFeedbackAttachmentStr())) {
                    arrayList = StringToListUtils.stringToList(feed.getResult().getFeedbackAttachmentStr(), ",");
                }else {
                    arrayList=new ArrayList<>();
                }

                final List<String> finalArrayList = arrayList;
                tvAttactment.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(TaskResponseHistoryDetail.this, AttachmentBrow.class);
                            intent.putExtra("imageList", new Gson().toJson(finalArrayList));
                            startActivity(intent);
                        }
                    });

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
