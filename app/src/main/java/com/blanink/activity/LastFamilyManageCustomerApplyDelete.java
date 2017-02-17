package com.blanink.activity;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.bean.SingleCustomer;
import com.blanink.utils.MyActivityManager;
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
    private ImageView customer_apply_iv_last;
    private  SingleCustomer info;
    private SharedPreferences sp;
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
        et_apply_info = ((TextView) findViewById(R.id.et_apply_delete_info));//申請信息
        btn_apply = ((Button) findViewById(R.id.tv_apply_delete));//發送請求
    }
    private void initData(){
        customer_apply_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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

        //申请解除
        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String message=et_apply_info.getText().toString().trim();
                if(TextUtils.isEmpty(message)){
                    Toast.makeText(LastFamilyManageCustomerApplyDelete.this, "请填写解除合作关系的理由！", Toast.LENGTH_SHORT).show();
                    return;
                }
                final AlertDialog alertDialog=new AlertDialog.Builder(LastFamilyManageCustomerApplyDelete.this).create();
                alertDialog.setTitle("提示");
                alertDialog.setIcon(R.mipmap.jcxy);
                alertDialog.setMessage("确定要解除合作关系吗？");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int which) {

                        //向对方发送解除关系请求 别名发送到服务器

                        RequestParams rp=new RequestParams("http://192.168.199.147:8080/Jpush/jpushServlet");
                        for (int i=0;i<info.getResult().getCompanyA().customerServiceList.size();i++){
                            rp.addBodyParameter("alias",info.getResult().getCompanyA().customerServiceList.get(i).getId());
                            //rp.addBodyParameter("");
                        }
                        rp.addBodyParameter("content",message);
                        rp.addBodyParameter("title","来自"+info.getResult().companyB.getName()+"供应商的消息");
                        rp.addBodyParameter("userId",sp.getString("USER_ID",null));
                        rp.addBodyParameter("type",DELETE);

                        x.http().post(rp, new Callback.CacheCallback<String>() {
                            @Override
                            public void onSuccess(String result) {
                                Log.e(TAG,info.getResult().getCompanyA().customerServiceList.toString());
                                Log.e(TAG,result.toString());
                                dialog.dismiss();
                                Toast.makeText(LastFamilyManageCustomerApplyDelete.this, "申请已发出,正在等待对方同意！", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(Throwable ex, boolean isOnCallback) {
                                Toast.makeText(LastFamilyManageCustomerApplyDelete.this, "net error!", Toast.LENGTH_SHORT).show();
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
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });

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
