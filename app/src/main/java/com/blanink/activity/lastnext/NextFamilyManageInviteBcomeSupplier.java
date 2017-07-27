package com.blanink.activity.lastnext;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.NotifyOffice;
import com.blanink.pojo.Response;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.DialogNotifyUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 下家管理 邀请成为他的供应商
 */
public class NextFamilyManageInviteBcomeSupplier extends AppCompatActivity {

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
    @BindView(R.id.bt_agree)
    Button btAgree;
    @BindView(R.id.bt_refuse)
    Button btRefuse;
    @BindView(R.id.ll_manage)
    LinearLayout llManage;
    @BindView(R.id.tv_company)
    TextView tvCompany;
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
        setContentView(R.layout.activity_next_family_manage_invite_bcome_supplier);
        ButterKnife.bind(this);
        DialogLoadUtils.getInstance(this);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        receiveData();
        initData();
    }

    private void receiveData() {
        Intent intent=getIntent();
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
        RequestParams rp=new RequestParams(NetUrlUtils.NET_URL+"notify/getOffice");
        rp.addBodyParameter("referrenceObjectId",id);
        x.http().post(rp, new Callback.CacheCallback<String>() {


            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                notifyOffice = gson.fromJson(result, NotifyOffice.class);
                Log.e("LastFamilyManage","companyB.id"+notifyOffice.getResult().getCompanyB().getId());
                Log.e("LastFamilyManage","companyA.id"+notifyOffice.getResult().getCompanyA().getId());
                tvCompany.setText(notifyOffice.getResult().getCompanyA().getName());
                tvAddress.setText(notifyOffice.getResult().getCompanyA().getArea().getName());
                tvApplyInfo.setText(content);
                tvCompanyAddress.setText(notifyOffice.getResult().getCompanyA().getAddress());
                tvMajorPerson.setText(notifyOffice.getResult().getCompanyA().getMaster());
                tvPhone.setText(notifyOffice.getResult().getCompanyA().getPhone());
                tvIntroduce.setText(notifyOffice.getResult().getCompanyA().getRemarks());
                tvCompanyRemark.setText(notifyOffice.getResult().getCompanyA().getReviewSelf()+"");
                tvCompanyOtherRemark.setText(notifyOffice.getResult().getCompanyA().getReviewOthers()+"");
                tvUrl.setText(notifyOffice.getResult().getCompanyA().getHomepage());
                tvCompanyXinYu.setText(new DecimalFormat("").format((notifyOffice.getResult().getCompanyB().getReviewSelf()+notifyOffice.getResult().getCompanyB().getReviewOthers())/2.0));
                tv.setText(notifyOffice.getResult().getCompanyA().getServiceCount()+"");

                if ("2".equals(notifyOffice.getResult().getReviewStatus())){
                    btAgree.setText("已同意");
                    btAgree.setEnabled(false);
                    btRefuse.setVisibility(View.GONE);
                }
                if ("3".equals(notifyOffice.getResult().getReviewStatus())){
                    btAgree.setText("已拒绝");
                    btAgree.setEnabled(false);
                    btRefuse.setVisibility(View.GONE);
                }
                if ("4".equals(notifyOffice.getResult().getReviewStatus())){
                    btAgree.setText("已解除");
                    btAgree.setEnabled(false);
                    btRefuse.setVisibility(View.GONE);
                }
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

    @OnClick({R.id.bt_agree, R.id.bt_refuse})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_agree:
                //同意
                DialogLoadUtils.showDialogLoad("操作进行中...");
                agreeApply();
                break;
            case R.id.bt_refuse:
                //拒绝
                showNotify();
                break;
        }
    }

    private void showNotify() {
        alertDialog = new AlertDialog.Builder(this).create();
        final View view=View.inflate(this,R.layout.dialog_refuse,null);
        alertDialog.setView(view);
        alertDialog.show();
        final Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display d = windowManager.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setAttributes(lp);
        alertDialog.setCanceledOnTouchOutside(false);
        view.findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送理由
                message = ((EditText) view.findViewById(R.id.et_info)).getText().toString();
                if (TextUtils.isEmpty(message)) {
                    Toast.makeText(NextFamilyManageInviteBcomeSupplier.this, "请填写拒绝理由", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.showDialogLoad("操作进行中...");
                reject();
            }
        });
        view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    //拒绝
    private void reject() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "partner/nextHomeReject");
        rp.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("companyB.id", sp.getString("COMPANY_ID", null));
        rp.addBodyParameter("companyA.id", notifyOffice.getResult().getCompanyA().getId());
        rp.addBodyParameter("notify.content", message);
        rp.addBodyParameter("isApply","0");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                alertDialog.dismiss();
                DialogLoadUtils.dismissDialog();
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if ("00000".equals(response.getErrorCode())) {
                    DialogLoadUtils.dismissDialog();
                    btAgree.setEnabled(false);
                    btAgree.setText("已拒绝");
                    btRefuse.setVisibility(View.GONE);
                    DialogNotifyUtils.showNotify(NextFamilyManageInviteBcomeSupplier.this, "你拒绝了对方的请求");

                } else {
                    Toast.makeText(NextFamilyManageInviteBcomeSupplier.this, "操作失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                alertDialog.dismiss();
                DialogLoadUtils.dismissDialog();
                Toast.makeText(NextFamilyManageInviteBcomeSupplier.this, "服务器异常", Toast.LENGTH_SHORT).show();
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


    //同意
    public void agreeApply() {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "customer/nextHomeAgree");
        rp.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("companyB.id", sp.getString("COMPANY_ID", null));
        rp.addBodyParameter("companyA.id",notifyOffice.getResult().getCompanyA().getId());
        rp.addBodyParameter("isApply","0");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                DialogLoadUtils.dismissDialog();
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if ("00000".equals(response.getErrorCode())) {
                    DialogLoadUtils.dismissDialog();
                    btAgree.setEnabled(false);
                    btAgree.setText("已同意");
                    btRefuse.setVisibility(View.GONE);
                    DialogNotifyUtils.showNotify(NextFamilyManageInviteBcomeSupplier.this, "你同意了对方的请求");

                } else {
                    Toast.makeText(NextFamilyManageInviteBcomeSupplier.this, "操作失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();
                Toast.makeText(NextFamilyManageInviteBcomeSupplier.this, "服务器异常", Toast.LENGTH_SHORT).show();
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
