package com.blanink.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
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
    private ImageView customer_iv_last;
    private int newIndex;//下一个即将可见的
    private int oldIndex;//当前可见的碎片
    private Fragment[] fragments = new Fragment[5];
    private RadioGroup rg_detail;
    private TextView customer_apply_info;
    private Boolean customerState;//判断是否是虚拟客户

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_customer_detail_info);
        Intent intent = getIntent();
        companyName = intent.getStringExtra("companyName");
        customerState = intent.getBooleanExtra("customerState", true);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initView();
        initData();

    }

    private void initView() {
        rg_detail = ((RadioGroup) findViewById(R.id.rg_detail));
        customer_iv_last = ((ImageView) findViewById(R.id.customer_iv_last));
        customer_apply_info = ((TextView) findViewById(R.id.customer_apply_info));
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
        }

        //返回
        customer_iv_last.setOnClickListener(new View.OnClickListener() {
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
        //改变当前的选中项
        oldIndex = newIndex;
    }
}
