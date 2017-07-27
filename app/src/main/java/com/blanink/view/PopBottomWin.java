package com.blanink.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.utils.SysConstants;

public class PopBottomWin extends PopupWindow {

    private Context mContext;

    private View view;

    private TextView tv_add_note, tv_down_send, tv_give_A, tv_seek_progress, tv_modify, tv_remark, tv_refuse, tv_cancel;


    public PopBottomWin(Context mContext, View.OnClickListener itemsOnClick, String orderProductStatus) {

        this.view = LayoutInflater.from(mContext).inflate(R.layout.popwin_layout, null);
        Log.e("@@@@","产品状态:"+orderProductStatus);
        tv_add_note = (TextView) view.findViewById(R.id.tv_add_note);
        tv_give_A = (TextView) view.findViewById(R.id.tv_give_A);
        tv_down_send = (TextView) view.findViewById(R.id.tv_down_send);
        tv_seek_progress = (TextView) view.findViewById(R.id.tv_seek_progress);
        tv_modify = (TextView) view.findViewById(R.id.tv_modify);
        tv_remark = (TextView) view.findViewById(R.id.tv_remark);
        tv_refuse = (TextView) view.findViewById(R.id.tv_refuse);
        tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        //编辑
        if (SysConstants.ORDER_PRODUCT_STATUS_BACK_TO_A_CONFIRMED_TO_B.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_A_CONBINED_SEND.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_CREATED.equals(orderProductStatus)) {
            tv_modify.setVisibility(View.VISIBLE);
        }

        if (SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_FLOW_PULISHED.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_PRODUCTION_END.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_DELIEVERY_PART.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_DELIEVERY_OVER.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_RECEIVED_PART.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_RECEIVED_OVER.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_COMMENT_OVER.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_AFTERSALES_START.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_AFTERSALES_DEALING.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_AFTERSALES_DEALING_OVER.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_SRTATUS_REJECT_TAKE.equals(orderProductStatus)
         ) {
            tv_seek_progress.setVisibility(View.VISIBLE);
        }
        //下发
        if (SysConstants.ORDER_PRODUCT_STATUS_BACK_TO_A_CONFIRMED_TO_B.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_A_CONBINED_SEND.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_CREATED.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_AFTERSALES_DEALING.equals(orderProductStatus))

        {
            tv_down_send.setVisibility(View.VISIBLE);
        }

//打回  //给甲方

        if (SysConstants.ORDER_PRODUCT_STATUS_BACK_TO_A_CONFIRMED_TO_B.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_A_CONBINED_SEND.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_CREATED.equals(orderProductStatus)
                || SysConstants.ORDER_PRODUCT_STATUS_AFTERSALES_DEALING.equals(orderProductStatus)) {

            tv_give_A.setVisibility(View.VISIBLE);

            tv_refuse.setVisibility(View.VISIBLE);

        }

        //评价
        if(SysConstants.ORDER_PRODUCT_STATUS_COMPANY_A_CREATED.equals(orderProductStatus)||
                SysConstants.ORDER_PRODUCT_STATUS_COMPANY_A_CONBINED.equals(orderProductStatus)||
                SysConstants.ORDER_PRODUCT_STATUS_COMPANY_A_CONBINED_SEND.equals(orderProductStatus)||
                SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_CREATED.equals(orderProductStatus)||
                SysConstants.ORDER_PRODUCT_STATUS_BACK_TO_A.equals(orderProductStatus)||
                SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_DISTRIBUTE.equals(orderProductStatus)||
                SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_FLOW_CREATED.equals(orderProductStatus)||
                SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_FLOW_PULISHED.equals(orderProductStatus)||
                SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_PRODUCTION_END.equals(orderProductStatus)||
                SysConstants.ORDER_PRODUCT_SRTATUS_REJECT.equals(orderProductStatus)||
                SysConstants.ORDER_PRODUCT_SRTATUS_REJECT_TAKE.equals(orderProductStatus)){
            tv_remark.setVisibility(View.GONE);
        }

        // 设置按钮监听
        tv_add_note.setOnClickListener(itemsOnClick);
        tv_give_A.setOnClickListener(itemsOnClick);
        tv_down_send.setOnClickListener(itemsOnClick);
        tv_seek_progress.setOnClickListener(itemsOnClick);
        tv_modify.setOnClickListener(itemsOnClick);
        tv_remark.setOnClickListener(itemsOnClick);
        tv_refuse.setOnClickListener(itemsOnClick);
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
