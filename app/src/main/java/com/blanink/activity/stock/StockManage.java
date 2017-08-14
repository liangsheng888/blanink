package com.blanink.activity.stock;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.blanink.fragment.OutInStockFragment;
import com.blanink.fragment.WareHouseFragment;
import com.blanink.view.CusViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StockManage extends AppCompatActivity {
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
    @BindView(R.id.tv_type)
    TextView tvType;
    private int mSelected = 0;
    private SharedPreferences sp;
    private List<Fragment> fragments = new ArrayList<>();
    private List<RadioButton> radioButtons = new ArrayList<>();
    private Boolean isType=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_manage);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=null;
                if(isType){
                    intent=new Intent(StockManage.this,WareHouseAdd.class);

                }else {
                    intent=new Intent(StockManage.this,OutInStockAdd.class);

                }
                startActivity(intent);
            }
        });
        fragments.add(new WareHouseFragment());
        fragments.add(new OutInStockFragment());

        // fragments.add(new SaleLineChartFragment());
        radioButtons.add(rbComeOrder);
        radioButtons.add(rbNotDownOrder);
        // radioButtons.add(rbDownOrder);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_come_order:
                        viewPager.setCurrentItem(0);
                        tvType.setText("库存添加");
                        isType=true;
                        break;
                    case R.id.rb_not_down_order:
                        viewPager.setCurrentItem(1);
                        tvType.setText("出入库添加");
                        isType=false;

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
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                LineChange(fragments);
                radioButtons.get(position).setChecked(true);
                if(rbComeOrder.isChecked()){
                    tvType.setText("库存添加");
                    isType=true;
                }else {
                    tvType.setText("出入库添加");
                    isType=false;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setPagingEnabled(true);
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
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            //设置控件的显示位置,相当于控件的layout_gravity属性
            params.gravity = Gravity.CENTER;


            params.leftMargin = 20;
            params.rightMargin = 20;
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.selector_line);
            llBottom.addView(view);
        }

    }

}
