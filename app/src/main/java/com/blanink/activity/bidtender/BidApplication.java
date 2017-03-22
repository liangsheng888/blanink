package com.blanink.activity.bidTender;

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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.blanink.R;
import com.blanink.pojo.Response;
import com.blanink.oss.OssService;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/***
 * 投标申请
 */
public class BidApplication extends AppCompatActivity {

    private static final int RESULT_UPLOAD = 1;
    private TextView bid_apply_iv_last;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private String inviteBidId;
    private String userId;
    private Button btn_upload;
    private EditText et_price;
    private EditText et_note;
    private TextView et_hand_date;
    private ImageView iv_upload;
    private TextView tv_file_name;
    private EditText et_title;
    private String handdate;
    private String note;
    private String singleprice;
    private String title;
    private String attachment;//附件
    OSSClient oss;
    private Spinner sp_date_type;
    private String dateType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_application);
        oss = OssService.getOSSClient(BidApplication.this);
        myActivityManager = MyActivityManager.getInstance();
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager.pushOneActivity(this);
        receivedIntentInfo();
        initView();
        initData();
    }

    private void receivedIntentInfo() {
        Intent intent = getIntent();
        inviteBidId = intent.getStringExtra("inviteBid.id");
        userId = intent.getStringExtra("userId");
    }


    private void initView() {
        et_title = ((EditText) findViewById(R.id.et_title));
        bid_apply_iv_last = ((TextView) findViewById(R.id.bid_apply_iv_last));
        btn_upload = ((Button) findViewById(R.id.btn_upload));//上传
        et_price = ((EditText) findViewById(R.id.et_price));//单价
        et_note = ((EditText) findViewById(R.id.et_note));//备注
        et_hand_date = ((TextView) findViewById(R.id.et_hand_date));//交货日期
        iv_upload = ((ImageView) findViewById(R.id.iv_upload));//上传附件
        tv_file_name = ((TextView) findViewById(R.id.tv_file_name));//文件名字
        sp_date_type = ((Spinner) findViewById(R.id.sp_date_type));//周期类型
    }

    private void initData() {
        sp_date_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getSelectedItem().toString().equals("年")) {
                    dateType = "5";
                }
                if (parent.getSelectedItem().toString().equals("月")) {
                    dateType = "4";
                }
                if (parent.getSelectedItem().toString().equals("周")) {
                    dateType = "3";
                }
                if (parent.getSelectedItem().toString().equals("日")) {
                    dateType = "2";
                }
                if (parent.getSelectedItem().toString().equals("时")) {
                    dateType = "1";
                }
             Log.e("BidApplication","dateType:"+dateType);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //返回
        bid_apply_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_upload.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                title = et_title.getText().toString();
                singleprice = et_price.getText().toString();
                note = et_note.getText().toString();
                handdate = et_hand_date.getText().toString();
                if (TextUtils.isEmpty(title)) {
                    Toast.makeText(BidApplication.this, "请输入标题", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(singleprice)) {
                    Toast.makeText(BidApplication.this, "请输入单价", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(handdate)) {
                    Toast.makeText(BidApplication.this, "请输入交货周期", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(note)) {
                    Toast.makeText(BidApplication.this, "请填写详情备注", Toast.LENGTH_SHORT).show();
                    return;
                }
                uploadDateToServer();
            }
        });
        //上传附件
        iv_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, RESULT_UPLOAD);
            }
        });
    }

    //上传服务器
    public void uploadDateToServer() {
        //http://192.168.199.124:8088/blanink-api/inviteBid/saveBid?
        // userId=fec25c7f7634448581e21876ef517c57&
        // inviteBid.id=c49b327e6695453c8b56f2f2ba4c1901&
        // bidPrice=9999&
        // downPayment=4444&
        // remarks=12321321&
        // attachment&
        // bidDate=2016-11-18 18:10:27&
        // bidCompany.id=ee45bdbac1df402a8a7b6e195ab6ce53
        if (!ExampleUtil.isConnected(this)) {
            Toast.makeText(this, "请检查你的网络！", Toast.LENGTH_SHORT).show();
        } else {
            RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/saveBid");
            rp.addBodyParameter("userId", sp.getString("USER_ID", null));
            rp.addBodyParameter("bidCompany.id", sp.getString("COMPANY_ID", null));
            rp.addBodyParameter("title",title);
            rp.addBodyParameter("inviteBid.id", inviteBidId);
            rp.addBodyParameter("bidPrice", singleprice);
            rp.addBodyParameter("remarks", note);
            rp.addBodyParameter("attachment", attachment);
            rp.addBodyParameter("productionCycle", handdate);
            rp.addBodyParameter("productionCycleUnit",dateType);
            x.http().post(rp, new Callback.CacheCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Gson gson = new Gson();
                    Response response = gson.fromJson(result, Response.class);
                    Log.e("BidApplication", result);
                    if ("00000".equals(response.getErrorCode())) {
                        final AlertDialog alertDialog = new AlertDialog.Builder(BidApplication.this).create();
                       // View view=View.inflate(BidApplication.this,R.layout.dialog_custom_bid,null);
                        alertDialog.show();
                        alertDialog.setCanceledOnTouchOutside(false);
                        alertDialog.setContentView(R.layout.dialog_custom_bid);
                        Window window=alertDialog.getWindow();
                        WindowManager.LayoutParams lp =window.getAttributes();
                        window.setGravity(Gravity.CENTER);
                        Display d = getWindowManager().getDefaultDisplay(); // 获取屏幕宽、高用
                        //  lp.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
                        lp.width = (int) (d.getWidth()*0.9); // 宽度设置为屏幕的1/2
                        window.setWindowAnimations(R.style.dialogAnimation);
                        window.setAttributes(lp);

                        window.findViewById(R.id.tv_continue).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(BidApplication.this, BidAccordWithTender.class);
                                startActivity(intent);
                                alertDialog.dismiss();
                            }
                        });
                        window.findViewById(R.id.tv_seek).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(BidApplication.this, MyBidQueue.class);
                                startActivity(intent);
                                alertDialog.dismiss();
                            }
                        });
                        alertDialog.getWindow().setWindowAnimations(R.style.dialogAnimationTranslate);
                       /* AnimatorSet animatorSet = new AnimatorSet();
                        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(view, "alpha", 1, 1, 1, 1, 1, 1, 1, 1);
                        ObjectAnimator animatorRotation = ObjectAnimator.ofFloat(view, "rotation", 0, 10, -10, 6, -6, 3, -3, 0);
                        animatorSet.playTogether(animatorAlpha, animatorRotation);
                        animatorSet.setDuration(1500);
                        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                        animatorSet.start();*/

                    } else {
                        Toast.makeText(BidApplication.this, "投标失败！", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {
                    Toast.makeText(BidApplication.this, "投标失败！", Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_UPLOAD && resultCode == RESULT_OK && null != data) {
            Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
            final String path = ExampleUtil.getPathByUri4kitkat(BidApplication.this, uri);
            tv_file_name.setText(path);

            PutObjectRequest put = OssService.upLoad("blanink", path, path);

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