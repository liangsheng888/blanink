package com.blanink.activity.my;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.MainActivity;
import com.blanink.pojo.LoginResult;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.XUtilsImageUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/***
 * 我的个人资料
 */
public class MyProfile extends AppCompatActivity {
    private SharedPreferences sp;
    private TextView iv_last;
    private TextView tv_name;
    private ImageView iv_photo;
    private TextView tv_company;
    private TextView tv_role;
    private ImageView iv_company_photo;
    private TextView tv_area;
    private TextView tv_phone;
    private TextView tv_modify;
    private LoginResult loginResult;
    private MyActivityManager myActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initView();
        initData();
    }

    private void initView() {
        iv_last = ((TextView) findViewById(R.id.iv_last));
        tv_name = ((TextView) findViewById(R.id.tv_name));
        iv_photo = ((ImageView) findViewById(R.id.iv_photo));
        tv_company = ((TextView) findViewById(R.id.tv_company));
        tv_role = ((TextView) findViewById(R.id.tv_role));
        iv_company_photo = ((ImageView) findViewById(R.id.iv_company_photo));
        tv_area = ((TextView) findViewById(R.id.tv_area));
        tv_phone = ((TextView) findViewById(R.id.tv_phone_number));
        tv_modify = ((TextView) findViewById(R.id.tv_modify));
    }

    private void initData() {
        loadUserInfoFromSever();
        iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfile.this, ModifyProfile.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("MyProfile", loginResult);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        loadUserInfoFromSever();
    }

    public void loadUserInfoFromSever() {
        // http://localhost:8088/blanink-api/customer/user?userId=fec25c7f7634448581e21876ef517c57

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "user");
        rp.addBodyParameter("id", sp.getString("USER_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("MyProfile", "result:" + result);
                Gson gson = new Gson();
                loginResult = gson.fromJson(result, LoginResult.class);
                Log.e("MyProfile", "loginResult:" + loginResult);
                GlideUtils.glideImageView(MyProfile.this,iv_photo, loginResult.getResult().photo, true);
                tv_name.setText(loginResult.getResult().name);
                tv_company.setText(loginResult.getResult().company.name);
                tv_role.setText(loginResult.getResult().roleNames);
                tv_phone.setText(loginResult.getResult().phone);
                tv_area.setText(loginResult.getResult().company.area.name);
                GlideUtils.glideImageView(MyProfile.this,iv_company_photo, loginResult.getResult().getCompany().getPhoto(), true);

                //x.image().bind(iv_photo,NetUrlUtils.NET_URL+loginResult.getResult().getPhoto());

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
            Intent intent = new Intent(MyProfile.this, MainActivity.class);
            intent.putExtra("DIRECT", 4);
            startActivity(intent);
    }
}
