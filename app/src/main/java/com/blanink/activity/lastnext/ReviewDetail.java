package com.blanink.activity.lastnext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.AllReview;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.view.NoScrollListview;

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
    @BindView(R.id.rl)
    RelativeLayout rl;
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
    @BindView(R.id.iv)
    ImageView iv;
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
        tvNum.setText(reviewDetail.getOrderProduct().getAmount());
        tvHonest.setText(reviewDetail.getIntegrityGrade());
        tvPay.setText(reviewDetail.getPaymentGrade());
        tvAtt.setText(reviewDetail.getServiceGrade());
        tvContent.setText(reviewDetail.getContents());
        tvCompanyName.setText(reviewDetail.getOrder().getACompany().getName());
        tvRemarkTime.setText(reviewDetail.getCreateDate());
        GlideUtils.glideImageView(ReviewDetail.this, iv, reviewDetail.getCreateBy().getPhoto(), true);

        tvMaster.setText(reviewDetail.getOrder().getACompany().getMaster());
       // tvEndDate.setText(reviewDetail.getOrder().getDelieverTimeString());
        lvReview.setAdapter(new CommonAdapter<AllReview.ResultBean.RowsBean.ReviewReplyListBean>(this, reviewDetail.getReviewReplyList(), R.layout.item_review_detail) {
            @Override
            public void convert(ViewHolder viewHolder, AllReview.ResultBean.RowsBean.ReviewReplyListBean reviewReplyListBean, int position) {
                reviewReplyListBean = reviewDetail.getReviewReplyList().get(position);
                TextView company = viewHolder.getViewById(R.id.tv_company);
                TextView reviewtime = viewHolder.getViewById(R.id.tv_time);
                TextView content = viewHolder.getViewById(R.id.tv_review_content);
                ImageView iv = viewHolder.getViewById(R.id.iv);

                company.setText(reviewReplyListBean.getCompany().getName());
                reviewtime.setText(reviewReplyListBean.getCreateDate());
                content.setText(reviewReplyListBean.getContents());
                GlideUtils.glideImageView(ReviewDetail.this, iv, reviewReplyListBean.getCompany().getPhoto(), true);
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
