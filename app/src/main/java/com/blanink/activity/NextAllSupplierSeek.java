package com.blanink.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.blanink.R;
import com.blanink.bean.ManyCustomer;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 * 全部供应商搜索
 */
public class NextAllSupplierSeek extends Activity {
    private static final String TAG = "NextFamilyAccordCompany";
    private ImageView iv_accord_supplier_last;
    private MyActivityManager myActivityManager;
    private TextView tv_seek;
    private SwipeMenuListView lv_supplier;
    private List<ManyCustomer.Result.Customer> customer;
    private MyAdapter adapter;
    private SharedPreferences sp;
    private EditText et_supplier;
    int currentPosition=0;
    private SwipeMenuCreator  creator = new SwipeMenuCreator() {
        @Override
        public void create(SwipeMenu menu) {
            // 设置加入潜在框
            SwipeMenuItem deleteitem = new SwipeMenuItem(getApplicationContext());
            deleteitem.setBackground(new ColorDrawable(Color.RED));
            deleteitem.setWidth(dp2px(150));
            if ("1".equals(customer.get(currentPosition).getType())) {
                deleteitem.setTitle("解除关系");
                deleteitem.setTitleSize(18);
                deleteitem.setTitleColor(Color.WHITE);
                menu.addMenuItem(deleteitem);
            } else {
                deleteitem.setTitle("申请合作");
                deleteitem.setTitleSize(18);
                deleteitem.setTitleColor(Color.WHITE);
                menu.addMenuItem(deleteitem);

                SwipeMenuItem addItem = new SwipeMenuItem(
                        NextAllSupplierSeek.this);
                // set item background
                addItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                addItem.setWidth(dp2px(150));
                // set a icon
                addItem.setIcon(R.mipmap.qz);
                // add to menu
                menu.addMenuItem(addItem);
            }



        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_supplier_seek);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initView();
        initData();
    }

    private void initView() {
        iv_accord_supplier_last = ((ImageView) findViewById(R.id.iv_customer_matches_last));
        tv_seek = ((TextView) findViewById(R.id.tv_seek));//seek
        lv_supplier = ((SwipeMenuListView) findViewById(R.id.lv_matches));
        et_supplier = ((EditText) findViewById(R.id.et_seek_content));
    }

    private void initData() {
        //返回
        iv_accord_supplier_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //搜索
        tv_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(et_supplier.getText().toString())) {
                    Toast.makeText(NextAllSupplierSeek.this, "请输入内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                getData();
            }
        });

        lv_supplier.setMenuCreator(creator);
        lv_supplier.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(final int position, SwipeMenu menu, int index) {
                if("1".equals(customer.get(position).getType())){
                    Intent intent=new Intent(NextAllSupplierSeek.this,NextFamilyManageSupplierManageApplyDelete.class);
                    intent.putExtra("companyId",customer.get(position).getId());
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(NextAllSupplierSeek.this,NextFamilyManageSupplierManageApplyCooperate.class);
                    intent.putExtra("companyId",customer.get(position).getId());
                    startActivity(intent);
                }
                return false;
            }
        });
        //跳转到详情
        lv_supplier.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String companyId = customer.get(position).getId();
                Intent intent = new Intent(NextAllSupplierSeek.this, NextFamilyManageCompanyDetail.class);
                intent.putExtra("id", companyId);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "partner/list");
        // rp.addBodyParameter("userId",sp.getString("USER_ID",null));
        rp.addBodyParameter("companyB.name", et_supplier.getText().toString());
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "解析前" + result);
                Gson gson = new Gson();
                ManyCustomer company = gson.fromJson(result, ManyCustomer.class);
                Log.e(TAG, "解析后" + company.toString());
                if (company.getResult().getRows().size() == 0) {
                    Toast.makeText(NextAllSupplierSeek.this, "没有找到该供应商！！！", Toast.LENGTH_SHORT).show();
                }
                customer = new ArrayList<ManyCustomer.Result.Customer>();
                customer.addAll(company.getResult().getRows());
                if (adapter == null) {
                    adapter = new MyAdapter();
                    lv_supplier.setAdapter(adapter);
                } else {
                    adapter.notifyDataSetChanged();
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

    public class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return customer.size();
        }

        @Override
        public Object getItem(int position) {
            return customer.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            currentPosition=position;
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(NextAllSupplierSeek.this, R.layout.item_supplier_manage, null);
                viewHolder.tv_customer_num = (TextView) convertView.findViewById(R.id.tv_customer_num);
                viewHolder.tv_supplier_company_name = (TextView) convertView.findViewById(R.id.tv_supplier_company_name);
                viewHolder.tv_apply_address = (TextView) convertView.findViewById(R.id.tv_apply_address);
                viewHolder.tv_master = (TextView) convertView.findViewById(R.id.tv_master);
                viewHolder.tv_phone = (TextView) convertView.findViewById(R.id.tv_phone);
                viewHolder.tv_honest = (TextView) convertView.findViewById(R.id.tv_honest);
                viewHolder.tv_major = (TextView) convertView.findViewById(R.id.tv_major);
                viewHolder.tv_company_apply_remark = (TextView) convertView.findViewById(R.id.tv_company_apply_remark);
                viewHolder.tv_company_apply_remark_other = (TextView) convertView.findViewById(R.id.tv_company_apply_other_remark);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            ManyCustomer.Result.CompanyB companyB = customer.get(position).getCompanyB();
            Log.e(TAG, "companyB:" + companyB.toString());
            viewHolder.tv_customer_num.setText(companyB.getSort() + "");//
            viewHolder.tv_supplier_company_name.setText(companyB.getName());
            viewHolder.tv_apply_address.setText(companyB.getAddress());
            viewHolder.tv_phone.setText(companyB.getPhone());
            viewHolder.tv_master.setText(companyB.getMaster());
            DecimalFormat df=new DecimalFormat("0.00");
            viewHolder.tv_honest.setText(df.format((customer.get(position).getComeOrderSelfRated()+customer.get(position).getComeOrderOthersRated())/2.0));
            viewHolder.tv_company_apply_remark.setText(customer.get(position).getComeOrderSelfRated()+"");
            viewHolder.tv_company_apply_remark_other.setText(customer.get(position).getComeOrderOthersRated()+"");

            return convertView;
        }
    }

    public static class ViewHolder {
        public TextView tv_supplier_company_name;//公司名称
        public TextView tv_customer_num;//服务客户数量
        public TextView tv_apply_address;//地址
        public TextView tv_master;//负责人
        public TextView tv_phone;//电话
        public TextView tv_honest;//公司信誉
        public TextView tv_company_apply_remark;//自评
        public TextView tv_company_apply_remark_other;//他评
        public TextView tv_major;//主营
    }

    public int dp2px(float dipValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
