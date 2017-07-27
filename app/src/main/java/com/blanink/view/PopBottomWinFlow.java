package com.blanink.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.utils.SysConstants;

public class PopBottomWinFlow extends PopupWindow {

    private Context mContext;

    private View view;

    private TextView tv_publish, tv_seek_progress, tv_modify, tv_cancel,tv_seek,tv_remark;


    public PopBottomWinFlow(Context mContext, View.OnClickListener itemsOnClick, String status) {

        this.view = LayoutInflater.from(mContext).inflate(R.layout.pop_flow, null);
        tv_publish = (TextView) view.findViewById(R.id.tv_public);
        tv_seek_progress = (TextView) view.findViewById(R.id.tv_seek_progress);
        tv_modify = (TextView) view.findViewById(R.id.tv_modify);
        tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        tv_seek = (TextView) view.findViewById(R.id.tv_seek);
        tv_remark = (TextView) view.findViewById(R.id.tv_remark);
        // 设置按钮监听
        if("1".equals(status)){
            tv_publish.setVisibility(View.VISIBLE);
            tv_modify.setVisibility(View.VISIBLE);
            tv_seek_progress.setVisibility(View.GONE);
        }
        tv_remark.setOnClickListener(itemsOnClick);
        tv_publish.setOnClickListener(itemsOnClick);
        tv_seek_progress.setOnClickListener(itemsOnClick);
        tv_modify.setOnClickListener(itemsOnClick);
        tv_seek.setOnClickListener(itemsOnClick);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        // 设置外部可点击
        this.setOutsideTouchable(true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        this.view.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = view.findViewById(R.id.pop_layout).getTop();

                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });


        /* 设置弹出窗口特征 */
        // 设置视图
        this.setContentView(this.view);
        // 设置弹出窗体的宽和高
        this.setHeight(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);

        // 设置弹出窗体可点击
        this.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        // 设置弹出窗体的背景
        this.setBackgroundDrawable(dw);

        // 设置弹出窗体显示时的动画，从底部向上弹出
        this.setAnimationStyle(R.style.take_photo_anim);

    }
}
