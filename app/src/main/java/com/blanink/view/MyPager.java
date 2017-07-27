package com.blanink.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import com.blanink.R;
import com.blanink.utils.NetUrlUtils;

import org.xutils.x;

import java.util.List;


/**
 * Created by Administrator on 2017/1/5.
 */

public class MyPager extends RelativeLayout {
    private ViewPager viewPager;
    private LinearLayout ll_viewpager_bottom;
    public MyPager(Context context) {
        super(context);
        initView(context);
    }
    public MyPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }
    private void initView(Context context) {
        View view=View.inflate(context,R.layout.custom_view_pager,this);
        viewPager = ((ViewPager)view.findViewById(R.id.viewPager));
        ll_viewpager_bottom = ((LinearLayout)view.findViewById(R.id.ll_viewpager_bottom));

    }
//初始化viewpager 底部小圆圈
    private void initOval(String[] drawableLists){
         if(drawableLists==null){
             drawableLists=null;
         }
        for (int i=0;i<drawableLists.length;i++){
            View view =new View(getContext());
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(8,8);
            layoutParams.leftMargin=10;
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(R.drawable.selector_oval);
            ll_viewpager_bottom.addView(view);
        }
    }
    //底部圆圈选中状态切换
    private  void ovalselected(String[] drawableLists) {
        int currentPage=viewPager.getCurrentItem()%drawableLists.length;
        for (int i=0;i<drawableLists.length;i++){
            ll_viewpager_bottom.getChildAt(i).setEnabled(currentPage==i);
        }
    }
 //
    public  void  pictureRoll(final String[] drawableLists){
        //动态初始化底部圆圈
        initOval(drawableLists);

        viewPager.setAdapter(new MyPagerAdapter(drawableLists));
        //
        int current=(Integer.MAX_VALUE/2)%drawableLists.length;
        viewPager.setCurrentItem((Integer.MAX_VALUE/2-current));
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

    //适配器
    private class MyPagerAdapter extends PagerAdapter {
        private String[] drawableLists;

        public MyPagerAdapter(String[] drawableLists) {
            this.drawableLists = drawableLists;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView=new ImageView(getContext());
            x.image().bind(imageView,drawableLists[position%drawableLists.length]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            container.addView(imageView);
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
/*
                    Intent intent =new Intent(getContext(),AdvertiseActivity.class);
                    getContext().startActivity(intent);*/
                }
            });
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);
        }


    }

}
