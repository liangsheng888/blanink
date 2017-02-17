package com.blanink.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blanink.R;

import java.util.List;

/**
 * Created by Administrator on 2017/1/3.
 */

public class AutoAdvertise {
    private ViewPager viewPager;
    private Context context;
    private LinearLayout ll_viewpager_bottom;
    private List<Integer> drawableLists;
    public AutoAdvertise(Context context,ViewPager viewPager, LinearLayout ll_viewpager_bottom, List<Integer> drawableLists) {
        this.context=context;
        this.viewPager = viewPager;
        this.ll_viewpager_bottom = ll_viewpager_bottom;
        this.drawableLists = drawableLists;
    }
    //handler 实现每三秒切换一张图片
      private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            handler.sendEmptyMessageDelayed(0,3000);

        }
    };

    public  void  pictureRoll(){
        //动态初始化底部圆圈
        for (int i=0;i<drawableLists.size();i++){
            View view =new View(context);
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(8,8);
            layoutParams.leftMargin=10;
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(R.drawable.selector_oval);
            ll_viewpager_bottom.addView(view);
        }

        viewPager.setAdapter(new MyPagerAdapter(context,drawableLists));
        //
        int current=(Integer.MAX_VALUE/2)%drawableLists.size();
        viewPager.setCurrentItem((Integer.MAX_VALUE/2-current));
        //
        ovalselected();
        //
        handler.sendEmptyMessageDelayed(0,3000);//三秒后向ui线程发送消息切换图片

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ovalselected();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    //底部圆圈选中状态切换
    private  void ovalselected() {
        int currentPage=viewPager.getCurrentItem()%drawableLists.size();
        for (int i=0;i<drawableLists.size();i++){
            ll_viewpager_bottom.getChildAt(i).setEnabled(currentPage==i);
        }
    }
//适配器
    private static class MyPagerAdapter extends PagerAdapter {
        private Context context;
        private List<Integer> drawableLists;

        public MyPagerAdapter(Context context, List<Integer> drawableLists) {
            this.context = context;
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
            ImageView imageView=new ImageView(context);
            imageView.setImageResource(drawableLists.get(position%drawableLists.size()));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);
        }


    }

}
