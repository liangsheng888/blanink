package com.blanink.activity.lastnext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.fragment.NextHonest;
import com.blanink.fragment.NextPartner;
import com.blanink.fragment.NextPartnerInfo;
import com.blanink.fragment.NextProduct;
import com.blanink.fragment.NextRemark;
import com.blanink.utils.MyActivityManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 下家管理公司详情
 */
public class NextFamilyManageCompanyDetail extends AppCompatActivity {

    private static final String TAG = "NextFamilyDetail";
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
    @BindView(R.id.activity_next_family_manage_company_detail)
    RelativeLayout activityNextFamilyManageCompanyDetail;
    private TextView customer_apply_iv_last;
    private MyActivityManager myActivityManager;
    private int newIndex;//下一个即将可见的
    private int oldIndex;//当前可见的碎片
    private Fragment[] fragments = new Fragment[5];
    private RadioGroup rg_detail;
    private String name;
    private TextView customer_apply_info;
    private RadioButton[] radioButtons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_family_manage_company_detail_info);
        ButterKnife.bind(this);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        ReceiveDataByIntent();//接收从上个界面传来的数据
        initView();
        initData();
    }

    private void ReceiveDataByIntent() {
        Intent intent = getIntent();
        name = intent.getStringExtra("companyName");

    }

    private void initView() {
        customer_apply_iv_last = ((TextView) findViewById(R.id.customer_apply_iv_last));//返回
        rg_detail = ((RadioGroup) findViewById(R.id.rg_detail));
        customer_apply_info = ((TextView) findViewById(R.id.customer_apply_info));
    }

    private void initData() {
        customer_apply_info.setText(name);
        //初始化数据
        fragments[0] = new NextPartnerInfo();
        fragments[1] = new NextPartner();
        fragments[2] = new NextHonest();
        fragments[3] = new NextProduct();
        fragments[4] = new NextRemark();
        radioButtons = new RadioButton[]{rbInfo,rbPartner,rbHonest,rbProduct,rbRemark};
        //默认选择公司信息将诶界面
        getSupportFragmentManager().beginTransaction().add(R.id.fl_customer_info, fragments[0]).commit();
        radioButtons[0].setTextSize(16);
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
        customer_apply_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
        radioButtons[newIndex].setTextSize(16);
        radioButtons[oldIndex].setTextSize(14);
        //改变当前的选中项
        oldIndex = newIndex;
    }
}
