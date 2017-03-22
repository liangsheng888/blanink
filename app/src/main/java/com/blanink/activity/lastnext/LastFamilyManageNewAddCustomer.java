package com.blanink.activity.lastNext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.Response;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.MyViewPager;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/***
 * 上家管理 客户管理 新建客户
 */
public class LastFamilyManageNewAddCustomer extends AppCompatActivity {

    private ImageView customer_add_iv_last;
    private MyActivityManager myActivityManager;
    private EditText et_company_name;
    private EditText et_major;
    private EditText et_contact_address;
    private EditText et_contact;
    private EditText et_contact_phone;
    private EditText et_email;
    private EditText et_note;
    private Button btn_submit;
    private SharedPreferences sp;
    private MyViewPager myViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_family_manage_new_add_customer);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initView();
        initData();
    }
    private void initView() {
        myViewPager = ((MyViewPager) findViewById(R.id.new_add_customer_viewpager));
        customer_add_iv_last = ((ImageView) findViewById(R.id.customer_add_iv_last));
        et_company_name = ((EditText) findViewById(R.id.et_company_name));//公司全名
        et_major = ((EditText) findViewById(R.id.et_major));//公司主营
        et_contact_address = ((EditText) findViewById(R.id.et_contact_address));//联系地址
        et_contact = ((EditText) findViewById(R.id.et_contact));//联系人
        et_contact_phone = ((EditText) findViewById(R.id.et_contact_phone));//联系电话
        et_email = ((EditText) findViewById(R.id.et_email));//邮箱
        et_note = ((EditText) findViewById(R.id.et_note));//备注信息
        btn_submit = ((Button) findViewById(R.id.btn_submit));//确认
    }

    private void initData() {
        customer_add_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //提交
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getData();
            }
        });
        //广告轮播
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.guanggao);
        list.add(R.drawable.guanggao1);
        list.add(R.drawable.guanggao2);
        list.add(R.drawable.guanggao3);
        myViewPager.pictureRoll(list);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    //访问服务器
    private void getData() {
        // http://jorion.wicp.net:34751/blanink-api/api/partner/save?
        // userId=d6c8e9bc4c2b476ba84b962c27882f41
        // &companyA.name=测试上家机构
        // &companyA.shortName=companyA.remarks
        // &companyA.registTime=
        // &companyA.code=100001
        // &companyA.master=上家测试员
        // &companyA.address=jfdafjdsa
        // &companyA.zipCode=100
        // &companyA.phone
        // &companyA.fax
        // &companyA.email
        // &companyA.scope=饭打发第三方
        // &companyA.remarks

        final String companyName = et_company_name.getText().toString();
        String master = et_contact.getText().toString();
        String address = et_contact_address.getText().toString();
        String scope = et_major.getText().toString();
        String phone = et_contact_phone.getText().toString();

        String email = et_email.getText().toString();
        String note = et_note.getText().toString();
        if (TextUtils.isEmpty(companyName)) {
            Toast.makeText(this, "请输入公司全称", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(master)) {
            Toast.makeText(this, "请输入公司联系人", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(address)) {
            Toast.makeText(this, "请输入联系人地址", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(scope)) {
            Toast.makeText(this, "请输入公司经营范围", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "请输入联系人手机号码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "请输入邮箱", Toast.LENGTH_SHORT).show();
            return;
        }

        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "customer/apply");
        requestParams.addBodyParameter("userId", sp.getString("USER_ID", null));
        Log.e("Last", "userId:" + sp.getString("USER_ID", null));
        requestParams.addBodyParameter("companyA.name", companyName);
        requestParams.addBodyParameter("companyA.master", master);
        requestParams.addBodyParameter("companyA.address", address);
        requestParams.addBodyParameter("companyA.phone", phone);
        requestParams.addBodyParameter("companyA.email", email);
        requestParams.addBodyParameter("companyA.scope", scope);
        requestParams.addBodyParameter("companyA.remarks", note);
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if ("00000".equals(response.getErrorCode())) {
                    Log.e("Last", "创建客户成功");
                    final AlertDialog alertDialog = new AlertDialog.Builder(LastFamilyManageNewAddCustomer.this).create();
                    alertDialog.setTitle("创建客户成功");
                    View view = View.inflate(LastFamilyManageNewAddCustomer.this, R.layout.customer_new_add_success, null);
                    Button btn_continue = ((Button) view.findViewById(R.id.btn_continue));
                    Button btn_see = ((Button) view.findViewById(R.id.btn_see));
                    TextView tv_company = ((TextView) view.findViewById(R.id.tv_company));
                    TextView tv_company2 = ((TextView) view.findViewById(R.id.tv_company2));
                    tv_company.setText(companyName);
                    tv_company2.setText(companyName);
                    btn_continue.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            clearContent();
                            alertDialog.dismiss();


                        }
                    });
                    btn_see.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //跳转到我的客户
                            Intent intent=new Intent(LastFamilyManageNewAddCustomer.this,LastFamilyManageCustomer.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.setCancelable(false);
                    alertDialog.setCanceledOnTouchOutside(false);
                    alertDialog.setView(view);
                    alertDialog.show();
                } else {
                    Log.e("Last", "创建客户失败");
                    Toast.makeText(LastFamilyManageNewAddCustomer.this, "该客户已存在！！！", Toast.LENGTH_SHORT).show();
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

    //清空信息
    private void clearContent() {
        et_company_name.setText("");
        et_contact.setText("");
        et_contact_address.setText("");
        et_major.setText("");
        et_contact_phone.setText("");
        et_email.setText("");
        et_note.setText("");
    }
}
