package com.blanink.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.bean.SingleCustomer;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DecimalFormat;

/***
 * 下家管理供应商管理申请解除
 */
public class NextFamilyManageSupplierManageApplyDelete extends AppCompatActivity {

    private MyActivityManager myActivityManager;
    private ImageView customer_apply_iv_last;
    private TextView tv_company;
    private TextView tv_customer_num;
    private TextView tv_address;
    private TextView tv_master;
    private TextView tv_phone;
    private TextView tv_scope;
    private TextView tv_detail_address;
    private TextView tv_url;
    private TextView tv_introduce;
    private TextView tv_company_honest;
    private TextView tv_company_remark;
    private TextView tv_company_other_remark;
    private EditText et_apply_info;
    private Button btn_apply;
    private SingleCustomer info;
    private String companyId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_family_manage_company_supplier_manage_apply_deltete);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);

        receiveIntentInfo();

        initView();
        initData();
    }

    private void initView() {
        customer_apply_iv_last = ((ImageView) findViewById(R.id.customer_apply_iv_last));
        tv_company = ((TextView) findViewById(R.id.tv_company));//公司名
        tv_customer_num = ((TextView) findViewById(R.id.tv_customer_name));//服务客户数量
        tv_address = ((TextView) findViewById(R.id.tv_address));//地址
        tv_master = ((TextView) findViewById(R.id.tv_major_person));//负责人
        tv_phone = ((TextView) findViewById(R.id.tv_phone));//手机
        tv_scope = ((TextView) findViewById(R.id.tv_major_content));//主营
        tv_detail_address = ((TextView) findViewById(R.id.tv_detail_address));//详细地址
        tv_url = ((TextView) findViewById(R.id.tv_url));//公司主页
        tv_introduce = ((TextView) findViewById(R.id.tv_introduce));//公司简介
        tv_company_honest = ((TextView) findViewById(R.id.tv_company_xin_yu));//公司信誉
        tv_company_remark = ((TextView) findViewById(R.id.tv_company_remark));//公司自评
        tv_company_other_remark = ((TextView) findViewById(R.id.tv_company_other_remark));//他评
        et_apply_info = ((EditText) findViewById(R.id.et_apply_info));//申请解除信息
        btn_apply = ((Button) findViewById(R.id.tv_apply_delete));//发送申请

    }

    private void initData() {

        customer_apply_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (info != null) {
            tv_company.setText(info.getResult().companyB.getName());
            tv_address.setText(info.getResult().companyB.getArea().getName());
            tv_master.setText(info.getResult().companyB.getMaster());
            tv_phone.setText(info.getResult().getCompanyB().getPhone());
            tv_detail_address.setText(info.getResult().getCompanyB().getAddress());
            tv_introduce.setText(info.getResult().getCompanyB().getRemarks());
            DecimalFormat df = new DecimalFormat("0.00");
            tv_company_remark.setText(info.getResult().getComeOrderSelfRated() + "");
            tv_company_other_remark.setText(info.getResult().getComeOrderOthersRated() + "");
            tv_company_honest.setText(df.format((info.getResult().getComeOrderSelfRated() + info.getResult().getComeOrderOthersRated()) / 2.0));
        }
    }

    private void receiveIntentInfo() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        info = (SingleCustomer) bundle.getSerializable("info");
        companyId = intent.getStringExtra("companyId");
        if (info != null) {
            Log.e("@@@@", info.toString());
        }
        if (companyId != null) {
            getData();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    public void getData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "partner/info");
        rp.addBodyParameter("id", companyId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                info = new Gson().fromJson(result, SingleCustomer.class);
                Log.e("@@@@", info.toString());
                tv_company.setText(info.getResult().companyB.getName());
                tv_address.setText(info.getResult().companyB.getArea().getName());
                tv_master.setText(info.getResult().companyB.getMaster());
                tv_phone.setText(info.getResult().getCompanyB().getPhone());
                tv_detail_address.setText(info.getResult().getCompanyB().getAddress());
                tv_introduce.setText(info.getResult().getCompanyB().getRemarks());
                DecimalFormat df = new DecimalFormat("0.00");
                tv_company_remark.setText(info.getResult().getComeOrderSelfRated() + "");
                tv_company_other_remark.setText(info.getResult().getComeOrderOthersRated() + "");
                tv_company_honest.setText(df.format((info.getResult().getComeOrderSelfRated() + info.getResult().getComeOrderOthersRated()) / 2.0));
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });

    }


}
