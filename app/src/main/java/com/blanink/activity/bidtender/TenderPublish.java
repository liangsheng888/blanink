package com.blanink.activity.bidTender;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.blanink.R;
import com.blanink.activity.MainActivity;
import com.blanink.pojo.Response;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/***
 * 发布招标
 */
public class TenderPublish extends AppCompatActivity {

    private static final int BACK_TASK = 0;
    private static final int RESULT_UPLOAD = 1;
    private MyActivityManager myActivityManager;
    private TextView last;
    private EditText et_title;
    private EditText et_product;
    private EditText et_first_price;
    private EditText et_price;
    private EditText et_num;
    private EditText et_end_date;
    private TextView tv_date;
    private EditText et_note;
    private TextView tv_file_name;
    private Button btn_ok;
    SharedPreferences sp;
    private String title;
    private String buyProductName;
    private String count;
    private String expireDate;
    private String remarks;
    private String attachment;//附件
    private String targetPrice;
    private String downPayment;
    private TextView tv_upload;
    //oss
    private String AccessKey = "LTAIekaAAtoKtE8s";
    private String AccessKeySecret = "1tav7M1OlqK5A2HmcbgQldgNwiWXuy";
    private String RoleArn = "acs:ram::1717376254830967:role/aliyunosstokengeneratorrole";
    private String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    private OSSClient oss;
    private TextView tv_file_size;
    private ImageView iv_upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_publish);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initView();
        initData();

    }


    private void initView() {
        last = ((TextView) findViewById(R.id.bid_apply_iv_last));
        et_title = ((EditText) findViewById(R.id.tender_et_title));
        et_product = ((EditText) findViewById(R.id.et_product));
        et_first_price = ((EditText) findViewById(R.id.et_first_price));
        et_price = ((EditText) findViewById(R.id.et_price));
        et_num = ((EditText) findViewById(R.id.et_num));
        et_end_date = ((EditText) findViewById(R.id.et_end_date));
        tv_date = ((TextView) findViewById(R.id.tv_date));
        et_note = ((EditText) findViewById(R.id.et_note));
        tv_file_name = ((TextView) findViewById(R.id.tv_file_name));
        btn_ok = ((Button) findViewById(R.id.btn_ok));
        tv_upload = (TextView) findViewById(R.id.tv_upload);
        iv_upload = ((ImageView) findViewById(R.id.iv_upload));
        tv_file_size = ((TextView) findViewById(R.id.tv_file_size));
    }

    private void initData() {
        // 明文设置secret的方式建议只在测试时使用，更多鉴权模式请参考后面的`访问控制`章节
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(AccessKey, AccessKeySecret);

        oss = new OSSClient(getApplicationContext(), endpoint, credentialProvider);

        //返回
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //设置当前时间
        et_end_date.setText(new SimpleDateFormat("yyyy-MM-dd").format((new Date(System.currentTimeMillis()))));
        //选择日期
        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dpd = new DatePickerDialog(TenderPublish.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        et_end_date.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });
        //选择文件
        iv_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();

            }
        });
        //上传
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到值
                title = et_title.getText().toString();
                buyProductName = et_product.getText().toString();
                count = et_num.getText().toString();
                expireDate = et_end_date.getText().toString();
                remarks = et_note.getText().toString();
                targetPrice = et_price.getText().toString();
                downPayment = et_first_price.getText().toString();
                uploadServer();
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("DIRECT", 0);
        startActivity(intent);
    }

    //上传服务器
    public void uploadServer() {
        //判断 输入选项不能为空
        if (TextUtils.isEmpty(title)) {
            Toast.makeText(this, "请输入标题", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(buyProductName)) {
            Toast.makeText(this, "请输入产品名称", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(downPayment)) {
            Toast.makeText(this, "请输入预付定金", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(targetPrice)) {
            Toast.makeText(this, "请输入价格", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(count)) {
            Toast.makeText(this, "请输入数量", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(expireDate)) {
            Toast.makeText(this, "请输入选择时间", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(remarks)) {
            Toast.makeText(this, "请输入备注", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Integer.parseInt(count) < 1) {
            Toast.makeText(this, "数量不能小于1", Toast.LENGTH_SHORT).show();
            return;
        }


        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/save");
        requestParams.addBodyParameter("userId", sp.getString("USER_ID", ""));
        requestParams.addBodyParameter("title", title);
        requestParams.addBodyParameter("buyProductName", buyProductName);
        requestParams.addBodyParameter("targetPrice", targetPrice);
        requestParams.addBodyParameter("downPayment", downPayment);
        requestParams.addBodyParameter("count", count);
        requestParams.addBodyParameter("remarks", remarks);
        requestParams.addBodyParameter("attachment", attachment);
        requestParams.addBodyParameter("expireDate", expireDate);

        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if ("00000".equals(response.getErrorCode())) {
                    final AlertDialog alertDialog = new AlertDialog.Builder(TenderPublish.this).create();
                    alertDialog.show();
                    alertDialog.setContentView(R.layout.dialog_custom_tender);
                    Window window=alertDialog.getWindow();
                    WindowManager.LayoutParams lp=window.getAttributes();
                    window.setGravity(Gravity.CENTER);
                    Display d = getWindowManager().getDefaultDisplay(); // 获取屏幕宽、高用
                    //  lp.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
                    lp.width = (int) (d.getWidth()*0.9); // 宽度设置为屏幕的1/2
                    window.setWindowAnimations(R.style.dialogAnimation);
                    window.setAttributes(lp);

                    window.findViewById(R.id.tv_continue).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(TenderPublish.this, TenderPublish.class);
                            startActivity(intent);
                           alertDialog.dismiss();
                        }
                    });
                    window.findViewById(R.id.tv_seek).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(TenderPublish.this, MyTender.class);
                            startActivity(intent);
                            alertDialog.dismiss();
                        }
                    });

                } else {
                    Toast.makeText(TenderPublish.this, "发布失败！", Toast.LENGTH_SHORT).show();
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

    /**
     * 调用文件选择软件来选择文件
     **/
    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, RESULT_UPLOAD);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_UPLOAD && resultCode == RESULT_OK && null != data) {
            Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
            final String path = ExampleUtil.getPathByUri4kitkat(TenderPublish.this, uri);
            tv_file_name.setText(path);

            if (requestCode == RESULT_UPLOAD) {
                // 构造上传请求
                PutObjectRequest put = new PutObjectRequest("blanink", ExampleUtil.getFileName(path), path);
                // 异步上传时可以设置进度回调
                put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
                    @Override
                    public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                        Log.d("TenderPublish", "currentSize: " + currentSize + " totalSize: " + totalSize);
                        tv_file_size.setText(totalSize + "");

                    }
                });

                OSSAsyncTask task = oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                    @Override
                    public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                        Log.d("TenderPublish", "UploadSuccess");
                        Log.d("TenderPublish", "ETag:" + result.getETag());
                        Log.d("TenderPublish", "RequestId:" + result.getRequestId());
                        String backReuslt = result.getServerCallbackReturnBody();
                        Log.d("TenderPublish", "ServerCallbackReturnBody():" + result.getServerCallbackReturnBody());
                        //http://blanink.oss-cn-hangzhou.aliyuncs.com/com_blanink_96x96
                        attachment = "blanink.oss-cn-hangzhou.aliyuncs.com/" + ExampleUtil.getFileName(path);
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
            }
        }
    }


}

