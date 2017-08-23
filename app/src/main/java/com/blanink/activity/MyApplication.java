package com.blanink.activity;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

/*import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;*/

import com.blanink.activity.EaseChat.modle.DemoHelper;
import com.videogo.openapi.EZOpenSDK;

import org.xutils.BuildConfig;
import org.xutils.x;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2016/12/26.
 */
public class MyApplication extends MultiDexApplication {
    public static Context applicationContext;
    private static MyApplication instance;
    // login user name
    public final String PREF_USERNAME = "username";
    public static String currentUserNick = "";

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
        instance = this;

        //init demo helper
        DemoHelper.getInstance().init(applicationContext);
        //初始化xutils
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

        JPushInterface.init(this);
        JPushInterface.setDebugMode(true);
        initSDK();
    }
    public static EZOpenSDK getOpenSDK() {
        return EZOpenSDK.getInstance();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    private void initSDK() {
        {
            /**
             * sdk日志开关，正式发布需要去掉
             */
            EZOpenSDK.showSDKLog(true);

            /**
             * 设置是否支持P2P取流,详见api
             */
            EZOpenSDK.enableP2P(false);

            /**
             * APP_KEY请替换成自己申请的f09a38faf1f04203ae33672ea5b1774a
             */
            EZOpenSDK.initLib(this, "f09a38faf1f04203ae33672ea5b1774a", "");
        }
    }
}
