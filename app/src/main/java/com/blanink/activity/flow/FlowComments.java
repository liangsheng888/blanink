package com.blanink.activity.flow;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.FlowRemark;
import com.blanink.pojo.OrderProductRemark;
import com.blanink.pojo.Response;
import com.blanink.utils.DateUtils;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.XUtilsImageUtils;
import com.blanink.view.KeyMapDialogFlow;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 流程 留言
 */
public class FlowComments extends AppCompatActivity {

    @BindView(R.id.tv_last)
    TextView tvLast;
    @BindView(R.id.rl_after_sale_demand)
    RelativeLayout rlAfterSaleDemand;
    @BindView(R.id.et_message)
    TextView etMessage;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.lv_comments)
    ListView lvComments;
    @BindView(R.id.rl_not_data)
    RelativeLayout rlNotData;
    KeyMapDialogFlow dialog;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_comments);
        sp=getSharedPreferences("DATA",MODE_PRIVATE);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        loadComments(getIntent().getStringExtra("flowId"));
        //弹出发送按钮
        etMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = new KeyMapDialogFlow("发表评论：", new KeyMapDialogFlow.SendBackListener() {
                    @Override
                    public void sendBack(String inputText) {
                        sendComments(inputText);
                    }

                });

                dialog.show(getSupportFragmentManager(), "dialog");
            }


        });
    }

    public void sendComments(String remarks) {
        //http://localhost:8080/blanink-api/flow/saveFlowRemark?userId=4856035c527b419a9cf70d856e65c93b&flowRemark.remarks=sunhong&flowRemark.flow.id=123456
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "flow/saveFlowRemark");
        rp.addBodyParameter("userId",sp.getString("USER_ID",null) );
        rp.addBodyParameter("flowRemark.flow.id", getIntent().getStringExtra("flowId"));
        rp.addBodyParameter("flowRemark.remarks", remarks);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Response re = gson.fromJson(result, Response.class);
                if ("00000".equals(re.getErrorCode())) {
                    dialog.hideProgressdialog();
                     dialog.dismiss();
                     loadComments(getIntent().getStringExtra("flowId"));
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                    dialog.dismiss();
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

    public void loadComments(String id) {
        //http://localhost:8080/blanink-api/flow/saveFlowRemark?id=2695060d06604c7e98f007e06592d22b&remarks=ssssss
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "flow/getFlowRemark");
        rp.addBodyParameter("id", id);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                final FlowRemark re = gson.fromJson(result, FlowRemark.class);
                if(re.getResult().getRemaksList().size()==0){
                    rlNotData.setVisibility(View.VISIBLE);
                }
                else {
                    rlNotData.setVisibility(View.GONE);
                }
                lvComments.setAdapter(new CommonAdapter<FlowRemark.ResultBean.RemaksListBean>(FlowComments.this, re.getResult().getRemaksList(), R.layout.item_order_product_remark) {
                    @Override
                    public void convert(ViewHolder viewHolder,FlowRemark.ResultBean.RemaksListBean resultBean, int position) {
                        resultBean = re.getResult().getRemaksList().get(position);
                        ImageView iv = viewHolder.getViewById(R.id.iv_photo);
                        TextView tv_company = viewHolder.getViewById(R.id.tv_company);
                        TextView tv_user = viewHolder.getViewById(R.id.tv_user);
                        TextView tv_time = viewHolder.getViewById(R.id.tv_time);
                        TextView tv_message = viewHolder.getViewById(R.id.tv_message);
                        tv_company.setText(resultBean.getCreateBy().getCompany().getName());
                        tv_user.setText(resultBean.getCreateBy().getName());
                        tv_time.setText(DateUtils.format(DateUtils.stringToDate(resultBean.getCreateDate())));
                        tv_message.setText(resultBean.getRemarks());
                        GlideUtils.glideImageView(FlowComments.this,iv, resultBean.getCreateBy().getCompany().getPhoto(), true);
//                        if(sp.getString("USER_ID",null).equals(resultBean.getCreateBy().getId())){
//                            tv_message.setTextColor(getResources().getColor(R.color.colorAccent));
//                        }
                    }
                });
                if (re.getResult().getRemaksList().size() == 0) {
                    rlNotData.setVisibility(View.VISIBLE);
                }else {
                    rlNotData.setVisibility(View.GONE);
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
