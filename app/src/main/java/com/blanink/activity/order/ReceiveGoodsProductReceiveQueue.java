package com.blanink.activity.order;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.blanink.R;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.ProductDeliverInfo;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.CustomSwipeRefreshLayout;
import com.google.gson.Gson;

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

/***
 * 收货列表
 */
public class ReceiveGoodsProductReceiveQueue extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.receive)
    RelativeLayout receive;
    @BindView(R.id.lv)
    SwipeMenuListView lv;
    @BindView(R.id.swipeRefreshLayout)
    CustomSwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.ll_load)
    LinearLayout llLoad;
    @BindView(R.id.loading_error_img)
    ImageView loadingErrorImg;
    @BindView(R.id.rl_load_fail)
    RelativeLayout rlLoadFail;
    @BindView(R.id.tv_not)
    TextView tvNot;
    @BindView(R.id.rl_not_data)
    RelativeLayout rlNotData;
    @BindView(R.id.fl_load)
    FrameLayout flLoad;
    private AlertDialog alertDialog;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_goods_product_receive_queue);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        OkHttp();
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                OkHttp();
            }
        });

    }

    public int dp2px(float dipValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public void OkHttp() {
        String url = NetUrlUtils.NET_URL + "order/getOrderProductWithDeliveryInfo";
        OkHttpClient ok = new OkHttpClient();
        final RequestBody rb = new FormBody.Builder().add("id", getIntent().getStringExtra("orderProductId")).build();
        Request re = new Request.Builder().post(rb).url(url).build();
        ok.newCall(re).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.e("@@@@", json);
                Gson gson = new Gson();
                final ProductDeliverInfo orderProduct = gson.fromJson(json, ProductDeliverInfo.class);
                final List<ProductDeliverInfo.ResultBean.RelFlowProcessListBean> relList = orderProduct.getResult().getRelFlowProcessList();
                final List<ProductDeliverInfo.ResultBean.RelFlowProcessListBean.ProcessFeedbackListBean> pfList = new ArrayList<ProductDeliverInfo.ResultBean.RelFlowProcessListBean.ProcessFeedbackListBean>();
                for (int i = 0; i < relList.size(); i++) {
                    for (ProductDeliverInfo.ResultBean.RelFlowProcessListBean.ProcessFeedbackListBean pf : relList.get(i).getProcessFeedbackList()) {
                        pf.setProcess(relList.get(i).getProcess());
                        pfList.add(pf);
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        llLoad.setVisibility(View.GONE);
                        swipeRefreshLayout.setRefreshing(false);
                        lv.setAdapter(new CommonAdapter<ProductDeliverInfo.ResultBean.RelFlowProcessListBean.ProcessFeedbackListBean>(ReceiveGoodsProductReceiveQueue.this, pfList, R.layout.item_order_receive) {
                            @Override
                            public void convert(ViewHolder viewHolder, ProductDeliverInfo.ResultBean.RelFlowProcessListBean.ProcessFeedbackListBean processFeedbackListBean, final int position) {
                                processFeedbackListBean = pfList.get(position);

                                TextView tvProName = viewHolder.getViewById(R.id.tv_product_name);
                                TextView tv_state = viewHolder.getViewById(R.id.tv_state);
                                TextView tv_deliver_num = viewHolder.getViewById(R.id.tv_deliver_num);
                                TextView tv_sender_name = viewHolder.getViewById(R.id.tv_sender_name);
                                TextView tv_deliver_note = viewHolder.getViewById(R.id.tv_deliver_note);
                                tvProName.setText(processFeedbackListBean.getProcess().getName());
                                if (processFeedbackListBean.getConfirmAmount() == -1) {
                                    tv_state.setText("已拒绝收货");
                                    tv_state.setTextColor(getResources().getColor(R.color.colorAccent));

                                }
                                if (processFeedbackListBean.getConfirmAmount() > 0) {
                                    tv_state.setText("已收货");
                                    tv_state.setTextColor(getResources().getColor(R.color.colorBlue));

                                }
                                if (processFeedbackListBean.getConfirmAmount() == 0) {
                                    tv_state.setText("未收货");
                                    tv_state.setTextColor(getResources().getColor(R.color.colorGray));


                                }
                                tv_deliver_num.setText(processFeedbackListBean.getAchieveAmount() + "");
                                tv_sender_name.setText(processFeedbackListBean.getFeedbackUser().getName());
                                tv_deliver_note.setText(processFeedbackListBean.getRemarks());
                                final SwipeMenuCreator creator = new SwipeMenuCreator() {
                                    @Override
                                    public void create(final SwipeMenu menu) {
                                        // 设置加入潜在框
                                        if (pfList.get(position).getConfirmAmount() == 0) {
                                            SwipeMenuItem talkNoteItem = new SwipeMenuItem(ReceiveGoodsProductReceiveQueue.this);
                                            talkNoteItem.setBackground(new ColorDrawable(getResources().getColor(R.color.colorBlue)));
                                            talkNoteItem.setWidth(dp2px(100));
                                            talkNoteItem.setTitle("收货");
                                            talkNoteItem.setTitleSize(18);
                                            talkNoteItem.setTitleColor(Color.WHITE);
                                            menu.addMenuItem(talkNoteItem);

                                            SwipeMenuItem refuse = new SwipeMenuItem(ReceiveGoodsProductReceiveQueue.this);
                                            refuse.setBackground(new ColorDrawable(getResources().getColor(R.color.colorAccent)));
                                            refuse.setWidth(dp2px(100));
                                            refuse.setTitle("拒绝收货");
                                            refuse.setTitleSize(18);
                                            refuse.setTitleColor(Color.WHITE);
                                            menu.addMenuItem(refuse);
                                        } else if (pfList.get(position).getConfirmAmount() > 0) {
                                            SwipeMenuItem talkNoteItem = new SwipeMenuItem(ReceiveGoodsProductReceiveQueue.this);
                                            talkNoteItem.setBackground(new ColorDrawable(getResources().getColor(R.color.colorBlue)));
                                            talkNoteItem.setWidth(dp2px(100));
                                            talkNoteItem.setTitle("已收货");
                                            talkNoteItem.setTitleSize(18);
                                            talkNoteItem.setTitleColor(Color.WHITE);
                                            menu.addMenuItem(talkNoteItem);
                                        } else if (pfList.get(position).getConfirmAmount() == -1) {
                                            //-1代表已拒绝
                                            SwipeMenuItem talkNoteItem = new SwipeMenuItem(ReceiveGoodsProductReceiveQueue.this);
                                            talkNoteItem.setBackground(new ColorDrawable(getResources().getColor(R.color.colorAccent)));
                                            talkNoteItem.setWidth(dp2px(100));
                                            talkNoteItem.setTitle("已拒绝");
                                            talkNoteItem.setTitleSize(18);
                                            talkNoteItem.setTitleColor(Color.WHITE);
                                            menu.addMenuItem(talkNoteItem);
                                        }


                                    }
                                };
                                lv.setMenuCreator(creator);
                            }

                        });

                        lv.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                                if (pfList.get(position).getConfirmAmount() == 0) {
                                    switch (index) {
                                        case 0:
                                            Intent intent = new Intent(ReceiveGoodsProductReceiveQueue.this, ReceiveGoodsToReceive.class);
                                            intent.putExtra("orderProductId", orderProduct.getResult().getId());
                                            intent.putExtra("orderId", orderProduct.getResult().getOrder().getId());
                                            if (orderProduct.getResult().getBCompany() != null) {
                                                intent.putExtra("companyId", orderProduct.getResult().getBCompany().getId());
                                            }
                                            intent.putExtra("productRemarks", orderProduct.getResult().getRemarks());

                                            intent.putExtra("price", orderProduct.getResult().getPrice());
                                            intent.putExtra("amount", orderProduct.getResult().getAmount());
                                            intent.putExtra("deliverTime", orderProduct.getResult().getDeliveryTime());
                                            intent.putExtra("companyCateGory", orderProduct.getResult().getCompanyCategory().getName());
                                            intent.putExtra("productName", orderProduct.getResult().getProductName());
                                            intent.putExtra("senderName", pfList.get(position).getFeedbackUser().getName());
                                            intent.putExtra("achieveAmount", pfList.get(position).getAchieveAmount());
                                            intent.putExtra("sendTime", pfList.get(position).getCreateDate());
                                            intent.putExtra("remarks", pfList.get(position).getRemarks());
                                            intent.putExtra("processFeedBackId", pfList.get(position).getId());
                                            intent.putExtra("processId", pfList.get(position).getProcess().getId());
                                            intent.putExtra("feedBackUserId", pfList.get(position).getFeedbackUser().getId());
                                            intent.putExtra("target", pfList.get(position).getTarget());

                                            intent.putExtra("images", pfList.get(position).getFeedbackAttachmentStr());
                                            startActivity(intent);
                                            break;
                                        case 1:
                                            showNotify(pfList.get(position).getFeedbackUser().getId(), pfList.get(position).getId(), pfList.get(position).getProcess().getId());
                                            break;
                                    }
                                } else {

                                }

                                return false;
                            }
                        });
//发货详情
                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(ReceiveGoodsProductReceiveQueue.this, ReceiveGoodsDetails.class);
                                intent.putExtra("ReceiveGoods", pfList.get(position));
                                intent.putExtra("orderProductId", orderProduct.getResult().getId());
                                if (orderProduct.getResult().getBCompany() != null) {
                                    intent.putExtra("companyId", orderProduct.getResult().getBCompany().getId());
                                }
                                intent.putExtra("companyCateGory", orderProduct.getResult().getCompanyCategory().getName());
                                intent.putExtra("productName", orderProduct.getResult().getProductName());
                                intent.putExtra("senderName", pfList.get(position).getFeedbackUser().getName());
                                intent.putExtra("achieveAmount", pfList.get(position).getAchieveAmount());
                                intent.putExtra("sendTime", pfList.get(position).getCreateDate());
                                intent.putExtra("remarks", pfList.get(position).getRemarks());
                                intent.putExtra("processFeedBackId", pfList.get(position).getId());
                                intent.putExtra("processId", pfList.get(position).getProcess().getId());
                                intent.putExtra("target", pfList.get(position).getTarget());
                                intent.putExtra("images", pfList.get(position).getFeedbackAttachmentStr());

                                startActivity(intent);

                            }
                        });
                    }
                });
            }
        });
    }

    private void showNotify(final String receiverId, final String processFeedBackId, final String processId) {
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
        ((TextView) view.findViewById(R.id.tv_title)).setText("拒绝收货");
        ((Button) view.findViewById(R.id.btn_send)).setText("确定");
        view.findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送理由
                String recomments = ((EditText) view.findViewById(R.id.et_info)).getText().toString();
                if (TextUtils.isEmpty(recomments)) {
                    Toast.makeText(ReceiveGoodsProductReceiveQueue.this, "请填写备注信息", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.getInstance(ReceiveGoodsProductReceiveQueue.this);
                DialogLoadUtils.showDialogLoad("操作进行中...");
                sendNotify(recomments, receiverId, processFeedBackId, processId);
            }
        });
        view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    //拒绝收货
    private void sendNotify(String recomments, String receiverId, String processFeedBackId, String processId) {

        String url = NetUrlUtils.NET_URL + "order/orderProductReject";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("orderProdId", getIntent().getStringExtra("orderProductId"))
                .add("currentUser.id", sp.getString("USER_ID", null))
                .add("comments", recomments)
                .add("sendUser", receiverId)
                .add("id", processFeedBackId)
                .add("process.id", processId)
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

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
                            Toast.makeText(ReceiveGoodsProductReceiveQueue.this, "已拒绝", Toast.LENGTH_SHORT).show();

                            OkHttp();
                            DialogLoadUtils.dismissDialog();
                            alertDialog.dismiss();


                        } else {
                            DialogLoadUtils.dismissDialog();
                        }
                    }
                });
            }
        });
    }

}
