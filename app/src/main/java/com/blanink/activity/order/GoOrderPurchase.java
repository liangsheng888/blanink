package com.blanink.activity.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.MainActivity;
import com.blanink.fragment.GoComeOrderFragment;
import com.blanink.fragment.GoDownOrderFragment;
import com.blanink.fragment.GoNotDownOrderFragment;
import com.blanink.utils.MyActivityManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 去单采购/去单列表
 */
public class GoOrderPurchase extends AppCompatActivity {

    private static final int BACK_TASK = 0;
    @BindView(R.id.go_order_purchase_tv_seek)
    TextView goOrderPurchaseTvSeek;
    @BindView(R.id.go_order_purchase_iv_last)
    TextView goOrderPurchaseIvLast;
    @BindView(R.id.tv_new_add)
    TextView tvNewAdd;
    @BindView(R.id.go_order_purchase)
    RelativeLayout goOrderPurchase;
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
    ViewPager viewPager;
    private ImageView go_order_purchase_iv_last;
    private MyActivityManager myActivityManager;
   /* private Fragment[] fragments;
    private RadioButton[] radioButtons;*/
    private int newIndex;
    private int oldIndex;
    private List<Fragment> fragments = new ArrayList<>();
    private List<RadioButton> radioButtons = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_order_purchase);
        ButterKnife.bind(this);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);

        initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        String code = getIntent().getStringExtra("DIRECT");
        Log.e("GoOrderPurchase", "code" + code);
        if (code != null) {
            viewPager.setCurrentItem(Integer.parseInt(code));
        }
    }

    private void initData() {
        //返回
        goOrderPurchaseIvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fragments.add(new GoComeOrderFragment());
        fragments.add(new GoNotDownOrderFragment());
        fragments.add(new GoDownOrderFragment());
       /* fragments[0] = new GoComeOrderFragment();
        fragments[1] = new GoNotDownOrderFragment();
        fragments[2] = new GoDownOrderFragment();*/
     /*   radioButtons = new RadioButton[3];
        radioButtons[0] = rbComeOrder;
        radioButtons[1] = rbNotDownOrder;
        radioButtons[2] = rbDownOrder;*/
        radioButtons.add(rbComeOrder);
        radioButtons.add(rbNotDownOrder);
        radioButtons.add(rbDownOrder);
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
                    case R.id.rb_down_order:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });
        //设置切换
        initLine(fragments);
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


            params.leftMargin = 20;
            params.rightMargin = 20;
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.selector_line);
            llBottom.addView(view);
        }

        //新增采购
        tvNewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoOrderPurchase.this, GoOrderNewAddProduct.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        myActivityManager.popOneActivity(this);
        super.onDestroy();
    }

  /*  public void changeFragment(int newIndex) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (newIndex != oldIndex) {
            fragmentTransaction.hide(fragments[oldIndex]);
            if (!fragments[newIndex].isAdded()) {
                fragmentTransaction.add(R.id.fl_main, fragments[newIndex]);
            }
            fragmentTransaction.show(fragments[newIndex]).commit();
        }
        radioButtons[oldIndex].setTextSize(16);
        radioButtons[newIndex].setTextSize(18);
        oldIndex = newIndex;

    }*/

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        String code = getIntent().getStringExtra("DIRECT");
        Log.e("GoOrderPurchase", "code" + code);
        if (code != null) {
            viewPager.setCurrentItem(Integer.parseInt(code));
        }

    }

   /* //底部直线选中状态切换
    private void LineChange(Fragment[] fragmentLists, int index) {

        int currentPage = index % fragmentLists.length;
        for (int i = 0; i < fragmentLists.length; i++) {
            llBottom.getChildAt(i).setEnabled(currentPage == i);
        }
    }

    //底部直线动态初始化
    private void initLine(Fragment[] fragmentLists) {

        for (int i = 0; i < fragmentLists.length; i++) {
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
    }*/
}
