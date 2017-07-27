package com.blanink.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/5.
 * 记住密码的工具类
 */
public class RePsdUtils {
    /**
     *
     * @param context
     * @param loginName 账户
     * @param psd 密码
     */
    public static void saveLoginPsd(Context context,String loginName, String psd){
        SharedPreferences sp=context.getSharedPreferences("USER",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("loginName",loginName);
        editor.putString("psd",psd);
        editor.commit();

    }

    /**
     *
     * @param context
     * @return
     */
    public static Map<String,String> getLoginPsd(Context context){
        Map<String,String> map=new HashMap<>();
        SharedPreferences sp=context.getSharedPreferences("USER",Context.MODE_PRIVATE);
        String loginName=sp.getString("loginName",null);
        String psd=sp.getString("psd",null);
        map.put(loginName,psd);
        return map;
    }
}
