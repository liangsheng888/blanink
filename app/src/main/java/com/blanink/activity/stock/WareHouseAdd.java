package com.blanink.activity.stock;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.CompanyProductCategory;
import com.blanink.pojo.ResponseDelete;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.CommonUtil;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/***
 * 库存添加
 */
public class WareHouseAdd extends AppCompatActivity {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.table)
    RelativeLayout table;
    @BindView(R.id.et_no)
    EditText etNo;
    @BindView(R.id.rb_stock)
    RadioButton rbStock;
    @BindView(R.id.rb_finishd)
    RadioButton rbFinishd;
    @BindView(R.id.rg_type)
    RadioGroup rgType;
    @BindView(R.id.sp_category)
    Spinner spCategory;
    @BindView(R.id.et_product_name)
    EditText etProductName;
    @BindView(R.id.et_num)
    EditText etNum;
    @BindView(R.id.et_unit)
    EditText etUnit;
    @BindView(R.id.et_price)
    EditText etPrice;
    @BindView(R.id.et_note)
    EditText etNote;
    @BindView(R.id.bt_commit)
    Button btCommit;
    private SharedPreferences sp;
    private String cateGoryId;
    private String name;
    private String procuteNumber;
    private String inventoryType="1";
    private String unit;
    private String remarks;
    private String stok="0";
    private String unitPrice;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ware_house_add);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", Context.MODE_PRIVATE);

        initData();
    }

    private void initData() {
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //加载产品类
        loadCateGory();
        //返回
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_stock://原料
                        inventoryType="1";
                        break;
                    case R.id.rb_finishd://成品
                        inventoryType="2";
                        break;
                }
            }
        });
        //
        btCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procuteNumber=etNo.getText().toString().trim();
                name=etProductName.getText().toString().trim();
                unit=etUnit.getText().toString().trim();
                unitPrice=etPrice.getText().toString().trim();
                stok=etNum.getText().toString().trim();
                remarks=etNote.getText().toString().trim();
                if(TextUtils.isEmpty(procuteNumber)){
                    Toast.makeText(WareHouseAdd.this, "唯一标识编号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(cateGoryId)){
                    Toast.makeText(WareHouseAdd.this, "请选择产品类", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(WareHouseAdd.this, "产品规格不那个为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(stok)){
                    Toast.makeText(WareHouseAdd.this, "数量不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(unit)){
                    Toast.makeText(WareHouseAdd.this, "单位不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(unitPrice)){
                    Toast.makeText(WareHouseAdd.this, "单价不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                DialogLoadUtils.getInstance(WareHouseAdd.this);
                DialogLoadUtils.showDialogLoad("提交中...");
                save();
            }
        });
    }

    private void loadCateGory(){
        String url = NetUrlUtils.NET_URL + "companyInventory/companyCategoryList";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("company.id", sp.getString("COMPANY_ID", null))
                .build();
        final Request request = new Request.Builder().post(body).url(url).build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                   runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final CompanyProductCategory companyProductCategory = gson.fromJson(result, CompanyProductCategory.class);
                final List<String> cateGoryNameList=new ArrayList<String>();
                final List<String> cateGoryIdList=new ArrayList<String>();
                cateGoryIdList.add("");
                cateGoryNameList.add("选择产品类");
                for(CompanyProductCategory.ResultBean rb:companyProductCategory.getResult()){
                    cateGoryNameList.add(rb.getName());
                    cateGoryIdList.add(rb.getId());
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                     spCategory.setAdapter(new ArrayAdapter<String>(WareHouseAdd.this,R.layout.spanner_item,cateGoryNameList));
                     spCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                         @Override
                         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                             cateGoryId = cateGoryIdList.get(position);
                         }

                         @Override
                         public void onNothingSelected(AdapterView<?> parent) {

                         }
                     });
                    }
                });
            }
        });

    }


    private void save(){
        if(!CommonUtil.isConnected(this)){
            Toast.makeText(WareHouseAdd.this, "请检查你的网络", Toast.LENGTH_SHORT).show();
            return;
        }
        String url = NetUrlUtils.NET_URL + "companyInventory/save";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("companyId.id", sp.getString("COMPANY_ID", null))
                .add("name",name)
                .add("procuteNumber", procuteNumber)
                .add("companyCategoryId.id", cateGoryId)
                .add("inventoryType",inventoryType)
                .add("unit",unit)
                .add("remarks",remarks)
                .add("stok", stok)
                .add("currentUser.id", sp.getString("USER_ID",null))
                .add("unitPrice", unitPrice)

                .build();
        final Request request = new Request.Builder().post(body).url(url).build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WareHouseAdd.this, "服务器异常", Toast.LENGTH_SHORT).show();

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
                        DialogLoadUtils.dismissDialog();
                     if("00000".equals(rd.getErrorCode())){
                         deleteNofity("保存成功，是否继续添加?","继续","返回");

                     }else {
                         Toast.makeText(WareHouseAdd.this, rd.getReason(), Toast.LENGTH_SHORT).show();
                     }
                    }
                });
            }
        });

    }

    private void deleteNofity( String content, String left, String right) {
        final AlertDialog alertDialog = new AlertDialog.Builder(WareHouseAdd.this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_exit);
        final Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        window.setAttributes(lp);
        ((TextView) window.findViewById(R.id.tv_content)).setText(content);
        ((TextView) window.findViewById(R.id.tv_continue)).setText(left);
        ((TextView) window.findViewById(R.id.tv_exit)).setText(right);
        window.findViewById(R.id.tv_continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        window.findViewById(R.id.tv_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                finish();

            }
        });
    }
}
