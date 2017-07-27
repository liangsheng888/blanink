package com.blanink.activity.notify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.NotifyOffice;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 通知回复详情
 */
public class NotifyReplayDetail extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.customer_apply_iv_last)
    TextView customerApplyIvLast;
    @BindView(R.id.last_family_manage_customer_apply_rl)
    RelativeLayout lastFamilyManageCustomerApplyRl;
    @BindView(R.id.tv_delete)
    TextView tvDelete;
    @BindView(R.id.apply)
    RelativeLayout apply;
    @BindView(R.id.tv_apply_info)
    TextView tvApplyInfo;
    @BindView(R.id.customer_delete_relation_rl)
    LinearLayout customerDeleteRelationRl;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.t)
    TextView t;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_company_xin)
    TextView tvCompanyXin;
    @BindView(R.id.tv_company_xin_yu)
    TextView tvCompanyXinYu;
    @BindView(R.id.tv_major)
    TextView tvMajor;
    @BindView(R.id.tv_major_person)
    TextView tvMajorPerson;
    @BindView(R.id.tv_company_zi_remark)
    TextView tvCompanyZiRemark;
    @BindView(R.id.tv_company_remark)
    TextView tvCompanyRemark;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_company_remark_other)
    TextView tvCompanyRemarkOther;
    @BindView(R.id.tv_company_other_remark)
    TextView tvCompanyOtherRemark;
    @BindView(R.id.introduce)
    TextView introduce;
    @BindView(R.id.tv_introduce)
    TextView tvIntroduce;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.tv_company_address)
    TextView tvCompanyAddress;
    @BindView(R.id.url)
    TextView url;
    @BindView(R.id.tv_url)
    TextView tvUrl;
    @BindView(R.id.company_info)
    LinearLayout companyInfo;
    @BindView(R.id.activity_last_family_manage_customer_supplier_invite)
    RelativeLayout activityLastFamilyManageCustomerSupplierInvite;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private String companyBId;
    private String message;
    private String content;
    private String id;
    private NotifyOffice notifyOffice;
    AlertDialog alertDialog;
    private String title1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_replay_detail);
        ButterKnife.bind(this);
        DialogLoadUtils.getInstance(this);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        receiveData();
        initData();
    }

    private void receiveData() {
        Intent intent = getIntent();
        content = intent.getStringExtra("content");
        id = intent.getStringExtra("referrenceObjectId");
        title1 = intent.getStringExtra("title");
    }

    private void initData() {
        getDataFromServer();
        //返回
        customerApplyIvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void getDataFromServer() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "notify/getOffice");
        rp.addBodyParameter("referrenceObjectId", id);
        x.http().post(rp, new Callback.CacheCallback<String>() {


            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                notifyOffice = gson.fromJson(result, NotifyOffice.class);
                Log.e("LastFamilyManage", "companyB.id" + notifyOffice.getResult().getCompanyB().getId());
                Log.e("LastFamilyManage", "companyA.id" + notifyOffice.getResult().getCompanyA().getId());
                tvCompany.setText(notifyOffice.getResult().getCompanyB().getName());
                tvAddress.setText(notifyOffice.getResult().getCompanyB().getArea().getName());
                tvApplyInfo.setText(content);
                tvCompanyAddress.setText(notifyOffice.getResult().getCompanyB().getAddress());
                tvMajorPerson.setText(notifyOffice.getResult().getCompanyB().getMaster());
                tvPhone.setText(notifyOffice.getResult().getCompanyB().getPhone());
                tvIntroduce.setText(notifyOffice.getResult().getCompanyB().getRemarks());
                tvCompanyRemark.setText(notifyOffice.getResult().getCompanyB().getReviewSelf() + "");
                tvCompanyOtherRemark.setText(notifyOffice.getResult().getCompanyB().getReviewOthers() + "");
                tvUrl.setText(notifyOffice.getResult().getCompanyB().getHomepage());
                tvCompanyXinYu.setText(new DecimalFormat().format((notifyOffice.getResult().getCompanyB().getReviewSelf() + notifyOffice.getResult().getCompanyB().getReviewOthers()) / 2.0));
                tv.setText(notifyOffice.getResult().getCompanyB().getServiceCount() + "");

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }


}
