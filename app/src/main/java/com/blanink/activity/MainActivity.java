package com.blanink.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blanink.R;
import com.blanink.activity.EaseChat.ChatFragmentParent;
import com.blanink.fragment.HomeFragment;
import com.blanink.fragment.MineFragment;
import com.blanink.fragment.NotifyFragment;
import com.blanink.utils.MyActivityManager;

public class MainActivity extends AppCompatActivity {
    private Fragment[] fragments = new Fragment[4];
    private RadioGroup main_rg;
    private RadioButton[] buttons = new RadioButton[4];
    private int newIndex;//下一个即将可见的
    private int oldIndex;//当前可见的碎片
    MyActivityManager activityManager;
    private SharedPreferences sp;
    private Boolean update=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityManager = MyActivityManager.getInstance();
        activityManager.pushOneActivity(this);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        initView();
        initData();

    }

    public Boolean getUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }

    //找到相关控件
    private void initView() {
        buttons[0] = (RadioButton) this.findViewById(R.id.main_rb_task);
        //buttons[1] = (RadioButton) this.findViewById(R.id.main_rb_seek);
        buttons[1] = (RadioButton) this.findViewById(R.id.main_rb_talk);
        buttons[2] = (RadioButton) this.findViewById(R.id.main_rb_notify);
        buttons[3] = (RadioButton) this.findViewById(R.id.main_rb_mine);
        main_rg = (RadioGroup) findViewById(R.id.main_rg);
        //初始化，为fragments添加数据
        fragments[0] = new HomeFragment();
       // fragments[1] = new OrderFragment();
        fragments[1] = new ChatFragmentParent();
        fragments[2] = new NotifyFragment();
        fragments[3] = new MineFragment();
        //默认选中界面  （任务）
        getSupportFragmentManager().beginTransaction().add(R.id.main_fl, fragments[0]).commit();

    }

    private void initData() {
        //底部导航栏点击事件
        main_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_rb_task:
                        newIndex = 0;
                        break;
                  /*  case R.id.main_rb_seek:
                        newIndex = 1;
                        break;*/
                    case R.id.main_rb_talk:
                        newIndex = 1;
                        break;
                    case R.id.main_rb_notify:
                        newIndex = 2;
                        break;
                    case R.id.main_rb_mine:
                        newIndex = 3;
                        break;
                }
                changeFragments(newIndex);

            }
        });
    }

    //切换界面
    private void changeFragments(int newIndex) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (newIndex != oldIndex) {
            ft.hide(fragments[oldIndex]);//隐藏当前的界面
            if (!fragments[newIndex].isAdded()) {//如果没有添加则添加
                ft.add(R.id.main_fl, fragments[newIndex]);
            }
            ft.show(fragments[newIndex]).commit();//显示

        }
        //改变当前的选中项
        oldIndex = newIndex;
    }

    @Override
    protected void onStart() {
        super.onStart();

   /*     Intent intentBack=getIntent();
        int backCode=intentBack.getIntExtra("DIRECT",0);
        changeFragments(backCode);
        buttons[backCode].setChecked(true);*/
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setUpdate(intent.getBooleanExtra("UPDATE",false));
        Log.e("MainActivity","是否更新:"+intent.getBooleanExtra("UPDATE",false));
        Log.e("MainActivity", "onNewIntent");
        int code=intent.getIntExtra("DIRECT",-1);
        //  接收返回的状态吗
        if (code!=-1) {
            changeFragments(code);
            buttons[code].setChecked(true);
        }
    }

    @Override
    protected void onPause() {
        Log.e("MainActivity", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("MainActivity", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e("MainActivity", "onDestroy");
        activityManager.pushOneActivity(this);
        super.onDestroy();
    }

    //监听菜单 防止用户不小心退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showDialogExit();
        }

        return false;

    }

    private void showDialogExit() {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_exit);
        final Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);
        window.findViewById(R.id.tv_continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        window.findViewById(R.id.tv_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                activityManager.finishAllActivity();

            }
        });
    }


}


