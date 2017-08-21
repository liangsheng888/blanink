package com.blanink.activity.stock;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
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
import com.blanink.pojo.Stock;
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
public class WareHouseModify extends AppCompatActivity {

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
    private Stock.ResultBean.RowsBean rowsBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ware_modify);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", Context.MODE_PRIVATE);
        rowsBean = ((Stock.ResultBean.RowsBean) getIntent().getSerializableExtra("rowsBean"));
        initData();
    }

    private void initData() {

        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        etNo.setText(rowsBean.getProcuteNumber());
        etNum.setText(rowsBean.getStok()+"");
        etPrice.setText(rowsBean.getUnitPrice());
        etUnit.setText(rowsBean.getUnit());
        etProductName.setText(rowsBean.getName());
        etNote.setText(rowsBean.getRemarks());
        cateGoryId=rowsBean.getCompanyCategoryId().getId();
        if("1".equals(rowsBean.getInventoryType())){
           rbStock.setChecked(true);
        }else {
            rbFinishd.setChecked(true);
        }
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
                    Toast.makeText(WareHouseModify.this, "唯一标识编号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(cateGoryId)){
                    Toast.makeText(WareHouseModify.this, "请选择产品类", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(WareHouseModify.this, "产品规格不那个为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(stok)){
                    Toast.makeText(WareHouseModify.this, "数量不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(unit)){
                    Toast.makeText(WareHouseModify.this, "单位不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(unitPrice)){
                    Toast.makeText(WareHouseModify.this, "单价不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                DialogLoadUtils.getInstance(WareHouseModify.this);
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
                     spCategory.setAdapter(new ArrayAdapter<String>(WareHouseModify.this,R.layout.spanner_item,cateGoryNameList));
                        spCategory.setSelection(getCompanyCateGoryIndex(rowsBean.getCompanyCategoryId().getId(),cateGoryIdList),true);
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
            Toast.makeText(WareHouseModify.this, "请检查你的网络", Toast.LENGTH_SHORT).show();
            return;
        }
        String url = NetUrlUtils.NET_URL + "companyInventory/update";
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
                .add("id",rowsBean.getId())
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
                        Toast.makeText(WareHouseModify.this, "服务器异常", Toast.LENGTH_SHORT).show();

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
                         Toast.makeText(WareHouseModify.this, "修改成功", Toast.LENGTH_SHORT).show();
                     }else {
                         Toast.makeText(WareHouseModify.this, rd.getReason(), Toast.LENGTH_SHORT).show();
                     }
                    }
                });
            }
        });

    }

    private int getCompanyCateGoryIndex(String id,List<String> idList){
        int inidex=0;
        for (int i=0;i<idList.size();i++){
            if(id.equals(idList.get(i))){
                inidex=i;
            }
        }
        return  inidex;
    }
}
