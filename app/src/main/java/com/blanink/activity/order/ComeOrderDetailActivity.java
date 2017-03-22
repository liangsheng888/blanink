package com.blanink.activity.order;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.adpater.CommonAdapter;
import com.blanink.adpater.ViewHolder;
import com.blanink.pojo.Order;
import com.blanink.pojo.OrderDetail;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.NoScrollListview;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 来单订单详情
 */
public class ComeOrderDetailActivity extends AppCompatActivity {

    @BindView(R.id.come_order_detail_tv_seek)
    TextView comeOrderDetailTvSeek;
    @BindView(R.id.come_order_detail_iv_last)
    TextView comeOrderDetailIvLast;
    @BindView(R.id.come_order_detail_rl)
    RelativeLayout comeOrderDetailRl;
    @BindView(R.id.order_detail_rl_tv_orderState)
    TextView orderDetailRlTvOrderState;
    @BindView(R.id.come_order_detail_tv_modify)
    TextView comeOrderDetailTvModify;
    @BindView(R.id.come_order_detail_ll)
    RelativeLayout comeOrderDetailLl;
    @BindView(R.id.order_detail_rl_ll_companyName)
    TextView orderDetailRlLlCompanyName;
    @BindView(R.id.tv_ordera)
    TextView orderDetailRlLlOrderNumber;
    @BindView(R.id.order_detail_rl_ll)
    LinearLayout orderDetailRlLl;
    @BindView(R.id.order_detail_rl)
    RelativeLayout orderDetailRl;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.order_date)
    TextView orderDate;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.tv_endTime)
    TextView tvEndTime;
    @BindView(R.id.order_endDate)
    TextView orderEndDate;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.order_detail_rl_ll_time)
    LinearLayout orderDetailRlLlTime;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.order_contact)
    TextView orderContact;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.order_phone)
    TextView orderPhone;
    @BindView(R.id.ll4)
    LinearLayout ll4;
    @BindView(R.id.order_detail_)
    LinearLayout orderDetail;
    @BindView(R.id.order_detail_address)
    LinearLayout orderDetailAddress;
    @BindView(R.id.order_detail_beizhu)
    TextView orderDetailBeizhu;
    @BindView(R.id.order_detail_noteInfo)
    TextView orderDetailNoteInfo;
    @BindView(R.id.rl_beizhu)
    RelativeLayout rlBeizhu;
    @BindView(R.id.order_detail_order_productNumber)
    TextView orderDetailOrderProductNumber;
    @BindView(R.id.ll_product_orderNumber)
    LinearLayout llProductOrderNumber;
    @BindView(R.id.come_order_detail_lv)
    NoScrollListview comeOrderDetailLv;
    private MyActivityManager myActivityManager;
    private Order.Result.Rows order;
    private SharedPreferences sp;
    private List<OrderDetail.Rows> orderDetails=new ArrayList<>();
    private CommonAdapter<OrderDetail.Rows> commonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_order_detail);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp=getSharedPreferences("DATA",MODE_PRIVATE);
        ButterKnife.bind(this);
        receiveData();
        initData();
    }

    private void receiveData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        order = (Order.Result.Rows) bundle.getSerializable("orderDetail");
    }

    private void initData() {
        getDatafromServer();
        //返回
        comeOrderDetailIvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //初始化数据
        orderDetailRlLlCompanyName.setText(order.aCompany.name);
        orderDetailRlLlOrderNumber.setText(order.aOrderNumber);//甲方订单编号
        orderDate.setText(order.takeOrderTime);
        orderEndDate.setText(order.delieverTime);
        orderDetailNoteInfo.setText(order.remarks);
        orderContact.setText(order.aCompany.master);
        orderPhone.setText(order.aCompany.phone);
        orderDetailOrderProductNumber.setText(order.bOrderNumber);
        //订单产品

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
   //订单详情
    public void getDatafromServer(){
        RequestParams rp=new RequestParams(NetUrlUtils.NET_URL+"order/orderDetail");
        rp.addBodyParameter("userId",sp.getString("USER_ID",null));
        rp.addBodyParameter("order.id",order.id);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("ComeOrderDetailActivity",result);
                Gson gson=new Gson();
                OrderDetail orderDetail= gson.fromJson(result, OrderDetail.class);
                Log.e("ComeOrderDetailActivity",orderDetail.toString());
                orderDetails.addAll(orderDetail.result.rows);
                if(commonAdapter==null) {
                    commonAdapter = new CommonAdapter<OrderDetail.Rows>(ComeOrderDetailActivity.this, orderDetails, R.layout.item_come_order_detail_product) {
                        @Override
                        public void convert(ViewHolder viewHolder, OrderDetail.Rows rows, int position) {
                            //根据当前位置获得当前对象
                            rows = orderDetails.get(position);
                            TextView order_detail_tv_proCateGory = viewHolder.getViewById(R.id.order_detail_tv_proCateGory);//产品类
                            TextView order_detail_ll_proCateGory_ruler = viewHolder.getViewById(R.id.order_detail_ll_proCateGory_ruler);//产品规格
                            TextView order_detail_ll_proCateGory_priority = viewHolder.getViewById(R.id.order_detail_ll_proCateGory_priority);//甲方优先级
                            TextView come_order_detail_single_price = viewHolder.getViewById(R.id.come_order_detail_single_price);//单价
                            TextView come_order_detail_tv_endDateHand = viewHolder.getViewById(R.id.come_order_detail_tv_endDateHand);//交货时间
                            TextView come_order_detail_tv_address = viewHolder.getViewById(R.id.come_order_detail_tv_address);//发货地址
                            TextView order_detail_tv_note = viewHolder.getViewById(R.id.order_detail_tv_note);//备注
                            TextView come_order_detail_tv_num = viewHolder.getViewById(R.id.come_order_detail_tv_num);//数量
                            TextView come_order_detail_tv_mine_priority = viewHolder.getViewById(R.id.come_order_detail_tv_mine_priority);//我方优先级

                            come_order_detail_single_price.setText(rows.price);
                            come_order_detail_tv_endDateHand.setText(rows.deliveryTime);
                            order_detail_tv_note.setText(rows.productDescription);
                            come_order_detail_tv_num.setText(rows.amount);
                        }
                    };
                    comeOrderDetailLv.setAdapter(commonAdapter);
                }else {
                    commonAdapter.notifyDataSetChanged();
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

    //加载订单产品
    public void loadOrderProduct(){

    }
}
