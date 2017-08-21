package com.blanink.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.VersionInfo;
import com.blanink.utils.CommonUtil;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/6.
 */

public class FlashActivity extends Activity {
    MyActivityManager myActivityManager;
    @BindView(R.id.tv_version_name)
    TextView tvVersionName;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.pb_downLoad)
    ProgressBar pbDownLoad;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        ButterKnife.bind(this);
        myActivityManager = (MyActivityManager) MyActivityManager.getInstance();
        sp=getSharedPreferences("USER",MODE_PRIVATE);
        myActivityManager.pushOneActivity(this);
        initData();
    }

    private void initData() {
        tvVersionName.setText(CommonUtil.getVersion(this));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //查看是否有新版本
                RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "Version/getVersionInfo");
                x.http().post(rp, new Callback.CacheCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        VersionInfo versionInfo = gson.fromJson(result, VersionInfo.class);
                        if (CommonUtil.GetVersionCode(FlashActivity.this) < versionInfo.getResult().getVersionCode()) {
                            showDialog(versionInfo.getResult().getVersionName());
                        } else {
                            if(sp.getString("loginName",null)!=null){
                                Intent intent = new Intent(FlashActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }else {
                                Intent intent = new Intent(FlashActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Intent intent = new Intent(FlashActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
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
        }, 3000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    private void showDialog(String versionName) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_update);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        WindowManager windowManager = getWindowManager();
        Display d = windowManager.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setAttributes(lp);
        alertDialog.setCanceledOnTouchOutside(false);
        ((TextView) (window.findViewById(R.id.tv_version_name))).setText("最新版本" + versionName);
        window.findViewById(R.id.tv_ingnore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                if(sp.getString("loginName",null)!=null){
                    Intent intent = new Intent(FlashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(FlashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        window.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlashActivity.this, UpdateActivity.class);
                startActivity(intent);
                alertDialog.dismiss();
                finish();

            }
        });
    }


}
