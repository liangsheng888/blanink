package com.blanink.activity.aftersale;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.AfterSaleHistory;
import com.blanink.pojo.AfterSales;
import com.blanink.pojo.ResponseDelete;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.OrderProductStateUtils;
import com.blanink.utils.SysConstants;
import com.blanink.view.UpLoadListView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/***
 * 我的售后（我发出的）
 */
public class MyAfterSale extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.rl_after_sale_demand)
    RelativeLayout rlAfterSaleDemand;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sale_recevie);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }


    private void initData() {
        loadData();
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
                    Intent intent = new Intent(MyAfterSale.this, AfterSaleHandleDetail.class);
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
                .add("my", "1").add("pageNo", pageNo + "").build();
        Request request = new Request.Builder().post(body).url(url).build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
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
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            llLoad.setVisibility(View.GONE);
                            if (af.getResult().getTotal() == 0) {
                                rlNotData.setVisibility(View.VISIBLE);
                                tvNot.setText("暂无售后需求");
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
                convertView = View.inflate(MyAfterSale.this, R.layout.item_my_after_sale_queue, null);
                viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
                viewHolder.tv_proNme = (TextView) convertView.findViewById(R.id.tv_proNme);

                viewHolder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);

                viewHolder.tv_reason = (TextView) convertView.findViewById(R.id.tv_reason);

                viewHolder.tv_note = (TextView) convertView.findViewById(R.id.tv_note);
                viewHolder.tv_refuse = (TextView) convertView.findViewById(R.id.tv_refuse);
                viewHolder.tv_ok = (TextView) convertView.findViewById(R.id.tv_ok);
                viewHolder.tv_result = (TextView) convertView.findViewById(R.id.tv_result);
                viewHolder.tv_modify = (TextView) convertView.findViewById(R.id.tv_modify);
                viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv);

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
                viewHolder.tv_modify.setVisibility(View.VISIBLE);
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
            }
            if ("6".equals(rb.getStatus())) {
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorGreen));
                viewHolder.tv_ok.setText(View.VISIBLE);
            }
            viewHolder.tv_state.setText(OrderProductStateUtils.getAfterSaleState(rb.getStatus()));
            viewHolder.tv_reason.setText(OrderProductStateUtils.getAfterSaleType(rb.getType()));
            viewHolder.tv_note.setText(rb.getReason());
            GlideUtils.glideImageView(MyAfterSale.this, viewHolder.iv, rb.getOrderProdCompany().getPhoto(), true);
            //处理结果
            viewHolder.tv_result.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MyAfterSale.this, AfterSaleDetail.class);
                    intent.putExtra("id", rb.getId());
                    startActivity(intent);
                }
            });
            if (SysConstants.AFTERSALES_STATUS_VERIFY.equals(rb.getStatus())) {
                viewHolder.tv_ok.setVisibility(View.VISIBLE);
                viewHolder.tv_refuse.setVisibility(View.VISIBLE);
            }
            //确认
            viewHolder.tv_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nofity(rb.getId(), "你确定接受对方售后处理结果吗?", "你同意了对方的请求", "取消", "确定", true);
                }
            });
            //拒绝
            viewHolder.tv_refuse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nofity(rb.getId(), "你真的要拒绝对方的售后处理结果吗?", "你拒绝了对方的请求", "取消", "确定", false);

                }
            });
            if (SysConstants.AFTERSALES_STATUS_START.equals(rb.getStatus())) {
                viewHolder.tv_modify.setVisibility(View.VISIBLE);
                viewHolder.tv_refuse.setVisibility(View.GONE);
            }
            //修改
            viewHolder.tv_modify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MyAfterSale.this, AfterSaleDemandModify.class);
                    intent.putExtra("orderProductCompanyId", rb.getOrderProdCompany().getId());
                    intent.putExtra("orderProductId", rb.getOrderProduct().getId());
                    intent.putExtra("remarks", rb.getReason());
                    intent.putExtra("id", rb.getId());
                    intent.putExtra("type", rb.getType());
                    intent.putExtra("images", rb.getImages());
                    startActivity(intent);
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
        TextView tv_result;
        TextView tv_ok;
        TextView tv_refuse;
        TextView tv_modify;
        ImageView iv;


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            pageNo = 1;
            rowsBeanList.clear();
            loadData();
        }
    }

    private void nofity(final String afterSaleId, final String content, final String title, String left, String right, final Boolean isOk) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_exit);
        final Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        window.setAttributes(lp);
        ((TextView) window.findViewById(R.id.tv_content)).setText(content);
        ((TextView) window.findViewById(R.id.tv_continue)).setText(left);
        ((TextView) window.findViewById(R.id.tv_exit)).setText(right);
        window.findViewById(R.id.tv_continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        window.findViewById(R.id.tv_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogLoadUtils.getInstance(MyAfterSale.this);
                DialogLoadUtils.showDialogLoad("操作进行中...");
                upDateStatus(afterSaleId, title, isOk);
                alertDialog.dismiss();
            }
        });
    }

    private void upDateStatus(String afterSaleId, final String title, Boolean isOk) {
        //  http://localhost:8080/blanink-api/afterSales/endAfterSales?
        // userId=4856035c527b419a9cf70d856e65c93b&
        // id=FFFFFF&curentUser.id=4856035c527b419a9cf70d856e65c93b
        String url;
        if (isOk) {
            url = NetUrlUtils.NET_URL + "afterSales/endAfterSales";
        } else {
            url = NetUrlUtils.NET_URL + "afterSales/refuseAfterSales";

        }
        Log.e("@@@@", url + "?currentUser.id=" + sp.getString("USER_ID", null) + "&id=" + afterSaleId);
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("currentUser.id", sp.getString("USER_ID", null))
                .add("userId", sp.getString("USER_ID", null))
                .add("id", afterSaleId)
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogLoadUtils.dismissDialog();
                        Toast.makeText(MyAfterSale.this, "服务器开了回小差", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Log.e("@@@@", result);
                Gson gson = new Gson();
                final ResponseDelete rd = gson.fromJson(result, ResponseDelete.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if ("00000".equals(rd.getErrorCode())) {
                            DialogLoadUtils.dismissDialog();
                            Toast.makeText(MyAfterSale.this, title, Toast.LENGTH_SHORT).show();
                            loadData();

                        } else {
                            DialogLoadUtils.dismissDialog();
                            Toast.makeText(MyAfterSale.this, "操着失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

}
