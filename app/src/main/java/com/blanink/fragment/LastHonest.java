package com.blanink.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blanink.R;

/**
 * Created by Administrator on 2017/2/9.
 */

/***
 * 上家 公司信息 诚信档案
 */
public class LastHonest extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.layout_cmpany_honest,null);
        return view;

    }
}
