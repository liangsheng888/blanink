package com.blanink.view;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.blanink.R;
import com.blanink.adapter.MyPagerAdapter;
import com.bumptech.glide.Glide;

import org.xutils.x;

import java.util.List;


/**
 * Created by Administrator on 2017/1/5.
 */

public class MyPagerList extends RelativeLayout {
    private ViewPager viewPager;
    private LinearLayout ll_viewpager_bottom;
    public MyPagerList(Context context) {
        super(context);
        initView(context);
    }

    public MyPagerList(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.custom_view_pager, this);
        viewPager = ((ViewPager) view.findViewById(R.id.viewPager));
        ll_viewpager_bottom = ((LinearLayout) view.findViewById(R.id.ll_viewpager_bottom));

    }

    //初始化viewpager 底部小圆圈
    private void initOval(List<String> drawableLists) {
        if (drawableLists == null) {
            drawableLists = null;
        }
        for (int i = 0; i < drawableLists.size(); i++) {
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(8, 8);
            layoutParams.leftMargin = 10;
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(R.drawable.selector_oval);
            ll_viewpager_bottom.addView(view);
        }
    }

    //底部圆圈选中状态切换
    private void ovalselected(List<String> drawableLists) {
        int currentPage = viewPager.getCurrentItem() % drawableLists.size();
        for (int i = 0; i < drawableLists.size(); i++) {
            ll_viewpager_bottom.getChildAt(i).setEnabled(currentPage == i);
        }
    }

    //
    public void pictureRoll(final List<String> drawableLists) {
        //动态初始化底部圆圈
        initOval(drawableLists);

        viewPager.setAdapter(new MyPagerAdapter(getContext(),drawableLists));
        //
        viewPager.setOffscreenPageLimit(0);

        int current = (Integer.MAX_VALUE / 2) % drawableLists.size();
        //viewPager.setCurrentItem((Integer.MAX_VALUE / 2 - current));
        //
        ovalselected(drawableLists);
        //

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ovalselected(drawableLists);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
