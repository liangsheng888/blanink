package com.blanink.activity.report;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.view.MyPagerList;

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
    @BindView(R.id.pager)
    MyPagerList pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_type);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        //pager.pictureRoll();
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
                startActivity(intent);
            }
        });
    }
}
