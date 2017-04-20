package com.blanink.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.RoundProgressBar;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpdateActivity extends AppCompatActivity {
    @BindView(R.id.roundProgressBar2)
    RoundProgressBar roundProgressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ButterKnife.bind(this);
        downLoadApp();
    }

    private void downLoadApp() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            final String path = Environment.getExternalStorageDirectory()
                    + "/update.app";
            HttpUtils httpUtils = new HttpUtils();
            String url = NetUrlUtils.NET_URL + "app.apk";
            httpUtils.download(url, path, new RequestCallBack<File>() {
                @Override
                public void onLoading(long total, long current,
                                      boolean isUploading) {
                    // TODO Auto-generated method stub
                    roundProgressBar2.setMax(total);
                    roundProgressBar2.setProgress(current);
                }

                @Override
                public void onSuccess(ResponseInfo<File> arg0) {
                    // TODO Auto-generated method stub
                    // 下载完毕，安装提示
                    Intent intent = new Intent();
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(arg0.result),
                            "application/vnd.android.package-archive");
                    startActivityForResult(intent, 0);
                }

                @Override
                public void onFailure(HttpException e, String s) {

                    Toast.makeText(UpdateActivity.this, "更新失败", Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            Toast.makeText(UpdateActivity.this, "找不到内存卡", Toast.LENGTH_SHORT).show();
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
