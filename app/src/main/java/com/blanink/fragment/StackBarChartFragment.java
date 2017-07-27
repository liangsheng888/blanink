package com.blanink.fragment;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.ReportSale;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.BarChart01View;
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
 * Created by Administrator on 2017/7/25.
 */
public class StackBarChartFragment extends Fragment {
    @BindView(R.id.tv_seek)
    TextView tvSeek;
    @BindView(R.id.fl_view)
    FrameLayout flView;
    Unbinder unbinder;
    private SharedPreferences sp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
        View view=View.inflate(getActivity(), R.layout.fragment_chart, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BarChart01View multiBarChart01View=new BarChart01View(getActivity());
        flView.addView(multiBarChart01View);
        //loadSaleData();
    }

    public void loadSaleData() {
        String url = NetUrlUtils.NET_URL + "report/saleDataList";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("userId", sp.getString("USER_ID", null))
                .add("viewType", "3")
                .add("office.id", sp.getString("COMPANY_ID", null))
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                final ReportSale rs = gson.fromJson(json, ReportSale.class);
                final List<String> labelList = new ArrayList<String>();
                final List<BarData> barDataSet = new ArrayList<BarData>();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Random random = new Random();
                        for (ReportSale.ResultBean rr : rs.getResult()) {
                            for (int i = 0; i < rr.getReportList().size(); i++) {
                                if (!labelList.contains(rr.getReportList().get(i).getStartDateString())) {
                                    labelList.add(rr.getReportList().get(i).getStartDateString());
                                }
                            }
                        }

                        for (ReportSale.ResultBean rr : rs.getResult()) {
                            final List<Double> dataSeries = new ArrayList<Double>();
                            for (int i = 0; i < rr.getReportList().size(); i++) {
                                dataSeries.add(Double.parseDouble(rr.getReportList().get(i).getSaleAmount() + ""));
                                if (i == rr.getReportList().size() - 1) {
                                    int color = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                                    barDataSet.add(new BarData(rr.getCompanyCategoryName(), dataSeries, color));
                                }

                            }
                        }


                        StackBarChartVerView sv = new StackBarChartVerView(getActivity(), labelList, barDataSet);
                        sv.setTitle("公司季度销售");
                        sv.setLeftTitle("单位/元");
                        sv.setYAxis(0, 2000000, 2000);
                        flView.addView(sv);


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
