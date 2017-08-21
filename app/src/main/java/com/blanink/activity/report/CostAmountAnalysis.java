package com.blanink.activity.report;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.fragment.CostBarChartFragment;
//import com.blanink.fragment.CostLineChartFragment;
import com.blanink.fragment.CostPieChartFragment;
import com.blanink.fragment.SalePieChartFragment;
import com.blanink.fragment.SaleBarChartFragment;
import com.blanink.view.CusViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CostAmountAnalysis extends AppCompatActivity {
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.table)
    RelativeLayout table;
    @BindView(R.id.rb_come_order)
    RadioButton rbComeOrder;
    @BindView(R.id.rb_not_down_order)
    RadioButton rbNotDownOrder;
    @BindView(R.id.rb_down_order)
    RadioButton rbDownOrder;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.viewPager)
    CusViewPager viewPager;
    @BindView(R.id.tv_name)
    TextView tvName;
    private int mSelected = 0;
    private SharedPreferences sp;
    private List<Fragment> fragments = new ArrayList<>();
    private List<RadioButton> radioButtons = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_amount_analysis);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvName.setText(getIntent().getStringExtra("name"));
        fragments.add(new CostBarChartFragment());
        fragments.add(new CostPieChartFragment());
       // fragments.add(new CostLineChartFragment());
        radioButtons.add(rbComeOrder);
        radioButtons.add(rbNotDownOrder);
       // radioButtons.add(rbDownOrder);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_come_order:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_not_down_order:
                        viewPager.setCurrentItem(1);
                        break;
                   /* case R.id.rb_down_order:
                        viewPager.setCurrentItem(2);
                        break;*/
                }
                LineChange(fragments);

            }
        });
        //设置切换
        initLine(fragments);
        viewPager.setPagingEnabled(false);
        viewPager.setOffscreenPageLimit(3);
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


            params.leftMargin = 20;
            params.rightMargin = 20;
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.selector_line);
            llBottom.addView(view);
        }

    }


}
