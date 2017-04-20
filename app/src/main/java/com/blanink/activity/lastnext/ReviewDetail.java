package com.blanink.activity.lastNext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.AllReview;
import com.blanink.utils.MyActivityManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 来单评价详情
 */
public class ReviewDetail extends AppCompatActivity {

    @BindView(R.id.tv_last)
    TextView tvLast;
    @BindView(R.id.rl_review)
    RelativeLayout rlReview;
    @BindView(R.id.product_category)
    TextView productCategory;
    @BindView(R.id.tv_product)
    TextView tvProduct;
    @BindView(R.id.rl_category)
    RelativeLayout rlCategory;
    @BindView(R.id.product_ruler)
    TextView productRuler;
    @BindView(R.id.tv_product_ruler)
    TextView tvProductRuler;
    @BindView(R.id.rl_product)
    LinearLayout rlProduct;
    @BindView(R.id.require)
    TextView require;
    @BindView(R.id.tv_require)
    TextView tvRequire;
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
    @BindView(R.id.tv_remark_time)
    TextView tvRemarkTime;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_response)
    TextView tvResponse;
    @BindView(R.id.activity_review_detail)
    RelativeLayout activityReviewDetail;
    private MyActivityManager myActivityManager;
    private AllReview.ResultBean.RowsBean reviewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_detail);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        reviewDetail = (AllReview.ResultBean.RowsBean) intent.getExtras().getSerializable("ReviewDetail");
        tvProduct.setText(reviewDetail.getOrderProduct().getProductName());
        tvProductRuler.setText(reviewDetail.getOrderProduct().getCompanyCategory().getName());
        tvRequire.setText(reviewDetail.getOrder().getBCompany().getName());

        tvNum.setText(reviewDetail.getOrderProduct().getAmount());
        tvHonest.setText(reviewDetail.getIntegrityGrade());
        tvPay.setText(reviewDetail.getPaymentGrade());
        tvAtt.setText(reviewDetail.getServiceGrade());
        tvContent.setText(reviewDetail.getContents());
        tvCompanyName.setText(reviewDetail.getOrder().getBCompany().getName());
        tvRemarkTime.setText(reviewDetail.getCreateDate());
        if (reviewDetail.getReviewReplyList().size() > 0) {
            tvResponse.setVisibility(View.VISIBLE);
            tvResponse.setText("查看" + reviewDetail.getReviewReplyList().size() + "条回复");
        }
        tvResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @OnClick(R.id.tv_last)
    public void onClick() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
