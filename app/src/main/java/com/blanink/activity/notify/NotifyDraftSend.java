package com.blanink.activity.notify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.CompanyEmployee;
import com.blanink.pojo.CompanyInfo;
import com.blanink.pojo.DraftContent;
import com.blanink.pojo.Emp;
import com.blanink.pojo.Response;
import com.blanink.pojo.Role;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.NoScrollGridview;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 草稿通知发送
 */
public class NotifyDraftSend extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.customer_apply_iv_last)
    TextView customerApplyIvLast;
    @BindView(R.id.last_family_manage_customer_apply_rl)
    RelativeLayout lastFamilyManageCustomerApplyRl;
    @BindView(R.id.sp_company)
    Spinner spCompany;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.sp_role)
    Spinner spRole;
    @BindView(R.id.ll_role)
    LinearLayout llRole;
    @BindView(R.id.tv_emp)
    TextView tvEmp;
    @BindView(R.id.sp_person)
    Spinner spPerson;
    @BindView(R.id.tv_delete_notify)
    TextView tvDelete;
    @BindView(R.id.ll_name)
    RelativeLayout llName;
    @BindView(R.id.gv_emp_name)
    NoScrollGridview gvEmpName;
    @BindView(R.id.rl_name)
    RelativeLayout rlName;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.sp_type)
    Spinner spType;
    @BindView(R.id.rl_type)
    RelativeLayout rlType;
    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tv_draft)
    TextView tvDraft;
    @BindView(R.id.tv_send)
    TextView tvSend;
    @BindView(R.id.activity_notify_send)
    RelativeLayout activityNotifySend;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private String type;
    private String userIds;
    private String content;
    private String titles;

    private java.util.List<Role> roleList;//角色列表
    private List<Emp> List;//员工列表
    private CompanyInfo company;//公司
    private Role role;//角色
    private Emp emp;//职工
    private int companyIndex = 0;
    private String[] typeName = {"会议通知", "活动通告"};
    private String status = "1";//默认是通知,0是草稿
    private int roleIndex;
    List<Emp> empList = new ArrayList<Emp>();
    private String userId;
    private EmpAdapter empAdapter;
    private List<Integer> empCheckedList = new ArrayList<>();
    private List<Emp> empDeleteList=new ArrayList<>();
    List<CompanyInfo> companyInfoList;
    private String id;
    private boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_draft_send);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        DialogLoadUtils.getInstance(this);
        Intent intent= getIntent();
        id = intent.getStringExtra("notifyId");
        SendObject();
        initData();
    }

    private void initData() {

        //加载公司人员
        loadUser();
        //适配器
        ArrayAdapter arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, typeName);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spType.setAdapter(arr_adapter);
        spType.setSelection(compareType(type,typeName),true);//魔人选中
        spType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        type = "1";
                        break;
                    case 1:
                        type = "3";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //删除责任人
        tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = empCheckedList.size()-1; i >=0 ; i--) {
                    empList.remove(empDeleteList.get(i));
                }
                empCheckedList.clear();
                empDeleteList.clear();
                userIds="";
                for (int i=0;i<empList.size();i++){
                    userIds+=(","+empList.get(i).getEmpId());
                }
                empAdapter = new EmpAdapter(empList);
                gvEmpName.setAdapter(empAdapter);
            }
        });
        //发送
        tvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titles = etTitle.getText().toString().trim();
                content = etContent.getText().toString().trim();
                if (TextUtils.isEmpty(titles)) {
                    Toast.makeText(NotifyDraftSend.this, "请输入标题", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(content)) {
                    Toast.makeText(NotifyDraftSend.this, "请输入内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.showDialogLoad(NotifyDraftSend.this);
                SendNotify();
            }
        });
        //草稿
        tvDraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titles = etTitle.getText().toString().trim();
                content = etContent.getText().toString().trim();
                if (TextUtils.isEmpty(titles)) {
                    Toast.makeText(NotifyDraftSend.this, "请输入标题", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(content)) {
                    Toast.makeText(NotifyDraftSend.this, "请输入内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.showDialogLoad(NotifyDraftSend.this);
                status = "0";
                SendNotify();
            }

        });
        //人员点击选中事件
        gvEmpName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index=compareChecked(position,empCheckedList);
                if (index==-1) {
                    ((CheckBox)view.findViewById(R.id.cb_emp_name)).setChecked(true);
                    empCheckedList.add(position);
                    empDeleteList.add(empList.get(position));
                }else {
                    ((CheckBox)view.findViewById(R.id.cb_emp_name)).setChecked(false);
                    empCheckedList.remove(index);
                    empDeleteList.remove(empList.get(index));
                }

                if (empCheckedList.size() > 0) {
                    tvDelete.setVisibility(View.VISIBLE);
                }else {
                    tvDelete.setVisibility(View.GONE);
                }
            }
        });

    }

    @OnClick(R.id.customer_apply_iv_last)
    public void onClick() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //加载合作伙伴
    public void loadUser() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "notify/getRelateCompanyPersons");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                CompanyEmployee companyEmployee = gson.fromJson(result, CompanyEmployee.class);
                companyInfoList = change(companyEmployee.getResult());//公司列表
                Log.e("NotifySend", companyInfoList.toString());
                spCompany.setAdapter(new CompanyAdapter(companyInfoList));
                //公司选择
                spCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        companyIndex = position;
                        spRole.setAdapter(new RoleAdapter(companyInfoList.get(position).getRoleList()));//岗位
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                //员工角色选择
                spRole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        spPerson.setAdapter(new EmpNameAdapter(companyInfoList.get(companyIndex).getRoleList().get(position).getEmpList()));//员工
                        roleIndex = position;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                //员工选择
                spPerson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(isFirst){
                        userId = companyInfoList.get(companyIndex).getRoleList().get(roleIndex).getEmpList().get(position).getEmpId();
                        if (compareEmp(userId, empList) == -1) {
                            userIds = userIds + ("," + userId);
                            userIds = userIds.substring(1);
                            empList.add(companyInfoList.get(companyIndex).getRoleList().get(roleIndex).getEmpList().get(position));
                            empAdapter = new EmpAdapter(empList);
                            gvEmpName.setAdapter(empAdapter);
                        }}
                        isFirst=true;
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

    //发送
    public void SendNotify() {
        //http://localhost:8088/blanink-api/notify/sendSs?
        // userId=b17faaade8754e3eab1bcaba29cb52a8&u
        // serIds=d6c8e9bc4c2b476ba84b962c27882f41,cd7bcbfd6fc84f49a7ec908e93093432&
        // title=孙宏测试发给安徽公司的&content=你好，很高兴认识你2&type=2&status=1&id
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "notify/draftSend");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("userIds", userIds);
        rp.addBodyParameter("title", titles);
        rp.addBodyParameter("content", content);
        rp.addBodyParameter("type", type);
        rp.addBodyParameter("status", status);
        rp.addBodyParameter("id",id);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                DialogLoadUtils.dismissDialog();
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if (response.getErrorCode().equals("00000")) {
                    if (status.equals("1")) {
                        showNotify("通知发送成功");
                    } else {
                        showNotify("保存草稿成功");
                    }

                } else {
                    Toast.makeText(NotifyDraftSend.this, "发送失败", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(NotifyDraftSend.this, "服务器异常", Toast.LENGTH_SHORT).show();
                DialogLoadUtils.dismissDialog();
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

    //对源数据进行排版
    public List<CompanyInfo> change(List<CompanyEmployee.ResultBean> result) {
        List<CompanyInfo> ciList = new ArrayList<>();//公司列表
        for (int i = 0; i < result.size(); i++) {
            int index = compare(result.get(i).getOfficeId(), ciList);
            if (index == -1) {
                company = new CompanyInfo(result.get(i).getOfficeId(), result.get(i).getOfficeName());
                role = new Role(result.get(i).getRoleId(), result.get(i).getRoleName());
                emp = new Emp(result.get(i).getUserId(), result.get(i).getUserName());
                role.getEmpList().add(emp);
                company.getRoleList().add(role);
                ciList.add(company);
            } else {
                int index2 = compareRole(result.get(i).getRoleId(), ciList.get(index).getRoleList());
                if (index2 == -1) {
                    role = new Role(result.get(i).getRoleId(), result.get(i).getRoleName());
                    emp = new Emp(result.get(i).getUserId(), result.get(i).getUserName());
                    role.getEmpList().add(emp);
                    ciList.get(index).getRoleList().add(role);
                } else {
                    emp = new Emp(result.get(i).getUserId(), result.get(i).getUserName());
                    ciList.get(index).getRoleList().get(index2).getEmpList().add(emp);
                }
            }

        }
        return ciList;
    }

    //比较公司
    public static int compare(String id, List<CompanyInfo> companInfoList) {
        int index = -1;
        if (companInfoList != null) {

            for (int i = 0; i < companInfoList.size(); i++) {
                if (id.equals(companInfoList.get(i).getOfficeId())) {
                    index = i;
                }
            }
        }
        return index;
    }

    //比较角色
    public static int compareRole(String id, List<Role> RoleList) {
        int index = -1;
        if (RoleList != null) {
            for (int i = 0; i < RoleList.size(); i++) {
                if (id.equals(RoleList.get(i).getRoleId())) {
                    index = i;
                }
            }
        }
        return index;
    }

    //
    public static int compareEmp(String id, List<Emp> EmpList) {
        int index = -1;
        if (EmpList != null) {
            for (int i = 0; i < EmpList.size(); i++) {
                if (id.equals(EmpList.get(i).getEmpId())) {
                    index = i;
                }
            }
        }
        return index;
    }
    public  int compareChecked(int postition, List<Integer> integer) {
        int index = -1;
        if (integer.size()>0) {
            for (int i = 0; i < integer.size(); i++) {
                if (postition==integer.get(i)) {
                    index = i;
                }
            }
        }
        return index;
    }
    public  int compareType(String type, String[] types) {
        int index = -1;
        if (types.length>0) {
            for (int i = 0; i < types.length; i++) {
                if (types[i].equals(types)) {
                    index = i;
                }
            }
        }
        return index;
    }
    //公司适配
    public class CompanyAdapter extends BaseAdapter {
        List<CompanyInfo> companyInfoList;
        public CompanyAdapter(List<CompanyInfo> companyInfoList) {
            this.companyInfoList = companyInfoList;
        }

        @Override
        public int getCount() {
            return companyInfoList.size();
        }

        @Override
        public Object getItem(int position) {
            return companyInfoList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(NotifyDraftSend.this, R.layout.simple_spinner_item, null);
            TextView textView = (TextView) view.findViewById(R.id.tv_name);
            textView.setText(companyInfoList.get(position).getOfficeName());
            return view;
        }
    }

    //公司适配
    public class RoleAdapter extends BaseAdapter {
        List<Role> roleList;

        public RoleAdapter(List<Role> roleList) {
            this.roleList = roleList;
        }

        @Override
        public int getCount() {
            return roleList.size();
        }

        @Override
        public Object getItem(int position) {
            return roleList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(NotifyDraftSend.this, R.layout.simple_spinner_item, null);
            TextView textView = (TextView) view.findViewById(R.id.tv_name);
            textView.setText(roleList.get(position).getRoleName());
            return view;
        }
    }

    public class EmpNameAdapter extends BaseAdapter {
        List<Emp> EmpList;

        public EmpNameAdapter(List<Emp> EmpList) {
            this.EmpList = EmpList;
        }

        @Override
        public int getCount() {
            return EmpList.size();
        }

        @Override
        public Object getItem(int position) {
            return EmpList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(NotifyDraftSend.this, R.layout.simple_spinner_item, null);
            TextView textView = (TextView) view.findViewById(R.id.tv_name);
            textView.setText(EmpList.get(position).getEmpName());
            return view;
        }
    }

    public class EmpAdapter extends BaseAdapter {
        List<Emp> EmpList;

        public EmpAdapter(List<Emp> EmpList) {
            this.EmpList = EmpList;
        }

        @Override
        public int getCount() {
            return EmpList.size();
        }

        @Override
        public Object getItem(int position) {
            return EmpList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(NotifyDraftSend.this, R.layout.item_emp_name, null);
            TextView textView = (TextView) view.findViewById(R.id.tv_name);

            CheckBox cb = (CheckBox) view.findViewById(R.id.cb_emp_name);
            for (int i=0;i<empCheckedList.size();i++){
                if(empCheckedList.get(i)==position){
                    cb.setChecked(true);
                }
            }
            textView.setText(EmpList.get(position).getEmpName());

            return view;
        }
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
        ((TextView) (window.findViewById(R.id.tv_message))).setText(tilte);
        window.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                finish();
            }
        });
    }
    //send obj
    public void SendObject() {
        //http://localhost:8080/blanink-api/notify/notifyEdit?userId=b17faaade8754e3eab1bcaba29cb52a8&id=6e4f450822be4097aaf9b1062693c6c3

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "notify/notifyEdit");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("id",id);
        x.http().post(rp, new Callback.CacheCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                DraftContent draftContent=gson.fromJson(result, DraftContent.class);
                userIds=draftContent.getResult().getOaNotifyRecordIds();
                type = draftContent.getResult().getType();
                String[] names=draftContent.getResult().getOaNotifyRecordNames().split(",");
                String[] empIds=userIds.split(",");
                etTitle.setText(draftContent.getResult().getTitle());
                etContent.setText(draftContent.getResult().getContent());
                Emp emp=null;
                for (int i=0;i<names.length;i++){
                    emp= new Emp();
                    emp.setEmpId(empIds[i]);
                    emp.setEmpName(names[i]);
                    empList.add(emp);
                }
                empAdapter=new EmpAdapter(empList);
                gvEmpName.setAdapter(empAdapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(NotifyDraftSend.this, "服务器异常", Toast.LENGTH_SHORT).show();

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
