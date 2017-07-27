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
import com.blanink.activity.bidTender.BidDetail;
import com.blanink.pojo.TenderAndBid;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.RefreshListView;
import com.blanink.view.UpLoadListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/4.
 */
public class FragmentMyBid extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.lv_my_bid)
    UpLoadListView lvMyBid;
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
    private List<TenderAndBid.Result.Row> myBidList = new ArrayList<>();
    private boolean isHasData = true;
    private int pageNo = 1;
    MyBidAdapter adapter;
    private SparseArray<View> viewSpare;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (adapter != null) {
                lvMyBid.completeRefresh(isHasData);
                adapter.notifyDataSetChanged();
            } else {
                rlNotData.setVisibility(View.VISIBLE);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_my_bid, null);
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initData() {
        loadDataFromServer();

        //重新加载
        rlLoadFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlLoadFail.setVisibility(View.GONE);
                llLoad.setVisibility(View.VISIBLE);
                loadDataFromServer();
            }
        });
        //刷新，加载更多
        lvMyBid.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {
            @Override
            public void onLoadingMore() {
                pageNo++;
                loadDataFromServer();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
        //点击跳转到详情
        lvMyBid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < myBidList.size()) {
                    Intent intent = new Intent(getActivity(), BidDetail.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("BidDetailInfo", myBidList.get(position));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
      /*  //去投标
        rlNotData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BidAccordWithTender.class);
                intent.putExtra("VALUE", 1);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });*/
    }

    //加载数据
    private void loadDataFromServer() {
        if (!ExampleUtil.isConnected(getActivity())) {
            Toast.makeText(getActivity(), "检查你的网络", Toast.LENGTH_SHORT).show();

        } else {
            RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/bidlist");
            rp.addBodyParameter("userId", sp.getString("USER_ID", null));
            rp.addBodyParameter("pageNo", pageNo + "");
            x.http().post(rp, new Callback.CacheCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    llLoad.setVisibility(View.GONE);
                    rlNotData.setVisibility(View.GONE);
                    Log.e("MyBidQueue", "result:" + result);
                    Gson gson = new Gson();
                    TenderAndBid tb = gson.fromJson(result, TenderAndBid.class);
                    Log.e("MyBidQueue", "tb:" + tb.toString());
                    if (tb.getResult().total <= myBidList.size()) {
                        isHasData = false;
                    } else {
                        myBidList.addAll(tb.getResult().rows);
                        if (adapter == null) {
                            adapter = new MyBidAdapter();
                            lvMyBid.setAdapter(adapter);
                        } else {
                            adapter.notifyDataSetChanged();
                        }
                    }
                    handler.sendEmptyMessage(0);

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

    }

    class MyBidAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return myBidList.size();
        }

        @Override
        public Object getItem(int position) {
            return myBidList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            viewSpare = new SparseArray<>();
            if (viewSpare.get(position, null) == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(getActivity(), R.layout.item_my_bid, null);
                viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
                viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                viewHolder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);
                viewHolder.tv_single_price = (TextView) convertView.findViewById(R.id.tv_single_price);
                viewHolder.tv_purchase_num = (TextView) convertView.findViewById(R.id.tv_purchase_num);
                viewHolder.tv_first_pay = (TextView) convertView.findViewById(R.id.tv_first_pay);
                viewHolder.tv_publish_person = (TextView) convertView.findViewById(R.id.tv_publish_person);
                viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv);

                convertView.setTag(viewHolder);
                viewSpare.put(position, convertView);
            } else {
                convertView = viewSpare.get(position);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            TenderAndBid.Result.Row row = myBidList.get(position);
            viewHolder.tv_name.setText(row.inviteCompany.name + "");
            viewHolder.tv_title.setText(row.title);
            viewHolder.tv_single_price.setText(row.targetPrice);
            viewHolder.tv_publish_person.setText(row.inviteCompany.master);
            viewHolder.tv_first_pay.setText(row.downPayment + "%");
            viewHolder.tv_purchase_num.setText(row.count + "");
            GlideUtils.glideImageView(getActivity(),viewHolder.iv,row.inviteCompany.photo,true);
            if (row.bidStatus.equals("0")) {
                viewHolder.tv_state.setText("沟通中");
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorTheme));
            }
            if (row.bidStatus.equals("1")) {
                viewHolder.tv_state.setText("已通过");
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorBlue));
            }
            int index = ExampleUtil.compare_date(row.expireDate, ExampleUtil.dateToString(new Date(System.currentTimeMillis())));
            if (index == -1) {
                viewHolder.tv_state.setText("已失效");
                viewHolder.tv_state.setTextColor(getResources().getColor(R.color.colorRed));
            }

            return convertView;
        }
    }

    static class ViewHolder {
        TextView tv_name;//
        TextView tv_title;
        TextView tv_state;
        TextView tv_single_price;
        TextView tv_purchase_num;
        TextView tv_first_pay;
        TextView tv_publish_person;
        ImageView iv;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

}
