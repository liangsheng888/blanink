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
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.task.TaskResponseHistoryDetail;
import com.blanink.adapter.CommonAdapter;
import com.blanink.adapter.ViewHolder;
import com.blanink.pojo.WorkedTask;
import com.blanink.utils.CommonUtil;
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
    private CommonAdapter<WorkedTask.ResultBean> commonAdapter;
    private List<WorkedTask.ResultBean> list;

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
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), TaskResponseHistoryDetail.class);
                intent.putExtra("id", list.get(position).getProcessFeedback().getId());
                if (list.get(position).getCompanyCategory() != null) {
                    intent.putExtra("productCategory", list.get(position).getCompanyCategory().getName());
                }
                intent.putExtra("productNum", list.get(position).getAmount());
                intent.putExtra("productName", list.get(position).getProductName());
                startActivity(intent);
            }
        });
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
        Log.e("TaskResponse", NetUrlUtils.NET_URL + "processFeedback/listWorkedTask?userId=" + sp.getString("USER_ID", null) + "&processId=" + processId);

        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String ResultBean) {
                Log.e("TaskResponse", ResultBean);
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                WorkedTask listPlanedTask = gson.fromJson(ResultBean, WorkedTask.class);
                if (listPlanedTask.getResult().size() == 0) {
                    rlNotData.setVisibility(View.VISIBLE);
                }
                list = new ArrayList<WorkedTask.ResultBean>();
                list.addAll(listPlanedTask.getResult());
                Log.e("TaskResponse", listPlanedTask.toString());
                if (commonAdapter == null) {
                    commonAdapter = new CommonAdapter<WorkedTask.ResultBean>(getActivity(), list, R.layout.item_history_task_response) {
                        @Override
                        public void convert(ViewHolder viewHolder, WorkedTask.ResultBean ResultBean, int position) {
                            ResultBean = list.get(position);
                            TextView tv_companyName = viewHolder.getViewById(R.id.tv_companyName);
                            TextView tv_time = viewHolder.getViewById(R.id.tv_time);
                            TextView tv_master = viewHolder.getViewById(R.id.tv_master);
                            TextView tv_pro_name = viewHolder.getViewById(R.id.tv_pro_name);//规格名称
                            TextView tv_pro_category = viewHolder.getViewById(R.id.tv_pro_category);//产品类
                            TextView tv_response = viewHolder.getViewById(R.id.tv_response);
                            TextView tv_bad = viewHolder.getViewById(R.id.tv_bad);
                            TextView tv_note = viewHolder.getViewById(R.id.tv_note);
                            if (ResultBean != null) {
                                Log.e("TaskResponseHistory", ResultBean.getProcessFeedback().toString());
                                if (ResultBean.getCompanyA() != null) {
                                    tv_companyName.setText(ResultBean.getCompanyA().getName());
                                }
                                if (ResultBean.getUpdateDate() != null) {
                                    tv_time.setText(CommonUtil.dateToString(CommonUtil.stringToDate(ResultBean.getUpdateDate())));
                                }
                                /*if (ResultBean.getCompanyBOwner() != null) {
                                    tv_master.setText(ResultBean.getCompanyBOwner().getName());
                                }*/
                                tv_pro_name.setText(ResultBean.getProductName());
                                if ("3".equals(getActivity().getIntent().getStringExtra("processType"))) {
                                    //tv_pro_category.setText(ResultBean.getProcessFeedback());
                                    if(ResultBean.getProcessFeedback().getConfirmAmount()==ResultBean.getProcessFeedback().getAchieveAmount()){
                                        tv_pro_category.setText("对方已收货");
                                        tv_pro_category.setTextColor(getResources().getColor(R.color.colorBlue));
                                    }
                                    if(ResultBean.getProcessFeedback().getConfirmAmount()==-1){
                                        tv_pro_category.setText("对方拒绝收货");
                                        tv_pro_category.setTextColor(getResources().getColor(R.color.colorRed));

                                    }
                                    if(ResultBean.getProcessFeedback().getConfirmAmount()==0){
                                        tv_pro_category.setText("对方暂未收货");
                                        tv_pro_category.setTextColor(getResources().getColor(R.color.colorAccent));

                                    }

                                } else {
                                    if (ResultBean.getCompanyCategory() != null) {
                                        tv_pro_category.setText(ResultBean.getCompanyCategory().getName());
                                    }
                                }
                                tv_response.setText(ResultBean.getProcessFeedback().getAchieveAmount() + "");//我的反馈
                                tv_note.setText(ResultBean.getRemarks());
                                tv_bad.setText(ResultBean.getProcessFeedback().getFaultAmount() + "");
                                //tv_bad.setText(ResultBean.);
                            }
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
                Log.e("TaskResponse", ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String ResultBean) {
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
