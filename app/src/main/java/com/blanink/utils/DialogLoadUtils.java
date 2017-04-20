package com.blanink.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.blanink.R;

/**
 * Created by Administrator on 2017/3/28.
 */

public class DialogLoadUtils {
    private static AlertDialog alertDialog;
    public static Context context;
    public static AlertDialog getInstance(Context context){
        alertDialog = new AlertDialog.Builder(context).create();
        return alertDialog;
    }

    public static void showDialogLoad(Context context) {
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setContentView(R.layout.dialog_custom_progress);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        WindowManager windowManager = (WindowManager)
                context.getSystemService(Context.WINDOW_SERVICE);
        Display d = windowManager.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth() * 0.4); // 宽度设置为屏幕的1/2*/
        window.setAttributes(lp);
    }

    public static void dismissDialog(){
        alertDialog.dismiss();
    }
}
