package com.blanink.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.task.WorkPlanAllocationDetail;
import com.blanink.adapter.CommonAdapter;
import com.blanink.pojo.WorkPlaned;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.UpLoadListView;
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
 * Created by Administrator on 2017/3/16.
 * 任务分配 已分配
 */

public class WorkPlanAllocation extends Fragment {
    @BindView(R.id.lv)
    UpLoadListView lv;
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
    @BindView(R.id.fl_load)
    FrameLayout flLoad;
    private String processId;
    private SharedPreferences sp;
    private CommonAdapter<WorkPlaned.ResultBean.Rows> commonAdapter;
    private List<WorkPlaned.ResultBean.Rows> list = new ArrayList<WorkPlaned.ResultBean.Rows>();
    private int pageNo = 1;
    private boolean isHasData = true;
    private String startDate;
    private String endDate;
    private SparseArray<View> sparseArray;
    private MyAdapter adapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (adapter == null) {
                rlNotData.setVisibility(View.VISIBLE);
            } else {
                lv.completeRefresh(isHasData);
                adapter.notifyDataSetChanged();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.work_plan_allocation, null);
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
        ButterKnife.bind(this, view);
        receivedData();
        return view;
    }

    private void receivedData() {
        Intent intent = getActivity().getIntent();
        processId = intent.getStringExtra("processId");
        Log.e("WorkPlaned", "processId:" + processId + ",userId:" + sp.getString("USER_ID", null));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
        lv.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {
            @Override
            public void onLoadingMore() {
                pageNo++;
                loadData();
            }
        });
        //分配详情
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < list.size()) {//防止出现下标越界
                    WorkPlaned.ResultBean.Rows rows = list.get(position);
                    Intent intent = new Intent(getActivity(), WorkPlanAllocationDetail.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("WorkPlanAllocationDetail", rows);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }

    @OnClick(R.id.rl_load_fail)
    public void onClick() {
        llLoad.setVisibility(View.VISIBLE);
        rlLoadFail.setVisibility(View.GONE);
        loadData();
    }

    public void loadData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "workPlan/searchWorkPlan");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("process.id", processId);
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("startDate", startDate);
        rp.addBodyParameter("endDate", endDate);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("WorkPlanNotAllocation", result);
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                WorkPlaned listPlanedTask = gson.fromJson(result, WorkPlaned.class);
                Log.e("WorkPlanNotAllocation", "解析完成:" + listPlanedTask.toString());
                if (listPlanedTask.getResult().total <= list.size()) {
                    isHasData = false;
                } else {
                    list.addAll(listPlanedTask.getResult().rows);
                    Log.e("WorkPlaned", listPlanedTask.toString());
                    if (adapter == null) {
                        adapter = new MyAdapter();
                        lv.setAdapter(adapter);
                    } else {
                        adapter.notifyDataSetChanged();
                    }
                }
                handler.sendEmptyMessage(0);//通知界面更新
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

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            WorkPlaned.ResultBean.Rows rows = list.get(position);
            ViewHolder viewHolder = null;
            sparseArray = new SparseArray<>();
            if (sparseArray.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(getActivity(), R.layout.item_work_plan_allocated, null);
                viewHolder.tv_companyName = (TextView) convertView.findViewById(R.id.tv_companyName);
                viewHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_take_order_time);
                viewHolder.tv_master = (TextView) convertView.findViewById(R.id.tv_master);
                viewHolder.tv_pro_name = (TextView) convertView.findViewById(R.id.tv_pro_name);
                viewHolder.tv_pro_category = (TextView) convertView.findViewById(R.id.tv_pro_category);
                viewHolder.tv_woker = (TextView) convertView.findViewById(R.id.tv_woker);
                viewHolder.tv_finish = (TextView) convertView.findViewById(R.id.tv_finish);
                convertView.setTag(viewHolder);
                sparseArray.put(position, convertView);
            } else {
                convertView = sparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.tv_companyName.setText(rows.getCompanyA().getName());
            viewHolder.tv_time.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(rows.getWorkPlan().getCreateDate())));
            viewHolder.tv_master.setText(rows.getCompanyBOwner().getName());
            viewHolder.tv_pro_name.setText(rows.getProductName());
            viewHolder.tv_pro_category.setText(rows.getCompanyCategory().getName());
            viewHolder.tv_woker.setText(rows.getWorkPlan().getWorker().getName());//分配人
            viewHolder.tv_finish.setText(rows.getRelFlowProcess().getTotalCompletedQuantity() + "/" + rows.getRelFlowProcess().getTarget());
            return convertView;
        }

    }

    static class ViewHolder {
        TextView tv_companyName;
        TextView tv_time;
        TextView tv_master;
        TextView tv_pro_name;
        TextView tv_pro_category;
        TextView tv_woker;
        TextView tv_finish;
    }
}
