package com.blanink.fragment;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;


import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.SeekActivity;
import com.blanink.view.MyViewPager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 * 任务
 */
public class TaskFragment extends Fragment {
    private MyViewPager myViewPager;
    private ViewPager fra_task_viewPager;
    private EditText framgent_task_edt_query;
    private ImageView imageView;
    private AnimationDrawable loadingDrawable;
    private List<Fragment> fragmentLists;
    private List<Integer> drawableLists;//存放图片的集合
    private LinearLayout ll_viewpager_bottom_line;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view=View.inflate(getActivity(), R.layout.fragment_task,null);
        initView(view);
        return view;


    }

    private void initView(View view) {
        myViewPager=(MyViewPager)view.findViewById(R.id.framgment_task_vp_advertise);
        framgent_task_edt_query = ((EditText) view.findViewById(R.id.framgent_task_edt_query));
        fra_task_viewPager = ((ViewPager) view.findViewById(R.id.fra_task_viewPager));
        ll_viewpager_bottom_line=(LinearLayout) view.findViewById(R.id.ll_viewpager_bottom_line);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();

    }
    private void initData() {

        framgent_task_edt_query.clearFocus();
        framgent_task_edt_query.setCursorVisible(false);
        framgent_task_edt_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                framgent_task_edt_query.setFocusable(true);
                framgent_task_edt_query.setCursorVisible(true);
            }
        });
        //设立焦点改变监听事件
        framgent_task_edt_query.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //跳到搜索界面
                    Log.e("TaskFragment", "焦点:" + hasFocus);
                    framgent_task_edt_query.setCursorVisible(true);
                    Intent intentSeek = new Intent(getActivity(), SeekActivity.class);
                    intentSeek.putExtra("DIRECT", 0);
                    startActivity(intentSeek);
                } else {
                    framgent_task_edt_query.setCursorVisible(false);
                }
            }
        });
        // 往集合中添加图片
        drawableLists = new ArrayList<>();
        drawableLists.add(R.drawable.guanggao);
        drawableLists.add(R.drawable.guanggao1);
        drawableLists.add(R.drawable.guanggao2);
        drawableLists.add(R.drawable.guanggao3);
        //广搞轮播
        myViewPager.pictureRoll(drawableLists);

        //初始化，往集合中添加碎片
        fragmentLists = new ArrayList<>();
        fragmentLists.add(new FirstPageFragment());
        fragmentLists.add(new SecondPageFragment());
        //根据页数动态初始化底部直线
         initLine(fragmentLists);

        //绑定适配器
        fra_task_viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {

            @Override
            public int getCount() {
                return fragmentLists.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragmentLists.get(position);
            }
        });

        //  //默认选中

        fra_task_viewPager.setCurrentItem(0);
        LineChange(fragmentLists);
        //fra_task_viewPager 的切换事件
        fra_task_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                LineChange(fragmentLists);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        framgent_task_edt_query.clearFocus();
        framgent_task_edt_query.setCursorVisible(false);
    }

    //底部直线选中状态切换
    private  void LineChange(List<Fragment> fragmentLists) {
        Log.e("@@@@", "LineChange: " + fragmentLists.size());
        int currentPage = fra_task_viewPager.getCurrentItem() % fragmentLists.size();
        for (int i = 0; i < fragmentLists.size(); i++) {
            ll_viewpager_bottom_line.getChildAt(i).setEnabled(currentPage == i);
        }
    }
    //底部直线动态初始化
        private void initLine(List<Fragment> fragmentLists){
            Log.e("@@@@","initLine: "+fragmentLists.size());
            if(fragmentLists==null){
                fragmentLists=new ArrayList<>();
            }
            for (int i=0;i<fragmentLists.size();i++){
                View view =new View(getContext());
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(getActivity().getWindowManager().getDefaultDisplay().getWidth()/2,10);
                layoutParams.gravity= Gravity.CENTER_VERTICAL;
                view.setLayoutParams(layoutParams);
                view.setBackgroundResource(R.drawable.selector_line);
                ll_viewpager_bottom_line.addView(view);
            }
        }
    }

