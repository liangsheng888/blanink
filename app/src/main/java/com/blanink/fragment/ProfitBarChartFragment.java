package com.blanink.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
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
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.Profit;
import com.blanink.pojo.ReportSale;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.BarChart01View;
import com.blanink.view.StackBarChartVerView;
import com.google.gson.Gson;

import org.xclcharts.chart.BarData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
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
 * Created by Administrator on 2017/8/15 0015.
 */
public class ProfitBarChartFragment extends Fragment {
    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.tv_end)
    TextView tvEnd;
    @BindView(R.id.sp_type)
    Spinner spType;
    @BindView(R.id.tv_seek)
    TextView tvSeek;
    @BindView(R.id.fl_view)
    FrameLayout flView;
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
    Calendar calendar;
    private String startDate = "";
    private String endDate = "";
    private String viewType = "1";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_profit, null);
        unbinder = ButterKnife.bind(this, view);
        sp=getActivity().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        calendar = Calendar.getInstance();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadSaleData();
        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DatePickerDialog dpd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvStart.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                        startDate = tvStart.getText().toString().trim();
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });


        tvEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvEnd.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                        endDate = tvEnd.getText().toString().trim();
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }

        });
        spType.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spanner_item, new String[]{"选择查看方式", "按月查看", "按年查看"}));
        spType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        viewType = "1";
                        break;
                    case 1:
                        viewType = "1";

                        break;
                    case 2:
                        viewType = "2";
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tvSeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlNotData.setVisibility(View.GONE);
                loadSaleData();
            }
        });
    }

    public void loadSaleData() {
        String url = NetUrlUtils.NET_URL + "report/profit";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("userId", sp.getString("USER_ID", null))
                .add("viewType", viewType)
                .add("startDateString", startDate)
                .add("endDateString", endDate)
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

                final Profit pf = gson.fromJson(json, Profit.class);
                final List<String> labelList = new ArrayList<String>();
                final List<BarData> barDataSet = new ArrayList<BarData>();
                final List<Double> costSetData = new ArrayList<Double>();
                final List<Double> saleSetData = new ArrayList<Double>();
                final List<Double> profitSetData = new ArrayList<Double>();
                final List<Double> data = new ArrayList<Double>();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        llLoad.setVisibility(View.GONE);
                        for (Profit.ResultBean rr : pf.getResult()) {
                             labelList.add(rr.getDateString());
                            costSetData.add(rr.getCostAmount()/10000);
                            saleSetData.add(rr.getSaleAmount()/10000);
                            profitSetData.add(rr.getProfitAmount()/10000);
                        }
                        data.addAll(costSetData);
                        data.addAll(saleSetData);
                        data.addAll(profitSetData);

                        barDataSet.add(new BarData("成本", costSetData, Color.RED));
                        barDataSet.add(new BarData("销售额", saleSetData, Color.BLUE));
                        barDataSet.add(new BarData("利润", profitSetData, Color.rgb(148,0,211)));

                         BarChart01View view = new BarChart01View(getActivity());
                       // StackBarChartVerView view = new StackBarChartVerView(getActivity());
                        Collections.sort(data);
                        if (data.size() > 0) {
                            view.setYAxis((Math.ceil(data.get(0)) >= 0 ? 0 : Math.ceil(data.get(0))), Math.ceil(data.get(data.size() - 1)) + Math.ceil(data.get(data.size() - 1)) / data.size(), Math.ceil(data.get(data.size() - 1)) / data.size());
                        }                                      view.setChartLabels(labelList);
                        view.setBarDataSet(barDataSet);
                        view.setTitle("万元","时间");
                        if (flView != null) {
                            flView.removeAllViews();
                            flView.addView(view);
                        }

                        if (pf.getResult().size() == 0) {
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
