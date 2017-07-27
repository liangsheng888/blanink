package com.blanink.activity.order;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.OfficeEmp;
import com.blanink.pojo.PartnerInfo;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 来单新增信息
 */
public class ComeOrderNewAddInfoActivity extends AppCompatActivity {

    @BindView(R.id.come_order_new_add_tv_seek)
    TextView comeOrderNewAddTvSeek;
    @BindView(R.id.come_order_new_add_iv_last)
    TextView comeOrderNewAddIvLast;
    @BindView(R.id.come_order_new_add_rl)
    RelativeLayout comeOrderNewAddRl;
    @BindView(R.id.tv_select_user)
    TextView tvSelectUser;
    @BindView(R.id.sp_customer)
    Spinner spCustomer;
    @BindView(R.id.come_order_new_add_rl2)
    RelativeLayout comeOrderNewAddRl2;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.sp_master)
    Spinner spMaster;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.come_order_new_add_edt_order)
    EditText comeOrderNewAddEdtOrder;
    @BindView(R.id.tv_order_note)
    TextView tvOrderNote;
    @BindView(R.id.come_order_new_add_edt_note)
    EditText comeOrderNewAddEdtNote;
    @BindView(R.id.tv_endDateHand)
    TextView tvEndDateHand;
    @BindView(R.id.et_date)
    EditText etDate;
    @BindView(R.id.iv_date)
    ImageView ivDate;
    @BindView(R.id.rl_DateHand)
    RelativeLayout rlDateHand;
    @BindView(R.id.come_order_new_add_ll)
    LinearLayout comeOrderNewAddLl;
    @BindView(R.id.tv_customer_name)
    TextView tvCustomerName;
    @BindView(R.id.ll_customer)
    LinearLayout llCustomer;
    @BindView(R.id.tv_customer_phone)
    TextView tvCustomerPhone;
    @BindView(R.id.ll_customer_phone)
    LinearLayout llCustomerPhone;
    @BindView(R.id.tv_customer_address)
    TextView tvCustomerAddress;
    @BindView(R.id.ll_customer_address)
    LinearLayout llCustomerAddress;
    @BindView(R.id.come_order_new_add_customer_info)
    RelativeLayout comeOrderNewAddCustomerInfo;
    @BindView(R.id.btn_contiume_add)
    Button btnContiumeAdd;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private List<String> customerNameList = new ArrayList<>();
    private List<String> masterNameList = new ArrayList<>();
    private List<String> customerIdList = new ArrayList<>();
    private List<String> customerAddress = new ArrayList<>();
    private List<String> customerPhone = new ArrayList<>();
    PartnerInfo partnerInfo;
    public String date;
    public String note;
    public String number;
    public String customer;
    public String master;
    private String aCompanyId;
    private String bMasterId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_order_new_add_info);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initData();
    }

    private void initData() {
        getCustmoer();
        getCompanyEmp();
        comeOrderNewAddIvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //继续添加产品
        btnContiumeAdd.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                note = comeOrderNewAddEdtNote.getText().toString().trim();
                number = comeOrderNewAddEdtOrder.getText().toString().trim();
                date=etDate.getText().toString().trim();
                if (TextUtils.isEmpty(number)) {
                    Toast.makeText(ComeOrderNewAddInfoActivity.this, "请输入订单编号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(note)) {
                    Toast.makeText(ComeOrderNewAddInfoActivity.this, "请填写备注信息", Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent intent = new Intent(ComeOrderNewAddInfoActivity.this, ComeOrderAddProductActivity.class);
                intent.putExtra("customer", customer);
                intent.putExtra("aCompanyId",aCompanyId);
                intent.putExtra("bMasterId", bMasterId);
                intent.putExtra("orderNumber", number);
                intent.putExtra("orderNote", note);
                intent.putExtra("finishDate", date);
                startActivity(intent);
            }
        });

        final Calendar calendar = Calendar.getInstance();
        etDate.setText(calendar.get(calendar.YEAR) + "-" + (calendar.get(calendar.MONTH) + 1) + "-" + calendar.get(calendar.DAY_OF_MONTH));
        ivDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dpd = new DatePickerDialog(ComeOrderNewAddInfoActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etDate.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                        date = etDate.getText().toString().trim();
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    //获得客户列表
    private void getCustmoer() {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/officeList");
        rp.addBodyParameter("companyB.id", sp.getString("COMPANY_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                 partnerInfo = gson.fromJson(result, PartnerInfo.class);
                if (partnerInfo.getResult().size() > 0) {
                    for (int i = 0; i < partnerInfo.getResult().size(); i++) {
                        customerNameList.add(partnerInfo.getResult().get(i).getCompanyA().getName());
                        customerIdList.add(partnerInfo.getResult().get(i).getCompanyA().getId());
                        customerAddress.add(partnerInfo.getResult().get(i).getCompanyA().getAddress());
                        customerPhone.add(partnerInfo.getResult().get(i).getCompanyA().getPhone());
                    }
                }
                if(partnerInfo.getResult().size()==0){
                    btnContiumeAdd.setText("你没有客户，无法添加订单");
                    btnContiumeAdd.setBackgroundColor(getResources().getColor(R.color.colorGray));
                }
                spCustomer.setAdapter(new ArrayAdapter<String>(ComeOrderNewAddInfoActivity.this,R.layout.spanner_item, customerNameList));
                spCustomer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        customer = customerNameList.get(position);
                        aCompanyId=customerIdList.get(position);
                        tvCustomerName.setText(customerNameList.get(position));
                        tvCustomerPhone.setText(customerPhone.get(position));
                        tvCustomerAddress.setText(customerAddress.get(position));

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

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

    //获得本公司人员列表
    private void getCompanyEmp() {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/userList");
        rp.addBodyParameter("id", sp.getString("COMPANY_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                final OfficeEmp officeEmp = gson.fromJson(result, OfficeEmp.class);
                for (int i = 0; i < officeEmp.getResult().size(); i++) {
                    masterNameList.add(officeEmp.getResult().get(i).getName());
                }
                Log.e("ComeOrder",masterNameList.toString());
                spMaster.setAdapter(new ArrayAdapter<String>(ComeOrderNewAddInfoActivity.this, R.layout.spanner_item,masterNameList));
                spMaster.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        master = masterNameList.get(position);
                        bMasterId=officeEmp.getResult().get(position).getId();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
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
