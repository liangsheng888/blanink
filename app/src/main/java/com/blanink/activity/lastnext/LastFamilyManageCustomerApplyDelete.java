package com.blanink.activity.lastNext;

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
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.Response;
import com.blanink.pojo.SingleCustomer;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DecimalFormat;



/***
 * 上家管理 客户管理 申请解除
 */
public class LastFamilyManageCustomerApplyDelete extends AppCompatActivity {

    private static final String  TAG ="LastDelete" ;
    private static final String DELETE ="0" ;//解除合作关系的标记
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
    private TextView customer_apply_iv_last;
    private  SingleCustomer info;
    private SharedPreferences sp;
    private  AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_family_manage_customer_apply_delete);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp=getSharedPreferences("DATA",MODE_PRIVATE);
        receiveIntentInfo();
        initView();
        initData();

    }

    private void initView() {
        customer_apply_iv_last = ((TextView) findViewById(R.id.customer_apply_iv_last));//發回
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
        et_apply_info = ((EditText) findViewById(R.id.et_apply_delete_info));//申請信息
        btn_apply = ((Button) findViewById(R.id.tv_apply_delete));//發送請求
    }
    private void initData(){
        customer_apply_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_company_name.setText(info.result.getName());
        tv_state.setText(info.result.getCreateCompanyBy()==null?"实有":"虚拟");
        tv_area.setText(info.result.getArea().getName());
        DecimalFormat df=new DecimalFormat("0.0");
        tv_company_xin_yu.setText(df.format((info.result.reviewOthers+info.result.reviewSelf)/2.0));
        tv_major_person.setText(info.result.getMaster());
        tv_phone.setText(info.result.getPhone());
        tv_introduce.setText(info.result.getMaster());
        tv_company_address.setText(info.result.getAddress());
        tv_company_remark.setText(info.result.reviewSelf+"");
        tv_company_other_remark.setText(info.result.reviewOthers+"");
        tv_url.setText(info.result.homepage);

        //申请解除
        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=et_apply_info.getText().toString().trim();
                if(TextUtils.isEmpty(message)){
                    Toast.makeText(LastFamilyManageCustomerApplyDelete.this, "请填写解除合作关系的理由！", Toast.LENGTH_SHORT).show();
                    return;
                }
                message=et_apply_info.getText().toString();
                DialogLoadUtils.getInstance(LastFamilyManageCustomerApplyDelete.this);
                DialogLoadUtils.showDialogLoad("操作进行中...");
                RequestParams rp=new RequestParams(NetUrlUtils.NET_URL+"partner/customerApply");
                rp.addBodyParameter("userId",sp.getString("USER_ID",null));
                rp.addBodyParameter("companyA.id",info.result.getId());
                rp.addBodyParameter("companyB.id",sp.getString("COMPANY_ID",null));
                rp.addBodyParameter("notify.remarks",message);
                rp.addBodyParameter("isApply","1");
                x.http().post(rp, new Callback.CacheCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        DialogLoadUtils.dismissDialog();
                        Log.e(TAG,result.toString());
                        Gson gson=new Gson();
                        Response response=gson.fromJson(result, Response.class);
                        if(response.getErrorCode().equals("00000")){
                           showDialog();
                        }else {
                            Toast.makeText(LastFamilyManageCustomerApplyDelete.this, "操作失败", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        DialogLoadUtils.dismissDialog();
                        Toast.makeText(LastFamilyManageCustomerApplyDelete.this, "服务器异常，稍后重试", Toast.LENGTH_SHORT).show();
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
        });

    }

    private void showDialog() {
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setContentView(R.layout.dialog_custom_apply_delete_relation);
        Window window=alertDialog.getWindow();
        WindowManager.LayoutParams lp =window.getAttributes();
        window.setGravity(Gravity.CENTER);
        Display d = getWindowManager().getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth()*0.9); // 宽度设置为屏幕的1/2
        window.setAttributes(lp);
        window.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.getWindow().setWindowAnimations(R.style.dialogAnimationTranslate);
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
    }
}
