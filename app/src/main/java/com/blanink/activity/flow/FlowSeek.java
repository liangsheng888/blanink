package com.blanink.activity.flow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.adapter.AttributesAdapter;
import com.blanink.pojo.Attributes;
import com.blanink.pojo.CompanyProductCategory;
import com.blanink.pojo.OfficeEmp;
import com.blanink.pojo.OrderProductSpecifications;
import com.blanink.pojo.PartnerInfo;
import com.blanink.pojo.RelIndustryCategoryAttribute;
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

public class FlowSeek extends AppCompatActivity {
    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    @BindView(R.id.tv_customer)
    TextView tvCustomer;
    @BindView(R.id.sp_customer)
    Spinner spCustomer;
    @BindView(R.id.tv_product_category)
    TextView tvProductCategory;
    @BindView(R.id.sp_product_category)
    Spinner spProductCategory;
    @BindView(R.id.lv_product_attribute)
    NoScrollListview lvProductAttribute;
    @BindView(R.id.tv_order_state)
    TextView tvOrderState;
    @BindView(R.id.sp_order_state)
    Spinner spOrderState;
    @BindView(R.id.tv_mine_master)
    TextView tvMineMaster;
    @BindView(R.id.sp_mine_master)
    Spinner spMineMaster;
    @BindView(R.id.tv_resource)
    TextView tvResource;
    @BindView(R.id.sp_tv_resource)
    Spinner spTvResource;
    @BindView(R.id.tv_product_number)
    TextView tvProductNumber;
    @BindView(R.id.et_product_number)
    EditText etProductNumber;
    @BindView(R.id.tv_A_number)
    TextView tvANumber;
    @BindView(R.id.et_A_number)
    EditText etANumber;
    @BindView(R.id.tv_product_name)
    TextView tvProductName;
    @BindView(R.id.et_product_name)
    EditText etProductName;
    @BindView(R.id.btn_seek)
    Button btnSeek;
    @BindView(R.id.rl_seek)
    LinearLayout rlSeek;
    private MyActivityManager instance;
    private SharedPreferences sp;
    private RelIndustryCategoryAttribute attribute;
    private SparseArray<View> sparseArray;
    private String customer;
    private String master;
    private List<OrderProductSpecifications> orderProductSpecificationsList = new ArrayList<OrderProductSpecifications>();
    private List<OrderProductSpecifications> listSpinner = new ArrayList<OrderProductSpecifications>();
    private List<String> productCateGoryName = new ArrayList<>();//产品类名称
    private List<String> productCateGoryId = new ArrayList<>();//产品类名称id
    private List<String> customerNameList = new ArrayList<>();//客户名称
    private List<String> customerIdList = new ArrayList<>();
    private List<String> masterNameList = new ArrayList<>();//责任人
    private String[] orderStateList = {"选择订单状态", "甲方已创建未发送", "甲方已绑定订单未发送", "甲方已发给乙方", "乙方自己已创建",
            "待甲方确认/修改", "甲方已确认", "下发生产中", "流程已创建待发布", "流程已发布",
            "生产完成待发货", "部分发货", "全部发出", "已确认收到部分货", "确认收到全部货",
            "已完成评论和检讨", "待接受售后申请", "售后已接受处理中", "售后处理已结束", "售后被接受",
            "发起还款", "还款已被确认收到", "还款未收到", "拒绝生产"};
    private String[] resources = {"选择产品来源", "甲方传输来的", "乙方自己创建的", "发起售后的", "发起还款的"};
    private String bMasterId;
    private String orderProductStatus;
    private String resource;
    private String productName;
    public String bCompanyId;
    public String aCompanyId;
    public String aOrderNumber;
    public String bOrderNumber;
    public String companyCategoryId;
    public String bCompanyOrderOwnerUserId;
    private String flag;
    private List<String> bMasterIdList = new ArrayList<>();
    private ArrayList<RelIndustryCategoryAttribute.ResultBean> attributeList = new ArrayList<>();
    private AttributesAdapter attributeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_seek);
        instance = MyActivityManager.getInstance();
        instance.pushOneActivity(this);
        ButterKnife.bind(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initData();
    }

    private void initData() {
        flag = getIntent().getStringExtra("flag");
        //返回
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //加载客户
        getCustmoer();
        //加载产品类
        loadProductCategory();

        //获取责任人
        getCompanyEmp();

        //订单状态
        spOrderState.setAdapter(new ArrayAdapter<String>(FlowSeek.this, R.layout.simple_spinner_item, R.id.tv_name, orderStateList));
        spOrderState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    orderProductStatus = "";
                } else {
                    orderProductStatus = position + "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //产品来源
        spTvResource.setAdapter(new ArrayAdapter<String>(FlowSeek.this, R.layout.simple_spinner_item, R.id.tv_name, resources));
        spTvResource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    resource = "";
                } else {
                    resource = position + "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //搜索
        btnSeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productName = etProductName.getText().toString();
                aOrderNumber = etANumber.getText().toString();
                bOrderNumber = etProductNumber.getText().toString();
                if ("请选择我方负责人".equals(master)) {
                    bMasterId = "";
                }
                orderProductSpecificationsList.clear();
                for (int i = 0; i < lvProductAttribute.getChildCount(); i++) {
                    final List<OrderProductSpecifications> listEdit = new ArrayList<OrderProductSpecifications>();
                    final OrderProductSpecifications orderProductSpecifications = new OrderProductSpecifications();
                    final Attributes attributes = new Attributes();
                    LinearLayout layout = (LinearLayout) lvProductAttribute.getChildAt(i);// 获得子item的layout
                    if (attribute.getResult().get(i).getInputType().equals("1")) {
                        EditText et = (EditText) layout.findViewById(R.id.et_attribute);
                        attributes.setId(attribute.getResult().get(i).getAttribute().getId());
                        orderProductSpecifications.setAttribute(attributes);
                        orderProductSpecifications.setAttributeValue(et.getText().toString());
                        orderProductSpecifications.setAttributeSearchType("1");
                        listEdit.add(orderProductSpecifications);
                        orderProductSpecificationsList.addAll(listEdit);
                    }
                }
                //添加下拉框
                if (listSpinner != null) {
                    orderProductSpecificationsList.addAll(listSpinner);
                }

                Log.e("ComeOrder", orderProductSpecificationsList.size() + "___" + orderProductSpecificationsList.toString());
                Intent intent=null;
                intent = new Intent(FlowSeek.this, FlowSeekContent.class);
                intent.putExtra("aCompanyId", aCompanyId);
                intent.putExtra("bCompanyId", sp.getString("COMPANY_ID", null));
                intent.putExtra("productName", productName);
                intent.putExtra("aOrderNumber", aOrderNumber);
                intent.putExtra("bOrderNumber", bOrderNumber);
                intent.putExtra("companyCategoryId", companyCategoryId);
                intent.putExtra("bCompanyOrderOwnerUserId", bMasterId);
                intent.putExtra("orderProductStatus", orderProductStatus);
                intent.putExtra("source", resource);
                intent.putExtra("flag", flag);
                intent.putExtra("orderProductSpecificationsList", new Gson().toJson(orderProductSpecificationsList));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance.popOneActivity(this);
    }

    //加载客户
    private void getCustmoer() {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/officeList");
        rp.addBodyParameter("companyB.id", sp.getString("COMPANY_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                customerNameList.add("选择客户名称");
                customerIdList.add("");
                PartnerInfo partnerInfo = gson.fromJson(result, PartnerInfo.class);
                Log.e("FlowSeek", "解析前" + result.toString());
                Log.e("FlowSeek", "解析后" + partnerInfo.toString());

                if (partnerInfo.getResult().size() > 0) {
                    for (int i = 0; i < partnerInfo.getResult().size(); i++) {
                        customerNameList.add(partnerInfo.getResult().get(i).getCompanyA().getName());
                        customerIdList.add(partnerInfo.getResult().get(i).getCompanyA().getId());
                    }
                }
                if (partnerInfo.getResult().size() == 0) {
                    //  btnContiumeAdd.setText("你没有客户，无法添加订单");
                    // btnContiumeAdd.setBackgroundColor(getResources().getColor(R.color.colorGray));
                }
                spCustomer.setAdapter(new ArrayAdapter<String>(FlowSeek.this, R.layout.simple_spinner_item, R.id.tv_name, customerNameList));
                spCustomer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        customer = customerNameList.get(position);
                        aCompanyId = customerIdList.get(position);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

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

    //加载产品类
    public void loadProductCategory() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/categoryList");
        rp.addBodyParameter("company.id", sp.getString("COMPANY_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                productCateGoryName.add("选择产品类");
                productCateGoryId.add("");
                Gson gson = new Gson();
                CompanyProductCategory category = gson.fromJson(result, CompanyProductCategory.class);
                for (int i = 0; i < category.getResult().size(); i++) {
                    productCateGoryName.add(category.getResult().get(i).getName());
                    productCateGoryId.add(category.getResult().get(i).getId());
                }

                spProductCategory.setAdapter(new ArrayAdapter<String>(FlowSeek.this, R.layout.simple_spinner_item
                        , R.id.tv_name, productCateGoryName));

                spProductCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        companyCategoryId = productCateGoryId.get(position);
                        orderProductSpecificationsList.clear();
                        if (orderProductSpecificationsList.size() == 0) {

                            loadProductAttributes(companyCategoryId);

                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

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


    //加载产品属性
    public void loadProductAttributes(String productCategoryId) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/attributeList");
        rp.addBodyParameter("id", productCategoryId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();

                attribute = gson.fromJson(result, RelIndustryCategoryAttribute.class);
                attributeList.clear();
                if (attribute.getResult() != null) {
                    attributeList.addAll(attribute.getResult());
                    attributeAdapter = new AttributesAdapter(attributeList);
                    lvProductAttribute.setAdapter(attributeAdapter);
                }else {
                    attributeAdapter = new AttributesAdapter(attributeList);
                    lvProductAttribute.setAdapter(attributeAdapter);
                }

                //显示产品属性

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


    //加载订单状态

    //获得本公司人员列表
    private void getCompanyEmp() {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/userList");
        rp.addBodyParameter("id", sp.getString("COMPANY_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                masterNameList.add("请选择我方负责人");
                bMasterIdList.add("");
                Gson gson = new Gson();
                final OfficeEmp officeEmp = gson.fromJson(result, OfficeEmp.class);
                for (int i = 0; i < officeEmp.getResult().size(); i++) {
                    masterNameList.add(officeEmp.getResult().get(i).getName());
                    bMasterIdList.add(officeEmp.getResult().get(i).getId());
                }
                spMineMaster.setAdapter(new ArrayAdapter<String>(FlowSeek.this, R.layout.simple_spinner_item, R.id.tv_name, masterNameList));
                spMineMaster.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        master = masterNameList.get(position);
                        bMasterId = bMasterIdList.get(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

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

    //加载产品来源


    public class AttributesAdapter extends BaseAdapter {
        private List<RelIndustryCategoryAttribute.ResultBean> attributeLists;

        public AttributesAdapter(List<RelIndustryCategoryAttribute.ResultBean> attributeLists) {
            this.attributeLists = attributeLists;
        }

        @Override
        public int getCount() {
            return attributeLists.size();
        }

        @Override
        public Object getItem(int position) {
            return attributeLists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            Log.e("@@@", "getView");
            sparseArray = new SparseArray<>();
            ViewHolder viewHolder = null;
            if (sparseArray.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(FlowSeek.this, R.layout.attributes, null);
                viewHolder.tv_attribute_name = (TextView) convertView.findViewById(R.id.tv_attribute_name);
                viewHolder.sp_attribute_value = (Spinner) convertView.findViewById(R.id.sp_attribute_value);
                viewHolder.attribute_name = (TextView) convertView.findViewById(R.id.attribute_name);
                viewHolder.et_attribute = (EditText) convertView.findViewById(R.id.et_attribute);
                viewHolder.rl_edt = (LinearLayout) convertView.findViewById(R.id.rl_edt);
                viewHolder.rl_sp = (LinearLayout) convertView.findViewById(R.id.rl_sp);
                convertView.setTag(viewHolder);
                sparseArray.put(position, convertView);
            } else {
                convertView = sparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }

            if (attributeLists.get(position).getInputType().equals("1")) {
                //文本框
                viewHolder.rl_sp.setVisibility(View.GONE);
                viewHolder.rl_edt.setVisibility(View.VISIBLE);
                viewHolder.attribute_name.setText(attributeLists.get(position).getAttribute().getName() + ":");
            } else {
                //下拉框
                final OrderProductSpecifications orderProductSpecifications = new OrderProductSpecifications();
                final Attributes attribute = new Attributes();
                viewHolder.rl_edt.setVisibility(View.GONE);
                viewHolder.rl_sp.setVisibility(View.VISIBLE);
                viewHolder.tv_attribute_name.setText(attributeLists.get(position).getAttribute().getName() + ":");
                attribute.setId(attributeLists.get(position).getAttribute().getId());
                final String[] strHardCodeValue = attributeLists.get(position).getHardcodeValue().split(",");
                viewHolder.sp_attribute_value.setAdapter(new ArrayAdapter<String>(FlowSeek.this, R.layout.simple_spinner_item, R.id.tv_name, strHardCodeValue));
                viewHolder.sp_attribute_value.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        listSpinner.clear();
                        orderProductSpecifications.setAttribute(attribute);
                        orderProductSpecifications.setAttributeValue(strHardCodeValue[position]);
                        orderProductSpecifications.setAttributeSearchType("2");
                        listSpinner.add(orderProductSpecifications);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
            return convertView;
        }


    }

    static class ViewHolder {
        TextView tv_attribute_name;
        Spinner sp_attribute_value;
        TextView attribute_name;
        EditText et_attribute;
        LinearLayout rl_sp;
        LinearLayout rl_edt;
    }

}