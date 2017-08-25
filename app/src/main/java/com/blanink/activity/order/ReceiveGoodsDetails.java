package com.blanink.activity.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.AttachmentBrow;
import com.blanink.utils.StringToListUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 发货详情
 */
public class ReceiveGoodsDetails extends AppCompatActivity {


    @BindView(R.id.come_order)
    TextView comeOrder;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order_detail_rl)
    RelativeLayout comeOrderDetailRl;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.proCateGory)
    TextView proCateGory;
    @BindView(R.id.order_detail_ll_proCateGory)
    LinearLayout orderDetailLlProCateGory;
    @BindView(R.id.tv_ruler)
    TextView tvRuler;
    @BindView(R.id.product_name)
    TextView productName;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.target)
    TextView target;
    @BindView(R.id.tv_target)
    TextView tvTarget;
    @BindView(R.id.deliver)
    TextView deliver;
    @BindView(R.id.tv_deliver)
    TextView tvDeliver;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.tv_sender)
    TextView tvSender;
    @BindView(R.id.tv_sender_name)
    TextView tvSenderName;
    @BindView(R.id.order_detail_rl3)
    LinearLayout orderDetailRl3;
    @BindView(R.id.tv_endDateHand)
    TextView tvEndDateHand;
    @BindView(R.id.deliveryTime)
    TextView deliveryTime;
    @BindView(R.id.time)
    RelativeLayout time;
    @BindView(R.id.attactment)
    TextView attactment;
    @BindView(R.id.tv_attactment)
    TextView tvAttactment;
    @BindView(R.id.rl_down)
    LinearLayout rlDown;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.order_detail_tv_note)
    TextView orderDetailTvNote;
    @BindView(R.id.order_detail_ll_note)
    LinearLayout orderDetailLlNote;
    @BindView(R.id.bt_receive)
    Button btReceive;
    @BindView(R.id.bt_refuse)
    Button btRefuse;
    @BindView(R.id.activity_come_order_product_detail)
    RelativeLayout activityComeOrderProductDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_goods_details);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        productName.setText(getIntent().getStringExtra("productName"));
        proCateGory.setText(getIntent().getStringExtra("companyCateGory"));
        tvSenderName.setText(getIntent().getStringExtra("senderName"));
        tvDeliver.setText(getIntent().getIntExtra("achieveAmount", 0) + "");
        deliveryTime.setText(getIntent().getStringExtra("sendTime"));
        orderDetailTvNote.setText(getIntent().getStringExtra("remarks"));
        tvTarget.setText(getIntent().getIntExtra("target", 0) + "");
        List<String> arrayList = null;
        if (getIntent().getStringExtra("images") != null && getIntent().getStringExtra("images") != "" && !"".equals(getIntent().getStringExtra("images"))) {
            arrayList = StringToListUtils.stringToList(getIntent().getStringExtra("images"), ",");
        } else {
            arrayList = new ArrayList<>();
        }


        final List<String> finalArrayList = arrayList;
        if (finalArrayList.size() == 0) {
            tvAttactment.setText("无附件");
        } else {
            // final List<String> stringList = StringToListUtils.stringToList(getIntent().getStringExtra("images"), ",");
            tvAttactment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ReceiveGoodsDetails.this, AttachmentBrow.class);
                    intent.putExtra("imageList", new Gson().toJson(finalArrayList));
                    startActivity(intent);
                }
            });
        }
    }
}