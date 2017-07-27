package com.blanink.activity.remark;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.ProductReview;
import com.blanink.pojo.ResponseDelete;
import com.blanink.pojo.ResponseOrder;
import com.blanink.pojo.ReviewReply;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.KeyMapDialogFlow;
import com.blanink.view.NoScrollListview;
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

public class RemarkReview extends AppCompatActivity {

    @BindView(R.id.tv_last)
    TextView tvLast;
    @BindView(R.id.rl_review)
    RelativeLayout rlReview;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv_end_date)
    TextView tvEndDate;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.product_category)
    TextView productCategory;
    @BindView(R.id.tv_product)
    TextView tvProduct;
    @BindView(R.id.rl_category)
    RelativeLayout rlCategory;
    @BindView(R.id.require)
    TextView require;
    @BindView(R.id.tv_productSn)
    TextView tvProductSn;
    @BindView(R.id.rl_product)
    LinearLayout rlProduct;
    @BindView(R.id.product_ruler)
    TextView productRuler;
    @BindView(R.id.tv_product_ruler)
    TextView tvProductRuler;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.honest)
    TextView honest;
    @BindView(R.id.tv_honest)
    TextView tvHonest;
    @BindView(R.id.pay)
    TextView pay;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.att)
    TextView att;
    @BindView(R.id.tv_att)
    TextView tvAtt;
    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;
    @BindView(R.id.tv_master)
    TextView tvMaster;
    @BindView(R.id.tv_remark_time)
    TextView tvRemarkTime;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.lv_review)
    NoScrollListview lvReview;
    @BindView(R.id.tv_review_other)
    TextView tvReviewOther;
    @BindView(R.id.cost)
    TextView cost;
    @BindView(R.id.tv_cost)
    TextView tvCost;
    @BindView(R.id.ect)
    TextView ect;
    @BindView(R.id.tv_ect)
    TextView tvEct;
    @BindView(R.id.quantity)
    TextView quantity;
    @BindView(R.id.tv_quantity)
    TextView tvQuantity;
    @BindView(R.id.service)
    TextView service;
    @BindView(R.id.tv_service)
    TextView tvService;
    @BindView(R.id.tv_company_name_self)
    TextView tvCompanyNameSelf;
    @BindView(R.id.tv_master_self)
    TextView tvMasterSelf;
    @BindView(R.id.tv_remark_time_self)
    TextView tvRemarkTimeSelf;
    @BindView(R.id.tv_content_self)
    TextView tvContentSelf;
    @BindView(R.id.lv_review_self)
    NoScrollListview lvReviewSelf;
    @BindView(R.id.tv_review_self)
    TextView tvReviewSelf;
    @BindView(R.id.activity_review_detail)
    RelativeLayout activityReviewDetail;
    @BindView(R.id.iv_other)
    ImageView ivOther;
    @BindView(R.id.iv)
    ImageView iv;
    private SharedPreferences sp;
    private ReviewReply rr;
    private KeyMapDialogFlow dialogFlow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remark_review);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvEndDate.setText(getIntent().getStringExtra("deliverTime"));
        tvProduct.setText(getIntent().getStringExtra("productName"));
        tvProductRuler.setText(getIntent().getStringExtra("productCategory"));
        tvNum.setText(getIntent().getStringExtra("amount"));
        tvProductSn.setText(getIntent().getStringExtra("productSo"));
        getRemarkInfo();
        getRemarkReply();
        tvReviewOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  dialogFlow = new KeyMapDialogFlow("去回复", new KeyMapDialogFlow.SendBackListener() {
                    @Override
                    public void sendBack(String inputText) {
                        saveReview(rr.getResult().get(0).getId(),inputText);
                    }
                });
                dialogFlow.show(getSupportFragmentManager(), "dialog");

            }
        });

        tvReviewSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   dialogFlow = new KeyMapDialogFlow("去回复", new KeyMapDialogFlow.SendBackListener() {
                    @Override
                    public void sendBack(String inputText) {
                        saveReview(rr.getResult().get(1).getId(),inputText);

                    }
                });
                dialogFlow.show(getSupportFragmentManager(), "dialog");
            }
        });
    }

    //得到评论回复信息
    private void getRemarkReply() {
        String url = NetUrlUtils.NET_URL + "review/getReview";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("order.id", getIntent().getStringExtra("orderId")).add("company.id", sp.getString("COMPANY_ID", null)).
                add("orderProduct.id", getIntent().getStringExtra("orderProductId")).build();
        Log.e("RemarkReview", url + "?order.id=" + getIntent().getStringExtra("orderId") + "&company.id=" + sp.getString("COMPANY_ID", null) + "&orderProduct.id=" + getIntent().getStringExtra("orderProductId"));

        Request re = new Request.Builder().post(body).url(url).build();
        ok.newCall(re).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                rr = gson.fromJson(json, ReviewReply.class);
                Log.e("RemarkReview", rr.toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (rr.getResult().size() > 0) {
                            lvReview.setAdapter(new CommonAdapter<ReviewReply.ResultBean.ReviewReplyListBean>(RemarkReview.this, rr.getResult().get(0).getReviewReplyList(), R.layout.item_review_detail) {
                                @Override
                                public void convert(ViewHolder viewHolder, ReviewReply.ResultBean.ReviewReplyListBean reviewReplyListBean, int position) {
                                    reviewReplyListBean = rr.getResult().get(0).getReviewReplyList().get(position);
                                    ImageView iv = viewHolder.getViewById(R.id.iv);
                                    TextView tv_company = viewHolder.getViewById(R.id.tv_company);
                                    TextView tv_review_content = viewHolder.getViewById(R.id.tv_review_content);
                                    TextView tv_time = viewHolder.getViewById(R.id.tv_time);
                                    GlideUtils.glideImageView(RemarkReview.this, iv, reviewReplyListBean.getCompany().getPhoto(),true);
                                    tv_company.setText(reviewReplyListBean.getCompany().getName());
                                    tv_review_content.setText(reviewReplyListBean.getContents());
                                    tv_time.setText(reviewReplyListBean.getCreateDate());

                                }
                            });
                            lvReviewSelf.setAdapter(new CommonAdapter<ReviewReply.ResultBean.ReviewReplyListBean>(RemarkReview.this, rr.getResult().get(1).getReviewReplyList(), R.layout.item_review_detail) {
                                @Override
                                public void convert(ViewHolder viewHolder, ReviewReply.ResultBean.ReviewReplyListBean reviewReplyListBean, int position) {
                                    reviewReplyListBean = rr.getResult().get(0).getReviewReplyList().get(position);
                                    ImageView iv = viewHolder.getViewById(R.id.iv);
                                    TextView tv_company = viewHolder.getViewById(R.id.tv_company);

                                    TextView tv_review_content = viewHolder.getViewById(R.id.tv_review_content);
                                    TextView tv_time = viewHolder.getViewById(R.id.tv_time);
                                    GlideUtils.glideImageView(RemarkReview.this, iv, reviewReplyListBean.getCompany().getPhoto(), true);
                                    tv_company.setText(reviewReplyListBean.getCompany().getName());
                                    tv_review_content.setText(reviewReplyListBean.getContents());
                                    tv_time.setText(reviewReplyListBean.getCreateDate());
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    //得到评论
    private void getRemarkInfo() {
        String url = NetUrlUtils.NET_URL + "review/getOrderProductReview";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("order.id", getIntent().getStringExtra("orderId")).add("company.id", sp.getString("COMPANY_ID", null)).
                add("orderProduct.id", getIntent().getStringExtra("orderProductId")).build();
        Log.e("RemarkReview", url + "?order.id=" + getIntent().getStringExtra("orderId") + "&company.id=" + sp.getString("COMPANY_ID", null) + "&orderProduct.id=" + getIntent().getStringExtra("orderProductId"));

        Request re = new Request.Builder().post(body).url(url).build();
        ok.newCall(re).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                final ProductReview review = gson.fromJson(json, ProductReview.class);
                Log.e("RemarkReview", review.toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (review.getResult().getComments() != null) {
                            tvHonest.setText(review.getResult().getComments().getIntegrityGrade());
                            tvPay.setText(review.getResult().getComments().getPaymentGrade());
                            tvAtt.setText(review.getResult().getComments().getServiceGrade());
                            tvContent.setText(review.getResult().getComments().getContents());
                            tvCompanyName.setText(review.getResult().getComments().getCompany().getName());
                            tvRemarkTime.setText(review.getResult().getComments().getCreateDate());
                            GlideUtils.glideCornerImageView(RemarkReview.this, ivOther, review.getResult().getComments().getCompany().getPhoto());
                        }
                        if (review.getResult().getReview() != null) {
                            tvCost.setText(review.getResult().getReview().getCostingGrade());
                            tvEct.setText(review.getResult().getReview().getTimingGrade());
                            tvQuantity.setText(review.getResult().getReview().getQualityGrade());
                            tvService.setText(review.getResult().getReview().getServiceGrade());
                            tvRemarkTimeSelf.setText(review.getResult().getReview().getCreateDate());
                            tvContentSelf.setText(review.getResult().getReview().getContents());
                            tvCompanyNameSelf.setText(review.getResult().getReview().getCompany().getName());
                            GlideUtils.glideCornerImageView(RemarkReview.this, iv, review.getResult().getReview().getCompany().getPhoto());
                        }
                    }
                });
            }
        });
    }

    public void saveReview(String id, String content) {
        //http://192.168.199.147:8080/blanink-api/review/saveReview?
        // review.id=8ec30bdae2894f09b8825fde3d791af1&
        // contents=ssssss&
        // company.id=f541afa391974409ba680e9bd9a394fd&
        // currentUser.id=447e4526d22045f59ed58250046b3842
        String url = NetUrlUtils.NET_URL + "review/saveReview";
        Log.e("RemarkReview",id);
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("review.id", id)
                .add("contents", content)
                .add("company.id",sp.getString("COMPANY_ID",null))
                .add("currentUser.id",sp.getString("USER_ID",null))
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
             runOnUiThread(new Runnable() {
                 @Override
                 public void run() {
                     runOnUiThread(new Runnable() {
                         @Override
                         public void run() {
                             dialogFlow.hideProgressdialog();
                             Toast.makeText(RemarkReview.this, "服务器异常", Toast.LENGTH_SHORT).show();
                         }
                     });

                 }
             });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Log.e("RemarkReview",result.toString());
                Gson gson = new Gson();
                final ResponseDelete re = gson.fromJson(result, ResponseDelete.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if("00000".equals(re.getErrorCode())){
                            dialogFlow.hideProgressdialog();
                            dialogFlow.dismiss();
                            getRemarkReply();
                        }else {
                            dialogFlow.hideProgressdialog();
                            Toast.makeText(RemarkReview.this, "回复失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}
