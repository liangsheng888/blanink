package com.blanink.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.notify.NotifySend;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/24.
 * 通知
 */
public class NotifyFragment extends Fragment {
    @BindView(R.id.my_notify)
    RadioButton myNotify;
    @BindView(R.id.notify_manage)
    RadioButton notifyManage;
    @BindView(R.id.rg_notify)
    RadioGroup rgNotify;
    @BindView(R.id.fl_notify)
    FrameLayout flNotify;
    @BindView(R.id.tv_add_notify)
    TextView tvAddNotify;
    @BindView(R.id.go_order_add_rl)
    RelativeLayout goOrderAddRl;
    private Fragment[] fragments;
    private RadioButton[] radioButtons;
    private int newIndex;
    private int oldIndex;
    /** TextView选择框 */
    private TextView mSelectTv;

    /** popup窗口里的ListView */
    private ListView mTypeLv;

    /** popup窗口 */
    private PopupWindow typeSelectPopup;

    /** 模拟的假数据 */
    private List<String> testData;

    /** 数据适配器 */
    private ArrayAdapter<String> testDataAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_notify, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化数据
        fragments = new Fragment[2];
        fragments[0] = new ReceiveEmailFragment();
        fragments[1] = new sendEmailFragment();
        radioButtons = new RadioButton[2];
        radioButtons[0] = myNotify;
        radioButtons[1] = notifyManage;
        //默认选中第一个
        getChildFragmentManager().beginTransaction().add(R.id.fl_notify, fragments[0]).commit();

        rgNotify.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.my_notify://我的通知
                        newIndex = 0;
                        break;
                    case R.id.notify_manage://通知管理
                        newIndex = 1;
                        break;
                }
                changeFragment(newIndex);
            }
        });

        //发送通知
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {

        }
    }

    public void changeFragment(int newIndex) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (newIndex != oldIndex) {
            fragmentTransaction.hide(fragments[oldIndex]);
            if (!fragments[newIndex].isAdded()) {
                fragmentTransaction.add(R.id.fl_notify, fragments[newIndex]);
            }
            fragmentTransaction.show(fragments[newIndex]).commit();
        }

        oldIndex = newIndex;
    }

    @OnClick(R.id.tv_add_notify)
    public void onClick() {
        Intent intent=new Intent(getActivity(),NotifySend.class);
        startActivity(intent);
    }
}
