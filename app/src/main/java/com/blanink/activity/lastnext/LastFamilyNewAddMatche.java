package com.blanink.activity.lastnext;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.Office;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/15.
 * 添加你的客户前，输入你想要新建的客户，如果在当前列表，就不用新建，不在再新建客户
 */
public class LastFamilyNewAddMatche extends Activity {

    private static final String TAG = "LastFamilyNewAddMatche";
    @BindView(R.id.iv_customer_matches_last)
    TextView ivCustomerMatchesLast;
    @BindView(R.id.rl_customer_manage)
    RelativeLayout rlCustomerManage;
    @BindView(R.id.come_order_tv)
    TextView comeOrderTv;
    @BindView(R.id.et_seek_content)
    EditText etSeekContent;
    @BindView(R.id.tv_seek)
    TextView tvSeek;
    @BindView(R.id.rl_seek)
    RelativeLayout rlSeek;
    @BindView(R.id.lv_matches)
    ListView lvMatches;
    @BindView(R.id.ll_load)
    LinearLayout llLoad;
    @BindView(R.id.loading_error_img)
    ImageView loadingErrorImg;
    @BindView(R.id.rl_load_fail)
    RelativeLayout rlLoadFail;
    @BindView(R.id.tv_not)
    TextView tvNot;
    @BindView(R.id.rl_not_data)
    RelativeLayout rlNotData;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.btn_not_customer_queue)
    Button btnNotCustomerQueue;
    private MyActivityManager myActivityManager;
    private TextView iv_customer_matches_last;
    private TextView tv_seek;
    private EditText et_seek_content;
    private ListView lv_matches;
    private SharedPreferences sp;
    private List<Office.ResultBean> company=new ArrayList<>();
    private MyAdapter myAdapter;
    private Button btn_not_customer_queue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_family_new_add_cusomter_matche);
        ButterKnife.bind(this);
        myActivityManager = MyActivityManager.getInstance();
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager.pushOneActivity(this);
        initView();
        initData();
    }

    private void initView() {
        iv_customer_matches_last = ((TextView) findViewById(R.id.iv_customer_matches_last));
        tv_seek = ((TextView) findViewById(R.id.tv_seek));
        et_seek_content = ((EditText) findViewById(R.id.et_seek_content));//搜索内容
        lv_matches = ((ListView) findViewById(R.id.lv_matches));
        btn_not_customer_queue = ((Button) findViewById(R.id.btn_not_customer_queue));
    }

    private void initData() {
        //重新加载
        rlLoadFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlLoadFail.setVisibility(View.GONE);
                llLoad.setVisibility(View.VISIBLE);
                getData();
            }
        });
        //
        et_seek_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                company.clear();
                btn_not_customer_queue.setVisibility(View.GONE);
                if (myAdapter != null)
                    myAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //返回
        iv_customer_matches_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //搜索
        tv_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String et_seekContent = et_seek_content.getText().toString();
                if (TextUtils.isEmpty(et_seekContent)) {
                    Toast.makeText(LastFamilyNewAddMatche.this, "请输入你要添加的客户名称！！！", Toast.LENGTH_SHORT).show();
                    return;
                }
                llLoad.setVisibility(View.VISIBLE);
                getData();

            }
        });
        //
        et_seek_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //getData();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // getData();
            }
        });
        //去添加客户
        btn_not_customer_queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LastFamilyNewAddMatche.this, LastFamilyManageNewAddCustomer.class);
                startActivity(intent);
            }
        });
        //进到客户详情页
        lv_matches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LastFamilyNewAddMatche.this, LastCustomerDetail.class);
                String companyId = company.get(position).getId();
                intent.putExtra("companyId", companyId);
                intent.putExtra("companyA.id", company.get(position).getId());
                intent.putExtra("companyName", company.get(position).getName());
                intent.putExtra("companyType", company.get(position).getServiceType());
                intent.putExtra("type",company.get(position).getPType());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    //访问服务器
    public void getData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "customer/findNameA");
        rp.addBodyParameter("name", et_seek_content.getText().toString());
        rp.addBodyParameter("currentUser.id",sp.getString("USER_ID",null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, result);
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                Office customer = gson.fromJson(result, Office.class);
                if (customer.getResult().size() > 0) {
                    btn_not_customer_queue.setVisibility(View.VISIBLE);
                } else {
                    btn_not_customer_queue.setVisibility(View.GONE);
                    final AlertDialog alertDialog = new AlertDialog.Builder(LastFamilyNewAddMatche.this).create();
                    alertDialog.setTitle("提示");
                    alertDialog.setMessage("该客户不存在！！！");
                    alertDialog.setIcon(R.mipmap.notify);
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "去创建新客户", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent intent = new Intent(LastFamilyNewAddMatche.this, LastFamilyManageNewAddCustomer.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }
                Log.e(TAG, "解析前" + customer.getResult().toString());
                company = new ArrayList<>();
                company.clear();
                company.addAll(customer.getResult());
                Log.e(TAG, "解析后" + company.toString());
                if (myAdapter == null) {
                    myAdapter = new MyAdapter();
                }
                lv_matches.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                llLoad.setVisibility(View.GONE);
                rlLoadFail.setVisibility(View.VISIBLE);
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

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return company.size();
        }

        @Override
        public Object getItem(int position) {
            return company.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            if (convertView == null) {
                view = View.inflate(LastFamilyNewAddMatche.this, R.layout.item_customer_matches, null);

            } else {
                view = convertView;
            }
            TextView tv_company = (TextView) view.findViewById(R.id.tv_company);
            TextView tv_company_address = (TextView) view.findViewById(R.id.tv_company_address);
            TextView tv_major = (TextView) view.findViewById(R.id.tv_major);
            Office.ResultBean customer = company.get(position);
            tv_company.setText(customer.getName());
            tv_company_address.setText(customer.getAddress());
            tv_major.setText(customer.getScope());

            return view;
        }
    }
}
