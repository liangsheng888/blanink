package com.blanink.activity.flow;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.blanink.R;
import com.blanink.activity.order.ComeOrderProductDetailTalkNote;
import com.blanink.activity.order.GoComeOrderProduct;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.OrderProgress;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.OrderProductStateUtils;
import com.blanink.utils.StringToListUtils;
import com.blanink.utils.XUtilsImageUtils;
import com.blanink.view.UpLoadListView;
import com.google.gson.Gson;

import java.io.IOException;
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

/****
 * 流程完成进度
 */
public class FlowProgress extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    @BindView(R.id.lv)
    SwipeMenuListView lv;
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
    private SwipeMenuCreator creator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_progress);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        Bundle bundle = getIntent().getExtras();
        final OrderProgress orderProgress = ((OrderProgress) bundle.getSerializable("orderProgress"));
        llLoad.setVisibility(View.GONE);
        lv.setAdapter(new OrderProductAdapter(orderProgress.getResult()));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent(FlowProgress.this,FlowProgressProductDetail.class);
                it.putExtra("orderProductId",orderProgress.getResult().get(position).getId());
                startActivity(it);
            }
        });

        lv.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                if (orderProgress.getResult().get(position).getFlow()!= null) {
                    switch (index) {
                        case 0:
                            Intent intent = new Intent(FlowProgress.this, FlowProgressDetail.class);
                            intent.putExtra("flowId", orderProgress.getResult().get(position).getFlow().getId());
                            startActivity(intent);
                            break;
                        case 1:
                            Intent it=new Intent(FlowProgress.this,FlowProgressProductDetail.class);
                            it.putExtra("orderProductId",orderProgress.getResult().get(position).getId());
                            startActivity(it);
                            break;
                    }
                } else {
                    Intent it=new Intent(FlowProgress.this,FlowProgressProductDetail.class);
                    it.putExtra("orderProductId",orderProgress.getResult().get(position).getId());
                    startActivity(it);
                }
                return false;
            }
        });
        //返回
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public class OrderProductAdapter extends BaseAdapter {
        private List<OrderProgress.ResultBean> or;

        public OrderProductAdapter(List<OrderProgress.ResultBean> or) {
            this.or = or;
        }

        @Override
        public int getCount() {
            return or.size();
        }

        @Override
        public Object getItem(int position) {
            return or.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(FlowProgress.this, R.layout.item_go_come_order_son_product, null);
                viewHolder.tv_product_name = (TextView) convertView.findViewById(R.id.tv_product_name);
                viewHolder.come_order_detail_single_price = (TextView) convertView.findViewById(R.id.tv_price);
                viewHolder.come_order_detail_tv_endDateHand = (TextView) convertView.findViewById(R.id.tv_deliver_time);
                viewHolder.come_order_detail_tv_num = (TextView) convertView.findViewById(R.id.tv_pro_num);
                viewHolder.order_product_state = (TextView) convertView.findViewById(R.id.tv_state);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            //添加备注
            //编辑订单产品
            creator = new SwipeMenuCreator() {
                @Override
                public void create(final SwipeMenu menu) {
                    // 设置加入潜在框

                    if (or.get(position).getFlow()!=null) {
                        SwipeMenuItem seekProgressItem = new SwipeMenuItem(FlowProgress.this);
                        seekProgressItem.setBackground(new ColorDrawable(getResources().getColor(R.color.colorGray)));
                        seekProgressItem.setWidth(dp2px(100));
                        seekProgressItem.setTitle("采购进展");
                        seekProgressItem.setTitleSize(18);
                        seekProgressItem.setTitleColor(Color.WHITE);
                        menu.addMenuItem(seekProgressItem);
                    }
                    SwipeMenuItem talkNoteItem = new SwipeMenuItem(FlowProgress.this);
                    talkNoteItem.setBackground(new ColorDrawable(getResources().getColor(R.color.colorBlue)));
                    talkNoteItem.setWidth(dp2px(100));
                    talkNoteItem.setTitle("查看");
                    talkNoteItem.setTitleSize(18);
                    talkNoteItem.setTitleColor(Color.WHITE);
                    menu.addMenuItem(talkNoteItem);

                }
            };
            lv.setMenuCreator(creator);
            //下发产品
            viewHolder.come_order_detail_single_price.setText(or.get(position).getPrice());

            viewHolder.come_order_detail_tv_endDateHand.setText(or.get(position).getDeliveryTime());

            viewHolder.come_order_detail_tv_num.setText(or.get(position).getAmount());
            String orderProductState = OrderProductStateUtils.orderProductStatus(or.get(position).getOrderProductStatus());
            viewHolder.order_product_state.setText(orderProductState);
            viewHolder.tv_product_name.setText(or.get(position).getProductName());
            if (or.get(position).getImages() != null) {
                GlideUtils.glideImageView(FlowProgress.this,viewHolder.iv, StringToListUtils.stringToList(or.get(position).getImages(), "\\|").get(0),false);
            }
            return convertView;
        }
    }

    static class ViewHolder {
        TextView order_product_state;//订单状态
        TextView come_order_detail_single_price;//单价
        TextView come_order_detail_tv_endDateHand;//交货时间
        TextView come_order_detail_tv_num;//数量
        TextView tv_product_name;//产品规格
        ImageView iv;//图片
    }

    public int dp2px(float dipValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
