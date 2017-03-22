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
import com.blanink.activity.order.ComeOrderActivity;
import com.blanink.activity.order.GoOrderPurchase;
import com.blanink.activity.task.TaskResponseQueue;
import com.blanink.activity.bidTender.TenderPublish;

/**
 * Created by Administrator on 2017/1/7.
 */
public class CommanUserFragment extends Fragment implements View.OnClickListener {
    private TextView tv_fr_come_order;
    private TextView tv_fr_go_order;
    private TextView tv_fr_task_response;
    private TextView tv_fr_tender;
    private TextView tv_fr_bid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View  view=View.inflate(getActivity(), R.layout.fragment_fisrt_page,null);
          initView(view);
        return view;

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }
    private void initView(View view) {
        tv_fr_come_order = ((TextView) view.findViewById(R.id.tv_fr_come_order));
        tv_fr_go_order = ((TextView) view.findViewById(R.id.tv_fr_go_order));
        tv_fr_task_response = ((TextView) view.findViewById(R.id.tv_fr_task_response));
        tv_fr_tender = ((TextView) view.findViewById(R.id.tv_fr_tender));
        tv_fr_bid = ((TextView) view.findViewById(R.id.tv_fr_bid));


    }
    private void initData() {
        tv_fr_come_order.setOnClickListener(this);
        tv_fr_go_order.setOnClickListener(this);
        tv_fr_task_response.setOnClickListener(this);
        tv_fr_tender.setOnClickListener(this);
        tv_fr_bid.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //招标
            case R.id.tv_fr_tender:
                Intent intentTender=new Intent(getActivity(),TenderPublish.class);
                startActivity(intentTender);
                break;
            //投标
            case R.id.tv_fr_bid:
                Intent intentBid=new Intent(getActivity(), BidAccordWithTender.class);
                startActivity(intentBid);
                break;
            //来单
            case R.id.tv_fr_come_order:
                Intent intent=new Intent(getActivity(), ComeOrderActivity.class);
                startActivity(intent);
                break;
            //去单
            case R.id.tv_fr_go_order:
                Intent intentGoOrder =new Intent(getActivity(), GoOrderPurchase.class);
                startActivity(intentGoOrder);
                break;
            //工作反馈
            case R.id.tv_fr_task_response:
                Intent intentTaskResponse =new Intent(getActivity(), TaskResponseQueue.class);
                startActivity(intentTaskResponse);
                break;
        }

    }
}
