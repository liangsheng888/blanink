package com.blanink.activity.afterSale;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import com.blanink.adapter.PhotoAdapter;
import com.blanink.adapter.RecyclerItemClickListener;
import com.blanink.oss.OssService;
import com.blanink.pojo.ResponseDelete;
import com.blanink.pojo.TypeCateGory;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.StringToListUtils;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/***
 * 售后 提出要求
 */
public class AfterSaleDemandModify extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.rl_after_sale_demand)
    RelativeLayout rlAfterSaleDemand;
    @BindView(R.id.tv_reason)
    TextView tvReason;
    @BindView(R.id.sp_reason)
    Spinner spReason;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.iv_picture)
    ImageView ivPicture;
    @BindView(R.id.tv_specific_description_to_demand)
    TextView tvSpecificDescriptionToDemand;
    @BindView(R.id.et_description_to_demand)
    EditText etDescriptionToDemand;
    @BindView(R.id.ll_chat)
    LinearLayout llChat;
    @BindView(R.id.btn_ok)
    Button btnOk;
    @BindView(R.id.activity_after_sale_demand)
    RelativeLayout activityAfterSaleDemand;
    private SharedPreferences sp;
    private String value;
    private ArrayList<String> selectedPhotos = new ArrayList<>();
    PhotoAdapter photoAdapter;
    private String urls = "";
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(AfterSaleDemandModify.this, "操作成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        }
    };
    private OSSClient oss;
    final List<String> valueList = new ArrayList<String>();
    final List<String> nameList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sale_apply);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        oss = OssService.getOSSClientInstance(this);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        if (!"".equals(getIntent().getStringExtra("images"))) {
            List<String> list = StringToListUtils.stringToList(getIntent().getStringExtra("images"), ",");
            Log.e("@@@", list.toString());
            selectedPhotos.addAll(list);
        }


        photoAdapter = new PhotoAdapter(this, selectedPhotos);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
        recyclerView.setAdapter(photoAdapter);
        etDescriptionToDemand.setText(getIntent().getStringExtra("remarks"));
        getTypeGory();
        //返回
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //选择图片
        ivPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhotoPicker.builder()
                        //设置选择个数
                        .setPhotoCount(3)
                        //选择界面第一个显示拍照按钮
                        .setShowCamera(true)
                        //选择时点击图片放大浏览
                        .setPreviewEnabled(false)
                        //附带已经选中过的图片
                        .start(AfterSaleDemandModify.this);
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
                                    .setPhotoCount(PhotoAdapter.MAX)
                                    .setShowCamera(true)
                                    .setPreviewEnabled(false)
                                    .setSelected(selectedPhotos)
                                    .start(AfterSaleDemandModify.this);
                        } else {
                            PhotoPreview.builder()
                                    .setPhotos(selectedPhotos)
                                    .setCurrentItem(position)
                                    .start(AfterSaleDemandModify.this);
                        }
                    }
                }));
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String note = etDescriptionToDemand.getText().toString();
                if ("0".equals(value)) {
                    Toast.makeText(AfterSaleDemandModify.this, "请选择发起缘由", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogLoadUtils.getInstance(AfterSaleDemandModify.this);
                DialogLoadUtils.showDialogLoad("正在修改中...");
                saveAfterSales(getIntent().getStringExtra("orderProductCompanyId"), getIntent().getStringExtra("orderProductId"), note, getIntent().getStringExtra("type"), urls);
            }
        });

    }

    public void saveAfterSales(String orderProdCompanyId, String orderProductId, final String reason, String type, String images) {
        //http://localhost:8080/blanink-api/afterSales/saveAfterSales?orderProdCompany.id&reason&orderProduct.id&remarks&curentUser.id&images
        String url = NetUrlUtils.NET_URL + "afterSales/saveAfterSales";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("currentUser.id", sp.getString("USER_ID", null))
                .add("orderProdCompany.id", orderProdCompanyId).
                        add("company.id", sp.getString("COMPANY_ID", null)).
                        add("reason", reason)
                .add("type", type).
                        add("id", getIntent().getStringExtra("id")).
                        add("orderProduct.id", orderProductId).
                        add("images", images).build();
        Request request = new Request.Builder().post(body).url(url).build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogLoadUtils.dismissDialog();
                        Toast.makeText(AfterSaleDemandModify.this, "服务器异常", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final ResponseDelete re = gson.fromJson(result, ResponseDelete.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if ("00000".equals(re.getErrorCode())) {
                            Toast.makeText(AfterSaleDemandModify.this, "操作成功", Toast.LENGTH_SHORT).show();
                            List<String> photos = new ArrayList<String>();
                            photos.addAll(selectedPhotos);
                            uploadFiles(oss, photos);
                        } else {
                            DialogLoadUtils.dismissDialog();

                            Toast.makeText(AfterSaleDemandModify.this, "操作失败", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }

    public void getTypeGory() {
        //http://localhost:8080/blanink-api/Dict/listValueByType?type=sys_afterSales_type
        String url = NetUrlUtils.NET_URL + "Dict/listValueByType";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("currentUser.id", sp.getString("USER_ID", null))
                .add("type", "sys_afterSales_type").build();
        Request request = new Request.Builder().post(body).url(url).build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(AfterSaleDemandModify.this, "服务器异常", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final TypeCateGory re = gson.fromJson(result, TypeCateGory.class);
                Log.e("afterSale", re.toString());
                final List<TypeCateGory.ResultBean> reLists = re.getResult();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if ("00000".equals(re.getErrorCode())) {

                            nameList.add("请选择发起原因");
                            valueList.add("0");
                            for (TypeCateGory.ResultBean rb : reLists) {
                                valueList.add(rb.getValue());
                                nameList.add(rb.getLabel());
                            }
                            spReason.setAdapter(new ArrayAdapter<String>(AfterSaleDemandModify.this, R.layout.spanner_item, nameList));
                            spReason.setSelection(getValuePosition(getIntent().getStringExtra("type")), true);
                            spReason.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    value = valueList.get(position);
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        }
                    }
                });
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
                        urls = urls + "," + OssService.OSS_URL + "alioss_" + ExampleUtil.getFileName(selectedPhotos.get(i)) + ExampleUtil.getFileLastName(selectedPhotos.get(i));
                    }
                    if (!urls.equals("")) {
                        urls = urls.substring(1);
                    }
                    Log.e("ComeOrder", urls);
                }
                photoAdapter.notifyDataSetChanged();
            }
        }
    }

    public void uploadFiles(OSSClient oss, List<String> urls) {
        if (null == urls || urls.size() == 0) {
            handler.sendEmptyMessage(0);
            DialogLoadUtils.dismissDialog();
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
            fileSuffix = ExampleUtil.getFileName(url) + ExampleUtil.getFileLastName(url);
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

    //判断 当前负责人所处位置
    public int getValuePosition(String name) {
        int position = 0;
        for (int i = 0; i < valueList.size(); i++) {
            if (name.equals(valueList.get(i))) {
                position = i;
            }
        }
        return position;
    }
}
