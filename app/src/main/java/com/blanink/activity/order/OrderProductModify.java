package com.blanink.activity.order;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.blanink.R;
import com.blanink.activity.MainActivity;
import com.blanink.adapter.PhotoAdapter;
import com.blanink.adapter.RecyclerItemClickListener;
import com.blanink.oss.OssService;
import com.blanink.pojo.Attributes;
import com.blanink.pojo.CompanyProductCategory;
import com.blanink.pojo.OneOrderProduct;
import com.blanink.pojo.OrderProd;
import com.blanink.pojo.OrderProductAttributes;
import com.blanink.pojo.OrderProductSpecifications;
import com.blanink.pojo.TypeCateGory;
import com.blanink.pojo.RelIndustryCategoryAttribute;
import com.blanink.pojo.Response;
import com.blanink.utils.CommonUtil;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.StringToListUtils;
import com.blanink.view.NoScrollListview;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;

/***
 * 修改产品
 */
public class OrderProductModify extends AppCompatActivity {
    @BindView(R.id.come_order_detail_tv_seek)
    TextView comeOrderDetailTvSeek;
    @BindView(R.id.tv_last)
    TextView tvLast;
    @BindView(R.id.come_order_add_product_rl)
    RelativeLayout comeOrderAddProductRl;
    @BindView(R.id.tv_product_no)
    TextView tvProductNo;
    @BindView(R.id.et_product_no)
    EditText etProductNo;
    @BindView(R.id.tv_pro_category)
    TextView tvProCategory;
    @BindView(R.id.tv_product_category)
    TextView tvProductCategory;
    @BindView(R.id.gv_attributes)
    NoScrollListview gvAttributes;
    @BindView(R.id.tv_product)
    TextView tvProduct;
    @BindView(R.id.et_product_name)
    EditText etProductName;
    @BindView(R.id.tv_priority_a)
    TextView tvPriorityA;
    @BindView(R.id.sp_priority_a)
    Spinner spPriorityA;
    @BindView(R.id.tv_priority)
    TextView tvPriority;
    @BindView(R.id.sp_priority)
    Spinner spPriority;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.edt_number)
    EditText edtNumber;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.edt_price)
    EditText edtPrice;
    @BindView(R.id.tv_hand_date)
    TextView tvHandDate;
    @BindView(R.id.tv_hand_date_time)
    TextView tvHandDateTime;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.rl_product_date)
    LinearLayout rlProductDate;
    @BindView(R.id.tv_hand_date_in)
    TextView tvHandDateIn;
    @BindView(R.id.tv_hand_date_time_in)
    TextView tvHandDateTimeIn;
    @BindView(R.id.rl_in)
    RelativeLayout rlIn;
    @BindView(R.id.rl_product_date_in)
    LinearLayout rlProductDateIn;
    @BindView(R.id.et_note)
    EditText etNote;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.bt_save)
    Button btSave;
    @BindView(R.id.come_order_add_product_ll)
    LinearLayout comeOrderAddProductLl;
    private SharedPreferences sp;
    private List<String> priorityValue = new ArrayList<>();
    private List<String> priorityName = new ArrayList<>();

    private ArrayList<String> selectedPhotos = new ArrayList<>();
    PhotoAdapter photoAdapter;
    private List<String> productCateGoryName = new ArrayList<>();
    private List<String> productCateGoryId = new ArrayList<>();
    MyActivityManager myActivityManager;
    public String customer;
    public String aCompanyId;//甲方公司id
    public String orderNumber;//订单编号
    public String orderDate;//订单交货日期
    private String dateIn;//内部交货日期
    private String date;//产品交货日期
    public String orderNote;//订单备注
    public String bMasterId;//接单人id
    private String priority_value;//内部优先级
    private String priority_value_a;//甲方优先级
    private String cateGoryId;//产品类Id
    public String amout;//产品数量
    public String productNote;//产品备注
    public String productNumber;//生产编号
    public String productName;//规格名称
    public String price;//产品价格
    private List<OrderProductSpecifications> orderProductSpecificationsList = new ArrayList<OrderProductSpecifications>();
    final List<OrderProductSpecifications> listSpinner = new ArrayList<OrderProductSpecifications>();
    RelIndustryCategoryAttribute attribute;
    SparseArray<View> sparseArray;
    private Boolean isFirstAdd = true;//默认是第一次添加
    public String orderId;
    private OSSClient oss;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            showNotify(OrderProductModify.this, "修改产品成功");
        }
    };
    private String urls = "";
    private OneOrderProduct orderProduct;
    private OrderProductAttributes attributes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_product_modify);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        Bundle bundle = getIntent().getExtras();
        orderProduct = (OneOrderProduct) bundle.getSerializable("productDetail");
        oss = OssService.getOSSClientInstance(this);
        loadPriority();//设置有优先级
        loadProductAttribute(orderProduct.getResult().getId());

        //日期
        final Calendar calendar = Calendar.getInstance();

        tvHandDateTime.setText(orderProduct.getResult().getDeliveryTime());
        tvHandDateTimeIn.setText(orderProduct.getResult().getInnerDeliveryTimeString());
        etProductName.setText(orderProduct.getResult().getProductName());
        etProductNo.setText(orderProduct.getResult().getProductSn());
        etNote.setText(orderProduct.getResult().getProductDescription());
        edtPrice.setText(orderProduct.getResult().getPrice());
        edtNumber.setText(orderProduct.getResult().getAmount());
        if (orderProduct.getResult().getImages() != null) {
            List<String> imageList = StringToListUtils.stringToList(orderProduct.getResult().getImages(), "\\|");

            for (String s : imageList) {
                selectedPhotos.add(s);
            }
        }
        photoAdapter = new PhotoAdapter(OrderProductModify.this, selectedPhotos);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
        recyclerView.setAdapter(photoAdapter);

        tvHandDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dpd = new DatePickerDialog(OrderProductModify.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvHandDateTime.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                        date = tvHandDateTime.getText().toString().trim();
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });
        //内部交货日期
        tvHandDateTimeIn.setText(orderProduct.getResult().getInnerDeliveryTimeString());
        tvHandDateTimeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dpd = new DatePickerDialog(OrderProductModify.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvHandDateTimeIn.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                        dateIn = tvHandDateTimeIn.getText().toString().trim();
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });
        //返回
        tvLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //图片放大
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (photoAdapter.getItemViewType(position) == PhotoAdapter.TYPE_ADD) {
                            PhotoPicker.builder()
                                    .setPhotoCount(3)
                                    .setShowCamera(true)
                                    .setPreviewEnabled(false)
                                    .setSelected(selectedPhotos)
                                    .start(OrderProductModify.this);
                        } else {
                            PhotoPreview.builder()
                                    .setPhotos(selectedPhotos)
                                    .setCurrentItem(position)
                                    .start(OrderProductModify.this);
                        }
                    }
                }));
        //保存订单
        btSave.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                orderProductSpecificationsList.clear();
                for (int i = 0; i < gvAttributes.getChildCount(); i++) {
                    final List<OrderProductSpecifications> listEdit = new ArrayList<OrderProductSpecifications>();
                    final OrderProductSpecifications orderProductSpecifications = new OrderProductSpecifications();
                    final Attributes attributes = new Attributes();
                    LinearLayout layout = (LinearLayout) gvAttributes.getChildAt(i);// 获得子item的layout
                    if (attribute.getResult().get(i).getInputType().equals("1")) {
                        EditText et = (EditText) layout.findViewById(R.id.et_attribute);
                        attributes.setId(attribute.getResult().get(i).getAttribute().getId());
                        orderProductSpecifications.setAttribute(attributes);
                        orderProductSpecifications.setAttributeValue(et.getText().toString());
                        listEdit.add(orderProductSpecifications);
                        orderProductSpecificationsList.addAll(listEdit);
                    }
                }
                //添加下拉框
                if (listSpinner != null) {
                    orderProductSpecificationsList.addAll(listSpinner);
                }

                Log.e("ComeOrder", orderProductSpecificationsList.size() + "___" + orderProductSpecificationsList.toString());
                productName = etProductName.getText().toString().trim();
                productNumber = etProductNo.getText().toString().trim();
                productNote = etNote.getText().toString().trim();
                amout = edtNumber.getText().toString().trim();
                price = edtPrice.getText().toString().trim();
                date = tvHandDateTime.getText().toString().trim();
                dateIn = tvHandDateTimeIn.getText().toString().trim();
                orderNote = etNote.getText().toString().trim();
                if (TextUtils.isEmpty(productNumber)) {
                    Toast.makeText(OrderProductModify.this, "请填写生产编号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(productName)) {
                    Toast.makeText(OrderProductModify.this, "请输入产品名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(amout)) {
                    Toast.makeText(OrderProductModify.this, "请输入产品数量", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(price)) {
                    Toast.makeText(OrderProductModify.this, "请输入产品单价", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(orderNote)) {
                    Toast.makeText(OrderProductModify.this, "请填写备注", Toast.LENGTH_SHORT).show();
                    return;
                }
                OrderProd orderProd = new OrderProd(orderProduct.getResult().getId(), productName, price, amout, date, dateIn, priority_value, productNote, productNumber);
                String aid_kv = "";
                for (int i = 0; i < orderProductSpecificationsList.size(); i++) {
                    aid_kv += "," + (orderProductSpecificationsList.get(i).getAttribute().getId() + "=" + orderProductSpecificationsList.get(i).getAttributeValue());
                }
                aid_kv = aid_kv.substring(1);
                DialogLoadUtils.getInstance(OrderProductModify.this);
                DialogLoadUtils.showDialogLoad("修改产品中...");
                ModifyOrder(new Gson().toJson(orderProd), aid_kv);
            }
        });

    }

    private void ModifyOrder(String orderProd, String aid_kv) {
        //http://localhost:8088/blanink-api/order/saveOrder?
        // userId=fec25c7f7634448581e21876ef517c57
        // &aCompany.id&
        // bCompany.id&
        // bCompanyOrderOwnerUser.id&
        // aOrderNumber&
        // bOrderNumber&
        // delieverTime&
        // remarks&
        // orderProductList.companyCategory.id
        // &orderProductList.price
        // &orderProductList.amount
        // &orderProductList.productDescription
        // &orderProductList.remarks
        // &orderProductList.productName
        // &orderProductList.deliveryTime
        // &orderProductList.innerDeliveryTimeString
        // &orderProductList.companyAPriority
        // &orderProductList.companyBPriority
        // &orderProductList.productSn
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/save_order_prod");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("orderProd", orderProd);
        rp.addBodyParameter("aid_kv", aid_kv);
        Log.e("OrderProductModify", NetUrlUtils.NET_URL + "order/save_order_prod?orderProd=" + orderProd.toString() + "&aid_kv=" + aid_kv);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                DialogLoadUtils.dismissDialog();
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if (response.getErrorCode().equals("00000")) {
                    List<String> photos = new ArrayList<String>();
                    photos.addAll(selectedPhotos);
                    uploadFiles(oss, photos);
                } else {
                    DialogLoadUtils.dismissDialog();
                    Toast.makeText(OrderProductModify.this, "修改失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();
                Log.e("ComeOrder", ex.toString());
                //Toast.makeText(ComeOrderContinueAddProductActivity.this, "服务器异常", Toast.LENGTH_SHORT).show();
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
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    //优先级
    public void loadPriority() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "Dict/listValueByType");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("type", "sys_assign_priority");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("WorkPlanToAllocation", result);
                Gson gson = new Gson();
                TypeCateGory prioritys = gson.fromJson(result, TypeCateGory.class);
                for (int i = 0; i < prioritys.getResult().size(); i++) {
                    priorityValue.add(prioritys.getResult().get(i).getValue());
                    priorityName.add(prioritys.getResult().get(i).getLabel());
                }
                //内部优先级
                spPriority.setAdapter(new ArrayAdapter<String>(OrderProductModify.this, R.layout.spanner_item
                        , priorityName));
                //甲方优先级
                spPriorityA.setAdapter(new ArrayAdapter<String>(OrderProductModify.this, R.layout.spanner_item
                        , priorityName));
                spPriority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        priority_value = (position + 1) + "";
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                spPriorityA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        priority_value_a = (position + 1) + "";
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

    //产品类
    public void loadProductCategory() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/categoryList");
        rp.addBodyParameter("company.id", sp.getString("COMPANY_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                CompanyProductCategory category = gson.fromJson(result, CompanyProductCategory.class);
                for (int i = 0; i < category.getResult().size(); i++) {
                    productCateGoryName.add(category.getResult().get(i).getName());
                    productCateGoryId.add(category.getResult().get(i).getId());
                }

                tvProductCategory.setText(orderProduct.getResult().getCompanyCategory().getName());
                loadProductAttributes(orderProduct.getResult().getCompanyCategory().getId());

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
        //选择返回
        if (resultCode == RESULT_OK &&
                (requestCode == PhotoPicker.REQUEST_CODE || requestCode == PhotoPreview.REQUEST_CODE)) {

            ArrayList<String> photos = null;
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                selectedPhotos.clear();
                if (photos != null) {
                    selectedPhotos.addAll(photos);
                    for (int i = 0; i < selectedPhotos.size(); i++) {

                        urls = urls + "|" + OssService.OSS_URL + "alioss_" + CommonUtil.getFileName(selectedPhotos.get(i) + CommonUtil.getFileLastName(selectedPhotos.get(i)));
                    }
                    if (selectedPhotos.size() > 0) {
                        urls = urls.substring(1);
                    }
                    Log.e("ComeOrder", urls);
                }
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
                recyclerView.setAdapter(photoAdapter);
                photoAdapter.notifyDataSetChanged();
            }
        }
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
                Log.e("GoOrder", "属性个数:" + attribute.getResult().size() + "");
                gvAttributes.setAdapter(new AttributesAdapter(attribute.getResult()));
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

    //
    public void showNotifyTwo(String tilte, String btnLeft, String btnRight) {
        final AlertDialog alertDialog = new AlertDialog.Builder(OrderProductModify.this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_bid);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        WindowManager windowManager = getWindowManager();
        Display d = windowManager.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);
        alertDialog.setCanceledOnTouchOutside(false);
        ((TextView) (window.findViewById(R.id.tv_message))).setText(tilte);
        ((TextView) (window.findViewById(R.id.tv_continue))).setText(btnLeft);
        ((TextView) (window.findViewById(R.id.tv_seek))).setText(btnRight);
        window.findViewById(R.id.tv_continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog.dismiss();
            }
        });

        window.findViewById(R.id.tv_seek).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OrderProductModify.this, MainActivity.class);
                intent.putExtra("DIRECT", 1);
                startActivity(intent);
                alertDialog.dismiss();
            }
        });


    }

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
                convertView = View.inflate(OrderProductModify.this, R.layout.attributes, null);
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
            //显示上个界面的属性值
            for (int i = 0; i < attributes.getResult().getOrderProductSpecificationList().size(); i++) {

                if (attributes.getResult().getOrderProductSpecificationList().get(i).getAttribute().getId().equals(attributeLists.get(position).getAttribute().getId())) {

                    if (attributeLists.get(position).getInputType().equals("1")) {
                        //文本框
                        viewHolder.rl_sp.setVisibility(View.GONE);
                        viewHolder.rl_edt.setVisibility(View.VISIBLE);
                        viewHolder.attribute_name.setText(attributes.getResult().getOrderProductSpecificationList().get(i).getAttribute().getName() + ":");
                        viewHolder.et_attribute.setText(attributes.getResult().getOrderProductSpecificationList().get(i).getAttributeValue());
                    } else {
                        //下拉框
                        final OrderProductSpecifications orderProductSpecifications = new OrderProductSpecifications();
                        final Attributes attribute = new Attributes();
                        viewHolder.rl_edt.setVisibility(View.GONE);
                        viewHolder.rl_sp.setVisibility(View.VISIBLE);
                        viewHolder.tv_attribute_name.setText(attributes.getResult().getOrderProductSpecificationList().get(i).getAttribute().getName() + ":");
                        attribute.setId(attributeLists.get(position).getAttribute().getId());
                        final String[] strHardCodeValue = attributeLists.get(position).getHardcodeValue().split(",");
                        viewHolder.sp_attribute_value.setAdapter(new ArrayAdapter<String>(OrderProductModify.this, R.layout.spanner_item, strHardCodeValue));
                        viewHolder.sp_attribute_value.setSelection(getAttributePosition(attributes.getResult().getOrderProductSpecificationList().get(i).getAttributeValue(), strHardCodeValue), true);
                        viewHolder.sp_attribute_value.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                listSpinner.clear();
                                orderProductSpecifications.setAttribute(attribute);
                                orderProductSpecifications.setAttributeValue(strHardCodeValue[position]);
                                listSpinner.add(orderProductSpecifications);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                    break;
                } else {
                    //如果是最后一个
                    if (i == attributes.getResult().getOrderProductSpecificationList().size()-1) {
                        if (attributeLists.get(position).getInputType().equals("1")) {
                            //文本框
                            viewHolder.rl_sp.setVisibility(View.GONE);
                            viewHolder.rl_edt.setVisibility(View.VISIBLE);
                            viewHolder.attribute_name.setText(attributeLists.get(position).getAttribute().getName() + ":");
                            viewHolder.et_attribute.setText(attributeLists.get(position).getHardcodeValue());
                        } else {
                            //下拉框
                            final OrderProductSpecifications orderProductSpecifications = new OrderProductSpecifications();
                            final Attributes attribute = new Attributes();
                            viewHolder.rl_edt.setVisibility(View.GONE);
                            viewHolder.rl_sp.setVisibility(View.VISIBLE);
                            viewHolder.tv_attribute_name.setText(attributeLists.get(position).getAttribute().getName() + ":");
                            attribute.setId(attributeLists.get(position).getAttribute().getId());
                            final String[] strHardCodeValue = attributeLists.get(position).getHardcodeValue().split(",");
                            viewHolder.sp_attribute_value.setAdapter(new ArrayAdapter<String>(OrderProductModify.this, R.layout.spanner_item,strHardCodeValue));
                            viewHolder.sp_attribute_value.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    listSpinner.clear();
                                    orderProductSpecifications.setAttribute(attribute);
                                    orderProductSpecifications.setAttributeValue(strHardCodeValue[position]);
                                    listSpinner.add(orderProductSpecifications);
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        }
                    }
                }

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

    public void uploadFiles(OSSClient oss, List<String> urls) {
        if (null == urls || urls.size() == 0) {
            return;
        } // 上传文件
        ossUpload(oss, urls);
    }

    public void ossUpload(final OSSClient oss, final List<String> urls) {
        Log.e("ComeOrder", "图片个数:" + urls.size());
        if (urls.size() <= 0) {
            Log.e("ComeOrder", "通知提醒");
            DialogLoadUtils.dismissDialog();

            handler.sendEmptyMessage(0);
            // 文件全部上传完毕，这里编写上传结束的逻辑，如果要在主线程操作，最好用Handler或runOnUiThead做对应逻辑
            return;// 这个return必须有，否则下面报越界异常，原因自己思考下哈
        }
        final String url = urls.get(0);
        if (TextUtils.isEmpty(url)) {
            urls.remove(0);
            // url为空就没必要上传了，这里做的是跳过它继续上传的逻辑。
            ossUpload(oss, urls);
            return;
        }

        File file = new File(url);
        if (null == file || !file.exists()) {
            urls.remove(0);
            // 文件为空或不存在就没必要上传了，这里做的是跳过它继续上传的逻辑。
            ossUpload(oss, urls);
            return;
        }
        // 文件后缀
        String fileSuffix = "";
        if (file.isFile()) {
            // 获取文件后缀名
            fileSuffix = CommonUtil.getFileName(url) + CommonUtil.getFileName(url);
        }
        // 文件标识符objectKey
        final String objectKey = "alioss_" + fileSuffix;
        // 下面3个参数依次为bucket名，ObjectKey名，上传文件路径
        PutObjectRequest put = new PutObjectRequest("blanink", objectKey, url);

        // 设置进度回调
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                // 进度逻辑
            }
        });

        // 异步上传
        OSSAsyncTask task = oss.asyncPutObject(put,
                new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                    @Override
                    public void onSuccess(PutObjectRequest request, PutObjectResult result) { // 上传成功
                        urls.remove(0);
                        ossUpload(oss, urls);// 递归同步效果
                    }

                    @Override
                    public void onFailure(PutObjectRequest request, ClientException clientExcepion,
                                          ServiceException serviceException) { // 上传失败

                        // 请求异常
                        if (clientExcepion != null) {
                            // 本地异常如网络异常等
                            clientExcepion.printStackTrace();
                        }
                        if (serviceException != null) {
                            // 服务异常
                            Log.e("ErrorCode", serviceException.getErrorCode());
                            Log.e("RequestId", serviceException.getRequestId());
                            Log.e("HostId", serviceException.getHostId());
                            Log.e("RawMessage", serviceException.getRawMessage());
                        }
                    }
                });
        // task.cancel(); // 可以取消任务
        // task.waitUntilFinished(); // 可以等待直到任务完成
    }


    public void showNotify(final Context context, String tilte) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_apply_delete_relation);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        WindowManager windowManager = (WindowManager)
                context.getSystemService(Context.WINDOW_SERVICE);
        Display d = windowManager.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);
        alertDialog.setCanceledOnTouchOutside(false);
        ((TextView) (window.findViewById(R.id.tv_message))).setText(tilte);
        window.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                finish();
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
                attributes = gson.fromJson(result, OrderProductAttributes.class);
                Log.e("ComeOrderProductDetail", attributes.toString());
                loadProductCategory();//显示产品

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

    //判断 属性位置
    public int getAttributePosition(String attributeValue, String[] value) {
        int position = 0;
        for (int i = 0; i < value.length; i++) {
            if (attributeValue.equals(value[i])) {
                position = i;
            }
        }
        return position;
    }
}
