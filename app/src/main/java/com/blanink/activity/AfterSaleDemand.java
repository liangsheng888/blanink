package com.blanink.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.blanink.R;

import java.util.ArrayList;

import me.iwf.photopicker.PhotoPickUtils;
import me.iwf.photopicker.utils.PhotoPickerIntent;
import me.iwf.photopicker.widget.MultiPickResultView;


/***
 * 售后 提出要求
 */
public class AfterSaleDemand extends AppCompatActivity {
   private MultiPickResultView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sale_demand);
        initView();
        initData();
    }

    private void initView() {
       recyclerView = (MultiPickResultView) findViewById(R.id.recycler_view);

    }
    private void initData() {
        recyclerView.init(this, MultiPickResultView.ACTION_SELECT,null);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        recyclerView.onActivityResult(requestCode,resultCode,data);
        PhotoPickUtils.onActivityResult(requestCode, resultCode, data, new PhotoPickUtils.PickHandler() {
            @Override
            public void onPickSuccess(ArrayList<String> photos) {//已经预先做了null或size为0的判断

            }

            @Override
            public void onPreviewBack(ArrayList<String> photos) {

            }

            @Override
            public void onPickFail(String error) {
                Toast.makeText(AfterSaleDemand.this,error,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPickCancle() {
                Toast.makeText(AfterSaleDemand.this,"取消选择",Toast.LENGTH_LONG).show();
            }

        });
}}
