package com.blanink.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.blanink.bean.Response;
import com.blanink.bean.TenderAndBid;
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

    private static final int RESULT_UPLOAD =1 ;
    private ImageView bid_apply_iv_last;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_application);
         oss= OssService.getOSSClient(BidApplication.this);
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
        bid_apply_iv_last = ((ImageView) findViewById(R.id.bid_apply_iv_last));
        btn_upload = ((Button) findViewById(R.id.btn_upload));//上传
        et_price = ((EditText) findViewById(R.id.et_price));//单价
        et_note = ((EditText) findViewById(R.id.et_note));//备注
        et_hand_date = ((TextView) findViewById(R.id.et_hand_date));//交货日期
        iv_upload = ((ImageView) findViewById(R.id.iv_upload));//上传附件
        tv_file_name = ((TextView) findViewById(R.id.tv_file_name));//文件名字
    }

    private void initData() {
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
                    Toast.makeText(BidApplication.this, "请输入交货日期", Toast.LENGTH_SHORT).show();
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
                startActivityForResult(intent,RESULT_UPLOAD);
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
            rp.addBodyParameter("inviteBid.id", inviteBidId);
            rp.addBodyParameter("bidPrice", singleprice);
            rp.addBodyParameter("remarks", note);
            rp.addBodyParameter("attachment", attachment);
            rp.addBodyParameter("bidDate", handdate);
            rp.addBodyParameter("bidCompany.id", sp.getString("COMPANY_ID",null));
            x.http().post(rp, new Callback.CacheCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Gson gson = new Gson();
                    Response response = gson.fromJson(result, Response.class);
                    Log.e("BidApplication",result);
                    if ("00000".equals(response.getErrorCode())) {
                        Toast.makeText(BidApplication.this, "投标成功！", Toast.LENGTH_SHORT).show();
                        AlertDialog alertDialog=new AlertDialog.Builder(BidApplication.this).create();
                        alertDialog.setTitle("投标成功");
                        alertDialog.setIcon(R.drawable.icon);
                        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "查看我的投标", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(BidApplication.this,MyBidQueue.class);
                                startActivity(intent);
                            }
                        });
                        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "继续投标", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(BidApplication.this,BidAccordWithTender.class);
                                startActivity(intent);
                                finish();

                            }
                        });
                        alertDialog.show();

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

            PutObjectRequest put= OssService.upLoad("blanink",path,path);

            OSSAsyncTask task = oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                @Override
                public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                    Log.d("TenderPublish", "UploadSuccess");
                    Log.d("TenderPublish","ETag:"+ result.getETag());
                    Log.d("TenderPublish","RequestId:"+ result.getRequestId());
                    String backReuslt=result.getServerCallbackReturnBody();
                    Log.d("TenderPublish","ServerCallbackReturnBody():"+ result.getServerCallbackReturnBody());
                    //http://blanink.oss-cn-hangzhou.aliyuncs.com/com_blanink_96x96
                    attachment="blanink.oss-cn-hangzhou.aliyuncs.com/"+ExampleUtil.getFileName(path);
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
                        Log.e("TenderPublish", "ErrorCode:"+serviceException.getErrorCode());
                        Log.e("TenderPublish","RequestId:"+ serviceException.getRequestId());
                        Log.e("TenderPublish","HostId:"+ serviceException.getHostId());
                        Log.e("TenderPublish","RawMessage:"+ serviceException.getRawMessage());
                    }
                }
            });
        }
    }}