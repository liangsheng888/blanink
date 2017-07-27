package com.blanink.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.blanink.R;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/***
 *
 */
public class FlashActivity2 extends Activity {
    private static final int FRAGMENT_TASK = 0;
    private ImageView imageView;
    AnimationDrawable loadingDrawable;
    MyActivityManager myActivityManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadContent();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void loadContent() {
        setContentView(R.layout.loding);
        imageView = (ImageView) findViewById(R.id.loading_img);
        loadingDrawable = (AnimationDrawable) imageView.getBackground();
        loadingDrawable.start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                loadingDrawable.stop();
            }
        }).start();
    }

    public void reloadContent(View view) {
        loadContent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
