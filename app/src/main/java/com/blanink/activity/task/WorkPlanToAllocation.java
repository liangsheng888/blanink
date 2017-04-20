package com.blanink.activity.task;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.*;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.NoScrollListview;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 任务分配 去分配
 */
public class WorkPlanToAllocation extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    @BindView(R.id.activity_work_plan_to_allocation)
    RelativeLayout activityWorkPlanToAllocation;
    @BindView(R.id.tv_companyName)
    TextView tvCompanyName;
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
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.priority)
    TextView priority;
    @BindView(R.id.tv_priority)
    TextView tvPriority;
    @BindView(R.id.response)
    TextView response;
    @BindView(R.id.tv_response)
    TextView tvResponse;
    @BindView(R.id.tv_my_task)
    TextView tvMyTask;
    @BindView(R.id.tv_my_task_num)
    TextView tvMyTaskNum;
    @BindView(R.id.deliveryTime)
    TextView deliveryTime;
    @BindView(R.id.tv_deliveryTime)
    TextView tvDeliveryTime;
    @BindView(R.id.note)
    TextView note;
    @BindView(R.id.tv_note)
    TextView tvNote;
    @BindView(R.id.task_response_rl_gongXuInfo)
    LinearLayout taskResponseRlGongXuInfo;
    @BindView(R.id.lv_task_response_info)
    NoScrollListview lvTaskResponseInfo;
    @BindView(R.id.task_response_et_finish_num)
    EditText taskResponseEtFinishNum;
    @BindView(R.id.task_response_ll2)
    LinearLayout taskResponseLl2;
    @BindView(R.id.et_finish_date)
    EditText etFinishDate;
    @BindView(R.id.task_response_ll3)
    LinearLayout taskResponseLl3;
    @BindView(R.id.task_response_rl_edt_content)
    EditText taskResponseRlEdtContent;
    @BindView(R.id.task_response_rl2)
    RelativeLayout taskResponseRl2;
    @BindView(R.id.btn_commit)
    Button btnCommit;
    @BindView(R.id.task_response_sp_person)
    Spinner taskResponseSpPerson;
    @BindView(R.id.task_response_ll)
    LinearLayout taskResponseLl;
    @BindView(R.id.note_num)
    TextView noteNum;
    @BindView(R.id.tv_note_num)
    TextView tvNoteNum;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.rl_history)
    RelativeLayout rlHistory;
    @BindView(R.id.lv_response_note)
    NoScrollListview lvResponseNote;
    @BindView(R.id.progressBar2)
    ProgressBar progressBar2;
    @BindView(R.id.rl_load)
    RelativeLayout rlLoad;
    @BindView(R.id.sp_priority)
    Spinner spPriority;
    @BindView(R.id.task_priority)
    LinearLayout taskPriority;
    @BindView(R.id.allocation)
    TextView allocation;
    @BindView(R.id.tv_allocation)
    TextView tvAllocation;
    private List<String> masterItem = new ArrayList<String>();
    private List<String> userIdList = new ArrayList<String>();
    private String processId;
    private String flowId;
    private SharedPreferences sp;
    private String feedbackUserId;
    private List<String> priorityValue = new ArrayList<>();
    private List<String> priorityName = new ArrayList<>();
    private String priority_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_plan_to_allocation);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        receiveData();
        initData();
    }

    private void receiveData() {
        Intent intent = getIntent();
        processId = intent.getStringExtra("processId");
        flowId = intent.getStringExtra("flowId");
    }

    private void initData() {
        loadData();
        //限定完成日期
        loadPriority();
        etFinishDate.setText(new SimpleDateFormat("yyyy-MM-dd").format((new Date(System.currentTimeMillis()))));
        etFinishDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dpd = new DatePickerDialog(WorkPlanToAllocation.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etFinishDate.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });
