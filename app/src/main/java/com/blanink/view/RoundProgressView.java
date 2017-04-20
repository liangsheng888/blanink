package com.blanink.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.blanink.R;

/**
 * Created by Administrator on 2017/3/24.
 */

public class RoundProgressView extends RelativeLayout {
    public RoundProgressView(Context context) {
        super(context);
        initView(context);

    }

    public RoundProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public RoundProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }
    public void initView(Context context){
        View view=View.inflate(context, R.layout.custom_view,null);


    }
}
