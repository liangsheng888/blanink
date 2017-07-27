package com.blanink.activity.set;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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
import com.blanink.pojo.Response;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;
import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;


/***
 * 修改密码
 */
public class ModifyPsd extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.et_oldPsd)
    EditText etOldPsd;
    @BindView(R.id.et_newPsd)
    EditText etNewPsd;
    @BindView(R.id.et_nick)
    EditText etNick;
    @BindView(R.id.btn_ok)
    Button btnOk;
    @BindView(R.id.tender_manager)
    RelativeLayout tenderManager;
    @BindView(R.id.ll_psd)
    LinearLayout llPsd;
    @BindView(R.id.activity_modify_psd)
    RelativeLayout activityModifyPsd;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        setContentView(R.layout.activity_modify_psd);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_last, R.id.btn_ok})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_last:
                finish();
                break;
            case R.id.btn_ok:
                commitData();
                break;
        }
    }

    private void commitData() {
        //修改前先验证
        // http://localhost:8088/blanink-api/passwordUpdata?loginName=admin&newPassword=admin&id=2
        String oldPsd = etOldPsd.getText().toString().trim();
        String newPsd = etNewPsd.getText().toString().trim();
        String newPsdSecond = etNick.getText().toString().trim();
        if (TextUtils.isEmpty(oldPsd)) {
            Toast.makeText(this, "请输入旧密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(newPsd)) {
            Toast.makeText(this, "请输入新密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!oldPsd.equals(sp.getString("PASSWORD", null))) {
            Toast.makeText(this, "你输入的旧密码不正确", Toast.LENGTH_SHORT).show();
            return;

        }
        if (!newPsdSecond.equals(newPsd)) {
            Toast.makeText(this, "两次输入的新密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        DialogLoadUtils.getInstance(ModifyPsd.this);
        DialogLoadUtils.showDialogLoad("操作进行中...");

        loadData(newPsd);
    }

    //提交密码
    private void loadData(String psd) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "passwordUpdata");
        rp.addBodyParameter("id", sp.getString("USER_ID", null));
        rp.addBodyParameter("newPassword", psd);
        rp.addBodyParameter("loginName", sp.getString("LOGIN_NAME", null));

        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                DialogLoadUtils.dismissDialog();
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if (response.getErrorCode().equals("00000")) {
                    showDialog();
                }else {
                    Toast.makeText(ModifyPsd.this, "修改失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();
                Toast.makeText(ModifyPsd.this, "服务器异常", Toast.LENGTH_SHORT).show();
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

    private void showDialog() {
        final AlertDialog alertDialog = new AlertDialog.Builder(ModifyPsd.this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_success);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        Display d = getWindowManager().getDefaultDisplay(); // 获取屏幕宽、高用
        //  lp.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);
        alertDialog.setCanceledOnTouchOutside(false);
        window.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
