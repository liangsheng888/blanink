package com.blanink.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.utils.MyActivityManager;
import com.blanink.view.MyViewPager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/***
 * 来单新增信息
 */
public class ComeOrderNewAddInfoActivity extends AppCompatActivity {
    private MyActivityManager myActivityManager;
    private ImageView come_order_new_add_iv_last;
    private MyViewPager myViewPager;
    private TextView tv_newAdd;
    private Button btn_contiume_add;
    private EditText et_date;
    private ImageView iv_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_order_new_add_info);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initView();
        initData();
    }


    private void initView() {
        come_order_new_add_iv_last = ((ImageView) findViewById(R.id.come_order_new_add_iv_last));
        myViewPager=(MyViewPager) findViewById(R.id.come_order_new_add_advertise);
        tv_newAdd = ((TextView) findViewById(R.id.tv_newAdd));
        btn_contiume_add = ((Button) findViewById(R.id.btn_contiume_add));
        et_date = ((EditText) findViewById(R.id.et_date));
        iv_date = ((ImageView) findViewById(R.id.iv_date));

    }
    private void initData() {
        come_order_new_add_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //广告轮播
        List<Integer> drawableLists=new ArrayList<>();
        drawableLists.add(R.drawable.guanggao);
        drawableLists.add(R.drawable.guanggao1);
        drawableLists.add(R.drawable.guanggao2);
        drawableLists.add(R.drawable.guanggao3);
        myViewPager.pictureRoll(drawableLists);
        //新增客户
        tv_newAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //新增客户

            }
        });
        //继续添加产品
        btn_contiume_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ComeOrderNewAddInfoActivity.this,ComeOrderAddProductActivity.class);
                startActivity(intent);
            }
        });

        final Calendar calendar=Calendar.getInstance();
        et_date.setText(calendar.get(calendar.YEAR)+"-"+(calendar.get(calendar.MONTH)+1)+"-"+calendar.get(calendar.DAY_OF_MONTH));
        iv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dpd=new DatePickerDialog(ComeOrderNewAddInfoActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        et_date.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                    }
                },calendar.get(calendar.YEAR),calendar.get(calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }
}
