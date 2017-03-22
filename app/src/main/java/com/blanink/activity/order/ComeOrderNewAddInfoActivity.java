package com.blanink.activity.order;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.utils.MyActivityManager;

import java.util.Calendar;

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
    @BindView(R.id.come_order_new_add_sp_customer)
    Spinner comeOrderNewAddSpCustomer;
    @BindView(R.id.come_order_new_add_rl2)
    RelativeLayout comeOrderNewAddRl2;
    @BindView(R.id.tv_newAdd)
    TextView tvNewAdd;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.come_order_new_add_sp_pic)
    Spinner comeOrderNewAddSpPic;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_order_new_add_info);
        ButterKnife.bind(this);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initData();
    }
    private void initData() {
        comeOrderNewAddIvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //新增客户
        tvNewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //新增客户

            }
        });
        //继续添加产品
        btnContiumeAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ComeOrderNewAddInfoActivity.this, ComeOrderAddProductActivity.class);
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
}
