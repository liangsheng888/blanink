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
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.activity.notify.NotifyDraftSend;
import com.blanink.activity.notify.OtherNotifyDetail;
import com.blanink.pojo.Notify;
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
 * 通知管理
 */
public class sendEmailFragment extends Fragment {
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
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv.completeRefresh(isHasData);
            if (adapter ==null || adapter.getCount() == 0) {
                rlNotData.setVisibility(View.VISIBLE);
            } else {
                adapter.notifyDataSetChanged();
            }
        }
    };
    private int pageNo = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_notify_manage, null);
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
    /*    if (!hidden) {
            resultBeanList.clear();
            pageNo = 1;
            rlNotData.setVisibility(View.GONE);
            Log.e("sendEmailFragment", "pageNo:" + pageNo);
            Refresh();
        }*/
    }

    private void initData() {
        loadData();//加载数据
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
                pageNo++;
                RefreshData();
            }
        });
        //加载更多
        lv.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {
            @Override
            public void onLoadingMore() {
                pageNo++;
                loadData();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
        //详情
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < resultBeanList.size()) {
                    Intent intent = null;
                    if ("0".equals(resultBeanList.get(position).getStatus())) {
                        intent = new Intent(getActivity(), NotifyDraftSend.class);//草稿
                    } else {
                        intent = new Intent(getActivity(), OtherNotifyDetail.class);
                    }
                    intent.putExtra("referrenceObjectId", resultBeanList.get(position).getReferrenceObjectId());
                    intent.putExtra("content", resultBeanList.get(position).getContent());
                    intent.putExtra("title", resultBeanList.get(position).getTitle());
                    intent.putExtra("time", resultBeanList.get(position).getCreateDate());
                    intent.putExtra("sender", resultBeanList.get(position).getCreateBy().getName());
                    intent.putExtra("company", resultBeanList.get(position).getCreateBy().getOffice().getName());
                    intent.putExtra("notifyId", resultBeanList.get(position).getId());
                    intent.putExtra("receiver",resultBeanList.get(position).getOaNotifyRecordNames());
                    startActivity(intent);

                }
            }
        });
    }

    private void Refresh() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "notify/myList");
        rp.addBodyParameter("createBy.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                swipeRefreshLayout.setRefreshing(false);
                Log.e("NotifyManage", result);
                Gson gson = new Gson();
                Notify notify = gson.fromJson(result, Notify.class);
                Log.e("NotifyManage", notify.toString());
                if (notify.getResult().getTotal() <= resultBeanList.size()) {
                    pageNo--;
                } else {
                    rlNotData.setVisibility(View.GONE);
                    resultBeanList.addAll(0, notify.getResult().getRows());
                    // Toast.makeText(getActivity(), "你有" + notify.getResult().getRows().size() + "条新通知", Toast.LENGTH_SHORT).show();
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

    private void RefreshData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "notify/myList");
        rp.addBodyParameter("createBy.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                swipeRefreshLayout.setRefreshing(false);
                Log.e("NotifyManage", result);
                Gson gson = new Gson();
                Notify notify = gson.fromJson(result, Notify.class);
                Log.e("NotifyManage", notify.toString());
                if (notify.getResult().getTotal() <= resultBeanList.size()) {
                    Toast.makeText(getActivity(), "没有新的数据", Toast.LENGTH_SHORT).show();

                } else {
                    resultBeanList.addAll(0, notify.getResult().getRows());
                    Toast.makeText(getActivity(), "刷新出来" + notify.getResult().getRows().size() + "条数据", Toast.LENGTH_SHORT).show();
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

    private void loadData() {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "notify/myList");
        rp.addBodyParameter("createBy.id", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("NotifyManage", result);
                llLoad.setVisibility(View.GONE);
                Gson gson = new Gson();
                Notify notify = gson.fromJson(result, Notify.class);
                Log.e("NotifyManage", notify.toString());
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

    //加载失败
    @OnClick(R.id.rl_load_fail)
    public void onClick() {
        rlLoadFail.setVisibility(View.GONE);
        llLoad.setVisibility(View.VISIBLE);
        loadData();
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
                convertView = View.inflate(getActivity(), R.layout.item_notify_manage, null);
                viewHolder.tv_company_name = (TextView) convertView.findViewById(R.id.tv_company_name);
                viewHolder.state = (TextView) convertView.findViewById(R.id.state);
                viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
                viewHolder.tv_master = (TextView) convertView.findViewById(R.id.tv_master);
                convertView.setTag(viewHolder);
                sparseArray.put(position, convertView);
            } else {
                convertView = sparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            Notify.ResultBean.RowsBean rows = resultBeanList.get(position);
            String title = rows.getTitle();
            viewHolder.tv_title.setText(title);
            viewHolder.tv_content.setText(rows.getContent());
            viewHolder.state.setText("0".equals(rows.getStatus()) ? "草稿" : "通知");
            if("0".equals(rows.getStatus())){
                viewHolder.state.setTextColor(getResources().getColor(R.color.colorBlue));
            }else {
                viewHolder.state.setTextColor(getResources().getColor(R.color.colorTheme));
            }
            viewHolder.tv_master.setText(rows.getCreateBy().getName());
            viewHolder.tv_company_name.setText(rows.getCreateBy().getOffice().getName());
            return convertView;
        }
    }

    static class ViewHolder {
        TextView tv_title;
        TextView state;
        TextView tv_company_name;
        TextView tv_master;
        TextView tv_content;
    }

}
