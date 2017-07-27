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
import com.blanink.activity.EaseChat.EaseChatActivity;
import com.blanink.activity.lastNext.NextFamilyManageSupplierManageApplyCooperate;
import com.blanink.activity.lastNext.NextFamilyManageSupplierManageApplyDelete;
import com.blanink.pojo.ManyCustomer;
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
 * Created by Administrator on 2017/2/9.
 * 下家 公司详情
 */
public class NextPartnerInfo extends Fragment {
    public static final String TAG = "NextPartnerInfo";
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_company_xin)
    TextView tvCompanyXin;
    @BindView(R.id.tv_company_xin_yu)
    TextView tvCompanyXinYu;
    @BindView(R.id.tv_major)
    TextView tvMajor;
    @BindView(R.id.tv_major_person)
    TextView tvMajorPerson;
    @BindView(R.id.tv_company_zi_remark)
    TextView tvCompanyZiRemark;
    @BindView(R.id.tv_company_remark)
    TextView tvCompanyRemark;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_company_remark_other)
    TextView tvCompanyRemarkOther;
    @BindView(R.id.tv_company_other_remark)
    TextView tvCompanyOtherRemark;
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
    @BindView(R.id.lv_order_info)
    NoScrollListview lvOrderInfo;
    @BindView(R.id.company_info)
    LinearLayout companyInfo;

    @BindView(R.id.btn_chat)
    Button btnChat;
    @BindView(R.id.ll_talk)
    LinearLayout llTalk;
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
    private ManyCustomer.Result.Customer suppliers;
    private SharedPreferences sp;
    private String id;
    private ManyCustomer.Result.Company companyB;
    private TextView tv_address;
    private TextView tv_master;
    private TextView tv_phone;
    private TextView tv_major_content;
    private TextView tv_company_address;
    private TextView tv_introduce;
    private SingleCustomer info;
    private Button btn;
    private Button btn_chat;
    private String supplierId;
    private TextView tv_company_xin_yu;
    private TextView tv_company_remark;
    private TextView tv_company_other_remark;
    private TextView tv_customer_num;
    private TextView tv_url;
    private String type;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        id = intent.getStringExtra("companyB.id");
        type = intent.getStringExtra("type");
        Log.e("partner", "NextPartnerInfo  id:" + id);
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
        View view = View.inflate(getActivity(), R.layout.fragment_next_partner_info, null);
        initView(view);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        getData();
        //聊天
        btn_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   //
                // startChat(supplierId);
                Intent intent = new Intent(getActivity(), EaseChatActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("companyB", companyB);
                intent.putExtras(bundle);
                startActivity(intent);*/
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("partner", "NextPartnerInfo  type:" + info.result.getType());
                if ("1".equals(type)) {
                    //跳到解除关系界面
                    Intent intent = new Intent(getActivity(), NextFamilyManageSupplierManageApplyDelete.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("info", info);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    //进到申请界面
                    Intent intent = new Intent(getActivity(), NextFamilyManageSupplierManageApplyCooperate.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("info", info);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }

    public void initView(View view) {
        tv_address = ((TextView) view.findViewById(R.id.tv_address));
        tv_master = ((TextView) view.findViewById(R.id.tv_major_person));//负责人
        tv_phone = ((TextView) view.findViewById(R.id.tv_phone));//手机
        tv_major_content = ((TextView) view.findViewById(R.id.tv_major_content));//主营
        tv_company_address = ((TextView) view.findViewById(R.id.tv_company_address));//详细地址
        tv_introduce = ((TextView) view.findViewById(R.id.tv_introduce));//公司简介
        tv_company_xin_yu = ((TextView) view.findViewById(R.id.tv_company_xin_yu));//公司信誉
        tv_company_remark = ((TextView) view.findViewById(R.id.tv_company_remark));//自评
        tv_company_other_remark = ((TextView) view.findViewById(R.id.tv_company_other_remark));//他评
        tv_url = ((TextView) view.findViewById(R.id.tv_url));
        btn = ((Button) view.findViewById(R.id.btn));//解除关系/申请合作
        btn_chat = ((Button) view.findViewById(R.id.btn_chat));//聊天
    }

    public void getData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "partner/info");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("id", id);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "url+++++++" + NetUrlUtils.NET_URL + "partner/info?userId=" + sp.getString("USER_ID", null) + "&id=" + id);
                Log.e(TAG, "result+++++++" + result);
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                info = gson.fromJson(result, SingleCustomer.class);
                Log.e(TAG, "info+++++++" + info.toString());
                companyB = info.result;
                supplierId = info.result.getId();
                Log.e(TAG, "companyA+++++++" + companyB.toString());
                //界面设置
                if (companyB.getArea() != null) {
                    tv_address.setText(companyB.getArea().getName());
                }
                tv_master.setText(companyB.getMaster());
                tv_phone.setText(companyB.getPhone());
                tv_company_address.setText(companyB.getAddress());
                DecimalFormat df = new DecimalFormat("0.0");
                tv_company_remark.setText(companyB.reviewSelf + "");
                tv_company_other_remark.setText(companyB.reviewOthers + "");
                tv_company_xin_yu.setText(df.format((companyB.reviewSelf + companyB.reviewOthers) / 2.0));
                tv_introduce.setText(companyB.getRemarks());
                tv_url.setText(companyB.homepage);
                if ("1".equals(type)) {
                    btn.setText("已合作,解除关系");
                } else if ("0".equals(type)) {
                    btn.setText("潜在供应商,申请合作");
                } else {
                    btn.setText("申请合作");
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                llLoad.setVisibility(View.GONE);
                //rlLoadFail.setVisibility(View.VISIBLE);
                Log.e("Next", ex.toString());
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

   /* //开启聊天
    private void startChat(String userId) {
        Intent intent = new Intent(getActivity(), EaseChatActivity.class);
        intent.putExtra(EaseConstant.EXTRA_USER_ID, userId);
        intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat);
        startActivity(intent);
    }*/

}
