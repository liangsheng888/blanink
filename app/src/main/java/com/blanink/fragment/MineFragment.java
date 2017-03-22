package com.blanink.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.bidTender.MyBidQueue;
import com.blanink.activity.my.MyProfile;
import com.blanink.activity.bidTender.MyTender;
import com.blanink.activity.set.PersonSet;
import com.blanink.pojo.LoginResult;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.XUtilsImageUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/24.
 * 我的
 */
public class MineFragment extends Fragment {
    @BindView(R.id.iv_user_photo)
    ImageView ivUserPhoto;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.rl_photo)
    RelativeLayout rlPhoto;
    @BindView(R.id.tv_profile)
    TextView tvProfile;
    @BindView(R.id.rl_profile)
    RelativeLayout rlProfile;
    @BindView(R.id.tv_finance)
    TextView tvFinance;
    @BindView(R.id.rl_finance)
    RelativeLayout rlFinance;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.rl_order)
    RelativeLayout rlOrder;
    @BindView(R.id.tv_my_tender)
    TextView tvMyTender;
    @BindView(R.id.rl_my_tender)
    RelativeLayout rlMyTender;
    @BindView(R.id.tv_my_bid)
    TextView tvMyBid;
    @BindView(R.id.rl_my_bid)
    RelativeLayout rlMyBid;
    @BindView(R.id.tv_feed_back)
    TextView tvFeedBack;
    @BindView(R.id.rl_response)
    RelativeLayout rlResponse;
    @BindView(R.id.tv_after_sale)
    TextView tvAfterSale;
    @BindView(R.id.rl_after_sale)
    RelativeLayout rlAfterSale;
    @BindView(R.id.tv_set)
    TextView tvSet;
    @BindView(R.id.rl_set)
    RelativeLayout rlSet;
    private SharedPreferences sp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("Mine","onCreateView");
        sp = getActivity().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        View view = View.inflate(getActivity(), R.layout.fragment_mine, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("Mine","onActivityCreated");
        loadUserInfoFromSever();
        initData();
    }

    private void initData() {

    }



    @OnClick({R.id.rl_profile, R.id.rl_finance, R.id.rl_order, R.id.rl_my_tender, R.id.rl_my_bid, R.id.rl_response, R.id.rl_after_sale, R.id.rl_set})
    public void onClick(View view) {
        switch (view.getId()) {
            //个人资料
            case R.id.rl_profile:
                Intent intent = new Intent(getActivity(), MyProfile.class);
                startActivity(intent);
                break;
            case R.id.rl_finance:
                break;
            case R.id.rl_order:
                break;
            case R.id.rl_my_tender:
                //我的招标
                Intent intent2 = new Intent(getActivity(), MyTender.class);
                startActivity(intent2);
                break;
            case R.id.rl_my_bid:
                //我的投标
                Intent intent3 = new Intent(getActivity(), MyBidQueue.class);
                startActivity(intent3);
                break;
            case R.id.rl_response:
                break;
            case R.id.rl_after_sale:
                break;
            case R.id.rl_set:
                //设置
                Intent intent4 = new Intent(getActivity(), PersonSet.class);
                startActivity(intent4);
                break;
        }
    }

    public void loadUserInfoFromSever() {
        // http://localhost:8088/blanink-api/customer/user?userId=fec25c7f7634448581e21876ef517c57

        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "user");
        rp.addBodyParameter("id", sp.getString("USER_ID", null));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("MyProfile", "result:" + result);
                Gson gson = new Gson();
                LoginResult loginResult = gson.fromJson(result, LoginResult.class);
                Log.e("MyProfile", "loginResult:" + loginResult);
                tvUserName.setText(loginResult.getResult().name);
                XUtilsImageUtils.display(ivUserPhoto, NetUrlUtils.NET_URL + loginResult.getResult().photo, true);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }






    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("Mine","onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("Mine","onAttach");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("Mine","onStart");
        loadUserInfoFromSever();
    }

    @Override
    public void onResume() {
        Log.e("Mine","onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("Mine","onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e("Mine","onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e("Mine","onDestroyView");
        super.onDestroyView();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Mine","onDestroy");
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
