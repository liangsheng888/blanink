package com.blanink.fragment;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.PartnerInfo;
import com.blanink.pojo.PartnerOffice;
import com.blanink.pojo.ReportPay;
import com.blanink.pojo.ReportSale;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.StackBarChartVerView;
import com.google.gson.Gson;

import org.xclcharts.chart.BarData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
 * Created by Administrator on 2017/8/1 0001.
 */
public class PayBarChartFragment extends Fragment {
    @BindView(R.id.sp_type)
    Spinner spType;
    @BindView(R.id.tv_seek)
    TextView tvSeek;
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
    @BindView(R.id.fl_view)
    FrameLayout flView;
    Unbinder unbinder;
    private SharedPreferences sp;
    private String customerId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_pay, null);
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadCustomerData();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void loadCustomerData() {
        String url = NetUrlUtils.NET_URL + "report/partnerList";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("userId", sp.getString("USER_ID", null))
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        llLoad.setVisibility(View.GONE);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();

                final PartnerOffice rs = gson.fromJson(json, PartnerOffice.class);
                final List<String> customerList=new ArrayList<String>();
                final List<String> customerIdList=new ArrayList<String>();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        llLoad.setVisibility(View.GONE);
                        loadSaleData();
                        for(int i=0;i<rs.getResult().size();i++){
                            customerList.add(rs.getResult().get(i).getName());
                            customerIdList.add(rs.getResult().get(i).getId());
                        }
                        spType.setAdapter(new ArrayAdapter<String>(getActivity(),R.layout.spanner_item,customerList));
                        spType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                customerId = customerIdList.get(position);

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }
                });
            }
        });
    }

    public void loadSaleData() {
        String url = NetUrlUtils.NET_URL + "report/orderDebitList";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("userId", sp.getString("USER_ID", null))
                .add("office.id", sp.getString("COMPANY_ID", null))
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        llLoad.setVisibility(View.GONE);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();

                final ReportPay rs = gson.fromJson(json, ReportPay.class);
                final List<String> labelList = new ArrayList<String>();
                final List<BarData> barDataSet = new ArrayList<BarData>();
                final List<Double> dataSeries = new ArrayList<Double>();
                final List<Double> dataSeries2 = new ArrayList<Double>();
                final List<Double> dataSeries3 = new ArrayList<Double>();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        llLoad.setVisibility(View.GONE);
                        for(int i=0;i<rs.getResult().size();i++){
                            labelList.add(rs.getResult().get(i).getOffice().getShortName());
                            dataSeries.add(rs.getResult().get(i).getSaleAmount()/10000);
                            dataSeries2.add(rs.getResult().get(i).getCostAmount()/10000);
                            dataSeries3.add((rs.getResult().get(i).getSaleAmount() - rs.getResult().get(i).getCostAmount())/10000);

                        }
                        barDataSet.add(new BarData("应付款总额", dataSeries, Color.rgb(255,0,0)));
                        barDataSet.add(new BarData("已付款", dataSeries2, Color.rgb(148,0,211)));
                        barDataSet.add(new BarData("未付款", dataSeries3,Color.rgb(0,0,255)));

                        StackBarChartVerView view = new StackBarChartVerView(getActivity());
                        view.setYAxis(0, 2000, 50);
                        view.setChartLabels(labelList);
                        view.setBarDataSet(barDataSet);
                        view.setLeftTitle("元");
                        if (flView != null) {
                            flView.removeAllViews();
                            flView.addView(view);
                        }
                        if (rs.getResult().size() == 0) {
                            rlNotData.setVisibility(View.VISIBLE);
                            tvNot.setText("没有结果显示");
                        } else {
                            rlNotData.setVisibility(View.GONE);

                        }

                    }
                });
            }
        });
    }
}
