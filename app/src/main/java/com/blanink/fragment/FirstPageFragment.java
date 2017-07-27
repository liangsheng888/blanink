package com.blanink.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.bidTender.BidAccordWithTender;
import com.blanink.activity.lastNext.LastFamilyManageCustomer;
import com.blanink.activity.lastNext.NextFamilyManageCompanySupplierManage;
import com.blanink.activity.bidTender.TenderPublish;

/**
 * Created by Administrator on 2017/1/7.
 */
public class FirstPageFragment extends Fragment implements View.OnClickListener {
    private TextView tv_fr_come_order;
    private TextView tv_fr_go_order;
    private TextView tv_fr_task_response;
    private TextView tv_fr_tender;
    private TextView tv_fr_bid;
    private TextView tv_last_manage;
    private TextView tv_next_manage;
    private TextView tv_after_sale;
    private TextView tv_financying;
    private TextView tv_workPlan;
    private TextView tv_flow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_fisrt_page, null);
        initView(view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initView(View view) {
        tv_fr_tender = ((TextView) view.findViewById(R.id.tv_fr_tender));
        tv_fr_bid = ((TextView) view.findViewById(R.id.tv_fr_bid));
        tv_last_manage = (TextView) view.findViewById(R.id.tv_last_manage);
        tv_next_manage = ((TextView) view.findViewById(R.id.tv_next_manage));

    }

    private void initData() {

        tv_fr_bid.setOnClickListener(this);
        tv_last_manage.setOnClickListener(this);
        tv_next_manage.setOnClickListener(this);
        tv_fr_tender.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //招标
            case R.id.tv_fr_tender:
                Intent intentTender = new Intent(getActivity(), TenderPublish.class);
                startActivity(intentTender);
                break;
            //投标
            case R.id.tv_fr_bid:
                Intent intentBid = new Intent(getActivity(), BidAccordWithTender.class);
                startActivity(intentBid);
                break;


            //上家管理
            case R.id.tv_last_manage:
                Intent intentLast = new Intent(getActivity(), LastFamilyManageCustomer.class);
                startActivity(intentLast);
                break;

            //下家管理
            case R.id.tv_next_manage:
                Intent intentNext = new Intent(getActivity(), NextFamilyManageCompanySupplierManage.class);
                startActivity(intentNext);
                break;


        }
    }
}