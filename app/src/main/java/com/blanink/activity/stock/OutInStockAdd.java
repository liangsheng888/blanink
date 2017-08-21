package com.blanink.activity.stock;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
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
import com.blanink.pojo.ProductNo;
import com.blanink.pojo.ResponseOrder;
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


public class OutInStockAdd extends AppCompatActivity {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.table)
    RelativeLayout table;
    @BindView(R.id.sp_no)
    Spinner spNo;
    @BindView(R.id.rb_stock)
    RadioButton rbStock;
    @BindView(R.id.rb_finishd)
    RadioButton rbFinishd;
    @BindView(R.id.rg_type)
    RadioGroup rgType;
    @BindView(R.id.tv_category)
    TextView tvCategory;
    @BindView(R.id.et_product_name)
    EditText etProductName;
    @BindView(R.id.et_num)
    EditText etNum;
    @BindView(R.id.tv_unit)
    TextView tvUnit;
    @BindView(R.id.et_price)
    EditText etPrice;
    @BindView(R.id.et_note)
    EditText etNote;
    @BindView(R.id.bt_commit)
    Button btCommit;
    private SharedPreferences sp;
    private String cateGoryId="";
    private String name="";
    private String procuteNumber="";
    private String inventoryType = "1";
    private String unit="";
    private String remarks="";
    private String changeAmount = "0";
    private String unitPrice="0";
    private String inOut = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_in_add);
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
        String type= getIntent().getStringExtra("inOut");
        if("1".equals(type)){
            rbStock.setChecked(true);
        }else if("2".equals(type)) {
            rbFinishd.setChecked(true);
        }
        //加载产品类
        loadNo();
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
                switch (checkedId) {
                    case R.id.rb_stock://原料
                        inOut = "1";
                        break;
                    case R.id.rb_finishd://成品
                        inOut = "2";
                        break;
                }
            }
        });
        //
        btCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etProductName.getText().toString().trim();
                unit = tvUnit.getText().toString().trim();
                unitPrice = etPrice.getText().toString().trim();
                changeAmount = etNum.getText().toString().trim();
                remarks = etNote.getText().toString().trim();
                if ("选择唯一标识编号".equals(procuteNumber)) {
                    Toast.makeText(OutInStockAdd.this, "唯一标识编号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cateGoryId)) {
                    Toast.makeText(OutInStockAdd.this, "请选择产品类", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(OutInStockAdd.this, "产品规格不那个为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(changeAmount)) {
                    Toast.makeText(OutInStockAdd.this, "数量不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(unit)) {
                    Toast.makeText(OutInStockAdd.this, "单位不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(unitPrice)) {
                    Toast.makeText(OutInStockAdd.this, "单价不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                DialogLoadUtils.getInstance(OutInStockAdd.this);
                DialogLoadUtils.showDialogLoad("提交中...");
                save();
            }
        });
    }

    private void loadNo() {
        String url = NetUrlUtils.NET_URL + "companyInventoryInOut/companyCategoryList";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("companyId.id", sp.getString("COMPANY_ID", null))
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
                final ProductNo pNo = gson.fromJson(result, ProductNo.class);
                final List<String> pNoNameList = new ArrayList<String>();
                final List<String> cateGoryList = new ArrayList<String>();
                final List<String> unitList = new ArrayList<String>();

                final List<String> cateGoryIdList = new ArrayList<String>();
                pNoNameList.add("选择唯一标识编号");
                cateGoryIdList.add("");
                cateGoryList.add("产品类");
                unitList.add("单位");
                for (ProductNo.ResultBean rb : pNo.getResult()) {
                    pNoNameList.add(rb.getProcuteNumber());
                    cateGoryIdList.add(rb.getCompanyCategoryId().getId());
                    cateGoryList.add(rb.getCompanyCategoryId().getName());
                    unitList.add(rb.getUnit());
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        spNo.setAdapter(new ArrayAdapter<String>(OutInStockAdd.this, R.layout.spanner_item, pNoNameList));
                        spNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                procuteNumber=pNoNameList.get(position);
                                cateGoryId = cateGoryIdList.get(position);
                                tvCategory.setText(cateGoryList.get(position));
                                tvUnit.setText(unitList.get(position));
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


    private void save() {
        if (!CommonUtil.isConnected(this)) {
            Toast.makeText(OutInStockAdd.this, "请检查你的网络", Toast.LENGTH_SHORT).show();
            return;
        }
        String url = NetUrlUtils.NET_URL + "companyInventoryInOut/save";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("companyId.id", sp.getString("COMPANY_ID", null))
                .add("name", name)
                .add("procuteNumber", procuteNumber)
                .add("companyCategoryId.id", cateGoryId)
                .add("inOut", inOut)
                .add("unit", unit)
                .add("remarks", remarks)
                .add("changeAmount", changeAmount)
                .add("currentUser.id", sp.getString("USER_ID", null))
                .add("unitPrice", unitPrice)

                .build();
        final Request request = new Request.Builder().post(body).url(url).build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OutInStockAdd.this, "服务器异常", Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Log.e("@@@@",result);
                Gson gson = new Gson();
                final ResponseOrder rd = gson.fromJson(result, ResponseOrder.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogLoadUtils.dismissDialog();
                        if ("00000".equals(rd.getErrorCode())) {
                            deleteNofity("保存成功，是否继续添加?","继续","返回");
                        } else {
                            Toast.makeText(OutInStockAdd.this, rd.getReason(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }



    private void deleteNofity( String content, String left, String right) {
        final AlertDialog alertDialog = new AlertDialog.Builder(OutInStockAdd.this).create();
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
