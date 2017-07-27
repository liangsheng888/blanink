package com.blanink.activity.order;

import android.app.Dialog;
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
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.activity.aftersale.AfterSaleDemand;
import com.blanink.activity.flow.FlowProgress;
import com.blanink.activity.flow.FlowProgressDetail;
import com.blanink.activity.remark.RemarkGoOrder;
import com.blanink.activity.remark.RemarkGoOrderReview;
import com.blanink.activity.AttachmentBrow;
import com.blanink.pojo.OneOrderProduct;
import com.blanink.pojo.OrderProductAttributes;
import com.blanink.pojo.OrderProductStatus;
import com.blanink.pojo.OrderProgress;
import com.blanink.pojo.Response;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.DialogNotifyUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.PriorityUtils;
import com.blanink.utils.StringToListUtils;
import com.blanink.view.LoadingDialog;
import com.blanink.view.NoScrollGridview;
import com.blanink.view.PopBottomWinGo;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

//去单 产品详情
public class GoDownOrderProductDetail extends AppCompatActivity {

    OneOrderProduct orderProduct;
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
    @BindView(R.id.come_order_detail_lv_fujian_download)
    NoScrollGridview comeOrderDetailLvFujianDownload;
    @BindView(R.id.activity_come_order_product_detail)
    RelativeLayout activityComeOrderProductDetail;

    private SharedPreferences sp;
    private String coments;
    private AlertDialog alertDialog;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_modify:
                    Intent intent = new Intent(GoDownOrderProductDetail.this, OrderProductModify.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("productDetail", orderProduct);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                case R.id.tv_modify_supplier:

                    Intent intentModify = new Intent(GoDownOrderProductDetail.this, GoDownOrderProductDetailModifySupplier.class);
                    intentModify.putExtra("currentSupplierId", orderProduct.getResult().getBCompany().getId());
                    Bundle bd = new Bundle();
                    bd.putSerializable("orderProduct", orderProduct);
                    intentModify.putExtras(bd);
                    startActivity(intentModify);

                    break;
                case R.id.tv_after_sale:
                    Intent intentAfter = new Intent(GoDownOrderProductDetail.this, AfterSaleDemand.class);
                    intentAfter.putExtra("orderProdCompanyId", orderProduct.getResult().getBCompany().getId());
                    intentAfter.putExtra("orderProdId", orderProduct.getResult().getId());
                    startActivity(intentAfter);

                    //售后
                    break;
                case R.id.tv_remark:
                    if ("1".equals(orderProduct.getResult().getReviewFinish())) {
                        //回复
                        Intent itRemark = new Intent(GoDownOrderProductDetail.this, RemarkGoOrderReview.class);
                        itRemark.putExtra("orderProductId", orderProduct.getResult().getId());
                        itRemark.putExtra("orderId", orderProduct.getResult().getOrder().getId());
                        itRemark.putExtra("productName", orderProduct.getResult().getProductName());
                        itRemark.putExtra("productCategory", orderProduct.getResult().getCompanyCategory().getName());
                        itRemark.putExtra("amount", orderProduct.getResult().getAmount());
                        itRemark.putExtra("deliverTime", orderProduct.getResult().getDeliveryTimeString());
                        itRemark.putExtra("productRemarks", orderProduct.getResult().getProductDescription());
                        itRemark.putExtra("price", orderProduct.getResult().getPrice());
                        itRemark.putExtra("productSo", orderProduct.getResult().getProductSn());
                        startActivity(itRemark);
                    } else {
                        //去评价
                        Intent itRemark = new Intent(GoDownOrderProductDetail.this, RemarkGoOrder.class);
                        itRemark.putExtra("orderProductId", orderProduct.getResult().getId());
                        itRemark.putExtra("orderId", orderProduct.getResult().getOrder().getId());
                        itRemark.putExtra("productName", orderProduct.getResult().getProductName());
                        itRemark.putExtra("amount", orderProduct.getResult().getAmount());
                        itRemark.putExtra("deliverTime", orderProduct.getResult().getDeliveryTime());
                        itRemark.putExtra("productRemarks", orderProduct.getResult().getProductDescription());
                        itRemark.putExtra("price", orderProduct.getResult().getPrice());
                        itRemark.putExtra("productSo", orderProduct.getResult().getProductSn());
                        startActivityForResult(itRemark, 0);
                    }


                    break;
                case R.id.tv_down_send:
                    callBackNotify("重新下发", "取消", "重新下发产品", v);
                    break;
                case R.id.tv_seek_progress:
                    DialogLoadUtils.showDialogLoad("努力加载中...");
                    postAsynHttp();
                    break;
                case R.id.tv_add_note:
                    Intent it = new Intent(GoDownOrderProductDetail.this, ComeOrderProductDetailTalkNote.class);
                    it.putExtra("productId", orderProduct.getResult().getId());
                    startActivity(it);
                    break;
            }
        }
    };
    private Dialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_down_order_product_detail);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        DialogLoadUtils.getInstance(this);
        DialogLoadUtils.showDialogLoad("努力加载中...");
        initData();
    }


    private void initData() {
        OkHttp();
        tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderProductStatus(orderProduct.getResult().getId());
            }
        });

    }
          /*  //点击放大
            myPager.setImageViewListener(new MyPagerList.ImageViewOnClickListener() {
                @Override
                public void imageViewOnClick(int position) {
                    PhotoPreview.builder()
                            .setPhotos(arrayList)
                            .setCurrentItem(position)
                            .setShowDeleteButton(false)
                            .start(GoDownOrderProductDetail.this);
                }
            });*/


