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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.lastNext.LastFamilyManageCustomerApply;
import com.blanink.activity.lastNext.NextFamilyManageSupplierManageApplyCooperate;
import com.blanink.pojo.SingleCustomer;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.NoScrollListview;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/12.
 */
public class CustomerInfo extends Fragment {

    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_company_xin_yu)
    TextView tvCompanyXinYu;
    @BindView(R.id.tv_company_xin)
    TextView tvCompanyXin;
    @BindView(R.id.tv_major)
    TextView tvMajor;
    @BindView(R.id.tv_major_person)
    TextView tvMajorPerson;
    @BindView(R.id.tv_company_remark)
    TextView tvCompanyRemark;
    @BindView(R.id.tv_company_zi_remark)
    TextView tvCompanyZiRemark;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_company_other_remark)
    TextView tvCompanyOtherRemark;
    @BindView(R.id.tv_company_remark_other)
    TextView tvCompanyRemarkOther;
    @BindView(R.id.major)
    TextView major;
    @BindView(R.id.tv_major_content)
    TextView tvMajorContent;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.tv_company_address)
    TextView tvCompanyAddress;
    @BindView(R.id.url)
    TextView url;
    @BindView(R.id.tv_url)
    TextView tvUrl;
    @BindView(R.id.introduce)
    TextView introduce;
    @BindView(R.id.tv_introduce)
    TextView tvIntroduce;
    @BindView(R.id.tv_order_num)
    TextView tvOrderNum;
    @BindView(R.id.tv_finished_order_num)
    TextView tvFinishedOrderNum;
    @BindView(R.id.lv_order_info)
    NoScrollListview lvOrderInfo;
    @BindView(R.id.btn_last)
    Button btnLast;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.btn_consult)
    Button btnConsult;
    @BindView(R.id.ll_talk)
    LinearLayout llTalk;
    @BindView(R.id.company_info)
    LinearLayout companyInfo;
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
    @BindView(R.id.fl_load)
    FrameLayout flLoad;
    private String id;
    private SharedPreferences sp;
    private SingleCustomer info;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_company_deatil_info, null);
        ButterKnife.bind(this, view);
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
        Intent intent = getActivity().getIntent();
        id = intent.getStringExtra("companyId");
        initData();
        return view;
    }

    private void initData() {
        getData();
        //客户
        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LastFamilyManageCustomerApply.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("info", info);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        //供应商
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NextFamilyManageSupplierManageApplyCooperate.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("info", info);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        //咨询
        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void getData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "customer/info");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("id", id);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                info = gson.fromJson(result, SingleCustomer.class);
                //界面设置
                if (info != null) {
                   // tvCompany.setText(info.result.getName());
                    tvCompanyAddress.setText(info.result.getAddress());
                    tvMajorPerson.setText(info.result.getMaster());
                    tvPhone.setText(info.result.getPhone());
                    tvMajorContent.setText(info.result.getScope());
                    tvAddress.setText(info.result.getArea().getName());
                   // tvCustomerNum.setText(info.result.serviceCount + "");
                    tvIntroduce.setText(info.result.getRemarks());
                    DecimalFormat df = new DecimalFormat("0.0");
                    tvCompanyRemark.setText(info.result.reviewSelf + "");
                    tvCompanyOtherRemark.setText(info.result.reviewOthers + "");
                    tvCompanyXinYu.setText((info.result.reviewSelf + info.result.reviewOthers) / 2.0 + "");
                    tvUrl.setText(info.result.homepage);
                    //

                    //如果当前公司是自己所在公司不能进行操作
                    if (sp.getString("COMPANY_ID", null).equals(info.result.getId())) {
                        btnLast.setVisibility(View.GONE);
                        btnConsult.setVisibility(View.GONE);
                        btnNext.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("@@@",ex.toString());
                llLoad.setVisibility(View.GONE);
                rlLoadFail.setVisibility(View.VISIBLE);
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
    }
}
