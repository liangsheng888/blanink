package com.blanink.activity.flow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.blanink.R;
import com.blanink.activity.AttachmentBrow;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.FeedBackingTask;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.StringToListUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 工序下的反馈记录
 */
public class FlowProgressDetailHistory extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    @BindView(R.id.lv)
    SwipeMenuListView lv;
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
        setContentView(R.layout.activity_flow_progress_detail_history);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        loadData();
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    public void loadData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/listFeedbackingTask");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("process.id", getIntent().getStringExtra("processId"));
        rp.addBodyParameter("flow.id", getIntent().getStringExtra("flowId"));
        x.http().post(rp, new Callback.CacheCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.e("TaskResponse", "我反馈过的:" + result);
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                final FeedBackingTask feedbackingTask = gson.fromJson(result, FeedBackingTask.class);

                if (feedbackingTask.getResult().getProcessFeedbackList().size() == 0) {
                    rlNotData.setVisibility(View.VISIBLE);
                    tvNot.setText("没有员工进行反馈");
                } else {
                    rlNotData.setVisibility(View.GONE);

                }
                CommonAdapter<FeedBackingTask.ResultBean.ProcessFeedbackListBean> commonAdapter = new CommonAdapter<FeedBackingTask.ResultBean.ProcessFeedbackListBean>(FlowProgressDetailHistory.this, feedbackingTask.getResult().getProcessFeedbackList(), R.layout.item_history_note_response) {
                    @Override
                    public void convert(ViewHolder viewHolder, FeedBackingTask.ResultBean.ProcessFeedbackListBean processFeedbackUser, int position) {
                        processFeedbackUser = feedbackingTask.getResult().getProcessFeedbackList().get(position);
                        TextView date = viewHolder.getViewById(R.id.tv_date);
                        TextView tv_master = viewHolder.getViewById(R.id.tv_master);
                        TextView tv_finished = viewHolder.getViewById(R.id.tv_finished);
                        TextView tv_bad = viewHolder.getViewById(R.id.tv_bad);
                        tv_master.setText(processFeedbackUser.getFeedbackUser().getName());
                        date.setText(processFeedbackUser.getCreateDate());
                        tv_finished.setText((processFeedbackUser.getAchieveAmount()) + "个");
                        tv_bad.setText((processFeedbackUser.getFaultAmount()) + "个");
                        final FeedBackingTask.ResultBean.ProcessFeedbackListBean finalProcessFeedbackUser = processFeedbackUser;
                        SwipeMenuCreator  creator = new SwipeMenuCreator() {
                            @Override
                            public void create(SwipeMenu menu) {
                                if(finalProcessFeedbackUser.getFeedbackAttachmentStr()!=null){
                                SwipeMenuItem seekProgressItem = new SwipeMenuItem(FlowProgressDetailHistory.this);
                                seekProgressItem.setBackground(new ColorDrawable(getResources().getColor(R.color.colorAccent)));
                                seekProgressItem.setWidth(dp2px(100));
                                seekProgressItem.setTitle("查看附件");
                                seekProgressItem.setTitleSize(18);
                                seekProgressItem.setTitleColor(Color.WHITE);
                                menu.addMenuItem(seekProgressItem);}else {
                                    SwipeMenuItem seekProgressItem = new SwipeMenuItem(FlowProgressDetailHistory.this);
                                    seekProgressItem.setBackground(new ColorDrawable(getResources().getColor(R.color.colorGray)));
                                    seekProgressItem.setWidth(dp2px(100));
                                    seekProgressItem.setTitle("查看附件");
                                    seekProgressItem.setTitleSize(18);
                                    seekProgressItem.setTitleColor(Color.WHITE);
                                    menu.addMenuItem(seekProgressItem);
                                }
                            }
                        };
                        lv .setMenuCreator(creator);

                    }
                };
                lv.setAdapter(commonAdapter);


                lv.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                        if(feedbackingTask.getResult().getProcessFeedbackList().get(position).getFeedbackAttachmentStr()!=null){
                            Intent intent=new Intent(FlowProgressDetailHistory.this, AttachmentBrow.class);
                            intent.putExtra("imageList",new Gson().toJson(StringToListUtils.stringToList(feedbackingTask.getResult().getProcessFeedbackList().get(position).getFeedbackAttachmentStr(),",")));
                            startActivity(intent);
                        }

                        return false;
                    }
                });


             /*   lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(FlowProgressDetailHistory.this,FlowSeekProgressDetail.class);
                        intent.putExtra("progressDetail",feedbackingTask.getResult().getProcessFeedbackList().get(position));
                        startActivity(intent);
                    }
                });*/
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

    public int dp2px(float dipValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
