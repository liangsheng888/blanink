package com.blanink.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blanink.R;

/**
 * Created by Administrator on 2017/1/7.
 */
public class SecondPageFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View  view=View.inflate(getActivity(), R.layout.fragment_second_page,null);
          initView(view);
        return view;

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }
    private void initView(View view) {



    }
    private void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }

    }
}
