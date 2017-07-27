package com.blanink.activity;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

/*import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;*/

import com.blanink.activity.EaseChat.modle.DemoHelper;

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

   /*  //初始化EaseUI
         EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
        //设置自动登录
        options.setAutoLogin(true);
        EaseUI.getInstance().init(this,options);*/
        //初始化jpush

        JPushInterface.init(this);
        JPushInterface.setDebugMode(true);
    }
    public static MyApplication getInstance() {
        return instance;
    }


}