/*

        //重新下发（当对方打回的时候）
        if (SysConstants.ORDER_PRODUCT_STATUS_BACK_TO_A.equals(orderProduct.getOrderProductStatus())) {
            tvDownSend.setVisibility(View.VISIBLE);
            tvModify.setVisibility(View.VISIBLE);
            tvModify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(GoDownOrderProductDetail.this, OrderProductModify.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("productDetail", orderProduct);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            tvDownSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //改变状态
                    callBackNotify("重新下发", "取消", "重新下发产品");
                }
            });
        }
        if (SysConstants.ORDER_PRODUCT_SRTATUS_REJECT.equals(orderProduct.getOrderProductStatus())) {
            //修改供应商（当对方拒绝的时候）
            tvModifySupplier.setVisibility(View.VISIBLE);
            tvModifySupplier.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(GoDownOrderProductDetail.this, GoDownOrderProductDetailModifySupplier.class);
                    intent.putExtra("currentSupplierId", orderProduct.getBCompany().getId());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("orderProduct", orderProduct);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
        if (SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_PRODUCTION_END.equals(orderProduct.getOrderProductStatus())
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_DELIEVERY_PART.equals(orderProduct.getOrderProductStatus())
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_RECEIVED_PART.equals(orderProduct.getOrderProductStatus())
                || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_RECEIVED_OVER.equals(orderProduct.getOrderProductStatus())) {
            //售后
            tvAfterSale.setVisibility(View.VISIBLE);
            tvAfterSale.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        //沟通记录
        tvAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoDownOrderProductDetail.this, ComeOrderProductDetailTalkNote.class);
                startActivity(intent);
            }
        });
        //评价
        tvRemark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //查看进度
        tvSeekProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
*/


    private void downSend(String comments, final View v) {
        //http://localhost:8080/blanink-api/order/reTransfer?
        // senderCompany=9ce7467e94884e7192a14ad3c29c554d&
        // orderProductId=13ca69d4c53c4a7c8185f5929cbc93b5&
        // comments=色色色谔谔谔谔&
        // senderName=额呃呃呃&
        // sender=3c70d715d02a4c4aadc1952ecde286e1
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/reTransfer");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("orderProductId", orderProduct.getResult().getId());
        rp.addBodyParameter("comments", comments);
        rp.addBodyParameter("sender", sp.getString("USER_ID", null));
        rp.addBodyParameter("senderName", sp.getString("NAME", null));
        rp.addBodyParameter("senderCompany", sp.getString("COMPANY_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if ("00000".equals(response.getErrorCode())) {
                    DialogLoadUtils.dismissDialog();
                    Toast.makeText(GoDownOrderProductDetail.this, "操作成功", Toast.LENGTH_SHORT).show();
                    /*tvDownSend.setText("已重新下发");
                    tvDownSend.setEnabled(false);
                    tvDownSend.setBackgroundColor(getResources().getColor(R.color.colorGray));*/
                    alertDialog.dismiss();
                    ((TextView) v).setText("已重新下发成功");
                    ((TextView) v).setBackgroundColor(getResources().getColor(R.color.colorBackGround));
                    ((TextView) v).setEnabled(false);
                    DialogNotifyUtils.showNotify(GoDownOrderProductDetail.this, "已重新下发成功");
                } else {
                    DialogLoadUtils.dismissDialog();
                    Toast.makeText(GoDownOrderProductDetail.this, "操作失败", Toast.LENGTH_SHORT).show();
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

    @OnClick(R.id.iv_last)
    public void onClick() {
        finish();
    }

    //加载产品属性
    public void loadProductAttribute(String productId) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/orderProductAttribute");
        rp.addBodyParameter("id", productId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                DialogLoadUtils.dismissDialog();
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
                        View view = View.inflate(GoDownOrderProductDetail.this, R.layout.item_product_attribute, null);
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

    private void callBackNotify(String title, String left, String right, View v) {
        alertDialog = new AlertDialog.Builder(this).create();
        final View view = View.inflate(this, R.layout.dialog_send, null);
        alertDialog.setView(view);
        alertDialog.show();
        final Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display d = windowManager.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setAttributes(lp);
        alertDialog.setCanceledOnTouchOutside(false);
        ((TextView) view.findViewById(R.id.tv_title)).setText(title);
        ((Button) view.findViewById(R.id.btn_cancel)).setText(left);
        ((Button) view.findViewById(R.id.btn_send)).setText(right);

        view.findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送理由
                String content = ((EditText) view.findViewById(R.id.et_info)).getText().toString();
                if (TextUtils.isEmpty(content)) {
                    Toast.makeText(GoDownOrderProductDetail.this, "请填写备注信息", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.showDialogLoad("重新下发中...");
                downSend(content, v);
            }
        });
        view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    public void OrderProductStatus(String productId) {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/getOneOrderProductStatus");
        rp.addBodyParameter("id", productId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                OrderProductStatus op = gson.fromJson(result, OrderProductStatus.class);
                Log.e("@@@@", "产品状态:" + op.toString());
                PopBottomWinGo popBottomWinGo = new PopBottomWinGo(GoDownOrderProductDetail.this, onClickListener, orderProduct.getResult().getOrderProductStatus());
                popBottomWinGo.showAtLocation(findViewById(R.id.activity_come_order_product_detail), Gravity.CENTER, 0, 0);

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
                .add("type", "2")
                .add("orderProduct.id", orderProduct.getResult().getId())

                .build();
        Request request = new Request.Builder()
                .url(NetUrlUtils.NET_URL + "flow/getFlowPlan")
                .post(formBody)
                .build();
        Call call = mOkHttpClient.newCall(request);
        Log.e("FlowSort", NetUrlUtils.NET_URL + "flow/getFlowPlan?type=2&orderProduct.id=" + orderProduct.getResult().getId());
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                String str = response.body().string();
                Gson gson = new Gson();
                Log.e("FlowProgress", str);
                final OrderProgress orderProgress = gson.fromJson(str, OrderProgress.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();

                        if ("00000".equals(orderProgress.getErrorCode())) {
                            DialogLoadUtils.dismissDialog();
                            if (orderProgress.getResult().size() > 1) {
                                Intent intent = new Intent(GoDownOrderProductDetail.this, FlowProgress.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("orderProgress", orderProgress);
                                intent.putExtras(bundle);
                                intent.putExtra("type", "2");

                                startActivity(intent);

                            } else if (orderProgress.getResult().size() == 1) {
                                Intent intent = new Intent(GoDownOrderProductDetail.this, FlowProgressDetail.class);
                                intent.putExtra("flowId", orderProgress.getResult().get(0).getFlow().getId());
                                intent.putExtra("type", "2");
                                intent.putExtra("notOwnCompany", "yes");
                                startActivity(intent);
                            }
                        } else {
                            DialogLoadUtils.dismissDialog();
                            Toast.makeText(GoDownOrderProductDetail.this, "服务器开了会小儿差", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    public void OkHttp() {
        String url = NetUrlUtils.NET_URL + "order/getOneOrderProduct";
        OkHttpClient ok = new OkHttpClient();
        RequestBody rb = new FormBody.Builder().add("id", getIntent().getStringExtra("orderProductId")).
                add("order.id",getIntent().getStringExtra("orderId")).build();
        Log.e("GoDown",url+"?order.id="+getIntent().getStringExtra("orderId")+"&id="+getIntent().getStringExtra("orderProductId"));
        Request re = new Request.Builder().post(rb).url(url).build();
        ok.newCall(re).enqueue(new okhttp3.Callback() {
                                   @Override
                                   public void onFailure(Call call, IOException e) {
                                       DialogLoadUtils.dismissDialog();
                                   }

                                   @Override
                                   public void onResponse(Call call, okhttp3.Response response) throws IOException {
                                       String json = response.body().string();
                                       Log.e("@@@@", json);
                                       Gson gson = new Gson();
                                       orderProduct = gson.fromJson(json, OneOrderProduct.class);
                                       runOnUiThread(new Runnable() {
                                                         @Override
                                                         public void run() {
                                                             //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
                                                             List<String> arrayList = null;
                                                             if (orderProduct.getResult() != null) {
                                                                 if (orderProduct.getResult().getImages() != null && orderProduct.getResult().getImages() != "" && !"".equals(orderProduct.getResult().getImages())) {
                                                                     arrayList = StringToListUtils.stringToList(orderProduct.getResult().getImages(), "\\|");
                                                                 } else {
                                                                     arrayList = new ArrayList<>();
                                                                 }



                                                             final List<String> finalArrayList = arrayList;
                                                             // final List<String> stringList = StringToListUtils.stringToList(orderProduct.getResult().getImages(), ",");
                                                             tvAttactment.setOnClickListener(new View.OnClickListener() {
                                                                 @Override
                                                                 public void onClick(View v) {
                                                                     Intent intent = new Intent(GoDownOrderProductDetail.this, AttachmentBrow.class);
                                                                     intent.putExtra("imageList", new Gson().toJson(finalArrayList));
                                                                     startActivity(intent);
                                                                 }
                                                             });
                                                             proCateGory.setText(orderProduct.getResult().getCompanyCategory().getName());//产品类
                                                             orderDetailLlProCateGoryRuler.setText(orderProduct.getResult().getProductName());//产品名称
                                                             comeOrderDetailSinglePrice.setText(orderProduct.getResult().getPrice());//单价
                                                             comeOrderDetailTvNum.setText(orderProduct.getResult().getAmount());
                                                             comeOrderDetailTvEndDateHand.setText(orderProduct.getResult().getDeliveryTime());
                                                             comeOrderDetailTvMinePriority.setText(PriorityUtils.getPriority(orderProduct.getResult().getCompanyAPriority()));//甲方优先级
                                                             orderDetailTvNote.setText(orderProduct.getResult().getProductDescription());
                                                             loadProductAttribute(orderProduct.getResult().getId());//获得产品属性
                                                             }
                                                         }
                                                     }

                                       );
                                   }
                               }

        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        OkHttp();
    }

}
