package com.blanink.activity.lastNext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.MainActivity;
import com.blanink.pojo.ManyCustomer;
import com.blanink.utils.CheckNetIsConncet;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.RefreshListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/***
 * 下家管理供应商管理
 */
public class NextFamilyManageCompanySupplierManage extends AppCompatActivity {

    private static final int BACK_TASK = 0;
    private MyActivityManager myActivityManager;
    private TextView iv_customer_manage_last;
    private LinearLayout ll_load;
    private RelativeLayout ll_load_fail;
    private RefreshListView lv_supplier_queue;
    private List<ManyCustomer.Result.Customer> suppliers = new ArrayList<ManyCustomer.Result.Customer>();
    private SparseArray<View> sparseArray;
    private MyAdapter adapter;
    private Integer pageNo = 1;//当前页
    private ManyCustomer lmc;
    SharedPreferences sp;
    Boolean hasData = true;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            //更新UI
            if(adapter==null){
                rl_not_data.setVisibility(View.VISIBLE);
            }else {
            adapter.notifyDataSetChanged();
            lv_supplier_queue.completeRefresh(hasData);}
        }

        ;
    };
    private TextView tv_seek;
    private EditText et_supplier;
    private ImageView iv_seek_supplier;
    private RelativeLayout rl_not_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_family_manage_company_supplier_manage);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initView();
        initData();
    }

    private void initView() {
        iv_customer_manage_last = ((TextView) findViewById(R.id.iv_customer_manage_last));
        lv_supplier_queue = ((RefreshListView) findViewById(R.id.lv_supplier_queue));
        ll_load = ((LinearLayout) findViewById(R.id.ll_load));//加载
        ll_load_fail = ((RelativeLayout) findViewById(R.id.rl_load_fail));//加载失败
        tv_seek = ((TextView) findViewById(R.id.tv_seek));//搜索
        et_supplier = ((EditText) findViewById(R.id.et_supplier));
        iv_seek_supplier = ((ImageView) findViewById(R.id.iv_seek_supplier));//搜索合作供应商
        rl_not_data = ((RelativeLayout) findViewById(R.id.rl_not_data));
    }

    private void initData() {

        getData();
        //重新加载
        ll_load_fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_load_fail.setVisibility(View.GONE);
                ll_load.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getData();
                    }
                }, 1500);
            }
        });
        iv_customer_manage_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //下拉刷新上拉加载
        lv_supplier_queue.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onPullRefresh() {
                requestDataFromServer(false);
            }

            @Override
            public void onLoadingMore() {
                requestDataFromServer(true);

            }
        });
        //跳转到供应商详情界面
        lv_supplier_queue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0 && position < suppliers.size() + 1) {
                    Intent intent = new Intent(NextFamilyManageCompanySupplierManage.this, NextFamilyManageCompanyDetail.class);
                    intent.putExtra("id", suppliers.get(position - 1).getId());
                    intent.putExtra("companyName",suppliers.get(position-1).getCompanyB().name);
                    intent.putExtra("companyB.id",suppliers.get(position-1).getCompanyB().id);
                    intent.putExtra("type",suppliers.get(position-1).getType());
                    startActivity(intent);
                }
            }
        });
        //我的供应商搜索
        tv_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NextFamilyManageCompanySupplierManage.this, NextFamilyManageMySupplierSeek.class);
                startActivity(intent);
            }
        });
        et_supplier.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Intent intent = new Intent(NextFamilyManageCompanySupplierManage.this, NextFamilyManageMySupplierSeek.class);
                    startActivity(intent);
                }
            }
        });
        //全局搜索
        iv_seek_supplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NextFamilyManageCompanySupplierManage.this, NextAllSupplierSeek.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
        Intent intentBackTask = new Intent(this, MainActivity.class);
        intentBackTask.putExtra("DIRECT", BACK_TASK);
        startActivity(intentBackTask);
    }

    // 上拉加载下拉刷新
    private void requestDataFromServer(final boolean isLoadingMore) {

        if (isLoadingMore) {
            pageNo++;
            getData();
        } else {
            getDataRefresh();
        }
    }

    private void getDataRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!CheckNetIsConncet.isNetWorkConnected(NextFamilyManageCompanySupplierManage.this)) {
                    ll_load.setVisibility(View.GONE);
                    ll_load_fail.setVisibility(View.VISIBLE);
                } else {
                    RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "partner/list");
                    requestParams.addBodyParameter("userId", sp.getString("USER_ID", "NULL"));
                    requestParams.addBodyParameter("pageNo", pageNo + "");
                    x.http().post(requestParams, new Callback.CacheCallback<String>() {
                        @Override
                        public void onSuccess(String result) {
                            ll_load.setVisibility(View.GONE);
                            Log.e("Next", "下家管理（未解析）:" + result);
                            Gson gson = new Gson();
                            lmc = gson.fromJson(result, ManyCustomer.class);
                            Log.e("Next", "下家管理（已解析）:" + lmc.getErrorCode() + lmc.getReason());
                            Log.e("Next", "下家管理（已解析）长度:" + lmc.getResult().getRows().size());
                            Log.e("@@@@", "下家管理:" + "数据总长度:" + lmc.getResult().getTotal() + "  拿到的数据总长度:" + suppliers.size());
                            if (lmc.getResult().getTotal() >= suppliers.size()) {
                                hasData = false;
                            } else {
                                hasData = true;
                                int oldIndex = suppliers.size() - 1;
                                suppliers.addAll(lmc.getResult().getRows());

                                if (adapter == null) {
                                    Log.e("Next", "adapter==null");
                                    adapter = new MyAdapter();
                                    lv_supplier_queue.setAdapter(adapter);
                                } else {
                                    Log.e("Next", "adapter!=null");
                                    adapter.notifyDataSetChanged();
                                    lv_supplier_queue.setSelection(oldIndex);
                                }
                            }
                            //在UI线程更新UI
                            handler.sendEmptyMessage(0);
                        }

                        @Override
                        public void onError(Throwable ex, boolean isOnCallback) {
                            ll_load.setVisibility(View.GONE);
                            ll_load_fail.setVisibility(View.VISIBLE);
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
        }, 1500);
    }


    //访问服务器
    private void getData() {

                if (!CheckNetIsConncet.isNetWorkConnected(NextFamilyManageCompanySupplierManage.this)) {
                    ll_load.setVisibility(View.GONE);
                    ll_load_fail.setVisibility(View.VISIBLE);
                } else {
                    RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "partner/list");
                    requestParams.addBodyParameter("userId", sp.getString("USER_ID", "NULL"));
                    requestParams.addBodyParameter("pageNo", pageNo + "");
                    x.http().post(requestParams, new Callback.CacheCallback<String>() {
                        @Override
                        public void onSuccess(String result) {
                            ll_load.setVisibility(View.GONE);
                            Log.e("Next", "下家管理（未解析）:" + result);
                            Gson gson = new Gson();
                            lmc = gson.fromJson(result, ManyCustomer.class);
                            Log.e("Next", "下家管理（已解析）:" + lmc.getErrorCode() + lmc.getReason());
                            Log.e("Next", "下家管理（已解析）长度:" + lmc.getResult().getRows().size());
                            Log.e("@@@@", "下家管理:" + "数据总长度:" + lmc.getResult().getTotal() + "  拿到的数据总长度:" + suppliers.size());
                            if (lmc.getResult().getTotal() == suppliers.size()) {
                                hasData = false;
                            } else {
                                int oldIndex = suppliers.size() - 1;
                                suppliers.addAll(lmc.getResult().getRows());

                                if (adapter == null) {
                                    Log.e("Next", "adapter==null");
                                    adapter = new MyAdapter();
                                    lv_supplier_queue.setAdapter(adapter);
                                } else {
                                    Log.e("Next", "adapter!=null");
                                    adapter.notifyDataSetChanged();
                                }
                            }
                            //在UI线程更新UI
                            handler.sendEmptyMessage(0);
                        }

                        @Override
                        public void onError(Throwable ex, boolean isOnCallback) {
                            ll_load.setVisibility(View.GONE);
                            ll_load_fail.setVisibility(View.VISIBLE);
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


    public class MyAdapter extends BaseAdapter {
        public MyAdapter() {
            Log.e("Next", "customers ：");
        }

        @Override
        public int getCount() {
            return suppliers.size();
        }

        @Override
        public Object getItem(int position) {
            return suppliers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            sparseArray = new SparseArray<>();
            Log.e("Next", "getView  supplier ：" + suppliers.size() + "");
            if (sparseArray.get(position, null) == null) {
                Log.e("Next", "getView  convertView ==null");
                viewHolder = new ViewHolder();
                convertView = View.inflate(NextFamilyManageCompanySupplierManage.this, R.layout.item_customer_queue, null);
                viewHolder.tv_company_jc = (TextView) convertView.findViewById(R.id.tv_name);
                //    viewHolder.tv_apply_company_name = (TextView) convertView.findViewById(R.id.tv_apply_company_name);
                viewHolder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);
                viewHolder.tv_master = (TextView) convertView.findViewById(R.id.tv_master);
                viewHolder.tv_phone = (TextView) convertView.findViewById(R.id.tv_phone);
                viewHolder.tv_honest = (TextView) convertView.findViewById(R.id.tv_honest);
                viewHolder.tv_company_apply_remark = (TextView) convertView.findViewById(R.id.tv_company_apply_remark);
                viewHolder.tv_company_apply_remark_other = (TextView) convertView.findViewById(R.id.tv_company_apply_other_remark);
                viewHolder.tv_apply_address = (TextView) convertView.findViewById(R.id.tv_apply_address);
                convertView.setTag(viewHolder);
                sparseArray.put(position, convertView);
            } else {
                Log.e("Next", "getView  convertView !=null");
                convertView = sparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            ManyCustomer.Result.Customer customer = suppliers.get(position);
            Log.e("Next", " getView 下家管理 supplier:" + customer.getCompanyB().toString());

            viewHolder.tv_state.setText("1".equals(customer.getType()) ? "已合作" : "潜在");
            Log.e("Next", "type"+customer.getType());
            if ("1".equals(customer.getType())) {
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorTheme));
            } else {
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorBlue));
            }
            viewHolder.tv_company_jc.setText(customer.getCompanyB().name);
            viewHolder.tv_master.setText(customer.getCompanyB().master);
            viewHolder.tv_apply_address.setText(customer.getCompanyB().address);
            viewHolder.tv_master.setText(customer.getCompanyB().master);
            viewHolder.tv_phone.setText(customer.getCompanyB().phone);
            DecimalFormat df = new DecimalFormat("0.0");
            viewHolder.tv_honest.setText(df.format((suppliers.get(position).companyB.reviewSelf + suppliers.get(position).companyB.reviewOthers) / 2.0));
            viewHolder.tv_company_apply_remark.setText(suppliers.get(position).companyB.reviewSelf + "");
            viewHolder.tv_company_apply_remark_other.setText(suppliers.get(position).companyB.reviewOthers + "");
            return convertView;
        }

    }

    public static class ViewHolder {
        public TextView tv_company_jc;//公司简称
        public TextView tv_apply_company_name;//公司名称
        public TextView tv_state;//实有 虚拟
        public TextView tv_apply_address;//地址
        public TextView tv_master;//负责人
        public TextView tv_phone;//电话
        public TextView tv_honest;//公司信誉
        public TextView tv_company_apply_remark;//自评
        public TextView tv_company_apply_remark_other;//他评

    }

    @Override
    protected void onStart() {
        super.onStart();
        //清空焦点
        et_supplier.clearFocus();
    }
}
