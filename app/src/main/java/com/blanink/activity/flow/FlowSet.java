package com.blanink.activity.flow;

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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.TypeCateGory;
import com.blanink.pojo.ProcessTarget;
import com.blanink.pojo.RelFlowProcess;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/****
 * 工序设置
 */
public class FlowSet extends AppCompatActivity {

    @BindView(R.id.tv_set)
    TextView tvSet;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.et_amount)
    EditText etAmount;
    @BindView(R.id.sp_priority)
    Spinner spPriority;
    @BindView(R.id.sp_isPublic)
    Spinner spIsPublic;
    @BindView(R.id.et_note)
    EditText etNote;
    private String flowId;
    private String processId;
    private String productId;
    private String processName;
    private List<String> stIsPublic=new ArrayList<>();
    private SharedPreferences sp;
    private List<String> priorityValue=new ArrayList<>();
    private List<String> priorityName=new ArrayList<>();
    private int priority;
    private int isPublic;
    private String relFlowProcess;
    RelFlowProcess relFlow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_set);
        ButterKnife.bind(this);
        sp=getSharedPreferences("DATA",MODE_PRIVATE);
        initData();
    }

    private void initData() {
        stIsPublic.add("是");
        stIsPublic.add("否");
        final Intent intent = getIntent();
        processId = intent.getStringExtra("processId");
        productId = intent.getStringExtra("orderProductId");
        processName = intent.getStringExtra("processName");
        relFlowProcess = intent.getStringExtra("relFlowProcess");
        relFlow= new Gson().fromJson(relFlowProcess,RelFlowProcess.class);
        if(relFlow!=null){
            etNote.setText(relFlow.getRemarks());
            etAmount.setTag(relFlow.getTarget());
        }
        tvSet.setText("工序设置(" + processName + ")");
        loadData();
        loadPriority();

        spIsPublic.setAdapter(new ArrayAdapter<String>(FlowSet.this, R.layout.simple_spinner_item
                , R.id.tv_name, stIsPublic));
        if(relFlow!=null){
           spIsPublic.setSelection(getSelectedPosition("0".equals(relFlow.getIsPublic())?"是":"否",stIsPublic));
        }
        spIsPublic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                isPublic = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    //保存
        btnSave.setOnClickListener(new View.OnClickListener() {

            private String remarks;
            private String target;

            @Override
            public void onClick(View v) {
                target = etAmount.getText().toString();
                remarks = etNote.getText().toString();
                if(TextUtils.isEmpty(target)){
                    Toast.makeText(FlowSet.this, "请填写完成数目", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(remarks)){
                    Toast.makeText(FlowSet.this, "请填写备注", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent1=new Intent();
                Bundle bundle=new Bundle();
                bundle.putSerializable("RelFlowProcess",new RelFlowProcess(processId,processName,"","",Integer.parseInt(target),priority+"",isPublic+"",remarks));
                intent1.putExtras(bundle);
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
    }

    public void loadData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "process/getProcessTarget");
        rp.addBodyParameter("process.id", processId);
        rp.addBodyParameter("orderProductId", productId);
        Log.e("FlowSet", NetUrlUtils.NET_URL + "process/getProcess?process.id=" + processId + "&orderProductId=" + productId);
        x.http().post(rp, new Callback.CacheCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.e("FlowSet", result);
                Gson gson = new Gson();
                ProcessTarget tagert = gson.fromJson(result, ProcessTarget.class);
                etAmount.setText(tagert.getResult()+"");//设置完成目标

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
    //优先级
    public void loadPriority() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "Dict/listValueByType");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("type", "sys_assign_priority");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("WorkPlanToAllocation", result);
                Gson gson = new Gson();
                TypeCateGory prioritys = gson.fromJson(result, TypeCateGory.class);
                for (int i = 0; i < prioritys.getResult().size(); i++) {
                    priorityValue.add(prioritys.getResult().get(i).getValue());
                    priorityName.add(prioritys.getResult().get(i).getLabel());
                }
                //内部优先级
                //甲方优先级
                spPriority.setAdapter(new ArrayAdapter<String>(FlowSet.this, R.layout.simple_spinner_item
                        , R.id.tv_name, priorityName));
                if(relFlow!=null){
                    spPriority.setSelection(getSelectedPosition(relFlow.getProcessPriority(),priorityValue));
                }
                spPriority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        priority = position+1;
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

    public int getSelectedPosition(String st,List<String> list) {
        int position = 0;
        for (int i = 0; i < list.size(); i++) {
            if (st.equals(list.get(i))) {
                position = i+1;
            }
        }
        return position;
    }
}
