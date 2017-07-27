package com.blanink.activity.lastnext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.ManyCustomer;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 我的客户搜索
 */
public class LastMyCustomerSeek extends AppCompatActivity {
    private static final String TAG = "LastMyCustomerSeek";
    @BindView(R.id.iv_last)
    TextView ivLast;
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
    @BindView(R.id.activity_last_my_customer_seek)
    RelativeLayout activityLastMyCustomerSeek;
    private TextView iv_last;
    private MyActivityManager myActivityManager;
    private TextView tv_seek;
    private ListView lv_supplier;
    private List<ManyCustomer.Result.Customer> customers = new ArrayList<>();
    private MyAdapter adapter;
    private SharedPreferences sp;
    private EditText et_seek_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_my_customer_seek);
        ButterKnife.bind(this);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initView();
        initData();
    }

    private void initView() {
        iv_last = ((TextView) findViewById(R.id.iv_last));
        tv_seek = ((TextView) findViewById(R.id.tv_seek));//seek
        lv_supplier = ((ListView) findViewById(R.id.lv_matches));
        et_seek_content = ((EditText) findViewById(R.id.et_seek_content));
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
                customers.clear();
                if (adapter != null)
                    adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //返回
        iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //搜索
        tv_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(et_seek_content.getText().toString())) {
                    Toast.makeText(LastMyCustomerSeek.this, "请输入内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                llLoad.setVisibility(View.VISIBLE);
                getData();
            }
        });
        //跳转到客户详情页
        lv_supplier.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LastMyCustomerSeek.this, LastCustomerDetail.class);
                String companyId = customers.get(position).getId();
                intent.putExtra("companyId", companyId);
                intent.putExtra("companyA.id", customers.get(position).getCompanyA().getId());
                intent.putExtra("companyName", customers.get(position).getCompanyA().getName());
                intent.putExtra("companyType", customers.get(position).getCompanyA().serviceType);
                intent.putExtra("type",customers.get(position).getType());
                startActivity(intent);

            }
        });

    }

    private void getData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "customer/list");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("companyA.name", et_seek_content.getText().toString());
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Log.e(TAG, "解析前" + result);
                Gson gson = new Gson();
                ManyCustomer company = gson.fromJson(result, ManyCustomer.class);
                Log.e(TAG, "解析后" + company.toString());
                if (company.getResult().getRows().size() == 0) {
                    rlNotData.setVisibility(View.VISIBLE);
                }
                customers.addAll(company.getResult().getRows());
                if (adapter == null) {
                    adapter = new MyAdapter();
                    lv_supplier.setAdapter(adapter);
                } else {
                    adapter.notifyDataSetChanged();
                }
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
            return customers.size();
        }

        @Override
        public Object getItem(int position) {
            return customers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(LastMyCustomerSeek.this, R.layout.item_customer_queue, null);
                viewHolder.tv_company_jc = (TextView) convertView.findViewById(R.id.tv_name);
                viewHolder.tv_scope = (TextView) convertView.findViewById(R.id.tv_scope);
                viewHolder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);
                viewHolder.tv_state.setTag(position);
                viewHolder.tv_master = (TextView) convertView.findViewById(R.id.tv_master);
                viewHolder.tv_phone = (TextView) convertView.findViewById(R.id.tv_phone);
                viewHolder.tv_honest = (TextView) convertView.findViewById(R.id.tv_honest);
                viewHolder.tv_company_apply_remark = (TextView) convertView.findViewById(R.id.tv_company_apply_remark);
                viewHolder.tv_company_apply_remark_other = (TextView) convertView.findViewById(R.id.tv_company_apply_other_remark);
                viewHolder.tv_apply_address = (TextView) convertView.findViewById(R.id.tv_apply_address);
                viewHolder.iv=(ImageView)convertView.findViewById(R.id.iv);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            ManyCustomer.Result.Customer customer = customers.get(position);
            Log.e("LastA", " getView 上家管理 customer:" + customer.getCompanyA().toString());
            viewHolder.tv_company_jc.setText(customer.getCompanyA().getName());
            viewHolder.tv_master.setText(customer.getCompanyA().getMaster());
            viewHolder.tv_scope.setText(customer.getCompanyA().getScope());
            viewHolder.tv_apply_address.setText(customer.getCompanyA().getAddress());
            viewHolder.tv_master.setText(customer.getCompanyA().getMaster());
            viewHolder.tv_phone.setText(customer.getCompanyA().getPhone());
            viewHolder.tv_state.setText(customer.getCompanyA().getCreateCompanyBy() == null ? "实有" : "虚拟");
            Log.e("LastA", "position:" + position + "Tag position" + viewHolder.tv_state.getTag());
            if (customer.getCompanyA().getCreateCompanyBy() != null) {
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorBlue));
            }

            DecimalFormat df = new DecimalFormat("0.0");
            viewHolder.tv_honest.setText(df.format((customers.get(position).companyA.reviewOthers + customers.get(position).companyA.reviewOthers) / 2.0));
            viewHolder.tv_company_apply_remark.setText(customers.get(position).companyA.reviewOthers + "");
            viewHolder.tv_company_apply_remark_other.setText(customers.get(position).companyA.reviewOthers + "");
            GlideUtils.glideImageView(LastMyCustomerSeek.this,viewHolder.iv,customers.get(position).getCompanyA().photo,true);

            return convertView;
        }
    }

    public static class ViewHolder {
        public TextView tv_company_jc;//公司简称
        public TextView tv_state;//实有 虚拟
        public TextView tv_apply_address;//地址
        public TextView tv_master;//负责人
        public TextView tv_phone;//电话
        public TextView tv_honest;//公司信誉
        public TextView tv_company_apply_remark;//自评
        public TextView tv_company_apply_remark_other;//他评
        public TextView tv_scope;
        ImageView iv;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
