package com.blanink.activity.report;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.MyPagerList;
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
    @BindView(R.id.pager)
    MyViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_type);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        List<String> picLis=new ArrayList<>();
        picLis.add("http://b.hiphotos.baidu.com/image/pic/item/d01373f082025aaf95bdf7e4f8edab64034f1a15.jpg");
        picLis.add("http://g.hiphotos.baidu.com/image/pic/item/6159252dd42a2834da6660c459b5c9ea14cebf39.jpg");
        picLis.add("http://d.hiphotos.baidu.com/image/pic/item/adaf2edda3cc7cd976427f6c3901213fb80e911c.jpg");
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
                intent.putExtra("url", NetUrlUtils.NET_URL+"report/saleDataList");
                intent.putExtra("name","销售额分析");
                startActivity(intent);
            }
        });

        tvCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportType.this, CostAmountAnalysis.class);
                intent.putExtra("name","成本分析");
                startActivity(intent);
            }
        });
    }
}
