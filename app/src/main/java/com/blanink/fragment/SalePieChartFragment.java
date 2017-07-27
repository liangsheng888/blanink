package com.blanink.fragment;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.blanink.pojo.ReportSale;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.PieChart3D01View;
import com.google.gson.Gson;

import org.xclcharts.chart.PieData;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
public class SalePieChartFragment extends Fragment {
    @BindView(R.id.tv_seek)
    TextView tvSeek;
    @BindView(R.id.fl_view)
    FrameLayout flView;
    Unbinder unbinder;
    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.tv_end)
    TextView tvEnd;
    @BindView(R.id.sp_type)
    Spinner spType;
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

    private SharedPreferences sp;
    Calendar calendar;
    private String startDate = "";
    private String endDate = "";
    private String viewType = "3";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_chart, null);
        unbinder = ButterKnife.bind(this, view);
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
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
        spType.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spanner_item, new String[]{"选择查看方式", "按日查看", "按月查看", "按年查看"}));
        spType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        viewType = "3";
                        break;
                    case 1:
                        viewType = "3";

                        break;
                    case 2:
                        viewType = "1";
                        break;
                    case 3:
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
                llLoad.setVisibility(View.VISIBLE);
                loadSaleData();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void loadSaleData() {
        String url = getActivity().getIntent().getStringExtra("url");
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
            public void onFailure(Call call, final IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        llLoad.setVisibility(View.GONE);
                        Log.e("@@@",e.getMessage());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final List<PieData> pieChartList = new ArrayList<>();
                String json = response.body().string();
                Gson gson = new Gson();
                Random random = new Random();
                Double total = 0.0;//总数
                DecimalFormat df = new DecimalFormat("0.000");
                final ReportSale rs = gson.fromJson(json, ReportSale.class);

                for (ReportSale.ResultBean rr : rs.getResult()) {

                    total += rr.getTotalSaleAmount();

                }
                for (ReportSale.ResultBean rr : rs.getResult()) {


                    int color = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                    pieChartList.add(new PieData(rr.getCompanyCategoryName(), rr.getCompanyCategoryName() + ":" + (df.format((rr.getTotalSaleAmount() / total * 1.0) * 100)) + "%", (rr.getTotalSaleAmount() / total) * 100, color));


                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("@@@",rs.toString());
                        llLoad.setVisibility(View.GONE);
                        PieChart3D01View view = new PieChart3D01View(getActivity());
                        view.setChartDataSet(pieChartList);
                        if (flView != null) {
                            flView.removeAllViews();
                            flView.addView(view);
                        }
                        if (rs.getResult().size() == 0) {
                           rlNotData.setVisibility(View.VISIBLE);
                            tvNot.setText("没有结果显示");
                        }else {
                            rlNotData.setVisibility(View.GONE);

                        }
                    }
                });
            }

        });
    }

}

