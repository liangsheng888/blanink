package com.blanink.activity.bidtender;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.Response;
import com.blanink.pojo.TenderAndBid;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/2/21.
 */
public class TenderModify extends Activity {
    private TextView modify_iv_last;
    private EditText et_title;
    private EditText et_product;
    private EditText et_first_price;
    private EditText et_price;
    private EditText et_num;
    private EditText et_end_date;
    private TextView tv_date;
    private EditText et_note;
    private TextView tv_file_name;
    private Button btn_commit;
    private TextView tv_upload;
    private ImageView iv_upload;
    private TextView tv_file_size;
    SharedPreferences sp;
    private String remarks;
    private String expireTime;
    private String count;
    private String targetPrice;
    private String downPayment;
    private String productName;
    private String title;
    public String attactment;

    private TenderAndBid.Result.Row row = new TenderAndBid.Result.Row();
    private MyActivityManager myActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_modify);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        receivedDataFromTenderBidQueue();
        initView();
        initData();
    }

    private void receivedDataFromTenderBidQueue() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        row = (TenderAndBid.Result.Row) bundle.getSerializable("TenderDetail");
        Log.e("TenderModify", row.toString());
    }


    private void initView() {
        modify_iv_last = ((TextView) findViewById(R.id.modify_iv_last));
        et_title = ((EditText) findViewById(R.id.tender_et_title));
        et_product = ((EditText) findViewById(R.id.et_product));
        et_first_price = ((EditText) findViewById(R.id.et_first_price));
        et_price = ((EditText) findViewById(R.id.et_price));
        et_num = ((EditText) findViewById(R.id.et_num));
        et_end_date = ((EditText) findViewById(R.id.et_end_date));
        tv_date = ((TextView) findViewById(R.id.tv_date));
        et_note = ((EditText) findViewById(R.id.et_note));
        btn_commit = ((Button) findViewById(R.id.btn_commit));
    }

    private void initData() {
        modify_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //
        et_title.setText(row.title);
        et_product.setText(row.buyProductName);
        et_first_price.setText(row.downPayment);
        et_price.setText(row.targetPrice);
        et_num.setText(row.count + "");
        et_end_date.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(row.expireDate)));
        et_note.setText(row.remarks);
        //upload data
        btn_commit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                title = et_title.getText().toString().trim();
                productName = et_product.getText().toString().trim();
                downPayment = et_first_price.getText().toString().trim();
                targetPrice = et_price.getText().toString().trim();
                count = et_num.getText().toString().trim();
                expireTime = et_end_date.getText().toString().trim();
                remarks = et_note.getText().toString().trim();
                DialogLoadUtils.getInstance(TenderModify.this);
                DialogLoadUtils.showDialogLoad("操作进行中...");

                uploadDataToServer();
            }
        });

        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dpd = new DatePickerDialog(TenderModify.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        et_end_date.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });
    }

    private void uploadDataToServer() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/update");
        Log.e("TenderModify",NetUrlUtils.NET_URL+"inviteBid/update?userId"+ sp.getString("USER_ID", null)+"&id="+row.id);
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("id", row.id);
        rp.addBodyParameter("buyProductName", productName);
        rp.addBodyParameter("targetPrice", targetPrice);
        rp.addBodyParameter("downPayment", downPayment);
        rp.addBodyParameter("count", count);
        rp.addBodyParameter("remarks", remarks);
        rp.addBodyParameter("attachment", attactment);
        rp.addBodyParameter("expireDate", expireTime);
        rp.addBodyParameter("title", title);
        x.http().post(rp, new Callback.CacheCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        DialogLoadUtils.dismissDialog();
                        Gson gson = new Gson();
                        Response rs = gson.fromJson(result, Response.class);
                        if (rs.getErrorCode().equals("00000")) {
                            final AlertDialog alertDialog = new AlertDialog.Builder(TenderModify.this).create();
                            alertDialog.show();
                            alertDialog.setContentView(R.layout.dialog_custom_success);
                            Window window = alertDialog.getWindow();
                            WindowManager.LayoutParams lp = window.getAttributes();
                            window.setGravity(Gravity.CENTER);
                            Display d = getWindowManager().getDefaultDisplay(); // 获取屏幕宽、高用
                            //  lp.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
                            lp.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的1/2
                            window.setWindowAnimations(R.style.dialogAnimation);
                            window.setAttributes(lp);
                            alertDialog.setCanceledOnTouchOutside(false);
                            window.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    alertDialog.dismiss();
                                }
                            });
                        } else {
                            Toast.makeText(TenderModify.this, "修改失败", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        DialogLoadUtils.dismissDialog();
                        Toast.makeText(TenderModify.this, "服务器异常", Toast.LENGTH_SHORT).show();
                        Log.e("TenderModify", ex.toString());
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
                }

        );

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
