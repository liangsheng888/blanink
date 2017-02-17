package com.blanink.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.XUtilsImageUtils;

/**
 * Created by Administrator on 2016/12/24.
 * 我的
 */
public class MineFragment extends Fragment {
    private TextView tv_user_name;
    private SharedPreferences sp;
    private ImageView iv_user_photo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.fragment_mine,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        sp=getActivity().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        tv_user_name = ((TextView) view.findViewById(R.id.tv_user_name));
        iv_user_photo = ((ImageView) view.findViewById(R.id.iv_user_photo));
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        tv_user_name.setText(sp.getString("NAME",null));
        XUtilsImageUtils.display(iv_user_photo, NetUrlUtils.NET_URL+sp.getString("PHOTO",null),true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
