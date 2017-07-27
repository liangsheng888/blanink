package com.blanink.activity.EaseChat;




import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.blanink.R;
import com.hyphenate.easeui.ui.EaseChatFragment;


/**
 * Created by Administrator on 2017/1/10.
 * 聊天界面
 */

public class EaseChatActivity extends AppCompatActivity {
    public static EaseChatActivity activityInstance;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        activityInstance = this;
        EaseChatFragment easeChatFragment=new ChatFragment();
        easeChatFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.ec_layout_container,easeChatFragment).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityInstance=null;
    }
}
