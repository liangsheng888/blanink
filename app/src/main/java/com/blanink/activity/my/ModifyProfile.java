package com.blanink.activity.my;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.blanink.R;
import com.blanink.oss.OssService;
import com.blanink.pojo.LoginResult;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.CommonUtil;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.XUtilsImageUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;

/***
 * 修改个人资料
 */
public class ModifyProfile extends AppCompatActivity {
    private static final int REQUEST_CODE = 2;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    private LoginResult loginResult;
    private SharedPreferences sp;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.tender_manager)
    RelativeLayout tenderManager;
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.tv_nick)
    TextView tvNick;
    @BindView(R.id.et_nick)
    EditText etNick;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.et_phone)
    EditText etPhone;
    private String name;
    private String psd;
    private String phone;
    private String photo;
    private MyActivityManager myActivityManager;
    private File file;
    String path;
    OSSClient oss;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            showNotify();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_profile);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        receivedData();
        ButterKnife.bind(this);
        initData();
    }

    private void receivedData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        loginResult = (LoginResult) bundle.getSerializable("MyProfile");
        Log.e("ModifyProfile", "loginResult:" + loginResult.toString());
    }

    private void initData() {

        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(OssService.AccessKey, OssService.AccessKeySecret);
        oss = new OSSClient(getApplicationContext(), OssService.endpoint, credentialProvider);
        etNick.setText(loginResult.getResult().name);
        etPhone.setText(loginResult.getResult().phone);
        if (loginResult.getResult().photo != null && loginResult.getResult().photo != "") {
            GlideUtils.glideImageView(ModifyProfile.this, ivPhoto, loginResult.getResult().photo, true);
        }
        //返回
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etNick.getText().toString().trim();
                phone = etPhone.getText().toString().trim();
                Log.e("ModifyProfile", name + "------" + phone);
                DialogLoadUtils.getInstance(ModifyProfile.this);
                DialogLoadUtils.showDialogLoad("操作进行中...");
                uploadDataToServer();
            }
        });
        //设置头像
        ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhotoPicker.builder()
                        //设置选择个数
                        .setPhotoCount(1)
                        //选择界面第一个显示拍照按钮
                        .setShowCamera(true)
                        //选择时点击图片放大浏览
                        .setPreviewEnabled(false)
                        //附带已经选中过的图片
                        .start(ModifyProfile.this);
            }
        });
    }

    //上传数据
    private void uploadDataToServer() {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "userUpdate");
        rp.addBodyParameter("id", sp.getString("USER_ID", null));
        rp.addBodyParameter("name", name);
        rp.addBodyParameter("phone", phone);
        rp.addBodyParameter("photo", photo);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("ModifyProfile", result);
                DialogLoadUtils.dismissDialog();
                Gson gson = new Gson();
                LoginResult response = gson.fromJson(result, LoginResult.class);
                if (response.getErrorCode().equals("00000")) {
                    //上传图片到阿里云服务器


                    PutObjectRequest put = new PutObjectRequest("blanink", CommonUtil.getFileName(path), path);
                    OSSAsyncTask task = oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                        @Override
                        public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                            handler.sendEmptyMessage(0);
                         /*   oss.asyncDeleteObject(new DeleteObjectRequest("blanink", loginResult.getResult().photo), new OSSCompletedCallback<DeleteObjectRequest, DeleteObjectResult>() {
                                @Override
                                public void onSuccess(DeleteObjectRequest deleteObjectRequest, DeleteObjectResult deleteObjectResult) {
                                    handler.sendEmptyMessage(0);
                                }

                                @Override
                                public void onFailure(DeleteObjectRequest deleteObjectRequest, ClientException e, ServiceException e1) {

                                }
                            });*/

                            Log.d("TenderPublish", "UploadSuccess");
                            Log.d("TenderPublish", "ETag:" + result.getETag());
                            Log.d("TenderPublish", "RequestId:" + result.getRequestId());
                            String backReuslt = result.getServerCallbackReturnBody();
                            Log.d("TenderPublish", "ServerCallbackReturnBody():" + result.getServerCallbackReturnBody());
                            //http://blanink.oss-cn-hangzhou.aliyuncs.com/com_blanink_96x96

                        }

                        @Override
                        public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                            // 请求异常
                            if (clientExcepion != null) {
                                // 本地异常如网络异常等
                                clientExcepion.printStackTrace();
                            }
                            if (serviceException != null) {
                                // 服务异常
                                Log.e("TenderPublish", "ErrorCode:" + serviceException.getErrorCode());
                                Log.e("TenderPublish", "RequestId:" + serviceException.getRequestId());
                                Log.e("TenderPublish", "HostId:" + serviceException.getHostId());
                                Log.e("TenderPublish", "RawMessage:" + serviceException.getRawMessage());
                            }
                        }
                    });
                    //弹出对话框

                } else {
                    Toast.makeText(ModifyProfile.this, "修改失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("ModifyProfile", ex.toString());
                DialogLoadUtils.dismissDialog();
                Toast.makeText(ModifyProfile.this, "服务器异常", Toast.LENGTH_SHORT).show();

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

    private void showNotify() {
        final AlertDialog alertDialog = new AlertDialog.Builder(ModifyProfile.this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_success);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        Display d = getWindowManager().getDefaultDisplay(); // 获取屏幕宽、高用
        //  lp.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);
        alertDialog.setCanceledOnTouchOutside(false);
        window.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //选择返回
        if (resultCode == RESULT_OK &&
                (requestCode == PhotoPicker.REQUEST_CODE || requestCode == PhotoPreview.REQUEST_CODE)) {

            List<String> photos = null;
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                path = Uri.fromFile(new File(photos.get(0))).getPath();
                photo = OssService.OSS_URL + CommonUtil.getFileName(path);
                ivPhoto.setImageBitmap(BitmapFactory.decodeFile(path));
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }


}

