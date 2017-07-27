package com.blanink.activity.bidtender;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.blanink.R;
import com.blanink.activity.MainActivity;
import com.blanink.adapter.PhotoAdapter;
import com.blanink.adapter.RecyclerItemClickListener;
import com.blanink.oss.OssService;
import com.blanink.pojo.Response;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.NoScrollListview;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;

/***
 * 发布招标
 */
public class TenderPublish extends AppCompatActivity {

    private static final int BACK_TASK = 0;
    private static final int RESULT_UPLOAD = 1;
    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.bid_apply_iv_last)
    TextView bidApplyIvLast;
    @BindView(R.id.bid_apply_rl)
    RelativeLayout bidApplyRl;
    @BindView(R.id.tv_theme)
    TextView tvTheme;
    @BindView(R.id.tender_et_title)
    EditText tenderEtTitle;
    @BindView(R.id.rl_theme)
    RelativeLayout rlTheme;
    @BindView(R.id.tv_product)
    TextView tvProduct;
    @BindView(R.id.et_product)
    EditText etProduct;
    @BindView(R.id.rl_product)
    RelativeLayout rlProduct;
    @BindView(R.id.tv_first_price)
    TextView tvFirstPrice;
    @BindView(R.id.et_first_price)
    EditText etFirstPrice;
    @BindView(R.id.rl_first_price)
    RelativeLayout rlFirstPrice;
    @BindView(R.id.tv_price2)
    TextView tvPrice2;
    @BindView(R.id.et_price)
    EditText etPrice;
    @BindView(R.id.rl_price)
    RelativeLayout rlPrice;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.et_num)
    EditText etNum;
    @BindView(R.id.rl_num)
    RelativeLayout rlNum;
    @BindView(R.id.tv_hand_date)
    TextView tvHandDate;
    @BindView(R.id.et_end_date)
    EditText etEndDate;
    @BindView(R.id.rl_hand_date)
    RelativeLayout rlHandDate;
    @BindView(R.id.tv_date)
    TextView tvDate;
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
    @BindView(R.id.iv_picture)
    ImageView ivPicture;
    @BindView(R.id.go_order_add_ll2)
    LinearLayout goOrderAddLl2;
    @BindView(R.id.btn_ok)
    Button btnOk;
    @BindView(R.id.ll_save)
    LinearLayout llSave;
    @BindView(R.id.activity_tender_publish)
    RelativeLayout activityTenderPublish;
    private MyActivityManager myActivityManager;
    private TextView last;
    private EditText et_title;
    private EditText et_product;
    private EditText et_first_price;
    private EditText et_price;
    private EditText et_num;
    private EditText et_end_date;
    private TextView tv_date;
    private EditText et_note;
    private Button btn_ok;
    SharedPreferences sp;
    private String title;
    private String buyProductName;
    private String count;
    private String expireDate;
    private String remarks;
    private String targetPrice;
    private String downPayment;
    private PhotoAdapter photoAdapter;
    private ArrayList<String> selectedPhotos = new ArrayList<>();
    private String urls = "";
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            DialogLoadUtils.dismissDialog();
            btnOk.setEnabled(true);
            showNotify();
        }
    };
    private OSSClient oss;
    private int value;

    private void showNotify() {
        final AlertDialog alertDialog = new AlertDialog.Builder(TenderPublish.this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_tender);
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        Display d = getWindowManager().getDefaultDisplay(); // 获取屏幕宽、高用
        //  lp.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
        lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);

        window.findViewById(R.id.tv_continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TenderPublish.this, TenderPublish.class);
                startActivity(intent);
                alertDialog.dismiss();
            }
        });
        window.findViewById(R.id.tv_seek).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Intent intent=new Intent(TenderPublish.this,TenderManage.class);
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_publish);
        ButterKnife.bind(this);
        value = getIntent().getIntExtra("value", 0);
        oss = OssService.getOSSClientInstance(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initView();
        initData();

    }


    private void initView() {
        last = ((TextView) findViewById(R.id.bid_apply_iv_last));
        et_title = ((EditText) findViewById(R.id.tender_et_title));
        et_product = ((EditText) findViewById(R.id.et_product));
        et_first_price = ((EditText) findViewById(R.id.et_first_price));
        et_price = ((EditText) findViewById(R.id.et_price));
        et_num = ((EditText) findViewById(R.id.et_num));
        et_end_date = ((EditText) findViewById(R.id.et_end_date));
        tv_date = ((TextView) findViewById(R.id.tv_date));
        et_note = ((EditText) findViewById(R.id.et_note));
        btn_ok = ((Button) findViewById(R.id.btn_ok));

    }

    private void initData() {
        // 明文设置secret的方式建议只在测试时使用，更多鉴权模式请参考后面的`访问控制`章节
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(OssService.AccessKey, OssService.AccessKeySecret);

        oss = new OSSClient(getApplicationContext(), OssService.endpoint, credentialProvider);

        //返回
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //设置当前时间
        et_end_date.setText(new SimpleDateFormat("yyyy-MM-dd").format((new Date(System.currentTimeMillis()))));
        //选择日期
        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dpd = new DatePickerDialog(TenderPublish.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        et_end_date.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
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
                        .start(TenderPublish.this);
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
                                    .start(TenderPublish.this);
                        } else {
                            PhotoPreview.builder()
                                    .setPhotos(selectedPhotos)
                                    .setCurrentItem(position)
                                    .start(TenderPublish.this);
                        }
                    }
                }));

        //选择文件
       /* iv_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();

            }
        });*/
        //上传
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到值

                title = et_title.getText().toString();
                buyProductName = et_product.getText().toString();
                count = et_num.getText().toString();
                expireDate = et_end_date.getText().toString();
                remarks = et_note.getText().toString();
                targetPrice = et_price.getText().toString();
                downPayment = et_first_price.getText().toString();
                if (TextUtils.isEmpty(title)) {
                    Toast.makeText(TenderPublish.this, "请输入标题", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(buyProductName)) {
                    Toast.makeText(TenderPublish.this, "请输入产品名称", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(downPayment)) {
                    Toast.makeText(TenderPublish.this, "请输入预付定金", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(targetPrice)) {
                    Toast.makeText(TenderPublish.this, "请输入价格", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(count)) {
                    Toast.makeText(TenderPublish.this, "请输入数量", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(expireDate)) {
                    Toast.makeText(TenderPublish.this, "请输入选择时间", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(remarks)) {
                    Toast.makeText(TenderPublish.this, "请输入备注", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Integer.parseInt(count) < 1) {
                    Toast.makeText(TenderPublish.this, "数量不能小于1", Toast.LENGTH_SHORT).show();
                    return;
                }
                btnOk.setEnabled(false);
                uploadServer();
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //上传服务器
    public void uploadServer() {
        //判断 输入选项不能为空


        DialogLoadUtils.getInstance(TenderPublish.this);
        DialogLoadUtils.showDialogLoad("操作进行中...");
        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/save");
        requestParams.addBodyParameter("userId", sp.getString("USER_ID", ""));
        requestParams.addBodyParameter("title", title);
        requestParams.addBodyParameter("buyProductName", buyProductName);
        requestParams.addBodyParameter("targetPrice", targetPrice);
        requestParams.addBodyParameter("downPayment", downPayment);
        requestParams.addBodyParameter("count", count);
        requestParams.addBodyParameter("remarks", remarks);
        requestParams.addBodyParameter("attachment", urls);
        requestParams.addBodyParameter("expireDate", expireDate);

        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if ("00000".equals(response.getErrorCode())) {
                    //上传图片
                    List<String> photos = new ArrayList<String>();
                    photos.addAll(selectedPhotos);
                    uploadFiles(oss, photos);
                } else {
                    Toast.makeText(TenderPublish.this, "发布失败！", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                DialogLoadUtils.dismissDialog();
                Toast.makeText(TenderPublish.this, "服务器异常！", Toast.LENGTH_SHORT).show();
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
            handler.sendEmptyMessage(0);
            return;
        } // 上传文件
        ossUpload(oss, urls);
    }

    public void ossUpload(final OSSClient oss, final List<String> urls) {
        Log.e("ComeOrder", "图片个数:" + urls.size());
        if (urls.size() <= 0) {
            Log.e("ComeOrder", "通知提醒");
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
                if (selectedPhotos != null) {
                    selectedPhotos.clear();
                }
                if (photos != null) {
                    selectedPhotos.addAll(photos);
                    for (int i = 0; i < selectedPhotos.size(); i++) {
                        urls = urls + "|" + OssService.OSS_URL+"alioss_"+ExampleUtil.getFileName(selectedPhotos.get(i)+ExampleUtil.getFileLastName(selectedPhotos.get(i)));
                    }
                    urls = urls.substring(1);
                    Log.e("ComeOrder", urls);
                }

                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
                recyclerView.setAdapter(photoAdapter);

                photoAdapter.notifyDataSetChanged();
            }
        }
    }
}




