package com.blanink.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.activity.lastnext.LastDeleteRelationIsAgree;
import com.blanink.activity.lastnext.LastFamilyManageCustomerSupplierInvite;
import com.blanink.activity.lastnext.NextDeleteRelationIsAgree;
import com.blanink.activity.lastnext.NextFamilyManageInviteBcomeSupplier;
import com.blanink.activity.notify.OtherNotifyDetail;
import com.blanink.pojo.Notify;
import com.blanink.pojo.Response;
import com.blanink.utils.DateUtils;
import com.blanink.utils.GlideUtils;
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
 * Created by Administrator on 2017/3/29.
 * 我的通知
 */
public class ReceiveEmailFragment extends Fragment {
    @BindView(R.id.lv)
    UpLoadListView lv;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
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
    private SharedPreferences sp;
    private MyNotifyAdapter adapter;
    private List<Notify.ResultBean.RowsBean> resultBeanList = new ArrayList<>();
    private boolean isHasData = true;
    private SparseArray<View> sparseArray;
    private String notifyId;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv.completeRefresh(isHasData);
            if (adapter == null || adapter.getCount() == 0) {
                rlNotData.setVisibility(View.VISIBLE);
            } else {
                adapter.notifyDataSetChanged();
            }
        }
    };
    private int pageNo = 1;
    private String type = "";
    private Spinner spNotifyCateGory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_my_notify, null);
        sp = getActivity().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
     /*   if (!hidden) {
            Log.e("ReceiveEmailFragment", "pageNo:" + pageNo);
            resultBeanList.clear();
            pageNo = 1;
            rlNotData.setVisibility(View.GONE);
            Refresh();
        }*/
    }

    private void Refresh() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "notify/filter");
        rp.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("type", type);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                swipeRefreshLayout.setRefreshing(false);
                Log.e("ReceiveEmailFragment", result);
                Gson gson = new Gson();
                Notify notify = gson.fromJson(result, Notify.class);
                Log.e("ReceiveEmailFragment", notify.toString());
                if (notify.getResult().getTotal() <= resultBeanList.size()) {
                    pageNo--;
                } else {
                    rlNotData.setVisibility(View.GONE);
                    resultBeanList.addAll(0, notify.getResult().getRows());
                }
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                pageNo--;
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

    private void initData() {
        loadNotifyFilter();
        View view = View.inflate(getActivity(), R.layout.layout_my_notify_header, null);
        lv.addHeaderView(view);
        spNotifyCateGory = (Spinner) view.findViewById(R.id.sp_notify_cateGory);

        spNotifyCateGory.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.spanner_item,
                new String[]{"通知筛选", "会议通告", "咨询沟通", "活动通告", "产品沟通", "下家申请", "上家申请", "下家解除", "上家解除", "申请回复"}));
        //筛选
        spNotifyCateGory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        pageNo = 1;
                        type = "";
                        resultBeanList.clear();
                        rlNotData.setVisibility(View.GONE);
                        loadNotifyFilter();
                        break;
                    case 1:
                        pageNo = 1;
                        type = "1";
                        resultBeanList.clear();
                        rlNotData.setVisibility(View.GONE);
                        llLoad.setVisibility(View.VISIBLE);
                        loadNotifyFilter();
                        break;
                    case 2:
                        pageNo = 1;
                        type = "2";
                        resultBeanList.clear();
                        rlNotData.setVisibility(View.GONE);
                        llLoad.setVisibility(View.VISIBLE);
                        loadNotifyFilter();
                        break;
                    case 3:
                        pageNo = 1;
                        type = "3";
                        resultBeanList.clear();
                        rlNotData.setVisibility(View.GONE);
                        llLoad.setVisibility(View.VISIBLE);
                        loadNotifyFilter();
                        break;
                    case 4:
                        pageNo = 1;
                        type = "4";
                        resultBeanList.clear();
                        rlNotData.setVisibility(View.GONE);
                        llLoad.setVisibility(View.VISIBLE);
                        loadNotifyFilter();
                        break;
                    case 5:
                        pageNo = 1;
                        type = "5";
                        resultBeanList.clear();
                        rlNotData.setVisibility(View.GONE);
                        llLoad.setVisibility(View.VISIBLE);
                        loadNotifyFilter();
                        break;
                    case 6:
                        pageNo = 1;
                        type = "6";
                        resultBeanList.clear();
                        rlNotData.setVisibility(View.GONE);
                        llLoad.setVisibility(View.VISIBLE);
                        loadNotifyFilter();
                        break;
                    case 7:
                        pageNo = 1;
                        type = "7";
                        resultBeanList.clear();
                        rlNotData.setVisibility(View.GONE);
                        llLoad.setVisibility(View.VISIBLE);
                        loadNotifyFilter();
                        break;
                    case 8:
                        pageNo = 1;
                        type = "8";
                        resultBeanList.clear();
                        rlNotData.setVisibility(View.GONE);
                        llLoad.setVisibility(View.VISIBLE);
                        loadNotifyFilter();
                        break;
                    case 9:
                        pageNo = 1;
                        type = "9";
                        resultBeanList.clear();
                        rlNotData.setVisibility(View.GONE);
                        llLoad.setVisibility(View.VISIBLE);
                        loadNotifyFilter();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //刷新数据
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        swipeRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                RefreshData();
            }
        });
        //加载更多
        lv.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {
            @Override
            public void onLoadingMore() {
                pageNo++;
                loadNotifyFilter();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
        //详情
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击显示已读
                updateStatus();
                if (position < resultBeanList.size() + 1) {
                    notifyId = resultBeanList.get(position - 1).getId();
                    Intent intent = null;
                    if ("6".equals(resultBeanList.get(position - 1).getType())) {
                        //上家申请
                        intent = new Intent(getActivity(), LastFamilyManageCustomerSupplierInvite.class);
                        //intent = new Intent(getActivity(), NotifyReplayDetail.class);

                    } else if ("5".equals(resultBeanList.get(position - 1).getType())) {
                        //下家申请
                        intent = new Intent(getActivity(), NextFamilyManageInviteBcomeSupplier.class);
                        // intent = new Intent(getActivity(), NotifyReplayDetail.class);

                    } else if ("7".equals(resultBeanList.get(position - 1).getType())) {
                        // 下家解除
                        intent = new Intent(getActivity(), NextDeleteRelationIsAgree.class);
                    } else if ("8".equals(resultBeanList.get(position - 1).getType())) {
                        //上家解除
                        intent = new Intent(getActivity(), LastDeleteRelationIsAgree.class);
                    } else {
                        intent = new Intent(getActivity(), OtherNotifyDetail.class);
                    }
                    intent.putExtra("referrenceObjectId", resultBeanList.get(position - 1).getReferrenceObjectId());
                    intent.putExtra("content", resultBeanList.get(position - 1).getContent());
                    intent.putExtra("title", resultBeanList.get(position - 1).getTitle());
                    intent.putExtra("time", resultBeanList.get(position - 1).getCreateDate());
                    intent.putExtra("sender", resultBeanList.get(position - 1).getCreateBy().getName());
                    intent.putExtra("company", resultBeanList.get(position - 1).getCreateBy().getOffice().getName());
                    startActivity(intent);

                }
            }
        });
    }

    private void updateStatus() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "notify/updateStatus");
        rp.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("id", notifyId);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("ReceiveEmailFragment", result);
                Gson gson = new Gson();
                Response notify = gson.fromJson(result, Response.class);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                swipeRefreshLayout.setRefreshing(false);
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

    private void RefreshData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "notify/list");
        rp.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", 1 + "");
        rp.addBodyParameter("type", type);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                swipeRefreshLayout.setRefreshing(false);
                Log.e("ReceiveEmailFragment", result);
                Gson gson = new Gson();
                Notify notify = gson.fromJson(result, Notify.class);
                Log.e("ReceiveEmailFragment", notify.toString());
                if (notify.getResult().getTotal() <= resultBeanList.size()) {
                    Toast.makeText(getActivity(), "没有新的数据", Toast.LENGTH_SHORT).show();

                } else {
                    resultBeanList.clear();
                    resultBeanList.addAll(0, notify.getResult().getRows());
                    Toast.makeText(getActivity(), "已刷新", Toast.LENGTH_SHORT).show();
                }
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                swipeRefreshLayout.setRefreshing(false);
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

    //加载失败
    @OnClick(R.id.rl_load_fail)
    public void onClick() {
        rlLoadFail.setVisibility(View.GONE);
        llLoad.setVisibility(View.VISIBLE);
        loadNotifyFilter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public class MyNotifyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return resultBeanList.size();
        }

        @Override
        public Object getItem(int position) {
            return resultBeanList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            sparseArray = new SparseArray<>();
            ViewHolder viewHolder = null;
            if (sparseArray.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(getActivity(), R.layout.item_my_notify, null);
                viewHolder.tv_company_name = (TextView) convertView.findViewById(R.id.tv_company_name);
                viewHolder.time = (TextView) convertView.findViewById(R.id.time);
                viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
                viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv);
                convertView.setTag(viewHolder);
                sparseArray.put(position, convertView);
            } else {
                convertView = sparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            Notify.ResultBean.RowsBean rows = resultBeanList.get(position);
            viewHolder.tv_title.setText(rows.getTitle());
            viewHolder.tv_content.setText(rows.getContent());
            viewHolder.time.setText(DateUtils.format(DateUtils.stringToDate(rows.getCreateDate())));
            if (rows.getCreateBy().getOffice() != null) {
                viewHolder.tv_company_name.setText(rows.getCreateBy().getOffice().getName());
            }
            if (rows.getCreateBy().getOffice() != null) {
                GlideUtils.glideImageView(getActivity(), viewHolder.iv, rows.getCreateBy().getOffice().getPhoto(), true);
            }

            return convertView;
        }
    }

    static class ViewHolder {
        TextView tv_title;
        TextView time;
        TextView tv_company_name;
        TextView tv_master;
        TextView tv_content;
        TextView ll_state;
        ImageView iv;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("@@@@", "onResume");

        //resultBeanList.clear();
        //loadNotifyFilter();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("@@@@", "onStart");
        //resultBeanList.clear();
        // loadNotifyFilter();
    }

    public void loadNotifyFilter() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "notify/filter");
        rp.addBodyParameter("currentUser.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("type", type);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("ReceiveEmailFragment", result);
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                Notify notify = gson.fromJson(result, Notify.class);
                Log.e("ReceiveEmailFragment", notify.toString());
                if (notify.getResult().getTotal() <= resultBeanList.size()) {
                    isHasData = false;
                } else {
                    resultBeanList.addAll(notify.getResult().getRows());
                    if (adapter == null) {
                        adapter = new MyNotifyAdapter();
                        lv.setAdapter(adapter);
                    } else {
                        adapter.notifyDataSetChanged();
                    }
                }
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("ReceiveEmailFragment", ex.toString());
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
}
