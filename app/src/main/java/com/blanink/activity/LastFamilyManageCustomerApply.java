package com.blanink.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.mapapi.map.Text;
import com.blanink.R;
import com.blanink.bean.SingleCustomer;
import com.blanink.utils.MyActivityManager;

import java.text.DecimalFormat;

/***
 * 上家管理 客户管理  申请合作
 */
public class LastFamilyManageCustomerApply extends AppCompatActivity {

    private MyActivityManager myActivityManager;
    private TextView tv_company_name;
    private TextView tv_state;
    private TextView tv_area;
    private TextView tv_company_xin_yu;
    private TextView tv_major_person;
    private TextView tv_phone;
    private TextView tv_introduce;
    private TextView tv_company_address;
    private TextView tv_url;
    private TextView tv_company_remark;
    private TextView tv_company_other_remark;
    private TextView et_apply_info;
    private Button btn_apply;
    private ImageView customer_apply_iv_last;
    private SingleCustomer info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_family_manage_customer_apply);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        receiveIntentInfo();
        initView();
        initData();
    }

    private void initView() {
        customer_apply_iv_last = ((ImageView) findViewById(R.id.customer_apply_iv_last));//發回
        tv_company_name = ((TextView) findViewById(R.id.tv_company_name));//公司名称
        tv_state = ((TextView) findViewById(R.id.tv_state));//公司状态
        tv_area = ((TextView) findViewById(R.id.tv_area));//区域
        tv_company_xin_yu = ((TextView) findViewById(R.id.tv_company_xin_yu));//公司信誉
        tv_major_person = ((TextView) findViewById(R.id.tv_major_person));//负责人
        tv_phone = ((TextView) findViewById(R.id.tv_phone));//電話
        tv_introduce = ((TextView) findViewById(R.id.tv_introduce));//簡介
        tv_company_address = ((TextView) findViewById(R.id.tv_company_address));//詳情地址
        tv_url = ((TextView) findViewById(R.id.tv_url));//主頁
        tv_company_remark = ((TextView) findViewById(R.id.tv_company_remark));//自評
        tv_company_other_remark = ((TextView) findViewById(R.id.tv_company_other_remark));//他評
        et_apply_info = ((TextView) findViewById(R.id.et_apply_info));//申請信息
        btn_apply = ((Button) findViewById(R.id.btn_apply));//發送請求
    }
    private void initData(){
        //返回
        customer_apply_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
       //初始化界面
        tv_company_name.setText(info.getResult().getCompanyA().getName());
        tv_state.setText(info.getResult().getCompanyA().getCreateCompanyBy()==null?"实有":"虚拟");
        tv_area.setText(info.getResult().getCompanyA().getArea().getName());
        DecimalFormat df=new DecimalFormat("0.00");
        tv_company_xin_yu.setText(df.format((info.getResult().getComeOrderOthersRated()+info.getResult().getComeOrderSelfRated())/2.0));

        tv_major_person.setText(info.getResult().getCompanyA().getMaster());
        tv_phone.setText(info.getResult().getCompanyA().getPhone());
        tv_introduce.setText(info.getResult().getCompanyA().getMaster());
        tv_company_address.setText(info.getResult().getCompanyA().getAddress());
        tv_company_remark.setText(info.getResult().getComeOrderSelfRated()+"");
        tv_company_other_remark.setText(info.getResult().getComeOrderOthersRated()+"");
    }
    private void receiveIntentInfo() {
        Intent intent=getIntent();
        Bundle bundle =intent.getExtras();
        info=(SingleCustomer) bundle.getSerializable("info");
        Log.e("@@@@",info.toString());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
