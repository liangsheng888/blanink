package com.blanink.activity.task;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.adpater.CommonAdapter;
import com.blanink.adpater.PhotoAdapter;
import com.blanink.adpater.RecyclerItemClickListener;
import com.blanink.adpater.ViewHolder;
import com.blanink.pojo.FeedBackingTask;
import com.blanink.pojo.OrderProduct;
import com.blanink.pojo.Response;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.NoScrollListview;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;

/***
 * 任务反馈详情
 */
public class TaskResponseDetailActivity extends AppCompatActivity {
    @BindView(R.id.task_response_rl)
    RelativeLayout taskResponseRl;
    @BindView(R.id.tv_companyName)
    TextView tvCompanyName;
    @BindView(R.id.tv_master)
    TextView tvMaster;
    @BindView(R.id.tv_order_time)
    TextView tvOrderTime;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.order_item_ll)
    RelativeLayout orderItemLl;
    @BindView(R.id.tv_pro_category)
    TextView tvProCategory;
    @BindView(R.id.order_item_ll2_guigeName)
    TextView orderItemLl2GuigeName;
    @BindView(R.id.tv_pro_name)
    TextView tvProName;
    @BindView(R.id.order_item_ll2)
    RelativeLayout orderItemLl2;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.priority)
    TextView priority;
    @BindView(R.id.tv_priority)
    TextView tvPriority;
    @BindView(R.id.response)
    TextView response;
    @BindView(R.id.tv_response)
    TextView tvResponse;
    @BindView(R.id.tv_my_task)
    TextView tvMyTask;
    @BindView(R.id.tv_my_task_num)
    TextView tvMyTaskNum;
    @BindView(R.id.deliveryTime)
    TextView deliveryTime;
    @BindView(R.id.tv_deliveryTime)
    TextView tvDeliveryTime;
    @BindView(R.id.my_priority)
    TextView myPriority;
    @BindView(R.id.tv_my_my_priority)
    TextView tvMyMyPriority;
    @BindView(R.id.note)
    TextView note;
    @BindView(R.id.tv_note)
    TextView tvNote;
    @BindView(R.id.task_response_rl_gongXuInfo)
    LinearLayout taskResponseRlGongXuInfo;
    @BindView(R.id.lv_task_response_info)
    NoScrollListview lvTaskResponseInfo;
    @BindView(R.id.task_response_sp_person)
    Spinner taskResponseSpPerson;
    @BindView(R.id.task_response_ll)
    LinearLayout taskResponseLl;
    @BindView(R.id.task_response_et_finish_num)
    EditText taskResponseEtFinishNum;
    @BindView(R.id.task_response_ll2)
    LinearLayout taskResponseLl2;
    @BindView(R.id.task_response_et_bad_num)
    EditText taskResponseEtBadNum;
    @BindView(R.id.task_response_ll3)
    LinearLayout taskResponseLl3;
    @BindView(R.id.task_response_tv_hand)
    TextView taskResponseTvHand;
    @BindView(R.id.task_response_rl_hand)
    RelativeLayout taskResponseRlHand;
    @BindView(R.id.task_response_sp_state)
    Spinner taskResponseSpState;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.task_response_rl_edt_content)
    EditText taskResponseRlEdtContent;
    @BindView(R.id.task_response_rl2)
    RelativeLayout taskResponseRl2;
    @BindView(R.id.task_response_btn_commit)
    Button taskResponseBtnCommit;
    @BindView(R.id.task_response_iv_last)
    TextView taskResponseIvLast;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.rl_load)
    RelativeLayout rlLoad;
    @BindView(R.id.lv_response_note)
    NoScrollListview lvResponseNote;
    @BindView(R.id.iv_picture)
    ImageView ivPicture;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.rl_history)
    RelativeLayout rlHistory;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.tv_note_num)
    TextView tvNoteNum;
    private MyActivityManager myActivityManager;
    private OrderProduct.Result order;
    private String faultAmount;
    private String isFinished;
    private String achieveAmount;
    private String remarks;
    private SharedPreferences sp;
    private List<String> masterItem = new ArrayList<String>();
    private List<String> userIdList = new ArrayList<String>();
    private String createById;
    private PhotoAdapter photoAdapter;
    private ArrayList<String> selectedPhotos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_response);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        ButterKnife.bind(this);
        receiveDataFromIntent();
        initData();
    }

    private void receiveDataFromIntent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        order = (OrderProduct.Result) bundle.getSerializable("TaskDetail");
        Log.e("TaskResponse","order:"+order.toString());
    }

    private void initData() {
        checkUserRoleType();
        //判断用户角色类型 assignment yes 显示下拉责任人 否不显示
        taskResponseSpState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        isFinished = "0";
                        break;
                    case 1:
                        isFinished = "1";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //图片放大
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (photoAdapter.getItemViewType(position) == PhotoAdapter.TYPE_ADD) {
                            PhotoPicker.builder()
                                    .setPhotoCount(PhotoAdapter.MAX)
                                    .setShowCamera(true)
                                    .setPreviewEnabled(false)
                                    .setSelected(selectedPhotos)
                                    .start(TaskResponseDetailActivity.this);
                        } else {
                            PhotoPreview.builder()
                                    .setPhotos(selectedPhotos)
                                    .setCurrentItem(position)
                                    .start(TaskResponseDetailActivity.this);
                        }
                    }
                }));


    }

    //检查判断用户角色
    private void checkUserRoleType() {
        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/accessControl");
        requestParams.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        requestParams.addBodyParameter("id", order.relFlowProcess.process.id);
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TaskResponse", "response："+result);
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                loadData(response);
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

    private void showSpinner(final List<String> masterItem) {
        Log.e("TaskResponse", masterItem.toString());
        ArrayAdapter<String> _Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, masterItem);
        taskResponseSpPerson.setAdapter(_Adapter);
        //选择责任人
        taskResponseSpPerson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                createById = userIdList.get(position);
                Log.e("TaskResponse","选中了"+createById);
                Log.e("TaskResponse","选中了"+masterItem.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @OnClick({R.id.task_response_iv_last, R.id.task_response_btn_commit, R.id.iv_picture, R.id.tv_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.task_response_iv_last:
                finish();//返回
                break;
            case R.id.task_response_btn_commit:
                //提交 前先验证
                faultAmount = taskResponseEtBadNum.getText().toString().trim();
                achieveAmount = taskResponseEtFinishNum.getText().toString().trim();
                remarks = taskResponseRlEdtContent.getText().toString().trim();
                if (TextUtils.isEmpty(taskResponseEtFinishNum.getText().toString())) {
                    Toast.makeText(this, "请填写完成数", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(taskResponseEtBadNum.getText().toString())) {
                    Toast.makeText(this, "请填写次品", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(taskResponseRlEdtContent.getText().toString())) {
                    Toast.makeText(this, "请填写备注", Toast.LENGTH_SHORT).show();
                    return;
                }
                uploadData();
                break;
            case R.id.iv_picture:
                PhotoPicker.builder()
                        //设置选择个数
                        .setPhotoCount(3)
                        //选择界面第一个显示拍照按钮
                        .setShowCamera(true)
                        //选择时点击图片放大浏览
                        .setPreviewEnabled(false)
                        //附带已经选中过的图片
                        .start(this);
                break;
            case R.id.tv_more:
                Intent intent = new Intent(this, MoreResponseNoteActivty.class);
                intent.putExtra("flow.id", order.relFlowProcess.flow.id);
                intent.putExtra("process.id", order.relFlowProcess.process.id);
                startActivity(intent);
                break;
        }
    }
  //save
    private void uploadData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/save");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("process.id", order.relFlowProcess.process.id);
        rp.addBodyParameter("flow.id", order.relFlowProcess.flow.id);
        rp.addBodyParameter("feedbackUser.id",createById);
        //rp.addBodyParameter("createBy.id",createById);
        rp.addBodyParameter("faultAmount", faultAmount);
        rp.addBodyParameter("isFinished", isFinished);
        rp.addBodyParameter("achieveAmount", achieveAmount);
        rp.addBodyParameter("remarks", remarks);
        Log.e("Response", "process.id:" + order.relFlowProcess.process.id + ",flow.id:" + order.relFlowProcess.flow.id + ",createById:" + createById + ",isFinished:" + isFinished);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if (response.getErrorCode().equals("00000")) {
                    showDialog();
                } else {
                    Toast.makeText(TaskResponseDetailActivity.this, "反馈失败", Toast.LENGTH_SHORT).show();
                }
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

    private void showDialog() {
        final AlertDialog alertDialog = new AlertDialog.Builder(TaskResponseDetailActivity.this).create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setContentView(R.layout.dialog_custom_response);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        Display d = getWindowManager().getDefaultDisplay(); // 获取屏幕宽、高用
        //  lp.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);

        window.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                taskResponseEtBadNum.setText("");
                taskResponseEtFinishNum.setText("");
                taskResponseRlEdtContent.setText("");
                rlLoad.setVisibility(View.VISIBLE);
                masterItem.clear();
                userIdList.clear();
                checkUserRoleType();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    //列出我已经反馈过的某个产品，并包含所有反馈记录，展示页面用的
    public void loadData(final Response response) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/listFeedbackingTask");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("process.id", order.relFlowProcess.process.id);
        rp.addBodyParameter("flow.id", order.relFlowProcess.flow.id);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                rlLoad.setVisibility(View.GONE);
                Log.e("TaskResponse", "我反馈过的:" + result);
                Gson gson = new Gson();
                final FeedBackingTask feedbackingTask = gson.fromJson(result, FeedBackingTask.class);
                Log.e("TaskResponse", "我反馈过的2:" + feedbackingTask.toString());
                if (response.getErrorCode().equals("00000") && response.getResult()) {
                    for (int i = 0; i < feedbackingTask.result.processWorkerList.size(); i++) {
                        masterItem.add(i, feedbackingTask.result.processWorkerList.get(i).name);
                        userIdList.add(i, feedbackingTask.result.processWorkerList.get(i).id);
                        Log.e("TaskResponse", "该用户有权限:" + userIdList.toString() + "----" + masterItem.toString());
                    }
                } else {
                    userIdList.add(sp.getString("USER_ID", null));
                    masterItem.add(sp.getString("NAME", null));
                    Log.e("TaskResponse", "该用户没有有权限:" + userIdList.toString() + "----" + masterItem.toString());
                }

                showSpinner(masterItem);//显示下拉列表
                tvCompanyName.setText(order.companyA.name);
                tvMaster.setText(order.companyBOwner.name);
                tvTime.setText(order.createDate);
                tvProCategory.setText(order.companyCategory.name);
                tvProName.setText(order.productName);
                tvNum.setText(order.amount);
                tvDeliveryTime.setText(order.deliveryTime);
                tvMyTaskNum.setText(order.workPlan.achieveAmount);
                tvResponse.setText((feedbackingTask.result.finishedAmount==null? 0:feedbackingTask.result.finishedAmount)+ "");
                tvNote.setText(order.productDescription);
                tvPriority.setText(order.companyAPriority);
                tvMyMyPriority.setText(order.companyBPriority);
                tvNoteNum.setText("(" + feedbackingTask.result.processFeedbackList.size() + ")");
                if (feedbackingTask.result.processFeedbackList.size() <= 4) {
                    tvMore.setVisibility(View.GONE);
                    tvMore.setEnabled(false);
                }
                //显示反馈记录
                lvResponseNote.setAdapter(new CommonAdapter<FeedBackingTask.Result.ProcessFeedbackUser>(TaskResponseDetailActivity.this, feedbackingTask.result.processFeedbackList, R.layout.item_history_note_response, 4) {
                    @Override
                    public void convert(ViewHolder viewHolder, FeedBackingTask.Result.ProcessFeedbackUser processFeedbackUser, int position) {
                        processFeedbackUser = feedbackingTask.result.processFeedbackList.get(position);
                        TextView date = viewHolder.getViewById(R.id.tv_date);
                        TextView tv_master = viewHolder.getViewById(R.id.tv_master);
                        TextView tv_finished = viewHolder.getViewById(R.id.tv_finished);
                        TextView tv_bad = viewHolder.getViewById(R.id.tv_bad);
                        tv_master.setText(processFeedbackUser.feedbackUser.name);
                        date.setText(processFeedbackUser.createDate);
                        tv_finished.setText((processFeedbackUser.achieveAmount == null ? 0 : processFeedbackUser.achieveAmount) + "个");
                        tv_bad.setText((processFeedbackUser.faultAmount == null ? 0 : processFeedbackUser.faultAmount) + "个");
                    }
                });

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                rlLoad.setVisibility(View.GONE);
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
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //选择返回
        if (resultCode == RESULT_OK &&
                (requestCode == PhotoPicker.REQUEST_CODE || requestCode == PhotoPreview.REQUEST_CODE)) {

            ArrayList<String> photos = null;
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                photoAdapter = new PhotoAdapter(this, selectedPhotos);
                selectedPhotos.clear();
                if (photos != null) {
                    selectedPhotos.addAll(photos);
                }
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
                recyclerView.setAdapter(photoAdapter);
                photoAdapter.notifyDataSetChanged();
            }
        }
    }

}

