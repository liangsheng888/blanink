package com.blanink.activity.afterSale;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.AfterSales;
import com.blanink.pojo.ResponseDelete;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//售后处理
public class AfterSaleToHandle extends AppCompatActivity {


    private static final int RESULT_CODE =100 ;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.rl_after_sale_demand)
    RelativeLayout rlAfterSaleDemand;
    @BindView(R.id.reason)
    TextView reason;
    @BindView(R.id.tv_reason)
    TextView tvReason;
    @BindView(R.id.tv_chat)
    TextView tvChat;
    @BindView(R.id.tv_demand)
    TextView tvDemand;
    @BindView(R.id.sp_demand)
    Spinner spDemand;
    @BindView(R.id.tv_specific_description_to_demand)
    TextView tvSpecificDescriptionToDemand;
    @BindView(R.id.et_description_to_demand)
    EditText etDescriptionToDemand;
    @BindView(R.id.ll_chat)
    LinearLayout llChat;
    @BindView(R.id.btn_ok)
    Button btnOk;
    @BindView(R.id.activity_after_sale_demand)
    RelativeLayout activityAfterSaleDemand;
    @BindView(R.id.tv_after_sale)
    TextView tvAfterSale;
    @BindView(R.id.sp_afterState)
    Spinner spAfterState;
    @BindView(R.id.rb_yes)
    RadioButton rbYes;
    @BindView(R.id.rb_no)
    RadioButton rbNo;
    @BindView(R.id.rg_phone)
    RadioGroup rgPhone;
    private SharedPreferences sp;
    private String solution="";
    private String  remarks="";
    private String  id="";
    private String status="";
    private String isCall="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sale_to_handle);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvReason.setText(getIntent().getStringExtra("reason"));
        //是否电话沟通
         rgPhone.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId) {
                 switch (checkedId){
                     case R.id.rb_yes:
                         isCall="1";
                         break;
                     case R.id.rb_no:
                         isCall="0";
                         break;
                 }
             }
         });
        //处理意见（1,2）
        spDemand.setAdapter(new ArrayAdapter<String>(AfterSaleToHandle.this, R.layout.spanner_item, new String[]{"退货", "整改"}));
        spDemand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                solution = (position + 1) + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //售后状态（1,2,3,4,5，6）

        spAfterState.setAdapter(new ArrayAdapter<String>(AfterSaleToHandle.this, R.layout.spanner_item, new String[]{"发起售后", "已接受并处理", "内部处理结束", "待发起方确认", "售后结束"}));
        spAfterState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                status = (position + 1) + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                remarks=etDescriptionToDemand.getText().toString();
                if(TextUtils.isEmpty(remarks)){
                    Toast.makeText(AfterSaleToHandle.this, "备注不能为空额", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.getInstance(AfterSaleToHandle.this);
                DialogLoadUtils.showDialogLoad("正在处理...");
                save();
            }
        });
    }

    private void save() {
        //http://localhost:8080/blanink-api/afterSales/afterSalesHandle?
        // userId=4856035c527b419a9cf70d856e65c93b&isCall=0&remarks=杀杀杀&status=1&solution=1&id
        String url = NetUrlUtils.NET_URL + "afterSales/afterSalesHandle";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("currentUser.id", sp.getString("USER_ID", null))
                .add("company.id",sp.getString("COMPANY_ID",null))
                .add("solution", solution)
                .add("afterSales.id", getIntent().getStringExtra("id"))
                .add("isCalled", isCall)
                .add("status", status)
                .add("remarks", remarks)
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogLoadUtils.dismissDialog();
                        Toast.makeText(AfterSaleToHandle.this, "服务器开了回小差", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final ResponseDelete rd = gson.fromJson(result, ResponseDelete.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if("00000".equals(rd.getErrorCode())){
                            DialogLoadUtils.dismissDialog();
                            Intent intent=new Intent();
                            setResult(RESULT_CODE,intent);
                            finish();
                            Toast.makeText(AfterSaleToHandle.this, "处理成功", Toast.LENGTH_SHORT).show();

                        }else {
                            DialogLoadUtils.dismissDialog();
                            Toast.makeText(AfterSaleToHandle.this, "操着失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}

