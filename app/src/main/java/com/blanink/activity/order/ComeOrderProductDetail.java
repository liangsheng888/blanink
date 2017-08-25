package com.blanink.activity.order;

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
import com.blanink.activity.AttachmentBrow;
import com.blanink.activity.flow.FlowProgress;
import com.blanink.activity.flow.FlowProgressDetail;
import com.blanink.activity.remark.RemarkComeOder;
import com.blanink.activity.remark.RemarkReview;
import com.blanink.pojo.OneOrderProduct;
import com.blanink.pojo.OrderProductAttributes;
import com.blanink.pojo.OrderProductStatus;
import com.blanink.pojo.OrderProgress;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.PriorityUtils;
import com.blanink.utils.StringToListUtils;
import com.blanink.utils.SysConstants;
import com.blanink.view.NoScrollGridview;
import com.blanink.view.PopBottomWin;
import com.google.gson.Gson;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ComeOrderProductDetail extends AppCompatActivity {


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
    @BindView(R.id.order_detail_ll_proCateGory)
    LinearLayout orderDetailLlProCateGory;
    @BindView(R.id.tv_ruler)
    TextView tvRuler;
    @BindView(R.id.order_detail_ll_proCateGory_ruler)
    TextView orderDetailLlProCateGoryRuler;
    @BindView(R.id.rl)
    RelativeLayout rl;
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
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.order_detail_tv_note)
    TextView orderDetailTvNote;
    @BindView(R.id.order_detail_ll_note)
    LinearLayout orderDetailLlNote;
    @BindView(R.id.tv_seek_progress)
    TextView tvSeekProgress;
    @BindView(R.id.tv_add_note)
    TextView tvAddNote;
    @BindView(R.id.item_come_order_detail_product)
    LinearLayout itemComeOrderDetailProduct;
    @BindView(R.id.activity_come_order_product_detail)
    RelativeLayout activityComeOrderProductDetail;
    private OneOrderProduct orderProduct;
    private AlertDialog alertDialog;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_order_product_detail);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        DialogLoadUtils.getInstance(this);
        DialogLoadUtils.showDialogLoad("努力加载中...");
        initData();
    }

    private void initData() {
        //返回
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        OkHttp();


        //查看进度
        //  查看进度
        tvSeekProgress.setOnClickListener(new View.OnClickListener()

                                          {
                                              @Override
                                              public void onClick(View v) {
                                                  DialogLoadUtils.showDialogLoad("努力加载中...");
                                                  postAsynHttp();
                                              }
                                          }

        );

        tvAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ComeOrderProductDetail.this, ComeOrderProductDetailTalkNote.class);
                it.putExtra("productId", orderProduct.getResult().getId());
                startActivity(it);
            }
        });
        //
        tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderProductStatus(orderProduct.getResult().getId());

            }
        });

    }

    //下发
    private void downSend(final View v, String content) {
//http://192.168.199.195:8080/blanink-api/order/distribute?orderProductId=fcd3ef29771d402cbd4f7810f16a0883
        String url = NetUrlUtils.NET_URL + "order/distribute";
        OkHttpClient ok = new OkHttpClient();
        RequestBody rb = new FormBody.Builder().add("orderProductId", orderProduct.getResult().getId()).build();
        Request re = new Request.Builder().post(rb).url(url).build();
        ok.newCall(re).enqueue(new Callback() {
                                   @Override
                                   public void onFailure(Call call, IOException e) {

                                       DialogLoadUtils.dismissDialog();
                                   }

                                   @Override
                                   public void onResponse(Call call, Response response) throws IOException {
                                       String json = response.body().string();
                                       Log.e("@@@@", json);
                                       Gson gson = new Gson();
                                       final com.blanink.pojo.Response rp = gson.fromJson(json, com.blanink.pojo.Response.class);
                                       runOnUiThread(new Runnable() {
                                           @Override
                                           public void run() {
                                               if ("00000".equals(rp.getErrorCode())) {
                                                   alertDialog.dismiss();
                                                   DialogLoadUtils.dismissDialog();
                                                   Toast.makeText(ComeOrderProductDetail.this, "已下发", Toast.LENGTH_SHORT).show();
                                                   ((TextView) v).setEnabled(false);
                                                   ((TextView) v).setText("已下发");
                                                   ((TextView) v).setBackgroundColor(getResources().getColor(R.color.colorBackGround));


                                               } else {
                                                   DialogLoadUtils.dismissDialog();
                                                   Toast.makeText(ComeOrderProductDetail.this, "操作失败", Toast.LENGTH_SHORT).show();

                                               }
                                           }
                                       });

                                   }
                               }

        );
    }

    public void OkHttp() {
        String url = NetUrlUtils.NET_URL + "order/getOneOrderProduct";
        OkHttpClient ok = new OkHttpClient();
        RequestBody rb = new FormBody.Builder().add("id", getIntent().getStringExtra("orderProductId"))
                .add("order.id", getIntent().getStringExtra("orderId")).build();
        Log.e("ComeOrder", getIntent().getStringExtra("orderProductId"));
        Request re = new Request.Builder().post(rb).url(url).build();
        ok.newCall(re).enqueue(new Callback() {
                                   @Override
                                   public void onFailure(Call call, IOException e) {

                                       DialogLoadUtils.dismissDialog();
                                   }

                                   @Override
                                   public void onResponse(Call call, Response response) throws IOException {
                                       String json = response.body().string();
                                       Log.e("@@@@", json);
                                       DialogLoadUtils.dismissDialog();
                                       Gson gson = new Gson();
                                       orderProduct = gson.fromJson(json, OneOrderProduct.class);
                                       DialogLoadUtils.dismissDialog();
                                       runOnUiThread(new Runnable() {
                                                         @Override
                                                         public void run() {
                                                             if (SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_FLOW_PULISHED.equals(orderProduct.getResult().getOrderProductStatus())
                                                                     || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_PRODUCTION_END.equals(orderProduct.getResult().getOrderProductStatus())
                                                                     || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_DELIEVERY_PART.equals(orderProduct.getResult().getOrderProductStatus())
                                                                     || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_DELIEVERY_OVER.equals(orderProduct.getResult().getOrderProductStatus())
                                                                     || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_RECEIVED_PART.equals(orderProduct.getResult().getOrderProductStatus())
                                                                     || SysConstants.ORDER_PRODUCT_STATUS_COMPANY_B_RECEIVED_OVER.equals(orderProduct.getResult().getOrderProductStatus())
                                                                     || SysConstants.ORDER_PRODUCT_STATUS_COMMENT_OVER.equals(orderProduct.getResult().getOrderProductStatus())
                                                                     || SysConstants.ORDER_PRODUCT_STATUS_AFTERSALES_START.equals(orderProduct.getResult().getOrderProductStatus())
                                                                     || SysConstants.ORDER_PRODUCT_STATUS_AFTERSALES_DEALING.equals(orderProduct.getResult().getOrderProductStatus())
                                                                     || SysConstants.ORDER_PRODUCT_STATUS_AFTERSALES_DEALING_OVER.equals(orderProduct.getResult().getOrderProductStatus())
                                                                     || SysConstants.ORDER_PRODUCT_SRTATUS_REJECT_TAKE.equals(orderProduct.getResult().getOrderProductStatus())
                                                                     ) {
                                                                 tvSeekProgress.setVisibility(View.VISIBLE);
                                                             }

                                                             //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
                                                             List<String> arrayList = null;
                                                             if (orderProduct.getResult().getImages() != null && orderProduct.getResult().getImages() != "" && !"".equals(orderProduct.getResult().getImages())) {

                                                                 arrayList = StringToListUtils.stringToList(orderProduct.getResult().getImages(), "\\|");
                                                             } else {
                                                                 arrayList = new ArrayList<>();
                                                             }


                                                             final List<String> finalArrayList = arrayList;
                                                             // final List<String> stringList = StringToListUtils.stringToList(orderProduct.getResult().getImages(), ",");
                                                             if (finalArrayList.size() == 0) {
                                                                 tvAttactment.setText("无附件");
                                                             } else {
                                                                 tvAttactment.setOnClickListener(new View.OnClickListener() {
                                                                     @Override
                                                                     public void onClick(View v) {
                                                                         Intent intent = new Intent(ComeOrderProductDetail.this, AttachmentBrow.class);
                                                                         intent.putExtra("imageList", new Gson().toJson(finalArrayList));
                                                                         startActivity(intent);
                                                                     }
                                                                 });
                                                             }
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

                                       );
                                   }
                               }

        );
    }


    private void loadProductAttribute(String id) {
        String url = NetUrlUtils.NET_URL + "order/orderProductAttribute";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("id", id).build();
        Request request = new Request.Builder().post(body).url(url).build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String json = null;
                json = response.body().string();
                final Gson gson = new Gson();
                final String finalJson = json;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        final OrderProductAttributes attributes = gson.fromJson(finalJson, OrderProductAttributes.class);
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
                                View view = View.inflate(ComeOrderProductDetail.this, R.layout.item_product_attribute, null);
                                TextView tv_attribute_name = ((TextView) view.findViewById(R.id.tv_attribute_name));
                                TextView tv_attribute_value = ((TextView) view.findViewById(R.id.tv_attribute_value));
                                tv_attribute_name.setText(attributes.getResult().getOrderProductSpecificationList().get(position).getAttribute().getName() + ":");
                                tv_attribute_value.setText(attributes.getResult().getOrderProductSpecificationList().get(position).getAttributeValue());

                                return view;
                            }
                        });
                    }

                });
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
        Log.e("FlowSort", NetUrlUtils.NET_URL + "flow/getFlowPlan?type=2&orderProduct.id=" + orderProduct.getResult().getId());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
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
                                Intent intent = new Intent(ComeOrderProductDetail.this, FlowProgress.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("orderProgress", orderProgress);
                                intent.putExtras(bundle);
                                intent.putExtra("type", "3");
                                startActivity(intent);

                            } else if (orderProgress.getResult().size() == 1) {
                                Intent intent = new Intent(ComeOrderProductDetail.this, FlowProgressDetail.class);
                                intent.putExtra("flowId", orderProgress.getResult().get(0).getFlow().getId());
                                intent.putExtra("type", "3");
                                startActivity(intent);
                            }
                        } else {
                            DialogLoadUtils.dismissDialog();
                            Toast.makeText(ComeOrderProductDetail.this, "服务器开了会小儿差", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    //打回甲方
    private void showMotify(final View vie, final String title, String left, String right, final String type) {
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
                    Toast.makeText(ComeOrderProductDetail.this, "请填写备注信息", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.showDialogLoad("打回甲方中...");
                callBack(vie, content, type, title);
            }
        });
        view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    private void downSendNotify(String title, String left, String right, final View ve) {
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
                    Toast.makeText(ComeOrderProductDetail.this, "请填写备注信息", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.showDialogLoad("正在下发...");
                downSend(ve, content);
            }
        });
        view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    private void callBack(final View v, String comments, String type, final String message) {
        //http://localhost:8080/blanink-api/order/comments4Reject?orderProdId&comments=ssssss&type=1&sender&senderName&senderCompany
        String url = NetUrlUtils.NET_URL + "order/comments4Reject";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("orderProdId", orderProduct.getResult().getId())
                .add("comments", comments)
                .add("type", type)
                .add("sender", sp.getString("USER_ID", null))
                .add("senderCompany", sp.getString("COMPANY_ID", null))
                .build();
        Request request = new Request.Builder().post(body).url(url).build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String json = null;
                json = response.body().string();
                final Gson gson = new Gson();
                final String finalJson = json;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        com.blanink.pojo.Response rp = gson.fromJson(finalJson, com.blanink.pojo.Response.class);
                        if ("00000".equals(rp.getErrorCode())) {
                            DialogLoadUtils.dismissDialog();
                            alertDialog.dismiss();
                            Toast.makeText(ComeOrderProductDetail.this, message, Toast.LENGTH_SHORT).show();
                            ((TextView) v).setEnabled(false);
                            ((TextView) v).setText(message);
                            ((TextView) v).setBackgroundColor(getResources().getColor(R.color.colorBackGround));

                        } else {
                            DialogLoadUtils.dismissDialog();
                            Toast.makeText(ComeOrderProductDetail.this, "服务器异常,操作失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    public void OrderProductStatus(final String productId) {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/getOneOrderProductStatus");
        rp.addBodyParameter("id", productId);
        x.http().post(rp, new org.xutils.common.Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                final OrderProductStatus op = gson.fromJson(result, OrderProductStatus.class);
                Log.e("@@@@", "产品状态:" + op.toString());
                PopBottomWin pop = new PopBottomWin(ComeOrderProductDetail.this, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()) {
                            case R.id.tv_add_note:
                                Intent it = new Intent(ComeOrderProductDetail.this, ComeOrderProductDetailTalkNote.class);
                                it.putExtra("productId", productId);
                                startActivity(it);
                                break;
                            case R.id.tv_give_A:
                                showMotify(v, "打回甲方", "取消", "确定", "1");
                                break;
                            case R.id.tv_down_send:
                                downSendNotify("下发生产", "取消", "确定", v);
                                break;
                            case R.id.tv_seek_progress:
                                DialogLoadUtils.showDialogLoad("努力加载中...");
                                postAsynHttp();
                                break;
                            case R.id.tv_modify:
                                Intent intent = new Intent(ComeOrderProductDetail.this, OrderProductModify.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("productDetail", orderProduct);
                                intent.putExtras(bundle);
                                startActivity(intent);
                                break;
                            case R.id.tv_remark:
                                Log.e("comeOrder", "reviewFinish" + orderProduct.getResult().getReviewFinish());
                                if ("1".equals(orderProduct.getResult().getReviewFinish())) {
                                    //回复
                                    Intent itRemark = new Intent(ComeOrderProductDetail.this, RemarkReview.class);
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
                                    Intent itRemark = new Intent(ComeOrderProductDetail.this, RemarkComeOder.class);
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
                            case R.id.tv_refuse:
                                showMotify(v, "拒绝", "取消", "确定", "2");
                                break;
                        }
                    }
                }, orderProduct.getResult().getOrderProductStatus());
                pop.showAtLocation(findViewById(R.id.activity_come_order_product_detail), Gravity.CENTER, 0, 0);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        OkHttp();
    }
}