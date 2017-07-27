package com.blanink.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;

/**
 * Created by Administrator on 2017/3/28.
 */

public class DialogLoadUtils {
    private static AlertDialog alertDialog;
    public static Context context;

    public static AlertDialog getInstance(Context ct) {
        context = ct;
        alertDialog = new AlertDialog.Builder(context).create();
        return alertDialog;
    }

    public static void showDialogLoad(String title) {
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setContentView(R.layout.dialog_custom_progress);
        Window window = alertDialog.getWindow();
        ((TextView) window.findViewById(R.id.tv_name)).setText(title);
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        WindowManager windowManager = (WindowManager)
                context.getSystemService(Context.WINDOW_SERVICE);
        Display d = windowManager.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth() * 0.4); // 宽度设置为屏幕的1/2*/
        window.setAttributes(lp);
    }

    public static void dismissDialog() {
        alertDialog.dismiss();
    }

}
