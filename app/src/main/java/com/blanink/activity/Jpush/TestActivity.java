package com.blanink.activity.Jpush;

import cn.jpush.android.api.JPushInterface;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("用户自定义打开的Activity");
	        Bundle bundle = getIntent().getExtras();
	        String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
	        String content = bundle.getString(JPushInterface.EXTRA_ALERT);
            String extras= bundle.getString(JPushInterface.EXTRA_EXTRA);
            String user_id=null;

            JSONObject jsonObject= null;
            try {
                jsonObject = new JSONObject(extras);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                user_id =jsonObject.getString("userId");

            } catch (JSONException e) {
                e.printStackTrace();

        }
        tv.setText("Title : " + title + "  " + "Content : " + content+"   user_id : "+user_id);
        addContentView(tv, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
    }

}
