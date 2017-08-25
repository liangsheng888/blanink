package com.blanink.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.SingleCustomer;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.NoScrollGridview;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/2/9.
 * 下家 诚信档案
 */
public class NextHonest extends Fragment {
    @BindView(R.id.tv_other_a)
    TextView tvOtherA;
    @BindView(R.id.tv_other_remark_a)
    TextView tvOtherRemarkA;
    @BindView(R.id.attitude)
    TextView attitude;
    @BindView(R.id.tv_attitude)
    TextView tvAttitude;
    @BindView(R.id.honest_a)
    TextView honestA;
    @BindView(R.id.tv_honest_a)
    TextView tvHonestA;
    @BindView(R.id.pay_satisfy_a)
    TextView paySatisfyA;
    @BindView(R.id.tv_pay_satisfy_a)
    TextView tvPaySatisfyA;
    @BindView(R.id.tv_self_a)
    TextView tvSelfA;
    @BindView(R.id.tv_remark_a)
    TextView tvRemarkA;
    @BindView(R.id.attitude_self)
    TextView attitudeSelf;
    @BindView(R.id.tv_attitude_self)
    TextView tvAttitudeSelf;
    @BindView(R.id.honest_self_a)
    TextView honestSelfA;
    @BindView(R.id.tv_honest_self_a)
    TextView tvHonestSelfA;
    @BindView(R.id.pay_time)
    TextView payTime;
    @BindView(R.id.tv_pay_time_self_a)
    TextView tvPayTimeSelfA;
    @BindView(R.id.generous)
    TextView generous;
    @BindView(R.id.tv_generous)
    TextView tvGenerous;
    @BindView(R.id.tv_other)
    TextView tvOther;
    @BindView(R.id.tv_other_remark)
    TextView tvOtherRemark;
    @BindView(R.id.other_remark)
    RelativeLayout otherRemark;
    @BindView(R.id.service)
    TextView service;
    @BindView(R.id.tv_service)
    TextView tvService;
    @BindView(R.id.rl_service)
    RelativeLayout rlService;
    @BindView(R.id.quality)
    TextView quality;
    @BindView(R.id.tv_quality)
    TextView tvQuality;
    @BindView(R.id.rl_quality)
    RelativeLayout rlQuality;
    @BindView(R.id.efficiency)
    TextView efficiency;
    @BindView(R.id.tv_efficiency)
    TextView tvEfficiency;
    @BindView(R.id.rl_efficiency)
    RelativeLayout rlEfficiency;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv_remark)
    TextView tvRemark;
    @BindView(R.id.remark)
    RelativeLayout remark;
    @BindView(R.id.tv_service2)
    TextView tvService2;
    @BindView(R.id.tv_service_content)
    TextView tvServiceContent;
    @BindView(R.id.rl_service2)
    RelativeLayout rlService2;
    @BindView(R.id.tv_quality2)
    TextView tvQuality2;
    @BindView(R.id.tv_quality_content)
    TextView tvQualityContent;
    @BindView(R.id.rl_quality2)
    RelativeLayout rlQuality2;
    @BindView(R.id.tv_efficiency2)
    TextView tvEfficiency2;
    @BindView(R.id.tv_efficiency_content)
    TextView tvEfficiencyContent;
    @BindView(R.id.rl_efficiency2)
    RelativeLayout rlEfficiency2;
    @BindView(R.id.tv_cost2)
    TextView tvCost2;
    @BindView(R.id.tv_cost_content2)
    TextView tvCostContent2;
    @BindView(R.id.rl_cost2)
    RelativeLayout rlCost2;
    @BindView(R.id.credit)
    LinearLayout credit;
    Unbinder unbinder;
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
        companyId = getActivity().getIntent().getStringExtra("companyId");
        Log.e("partner", "NextHonest companyId" + companyId);
        View view = View.inflate(getActivity(), R.layout.layout_cmpany_honest, null);
        //  initView(view);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);

        // initData();
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
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "customer/companyBreview");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("companyB.id", companyId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("NextHonest", "result" + result);
                Gson gson = new Gson();
                SingleCustomer review = gson.fromJson(result, SingleCustomer.class);
                Log.e("NextHonest", "review:" + review.toString());
                other_remark.setText(review.result.reviewOthers == null ? "0" : review.result.reviewOthers + "");
                tv_service.setText(review.result.otherService == null ? "0" : review.result.otherService + "");
                tv_quality.setText(review.result.otherQuality == null ? "0" : review.result.otherQuality + "");
                tv_efficiency.setText(review.result.otherTime == null ? "0" : review.result.otherTime + "");
                tv_cost_content.setText(review.result.otherCosting == null ? "0" : review.result.otherCosting + "");
                tv_satisfy_content.setText(review.result.otherPayment == null ? "0" : review.result.otherPayment + "");
                //自评
                tv_remark.setText(review.result.reviewSelf == null ? "0" : review.result.reviewSelf + "");
                tv_service_content.setText(review.result.selfService == null ? "0" : review.result.selfService + "");
                tv_quality_content.setText(review.result.selfQuality == null ? "0" : review.result.selfQuality + "");
                tv_efficiency_content.setText(review.result.selfTime == null ? "0" : review.result.selfTime + "");
                tv_cost_content2.setText(review.result.selfCosting == null ? "0" : review.result.selfCosting + "");
                tv_pay_time_content.setText(review.result.selfPayment == null ? "0" : review.result.selfPayment + "");
                DecimalFormat df = new DecimalFormat("0.0");
                tv_company_credit.setText(df.format((review.result.reviewOthers + review.result.reviewSelf) / 2.0));

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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
