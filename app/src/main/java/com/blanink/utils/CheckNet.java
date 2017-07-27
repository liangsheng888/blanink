package com.blanink.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Patterns;

/**
 * Created by Administrator on 2017/1/11.
 * 判断网络是否连接
 */

public class CheckNet {
    private CheckNet(){}

    public static boolean isNetWorkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable() && mNetworkInfo.isConnected();
            }
        }

        return false;
    }

    public static Boolean checkedURLIsUseful(String url) {


        if (Patterns.WEB_URL.matcher(url).matches()) {
            return  true;
            //符合标准
        } else {
            //不符合标准
            return false;
        }
    }
}
