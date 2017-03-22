package com.blanink.activity.lastNext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.fragment.LastCustomerInfo;
import com.blanink.fragment.LastHonest;
import com.blanink.fragment.LastPartner;
import com.blanink.fragment.LastProduct;
import com.blanink.fragment.LastRemark;
import com.blanink.utils.MyActivityManager;

/***
 * 上家 客户详情
 */
public class LastCustomerDetail extends AppCompatActivity {

    private static final String TAG = "LastCustomerDetail";
    private MyActivityManager myActivityManager;
    private String id;
    private String companyName;
    private TextView customer_iv_last;
    private int newIndex;//下一个即将可见的
    private int oldIndex;//当前可见的碎片
    private Fragment[] fragments = new Fragment[5];
    private RadioGroup rg_detail;
    private TextView customer_apply_info;
    private Boolean customerState;//判断是否是虚拟客户
    private String companyType;
    private SharedPreferences sp;
    private TextView tv_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_customer_detail_info);
        Intent intent = getIntent();
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        companyName = intent.getStringExtra("companyName");
        customerState = intent.getBooleanExtra("customerState", true);
        companyType = intent.getStringExtra("companyType");
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initView();
        initData();

    }

    private void initView() {
        rg_detail = ((RadioGroup) findViewById(R.id.rg_detail));
        customer_iv_last = ((TextView) findViewById(R.id.customer_iv_last));
        customer_apply_info = ((TextView) findViewById(R.id.customer_apply_info));
        tv_type = ((TextView) findViewById(R.id.tv_type));
    }

    private void initData() {
        customer_apply_info.setText(companyName);
        //初始化数据
        fragments[0] = new LastCustomerInfo();
        fragments[1] = new LastPartner();
        fragments[2] = new LastHonest();
        fragments[3] = new LastProduct();
        fragments[4] = new LastRemark();

        //默认选择公司信息将诶界面
        getSupportFragmentManager().beginTransaction().add(R.id.fl_customer_info, fragments[0]).commit();
        //如果是虚拟客户 只能显示 一般信息
        if (!customerState) {
            findViewById(R.id.rb_partner).setEnabled(false);
            findViewById(R.id.rb_honest).setEnabled(false);
            findViewById(R.id.rb_product).setEnabled(false);
            findViewById(R.id.rb_remark).setEnabled(false);

        } else {
            //界面点击事件
            rg_detail.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.rb_info:
                            //公司信息
                            newIndex = 0;
                            break;
                        case R.id.rb_partner:
                            //合作伙伴
                            newIndex = 1;
                            break;
                        case R.id.rb_honest:
                            //诚信档案
                            newIndex = 2;
                            break;
                        case R.id.rb_product:
                            //产品
                            newIndex = 3;
                            break;
                        case R.id.rb_remark:
                            //评价
                            newIndex = 4;
                            break;
                    }
                    changeFragments(newIndex);
                }
            });
            //判断公司类型
            if (companyType.equals("1") && "2".equals(sp.getString("COMPANY_TYPE", null))) {
                tv_type.setVisibility(View.VISIBLE);
            }
            tv_type.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPop(v);
                }
            });
        }

        //返回
        customer_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void showPop(View v) {
        View view = View.inflate(this, R.layout.popup_custom, null);
        final PopupWindow popupWindow = new PopupWindow(view, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        //测量view 注意这里，如果没有测量  ，下面的popupHeight高度为-2  ,因为LinearLayout.LayoutParams.WRAP_CONTENT这句自适应造成的
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int popupWidth = view.getMeasuredWidth();    //  获取测量后的宽度
        int popupHeight = view.getMeasuredHeight();  //获取测量后的高度
        int[] location = new int[2];
        // 允许点击外部消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());//注意这里如果不设置，下面的setOutsideTouchable(true);允许点击外部消失会失效
        popupWindow.setOutsideTouchable(true);   //设置外部点击关闭ppw窗口
        popupWindow.setFocusable(true);
        // 获得位置 这里的v是目标控件，就是你要放在这个v的上面还是下面
        v.getLocationOnScreen(location);
        popupWindow.setAnimationStyle(R.style.popAnimation);  //设置动画
        //这里就可自定义在上方和下方了 ，这种方式是为了确定在某个位置，某个控件的左边，右边，上边，下边都可以
       // popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, (location[0] + v.getWidth() / 2) - popupWidth / 2, location[1] - popupHeight);

       //因为ppw提供了在某个控件下方的方法，所以有些时候需要直接定位在下方时并不用上面的这个方法
        popupWindow.showAsDropDown(v);    // 以触发弹出窗的view为基准，出现在view的正下方，弹出的pop_view左上角正对view的左下角  偏移量默认为0,0
       /* ppwfilter.showAsDropDown(v, xoff, yoff);    // 有参数的话，就是一view的左下角进行偏移，xoff正的向左，负的向右. yoff没测，也应该是正的向下，负的向上
        ppwfilter.showAsDropDown(parent, xoff, yoff, gravity) //parent:传你当前Layout的id; gravity:Gravity.BOTTOM（以屏幕左下角为参照）... 偏移量会以它为基准点 当x y为0,0是出现在底部居中*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
    //切换界面
    private void changeFragments(int newIndex) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (newIndex != oldIndex) {
            ft.hide(fragments[oldIndex]);//隐藏当前的界面
            if (!fragments[newIndex].isAdded()) {//如果没有添加则添加
                ft.add(R.id.fl_customer_info, fragments[newIndex]);
            }
            ft.show(fragments[newIndex]).commit();//显示
        }
        //改变当前的选中项
        oldIndex = newIndex;
    }
}
