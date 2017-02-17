package com.blanink.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blanink.R;
import com.blanink.activity.LastFamilyManageCustomerApply;
import com.blanink.activity.LastFamilyManageCustomerApplyDelete;
import com.blanink.bean.ManyCustomer;
import com.blanink.bean.SingleCustomer;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/2/9.
 */

/***
 * 上家 我的客户详细信息
 */
public class LastCustomerInfo extends Fragment {

    private static final String TAG ="LastCustomerInfo" ;
    private SharedPreferences sp;
    private String id;
    private ManyCustomer.Result.CompanyA companyA;
    private TextView tv_company;
    private TextView tv_address;
    private TextView tv_master;
    private TextView tv_phone;
    private TextView tv_major_content;
    private TextView tv_company_address;
    private TextView tv_introduce;
    private TextView tv_finished_order_num;
    private Button btn_state;
    private Button btn_consult;
    private SingleCustomer info;
    private TextView tv_company_xin_yu;
    private TextView tv_company_remark;
    private TextView tv_company_other_remark;
    private LinearLayout ll_talk;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
        Intent intent = getActivity().getIntent();
        id = intent.getStringExtra("companyId");
        View view = View.inflate(getActivity(), R.layout.fragment_company_info, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tv_company = ((TextView) view.findViewById(R.id.tv_company));
        tv_address = ((TextView) view.findViewById(R.id.tv_address));
        tv_master = ((TextView) view.findViewById(R.id.tv_major_person));//负责人
        tv_phone = ((TextView) view.findViewById(R.id.tv_phone));//手机
        tv_major_content = ((TextView) view.findViewById(R.id.tv_major_content));//主营
        tv_company_address = ((TextView) view.findViewById(R.id.tv_company_address));//详细地址
        tv_introduce = ((TextView) view.findViewById(R.id.tv_introduce));//公司简介
        tv_finished_order_num = ((TextView) view.findViewById(R.id.tv_finished_order_num));//已完成订单数
        tv_company_xin_yu = ((TextView) view.findViewById(R.id.tv_company_xin_yu));//公司信誉
        tv_company_remark = ((TextView) view.findViewById(R.id.tv_company_remark));//自评
        tv_company_other_remark = ((TextView) view.findViewById(R.id.tv_company_other_remark));//他评
        btn_state = ((Button) view.findViewById(R.id.btn_state));//申请合作/解除合作
        btn_consult = ((Button) view.findViewById(R.id.btn_consult));//在线咨询
        ll_talk = ((LinearLayout) view.findViewById(R.id.ll_talk));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        //从服务器中获取数据
        getData();
        //
        btn_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //申请合作、解除关系
                if ("1".equals(info.getResult().getType())) {
                    Intent intent = new Intent(getActivity(), LastFamilyManageCustomerApplyDelete.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("info", info);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getActivity(), LastFamilyManageCustomerApply.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("info", info);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });
    }

    //
    public void getData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "customer/info");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("id", id);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "url+++++++" + NetUrlUtils.NET_URL + "customer/info?userId=" + sp.getString("USER_ID", null) + "&id=" + id);
                Log.e(TAG, "result+++++++" + result);
                Gson gson = new Gson();
                info = gson.fromJson(result, SingleCustomer.class);
                Log.e(TAG, "info+++++++" + info.toString());
                companyA = info.getResult().getCompanyA();
                Log.e(TAG, "companyA+++++++" + companyA.toString());
                if (companyA.getCreateCompanyBy() != null) {
                    //如果该客户是虚拟客户
                    ll_talk.setVisibility(View.GONE);
                }
                //界面设置
                tv_company.setText(companyA.getName());
                tv_address.setText(companyA.getAddress());
                tv_master.setText(companyA.getMaster());
                tv_phone.setText(companyA.getPhone());
                tv_major_content.setText(companyA.getScope());
                tv_company_address.setText(companyA.getAddress());
                tv_introduce.setText(companyA.getRemarks());
                DecimalFormat df = new DecimalFormat("0.0");
                tv_company_remark.setText(info.getResult().getComeOrderSelfRated() + "");
                tv_company_other_remark.setText(info.getResult().getComeOrderOthersRated() + "");
                tv_company_xin_yu.setText(df.format((info.getResult().getComeOrderSelfRated() + info.getResult().getComeOrderOthersRated()) / 2.0));
                //
                Log.e(TAG, "type:" + info.getResult().getType());
                if ("1".equals(info.getResult().getType())) {
                    btn_state.setText("解除关系");
                } else {
                    btn_state.setText("申请合作");
                }
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
