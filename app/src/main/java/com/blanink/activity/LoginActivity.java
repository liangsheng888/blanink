package com.blanink.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.LoginResult;
import com.blanink.utils.CheckNetIsConncet;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/***
 * 登录界面
 */
public class LoginActivity extends AppCompatActivity {
    private static final int MSG_SET_ALIAS = 1001;
    private static final int MSG_SET_TAGS = 1002;

    private static final String TAG = "LoginActivity";
    private EditText et_user;
    private EditText et_psd;
    private Button btn_login;
    private TextView tv_forget;
    private RelativeLayout rl_login_progress;
    private ImageView imageView;
    private AnimationDrawable loadingDrawable;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_SET_ALIAS:
                    JPushInterface.setAliasAndTags(getApplicationContext(), (String) msg.obj, null, mAliasCallback);
                    break;

                case MSG_SET_TAGS:
                    JPushInterface.setAliasAndTags(getApplicationContext(), null, (Set<String>) msg.obj, mTagsCallback);
                    break;

                default:

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initView();
        initData();
    }

    private void initView() {
        et_user = ((EditText) findViewById(R.id.et_user));//找到账户
        et_psd = ((EditText) findViewById(R.id.et_psd));//找到密码
        btn_login = ((Button) findViewById(R.id.btn_login));//登录
        tv_forget = ((TextView) findViewById(R.id.tv_forget));//忘记密码
        rl_login_progress = ((RelativeLayout) findViewById(R.id.rl_login_progress));
        imageView = (ImageView) findViewById(R.id.loading_img);


    }

    private void initData() {

        //登录验证
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得输入的账户，密码
                final String userName = et_user.getText().toString();
                final String passWord = et_psd.getText().toString();
                if (TextUtils.isEmpty(userName)) {
                    Toast.makeText(LoginActivity.this, "账户不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passWord)) {
                    Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                final Boolean isConnect = CheckNetIsConncet.isNetWorkConnected(LoginActivity.this);
                //检查网络是否连接，
                rl_login_progress.setVisibility(View.VISIBLE);
               /* loadingDrawable = (AnimationDrawable) imageView.getBackground();
                loadingDrawable.start();*/

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        if (isConnect) {
                            //登录状态设置为显示
                            RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "login");
                            Log.e("login", "Url:" + NetUrlUtils.NET_URL + "login");
                            requestParams.addBodyParameter("loginName", userName);
                            requestParams.addBodyParameter("password", passWord);
                            x.http().post(requestParams, new Callback.CacheCallback<String>() {
                                @Override
                                public void onSuccess(String result) {
                                    rl_login_progress.setVisibility(View.INVISIBLE);
                                    Log.e("LoginActivity", "result:" + result.toString());
                                    Gson gson = new Gson();
                                    LoginResult loginResult = gson.fromJson(result, LoginResult.class);
                                    Log.e("LoginActivity", "loginResult:" + loginResult.toString());
                                    if ("00000".equals(loginResult.getErrorCode())) {
                                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                        //保存用户信息
                                        SharedPreferences.Editor ed = sp.edit();
                                        ed.putString("COMPANY_ID",loginResult.getResult().company.id);
                                        ed.putString("USER_ID", loginResult.getResult().id);
                                        ed.putString("LOGIN_NAME", loginResult.getResult().loginName);
                                        ed.putString("NAME", loginResult.getResult().name);
                                        ed.putString("PHONE", loginResult.getResult().phone);
                                        ed.putString("MOBILE", loginResult.getResult().mobile);
                                        ed.putString("PHOTO", loginResult.getResult().photo);
                                        ed.putString("ROLE_LIST",loginResult.getResult().roleList.toString());
                                        ed.putString("PASSWORD",passWord);
                                        ed.putString("COMPANY_TYPE",loginResult.getResult().office.serviceType);
                                        ed.commit();
                                        setAlias(loginResult.getResult().id);
                                        RegisterUser(loginResult.getResult().id, passWord);
                                        if (loginResult.getResult().admin) {
                                            //跳转到管理员界面
                                            Intent intent = new Intent(LoginActivity.this, FlashActivity.class);
                                            startActivity(intent);
                                        } else {
                                            //跳转到普通用户界面
                                            Intent intent = new Intent(LoginActivity.this, FlashActivity.class);
                                            startActivity(intent);
                                        }

                                    } else {
                                        rl_login_progress.setVisibility(View.GONE);
                                        Toast.makeText(LoginActivity.this, "用户或密码错误, 请重试！", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onError(Throwable ex, boolean isOnCallback) {
                                    Log.e("LoginActivity",ex.toString());
                                    rl_login_progress.setVisibility(View.INVISIBLE);
                                    Toast.makeText(LoginActivity.this, "服务器无响应！", Toast.LENGTH_SHORT).show();
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

                        } else {
                            rl_login_progress.setVisibility(View.INVISIBLE);
                            Toast.makeText(LoginActivity.this, "你的网络有问题，请检查网络", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, 1500);


            }
        });
        //忘记密码
        tv_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "点击了忘记密码", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    //注册环信账户
    private void RegisterUser(final String username, final String psd) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 注册方法，同步，需要自己异步执行，根据执行情况判断是否注册成功

                    EMClient.getInstance().createAccount(username, psd);
                } catch (HyphenateException e) {
                    e.printStackTrace();
                    Log.e("register", "注册失败");
                }
            }
        }).start();
    }

    //设置别名（Jpush）
    private void setAlias(String alias) {
        if (TextUtils.isEmpty(alias)) {
            return;
        }
        if (!ExampleUtil.isValidTagAndAlias(alias)) {
            return;
        }

        //调用JPush API设置Alias
        mHandler.sendMessage(mHandler.obtainMessage(MSG_SET_ALIAS, alias));
    }

    private TagAliasCallback mAliasCallback = new TagAliasCallback() {
        @Override
        public void gotResult(int code, String alias, Set<String> tags) {
            String logs;
            switch (code) {
                case 0:
                    logs = "Set tag and alias success";
                    Log.i(TAG, logs);
                    // 建议这里往 SharePreference 里写一个成功设置的状态。成功设置一次后，以后不必再次设置了。
                    break;
                case 6002:
                    logs = "Failed to set alias and tags due to timeout. Try again after 60s.";
                    Log.i(TAG, logs);
                    // 延迟 60 秒来调用 Handler 设置别名
                    mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_SET_ALIAS, alias), 1000 * 60);
                    break;
                default:
                    logs = "Failed with errorCode = " + code;
                    Log.e(TAG, logs);
            }
           // ExampleUtil.showToast(logs, getApplicationContext());
        }
    };


    private final TagAliasCallback mTagsCallback = new TagAliasCallback() {

        @Override
        public void gotResult(int code, String alias, Set<String> tags) {
            String logs;
            switch (code) {
                case 0:
                    logs = "Set tag and alias success";
                    Log.i(TAG, logs);
                    break;

                case 6002:
                    logs = "Failed to set alias and tags due to timeout. Try again after 60s.";
                    Log.i(TAG, logs);
                    if (ExampleUtil.isConnected(getApplicationContext())) {
                        mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_SET_TAGS, tags), 1000 * 60);
                    } else {
                        Log.i(TAG, "No network");
                    }
                    break;

                default:
                    logs = "Failed with errorCode = " + code;
                    Log.e(TAG, logs);
            }

            // ExampleUtil.showToast(logs, getApplicationContext());
        }

    };

}
