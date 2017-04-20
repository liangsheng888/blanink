package com.blanink.activity.chat;




import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.blanink.R;


/**
 * Created by Administrator on 2017/1/10.
 * 聊天界面
 */

public class ChatAcitivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
       /* EaseChatFragment easeChatFragment=new EaseChatFragment();
        easeChatFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.ec_layout_container,easeChatFragment).commit();*/
    }
}
