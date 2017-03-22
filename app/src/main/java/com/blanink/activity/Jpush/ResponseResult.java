package com.blanink.activity.jPush;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.utils.MyActivityManager;

import org.json.JSONException;
import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;

/***
 * 回复通知内容
 */
public class ResponseResult extends AppCompatActivity {
    private SharedPreferences sp;
    private String title = null;
    private String content = null;
    private String extras=null;
    private String user_id=null;
    private String time=null;
    private ImageView customer_apply_iv_last;
    private MyActivityManager myActivityManager;
    private TextView tv_title;
    private TextView tv_content;
    private TextView tv_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response_result);
        sp=getSharedPreferences("DATA",MODE_PRIVATE);
        ReceivejpushData();
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initView();
        initData();
    }



    private void initView() {
        customer_apply_iv_last = ((ImageView) findViewById(R.id.customer_apply_iv_last));
        tv_title = ((TextView) findViewById(R.id.tv_title));
        tv_content = ((TextView) findViewById(R.id.tv_content));
        tv_time = ((TextView) findViewById(R.id.tv_time));
    }

    private void initData() {
        //返回
        customer_apply_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_title.setText(title);
        tv_content.setText(content);
        tv_time.setText(time);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    private void ReceivejpushData() {
        Bundle bundle = getIntent().getExtras();
        title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        content = bundle.getString(JPushInterface.EXTRA_ALERT);
        extras= bundle.getString(JPushInterface.EXTRA_EXTRA);

        JSONObject jsonObject= null;
        try {
            jsonObject = new JSONObject(extras);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            user_id =jsonObject.getString("userId");
            time=jsonObject.getString("time");

        } catch (JSONException e) {
            e.printStackTrace();

        }
    }

}
