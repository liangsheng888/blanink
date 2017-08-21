package com.blanink.activity.report;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.UrlPic;
import com.blanink.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportType extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.table)
    RelativeLayout table;
    @BindView(R.id.tv_sale)
    TextView tvSale;
    @BindView(R.id.tv_cost)
    TextView tvCost;
    @BindView(R.id.pay)
    TextView pay;
    @BindView(R.id.pager)
    MyViewPager pager;
    @BindView(R.id.tv_profit)
    TextView tvProfit;
    @BindView(R.id.tv_loss)
    TextView tvLoss;
    @BindView(R.id.ll)
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_type);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        List<String> picLis = new ArrayList<>();
        picLis.add(UrlPic.pic);
        picLis.add(UrlPic.pic2);
        picLis.add(UrlPic.pic3);
        pager.pictureRoll(picLis);
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportType.this, SaleAmountAnalysis.class);
                intent.putExtra("url", NetUrlUtils.NET_URL + "report/saleDataList");
                intent.putExtra("name", "销售额分析");
                startActivity(intent);
            }
        });

        tvCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportType.this, CostAmountAnalysis.class);
                intent.putExtra("name", "成本分析");
                startActivity(intent);
            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportType.this, PayAmountAnalysis.class);
                startActivity(intent);
            }
        });
        tvProfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportType.this, ProfitAnalysis.class);
                startActivity(intent);
            }
        });

        tvLoss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportType.this, LossAnalysis.class);
                startActivity(intent);
            }
        });
    }
}
