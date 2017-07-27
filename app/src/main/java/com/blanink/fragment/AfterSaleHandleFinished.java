package com.blanink.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
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
import com.blanink.activity.aftersale.AfterSaleDetail;
import com.blanink.activity.aftersale.AfterSaleHandleDetail;
import com.blanink.activity.aftersale.AfterSaleToHandle;
import com.blanink.adapter.AfterSaleAdapter;
import com.blanink.pojo.AfterSales;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.OrderProductStateUtils;
import com.blanink.view.UpLoadListView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/2/6.
 */

/***
 * 售后 已处理
 */
public class AfterSaleHandleFinished extends Fragment {
    @BindView(R.id.lv_after_sale)
    UpLoadListView lvAfterSale;
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
    Unbinder unbinder;
    private SharedPreferences sp;
    private AfterSaleAdapter adapter;
    private List<AfterSales.ResultBean.RowsBean> rowsBeanList = new ArrayList<>();
    private boolean isHasData = true;
    private int pageNo = 1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lvAfterSale.completeRefresh(isHasData);
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_after_sale_not_handle, null);
        unbinder = ButterKnife.bind(this, view);
        sp = getActivity().getSharedPreferences("DATA", Context.MODE_PRIVATE);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void initData() {
        loadData();
        lvAfterSale.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {
            @Override
            public void onLoadingMore() {
                pageNo++;
                loadData();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        rlLoadFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlLoadFail.setVisibility(View.GONE);
                llLoad.setVisibility(View.VISIBLE);
                loadData();
            }
        });

        //处理
        lvAfterSale.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < rowsBeanList.size()) {
                    Intent intent = new Intent(getActivity(), AfterSaleHandleDetail.class);
                    intent.putExtra("reason", OrderProductStateUtils.getAfterSaleType(rowsBeanList.get(position).getType()));
                    intent.putExtra("orderProductCompanyId", rowsBeanList.get(position).getOrderProdCompany().getId());
                    intent.putExtra("orderProductId", rowsBeanList.get(position).getOrderProduct().getId());
                    startActivity(intent);
                }
            }
        });
    }


    public void loadData() {
        String url = NetUrlUtils.NET_URL + "afterSales/myAfterSalesList";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("userId", sp.getString("USER_ID", null))
                .add("my", "0").add("pageNo", pageNo + "").add("status", "5").build();
        Request request = new Request.Builder().post(body).url(url).build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        llLoad.setVisibility(View.GONE);
                        rlLoadFail.setVisibility(View.VISIBLE);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final AfterSales af = gson.fromJson(result, AfterSales.class);
                Log.e("@@@",af.toString());
                if (af.getResult() != null) {
                    if (af.getResult().getRows().size() == 0) {
                        isHasData = false;
                    } else {
                        rowsBeanList.addAll(af.getResult().getRows());
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            llLoad.setVisibility(View.GONE);
                            if (af.getResult().getTotal() == 0) {
                                rlNotData.setVisibility(View.VISIBLE);
                                tvNot.setText("*不能太懒啦*");
                            }
                            if (adapter == null) {
                                adapter = new AfterSaleAdapter(rowsBeanList);
                                lvAfterSale.setAdapter(adapter);
                            } else {
                                adapter.notifyDataSetChanged();
                            }
                            handler.sendEmptyMessage(0);
                        }
                    });

                }
            }
        });
    }

    public class AfterSaleAdapter extends BaseAdapter {
        private SparseArray<View> sparseArray = new SparseArray<>();
        private List<AfterSales.ResultBean.RowsBean> afterSalesList;

        public AfterSaleAdapter(List<AfterSales.ResultBean.RowsBean> afterSalesList) {
            this.afterSalesList = afterSalesList;
        }

        @Override
        public int getCount() {
            return afterSalesList.size();
        }

        @Override
        public Object getItem(int position) {
            return afterSalesList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (sparseArray.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(getActivity(), R.layout.item_after_sale_queue, null);
                viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
                viewHolder.tv_proNme = (TextView) convertView.findViewById(R.id.tv_proNme);

                viewHolder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);
                viewHolder.iv_photo = (ImageView) convertView.findViewById(R.id.iv_photo);

                viewHolder.tv_reason = (TextView) convertView.findViewById(R.id.tv_reason);

                viewHolder.tv_note = (TextView) convertView.findViewById(R.id.tv_note);
                viewHolder.tv_handle = (TextView) convertView.findViewById(R.id.tv_handle);
                viewHolder.tv_ok = (TextView) convertView.findViewById(R.id.tv_ok);
                viewHolder.tv_result = (TextView) convertView.findViewById(R.id.tv_result);

                convertView.setTag(viewHolder);
                sparseArray.put(position, convertView);
            } else {
                convertView = sparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            final AfterSales.ResultBean.RowsBean rb = afterSalesList.get(position);
            viewHolder.tv_name.setText(rb.getCreateBy().getName());
            viewHolder.tv_proNme.setText(rb.getOrderProduct().getProductName());
            if ("1".equals(rb.getStatus())) {
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorBlue));
            }
            if ("2".equals(rb.getStatus())) {
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            }
            if ("3".equals(rb.getStatus())) {
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorOrange));

            }
            if ("4".equals(rb.getStatus())) {
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorAccent));

            }
            if ("5".equals(rb.getStatus())) {
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorRed));
                viewHolder.tv_handle.setVisibility(View.INVISIBLE);
            }
            if ("6".equals(rb.getStatus())) {
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorGreen));
                viewHolder.tv_handle.setVisibility(View.INVISIBLE);
            }
            viewHolder.tv_state.setText(OrderProductStateUtils.getAfterSaleState(rb.getStatus()));
            viewHolder.tv_reason.setText(OrderProductStateUtils.getAfterSaleType(rb.getType()));
            viewHolder.tv_note.setText(rb.getReason());
            GlideUtils.glideImageView(getActivity(), viewHolder.iv_photo, rb.getCompany().getPhoto(), true);

            //处理结果
            viewHolder.tv_result.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), AfterSaleDetail.class);
                    intent.putExtra("id", rb.getId());
                    startActivity(intent);
                }
            });

            viewHolder.tv_handle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), AfterSaleToHandle.class);
                    intent.putExtra("reason", OrderProductStateUtils.getAfterSaleType(rb.getType()));
                    intent.putExtra("orderProductCompanyId", rb.getOrderProdCompany().getId());
                    intent.putExtra("orderProductId", rb.getOrderProduct().getId());
                    intent.putExtra("id", rb.getId());
                    startActivityForResult(intent, 200);
                }
            });
            return convertView;
        }


    }

    static class ViewHolder {
        TextView tv_proNme;
        TextView tv_name;
        TextView tv_state;
        TextView tv_reason;
        TextView tv_note;
        TextView tv_handle;
        TextView tv_result;
        TextView tv_ok;
        ImageView iv_photo;

    }
}
