package com.blanink.activity.afterSale;

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
import com.blanink.fragment.AfterSaleHandleFinished;
import com.blanink.fragment.AfterSaleNotHandle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 售后列表
 */
public class AfterSaleQueue extends AppCompatActivity {
    @BindView(R.id.after_sale_queue_iv_last)
    TextView afterSaleQueueIvLast;
    @BindView(R.id.rl_after_sale_queue)
    RelativeLayout rlAfterSaleQueue;
    @BindView(R.id.rb_not_handle)
    RadioButton rbNotHandle;
    @BindView(R.id.rb_handle_finished)
    RadioButton rbHandleFinished;
    @BindView(R.id.rg_after_sale)
    RadioGroup rgAfterSale;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.rl)
    LinearLayout rl;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.activity_after_sale_queue)
    RelativeLayout activityAfterSaleQueue;
    private List<Fragment> fragments = new ArrayList<>();
    private List<RadioButton> radioButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sale_queue);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        //初始化数据
        fragments.add(new AfterSaleNotHandle());
        fragments.add(new AfterSaleHandleFinished());
        radioButtons.add(rbNotHandle);
        radioButtons.add(rbHandleFinished);
        //返回
        afterSaleQueueIvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //
        rgAfterSale.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_not_handle:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_handle_finished:
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
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            //设置控件的显示位置,相当于控件的layout_gravity属性
            params.gravity = Gravity.CENTER;


            params.leftMargin = 50;
            params.rightMargin = 50;
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.selector_line);
            llBottom.addView(view);
        }
    }

}
