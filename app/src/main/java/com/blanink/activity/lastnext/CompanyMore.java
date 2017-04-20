package com.blanink.activity.lastNext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.activity.SeekActivity;
import com.blanink.pojo.Company;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.XUtilsImageUtils;
import com.blanink.view.UpLoadListView;
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
 * 大搜索公司更多
 */
public class CompanyMore extends AppCompatActivity {

    @BindView(R.id.tv_last)
    TextView tvLast;
    @BindView(R.id.rl_customer_manage)
    RelativeLayout rlCustomerManage;
    @BindView(R.id.lv)
    UpLoadListView lv;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
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
    @BindView(R.id.fl_load)
    FrameLayout flLoad;
    @BindView(R.id.activity_company_more)
    RelativeLayout activityCompanyMore;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private String content;
    private List<Company.ResultBean.ListBean> listBean = new ArrayList<>();
    private CompanyAdapter adapter;
    private boolean isHasData;
    private int pageNo = 1;
    private SparseArray<View> sparseArray;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv.completeRefresh(isHasData);
            adapter.notifyDataSetChanged();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_more);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        ButterKnife.bind(this);
        receiveData();
        initData();
    }

    private void initData() {
        loadData();
        //加载更多
        lv.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {
            @Override
            public void onLoadingMore() {
                pageNo++;
                loadData();
            }
        });
        //刷新
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        swipeRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });
        //公司详情
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                String customerId = listBean.get(position).getOffice().getId();
                //客户
                if (listBean.get(position).getPartnershipAsA() != null) {
                    intent = new Intent(CompanyMore.this, LastCustomerDetail.class);
                    intent.putExtra("companyA.id", listBean.get(position).getOffice().getId());
                    intent.putExtra("type", listBean.get(position).getPartnershipAsA().getType());
                } else if (listBean.get(position).getPartnershipAsB() != null) {
                    //供应商
                    intent = new Intent(CompanyMore.this, NextFamilyManageCompanyDetail.class);
                    intent.putExtra("companyB.id", listBean.get(position).getOffice().getId());
                    intent.putExtra("type", listBean.get(position).getPartnershipAsB().getType());
                } else {
                    //未合作
                    intent = new Intent(CompanyMore.this, CompanyDetail.class);
                }
                intent.putExtra("companyId", customerId);
                intent.putExtra("companyName", listBean.get(position).getOffice().getName());
                intent.putExtra("companyType", listBean.get(position).getOffice().getServiceType());
                startActivity(intent);
            }
        });
    }

    private void refreshData() {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "search/bigSearch");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("office.name", content);
        rp.addBodyParameter("companyProduct.productName", content);
        rp.addBodyParameter("inviteBid.title", content);
        rp.addBodyParameter("financing.title", content);
        rp.addBodyParameter("pageNo", pageNo + "");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                swipeRefreshLayout.setRefreshing(false);
                Gson gson = new Gson();
                Company company = gson.fromJson(result, Company.class);

                if (company.getResult().get(0).getCount()<=listBean.size()){
                    Toast.makeText(CompanyMore.this, "没有新的数据", Toast.LENGTH_SHORT).show();
                } else {
                    listBean.addAll(0, company.getResult().get(0).getList());
                    Toast.makeText(CompanyMore.this, "刷新出来" + company.getResult().get(0).getList().size() + "条数据", Toast.LENGTH_SHORT).show();
                }
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(CompanyMore.this, "服务器异常", Toast.LENGTH_SHORT).show();
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


    private void receiveData() {
        Intent intent = getIntent();
        content = intent.getStringExtra("content");
    }

    @OnClick(R.id.tv_last)
    public void onClick() {
        finish();//返回
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    public void loadData() {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "search/bigSearch");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("office.name", content);
        rp.addBodyParameter("companyProduct.productName", content);
        rp.addBodyParameter("inviteBid.title", content);
        rp.addBodyParameter("financing.title", content);
        rp.addBodyParameter("pageNo", pageNo + "");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                Company company = gson.fromJson(result, Company.class);

                if (company.getResult().get(0).getCount()<=listBean.size()) {
                    isHasData = false;
                } else {
                    listBean.addAll(company.getResult().get(0).getList());
                    if (adapter == null) {
                        adapter = new CompanyAdapter();
                        lv.setAdapter(adapter);//公司
                    } else {
                      adapter.notifyDataSetChanged();
                    }
                }
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                llLoad.setVisibility(View.GONE);
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

    public class CompanyAdapter extends BaseAdapter {
        public CompanyAdapter() {

        }

        @Override
        public int getCount() {
            return listBean.size();
        }

        @Override
        public Object getItem(int position) {
            return listBean.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            sparseArray = new SparseArray<>();
            if (sparseArray.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(CompanyMore.this, R.layout.item_company, null);
                viewHolder.ivCompany=(ImageView)convertView.findViewById(R.id.iv_company);
                viewHolder.tvAddress=(TextView) convertView.findViewById(R.id.tv_company_address);
                viewHolder.tvCompanyName=(TextView)convertView.findViewById(R.id.tv_company_name);
                viewHolder.tvMaster=(TextView)convertView.findViewById(R.id.tv_company_master);
                viewHolder.tvScope=(TextView)convertView.findViewById(R.id.tv_company_scope);
                convertView.setTag(viewHolder);
                sparseArray.put(position, convertView);
            } else {
                convertView = sparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.tvCompanyName.setText(listBean.get(position).getOffice().getName());
            viewHolder.tvMaster.setText(listBean.get(position).getOffice().getMaster());
            viewHolder.tvScope.setText(listBean.get(position).getOffice().getScope());
            viewHolder.tvAddress.setText(listBean.get(position).getOffice().getAddress());
            XUtilsImageUtils.display(viewHolder.ivCompany,listBean.get(position).getOffice().getPhoto());
            return convertView;
        }

    }
   static class ViewHolder{
       ImageView ivCompany;
       TextView tvCompanyName;
       TextView tvMaster;
       TextView tvScope;
       TextView tvAddress;
   }
}
