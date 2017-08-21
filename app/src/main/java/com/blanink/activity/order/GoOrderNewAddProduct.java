package com.blanink.activity.order;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.blanink.adapter.AttributesAdapter;
import com.blanink.adapter.PhotoAdapter;
import com.blanink.adapter.RecyclerItemClickListener;
import com.blanink.oss.OssService;
import com.blanink.pojo.Attributes;
import com.blanink.pojo.CompanyProductCategory;
import com.blanink.pojo.OrderDetail;
import com.blanink.pojo.OrderProductSpecifications;
import com.blanink.pojo.PartnerInfo;
import com.blanink.pojo.TypeCateGory;
import com.blanink.pojo.RelIndustryCategoryAttribute;
import com.blanink.pojo.ResponseOrder;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.CommonUtil;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
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

/**
 * Created by Administrator on 2017/5/22.
 * 去单 新增采购
 */
public class GoOrderNewAddProduct extends Activity {

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
    @BindView(R.id.tv_product_name2)
    TextView tvProductName2;
    @BindView(R.id.et_product_name)
    EditText etProductName;
    @BindView(R.id.rl_product_name)
    RelativeLayout rlProductName;
    private MyActivityManager instance;
    private OrderDetail.ResultBean orderProduct;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_order_new_add_product);
        instance = MyActivityManager.getInstance();
        instance.pushOneActivity(this);
        ButterKnife.bind(this);
        DialogLoadUtils.getInstance(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        oss = OssService.getOSSClientInstance(this);
        initData();
    }

    private void initData() {
        photoAdapter = new PhotoAdapter(this, selectedPhotos);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
        recyclerView.setAdapter(photoAdapter);
        //返回
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //供应商
        getSupplier();
        loadPriority();//加载优先级
        tvHandDate.setText(calendar.get(calendar.YEAR) + "-" + (calendar.get(calendar.MONTH) + 1) + "-" + calendar.get(calendar.DAY_OF_MONTH));
        tvHandDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dpd = new DatePickerDialog(GoOrderNewAddProduct.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvHandDate.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                        handTime = tvHandDate.getText().toString().trim();
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });

        //
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
                                    .start(GoOrderNewAddProduct.this);
                        } else {
                            PhotoPreview.builder()
                                    .setPhotos(selectedPhotos)
                                    .setCurrentItem(position)
                                    .start(GoOrderNewAddProduct.this);
                        }
                    }
                }));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amout = etNum.getText().toString().trim();
                productDescription = etNote.getText().toString().trim();
                price = etPrice.getText().toString().trim();
                if ("请选择供应商".equals(supplierName)) {
                    Toast.makeText(GoOrderNewAddProduct.this, "请选择供应商", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("请选择产品类".equals(companyCategoryName)) {
                    Toast.makeText(GoOrderNewAddProduct.this, "请选择产品类", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(etProductName.getText().toString())){
                    Toast.makeText(GoOrderNewAddProduct.this, "请填写产品规格", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(amout)) {
                    Toast.makeText(GoOrderNewAddProduct.this, "请填写数量", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(priority_value)) {
                    Toast.makeText(GoOrderNewAddProduct.this, "请选择优先级", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(price)) {
                    Toast.makeText(GoOrderNewAddProduct.this, "价格不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(productDescription)) {
                    Toast.makeText(GoOrderNewAddProduct.this, "请填写备注信息", Toast.LENGTH_SHORT).show();
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

                DialogLoadUtils.showDialogLoad("采购中...");
                UploadData();
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
                supllierNameList.add("请选择供应商");
                supplierIdList.add("");
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

                spSupplier.setAdapter(new ArrayAdapter<String>(GoOrderNewAddProduct.this, R.layout.spanner_item, supllierNameList));
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

    //加载产品类
    public void loadProductCategory(String companyId) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/categoryList");
        rp.addBodyParameter("company.id", companyId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                productCateGoryName.clear();
                productCateGoryId.clear();
                productCateGoryName.add("请选择产品类");
                productCateGoryId.add("");
                Gson gson = new Gson();
                CompanyProductCategory category = gson.fromJson(result, CompanyProductCategory.class);
                for (int i = 0; i < category.getResult().size(); i++) {
                    productCateGoryName.add(category.getResult().get(i).getName());
                    productCateGoryId.add(category.getResult().get(i).getId());
                }

                spProductCategory.setAdapter(new ArrayAdapter<String>(GoOrderNewAddProduct.this, R.layout.spanner_item
                        , productCateGoryName));

                spProductCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        companyCategoryId = productCateGoryId.get(position);
                        companyCategoryName = productCateGoryName.get(position);
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
                    attributeAdapter = new AttributesAdapter(GoOrderNewAddProduct.this, attributeList);
                    lvProductAttribute.setAdapter(attributeAdapter);
                } else {
                    attributeAdapter = new AttributesAdapter(GoOrderNewAddProduct.this, attributeList);
                    lvProductAttribute.setAdapter(attributeAdapter);
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
                spPriority.setAdapter(new ArrayAdapter<String>(GoOrderNewAddProduct.this, R.layout.spanner_item
                        ,priorityName));
                spPriority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        priority_value = (position+1) + "";
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

    public void UploadData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "order/save_go_self");
        rp.addBodyParameter("aCompanyId", sp.getString("COMPANY_ID", null));
        rp.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("orderList[0].crudType", "ADD");//备注
        rp.addBodyParameter("orderList[0].orderProductList[0].crudType", "ADD");//备注
        rp.addBodyParameter("orderList[0].orderProductList[0].bCompany.id", supplierId);//乙方公司id
        rp.addBodyParameter("orderList[0].orderProductList[0].companyCategory.name", companyCategoryName);
        rp.addBodyParameter("orderList[0].orderProductList[0].companyCategory.id", companyCategoryId);//产品类id
        rp.addBodyParameter("orderList[0].orderProductList[0].aOrderNumber", orderNumder);//订单编号
        rp.addBodyParameter("orderList[0].orderProductList[0].price", price);//价格
        rp.addBodyParameter("orderList[0].orderProductList[0].amount", amout);//数量
        rp.addBodyParameter("orderList[0].orderProductList[0].deliveryTime",tvHandDate.getText().toString());//交货时间
        rp.addBodyParameter("orderList[0].orderProductList[0].productDescription", productDescription);//产品备注
        rp.addBodyParameter("orderList[0].orderProductList[0].productName", etProductName.getText().toString());//产品规格
        rp.addBodyParameter("orderList[0].orderProductList[0].companyAPriority", priority_value);//甲方优先级
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
            fileSuffix = CommonUtil.getFileName(url);
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
                selectedPhotos.clear();
                if (photos != null) {
                    selectedPhotos.addAll(photos);
                    for (int i = 0; i < selectedPhotos.size(); i++) {
                        urls = urls + "|" + OssService.OSS_URL + "alioss_" + CommonUtil.getFileName(selectedPhotos.get(i));
                    }

                    urls = urls.substring(1);
                    Log.e("ComeOrder", urls);
                }


                photoAdapter.notifyDataSetChanged();
            }
        }
    }

    public void showNotifyTwo(String tilte, String btnLeft, String btnRight) {
        final AlertDialog alertDialog = new AlertDialog.Builder(GoOrderNewAddProduct.this).create();
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
                Intent intent = new Intent(GoOrderNewAddProduct.this, GoOrderPurchase.class);
                intent.putExtra("DIRECT","1");
                startActivity(intent);
            }
        });


    }
}
