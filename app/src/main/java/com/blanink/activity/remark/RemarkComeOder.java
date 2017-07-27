package com.blanink.activity.remark;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.OrderDetail;
import com.blanink.pojo.ProductReview;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.DialogNotifyUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.MyRatingBar;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/***
 * 评论 来单订单
 */
public class RemarkComeOder extends AppCompatActivity {


    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.come_order_iv_last)
    TextView comeOrderIvLast;
    @BindView(R.id.come_order_rl)
    RelativeLayout comeOrderRl;
    @BindView(R.id.product_name)
    TextView productName;
    @BindView(R.id.tv_product_name)
    TextView tvProductName;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.tv_endTime)
    TextView tvEndTime;
    @BindView(R.id.order_endDate)
    TextView orderEndDate;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.product_remark_ll_time)
    LinearLayout productRemarkLlTime;
    @BindView(R.id.contact)
    TextView contact;
    @BindView(R.id.tv_product_num)
    TextView tvProductNum;
    @BindView(R.id.ll_contact)
    LinearLayout llContact;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.ll_phone)
    LinearLayout llPhone;
    @BindView(R.id.order_detail_rl_ll_time)
    LinearLayout orderDetailRlLlTime;
    @BindView(R.id.tv_note)
    TextView tvNote;
    @BindView(R.id.order_detail_address)
    LinearLayout orderDetailAddress;
    @BindView(R.id.other)
    TextView other;
    @BindView(R.id.tv_service)
    TextView tvService;
    @BindView(R.id.rb_service)
    MyRatingBar rbService;
    @BindView(R.id.tv_satisfy)
    TextView tvSatisfy;
    @BindView(R.id.rb_satisfy)
    MyRatingBar rbSatisfy;
    @BindView(R.id.tv_honest)
    TextView tvHonest;
    @BindView(R.id.rb_honest)
    MyRatingBar rbHonest;
    @BindView(R.id.et_other)
    EditText etOther;
    @BindView(R.id.remark_content)
    LinearLayout remarkContent;
    @BindView(R.id.remark_other)
    RelativeLayout remarkOther;
    @BindView(R.id.tv_remark_self)
    TextView tvRemarkSelf;
    @BindView(R.id.tv_service2)
    TextView tvService2;
    @BindView(R.id.rb_service_self)
    MyRatingBar rbServiceSelf;
    @BindView(R.id.tv_quality_self)
    TextView tvQualitySelf;
    @BindView(R.id.rb_quality_self)
    MyRatingBar rbQualitySelf;
    @BindView(R.id.tv_effective)
    TextView tvEffective;
    @BindView(R.id.rb_effective_self)
    MyRatingBar rbEffectiveSelf;
    @BindView(R.id.tv_cost)
    TextView tvCost;
    @BindView(R.id.rb_cost_self)
    MyRatingBar rbCostSelf;
    @BindView(R.id.et_self)
    EditText etSelf;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.ll_remark_self)
    LinearLayout llRemarkSelf;
    @BindView(R.id.remark_self)
    RelativeLayout remarkSelf;
    @BindView(R.id.activity_remark_come_oder)
    RelativeLayout activityRemarkComeOder;
    private float totalService = 0.0f;
    private float totalServiceSelf = 0.0f;

    private float totalHonest = 0.0f;

    private float totalSatisfy = 0.0f;

    private float totalCostSelf = 0.0f;

    private float totalQualitySelf = 0.0f;

    private float totalEffectiveSelf = 0.0f;
    private float oneGrade = 1;
    private SharedPreferences sp;
    private ProductReview review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remark_come_oder);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        loadRemark();
        tvProductName.setText(getIntent().getStringExtra("productName"));
        tvPrice.setText(getIntent().getStringExtra("price"));
        tvProductNum.setText(getIntent().getStringExtra("amount"));
        orderEndDate.setText(getIntent().getStringExtra("deliverTime"));
        tvNote.setText(getIntent().getStringExtra("productRemarks"));
        comeOrderIvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //态度评分（对方）
        rbService.setOnRatingChangeListener(new MyRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                Log.e("RemarkComeOrder", "星:" + ratingCount);
                totalService = +ratingCount * oneGrade;
            }
        });
        rbHonest.setOnRatingChangeListener(new MyRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                totalHonest = ratingCount * oneGrade;
            }
        });
        rbSatisfy.setOnRatingChangeListener(new MyRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                totalSatisfy = ratingCount * oneGrade;
            }
        });
        //(自我检讨)
        rbServiceSelf.setOnRatingChangeListener(new MyRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                totalServiceSelf = ratingCount * oneGrade;
            }
        });
        rbCostSelf.setOnRatingChangeListener(new MyRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                totalCostSelf = ratingCount * oneGrade;
            }
        });
        rbQualitySelf.setOnRatingChangeListener(new MyRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                totalQualitySelf = ratingCount * oneGrade;

            }
        });
        rbEffectiveSelf.setOnRatingChangeListener(new MyRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                totalEffectiveSelf = ratingCount * oneGrade;

            }
        });
        //保存评价
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strOther = etOther.getText().toString();
                String strSelf = etSelf.getText().toString();
                if (totalService == 0.0f && totalHonest == 0.0f && totalSatisfy == 0.0f && TextUtils.isEmpty(strOther) && totalServiceSelf == 0.0f && totalQualitySelf == 0.0f && totalEffectiveSelf == 0.0f && totalCostSelf == 0.0f && TextUtils.isEmpty(strSelf)) {
                    Toast.makeText(RemarkComeOder.this, "你没有做任何评论操作", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.getInstance(RemarkComeOder.this);
                DialogLoadUtils.showDialogLoad("操作进行中...");
                saveRemarkData(strOther, strSelf);
            }
        });
    }

    private void saveRemarkData(String strOther, String strSelf) {
        String url = NetUrlUtils.NET_URL + "review/orderReviewSave";
        // http://106.14.148.163:8080/blanink-api/review/orderReviewSave?
        // userId=447e4526d22045f59ed58250046b3842
        // &review.serviceGrade
        // &review.qualityGrade
        // &review.timingGrade
        // &review.costingGrade
        // &review.paymentGrade
        // &review.integrityGrade
        // &review.contents
        // &comments.serviceGrade
        // &comments.qualityGrade
        // &comments.timingGrade
        // &comments.costingGrade
        // &comments.paymentGrade
        // &comments.integrityGrade
        // &comments.contents
        // &review.orderProduct.id
        // &comments.orderProduct.id
        OkHttpClient okhttp = new OkHttpClient();
        //如果评论过或者检讨过，再次插入是数据不生效
        if(review.getResult().getComments()!=null){
            totalService=0.0f;
            totalHonest=0.0f;
            totalSatisfy=0.0f;
            strOther="";

        }
        if(review.getResult().getReview()!=null){

            //检讨
            totalServiceSelf=0.0f;
            totalQualitySelf=0.0f;
            totalCostSelf=0.0f;
            totalEffectiveSelf=0.0f;
            strSelf="";
        }
        RequestBody body = new FormBody.Builder()
                .add("review.serviceGrade", totalServiceSelf == 0.0f ? "" : totalServiceSelf + "")
                .add("review.qualityGrade", totalQualitySelf == 0.0f ? "" : totalQualitySelf + "")
                .add("review.costingGrade", totalCostSelf == 0.0f ? "" : totalCostSelf + "")
                .add("review.timingGrade", totalEffectiveSelf == 0.0f ? "" : totalEffectiveSelf + "")
                .add("review.contents", strSelf)
                .add("comments.serviceGrade", totalService == 0.0f ? "" : totalService + "")
                .add("comments.integrityGrade", totalHonest == 0.0f ? "" : totalHonest + "")
                .add("comments.paymentGrade", totalSatisfy == 0.0f ? "" : totalSatisfy + "")
                .add("comments.contents", strOther + "")
                .add("review.order.id", getIntent().getStringExtra("orderId"))
                .add("review.orderProduct.id", getIntent().getStringExtra("orderProductId"))
                .add("comments.order.id", getIntent().getStringExtra("orderId"))
                .add("review.currentUser.id", sp.getString("USER_ID", null))
                .add("comments.currentUser.id", sp.getString("USER_ID", null))
                .add("comments.orderProduct.id", getIntent().getStringExtra("orderProductId"))
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        okhttp.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                DialogLoadUtils.dismissDialog();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                final com.blanink.pojo.Response rp = gson.fromJson(json, com.blanink.pojo.Response.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if ("00000".equals(rp.getErrorCode())) {
                            DialogLoadUtils.dismissDialog();
                            showNotify("保存成功");
                        } else {
                            DialogLoadUtils.dismissDialog();
                        }
                    }
                });
            }
        });
    }

    public void showNotify(String tilte) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_apply_delete_relation);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        WindowManager windowManager = getWindowManager();
        Display d = windowManager.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);
        alertDialog.setCanceledOnTouchOutside(false);
        ((TextView) (window.findViewById(R.id.tv_message))).setText(tilte);
        window.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Intent intent=new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    public void loadRemark() {
        String url = NetUrlUtils.NET_URL + "review/getOrderProductReview";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("order.id", getIntent().getStringExtra("orderId")).add("orderProduct.id", getIntent().getStringExtra("orderProductId")).build();
        Request request = new Request.Builder().url(url).post(body).build();
        Log.e("RemarkComeOrder", url + "?order.id=" + getIntent().getStringExtra("orderId") + "&orderProduct.id=" + getIntent().getStringExtra("orderProductId"));
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                 review = gson.fromJson(result, ProductReview.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (review.getResult().getComments() != null) {
                            rbService.setClickable(false);

                            rbSatisfy.setClickable(false);
                            rbHonest.setClickable(false);
                            etOther.setClickable(false);
                            rbService.setStar(Float.parseFloat(review.getResult().getComments().getServiceGrade()));
                            rbSatisfy.setStar(Float.parseFloat(review.getResult().getComments().getPaymentGrade()));
                            rbHonest.setStar(Float.parseFloat(review.getResult().getComments().getIntegrityGrade()));
                            etOther.setText(review.getResult().getComments().getContents());
                            etOther.setTextColor(getResources().getColor(R.color.colorBlack));
                            etOther.setBackgroundColor(getResources().getColor(R.color.colorBackGround));

                        }
                        if (review.getResult().getReview() != null) {
                            rbEffectiveSelf.setClickable(false);
                            rbQualitySelf.setClickable(false);
                            rbCostSelf.setClickable(false);
                            rbServiceSelf.setClickable(false);
                            etSelf.setEnabled(false);
                            rbEffectiveSelf.setStar(Float.parseFloat(review.getResult().getReview().getTimingGrade()));
                            rbQualitySelf.setStar(Float.parseFloat(review.getResult().getReview().getQualityGrade()));
                            rbServiceSelf.setStar(Float.parseFloat(review.getResult().getReview().getServiceGrade()));
                            rbCostSelf.setStar(Float.parseFloat(review.getResult().getReview().getCostingGrade()));
                            etSelf.setText(review.getResult().getReview().getContents());
                            etSelf.setBackgroundColor(getResources().getColor(R.color.colorBackGround));
                            etSelf.setTextColor(getResources().getColor(R.color.colorBlack));


                        }
                    }
                });
            }
        });

    }
}
