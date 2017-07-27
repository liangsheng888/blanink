package com.blanink.activity.order;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.OrderTalkNoteAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.OrderProductRemark;
import com.blanink.pojo.Response;
import com.blanink.utils.DateUtils;
import com.blanink.view.KeyMapDialog;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.XUtilsImageUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 沟通记录
 */
public class ComeOrderProductDetailTalkNote extends AppCompatActivity {


    @BindView(R.id.tv_last)
    TextView tvLast;
    @BindView(R.id.rl_after_sale_demand)
    RelativeLayout rlAfterSaleDemand;
    @BindView(R.id.lv_comments)
    ListView lvComments;
    @BindView(R.id.et_message)
    TextView etMessage;
    @BindView(R.id.ly_main_weixin)
    RelativeLayout lyMainWeixin;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.rl_not_data)
    RelativeLayout rlNotData;
    private String productId;
    MyActivityManager instance;
    PopupWindow popupwindow;
    SharedPreferences sp;
    KeyMapDialog dialog;
    private List<OrderProductRemark.ResultBean> remarkList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_order_product_detail_talk_note);
        instance = MyActivityManager.getInstance();
        instance.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        //接受从ComeOrderProductDetail 传递过来的数据
        Intent intent = getIntent();
        productId = intent.getStringExtra("productId");
        //加载历史沟通记录
        loadCommentsRecords();
        tvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        etMessage.clearFocus();
        etMessage.setCursorVisible(false);
        //弹出发送按钮
        etMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = new KeyMapDialog("发表评论：", new KeyMapDialog.SendBackListener() {
                    @Override
                    public void sendBack(String inputText, String type) {

                        sendNotify(inputText, type);
                    }

                });

                dialog.show(getSupportFragmentManager(), "dialog");
            }


        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance.popOneActivity(this);
    }

    public void loadCommentsRecords() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/viewComments");
        rp.addBodyParameter("id", productId);
        rp.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("companyId", sp.getString("COMPANY_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(final String result) {
                Log.e("ComeOrderProduct", result);
                Gson gson = new Gson();
                remarkList.clear();
                final OrderProductRemark remark = gson.fromJson(result, OrderProductRemark.class);
                remarkList.addAll(remark.getResult());
                lvComments.setAdapter(new OrderTalkNoteAdapter(ComeOrderProductDetailTalkNote.this,remarkList));
                if (remark.getResult().size() == 0) {
                    rlNotData.setVisibility(View.VISIBLE);
                } else {
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


    private void sendNotify(String s, String type) {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/sendComments");
        rp.addBodyParameter("orderProduct.id", productId);
        rp.addBodyParameter("comments", s);
        rp.addBodyParameter("sender.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("senderCompany.id", sp.getString("COMPANY_ID", null));
        rp.addBodyParameter("type", type);


        // http://localhost:8080/blanink-api/order/sendComments?orderProduct.id=13ca69d4c53c4a7c8185f5929cbc93b5
        //&comments=dddddd&sender.id=3c70d715d02a4c4aadc1952ecde286e1&senderCompany.id=9ce7467e94884e7192a14ad3c29c554d&type=1

        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(final String result) {
                Log.e("ComeOrderProduct", result);
                Gson gson = new Gson();
                Response re = gson.fromJson(result, Response.class);
                if ("00000".equals(re.getErrorCode())) {
                    dialog.hideProgressdialog();
                    dialog.dismiss();
                    loadCommentsRecords();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Toast.makeText(ComeOrderProductDetailTalkNote.this, "服务器异常", Toast.LENGTH_SHORT).show();

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
