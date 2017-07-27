package com.blanink.activity.order;

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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.activity.remark.RemarkComeOder;
import com.blanink.pojo.OfficeEmp;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.NoScrollGridview;
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
 * 去收货
 */
public class ReceiveGoodsToReceive extends AppCompatActivity {
    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.deliver)
    RelativeLayout deliver;
    @BindView(R.id.tv_master)
    TextView tvMaster;
    @BindView(R.id.tv_order_time)
    TextView tvOrderTime;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.order_item_ll)
    RelativeLayout orderItemLl;
    @BindView(R.id.tv_pro_category)
    TextView tvProCategory;
    @BindView(R.id.order_item_ll2)
    RelativeLayout orderItemLl2;
    @BindView(R.id.order_item_ll2_guigeName)
    TextView orderItemLl2GuigeName;
    @BindView(R.id.tv_pro_name)
    TextView tvProName;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.response)
    TextView response;
    @BindView(R.id.tv_response)
    TextView tvResponse;
    @BindView(R.id.note)
    TextView note;
    @BindView(R.id.tv_note)
    TextView tvNote;
    @BindView(R.id.task_response_rl_gongXuInfo)
    LinearLayout taskResponseRlGongXuInfo;
    @BindView(R.id.sp_receiver)
    Spinner spReceiver;
    @BindView(R.id.gv_receiver)
    NoScrollGridview gvReceiver;
    @BindView(R.id.et_note)
    EditText etNote;
    @BindView(R.id.ll_info)
    LinearLayout llInfo;
    @BindView(R.id.btn_send)
    Button btnSend;
    private SharedPreferences sp;
    private List<String> masterNameList = new ArrayList<>();
    private List<String> masterIdList = new ArrayList<>();
    private String masterId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_goods_to_receive);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        tvProName.setText(getIntent().getStringExtra("productName"));
        tvProCategory.setText(getIntent().getStringExtra("companyCateGory"));
        tvMaster.setText(getIntent().getStringExtra("senderName"));
        tvResponse.setText(getIntent().getIntExtra("achieveAmount",0)+"");
        tvTime.setText(getIntent().getStringExtra("sendTime"));
        tvNote.setText(getIntent().getStringExtra("remarks"));
        getCompanyEmp();
        //收货
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comments = etNote.getText().toString();
                if (TextUtils.isEmpty(masterId)) {
                    Toast.makeText(ReceiveGoodsToReceive.this, "请选择接收通知的员工", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(comments)) {
                    Toast.makeText(ReceiveGoodsToReceive.this, "请填写备注信息", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.getInstance(ReceiveGoodsToReceive.this);
                DialogLoadUtils.showDialogLoad("操作进行中...");

                receiveGoods(comments, v);
            }
        });
        //返回
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void receiveGoods(String comments, final View v) {
        String url = NetUrlUtils.NET_URL + "order/orderProductHarvest";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("orderProdId", getIntent().getStringExtra("orderProductId"))
                .add("currentUser.id", sp.getString("USER_ID", null))
                .add("comments", comments)
                .add("sendUser", masterId)
                .add("id",getIntent().getStringExtra("processFeedBackId"))
                .add("process.id",getIntent().getStringExtra("processId"))
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                final com.blanink.pojo.Response rp = gson.fromJson(json, com.blanink.pojo.Response.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if ("00000".equals(rp.getErrorCode())) {
                            Toast.makeText(ReceiveGoodsToReceive.this, "收货成功", Toast.LENGTH_SHORT).show();
                            DialogLoadUtils.dismissDialog();
                            ((Button) v).setEnabled(false);
                            ((Button) v).setBackgroundColor(getResources().getColor(R.color.colorBackGround));
                            ((Button) v).setText("收货成功");
                            //去评价
                            showNotify("去评价");
                            finish();

                        } else {
                            DialogLoadUtils.dismissDialog();
                        }
                    }
                });
            }
        });
    }

    private void getCompanyEmp() {
        String url = NetUrlUtils.NET_URL + "order/userList";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("id", getIntent().getStringExtra("companyId"))
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                final OfficeEmp officeEmp = gson.fromJson(json, OfficeEmp.class);
                masterNameList.add("请选择");
                masterIdList.add("");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < officeEmp.getResult().size(); i++) {
                            masterNameList.add(officeEmp.getResult().get(i).getName());
                            masterIdList.add(officeEmp.getResult().get(i).getId());
                        }
                        Log.e("ComeOrder", masterNameList.toString());
                        spReceiver.setAdapter(new ArrayAdapter<String>(ReceiveGoodsToReceive.this, R.layout.spanner_item, masterNameList));
                        spReceiver.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                masterId = masterIdList.get(position);
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
    public void showNotify(String tilte) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_apply_delete_relation);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        WindowManager windowManager = getWindowManager();
        Display d = windowManager.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);
        alertDialog.setCanceledOnTouchOutside(false);
        ((TextView)(window.findViewById(R.id.tv_message))).setText(tilte);
        window.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ReceiveGoodsToReceive.this, RemarkComeOder.class);
                intent.putExtra("price", getIntent().getStringExtra("price"));
                intent.putExtra("amount", getIntent().getStringExtra("amount"));
                intent.putExtra("deliverTime",getIntent().getStringExtra("deliverTime"));
                intent.putExtra("companyCateGory", getIntent().getStringExtra("companyCateGory"));
                intent.putExtra("productName", getIntent().getStringExtra("productName"));
                intent.putExtra("orderId", getIntent().getStringExtra("orderId"));
                intent.putExtra("orderProductId", getIntent().getStringExtra("orderProductId"));
                intent.putExtra("productRemarks",getIntent().getStringExtra("productRemarks"));
                startActivity(intent);
                alertDialog.dismiss();
                finish();
            }
        });
    }

}
