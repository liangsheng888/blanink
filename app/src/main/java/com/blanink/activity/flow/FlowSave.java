package com.blanink.activity.flow;

import android.app.DatePickerDialog;
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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.FlowDetail;
import com.blanink.pojo.RelFlowProcess;
import com.blanink.pojo.Response;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 流程保存
 */
public class FlowSave extends AppCompatActivity {

    @BindView(R.id.tv_last)
    TextView tvLast;
    @BindView(R.id.customer_delete_relation_tv_seek)
    TextView customerDeleteRelationTvSeek;
    @BindView(R.id.tv_select_user)
    TextView tvSelectUser;
    @BindView(R.id.et_flow_name)
    EditText etFlowName;
    @BindView(R.id.ll_name)
    LinearLayout llName;
    @BindView(R.id.deliveryTime)
    TextView deliveryTime;
    @BindView(R.id.tv_deliveryTime)
    TextView tvDeliveryTime;
    @BindView(R.id.rl_deliveryTime)
    RelativeLayout rlDeliveryTime;
    @BindView(R.id.et_note_info)
    EditText etNoteInfo;
    @BindView(R.id.btn_send)
    Button btnSend;
    private String productId;
    Map<String, RelFlowProcess> os;
    Map<String, String> mapStr=new HashMap<>();
    private SharedPreferences sp;
    private String remarks, internalDeliveryDate, flowName;
    private String flowData;
    private String relations;
    String relFlowProcessMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_flow_save);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        productId = getIntent().getStringExtra("orderProductId");
        relFlowProcessMap = getIntent().getStringExtra("relFlowProcessMap");
        final Calendar calendar = Calendar.getInstance();

        tvDeliveryTime.setText(calendar.get(calendar.YEAR) + "-" + (calendar.get(calendar.MONTH) + 1) + "-" + calendar.get(calendar.DAY_OF_MONTH));
        tvDeliveryTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dpd = new DatePickerDialog(FlowSave.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDeliveryTime.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                        internalDeliveryDate = tvDeliveryTime.getText().toString().trim();
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });

        os = new Gson().fromJson(relFlowProcessMap, new TypeToken<Map<String, RelFlowProcess>>() {
        }.getType());
        for (Map.Entry<String, RelFlowProcess> set: os.entrySet()){
            mapStr.put(set.getKey(),new Gson().toJson(set.getValue()));
        }
        //返回
        tvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //保存
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowName = etFlowName.getText().toString();
                remarks = etNoteInfo.getText().toString();
                internalDeliveryDate =tvDeliveryTime.getText().toString();
                if (TextUtils.isEmpty(flowName)){
                    Toast.makeText(FlowSave.this, "请填写流程名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(remarks)){
                    Toast.makeText(FlowSave.this, "请填写备注", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.getInstance(FlowSave.this);
                DialogLoadUtils.showDialogLoad("保存中...");
                checkIsHasFlow();


            }
        });
    }
private void checkIsHasFlow() {
    RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "flow/getFlow");
    rp.addBodyParameter("orderProduct.id", productId);
    x.http().post(rp, new Callback.CacheCallback<String>() {
        @Override
        public void onSuccess(String result) {
            Gson gson = new Gson();
            FlowDetail flowDetail = gson.fromJson(result, FlowDetail.class);
            if(flowDetail.getResult()==null){
                uploadProcessData("Y","");
            }else {
                uploadProcessData("N",flowDetail.getResult().getId());

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


    private void uploadProcessData(String tempId, String flowId ) {
        //http://localhost:8080/blanink-api/flow/saveFlow?currentUser.id=fec25c7f7634448581e21876ef517c57&orderProduct.id=ssss
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "flow/saveFlow");
        rp.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("company.id", sp.getString("COMPANY_ID", null));
        rp.addBodyParameter("orderProduct.id", productId);
        rp.addBodyParameter("name", flowName);
        rp.addBodyParameter("internalDeliveryDate", internalDeliveryDate);
        rp.addBodyParameter("remarks", remarks);
        rp.addBodyParameter("tempId",tempId);
        rp.addBodyParameter("id",flowId);
        rp.addBodyParameter("relations", new Gson().toJson(mapStr).replace("processId","process.id").replace("flowId","flow.id").replace("processName","process.name"));
        rp.addBodyParameter("flowData",getIntent().getStringExtra("flowData"));
        Log.e("FlowSave", new Gson().toJson(os).replace("processId","process.id").replace("flowId","flow.id").replace("processName","process.name"));
      /*  int i = 0;
        for (Map.Entry<String, RelFlowProcess> map : os.entrySet()) {
            rp.addBodyParameter("processList[" + i + "].target", os.get(map.getKey()).getTarget() + "");
            rp.addBodyParameter("processList[" + i + "].remarks", os.get(map.getKey()).getRemarks());
            rp.addBodyParameter("processList[" + i + "].processPriority", os.get(map.getKey()).getProcessPriority());
            rp.addBodyParameter("processList[" + i + "].isPublic", os.get(map.getKey()).getIsPublic());
            rp.addBodyParameter("processList[" + i + "].process.id",os.get(map.getKey()).getProcessId());
            i++;
        }*/
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if ("00000".equals(response.getErrorCode())) {
                    Toast.makeText(FlowSave.this, "保存成功", Toast.LENGTH_SHORT).show();
                    showDialogExit();
                    DialogLoadUtils.dismissDialog();
                } else {
                    DialogLoadUtils.dismissDialog();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();
                Toast.makeText(FlowSave.this, "服务器开了会儿小差，请稍后再试！", Toast.LENGTH_SHORT).show();
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
    private void showDialogExit() {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_exit);
        final Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);

        ((TextView) window.findViewById(R.id.tv_content)).setText("流程和产品已绑定！");
        ((TextView) window.findViewById(R.id.tv_continue)).setText("返回");
        ((TextView) window.findViewById(R.id.tv_exit)).setText("查看已排流程");

        window.findViewById(R.id.tv_continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FlowSave.this,FlowOrder.class);
                startActivity(intent);
                alertDialog.dismiss();
                finish();

            }
        });
        window.findViewById(R.id.tv_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FlowSave.this,FlowSortCompleted.class);
                startActivity(intent);
                alertDialog.dismiss();
                finish();
            }
        });
    }


}
