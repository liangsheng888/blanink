package com.blanink.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.activity.lastNext.ProductDetail;
import com.blanink.pojo.CompanyProduct;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.RefreshListView;
import com.google.gson.Gson;
import com.loopj.android.image.SmartImageView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/2/9.
 */

/***
 * 上家 公司信息 公司产品
 */
public class LastProduct extends Fragment {
    public String companyId;
    private RefreshListView lv_product;
    private List<CompanyProduct.Result.Row> rowList=new ArrayList<CompanyProduct.Result.Row>();
    private int pageNo=1;
    private SparseArray<View> sparseArray;
    private Boolean isHasData=true;
    private MyAdapter adater;
    private LinearLayout ll_load;
    private RelativeLayout ll_load_fail;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            //更新UI
            lv_product.completeRefresh(isHasData);
            if(adater!=null)
            adater.notifyDataSetChanged();
        }

    };
    private SharedPreferences sp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        companyId=getActivity().getIntent().getStringExtra("companyA.id");
        sp = getActivity().getSharedPreferences("DATA",getActivity().MODE_PRIVATE);
        View view=View.inflate(getActivity(), R.layout.fragment_company_product,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        lv_product = ((RefreshListView) view.findViewById(R.id.lv_product));
        ll_load = ((LinearLayout) view.findViewById(R.id.ll_load));//加载
        ll_load_fail = ((RelativeLayout)view.findViewById(R.id.rl_load_fail));//加载失败
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
        //加载失败 重新加载
        ll_load_fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_load_fail.setVisibility(View.GONE);
                ll_load.setVisibility(View.VISIBLE);
                getData();
            }
        });

       lv_product.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onPullRefresh() {
                requestDataFromServer(false);
            }

            @Override
            public void onLoadingMore() {
                requestDataFromServer(true);
            }
        });

        //产品详情
        lv_product.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CompanyProduct.Result.Row row=rowList.get(position-1);
                Intent intent=new Intent(getActivity(),ProductDetail.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("ProductDetail",row);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    // 服务器访问数据库
    private void requestDataFromServer(final boolean isLoadingMore) {

        if (isLoadingMore) {
            pageNo++;
            getData();
        } else {
            getData();
        }
    }

    public void getData(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!ExampleUtil.isConnected(getActivity())){
                    //判断网络是否连接
                    ll_load.setVisibility(View.GONE);
                    ll_load_fail.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_SHORT).show();
                    return;
                }

                RequestParams rp=new RequestParams(NetUrlUtils.NET_URL+"customer/productList");
                rp.addBodyParameter("pageNo",pageNo+"");
                rp.addBodyParameter("company.id",companyId);
                rp.addBodyParameter("userId",sp.getString("USER_ID",null));
                Log.e("LastProduct","company.id"+companyId);
                x.http().post(rp, new Callback.CacheCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        ll_load.setVisibility(View.GONE);
                        Log.e("LastProduct","获取数据:"+result);
                        Gson gson=new Gson();
                        CompanyProduct cp= gson.fromJson(result, CompanyProduct.class);
                        Log.e("LastProduct","解析完成:"+cp.toString());
                        if(cp.result.total<=rowList.size()){
                            Log.e("LastProduct","没有多余的数据了:");
                            isHasData=false;
                        }
                        else {
                            rowList.addAll(cp.result.rows);
                            if(adater==null){
                                Log.e("LastProduct","adater==null:");
                                adater=new MyAdapter();
                                lv_product.setAdapter(adater);
                            }else {
                                Log.e("LastProduct","adater!=null:");
                                adater.notifyDataSetChanged();
                            }

                        }
                        handler.sendEmptyMessage(0);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        ll_load.setVisibility(View.GONE);
                        ll_load_fail.setVisibility(View.VISIBLE);
                        Log.e("LastProduct",ex.toString());
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
        },1000);

    }
    
    public  class  MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return rowList.size();
        }

        @Override
        public Object getItem(int position) {
            return rowList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.e("LastProduct","getView");
            sparseArray=new SparseArray<View>();
            ViewHolder viewHolder=null;
            if(sparseArray.get(position,null)==null){
                viewHolder=new ViewHolder();
                convertView=View.inflate(getActivity(),R.layout.item_product_queue,null);
                viewHolder.iv_product_picture= ((SmartImageView) convertView.findViewById(R.id.iv_product_picture));
                viewHolder.tv_product_name=(TextView)convertView.findViewById(R.id.tv_product_name);
                viewHolder.tv_address=(TextView)convertView.findViewById(R.id.tv_address);
                viewHolder.tv_price=(TextView)convertView.findViewById(R.id.tv_price);
                viewHolder.tv_specific_description=(TextView)convertView.findViewById(R.id.tv_specific_description);
                viewHolder.tv_hige_price=(TextView)convertView.findViewById(R.id.tv_price2);
                convertView.setTag(viewHolder);
                sparseArray.put(position,convertView);
            }else {
                convertView=sparseArray.get(position);
                viewHolder=(ViewHolder) convertView.getTag();
            }
            Log.e("LastProduct",rowList.toString());
            //x.image().bind(viewHolder.iv_product_picture,NetUrlUtils.NET_URL+rowList.get(position).productPhotos);
           // XUtilsImageUtils.displayLoading(viewHolder.iv_product_picture,NetUrlUtils.NET_URL+rowList.get(position).productPhotos);
            viewHolder.iv_product_picture.setImageUrl(NetUrlUtils.NET_URL+rowList.get(position).productPhotos);
            viewHolder.tv_product_name.setText(rowList.get(position).productName);
            viewHolder.tv_price.setText(rowList.get(position).productPriceDownline);
            viewHolder.tv_hige_price.setText(rowList.get(position).productPriceHighline);
            viewHolder.tv_specific_description.setText(rowList.get(position).productDescription);
            return convertView;
        }
    }
    static class ViewHolder{
        SmartImageView iv_product_picture;
        TextView  tv_product_name;
        TextView  tv_address;
        TextView  tv_price;
        TextView  tv_hige_price;
        TextView  tv_specific_description;
    }
}
