package com.blanink.activity.flow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.activity.AttachmentBrow;
import com.blanink.pojo.FlowDetail;
import com.blanink.pojo.FlowSort;
import com.blanink.pojo.OneOrderProduct;
import com.blanink.pojo.OrderProductAttributes;
import com.blanink.pojo.OrderProgress;
import com.blanink.pojo.Response;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.PriorityUtils;
import com.blanink.utils.StringToListUtils;
import com.blanink.view.NoScrollGridview;
import com.blanink.view.PopBottomWinFlow;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/***
 * 已派流程 产品详情
 */
public class FlowSortCompletedProductDetail extends AppCompatActivity {

    OneOrderProduct orderProduct;
    FlowDetail flowDetail;
    @BindView(R.id.come_order)
    TextView comeOrder;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.tv_more)
    TextView tvMore;
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
    @BindView(R.id.rl_flow)
    RelativeLayout rlFlow;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogLoadUtils.getInstance(FlowSortCompletedProductDetail.this);
            switch (v.getId()) {
                case R.id.tv_public:
                    DialogLoadUtils.showDialogLoad("正在发布...");
                    upDataFlowState(flowDetail.getResult().getId(), v);

                    //发布
                    break;
                case R.id.tv_seek_progress:
                    DialogLoadUtils.showDialogLoad("努力加载...");
                    postAsynHttp();
                    //查看进度
                    break;
                case R.id.tv_modify:
                    Intent intent = new Intent(FlowSortCompletedProductDetail.this, FlowOftenUse.class);
                    intent.putExtra("orderProductId", orderProduct.getResult().getId());
                    startActivity(intent);
                    //重新排流程
                    break;
                case R.id.tv_seek:
                    //流程详情
                    Intent it = new Intent(FlowSortCompletedProductDetail.this, FlowSortCompletedDetail.class);
                    it.putExtra("productId", orderProduct.getResult().getId());
                    startActivity(it);
                    break;
                case R.id.tv_remark:
                    //留言
                    Intent itRemark = new Intent(FlowSortCompletedProductDetail.this, FlowComments.class);
                    itRemark.putExtra("flowId", flowDetail.getResult().getId());
                    startActivity(itRemark);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_sort_completed_product_detail);
        ButterKnife.bind(this);
        DialogLoadUtils.getInstance(this);
        DialogLoadUtils.showDialogLoad("拼命加载中...");
        initData();
    }

    private void initData() {

        loadProductDetail();

        Bundle bundle = getIntent().getExtras();
        FlowSort.ResultBean.RowsBean orderProduct = ((FlowSort.ResultBean.RowsBean) bundle.getSerializable("orderProduct"));
        if (orderProduct.getOrderProduct() != null && orderProduct.getOrderProduct().getImages() != null) {
            List<String> arrayList=null;
            if (orderProduct.getOrderProduct().getImages()!= null && orderProduct.getOrderProduct().getImages() != ""&&!"".equals(orderProduct.getOrderProduct().getImages())) {
                arrayList = StringToListUtils.stringToList(orderProduct.getOrderProduct().getImages(), "\\|");
            }else {
                arrayList=new ArrayList<>();
            }


            final List<String> finalArrayList = arrayList;
            //final List<String> picList = StringToListUtils.stringToList(orderProduct.getOrderProduct().getImages(), "\\|");

            //final List<String> picList = StringToListUtils.stringToList(orderProduct.getOrderProduct().getImages(), "\\|");

                tvAttactment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(FlowSortCompletedProductDetail.this, AttachmentBrow.class);
                        intent.putExtra("imageList", new Gson().toJson(finalArrayList));
                        startActivity(intent);
                    }
                });

              /*  //点击放大
                flowMyPager.setImageViewListener(new MyPagerList.ImageViewOnClickListener() {
                    @Override
                    public void imageViewOnClick(int position) {
                        PhotoPreview.builder()
                                .setPhotos(arrayList)
                                .setCurrentItem(position)
                                .setShowDeleteButton(false)
                                .start(FlowSortCompletedProductDetail.this);
                    }
                });*/
            }


        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIsHasFlow();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void checkIsHasFlow() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "flow/getFlow");
        if (orderProduct.getResult() != null) {
            rp.addBodyParameter("orderProduct.id", orderProduct.getResult().getId());
        }
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                flowDetail = gson.fromJson(result, FlowDetail.class);
                PopBottomWinFlow popBottomWin = new PopBottomWinFlow(FlowSortCompletedProductDetail.this, onClickListener, flowDetail.getResult().getStatus());
                popBottomWin.showAtLocation(findViewById(R.id.rl_flow), Gravity.CENTER, 0, 0);
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

    private void initFlow() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "flow/getFlow");
        rp.addBodyParameter("orderProduct.id", orderProduct.getResult().getId());
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                flowDetail = gson.fromJson(result, FlowDetail.class);
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

    private void upDataFlowState(String id, final View v) {
        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "flow/publish");
        requestParams.addBodyParameter("id", id);
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if ("00000".equals(response.errorCode)) {
                    DialogLoadUtils.dismissDialog();
                    ((TextView) v).setText("流程已发布");
                    ((TextView) v).setBackgroundColor(getResources().getColor(R.color.colorBackGround));
                    ((TextView) v).setEnabled(false);
                    Toast.makeText(FlowSortCompletedProductDetail.this, "流程已发布", Toast.LENGTH_SHORT).show();
                } else {
                    DialogLoadUtils.dismissDialog();

                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();
                Toast.makeText(FlowSortCompletedProductDetail.this, "服务器开了会儿小差", Toast.LENGTH_SHORT).show();

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


    public void loadProductDetail() {
        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "order/getOneOrderProduct");
        requestParams.addBodyParameter("id", getIntent().getStringExtra("productId"));
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                DialogLoadUtils.dismissDialog();
                orderProduct = gson.fromJson(result, OneOrderProduct.class);
                Log.e("@@@@", orderProduct.toString());
                //初始化数据
                initFlow();
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
                        View view = View.inflate(FlowSortCompletedProductDetail.this, R.layout.item_product_attribute, null);
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


    private void postAsynHttp() {
        //   http://localhost:8080/blanink-api/flow/getFlowPlan?type=2&orderProduct.id=6c57048a31e741a3810e37440903032d//
        OkHttpClient mOkHttpClient = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("type", "3")
                .add("orderProduct.id", orderProduct.getResult().getId())
                .build();
        Request request = new Request.Builder()
                .url(NetUrlUtils.NET_URL + "flow/getFlowPlan")
                .post(formBody)
                .build();
        Call call = mOkHttpClient.newCall(request);
        Log.e("FlowSort", NetUrlUtils.NET_URL + "flow/getFlowPlan?type=3&orderProduct.id=" + orderProduct.getResult().getId());
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                String str = response.body().string();
                Gson gson = new Gson();
                final OrderProgress orderProgress = gson.fromJson(str, OrderProgress.class);


                Log.e("FlowProgress", str);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();

                        if ("00000".equals(orderProgress.getErrorCode())) {
                            DialogLoadUtils.dismissDialog();
                            if (orderProgress.getResult().size() > 1) {
                                Intent intent = new Intent(FlowSortCompletedProductDetail.this, FlowProgress.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("orderProgress", orderProgress);
                                intent.putExtra("type", "3");
                                intent.putExtras(bundle);
                                startActivity(intent);

                            } else if (orderProgress.getResult().size() == 1) {
                                Intent intent = new Intent(FlowSortCompletedProductDetail.this, FlowProgressDetail.class);
                                intent.putExtra("flowId", orderProgress.getResult().get(0).getFlow().getId());
                                intent.putExtra("type", "3");
                                intent.putExtra("flag", "FLOW_SORTED");
                                startActivity(intent);
                            }
                        } else {
                            DialogLoadUtils.dismissDialog();
                            Toast.makeText(FlowSortCompletedProductDetail.this, "服务器开了会小儿差", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
