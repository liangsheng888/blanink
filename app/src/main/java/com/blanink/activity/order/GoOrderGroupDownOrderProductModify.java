package com.blanink.activity.order;

import android.app.DatePickerDialog;
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
import com.blanink.adapter.PhotoAdapter;
import com.blanink.adapter.RecyclerItemClickListener;
import com.blanink.oss.OssService;
import com.blanink.pojo.Attributes;
import com.blanink.pojo.CompanyProductCategory;
import com.blanink.pojo.GoFormDownOrder;
import com.blanink.pojo.OneOrderProduct;
import com.blanink.pojo.OrderProd;
import com.blanink.pojo.OrderProductAttributes;
import com.blanink.pojo.OrderProductSpecifications;
import com.blanink.pojo.PartnerInfo;
import com.blanink.pojo.TypeCateGory;
import com.blanink.pojo.RelIndustryCategoryAttribute;
import com.blanink.pojo.ResponseOrder;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.ExampleUtil;
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
 * 组合下单产品编辑
 */
public class GoOrderGroupDownOrderProductModify extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.go_order_new_add_rl)
    RelativeLayout goOrderNewAddRl;
    @BindView(R.id.tv_supplier)
    TextView tvSupplier;
    @BindView(R.id.sp_supplier)
    Spinner spSupplier;
    @BindView(R.id.rl_supplier)
    RelativeLayout rlSupplier;
    @BindView(R.id.go_order_add_rl_supplier)
    LinearLayout goOrderAddRlSupplier;
    @BindView(R.id.tv_category)
    TextView tvCategory;
    @BindView(R.id.sp_product_category)
    Spinner spProductCategory;
    @BindView(R.id.rl_category)
    RelativeLayout rlCategory;
    @BindView(R.id.lv_product_attribute)
    NoScrollListview lvProductAttribute;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.et_num)
    EditText etNum;
    @BindView(R.id.rl_num)
    RelativeLayout rlNum;
    @BindView(R.id.tv_prioirty)
    TextView tvPrioirty;
    @BindView(R.id.sp_priority)
    Spinner spPriority;
    @BindView(R.id.rl_prioirty)
    RelativeLayout rlPrioirty;
    @BindView(R.id.tv_price2)
    TextView tvPrice2;
    @BindView(R.id.et_price)
    EditText etPrice;
    @BindView(R.id.rl_price)
    RelativeLayout rlPrice;
    @BindView(R.id.hand_date)
    TextView handDate;
    @BindView(R.id.tv_hand_date)
    TextView tvHandDate;
    @BindView(R.id.rl_hand_date)
    RelativeLayout rlHandDate;
    @BindView(R.id.go_order_add_ll)
    LinearLayout goOrderAddLl;
    @BindView(R.id.lv_major)
    NoScrollListview lvMajor;
    @BindView(R.id.tv_note)
    TextView tvNote;
    @BindView(R.id.et_note)
    EditText etNote;
    @BindView(R.id.rl_note)
    RelativeLayout rlNote;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.go_order_add_ll2)
    LinearLayout goOrderAddLl2;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.ll_save)
    LinearLayout llSave;
    @BindView(R.id.tv_product_name)
    TextView tvProductName;
    @BindView(R.id.et_product_name)
    EditText etProductName;
    @BindView(R.id.rl_product_name)
    RelativeLayout rlProductName;
    private MyActivityManager instance;
    private String orderNumder;
    private String companyName;
    private List<OrderProductSpecifications> orderProductSpecificationsList = new ArrayList<OrderProductSpecifications>();
    private List<OrderProductSpecifications> listSpinner = new ArrayList<OrderProductSpecifications>();
    private List<String> productCateGoryName = new ArrayList<>();//产品类名称
    private List<String> productCateGoryId = new ArrayList<>();//产品类名称id
    private List<String> supllierNameList = new ArrayList<>();//供应商
    private List<RelIndustryCategoryAttribute.ResultBean> attributeList = new ArrayList<>();
    private List<String> priorityValue = new ArrayList<>();
    private List<String> priorityName = new ArrayList<>();
    private ArrayList<String> selectedPhotos = new ArrayList<>();
    private SharedPreferences sp;
    private List<String> supplierIdList = new ArrayList<>();
    private String companyCategoryId;
    private String supplierName;
    private String supplierId;
    private RelIndustryCategoryAttribute attribute;


    private AttributesAdapter attributeAdapter;

    private String priority_value = "";
    Calendar calendar = Calendar.getInstance();
    private String handTime;
    private String urls = "";
    OSSClient oss;
    private String path;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            showNotifyTwo("保存成功", "继续采购", "我的订单");
        }
    };
    private PhotoAdapter photoAdapter;
    private String productName;
    private String productDescription;
    private String deliveryTime;
    private String amout;
    private String price;
    private String companyCategoryName;
    GoFormDownOrder.ResultBean.OrderProductListBean orderProduct;
    OneOrderProduct oneOrderProduct;
    private String productNote;
    private OrderProductAttributes attributes;
    private SparseArray<View> sparseArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_order_group_down_order_product_modify);
        instance = MyActivityManager.getInstance();
        instance.pushOneActivity(this);
        ButterKnife.bind(this);
        DialogLoadUtils.getInstance(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        oss = OssService.getOSSClientInstance(this);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        orderProduct = (GoFormDownOrder.ResultBean.OrderProductListBean) intent.getExtras().getSerializable("orderProduct");
        getLoadProdut();
        loadPriority();//加载优先级

        //返回
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //供应商

        tvHandDate.setText(orderProduct.getDeliveryTime());
        tvHandDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dpd = new DatePickerDialog(GoOrderGroupDownOrderProductModify.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvHandDate.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                        handTime = tvHandDate.getText().toString().trim();
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });

        //图片放大
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (photoAdapter.getItemViewType(position) == PhotoAdapter.TYPE_ADD) {
                            PhotoPicker.builder()
                                    .setPhotoCount(PhotoAdapter.MAX)
                                    .setShowCamera(true)
                                    .setPreviewEnabled(false)
                                    .setSelected(selectedPhotos)
                                    .start(GoOrderGroupDownOrderProductModify.this);
                        } else {
                            PhotoPreview.builder()
                                    .setPhotos(selectedPhotos)
                                    .setCurrentItem(position)
                                    .start(GoOrderGroupDownOrderProductModify.this);
                        }
                    }
                }));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amout = etNum.getText().toString().trim();
                productDescription = etNote.getText().toString().trim();
                price = etPrice.getText().toString().trim();
                productName = etProductName.getText().toString().trim();
                if ("请选择供应商".equals(supplierName)) {
                    Toast.makeText(GoOrderGroupDownOrderProductModify.this, "请选择供应商", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("请选择产品类".equals(companyCategoryName)) {
                    Toast.makeText(GoOrderGroupDownOrderProductModify.this, "请选择产品类", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("请选择产品类".equals(productName)) {
                    Toast.makeText(GoOrderGroupDownOrderProductModify.this, "请填写产品规格", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(amout)) {
                    Toast.makeText(GoOrderGroupDownOrderProductModify.this, "请填写数量", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(priority_value)) {
                    Toast.makeText(GoOrderGroupDownOrderProductModify.this, "请选择优先级", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(price)) {
                    Toast.makeText(GoOrderGroupDownOrderProductModify.this, "价格不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(productDescription)) {
                    Toast.makeText(GoOrderGroupDownOrderProductModify.this, "请填写备注信息", Toast.LENGTH_SHORT).show();
                    return;
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
                        listEdit.add(orderProductSpecifications);
                        orderProductSpecificationsList.addAll(listEdit);
                    }
                }
                //添加下拉框
                if (listSpinner != null) {
                    orderProductSpecificationsList.addAll(listSpinner);
                }
                OrderProd orderProd = new OrderProd(orderProduct.getId(), productName, price, amout, tvHandDate.getText().toString(), null, priority_value, productDescription, null);

                DialogLoadUtils.showDialogLoad("修改中...");
                UploadData(orderProd);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance.popOneActivity(this);
    }

    //选择供应商
    private void getSupplier() {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/partnerList");
        rp.addBodyParameter("companyA.id", sp.getString("COMPANY_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Log.e("GoOrder", "解析前" + result.toString());
                PartnerInfo partnerInfo = gson.fromJson(result, PartnerInfo.class);

                Log.e("GoOrder", "解析后" + partnerInfo.toString());
                if (partnerInfo.getResult().size() > 0) {
                    for (int i = 0; i < partnerInfo.getResult().size(); i++) {
                        supllierNameList.add(partnerInfo.getResult().get(i).getCompanyB().getName());
                        supplierIdList.add(partnerInfo.getResult().get(i).getCompanyB().getId());
                    }
                }
                if (partnerInfo.getResult().size() == 0) {
                    //  btnContiumeAdd.setText("你没有客户，无法添加订单");
                    // btnContiumeAdd.setBackgroundColor(getResources().getColor(R.color.colorGray));
                }

                spSupplier.setAdapter(new ArrayAdapter<String>(GoOrderGroupDownOrderProductModify.this, R.layout.spanner_item,supllierNameList));
                spSupplier.setSelection(getsupplierPosition(oneOrderProduct.getResult().getBCompany().getId()));
                spSupplier.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        supplierName = supllierNameList.get(position);
                        supplierId = supplierIdList.get(position);
                        loadProductCategory(supplierId);

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

    private void getLoadProdut() {

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/getOneOrderProduct");
        rp.addBodyParameter("id", orderProduct.getId());
        rp.addBodyParameter("order.id","");

        Log.e("GoOrder",NetUrlUtils.NET_URL + "order/getOneOrderProduct?id="+orderProduct.getId());
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();

                Log.e("GoOrder", "解析前" + result.toString());
                oneOrderProduct = gson.fromJson(result, OneOrderProduct.class);
                if (oneOrderProduct.getResult().getImages() != null) {
                    List<String> imageList = StringToListUtils.stringToList(oneOrderProduct.getResult().getImages(), "\\|");
                    for (String s : imageList) {
                        selectedPhotos.add(s);
                    }
                }
                photoAdapter = new PhotoAdapter(GoOrderGroupDownOrderProductModify.this, selectedPhotos);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
                recyclerView.setAdapter(photoAdapter);
                etNum.setText(oneOrderProduct.getResult().getAmount());
                etPrice.setText(oneOrderProduct.getResult().getPrice());
                etNote.setText(oneOrderProduct.getResult().getProductDescription());
                etProductName.setText(oneOrderProduct.getResult().getProductName());
                getSupplier();
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
    public void loadProductCategory(String companyId) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/categoryList");
        rp.addBodyParameter("company.id", companyId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("GoOrder", "加载产品类" + result.toString());

                productCateGoryName.clear();
                productCateGoryId.clear();
                Gson gson = new Gson();
                CompanyProductCategory category = gson.fromJson(result, CompanyProductCategory.class);
                for (int i = 0; i < category.getResult().size(); i++) {
                    productCateGoryName.add(category.getResult().get(i).getName());
                    productCateGoryId.add(category.getResult().get(i).getId());
                }

                spProductCategory.setAdapter(new ArrayAdapter<String>(GoOrderGroupDownOrderProductModify.this, R.layout.spanner_item
                        , productCateGoryName));
                spProductCategory.setSelection(getCompanyCategoryPosition(oneOrderProduct.getResult().getCompanyCategory().getId()));
                spProductCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        companyCategoryId = productCateGoryId.get(position);
                        companyCategoryName = productCateGoryName.get(position);
                        orderProductSpecificationsList.clear();
                        Log.e("GoOrder", "加载产品属性");

                        loadProductAttribute(companyCategoryId,orderProduct.getId());


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


    //加载公司产品属性
    public void loadProductAttributes(String productCategoryId) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/attributeList");
        rp.addBodyParameter("id", productCategoryId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                attribute = gson.fromJson(result, RelIndustryCategoryAttribute.class);
                lvProductAttribute.setAdapter(new AttributesAdapter(attribute.getResult()));

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

    //优先级
    public void loadPriority() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "Dict/listValueByType");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("type", "sys_assign_priority");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                TypeCateGory prioritys = gson.fromJson(result, TypeCateGory.class);
                for (int i = 0; i < prioritys.getResult().size(); i++) {
                    priorityValue.add(prioritys.getResult().get(i).getValue());
                    priorityName.add(prioritys.getResult().get(i).getLabel());
                }
                spPriority.setAdapter(new ArrayAdapter<String>(GoOrderGroupDownOrderProductModify.this, R.layout.spanner_item
                        , priorityName));
                spPriority.setSelection(getPriorityPosition(oneOrderProduct.getResult().getCompanyAPriority()));
                spPriority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        priority_value = (position + 1) + "";
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

    public void UploadData(OrderProd orderPro) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/save_order_prod_go");
        rp.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("orderProd", new Gson().toJson(orderPro));
        rp.addBodyParameter("prodCount", "0");
        rp.addBodyParameter("orderCount", "0");

        rp.addBodyParameter("orderList[0].orderProductList[0].images", urls);//产品图片
        for (int i = 0; i < orderProductSpecificationsList.size(); i++) {
            rp.addBodyParameter("orderList[0].orderProductList[0].orderProductSpecificationList[" + i + "].attribute.id", orderProductSpecificationsList.get(i).getAttribute().getId());
            rp.addBodyParameter("orderList[0].orderProductList[0].orderProductSpecificationList[" + i + "].attributeValue", orderProductSpecificationsList.get(i).getAttributeValue());

        }
        x.http().post(rp, new Callback.CacheCallback<String>() {


            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ResponseOrder response = gson.fromJson(result, ResponseOrder.class);
                if (response.getErrorCode().equals("00000")) {
                    List<String> photos = new ArrayList<String>();
                    photos.addAll(selectedPhotos);
                    uploadFiles(oss, photos);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();
                Log.e("ComeOrder", ex.toString());
                //Toast.makeText(ComeOrderAddProductActivity.this, "服务器异常", Toast.LENGTH_SHORT).show();
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
            fileSuffix = ExampleUtil.getFileName(url)+ExampleUtil.getFileLastName(url);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //选择返回
        if (resultCode == RESULT_OK &&
                (requestCode == PhotoPicker.REQUEST_CODE || requestCode == PhotoPreview.REQUEST_CODE)) {

            ArrayList<String> photos = null;
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                photoAdapter = new PhotoAdapter(this, selectedPhotos);
                selectedPhotos.clear();
                if (photos != null) {
                    selectedPhotos.addAll(photos);
                    for (int i = 0; i < selectedPhotos.size(); i++) {
                        urls = urls + "|" + OssService.OSS_URL+"alioss_"+ExampleUtil.getFileName(selectedPhotos.get(i)+ExampleUtil.getFileLastName(selectedPhotos.get(i)));
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

    public void showNotifyTwo(String tilte, String btnLeft, String btnRight) {
        final AlertDialog alertDialog = new AlertDialog.Builder(GoOrderGroupDownOrderProductModify.this).create();
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
                alertDialog.dismiss();
                Intent intent = new Intent(GoOrderGroupDownOrderProductModify.this, GoOrderPurchase.class);
                startActivity(intent);
            }
        });


    }


    //加载订单产品属性
    public void loadProductAttribute(final String companyCategoryId, String productId) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/orderProductAttribute");
        rp.addBodyParameter("id", productId);
        Log.e("GoOrder", NetUrlUtils.NET_URL + "order/orderProductAttribute?id=" + productId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("GoOrder", result);
                Gson gson = new Gson();
                attributes = gson.fromJson(result, OrderProductAttributes.class);
                Log.e("GoOrder", attributes.toString());
                loadProductAttributes(companyCategoryId);

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

    //判断 当前supplier所处位置
    public int getsupplierPosition(String id) {
        int position = 0;
        for (int i = 0; i < supplierIdList.size(); i++) {
            if (id.equals(supplierIdList.get(i))) {
                position = i;
            }
        }
        return position;
    }

    //判断 当前supplier所处位置
    public int getCompanyCategoryPosition(String id) {
        int position = 0;
        for (int i = 0; i < productCateGoryId.size(); i++) {
            if (id.equals(productCateGoryId.get(i))) {
                position = i;
            }
        }
        return position;
    }

    //判断 当前supplier所处位置
    public int getPriorityPosition(String id) {
        int position = 0;
        for (int i = 0; i < priorityValue.size(); i++) {
            if (id.equals(priorityValue.get(i))) {
                position = i;
            }
        }
        return position;
    }

    //判断 属性位置

    //判断 属性位置
    public int getAttributePosition(String attributeValue,String[] value) {
        int position = 0;
        for (int i = 0; i < value.length; i++) {
            if (attributeValue.equals(value[i])) {
                position = i;
            }
        }
        return position;
    }
    //判断 产品类位置


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
                convertView = View.inflate(GoOrderGroupDownOrderProductModify.this, R.layout.attributes, null);
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
                        viewHolder.sp_attribute_value.setAdapter(new ArrayAdapter<String>(GoOrderGroupDownOrderProductModify.this, R.layout.spanner_item, strHardCodeValue));
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
                } else if (i == attributes.getResult().getOrderProductSpecificationList().size()-1) {
                    //最后一个
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
                            viewHolder.sp_attribute_value.setAdapter(new ArrayAdapter<String>(GoOrderGroupDownOrderProductModify.this, R.layout.spanner_item,strHardCodeValue));
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
