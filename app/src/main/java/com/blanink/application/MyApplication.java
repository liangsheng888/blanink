package com.blanink.application;

import android.app.Application;

/*import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;*/

import org.xutils.BuildConfig;
import org.xutils.x;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2016/12/26.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化xutils
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
       /* //初始化EaseUI
        EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
        //设置不自动登录
        options.setAutoLogin(true);
        EaseUI.getInstance().init(this,options);*/
        //初始化
        JPushInterface.init(this);
        JPushInterface.setDebugMode(true);
    }
}
