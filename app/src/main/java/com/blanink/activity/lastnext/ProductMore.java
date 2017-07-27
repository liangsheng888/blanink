package com.blanink.activity.lastnext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.CompanyCateGory;
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

public class ProductMore extends AppCompatActivity {

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
    SparseArray<View> sparseArray;
    private String content;
    private SharedPreferences sp;
    private int pageNo=1;
    private Boolean isHasData;
    private CompanyAdapter adapter;
    private List<CompanyCateGory.ResultBean.ListBean> listBean=new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv.completeRefresh(isHasData);
            adapter.notifyDataSetChanged();

        }
    };
    private MyActivityManager myActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_more);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        Intent intent=getIntent();
        content = intent.getStringExtra("content");
        sp=getSharedPreferences("DATA",MODE_PRIVATE);
        loadData();//
        //load more
        lv.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {
            @Override
            public void onLoadingMore() {
                pageNo++;
                loadData();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
       //enter detail
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ProductMore.this, CompanyProductDetail.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("ProductDetail", listBean.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @OnClick({R.id.tv_last, R.id.rl_load_fail})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_last:
                finish();
                break;
            case R.id.rl_load_fail:
                break;
        }
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
                CompanyCateGory product = gson.fromJson(result, CompanyCateGory.class);

                if (product.getResult().get(1).getCount()<=listBean.size()) {
                    isHasData = false;
                } else {
                    listBean.addAll(product.getResult().get(1).getList());
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
                convertView = View.inflate(ProductMore.this, R.layout.item_product_queue, null);
                viewHolder.iv_product_picture=(ImageView)convertView.findViewById(R.id.iv_product_picture);
                viewHolder.tv_product_name=(TextView) convertView.findViewById(R.id.tv_product_name);
                viewHolder.tv_down_price=(TextView)convertView.findViewById(R.id.tv_down_price);
                viewHolder.tv_high_price=(TextView)convertView.findViewById(R.id.tv_high_price);
                viewHolder.tv_specific_description=(TextView)convertView.findViewById(R.id.tv_specific_description);
                convertView.setTag(viewHolder);
                sparseArray.put(position, convertView);
            } else {
                convertView = sparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.tv_product_name.setText(listBean.get(position).getCompanyProduct().getProductName());
            viewHolder.tv_specific_description.setText(listBean.get(position).getCompanyProduct().getProductDescription());
            String[] url=listBean.get(position).getCompanyProduct().getProductPhotos().split(",");
            XUtilsImageUtils.display(viewHolder.iv_product_picture,url[0]);
            return convertView;
        }

    }
    static class ViewHolder{
        ImageView iv_product_picture;
        TextView tv_product_name;
        TextView tv_down_price;//
        TextView tv_high_price;
        TextView tv_specific_description;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
