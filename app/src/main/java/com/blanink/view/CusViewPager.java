package com.blanink.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/7/26.
 */
public class CusViewPager extends ViewPager {
    //定义一个布尔变量来控制是否允许滑动，该变量的set方法就直接决定了该viewpager是否可以滑动
    private boolean enabled;


    public CusViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.enabled = false;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onTouchEvent(event);
        }

        return false;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }

    public void setPagingEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
