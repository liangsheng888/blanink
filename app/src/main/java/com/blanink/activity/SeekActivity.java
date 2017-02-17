package com.blanink.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.blanink.R;
import com.blanink.utils.MyActivityManager;

/**
 * 搜索界面
 */
public class SeekActivity extends AppCompatActivity {


    private static final int SEEK = 1;
    MyActivityManager activityManager;
    private EditText SeekActivity_edt_query;
    private int index=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
        activityManager= MyActivityManager.getInstance();
        activityManager.pushOneActivity(this);
        index= getIntent().getIntExtra("DIRECT",-1);
        initView();
        initData();

    }

    private void initData() {

    }

    private void initView() {
        SeekActivity_edt_query = ((EditText) findViewById(R.id.SeekActivity_edt_query));
    }

    @Override
    protected void onDestroy() {
        Log.e("SeekActivity","onDestroy");
        activityManager.popOneActivity(this);
        Intent intent=new Intent(SeekActivity.this,MainActivity.class);
        if(index>-1){
            intent.putExtra("DIRECT",0);
        }else {
        intent.putExtra("DIRECT",SEEK);}
        startActivity(intent);
        super.onDestroy();

    }
}
