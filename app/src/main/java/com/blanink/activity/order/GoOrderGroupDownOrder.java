package com.blanink.activity.order;

import android.app.DatePickerDialog;
import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.GoFormDownOrder;
import com.blanink.pojo.OfficeEmp;
import com.blanink.pojo.Response;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.NoScrollListview;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 去单组合下单
 */
public class GoOrderGroupDownOrder extends AppCompatActivity {

    @BindView(R.id.go_order_group_tv_seek)
    TextView goOrderGroupTvSeek;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.go_order_group)
    RelativeLayout goOrderGroup;
    @BindView(R.id.ll_pro_queue)
    LinearLayout llProQueue;
    @BindView(R.id.lv_product)
    NoScrollListview lvProduct;
    @BindView(R.id.tv_priority)
    TextView tvPriority;
    @BindView(R.id.et_order_number)
    EditText etOrderNumber;
    @BindView(R.id.tv_hand_date)
    TextView tvHandDate;
    @BindView(R.id.et_hand_date_time)
    TextView etHandDateTime;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.tv_product_no)
    TextView tvProductNo;
    @BindView(R.id.sp_master)
    Spinner spMaster;
    @BindView(R.id.tv_note)
    TextView tvNote;
    @BindView(R.id.et_note)
    EditText etNote;
    @BindView(R.id.go_order_group_product_ll)
    LinearLayout goOrderGroupProductLl;
    @BindView(R.id.btn_ok)
    Button btnOk;
    private MyActivityManager instance;
    private List<GoFormDownOrder.ResultBean.OrderProductListBean> list = new ArrayList<>();
    private List<String> masterNameList = new ArrayList<>();
    private List<String> masterIdList = new ArrayList<>();
    private SharedPreferences sp;
    private String master;
    private String note;
    private String deliverTime;
    private String aNumber;
    private String masterId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_order_group_down_order);
        instance = MyActivityManager.getInstance();
        instance.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        DialogLoadUtils.getInstance(this);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

        initIntentData();
        //返回
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lvProduct.setAdapter(new CommonAdapter<GoFormDownOrder.ResultBean.OrderProductListBean>(GoOrderGroupDownOrder.this, list, R.layout.item_go_order_form) {
            @Override
            public void convert(ViewHolder viewHolder, GoFormDownOrder.ResultBean.OrderProductListBean orderProductListBean, int position) {

                orderProductListBean = list.get(position);
                TextView tv = viewHolder.getViewById(R.id.tv_company_category);
                TextView tv_delverTime = viewHolder.getViewById(R.id.tv_delverTime);
                TextView tv_product_name = viewHolder.getViewById(R.id.tv_product_name);
                tv.setText(orderProductListBean.getCompanyCategory().getName());
                tv_delverTime.setText(orderProductListBean.getDeliveryTime());
                tv_product_name.setText(orderProductListBean.getProductName());
            }
        });
        //我方责任人
        getCompanyEmp();
        //
        final Calendar calendar = Calendar.getInstance();
        etHandDateTime.setText(calendar.get(calendar.YEAR) + "-" + (calendar.get(calendar.MONTH) + 1) + "-" + calendar.get(calendar.DAY_OF_MONTH));
        etHandDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd = new DatePickerDialog(GoOrderGroupDownOrder.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etHandDateTime.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                        etHandDateTime.clearFocus();
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });

        //去下单
        btnOk.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                aNumber = etOrderNumber.getText().toString();
                deliverTime = etHandDateTime.getText().toString();
                note = etNote.getText().toString();
                if (TextUtils.isEmpty(aNumber)) {
                    Toast.makeText(GoOrderGroupDownOrder.this, "请填写订单编号", Toast.LENGTH_SHORT).show();

                    return;
                }
                if ("请选择责任人".equals(master)) {
                    Toast.makeText(GoOrderGroupDownOrder.this, "请选择责任人", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(note)) {
                    Toast.makeText(GoOrderGroupDownOrder.this, "请填写备注", Toast.LENGTH_SHORT).show();

                    return;
                }
                DialogLoadUtils.showDialogLoad("正在下单中...");
                downOrder();
            }
        });
    }

    private void initIntentData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String orderProduct = bundle.getString("OrderProductMap");
        Map<Integer, GoFormDownOrder.ResultBean.OrderProductListBean> orderProductMap = new Gson().fromJson(orderProduct, new TypeToken<Map<Integer, GoFormDownOrder.ResultBean.OrderProductListBean>>() {
        }.getType());

        for (Map.Entry<Integer, GoFormDownOrder.ResultBean.OrderProductListBean> product : orderProductMap.entrySet()) {
            if (product.getValue() != null) {
                list.add(product.getValue());
            }
        }
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
                masterNameList.add("请选择责任人");
                masterIdList.add("");
                final OfficeEmp officeEmp = gson.fromJson(result, OfficeEmp.class);
                for (int i = 0; i < officeEmp.getResult().size(); i++) {
                    masterNameList.add(officeEmp.getResult().get(i).getName());
                    masterIdList.add(officeEmp.getResult().get(i).getId());
                }
                spMaster.setAdapter(new ArrayAdapter<String>(GoOrderGroupDownOrder.this, R.layout.simple_spinner_item, R.id.tv_name, masterNameList));
                spMaster.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        master = masterNameList.get(position);
                        masterId = masterIdList.get(position);
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

    public void downOrder() {

        // http://localhost:8080/blanink-api/order/makeOrderGoCombination?
        // currentUser.id=d6c8e9bc4c2b476ba84b962c27882f41&
        // providerId=9ce7467e94884e7192a14ad3c29c554d&orderChecked=01dd57451aa446088b0fd696bbbdf138&
        // orderChecked=080532b81288442ab4a73f44485731a1&
        // aOrderNumber=1&delieverTime=2017-05-17&
        // aCompanyOrderOwnerUser.name=%E5%BC%A0%E4%B8%89&
        // aCompanyOrderOwnerUser.id=d6c8e9bc4c2b476ba84b962c27882f41&
        // remarks=1111

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/makeOrderGoCombination");
        rp.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("providerId", list.get(0).getBCompany().getId());
        for (int i = 0; i < list.size(); i++) {
            rp.addBodyParameter("orderChecked[" + i + "]", list.get(i).getId());
        }
        rp.addBodyParameter("delieverTime", deliverTime);
        rp.addBodyParameter("aOrderNumber", aNumber);
        rp.addBodyParameter("aCompanyOrderOwnerUser.name", master);
        rp.addBodyParameter("aCompanyOrderOwnerUser.id", masterId);
        rp.addBodyParameter("remarks", note);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                DialogLoadUtils.dismissDialog();
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if ("00000".equals(response.getErrorCode())) {
                    showNotifyTwo("组合下单成功", "继续组合下单", "查看已下单");
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();
                Toast.makeText(GoOrderGroupDownOrder.this, "服务异常", Toast.LENGTH_SHORT).show();

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

    //
    public void showNotifyTwo(String tilte, String btnLeft, String btnRight) {
        final AlertDialog alertDialog = new AlertDialog.Builder(GoOrderGroupDownOrder.this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_bid);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        WindowManager windowManager = getWindowManager();
        Display d = windowManager.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);
        alertDialog.setCanceledOnTouchOutside(false);
        ((TextView) (window.findViewById(R.id.tv_message))).setText(tilte);
        ((TextView) (window.findViewById(R.id.tv_continue))).setText(btnLeft);
        ((TextView) (window.findViewById(R.id.tv_seek))).setText(btnRight);
        window.findViewById(R.id.tv_continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoOrderGroupDownOrder.this, GoOrderPurchase.class);
                intent.putExtra("DIRECT", "1");
                startActivity(intent);
                alertDialog.dismiss();
            }
        });

        window.findViewById(R.id.tv_seek).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GoOrderGroupDownOrder.this, GoOrderPurchase.class);
                intent.putExtra("DIRECT", "2");
                startActivity(intent);
                alertDialog.dismiss();
            }
        });


    }

}
