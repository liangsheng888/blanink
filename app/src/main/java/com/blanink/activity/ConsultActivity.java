package com.blanink.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.ManyCustomer;
import com.blanink.pojo.Response;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.NoScrollListview;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;
import java.util.List;

/**
 * 咨询
 * */
public class ConsultActivity extends AppCompatActivity {
    private ManyCustomer.Result.Company companyB;
    private ImageView last;
    private MyActivityManager myActivityManager;
    private NoScrollListview lv;
    private EditText ec_edit_message_input;
    private Button ec_btn_send;
    private SharedPreferences sp;
    private List<ManyCustomer.CustomerService> customerServiceList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp=getSharedPreferences("DATA",MODE_PRIVATE);
        receiveIntentfromNext();
        initView();
        initData();
    }

    private void initView() {
        last = ((ImageView) findViewById(R.id.come_order_iv_last));
        lv = ((NoScrollListview) findViewById(R.id.lv_message));//显示消息内容
        ec_edit_message_input = ((EditText) findViewById(R.id.ec_edit_message_input));//消息输入
        ec_btn_send = ((Button) findViewById(R.id.ec_btn_send));//发送
    }

    private void initData() {
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //
        ec_btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=ec_edit_message_input.getText().toString();
                if(TextUtils.isEmpty(message)){
                    Toast.makeText(ConsultActivity.this, "消息内容不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                sendMessage(message);

            }
        });

    }
  //接收上个界面的信息
    private void receiveIntentfromNext() {
        Intent intent=getIntent();
        companyB=(ManyCustomer.Result.Company) intent.getExtras().getSerializable("companyB");
        Log.e("ConsultActivity","companyB+++++"+companyB.getCustomerServiceList().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    private void sendMessage(final String content){
        RequestParams rp=new RequestParams(NetUrlUtils.NET_URL+"notify/send");
        customerServiceList = companyB.customerServiceList;
        for (int i=0;i<customerServiceList.size();i++){
        rp.addBodyParameter("oaNotifyRecordIds",customerServiceList.get(i).getId());}
        rp.addBodyParameter("userId",sp.getString("USER_ID","NULL"));
        rp.addBodyParameter("content",content);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                Response rs=gson.fromJson(result, Response.class);
                if(rs.getErrorCode().equals("00000")){
                   Log.e("ConsultActivity","发送成功");
                    ec_edit_message_input.setText("");
                }else {
                    Log.e("ConsultActivity","发送失败");
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
}
