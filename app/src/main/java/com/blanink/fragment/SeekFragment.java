package com.blanink.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.LookBrowseOrder;
import com.blanink.activity.LookSuperSeek;
import com.blanink.activity.SeekActivity;
import com.blanink.view.MyViewPager;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/12/24.
 * 查看
 */
public class SeekFragment extends Fragment {
    private RelativeLayout framgent_seek_rl_superSeek;
    private RelativeLayout framgent_seek_rl_findOrder;
    private EditText edt_query;
    private ArrayList<Integer> drawableLists;
    private MyViewPager myViewPager;
    private TextView tv_date_start;
    private TextView tv_date_end;
    private EditText et_date_start;
    private EditText et_date_end;
    // private RollPagerView rollPagerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.fragment_seek,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        framgent_seek_rl_superSeek = ((RelativeLayout) view.findViewById(R.id.framgent_seek_rl_superSeek));
        framgent_seek_rl_findOrder = ((RelativeLayout) view.findViewById(R.id.framgent_seek_rl_findOrder));
        edt_query = ((EditText) view.findViewById(R.id.edt_query));
        myViewPager=(MyViewPager)view.findViewById(R.id.myViewPager);
        tv_date_start = ((TextView) view.findViewById(R.id.tv_date_start));
        tv_date_end = ((TextView) view.findViewById(R.id.tv_date_end));
        et_date_start = ((EditText) view.findViewById(R.id.framgent_seek_ll_tvStartTime));//开始时间
        et_date_end = ((EditText) view.findViewById(R.id.framgent_seek_ll_tvEndTime));//结束时间

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onStart() {
        super.onStart();
        edt_query.clearFocus();
        edt_query.setCursorVisible(false);
    }

    private void initData() {
         edt_query.clearFocus();

        edt_query.setCursorVisible(false);
        edt_query.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    //进入搜索界面
                    Log.e("SeekFragment","焦点:"+hasFocus);
                    edt_query.setCursorVisible(true);
                    Intent intentSeek=new Intent(getActivity(),SeekActivity.class);
                    startActivity(intentSeek);
                }else{
                    Log.e("SeekFragment","焦点:"+hasFocus);
                    edt_query.setCursorVisible(false);
                }
            }
        });
       //广告
        // 往集合中添加图片
        drawableLists = new ArrayList<>();
        drawableLists.add(R.drawable.guanggao);
        drawableLists.add(R.drawable.guanggao1);
        drawableLists.add(R.drawable.guanggao2);
        drawableLists.add(R.drawable.guanggao3);
        //开启广告轮播
        myViewPager.pictureRoll(drawableLists);

        //高级搜索
        framgent_seek_rl_superSeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LookSuperSeek.class);
                startActivity(intent);
              //  getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
            }
        });
        //浏览订单
        framgent_seek_rl_findOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOrder=new Intent(getActivity(), LookBrowseOrder.class);
                startActivity(intentOrder);
                //getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
            }
        });
      //开始日期和结束日期
        final Calendar calendar=Calendar.getInstance();
       tv_date_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dpd=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        et_date_start.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                    }
                },calendar.get(calendar.YEAR),calendar.get(calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });
        tv_date_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dpd=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        et_date_end.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                    }
                },calendar.get(calendar.YEAR),calendar.get(calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });
    }

}
