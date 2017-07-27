package com.blanink.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.utils.CheckNet;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.RoundProgressBar;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jiguang.net.HttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UpdateActivity extends AppCompatActivity {
    @BindView(R.id.roundProgressBar2)
    RoundProgressBar roundProgressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ButterKnife.bind(this);
        roundProgressBar2.setCricleProgressColor(getResources().getColor(R.color.colorOrange));
        roundProgressBar2.setTextColor(getResources().getColor(R.color.colorOrange));
        downLoad();
    }

    public void downLoad() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            final String path = Environment.getExternalStorageDirectory()
                    + "/update.app";
            String url =  "http://192.168.199.147:8080/app.apk";
            Boolean use = CheckNet.checkedURLIsUseful(url);
            if (!use) {
                Toast.makeText(UpdateActivity.this, "附件地址不合法", Toast.LENGTH_SHORT).show();
                return;
            }
            OkHttpClient ok = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            ok.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(UpdateActivity.this, "服务器异常，稍后重试", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final InputStream is = response.body().byteStream();
                    final long maxLength = response.body().contentLength();
                    FileOutputStream fos = null;
                    Log.e("OrderAttachment", path);
                    Log.e("OrderAttachment", "总长度:" + maxLength);

                    fos = new FileOutputStream(new File(path));
                    Log.e("OrderAttachment", "是否存在:" + new File(path).exists());

                    final FileOutputStream finalFos = fos;
                    {
                        int currentLength = 0;
                        roundProgressBar2.setMax(maxLength);

                        try {
                            byte[] buffer = new byte[2048];
                            int len = 0;
                            while ((len = is.read(buffer)) != -1) {
                                finalFos.write(buffer, 0, len);
                                currentLength += len;
                                Log.e("OrderAttachment", "当前长度" + currentLength);
                                roundProgressBar2.setProgress(currentLength);
                            }
                            finalFos.flush();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Log.e("OrderAttachment", "下载成功" + currentLength);
                        //showDialogExit(path);
                        Intent intent = new Intent();
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.fromFile(new File(path)),
                                "application/vnd.android.package-archive");
                        startActivityForResult(intent, 0);
                    }
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
