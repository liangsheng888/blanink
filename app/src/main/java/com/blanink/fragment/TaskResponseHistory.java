package com.blanink.fragment;

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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.WorkedTask;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/8.
 * 历史任务反馈
 */

public class TaskResponseHistory extends Fragment {
    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.ll_load)
    LinearLayout llLoad;
    @BindView(R.id.loading_error_img)
    ImageView loadingErrorImg;
    @BindView(R.id.rl_load_fail)
    RelativeLayout rlLoadFail;
    @BindView(R.id.tv_not)
    TextView tvNot;
    @BindView(R.id.rl_not_data)
    RelativeLayout rlNotData;
    private String processId;
    private SharedPreferences sp;
    private CommonAdapter<WorkedTask.Result> commonAdapter;
    private List<WorkedTask.Result> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_my_task, null);
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
        receivedData();
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    private void receivedData() {
        Intent intent = getActivity().getIntent();
        processId = intent.getStringExtra("processId");
        Log.e("TaskResponse", "processId:" + processId + ",userId:" + sp.getString("USER_ID", null));
    }

    public void loadData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/listWorkedTask");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("process.id", processId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TaskResponse", result);
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                WorkedTask listPlanedTask = gson.fromJson(result, WorkedTask.class);
                if (listPlanedTask.result.size()==0){
                    rlNotData.setVisibility(View.VISIBLE);
                }
                list = new ArrayList<WorkedTask.Result>();
                list.addAll(listPlanedTask.result);
                Log.e("TaskResponse", listPlanedTask.toString());
                if (commonAdapter == null) {
                    commonAdapter = new CommonAdapter<WorkedTask.Result>(getActivity(), list, R.layout.item_history_task_response) {
                        @Override
                        public void convert(ViewHolder viewHolder, WorkedTask.Result result, int position) {
                            result = list.get(position);
                            TextView tv_companyName = viewHolder.getViewById(R.id.tv_companyName);
                            TextView tv_time = viewHolder.getViewById(R.id.tv_time);
                            TextView tv_master = viewHolder.getViewById(R.id.tv_master);
                            TextView tv_pro_name = viewHolder.getViewById(R.id.tv_pro_name);//规格名称
                            TextView tv_pro_category = viewHolder.getViewById(R.id.tv_pro_category);//产品类
                            TextView tv_response = viewHolder.getViewById(R.id.tv_response);
                            TextView tv_bad = viewHolder.getViewById(R.id.tv_bad);
                            TextView tv_note = viewHolder.getViewById(R.id.tv_note);
                            tv_companyName.setText(result.companyA.name);
                            tv_time.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(result.createDate)));
                            tv_master.setText(result.companyBOwner.name);
                            tv_pro_name.setText(result.productName);
                            tv_pro_category.setText(result.companyCategory.name);
                            tv_response.setText(result.finishedAmount + "");//我的反馈
                            tv_note.setText(result.productDescription);
                            tv_bad.setText(result.processFeedback.faultAmount+"");
                            //tv_bad.setText(result.);

                        }
                    };
                    lv.setAdapter(commonAdapter);
                } else {
                    commonAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                llLoad.setVisibility(View.GONE);
                rlLoadFail.setVisibility(View.VISIBLE);
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

    @OnClick(R.id.rl_load_fail)
    public void onClick() {
        llLoad.setVisibility(View.VISIBLE);
        rlLoadFail.setVisibility(View.GONE);
        loadData();
    }
}
