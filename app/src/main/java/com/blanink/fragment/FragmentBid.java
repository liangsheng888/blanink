package com.blanink.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.bidtender.BidSeekTender;
import com.blanink.activity.bidtender.TenderDetail;
import com.blanink.pojo.TenderAndBid;
import com.blanink.utils.DateUtils;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.UpLoadListView;
import com.google.gson.Gson;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/4.
 */
public class FragmentBid extends Fragment {

    private static final int BACK_TASK = 0;
    @BindView(R.id.sp_sort)
    Spinner spSort;
    @BindView(R.id.sp_expire)
    Spinner spExpire;
    @BindView(R.id.ll_seek)
    LinearLayout llSeek;
    @BindView(R.id.lv_tender_info_queue)
    UpLoadListView lvTenderInfoQueue;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
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
    @BindView(R.id.activity_bid_accord_with_tender)
    RelativeLayout activityBidAccordWithTender;


    private MyAdapter myAdapter;
    private SharedPreferences sp;
    private boolean isHasData = true;
    private List<TenderAndBid.Result.Row> rowList = new ArrayList<>();
    private String sort = "1";
    private String expire = "";
    private int pageNo = 1;
    private SparseArray<View> viewSparseArray;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lvTenderInfoQueue.completeRefresh(isHasData);
            if (myAdapter != null) {
                myAdapter.notifyDataSetChanged();
            } else {

            }
        }
    };
    private Spinner sp_sort;
    private Spinner sp_expire;
    private EditText et_seek;
    private TextView tv_seek;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_bid, null);
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();

    }

    private void initData() {
        sort(sort, expire);
        addHeaderView();
        //重新加载
        rlLoadFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlLoadFail.setVisibility(View.GONE);
                llLoad.setVisibility(View.VISIBLE);
                sort(sort, expire);

            }
        });

        //刷新 加载更多
        lvTenderInfoQueue.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {

            @Override
            public void onLoadingMore() {
                pageNo++;
                sort(sort, expire);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.e("BID", "firstVisibleItem:" + firstVisibleItem + ",visibleItemCount:" + visibleItemCount);
                if (firstVisibleItem > 1) {
                    llSeek.setVisibility(View.VISIBLE);
                } else {
                    if (firstVisibleItem <= 2) {
                        llSeek.setVisibility(View.GONE);
                    }
                }
            }
        });

        WaveSwipeHeader waveSwipeHeader = new WaveSwipeHeader(getActivity());
        waveSwipeHeader.setColorSchemeColors(Color.WHITE, Color.WHITE);
        waveSwipeHeader.setPrimaryColors(getResources().getColor(R.color.colorOrange));
        smartRefreshLayout.setRefreshHeader(waveSwipeHeader);
        smartRefreshLayout.setEnableLoadmore(false);//是否开启加上拉加载功能（默认true）
        smartRefreshLayout.setEnableHeaderTranslationContent(false);//拖动Header的时候是否同时拖动内容（默认true）
        smartRefreshLayout.setDisableContentWhenRefresh(true);//是否在刷新的时候禁止内容的一切手势操作（默认false）
        //刷新
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNo = 1;
                rowList.clear();
                sort(sort, expire);

            }
        });

        //招标详情
        lvTenderInfoQueue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < rowList.size() + 2) {
                    TenderAndBid.Result.Row row = rowList.get(position - 2);
                    Intent intent = new Intent(getActivity(), TenderDetail.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("TenderDetail", row);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });

        //搜索
        et_seek.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Intent intent = new Intent(getActivity(), BidSeekTender.class);
                    startActivity(intent);
                }
            }
        });
        tv_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BidSeekTender.class);
                startActivity(intent);
            }
        });
        et_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_seek.setFocusable(true);
            }
        });
        spSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pageNo = 1;
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        rowList.clear();
                        llLoad.setVisibility(View.VISIBLE);
                        sort = "1";
                        sort(sort, expire);
                        break;
                    case 2:
                        rowList.clear();
                        llLoad.setVisibility(View.VISIBLE);
                        sort = "2";
                        sort(sort, expire);
                        break;
                    case 3:
                        rowList.clear();
                        llLoad.setVisibility(View.VISIBLE);
                        sort = "3";
                        sort(sort, expire);
                        break;
                    case 4:
                        rowList.clear();
                        llLoad.setVisibility(View.VISIBLE);
                        sort = "4";
                        sort(sort, expire);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp_sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pageNo = 1;
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        rowList.clear();
                        llLoad.setVisibility(View.VISIBLE);
                        sort = "1";
                        sort(sort, expire);
                        break;
                    case 2:
                        rowList.clear();
                        llLoad.setVisibility(View.VISIBLE);
                        sort = "2";
                        sort(sort, expire);
                        break;
                    case 3:
                        rowList.clear();
                        llLoad.setVisibility(View.VISIBLE);
                        sort = "3";
                        sort(sort, expire);
                        break;
                    case 4:
                        rowList.clear();
                        llLoad.setVisibility(View.VISIBLE);
                        sort = "4";
                        sort(sort, expire);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spExpire.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pageNo = 1;
                switch (position) {
                    case 0:
                        expire = "";
                        break;
                    case 1:
                        rowList.clear();
                        llLoad.setVisibility(View.VISIBLE);
                        expire = "1";
                        sort(sort, expire);
                        break;
                    case 2:
                        rowList.clear();
                        llLoad.setVisibility(View.VISIBLE);
                        expire = "2";
                        sort(sort, expire);
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp_expire.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pageNo = 1;
                switch (position) {
                    case 0:
                        expire = "";
                        break;
                    case 1:
                        rowList.clear();
                        llLoad.setVisibility(View.VISIBLE);
                        expire = "1";
                        sort(sort, expire);
                        break;
                    case 2:
                        rowList.clear();
                        llLoad.setVisibility(View.VISIBLE);
                        expire = "2";
                        sort(sort, expire);
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        et_seek.clearFocus();//清除焦点
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return rowList.size();
        }

        @Override
        public Object getItem(int position) {
            return rowList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            viewSparseArray = new SparseArray<>();
            ViewHolder viewHolder = null;
            if (viewSparseArray.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(getActivity(), R.layout.item_my_tender, null);
                viewHolder.tv_company = (TextView) convertView.findViewById(R.id.tv_company);
                viewHolder.tv_tag = (TextView) convertView.findViewById(R.id.tv_tag);
                viewHolder.tv_purchase_num = (TextView) convertView.findViewById(R.id.tv_tender_purchase_num);
                viewHolder.tv_single_price = (TextView) convertView.findViewById(R.id.tv_single_price);
                viewHolder.tv_useful_time = (TextView) convertView.findViewById(R.id.tv_useful_time);
                viewHolder.tv_single_price = (TextView) convertView.findViewById(R.id.tv_single_price);
                viewHolder.tv_note_content = (TextView) convertView.findViewById(R.id.tv_note_content);
                viewHolder.tv_first_pay = (TextView) convertView.findViewById(R.id.tv_first_pay);
                viewHolder.tv_publish = (TextView) convertView.findViewById(R.id.tv_publish);
                viewHolder.iv_out_of_date = (ImageView) convertView.findViewById(R.id.iv_out_of_date);
                viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv);

                viewSparseArray.put(position, convertView);
                convertView.setTag(viewHolder);
            } else {
                convertView = viewSparseArray.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.tv_company.setText(rowList.get(position).inviteCompany.name);
            viewHolder.tv_tag.setText(rowList.get(position).buyProductName);
            viewHolder.tv_purchase_num.setText(rowList.get(position).count + "");
            viewHolder.tv_single_price.setText(rowList.get(position).targetPrice);
            viewHolder.tv_first_pay.setText(rowList.get(position).downPayment + "%");
            viewHolder.tv_note_content.setText(rowList.get(position).remarks);
            viewHolder.tv_useful_time.setText(ExampleUtil.dateToString(ExampleUtil.stringToDate(rowList.get(position).expireDate)));
            viewHolder.tv_publish.setText(DateUtils.format(ExampleUtil.stringToDate(rowList.get(position).createDate)));
            //设置失效显示
            if (ExampleUtil.compare_date(rowList.get(position).expireDate, ExampleUtil.dateToString(new Date(System.currentTimeMillis()))) < 0) {
                viewHolder.iv_out_of_date.setVisibility(View.VISIBLE);
            }
            GlideUtils.glideImageView(getActivity(), viewHolder.iv, rowList.get(position).inviteCompany.photo, true);

            return convertView;
        }
    }

    static class ViewHolder {
        public TextView tv_company;
        public TextView tv_tag;
        public TextView tv_purchase_num;
        public TextView tv_single_price;
        public TextView tv_useful_time;
        public TextView tv_note_content;
        public TextView tv_attachment;
        public TextView tv_first_pay;
        public TextView tv_publish;
        public ImageView iv_out_of_date;
        public ImageView iv;
    }

    //排序
    private void sort(final String sort, String expire) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/inviteBidSort");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("pageNo", pageNo + "");
        rp.addBodyParameter("sort", sort);
        rp.addBodyParameter("expire", expire);
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                llLoad.setVisibility(View.GONE);
                smartRefreshLayout.finishRefresh();
                Log.e("BidAccordWithTender", " sort result+++++" + sort + "----" + result);
                Gson gson = new Gson();
                TenderAndBid tender = gson.fromJson(result, TenderAndBid.class);
                Log.e("BidAccordWithTender", "sort tender+++++" + tender.toString());
                if (tender.getResult().total <= rowList.size()) {
                    isHasData = false;
                } else {
                    rowList.addAll(tender.getResult().rows);
                    if (myAdapter == null) {
                        myAdapter = new MyAdapter();
                        lvTenderInfoQueue.setAdapter(myAdapter);
                    } else {
                        myAdapter.notifyDataSetChanged();
                    }
                }
                handler.sendEmptyMessage(0);//发送消息通知更新界面
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                llLoad.setVisibility(View.GONE);
                rlLoadFail.setVisibility(View.VISIBLE);
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

    public void addHeaderView() {
        View view = View.inflate(getActivity(), R.layout.layout_bid_header, null);
        View viewCategory = View.inflate(getActivity(), R.layout.item_bid_seek_category, null);
        sp_sort = ((Spinner) viewCategory.findViewById(R.id.sp_sort));
        sp_expire = ((Spinner) viewCategory.findViewById(R.id.sp_expire));
        et_seek = (EditText) view.findViewById(R.id.et_seek);
        tv_seek = ((TextView) view.findViewById(R.id.tv_seek));
        lvTenderInfoQueue.addHeaderView(view);
        lvTenderInfoQueue.addHeaderView(viewCategory);
    }
}
