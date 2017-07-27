package com.blanink.activity.lastNext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.fragment.CompanyCateGoryProduct;
import com.blanink.fragment.CompanyHonest;
import com.blanink.fragment.CompanyPartner;
import com.blanink.fragment.CompanyRemark;
import com.blanink.fragment.CustomerInfo;
import com.blanink.utils.MyActivityManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 公司详情
 */
public class CompanyDetail extends AppCompatActivity {

    @BindView(R.id.customer_apply_info)
    TextView customerApplyInfo;
    @BindView(R.id.customer_iv_last)
    TextView customerIvLast;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.last_family_manage_customer_apply_rl)
    RelativeLayout lastFamilyManageCustomerApplyRl;
    @BindView(R.id.rb_info)
    RadioButton rbInfo;
    @BindView(R.id.rb_product)
    RadioButton rbProduct;
    @BindView(R.id.rb_honest)
    RadioButton rbHonest;
    @BindView(R.id.rb_partner)
    RadioButton rbPartner;
    @BindView(R.id.rb_remark)
    RadioButton rbRemark;
    @BindView(R.id.rg_detail)
    RadioGroup rgDetail;
    @BindView(R.id.fl_customer_info)
    FrameLayout flCustomerInfo;
    private MyActivityManager myActivityManager;
    private int newIndex;//下一个即将可见的
    private int oldIndex;//当前可见的碎片
    private Fragment[] fragments = new Fragment[5];
    private Boolean customerState;//判断是否是虚拟客户
    private SharedPreferences sp;
    private RadioButton[] radioButtons;
    private String id;
    private String companyName;
    private String companyType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_detail);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        receivedData();
        initData();

    }

    private void initData() {

        //初始化数据
        fragments[0] = new CustomerInfo();
        fragments[1] = new CompanyPartner();
        fragments[2] = new CompanyHonest();
        fragments[3] = new CompanyCateGoryProduct();
        fragments[4] = new CompanyRemark();
        radioButtons = new RadioButton[]{rbInfo,rbPartner,rbHonest,rbProduct,rbRemark};
        //默认选择公司信息将诶界面
        getSupportFragmentManager().beginTransaction().add(R.id.fl_customer_info, fragments[0]).commit();
        radioButtons[0].setTextSize(16);
        //如果是虚拟客户 只能显示一般信息

            //界面点击事件
            rgDetail.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
            if ("1".equals(companyType) && "2".equals(sp.getString("COMPANY_TYPE", null))) {
                tvType.setVisibility(View.VISIBLE);
            }
            tvType.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPop(v);
                }
            });
        }
    private void receivedData() {
        Intent intent = getIntent();
        companyName = intent.getStringExtra("companyName");
        companyType = intent.getStringExtra("companyType");
        customerApplyInfo.setText(companyName);

    }

    @OnClick(R.id.customer_iv_last)
    public void onClick() {
        finish();
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
        radioButtons[newIndex].setTextSize(16);
        radioButtons[oldIndex].setTextSize(14);
        oldIndex = newIndex;
    }

}
