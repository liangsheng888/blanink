package com.blanink.activity.bidTender;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.fragment.FragmentBid;
import com.blanink.fragment.FragmentMyBid;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 投标管理
 */
public class BidManage extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.bid_apply_iv_last)
    TextView bidApplyIvLast;
    @BindView(R.id.bid)
    RelativeLayout bid;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.ll_menu)
    LinearLayout llMenu;
    @BindView(R.id.rb_go)
    RadioButton rbGo;
    @BindView(R.id.rb_my_bid)
    RadioButton rbMyBid;
    @BindView(R.id.rg_menu)
    RadioGroup rgMenu;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    private List<Fragment> fragments = new ArrayList<>();
    private List<RadioButton> radioButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_manage);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        //初始化数据
        fragments.add(new FragmentBid());
        fragments.add(new FragmentMyBid());
        radioButtons.add(rbGo);
        radioButtons.add(rbMyBid);
        //返回
        bidApplyIvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //
        rgMenu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_go:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_my_bid:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });
        //设置切换
        initLine(fragments);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        viewPager.setCurrentItem(0);//默认选中第一个
        LineChange(fragments);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioButtons.get(position).setChecked(true);
                //radioButtons.get(position).setTextSize(18);
                LineChange(fragments);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置适配

    }

    //底部直线选中状态切换
    private void LineChange(List<Fragment> fragmentLists) {
        Log.e("@@@@", "LineChange: " + fragmentLists.size());
        int currentPage = viewPager.getCurrentItem() % fragmentLists.size();
        for (int i = 0; i < fragmentLists.size(); i++) {
            llBottom.getChildAt(i).setEnabled(currentPage == i);
        }
    }

    //底部直线动态初始化
    private void initLine(List<Fragment> fragmentLists) {
        Log.e("@@@@", "initLine: " + fragmentLists.size());
        if (fragmentLists == null) {
            fragmentLists = new ArrayList<>();
        }

        for (int i = 0; i < fragmentLists.size(); i++) {
            View view = new View(this);
            LinearLayout.LayoutParams   params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            //设置控件的显示位置,相当于控件的layout_gravity属性
            params.gravity= Gravity.CENTER;


            params.leftMargin=50;
            params.rightMargin=50;
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.selector_line);
            llBottom.addView(view);
        }
    }

  /*  @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("@@@","切换"+intent.getStringExtra("DIRECT"));
        if("MINE_BID".equals(getIntent().getStringExtra("DIRECT"))){
            viewPager.setCurrentItem(1);
        }
    }*/

    @Override
    protected void onStart() {
        super.onStart();
      if("MINE_BID".equals(getIntent().getStringExtra("DIRECT"))){
            viewPager.setCurrentItem(1);
        }
    }
}
