package com.blanink.activity.fincying;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blanink.R;
import com.blanink.activity.MainActivity;
import com.blanink.fragment.FinancingManageSatisfy;
import com.blanink.fragment.FinancingManageSend;
import com.blanink.utils.MyActivityManager;

/***
 *  融资管理
 */
public class FinancingManage extends AppCompatActivity {

    private MyActivityManager myActivityManager;
    private int newIndex;//下一个即将可见的
    private int oldIndex;//当前可见的碎片
    private Fragment[] fragments=new Fragment[2];
    private RadioButton[] buttons=new RadioButton[2];
    private RadioGroup rg_financying;
    private ImageView iv_financyingManage_last;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financying_manage);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        initView();
        initData();
    }

    private void initView() {
        rg_financying = ((RadioGroup) findViewById(R.id.rg_financying));
        iv_financyingManage_last = ((ImageView) findViewById(R.id.iv_financyingManage_last));
    }


    private void initData() {
        fragments[0]=new FinancingManageSatisfy();
        fragments[1]=new FinancingManageSend();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_financying,fragments[0]).commit();
        rg_financying.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_satisfy:
                        newIndex=0;
                        break;
                    case R.id.rb_send:
                        newIndex=1;
                        break;
                }
                changeFragments(newIndex);
            }
        });
        //
        iv_financyingManage_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("DIRECT",0);
        startActivity(intent);
    }

    //切换界面
    private void changeFragments(int newIndex) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(newIndex!=oldIndex){
            ft.hide(fragments[oldIndex]);//隐藏当前的界面
            if(!fragments[newIndex].isAdded()){//如果没有添加则添加
                ft.add(R.id.fl_financying,fragments[newIndex]);
            }
            ft.show(fragments[newIndex]).commit();//显示
        }
        //改变当前的选中项
        oldIndex=newIndex;
    }
}
