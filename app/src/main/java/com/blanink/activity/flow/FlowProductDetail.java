package com.blanink.activity.flow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.AttachmentBrow;
import com.blanink.pojo.OneOrderProduct;
import com.blanink.pojo.OrderDetail;
import com.blanink.pojo.OrderProductAttributes;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.PriorityUtils;
import com.blanink.utils.StringToListUtils;
import com.blanink.view.NoScrollGridview;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 流程产品 详情
 */
public class FlowProductDetail extends AppCompatActivity {


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
    @BindView(R.id.attactment)
    TextView attactment;
    @BindView(R.id.tv_attactment)
    TextView tvAttactment;
    @BindView(R.id.rl_down)
    RelativeLayout rlDown;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.order_detail_tv_note)
    TextView orderDetailTvNote;
    @BindView(R.id.order_detail_ll_note)
    LinearLayout orderDetailLlNote;
    @BindView(R.id.btn_flow)
    Button btnFlow;
    private MyActivityManager instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_product_detail);

        instance = MyActivityManager.getInstance();
        ButterKnife.bind(this);
        instance.pushOneActivity(this);
        DialogLoadUtils.getInstance(this);
        DialogLoadUtils.showDialogLoad("加载中...");
        initData();
    }

    private void initData() {

        loadProductDetail();

        Bundle bundle = getIntent().getExtras();
        OrderDetail.ResultBean orderProduct = ((OrderDetail.ResultBean) bundle.getSerializable("orderProduct"));
        if (orderProduct.getImages() != null) {
            List<String> arrayList=null;
            if (orderProduct.getImages()!= null && orderProduct.getImages() != ""&&!"".equals(orderProduct.getImages())) {
                arrayList = StringToListUtils.stringToList(orderProduct.getImages(), "\\|");
            }else {
                arrayList=new ArrayList<>();
            }


            final List<String> finalArrayList = arrayList;
           // final List<String> picList = StringToListUtils.stringToList(orderProduct.getImages(), "\\|");

                tvAttactment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(FlowProductDetail.this, AttachmentBrow.class);
                        intent.putExtra("imageList", new Gson().toJson(finalArrayList));
                        startActivity(intent);
                    }
                });
             /*   final ArrayList<String> arrayList = new ArrayList<String>();
                arrayList.addAll(picList);
                //点击放大
                myPager.setImageViewListener(new MyPagerList.ImageViewOnClickListener() {
                    @Override
                    public void imageViewOnClick(int position) {
                        PhotoPreview.builder()
                                .setPhotos(arrayList)
                                .setCurrentItem(position)
                                .setShowDeleteButton(false)
                                .start(FlowProductDetail.this);
                    }
                });*/

        }

        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //排流程
        btnFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlowProductDetail.this, FlowOftenUse.class);
                intent.putExtra("orderProductId", getIntent().getStringExtra("orderProductId"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance.popOneActivity(this);
    }


    public void loadProductDetail() {
        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "order/getOneOrderProduct");
        requestParams.addBodyParameter("id", getIntent().getStringExtra("orderProductId"));
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                OneOrderProduct orderProduct;
                orderProduct = gson.fromJson(result, OneOrderProduct.class);
                Log.e("@@@@", orderProduct.toString());
                //初始化数据

                proCateGory.setText(orderProduct.getResult().getCompanyCategory().getName());//产品类
                orderDetailLlProCateGoryRuler.setText(orderProduct.getResult().getProductName());//产品名称
                comeOrderDetailSinglePrice.setText(orderProduct.getResult().getPrice());//单价
                comeOrderDetailTvNum.setText(orderProduct.getResult().getAmount());
                comeOrderDetailTvEndDateHand.setText(orderProduct.getResult().getDeliveryTime());
                comeOrderDetailTvMinePriority.setText(PriorityUtils.getPriority(orderProduct.getResult().getCompanyAPriority()));//甲方优先级
                orderDetailTvNote.setText(orderProduct.getResult().getProductDescription());
                loadProductAttribute(orderProduct.getResult().getId());//获得产品属性

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();

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

    //加载产品属性
    public void loadProductAttribute(String productId) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/orderProductAttribute");
        rp.addBodyParameter("id", productId);
        Log.e("@@@@", NetUrlUtils.NET_URL + "order/orderProductAttribute?id=" + productId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("ComeOrderProductDetail", result);
                DialogLoadUtils.dismissDialog();
                Gson gson = new Gson();
                final OrderProductAttributes attributes = gson.fromJson(result, OrderProductAttributes.class);
                Log.e("ComeOrderProductDetail", attributes.toString());
                productAttribute.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return attributes.getResult().getOrderProductSpecificationList().size();
                    }

                    @Override
                    public Object getItem(int position) {
                        return null;
                    }

                    @Override
                    public long getItemId(int position) {
                        return 0;
                    }

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = View.inflate(FlowProductDetail.this, R.layout.item_product_attribute, null);
                        TextView tv_attribute_name = ((TextView) view.findViewById(R.id.tv_attribute_name));
                        TextView tv_attribute_value = ((TextView) view.findViewById(R.id.tv_attribute_value));
                        tv_attribute_name.setText(attributes.getResult().getOrderProductSpecificationList().get(position).getAttribute().getName() + ":");
                        tv_attribute_value.setText(attributes.getResult().getOrderProductSpecificationList().get(position).getAttributeValue());

                        return view;
                    }
                });
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();

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