//保存分配
        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(taskResponseEtFinishNum.getText().toString())) {
                    Toast.makeText(WorkPlanToAllocation.this, "请填写完成数量", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(taskResponseRlEdtContent.getText().toString())) {
                    Toast.makeText(WorkPlanToAllocation.this, "请填写备注信息", Toast.LENGTH_SHORT).show();
                    return;
                }

                saveAllocation();
            }
        });
    }

    @OnClick(R.id.iv_last)
    public void onClick() {
        finish();
    }

    public void loadData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "workPlan/listPlanTaskPage");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("process.id", processId);
        rp.addBodyParameter("flow.id", flowId);
        Log.e("WorkPlanToAllocation", "userId:" + sp.getString("USER_ID", null) + ",processId:" + processId + ",flowId:" + flowId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                rlLoad.setVisibility(View.GONE);
                Log.e("WorkPlanToAllocation", result);
                Gson gson = new Gson();
                final com.blanink.pojo.WorkPlanToAllocation workPlan = gson.fromJson(result, com.blanink.pojo.WorkPlanToAllocation.class);
                Log.e("WorkPlanToAllocation", "WorkPlanToAllocation:" + workPlan.toString());
                tvCompanyName.setText(workPlan.getResult().getCompanyA().getName());
                tvTime.setText(workPlan.getResult().getOrder().getTakeOrderTime());
                tvProCategory.setText(workPlan.getResult().getCompanyCategory().getName());
                tvProName.setText(workPlan.getResult().getProductName());
                tvNum.setText(workPlan.getResult().getAmount());
                tvPriority.setText(workPlan.getResult().getRelFlowProcess().getProcessPriority());
                tvResponse.setText(workPlan.getResult().getRelFlowProcess().getTotalCompletedQuantity() + "");
                tvMyTaskNum.setText(workPlan.getResult().getRelFlowProcess().getTarget() + "");
                tvDeliveryTime.setText(workPlan.getResult().getDeliveryTime());
                tvNote.setText(workPlan.getResult().getProductDescription());
                if (workPlan.getResult().getProcessWorkerList() != null) {
                    for (int i = 0; i < workPlan.getResult().getProcessWorkerList().size(); i++) {
                        masterItem.add(workPlan.getResult().getProcessWorkerList().get(i).getName());
                        userIdList.add(workPlan.getResult().getProcessWorkerList().get(i).getId());
                    }
                    Log.e("WorkPlanToAllocation", "被分配者:" + masterItem.toString());
                    showSpinner(masterItem);
                }
                Log.e("WorkPlanToAllocation", "planedAmount:" + workPlan.getResult().getPlanedAmount());
                tvAllocation.setText(workPlan.getResult().getPlanedAmount() + "");
                tvNoteNum.setText("("+workPlan.getResult().getWorkPlanList().size()+")");
                //历史分配
                if(workPlan.getResult().getWorkPlanList().size()<2){
                    tvMore.setVisibility(View.GONE);
                }else {
                    //更多
                    tvMore.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(WorkPlanToAllocation.this,WorkPlanToAllocationHistory.class);
                            Bundle bundle=new Bundle();
                            bundle.putSerializable("workPlan",workPlan);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
                }
                //如果当前分配的任务等于总任务量 无法进行分配
                if(workPlan.getResult().getPlanedAmount()==workPlan.getResult().getRelFlowProcess().getTarget()){
                    btnCommit.setEnabled(false);
                    btnCommit.setBackgroundColor(getResources().getColor(R.color.colorBackGround));
                    btnCommit.setText("任务已经分配完了");
                }
                //分配记录
                lvResponseNote.setAdapter(new CommonAdapter<com.blanink.pojo.WorkPlanToAllocation.ResultBean.WorkPlanListBean>(WorkPlanToAllocation.this, workPlan.getResult().getWorkPlanList(), R.layout.item_work_plan_history_allocated, 2) {
                    @Override
                    public void convert(ViewHolder viewHolder, com.blanink.pojo.WorkPlanToAllocation.ResultBean.WorkPlanListBean workPlanBean, int position) {
                        workPlanBean = workPlan.getResult().getWorkPlanList().get(position);
                        TextView tv_allocation_time = viewHolder.getViewById(R.id.tv_allocation_time);
                        TextView tv_task_person = viewHolder.getViewById(R.id.tv_task_person);
                        TextView tv_allocation_num = viewHolder.getViewById(R.id.tv_allocation_num);
                        tv_allocation_time.setText(workPlanBean.getCreateDate());
                        tv_task_person.setText(workPlanBean.getWorker().getName());
                        tv_allocation_num.setText(workPlanBean.getAchieveAmount());
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

    //select master
    private void showSpinner(List<String> masterItem) {
        Log.e("TaskResponse", masterItem.toString());
        ArrayAdapter<String> _Adapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item
                , R.id.tv_name, masterItem);
        taskResponseSpPerson.setAdapter(_Adapter);
        //选择责任人
        taskResponseSpPerson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                feedbackUserId = userIdList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //保存分配
    public void saveAllocation() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "workPlan/saveWorkPlan");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("process.id", processId);
        rp.addBodyParameter("flow.id", flowId);
        rp.addBodyParameter("planTime", etFinishDate.getText().toString());
        rp.addBodyParameter("priority", priority_value);
        rp.addBodyParameter("worker.id", feedbackUserId);
        rp.addBodyParameter("remarks", taskResponseRlEdtContent.getText().toString());
        rp.addBodyParameter("achieveAmount", taskResponseEtFinishNum.getText().toString().trim());
        Log.e("WorkPlanToAllocation", "userId:" + sp.getString("USER_ID", null) + ",processId:" + processId + ",flowId:" + flowId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("WorkPlanToAllocation", result);
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if (response.getErrorCode().equals("00000")) {
                    showDialog();
                } else {
                    Toast.makeText(WorkPlanToAllocation.this, "反馈失败", Toast.LENGTH_SHORT).show();
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

    // 显示提示
    private void showDialog() {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setContentView(R.layout.dialog_custom_response);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        Display d = getWindowManager().getDefaultDisplay(); // 获取屏幕宽、高用
        //  lp.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);

        window.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                taskResponseEtFinishNum.setText("");
                taskResponseRlEdtContent.setText("");
                rlLoad.setVisibility(View.VISIBLE);
                masterItem.clear();
                userIdList.clear();
                loadData();
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
                Priority prioritys = gson.fromJson(result, Priority.class);
                for (int i = 0; i < prioritys.getResult().size(); i++) {
                    priorityValue.add(prioritys.getResult().get(i).getValue());
                    priorityName.add(prioritys.getResult().get(i).getLabel());
                }

                spPriority.setAdapter(new ArrayAdapter<String>(WorkPlanToAllocation.this, R.layout.simple_spinner_item
                        , R.id.tv_name, priorityName));

                spPriority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        priority_value = priorityValue.get(position);
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
