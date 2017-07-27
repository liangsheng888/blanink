package com.blanink.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.blanink.R;

/**
 * Created by Administrator on 2017/7/25.
 */
public class CusProgressView extends RelativeLayout {
    private AnimationDrawable loadingDrawable;

    public CusProgressView(Context context) {
        super(context);
        initView(context);

    }



    public CusProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public CusProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }
    private void initView(Context context) {
        View view=View.inflate(context, R.layout.layout_progrss,this);
        ImageView iv=((ImageView) view.findViewById(R.id.loading_img));
        loadingDrawable = (AnimationDrawable) iv.getBackground();
        loadingDrawable.start();
    }

    public void stop(){
        loadingDrawable.stop();
    }
}
