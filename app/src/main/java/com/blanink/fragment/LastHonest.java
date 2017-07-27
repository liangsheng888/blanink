package com.blanink.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.SingleCustomer;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2017/2/9.
 */

/***
 * 上家 公司信息 诚信档案
 */
public class LastHonest extends Fragment {
    private TextView tv_company_credit;
    private TextView other_remark;
    private TextView tv_service;
    private TextView tv_quality;
    private TextView tv_efficiency;
    private TextView tv_cost_content;
    private TextView tv_satisfy_content;
    private TextView tv_remark;
    private TextView tv_service_content;
    private TextView tv_quality_content;
    private TextView tv_efficiency_content;
    private TextView tv_cost_content2;
    private TextView tv_pay_time_content;
    private SharedPreferences sp;
    private String companyId;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        companyId = getActivity().getIntent().getStringExtra("companyA.id");
        Log.e("Company","LastHonest companyId"+companyId);
        View view=View.inflate(getActivity(), R.layout.layout_cmpany_honest,null);
        initView(view);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sp=getActivity().getSharedPreferences("DATA",getActivity().MODE_PRIVATE);

        initData();
    }

    private void initData() {
        loadData();
    }


    private void initView(View view) {
        tv_company_credit = ((TextView) view.findViewById(R.id.tv_company_credit));//公司信誉
        other_remark = ((TextView) view.findViewById(R.id.tv_other_remark));//他评
        tv_service = ((TextView) view.findViewById(R.id.tv_service));//他评服务
        tv_quality = ((TextView) view.findViewById(R.id.tv_quality));//他评质量
        tv_efficiency = ((TextView) view.findViewById(R.id.tv_efficiency));//他评时效
        tv_cost_content = ((TextView) view.findViewById(R.id.tv_cost_content));//他评成本
        tv_satisfy_content = ((TextView) view.findViewById(R.id.tv_satisfy_content));//他评满意度
        tv_remark = ((TextView) view.findViewById(R.id.tv_remark));//自评
        tv_service_content = ((TextView) view.findViewById(R.id.tv_service_content));//自评 服务
        tv_quality_content = ((TextView) view.findViewById(R.id.tv_quality_content));//自评 质量
        tv_efficiency_content = ((TextView) view.findViewById(R.id.tv_efficiency_content));//自评时效
        tv_cost_content2 = ((TextView) view.findViewById(R.id.tv_cost_content2));//自评成本
        tv_pay_time_content = ((TextView) view.findViewById(R.id.tv_pay_time_content));//自评 付款及时性
    }

    private void loadData() {
        RequestParams rp=new RequestParams(NetUrlUtils.NET_URL+"customer/companyAreview");
        rp.addBodyParameter("userId",sp.getString("USER_ID",null));
        rp.addBodyParameter("companyA.id",companyId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("LastHonest","result"+result);
                Gson gson=new Gson();
                SingleCustomer review=gson.fromJson(result, SingleCustomer.class);
                Log.e("LastHonest","review:"+review.toString());
                other_remark.setText(review.result.reviewOthers==null?"0":review.result.reviewOthers+"");
                tv_service.setText(review.result.otherService==null?"0":review.result.otherService+"");
                tv_quality.setText(review.result.otherQuality==null?"0":review.result.otherQuality+"");
                tv_efficiency.setText(review.result.otherTime==null?"0":review.result.otherTime+"");
                tv_cost_content.setText(review.result.otherCosting==null?"0":review.result.otherCosting+"");
                tv_satisfy_content.setText(review.result.otherPayment==null?"0":review.result.otherPayment+"");
                //自评
                tv_remark.setText(review.result.reviewSelf==null?"0":review.result.reviewSelf+"");
                tv_service_content.setText(review.result.selfService==null?"0":review.result.selfService+"");
                tv_quality_content.setText(review.result.selfQuality==null?"0":review.result.selfQuality+"");
                tv_efficiency_content.setText(review.result.selfTime==null?"0":review.result.selfTime+"");
                tv_cost_content2.setText(review.result.selfCosting==null?"0":review.result.selfCosting+"");
                tv_pay_time_content.setText(review.result.selfPayment==null?"0":review.result.selfPayment+"");
                tv_company_credit.setText((review.result.reviewOthers+review.result.reviewSelf)/2.0+"");


            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }

}
