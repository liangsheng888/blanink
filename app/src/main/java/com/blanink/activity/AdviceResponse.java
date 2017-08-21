package com.blanink.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
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
import com.blanink.activity.order.ComeOrderContinueAddProductActivity;
import com.blanink.adapter.GridSpacingItemDecoration;
import com.blanink.adapter.PhotoAdapter;
import com.blanink.adapter.RecyclerItemClickListener;
import com.blanink.oss.OssService;
import com.blanink.pojo.ReportPay;
import com.blanink.pojo.ResponseDelete;
import com.blanink.utils.CommonUtil;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.BarChart01View;
import com.google.gson.Gson;

import org.xclcharts.chart.BarData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/****
 * 意见反馈
 */
public class AdviceResponse extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    @BindView(R.id.et_msg)
    EditText etMsg;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.bt_commit)
    Button btCommit;
    private PhotoAdapter photoAdapter=null;
    private ArrayList<String> selectedPhotos=new ArrayList<>();
    private OSSClient oss;
    private String urls="";
    private SharedPreferences sp;
    private String remarks="";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            DialogLoadUtils.dismissDialog();
            showNotifyTwo("反馈成功", "继续提意见", "返回");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice_response);
        oss=OssService.getOSSClientInstance(this);
        sp=getSharedPreferences("DATA",MODE_PRIVATE);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        photoAdapter=new PhotoAdapter(this,selectedPhotos);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
        recyclerView.setAdapter(photoAdapter);
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
                                    .start(AdviceResponse.this);
                        } else {
                            PhotoPreview.builder()
                                    .setPhotos(selectedPhotos)
                                    .setCurrentItem(position)
                                    .start(AdviceResponse.this);
                        }
                    }
                }));

        //提交
        btCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg=etMsg.getText().toString();
                if(TextUtils.isEmpty(msg)){
                    Toast.makeText(AdviceResponse.this, "请填写反馈内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.getInstance(AdviceResponse.this);
                DialogLoadUtils.showDialogLoad("提交中...");
                save(msg);

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
                    for (int i = 0; i < selectedPhotos.size(); i++){
                        urls = urls + "|" + OssService.OSS_URL+"alioss_"+ CommonUtil.getFileName(selectedPhotos.get(i))+ CommonUtil.getFileLastName(selectedPhotos.get(i));
                    }
                    urls = urls.substring(1);
                }

                photoAdapter.notifyDataSetChanged();
            }
        }
    }

    public void save(String msg) {
        if(!CommonUtil.isConnected(this)){
            Toast.makeText(AdviceResponse.this, "请检查你的网络", Toast.LENGTH_SHORT).show();

            return;
        }
        String url = NetUrlUtils.NET_URL + "saveAdvice";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("currentUser.id",sp.getString("USER_ID",null))
                .add("remarks",msg)
                .add("photo",urls)
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
              runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(AdviceResponse.this, "服务异常", Toast.LENGTH_SHORT).show();

                        DialogLoadUtils.dismissDialog();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();

                final ResponseDelete rs = gson.fromJson(json, ResponseDelete.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if("00000".equals(rs.getErrorCode())){
                            List<String> photos=new ArrayList<String>();
                            photos.addAll(selectedPhotos);
                            uploadFiles(oss,photos);
                        }else {
                            Toast.makeText(AdviceResponse.this, "操作失败", Toast.LENGTH_SHORT).show();

                        }

                    }
                });


            }
        });
    }
    public  void uploadFiles(OSSClient oss,List<String> urls) {
        if (null == urls || urls.size() == 0) {
            handler.sendEmptyMessage(0);
            DialogLoadUtils.dismissDialog();
            return ;
        } // 上传文件
        ossUpload(oss,urls);
    }

    public void ossUpload(final OSSClient oss, final List<String> urls) {
        Log.e("ComeOrder","图片个数:"+urls.size());
        if (urls.size() <= 0) {
            Log.e("ComeOrder","通知提醒");
            DialogLoadUtils.dismissDialog();
            handler.sendEmptyMessage(0);
            // 文件全部上传完毕，这里编写上传结束的逻辑，如果要在主线程操作，最好用Handler或runOnUiThead做对应逻辑
            return ;// 这个return必须有，否则下面报越界异常，原因自己思考下哈
        }
        final String url = urls.get(0);
        if (TextUtils.isEmpty(url)) {
            urls.remove(0);
            // url为空就没必要上传了，这里做的是跳过它继续上传的逻辑。
            ossUpload(oss, urls);
            return ;
        }

        File file = new File(url);
        if (null == file || !file.exists()) {
            urls.remove(0);
            // 文件为空或不存在就没必要上传了，这里做的是跳过它继续上传的逻辑。
            ossUpload(oss, urls);
            return ;
        }
        // 文件后缀
        String fileSuffix = "";
        if (file.isFile()) {
            // 获取文件后缀名
            fileSuffix = CommonUtil.getFileName(url)+ CommonUtil.getFileLastName(url);
        }
        // 文件标识符objectKey
        final String objectKey = "alioss_"+ fileSuffix;
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

    //
    public void showNotifyTwo(String tilte, String btnLeft, String btnRight) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_bid);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        WindowManager windowManager = getWindowManager();
        Display d = windowManager.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);
        alertDialog.setCanceledOnTouchOutside(false);
        ((TextView) (window.findViewById(R.id.tv_message))).setText(tilte);
        ((TextView) (window.findViewById(R.id.tv_continue))).setText(btnLeft);
        ((TextView) (window.findViewById(R.id.tv_seek))).setText(btnRight);
        window.findViewById(R.id.tv_continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etMsg.setText("");
                selectedPhotos.clear();
                alertDialog.dismiss();

            }
        });

        window.findViewById(R.id.tv_seek).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
