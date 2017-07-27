package com.blanink.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.blanink.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/8.
 * 广告界面
 */
public class AdvertiseActivity extends Activity {
    ProgressDialog mProgressDialog;
    @BindView(R.id.webView)
    WebView webView;
    final Activity activity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(this);

        setContentView(R.layout.webview);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.baidu.com");
        webView.getSettings().setSupportZoom(true);
       /* webView.setWebChromeClient(new WebChromeClient()
                                   {
                                       public void onProgressChanged(WebView view, int progress)
                                       {
                                           activity.setTitle("Loading...");
                                           activity.setProgress(progress * 100);
                                           if(progress == 100)
                                               activity.setTitle(R.string.app_name);
                                       }
                                   }*/
        webView.setWebViewClient(new HelloWebViewClient());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        } else {
            System.exit(0);
        }
        return super.onKeyDown(keyCode, event);
    }

    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mProgressDialog.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mProgressDialog.hide();
        }
    }
}
