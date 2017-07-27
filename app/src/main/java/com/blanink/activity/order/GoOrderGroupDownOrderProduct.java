package com.blanink.activity.order;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import com.blanink.pojo.GoFormDownOrder;
import com.blanink.pojo.ResponseDelete;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 组合下单 产品列表
 */
public class GoOrderGroupDownOrderProduct extends AppCompatActivity {

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
    @BindView(R.id.btn_go)
    Button btnGo;
    @BindView(R.id.tv_last)
    TextView tvLast;
    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    private MyActivityManager instance;
    private GoFormDownOrder.ResultBean orderProduct;
    private Map<Integer, Boolean> checkBoxIsChecked = new HashMap<>();
    private List<GoFormDownOrder.ResultBean.OrderProductListBean> productList = new ArrayList<>();
    private Map<Integer, GoFormDownOrder.ResultBean.OrderProductListBean> productMap = new HashMap<>();
    private int i=0;
    private SparseArray<View> sparseArray = new SparseArray<>();
    SwipeMenuCreator creator = new SwipeMenuCreator() {
        @Override
        public void create(SwipeMenu menu) {
            // 设置加入潜在框
            SwipeMenuItem seekProgressItem = new SwipeMenuItem(GoOrderGroupDownOrderProduct.this);
            seekProgressItem.setBackground(new ColorDrawable(getResources().getColor(R.color.colorBlue)));
            seekProgressItem.setWidth(dp2px(100));
            seekProgressItem.setTitle("编辑");
            seekProgressItem.setTitleSize(18);
            seekProgressItem.setTitleColor(Color.WHITE);
            menu.addMenuItem(seekProgressItem);

            SwipeMenuItem talkNoteItem = new SwipeMenuItem(GoOrderGroupDownOrderProduct.this);
            talkNoteItem.setBackground(new ColorDrawable(getResources().getColor(R.color.colorAccent)));
            talkNoteItem.setWidth(dp2px(100));
            talkNoteItem.setTitle("删除");
            talkNoteItem.setTitleSize(18);
            talkNoteItem.setTitleColor(Color.WHITE);
            menu.addMenuItem(talkNoteItem);
        }
    };
    private SharedPreferences sp;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_order_group_down_order_product);
        ButterKnife.bind(this);
        instance = MyActivityManager.getInstance();
        instance.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        receDataByIntent();
        lv.setMenuCreator(creator);
        lv.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // 编辑
                        Intent intent = new Intent(GoOrderGroupDownOrderProduct.this, GoOrderGroupDownOrderProductModify.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("orderProduct", productList.get(position));
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    case 1:
                        // 删除
                        Log.e("GoOrder", "position" + position);
                        Log.e("GoOrder", "删除" + productList.get(position).getProductName());
                        deleteNofity(productList.get(position).getId(), position, "你真要删除该产品吗?", "取消", "确定");
                        break;
                }
                return false;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GoOrderGroupDownOrderProduct.this, "position" + position, Toast.LENGTH_SHORT).show();
            }
        });

        //返回
        tvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //组合下单
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productMap.size() == 0) {
                    Toast.makeText(GoOrderGroupDownOrderProduct.this, "请选择产品进行组合下单！", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(GoOrderGroupDownOrderProduct.this, GoOrderGroupDownOrder.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("OrderProductMap", new Gson().toJson(productMap));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void receDataByIntent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        orderProduct = ((GoFormDownOrder.ResultBean) bundle.getSerializable("OrderProd"));
        productList.addAll(orderProduct.getOrderProductList());
        adapter = new MyAdapter(productList);
        lv.setAdapter(adapter);
        llLoad.setVisibility(View.GONE);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance.popOneActivity(this);
    }

    public int dp2px(float dipValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    private void deleteNofity(final String orderProductId, final int position, String content, String left, String right) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_exit);
        final Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        window.setAttributes(lp);
        ((TextView) window.findViewById(R.id.tv_content)).setText(content);
        ((TextView) window.findViewById(R.id.tv_continue)).setText(left);
        ((TextView) window.findViewById(R.id.tv_exit)).setText(right);
        window.findViewById(R.id.tv_continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        window.findViewById(R.id.tv_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogLoadUtils.getInstance(GoOrderGroupDownOrderProduct.this);
                DialogLoadUtils.showDialogLoad("删除中...");
                deleteData(orderProductId, position);
                alertDialog.dismiss();
            }
        });
    }

    public void deleteData(String orderProductId, final int position) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/delete_order_product_go");
        rp.addBodyParameter("orderProdId", orderProductId);
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));

        rp.addBodyParameter("userName", sp.getString("NAME", null));

        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ResponseDelete respone = gson.fromJson(result, ResponseDelete.class);
                if ("00000".equals(respone.getErrorCode())) {
                    DialogLoadUtils.dismissDialog();
                    productList.remove(position);
                    for (int i=position;i<productList.size();i++){
                        for (int j=i;j<checkBoxIsChecked.size();j++){
                            checkBoxIsChecked.put(i,checkBoxIsChecked.get(j+1));
                            break;
                        }
                    }
                        for (int i=position;i<productList.size();i++){
                            for (int j=i;j<productMap.size();j++){
                                productMap.put(i,productMap.get(j+1));
                                break;
                            }

                    }
                    i--;//选中条目减一
                    adapter.notifyDataSetChanged();
                    //通知订单界面刷新
                    Intent intent = new Intent("com.blanink.GO_ORDER_FORM_REFRESH_DATA");
                    intent.putExtra("flag", "REFRESH");
                    sendBroadcast(intent);
                    Toast.makeText(GoOrderGroupDownOrderProduct.this, "删除产品成功", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(GoOrderGroupDownOrderProduct.this, "删除产品失败", Toast.LENGTH_SHORT).show();
                    DialogLoadUtils.dismissDialog();

                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("come", ex.toString());
                DialogLoadUtils.dismissDialog();
                Toast.makeText(GoOrderGroupDownOrderProduct.this, "服务器开了会儿小车,请稍后重试", Toast.LENGTH_SHORT).show();

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

    public class MyAdapter extends BaseAdapter {
        private List<GoFormDownOrder.ResultBean.OrderProductListBean> productList;

        public MyAdapter(List<GoFormDownOrder.ResultBean.OrderProductListBean> productList) {
            this.productList = productList;
            init();
        }

        void init() {
            for (int i = 0; i < productList.size(); i++) {
                checkBoxIsChecked.put(i, false);
                productMap.put(i,null);
            }
        }

        @Override
        public int getCount() {
            return productList.size();
        }

        @Override
        public Object getItem(int position) {
            return productList.get(position);
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
                convertView = View.inflate(GoOrderGroupDownOrderProduct.this, R.layout.item_go_order_form_product, null);
                viewHolder.cb_check = (CheckBox) convertView.findViewById(R.id.cb_check);
                viewHolder.tv_delverTime = (TextView) convertView.findViewById(R.id.tv_delverTime);
                viewHolder.tv_product_name = (TextView) convertView.findViewById(R.id.tv_product_name);
                viewHolder.tv_product_category = (TextView) convertView.findViewById(R.id.tv_product_category);
                viewHolder.tv_amount = (TextView) convertView.findViewById(R.id.tv_amount);
                viewHolder.tv_price = (TextView) convertView.findViewById(R.id.tv_price);
                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.cb_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked) {
                        checkBoxIsChecked.put(position, true);
                        btnGo.setVisibility(View.VISIBLE);
                        productMap.put(position, productList.get(position));
                        i++;

                    } else {
                        checkBoxIsChecked.put(position, false);
                        productMap.put(position,null);
                        i--;
                    }
                    if (i > 0) {
                        btnGo.setVisibility(View.VISIBLE);
                    } else {
                        btnGo.setVisibility(View.GONE);
                    }
                }


            });
            if (checkBoxIsChecked.get(position) != null) {
                viewHolder.cb_check.setChecked(checkBoxIsChecked.get(position));
            }
            viewHolder.tv_delverTime.setText(productList.get(position).getDeliveryTime());
            viewHolder.tv_product_name.setText(productList.get(position).getProductName());
            viewHolder.tv_product_category.setText(productList.get(position).getCompanyCategory().getName());
            viewHolder.tv_amount.setText(productList.get(position).getAmount());
            viewHolder.tv_price.setText(productList.get(position).getPrice());
            return convertView;
        }
    }

    static class ViewHolder {
        CheckBox cb_check;
        TextView tv_delverTime;
        TextView tv_product_name;
        TextView tv_product_category;
        TextView tv_amount;
        TextView tv_price;
    }
}
