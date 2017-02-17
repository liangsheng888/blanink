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
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.ConsultActivity;
import com.blanink.activity.NextFamilyManageCompanyDetail;
import com.blanink.activity.NextFamilyManageSupplierManageApplyCooperate;
import com.blanink.activity.NextFamilyManageSupplierManageApplyDelete;
import com.blanink.activity.chat.ChatAcitivity;
import com.blanink.bean.ManyCustomer;
import com.blanink.bean.SingleCustomer;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DecimalFormat;


/**
 * Created by Administrator on 2017/2/9.
 * 下家 公司详情
 */
public class NextPartnerInfo extends Fragment {
    public  static final String TAG="NextPartnerInfo";
    private ManyCustomer.Result.Customer suppliers;
    private SharedPreferences sp;
    private String id;
    private ManyCustomer.Result.CompanyB companyB;
    private TextView tv_company;
    private TextView tv_address;
    private TextView tv_master;
    private TextView tv_phone;
    private TextView tv_major_content;
    private TextView tv_company_address;
    private TextView tv_introduce;
    private TextView tv_finished_order_num;
    private  SingleCustomer info;
    private Button btn;
    private Button btn_chat;
    private String supplierId;
    private TextView tv_company_xin_yu;
    private TextView tv_company_remark;
    private TextView tv_company_other_remark;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent intent=getActivity().getIntent();
        id= intent.getStringExtra("id");
        sp=getActivity().getSharedPreferences("DATA",getActivity().MODE_PRIVATE);
        View view=View.inflate(getActivity(), R.layout.fragment_next_partner_info,null);
        initView(view);
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
                //
              //  startChat(supplierId);
                Intent intent=new Intent(getActivity(),ConsultActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("companyB",companyB);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("1".equals(info.getResult().getType())){
                    //跳到解除关系界面
                    Intent intent =new Intent(getActivity(),NextFamilyManageSupplierManageApplyDelete.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("info",info);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    //进到申请界面
                    Intent intent =new Intent(getActivity(),NextFamilyManageSupplierManageApplyCooperate.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("info",info);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }

    public void initView(View view){
        tv_company = ((TextView) view.findViewById(R.id.tv_company));
        tv_address = ((TextView) view.findViewById(R.id.tv_address));
        tv_master = ((TextView) view.findViewById(R.id.tv_major_person));//负责人
        tv_phone = ((TextView) view.findViewById(R.id.tv_phone));//手机
        tv_major_content = ((TextView) view.findViewById(R.id.tv_major_content));//主营
        tv_company_address = ((TextView) view.findViewById(R.id.tv_company_address));//详细地址
        tv_introduce = ((TextView) view.findViewById(R.id.tv_introduce));//公司简介
        tv_company_xin_yu = ((TextView) view.findViewById(R.id.tv_company_xin_yu));//公司信誉
        tv_company_remark = ((TextView) view.findViewById(R.id.tv_company_remark));//自评
        tv_company_other_remark = ((TextView) view.findViewById(R.id.tv_company_other_remark));//他评
        tv_finished_order_num = ((TextView) view.findViewById(R.id.tv_finished_order_num));//已完成订单数
        btn = ((Button) view.findViewById(R.id.btn));//解除关系/申请合作
        btn_chat = ((Button) view.findViewById(R.id.btn_chat));//聊天
    }
    public void getData(){
        RequestParams rp=new RequestParams(NetUrlUtils.NET_URL+"customer/info");
        rp.addBodyParameter("userId",sp.getString("USER_ID",null));
        rp.addBodyParameter("id",id);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG,"url+++++++"+NetUrlUtils.NET_URL+"customer/info?userId="+sp.getString("USER_ID",null)+"&id="+id);
                Log.e(TAG,"result+++++++"+result);
                Gson gson=new Gson();
                info=gson.fromJson(result, SingleCustomer.class);
                Log.e(TAG,"info+++++++"+info.toString());
                companyB=info.getResult().getCompanyB();
                supplierId=info.getResult().getCompanyB().getId();
                Log.e(TAG,"companyA+++++++"+companyB.toString());

                //界面设置
                tv_company.setText(companyB.getName());
                tv_address.setText(companyB.getArea().getName());
                tv_master.setText(companyB.getMaster());
                tv_phone.setText(companyB.getPhone());
                //tv_major_content.setText(companyB.getScope());
                tv_company_address.setText(companyB.getAddress());
                DecimalFormat df=new DecimalFormat("0.0");
                tv_company_remark.setText(info.getResult().getComeOrderSelfRated()+"");
                tv_company_other_remark.setText(info.getResult().getComeOrderOthersRated()+"");
                tv_company_xin_yu.setText(df.format((info.getResult().getComeOrderSelfRated()+info.getResult().getComeOrderOthersRated())/2.0));
                tv_introduce.setText(companyB.getRemarks());
                if("1".equals(info.getResult().getType())){
                    btn.setText("解除关系");
                }else {
                    btn.setText("申请合作");
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

    //开启聊天
    private void startChat(String userId) {
        Intent intent=new Intent(getActivity(),ChatAcitivity.class);
        intent.putExtra(EaseConstant.EXTRA_USER_ID,userId);
        intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat);
        startActivity(intent);
    }

}
