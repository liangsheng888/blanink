package com.blanink.activity.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.OrderDetail;
import com.blanink.view.NoScrollGridview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 订单产品详情
 */
public class ComeOrderProductDetail extends AppCompatActivity {

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
    @BindView(R.id.tv_ruler)
    TextView tvRuler;
    @BindView(R.id.order_detail_ll_proCateGory_ruler)
    TextView orderDetailLlProCateGoryRuler;
    @BindView(R.id.order_detail_ll_proCateGory)
    LinearLayout orderDetailLlProCateGory;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.come_order_detail_single_price)
    TextView comeOrderDetailSinglePrice;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.come_order_detail_tv_num)
    TextView comeOrderDetailTvNum;
    @BindView(R.id.order_detail_rl2)
    LinearLayout orderDetailRl2;
    @BindView(R.id.tv_endDateHand)
    TextView tvEndDateHand;
    @BindView(R.id.come_order_detail_tv_endDateHand)
    TextView comeOrderDetailTvEndDateHand;
    @BindView(R.id.tv_mine_priority)
    TextView tvMinePriority;
    @BindView(R.id.come_order_detail_tv_mine_priority)
    TextView comeOrderDetailTvMinePriority;
    @BindView(R.id.order_detail_rl3)
    LinearLayout orderDetailRl3;
    @BindView(R.id.product_attribute)
    NoScrollGridview productAttribute;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.order_detail_tv_note)
    TextView orderDetailTvNote;
    @BindView(R.id.order_detail_ll_note)
    LinearLayout orderDetailLlNote;
    @BindView(R.id.rl_down)
    RelativeLayout rlDown;
    @BindView(R.id.come_order_detail_lv_fujian_download)
    NoScrollGridview comeOrderDetailLvFujianDownload;
    @BindView(R.id.tv_add_note)
    TextView tvAddNote;
    @BindView(R.id.tv_modify)
    TextView tvModify;
    @BindView(R.id.tv_down_send)
    TextView tvDownSend;
    @BindView(R.id.item_come_order_detail_product)
    LinearLayout itemComeOrderDetailProduct;
    @BindView(R.id.activity_come_order_product_detail)
    RelativeLayout activityComeOrderProductDetail;
    private OrderDetail.ResultBean.RowsBean orderProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_order_product_detail);
        ButterKnife.bind(this);
        receiveData();
        initData();
    }

    private void receiveData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        orderProduct = ((OrderDetail.ResultBean.RowsBean) bundle.getSerializable("orderProduct"));
    }

    private void initData() {
        //初始化数据
        proCateGory.setText(orderProduct.getCompanyCategory().getName());//产品类
        orderDetailLlProCateGoryRuler.setText(orderProduct.getProductName());//产品名称
        comeOrderDetailSinglePrice.setText(orderProduct.getPrice());//单价
        comeOrderDetailTvNum.setText(orderProduct.getAmount());
        comeOrderDetailTvEndDateHand.setText(orderProduct.getDeliveryTime());
        comeOrderDetailTvMinePriority.setText(orderProduct.getCompanyAPriority());//甲方优先级
        orderDetailTvNote.setText(orderProduct.getProductDescription());
        //产品属性
      /*  productAttribute.setAdapter(new CommonAdapter<OrderDetail.ResultBean.RowsBean>(ComeOrderProductDetail.this,,R.layout.item_product_attribute) {
            @Override
            public void convert(ViewHolder viewHolder, OrderDetail.ResultBean.RowsBean rowsBean, int position) {

            }
        });*/
    }

    @OnClick(R.id.iv_last)
    public void onClick() {
        finish();
    }
}
