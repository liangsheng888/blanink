package com.blanink.activity.EaseChat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.EaseChat.modle.DemoHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatFragmentParent extends Fragment {

    @BindView(R.id.rb_message)
    RadioButton rbMessage;
    @BindView(R.id.rb_friends)
    RadioButton rbFriends;
    @BindView(R.id.rg_notify)
    RadioGroup rgNotify;
    @BindView(R.id.tv_add_friends)
    TextView tvAddFriends;
    @BindView(R.id.go_order_add_rl)
    RelativeLayout goOrderAddRl;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.rl_chat)
    RelativeLayout rlChat;
    private List<Fragment> fragmentList;
    private List<RadioButton> radioButtons = new ArrayList<>();
    private  FragmentPagerAdapter adapter=null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_chat, null);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initData() {
        //初始化数据
        fragmentList = new ArrayList<>();
        fragmentList.add(new EaseTalkFragment());
        fragmentList.add(new ContactListFragment());
        radioButtons.add(rbMessage);
        radioButtons.add(rbFriends);
        //添加好友
        tvAddFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EaseAddContactActivity.class);
                startActivity(intent);
            }
        });
        //
        rgNotify.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_message:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_friends:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });
        //设置切换
        adapter=new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        viewPager.setAdapter(adapter) ;



        viewPager.setCurrentItem(0);//默认选中第一个

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioButtons.get(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //

    }

}
