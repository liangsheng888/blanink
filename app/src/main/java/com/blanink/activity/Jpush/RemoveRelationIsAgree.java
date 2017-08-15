package com.blanink.activity.Jpush;

import android.content.DialogInterface;
import android.content.SharedPreferences;
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

import com.blanink.R;
import com.blanink.pojo.Response;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import cn.jpush.android.api.JPushInterface;

/**
 * 解除合作关系 是否同意
 */
public class RemoveRelationIsAgree extends AppCompatActivity {
    private static final String TAG ="RemoveRelationIsAgree" ;
    private SharedPreferences sp;
    private String title = null;
    private String content = null;
    private String extras=null;
    private String user_id=null;
    private TextView tv_reason;
    private Button btn_agree;
    private Button btn_not_agree;
    private Button btn_ignore;
    private MyActivityManager myActivityManager;
    private ImageView customer_apply_iv_last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_relation_is_agree);
        sp=getSharedPreferences("DATA",MODE_PRIVATE);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        ReceivejpushData();
        initView();
        initData();
    }
    private void initView() {
        tv_reason = ((TextView) findViewById(R.id.tv_reason));
        btn_agree = ((Button) findViewById(R.id.btn_agree));
        btn_not_agree = ((Button) findViewById(R.id.btn_reject));
        btn_ignore = ((Button) findViewById(R.id.btn_ignore));
        customer_apply_iv_last = ((ImageView) findViewById(R.id.customer_apply_iv_last));//返回

    }

    private void initData() {
        tv_reason.setText(content);
        customer_apply_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //同意
        btn_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog=new AlertDialog.Builder(RemoveRelationIsAgree.this).create();
                dialog.setTitle("提示");
                dialog.setMessage("确定要同意吗？点击同意，合作关系取消！");
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "同意", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        RequestParams requestParams=new RequestParams(NetUrlUtils.NET_URL+"partner/agree");
                        requestParams.addBodyParameter("userId",sp.getString("USER_ID",null));
                        requestParams.addBodyParameter("id",user_id);
                        x.http().post(requestParams, new Callback.CacheCallback<String>() {
                            @Override
                            public void onSuccess(String result) {
                                Gson gson=new Gson();
                                String errorCode= gson.fromJson(result, Response.class).getErrorCode();
                                Log.e(TAG,result);
                                if("00000".equals(errorCode)){
                                    //操作成功，向对方发送通知提醒
                                    Toast.makeText(RemoveRelationIsAgree.this, "解除合作关系成功", Toast.LENGTH_SHORT).show();
                                    RequestParams rp=new RequestParams("http://192.168.199.147:8080/Jpush/jpushServlet");
                                    rp.addBodyParameter("alias",user_id);
                                    rp.addBodyParameter("title","解除合作关系通知");
                                    rp.addBodyParameter("content","关于你向对方申请解除合作关系的申请，对方已经同意，双方合作关系解除，立即生效");
                                    rp.addBodyParameter("type","3");
                                    rp.addBodyParameter("userId",sp.getString("USER_ID",null));
                                    x.http().post(rp, new CacheCallback<String>() {
                                        @Override
                                        public void onSuccess(String result) {

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
                                    finish();
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
                });
                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();


            }
        });
        //拒绝
        btn_not_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alertDialog=new AlertDialog.Builder(RemoveRelationIsAgree.this).create();
                View view=View.inflate(RemoveRelationIsAgree.this,R.layout.dialog_refuse,null);
                final EditText et_info=(EditText) view.findViewById(R.id.et_info);
                (view.findViewById(R.id.btn_send)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String eason=et_info.getText().toString();
                        if(TextUtils.isEmpty(eason)){
                            Toast.makeText(RemoveRelationIsAgree.this, "请填写拒绝信息", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        RequestParams rp=new RequestParams("http://192.168.199.147:8080/Jpush/jpushServlet");
                        rp.addBodyParameter("alias",user_id);
                        rp.addBodyParameter("title","申请回复");
                        rp.addBodyParameter("content",eason);
                        rp.addBodyParameter("type","3");
                        rp.addBodyParameter("userId",sp.getString("USER_ID",null));
                        x.http().post(rp, new Callback.CacheCallback<String>() {
                            @Override
                            public void onSuccess(String result) {
                               finish();
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
                });
                alertDialog.setView(view);
                alertDialog.show();
            }
        });
        //忽略
        btn_ignore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });
    }

    private void ReceivejpushData() {
        Bundle bundle = getIntent().getExtras();
         title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
         content = bundle.getString(JPushInterface.EXTRA_ALERT);
         extras= bundle.getString(JPushInterface.EXTRA_EXTRA);

        JSONObject jsonObject= null;
        try {
            jsonObject = new JSONObject(extras);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            user_id =jsonObject.getString("userId");

        } catch (JSONException e) {
            e.printStackTrace();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
