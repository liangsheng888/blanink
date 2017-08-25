package com.blanink.activity.task;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.blanink.R;
import com.blanink.adapter.EmpAdapter;
import com.blanink.adapter.PhotoAdapter;
import com.blanink.adapter.RecyclerItemClickListener;
import com.blanink.oss.OssService;
import com.blanink.pojo.Emp;
import com.blanink.pojo.FeedBackingTask;
import com.blanink.pojo.OfficeEmp;
import com.blanink.pojo.Response;
import com.blanink.utils.CommonUtil;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.DialogNotifyUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.PriorityUtils;
import com.blanink.view.NoScrollGridview;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;

/***
 * 发货 列表
 */
public class TaskResponseDeliver extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.deliver)
    RelativeLayout deliver;
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
    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.sp_is_sender)
    Spinner spIsSender;
    @BindView(R.id.sp_sender)
    Spinner spSender;
    @BindView(R.id.sp_receiver)
    Spinner spReceiver;
    @BindView(R.id.gv_receiver)
    NoScrollGridview gvReceiver;
    @BindView(R.id.et_note)
    EditText etNote;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.task_response_rl_hand)
    RelativeLayout taskResponseRlHand;
    @BindView(R.id.ll_info)
    LinearLayout llInfo;
    @BindView(R.id.btn_send)
    Button btnSend;
    private List<String> receiverNameList = new ArrayList<>();
    private List<String> receiverIdList = new ArrayList<>();
    private List<String> senderNameList = new ArrayList<>();
    private List<String> senderIdList = new ArrayList<>();
    private List<Emp> empList = new ArrayList<>();
    private String receiverName;
    private String receiverId;
    private String senderName;
    private String senderId;
    private String[] isSend = {"部分发货", "全部发货"};
    private String isFinish;
    private ArrayList<String> selectedPhotos = new ArrayList<>();
    List<FeedBackingTask.ResultBean.SendUserListBean> sendUserList = new ArrayList<>();
    private List<String> masterItem = new ArrayList<String>();
    private List<String> userIdList = new ArrayList<String>();
    PhotoAdapter photoAdapter;
    private String urls = "";
    private String achieveAmount;
    private String isFinished;//1部分发货，2全部发货
    private String remarks;
    private OSSClient oss;
    private SharedPreferences sp;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            DialogNotifyUtils.showNotify(TaskResponseDeliver.this, "操作成功");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_response_deliver);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        oss = OssService.getOSSClientInstance(this);
        DialogLoadUtils.getInstance(this);
        DialogLoadUtils.showDialogLoad("拼命加载中...");
        initData();
    }

    private void initData() {
        photoAdapter = new PhotoAdapter(this, selectedPhotos);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
        recyclerView.setAdapter(photoAdapter);

        // getReceiver(getIntent().getStringExtra("companyId"));//收货人
        checkUserRoleType();

        getMineEmp(sp.getString("COMPANY_ID", null));//发货人
        spIsSender.setAdapter(new ArrayAdapter<String>(TaskResponseDeliver.this, R.layout.spanner_item, isSend));
        spIsSender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                isFinished = position + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //发货
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                achieveAmount = etNumber.getText().toString().trim();
                remarks = etNote.getText().toString();
                if (TextUtils.isEmpty(achieveAmount)) {
                    Toast.makeText(TaskResponseDeliver.this, "数量不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (receiverIdList.size() == 0) {
                    Toast.makeText(TaskResponseDeliver.this, "请选择通知接收人", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(remarks)) {
                    Toast.makeText(TaskResponseDeliver.this, "需要填写备注信息", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.getInstance(TaskResponseDeliver.this);
                DialogLoadUtils.showDialogLoad("发货中...");
                Deliver();
            }
        });


        //
        //图片放大
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (photoAdapter.getItemViewType(position) == PhotoAdapter.TYPE_ADD) {
                            PhotoPicker.builder()
                                    .setPhotoCount(3)
                                    .setShowCamera(true)
                                    .setPreviewEnabled(false)
                                    .setSelected(selectedPhotos)
                                    .start(TaskResponseDeliver.this);
                        } else {
                            PhotoPreview.builder()
                                    .setPhotos(selectedPhotos)
                                    .setCurrentItem(position)
                                    .start(TaskResponseDeliver.this);
                        }
                    }
                }));
    }

    private void Deliver() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/delivery");
        rp.addBodyParameter("achieveAmount", achieveAmount);
        rp.addBodyParameter("isFinished", isFinished);
        rp.addBodyParameter("feedbackUser", senderId);
        rp.addBodyParameter("remarks", remarks);
        for (int i = 0; i < sendUserList.size(); i++) {
            rp.addBodyParameter("sendUser[" + i + "]", sendUserList.get(i).getId());//接收人List
        }
        rp.addBodyParameter("feedbackAttachmentStr", urls);
        rp.addBodyParameter("process.id", getIntent().getStringExtra("processId"));
        rp.addBodyParameter("flow.id", getIntent().getStringExtra("flowId"));
        rp.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Response re = gson.fromJson(result, Response.class);
                if ("00000".equals(re.getErrorCode())) {
                    List<String> photos = new ArrayList<String>();
                    photos.addAll(selectedPhotos);
                    uploadFiles(oss, photos);
                } else {
                    DialogLoadUtils.dismissDialog();
                    Toast.makeText(TaskResponseDeliver.this, "操作失败", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();
                Toast.makeText(TaskResponseDeliver.this, "服务器开了会儿小差，稍后再试", Toast.LENGTH_SHORT).show();

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

    public void getReceiver(String companyId) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/userList");
        rp.addBodyParameter("id", companyId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                receiverNameList.add("请选择");
                receiverIdList.add("");
                final OfficeEmp officeEmp = gson.fromJson(result, OfficeEmp.class);
                for (int i = 0; i < officeEmp.getResult().size(); i++) {
                    receiverNameList.add(officeEmp.getResult().get(i).getName());
                    receiverIdList.add(officeEmp.getResult().get(i).getId());
                }
                spReceiver.setAdapter(new ArrayAdapter<String>(TaskResponseDeliver.this, R.layout.simple_spinner_item, R.id.tv_name, receiverNameList));
                spReceiver.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        receiverName = receiverNameList.get(position);
                        receiverId = receiverIdList.get(position);
                        if (receiverId != "" && receiverId != null) {
                            if (!compareIsExists(empList, receiverId)) {
                                empList.add(new Emp(receiverId, receiverName));
                            }
                            gvReceiver.setAdapter(new EmpAdapter(TaskResponseDeliver.this, empList));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //选择返回
        if (resultCode == RESULT_OK &&
                (requestCode == PhotoPicker.REQUEST_CODE || requestCode == PhotoPreview.REQUEST_CODE)) {

            ArrayList<String> photos = null;
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);

                selectedPhotos.clear();
                if (photos != null) {
                    selectedPhotos.addAll(photos);
                    for (int i = 0; i < selectedPhotos.size(); i++) {
                        urls = urls + "," + OssService.OSS_URL + "alioss_" + CommonUtil.getFileName(selectedPhotos.get(i)) + CommonUtil.getFileLastName((selectedPhotos.get(i)));
                    }
                    urls = urls.substring(1);
                    Log.e("ComeOrder", urls);
                }

                photoAdapter.notifyDataSetChanged();
            }
        }
    }

    public void getMineEmp(String companyId) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/userList");
        rp.addBodyParameter("id", companyId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                final OfficeEmp officeEmp = gson.fromJson(result, OfficeEmp.class);
                for (int i = 0; i < officeEmp.getResult().size(); i++) {
                    senderNameList.add(officeEmp.getResult().get(i).getName());
                    senderIdList.add(officeEmp.getResult().get(i).getId());
                }
                spSender.setAdapter(new ArrayAdapter<String>(TaskResponseDeliver.this, R.layout.spanner_item, senderNameList));
                spSender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        senderName = senderNameList.get(position);
                        senderId = senderIdList.get(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

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

    public Boolean compareIsExists(List<Emp> empList, String id) {
        Boolean flag = false;
        if (empList.size() == 0) {
            return false;
        }
        for (Emp em : empList) {
            if (em.EmpId.equals(id)) {
                flag = true;
                break;
            }

        }
        return flag;
    }

    //列出我已经反馈过的某个产品，并包含所有反馈记录，展示页面用的
    public void loadData(final Response response) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/listFeedbackingTask");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("process.id", getIntent().getStringExtra("processId"));
        rp.addBodyParameter("flow.id", getIntent().getStringExtra("flowId"));
        x.http().post(rp, new Callback.CacheCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                DialogLoadUtils.dismissDialog();
                final FeedBackingTask feedbackingTask = gson.fromJson(result, FeedBackingTask.class);
                if ("00000".equals(response.getErrorCode())) {
                    for (int i = 0; i < feedbackingTask.getResult().getProcessWorkerList().size(); i++) {
                        masterItem.add(i, feedbackingTask.getResult().getProcessWorkerList().get(i).getName());
                        userIdList.add(i, feedbackingTask.getResult().getProcessWorkerList().get(i).getId());
                        Log.e("TaskResponse", "该用户有权限:" + userIdList.toString() + "----" + masterItem.toString());
                    }
                } else {
                    userIdList.add(sp.getString("USER_ID", null));
                    masterItem.add(sp.getString("NAME", null));
                    Log.e("TaskResponse", "该用户没有有权限:" + userIdList.toString() + "----" + masterItem.toString());
                }
                tvCompanyName.setText(feedbackingTask.getResult().getCompanyA().getName());
                tvMaster.setText(feedbackingTask.getResult().getCompanyBOwner().getName());
                tvTime.setText(feedbackingTask.getResult().getCreateDate());
                tvProCategory.setText(feedbackingTask.getResult().getCompanyCategory().getName());
                tvProName.setText(feedbackingTask.getResult().getProductName());
                tvNum.setText(feedbackingTask.getResult().getAmount());
                tvDeliveryTime.setText(feedbackingTask.getResult().getDeliveryTime());
                tvMyTaskNum.setText(feedbackingTask.getResult().getRelFlowProcess().getTarget() + "");
                tvNote.setText(feedbackingTask.getResult().getProductDescription());
                tvPriority.setText(PriorityUtils.getPriority(PriorityUtils.getPriority(feedbackingTask.getResult().getCompanyAPriority())));
                tvMyMyPriority.setText(PriorityUtils.getPriority(PriorityUtils.getPriority(feedbackingTask.getResult().getCompanyBPriority())));
                tvResponse.setText((feedbackingTask.getResult().getAllFinishedAmount() + ""));
                sendUserList.addAll(feedbackingTask.getResult().getSendUserList());
                Log.e("TaskResponse", sendUserList.toString());
                receiverNameList.add("请选择责任人");
                receiverIdList.add("");
                for (FeedBackingTask.ResultBean.SendUserListBean send : sendUserList) {
                    receiverNameList.add(send.getName());
                    receiverIdList.add(send.getId());
                }
                spReceiver.setAdapter(new ArrayAdapter<String>(TaskResponseDeliver.this, R.layout.spanner_item, receiverNameList));
                spReceiver.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        receiverName = receiverNameList.get(position);
                        receiverId = receiverIdList.get(position);
                        if (receiverId != "" && receiverId != null) {
                            if (!compareIsExists(empList, receiverId)) {
                                empList.add(new Emp(receiverId, receiverName));
                            }
                            gvReceiver.setAdapter(new EmpAdapter(TaskResponseDeliver.this, empList));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();
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

    public void uploadFiles(OSSClient oss, List<String> urls) {
        if (null == urls || urls.size() == 0) {
            DialogLoadUtils.dismissDialog();
            handler.sendEmptyMessage(0);
            return;
        } // 上传文件
        ossUpload(oss, urls);
    }

    public void ossUpload(final OSSClient oss, final List<String> urls) {
        Log.e("ComeOrder", "图片个数:" + urls.size());
        if (urls.size() <= 0) {
            Log.e("ComeOrder", "通知提醒");
            DialogLoadUtils.dismissDialog();
            handler.sendEmptyMessage(0);
            // 文件全部上传完毕，这里编写上传结束的逻辑，如果要在主线程操作，最好用Handler或runOnUiThead做对应逻辑
            return;// 这个return必须有，否则下面报越界异常，原因自己思考下哈
        }
        final String url = urls.get(0);
        if (TextUtils.isEmpty(url)) {
            urls.remove(0);
            // url为空就没必要上传了，这里做的是跳过它继续上传的逻辑。
            ossUpload(oss, urls);
            return;
        }

        File file = new File(url);
        if (null == file || !file.exists()) {
            urls.remove(0);
            // 文件为空或不存在就没必要上传了，这里做的是跳过它继续上传的逻辑。
            ossUpload(oss, urls);
            return;
        }
        // 文件后缀
        String fileSuffix = "";
        if (file.isFile()) {
            // 获取文件后缀名
            fileSuffix = CommonUtil.getFileName(url) + CommonUtil.getFileLastName(url);
        }
        // 文件标识符objectKey
        final String objectKey = "alioss_" + fileSuffix;
        // 下面3个参数依次为bucket名，ObjectKey名，上传文件路径
        PutObjectRequest put = new PutObjectRequest("blanink", objectKey, url);

        // 设置进度回调
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                // 进度逻辑
            }
        });

        // 异步上传
        OSSAsyncTask task = oss.asyncPutObject(put,
                new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                    @Override
                    public void onSuccess(PutObjectRequest request, PutObjectResult result) { // 上传成功
                        urls.remove(0);
                        ossUpload(oss, urls);// 递归同步效果
                    }

                    @Override
                    public void onFailure(PutObjectRequest request, ClientException clientExcepion,
                                          ServiceException serviceException) { // 上传失败

                        // 请求异常
                        if (clientExcepion != null) {
                            // 本地异常如网络异常等
                            clientExcepion.printStackTrace();
                        }
                        if (serviceException != null) {
                            // 服务异常
                            Log.e("ErrorCode", serviceException.getErrorCode());
                            Log.e("RequestId", serviceException.getRequestId());
                            Log.e("HostId", serviceException.getHostId());
                            Log.e("RawMessage", serviceException.getRawMessage());
                        }
                    }
                });
        // task.cancel(); // 可以取消任务
        // task.waitUntilFinished(); // 可以等待直到任务完成
    }

    //检查判断用户角色
    private void checkUserRoleType() {
        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/accessControl");
        requestParams.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        requestParams.addBodyParameter("id", getIntent().getStringExtra("processId"));
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                DialogLoadUtils.dismissDialog();

                Log.e("TaskResponse", result);
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                loadData(response);

            }


            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();
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
