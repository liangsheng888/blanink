package com.blanink.activity.order;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
import com.blanink.pojo.ComeOder;
import com.blanink.pojo.OfficeEmp;
import com.blanink.pojo.PartnerInfo;
import com.blanink.pojo.Response;
import com.blanink.utils.DialogLoadUtils;
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

public class ComeOrderModifyNoModifyCustomer extends AppCompatActivity {

    @BindView(R.id.come_order_new_add_tv_seek)
    TextView comeOrderNewAddTvSeek;
    @BindView(R.id.come_order_new_add_iv_last)
    TextView comeOrderNewAddIvLast;
    @BindView(R.id.come_order_new_add_rl)
    RelativeLayout comeOrderNewAddRl;
    @BindView(R.id.tv_select_user)
    TextView tvSelectUser;
    @BindView(R.id.tv_customer)
    TextView tvCustomer;
    @BindView(R.id.come_order_new_add_rl2)
    RelativeLayout comeOrderNewAddRl2;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.sp_master)
    Spinner spMaster;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.et_order_number)
    EditText etOrderNumber;
    @BindView(R.id.tv_order_note)
    TextView tvOrderNote;
    @BindView(R.id.et_note)
    EditText etNote;
    @BindView(R.id.tv_endDateHand)
    TextView tvEndDateHand;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.iv_date)
    ImageView ivDate;
    @BindView(R.id.rl_DateHand)
    RelativeLayout rlDateHand;
    @BindView(R.id.come_order_new_add_ll)
    LinearLayout comeOrderNewAddLl;
    @BindView(R.id.btn_save)
    Button btnSave;
    private MyActivityManager instance;
    private ComeOder.ResultBean.RowsBean order;
    private SharedPreferences sp;
    private PartnerInfo partnerInfo;
    private List<String> customerNameList = new ArrayList<>();
    private List<String> masterNameList = new ArrayList<>();
    private List<String> customerIdList = new ArrayList<>();
    private List<String> customerAddress = new ArrayList<>();
    private List<String> customerPhone = new ArrayList<>();
    private List<String> masterIdList=new ArrayList<>();

    private String customer;
    private String aCompanyId;
    private String bMasterId;
    private String master;
    private String remarks;
    private String aOrderNumber;
    private String deliverTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_order_modify_no_modify_customer);
        ButterKnife.bind(this);
        instance = MyActivityManager.getInstance();
        instance.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        getIntentData();
        getCompanyEmp();
        comeOrderNewAddIvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final Calendar calendar = Calendar.getInstance();

        tvDate.setText(order.getDelieverTimeString());
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dpd = new DatePickerDialog(ComeOrderModifyNoModifyCustomer.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDate.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                remarks = etNote.getText().toString();
                aOrderNumber = etOrderNumber.getText().toString();
                deliverTime = tvDate.getText().toString();
                if(TextUtils.isEmpty(aOrderNumber)){
                    Toast.makeText(ComeOrderModifyNoModifyCustomer.this, "请填写订单编号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(remarks)){
                    Toast.makeText(ComeOrderModifyNoModifyCustomer.this, "请填写备注", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.getInstance(ComeOrderModifyNoModifyCustomer.this);
                DialogLoadUtils.showDialogLoad("正在修改...");
                saveData();
            }
        });
    }

    private void saveData() {
        RequestParams rp=new RequestParams(NetUrlUtils.NET_URL+"order/orderUpdate");
        rp.addBodyParameter("id",order.getId());
        rp.addBodyParameter("aOrderNumber",aOrderNumber);
        rp.addBodyParameter("aCompany.id",aCompanyId);
        rp.addBodyParameter("bCompany.id",sp.getString("COMPANY_ID",null));
        rp.addBodyParameter("delieverTime",deliverTime);
        rp.addBodyParameter("remarks",remarks);

        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                Response re=gson.fromJson(result, Response.class);
                if("00000".equals(re.getErrorCode())){
                    showNotify(ComeOrderModifyNoModifyCustomer.this,"修改订单成功");
                    DialogLoadUtils.dismissDialog();
                }else {
                    DialogLoadUtils.dismissDialog();
                    Toast.makeText(ComeOrderModifyNoModifyCustomer.this, "修改失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();
                Toast.makeText(ComeOrderModifyNoModifyCustomer.this, "服务器异常，请稍后再试", Toast.LENGTH_SHORT).show();
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

    private void getIntentData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        order = (ComeOder.ResultBean.RowsBean) bundle.getSerializable("OrderDetail");
        etOrderNumber.setText(order.getAOrderNumber());
        etNote.setText(order.getRemarks());
        tvCustomer.setText(order.getaCompany().getName());
        aCompanyId=order.getACompany().getId();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance.popOneActivity(this);
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
                    masterIdList.add(officeEmp.getResult().get(i).getId());
                }
                Log.e("ComeOrder", masterNameList.toString());
                spMaster.setAdapter(new ArrayAdapter<String>(ComeOrderModifyNoModifyCustomer.this, R.layout.spanner_item, masterNameList));
                spMaster.setSelection(getMasterPosition(order.getACompanyOrderOwnerUser().getId()), true);
                spMaster.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        master = masterNameList.get(position);
                        bMasterId = officeEmp.getResult().get(position).getId();
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

    //判断 当前客户所处位置
    public int getCustomerPosition(String name) {
        int position = 0;
        for (int i = 0; i < customerNameList.size(); i++) {
            if (name.equals(customerNameList.get(i))) {
                position = i;
            }
        }
        return position;
    }

    //判断 当前负责人所处位置
    public int getMasterPosition(String name) {
        int position = 0;
        for (int i = 0; i < masterIdList.size(); i++) {
            if (name.equals(masterIdList.get(i))) {
                position = i;
            }
        }
        return position;
    }

    public  void showNotify(final Context context, String tilte) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_apply_delete_relation);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        WindowManager windowManager = (WindowManager)
                context.getSystemService(Context.WINDOW_SERVICE);
        Display d = windowManager.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);
        alertDialog.setCanceledOnTouchOutside(false);
        ((TextView)(window.findViewById(R.id.tv_message))).setText(tilte);
        window.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                finish();
            }
        });
    }
}