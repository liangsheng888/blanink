package com.blanink.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.blanink.R;

/**
 * Created by Administrator on 2016/12/24.
 *  沟通
 * */
public class TalkFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.fragment_talk,null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    public void showPopupWindow(View v){
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.popup_custom, null);

        final PopupWindow popupWindow = new PopupWindow(contentView,
                200, RelativeLayout.LayoutParams.WRAP_CONTENT, true);
        //添加客户
        popupWindow.setTouchable(true);

//        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                Log.i("mengdd", "onTouch : ");
//
//                return false;
//                // 这里如果返回true的话，touch事件将被拦截
//                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
//            }
//        });
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.mipmap.ic_launcher));
        // 设置好参数之后再show
        popupWindow.showAsDropDown(v,0,15);
    }
}
