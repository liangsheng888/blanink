package com.blanink.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;

/**
 * Created by Administrator on 2017/6/7.
 */
public class CusRect extends LinearLayout {

    OnButtonClickListener listener;
    private Button bt;
    private TextView text;
    private TextView tvNum;

    public CusRect(Context context) {
        super(context);
        initView(context);
    }



    public CusRect(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CusRect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    private void initView(Context context) {
        View view=View.inflate(getContext(),R.layout.item_flow,this);
        bt=(Button) view.findViewById(R.id.bt_flow);
        text=(TextView) view.findViewById(R.id.tv_flow);
        tvNum = ((TextView) view.findViewById(R.id.tv_process_num));

    }
    public void setOnButtonClickListener(final OnButtonClickListener listener){
        bt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonClick(v);
            }
        });
    }
    public interface OnButtonClickListener{
        void onButtonClick(View v);
    }

    public void setTile(String title){
        text.setText(title);
    }
    public void setTileColor(int color){
        text.setTextColor(color);
        tvNum.setTextColor(color);
    }
    public void setNum(String num){
        tvNum.setText(num);
    }
    public String getTile(){
        return text.getText().toString();
    }
}
