package com.blanink.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.MainActivity;
import com.blanink.activity.SeekActivity;
import com.blanink.activity.WorkResponseHistory;
import com.blanink.activity.aftersale.AfterSaleQueue;
import com.blanink.activity.aftersale.MyAfterSale;
import com.blanink.activity.bidtender.BidManage;
import com.blanink.activity.bidtender.TenderManage;
import com.blanink.activity.flow.FlowOrder;

import com.blanink.activity.lastnext.LastFamilyManageCustomer;
import com.blanink.activity.lastnext.NextFamilyManageCompanySupplierManage;
import com.blanink.activity.order.ComeOrder;
import com.blanink.activity.order.GoOrderPurchase;
import com.blanink.activity.order.ReceiveGoods;
import com.blanink.activity.report.ReportType;
import com.blanink.activity.stock.StockManage;
import com.blanink.activity.task.TaskResponseProcessQueue;
import com.blanink.activity.task.WorkPlanProcessQueue;
import com.blanink.adapter.GridSpacingItemDecoration;
import com.blanink.adapter.MenuAdapter;
import com.blanink.adapter.RecyclerItemClickListener;
import com.blanink.pojo.MenuControl;
import com.blanink.pojo.OrderProduct;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.UrlPic;
import com.blanink.view.MyViewPager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/12/24.
 * 任务
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.framgent_task_edt_query)
    EditText framgentTaskEdtQuery;
    @BindView(R.id.framgent_task_search_clear)
    ImageButton framgentTaskSearchClear;
    @BindView(R.id.framgent_task_tv_search)
    TextView framgentTaskTvSearch;
    @BindView(R.id.framgent_task_seek_ll)
    LinearLayout framgentTaskSeekLl;
    @BindView(R.id.framgment_task_vp_advertise)
    MyViewPager framgmentTaskVpAdvertise;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private AnimationDrawable loadingDrawable;
    private List<Fragment> fragmentLists;
    private List<Integer> drawableLists;//存放图片的集合
    private LinearLayout ll_viewpager_bottom_line;
    private ListView myTaskListView;
    private SharedPreferences sp;
    private List<String> processList = new ArrayList<>();
    private List<OrderProduct.Result> myTaskList = new ArrayList<>();
    private List<OrderProduct.Result> oldTaskList = new ArrayList<>();

    private RelativeLayout rlMyTask;
    private MenuAdapter menuAdapter=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = View.inflate(getActivity(), R.layout.fragment_task_fu, null);
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        loadMenuControl();

    }


    private void initData() {
        framgentTaskEdtQuery.clearFocus();
        framgentTaskEdtQuery.setCursorVisible(false);
        framgentTaskEdtQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                framgentTaskEdtQuery.setFocusable(true);
                framgentTaskEdtQuery.setCursorVisible(true);
            }
        });
        //设立焦点改变监听事件
        framgentTaskEdtQuery.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //跳到搜索界面
                    Log.e("HomeFragment", "焦点:" + hasFocus);
                    framgentTaskEdtQuery.setCursorVisible(true);
                    Intent intentSeek = new Intent(getActivity(), SeekActivity.class);
                    intentSeek.putExtra("DIRECT", 0);
                    startActivity(intentSeek);
                } else {
                    framgentTaskEdtQuery.setCursorVisible(false);
                }
            }
        });


        List<String> picLis = new ArrayList<>();
        picLis.add(UrlPic.pic);
        picLis.add(UrlPic.pic2);
        picLis.add(UrlPic.pic3);
        //广搞轮播
        framgmentTaskVpAdvertise.pictureRoll(picLis);

    }

    @Override
    public void onStart() {
        super.onStart();
        framgentTaskEdtQuery.clearFocus();
        framgentTaskEdtQuery.setCursorVisible(false);
        if (((MainActivity)getActivity()).getUpdate()) {
            recyclerView.removeAllViews();
            recyclerView.setAdapter(null);
            menuAdapter.notifyDataSetChanged();
            loadMenuControl();
        }
    }

    /*   //底部直线选中状态切换
       private void LineChange(List<Fragment> fragmentLists) {
           Log.e("@@@@", "LineChange: " + fragmentLists.size());
           int currentPage = fra_task_viewPager.getCurrentItem() % fragmentLists.size();
           for (int i = 0; i < fragmentLists.size(); i++) {
               ll_viewpager_bottom_line.getChildAt(i).setEnabled(currentPage == i);
           }
       }
   */
    //底部直线动态初始化
    private void initLine(List<Fragment> fragmentLists) {
        Log.e("@@@@", "initLine: " + fragmentLists.size());
        if (fragmentLists == null) {
            fragmentLists = new ArrayList<>();
        }
        for (int i = 0; i < fragmentLists.size(); i++) {
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(8, 8);
            layoutParams.leftMargin = 10;
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(R.drawable.selector_oval);
            ll_viewpager_bottom_line.addView(view);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }


    //菜单配置
    public void loadMenuControl() {
        String url = NetUrlUtils.NET_URL + "getMenu";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("id", sp.getString("USER_ID", null)).build();
        Request request = new Request.Builder().post(body).url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                MenuControl menu = gson.fromJson(result, MenuControl.class);
                final List<String> menuList = menu.getResult();
                menuAdapter=new MenuAdapter(getActivity(), menuList);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4, GridLayoutManager.VERTICAL, false));

                        recyclerView.addItemDecoration(new GridSpacingItemDecoration(4, getResources().getDimensionPixelSize(R.dimen.padding_middle), true));//设置间隙
                        recyclerView.setAdapter(menuAdapter);
                        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                if ("招标管理".equals(menuList.get(position))) {
                                    Intent intentTender = new Intent(getActivity(), TenderManage.class);
                                    startActivity(intentTender);
                                }
                                if ("投标管理".equals(menuList.get(position))) {
                                    Intent intentBid = new Intent(getActivity(), BidManage.class);
                                    startActivity(intentBid);
                                }
                                if ("客户管理".equals(menuList.get(position))) {
                                    Intent intentLast = new Intent(getActivity(), LastFamilyManageCustomer.class);
                                    startActivity(intentLast);
                                }
                                if ("供应商管理".equals(menuList.get(position))) {
                                    Intent intentNext = new Intent(getActivity(), NextFamilyManageCompanySupplierManage.class);
                                    startActivity(intentNext);
                                }
                                if ("工作反馈".equals(menuList.get(position))) {
                                    Intent intentTaskResponse = new Intent(getActivity(), TaskResponseProcessQueue.class);
                                    startActivity(intentTaskResponse);
                                }
                                if ("任务分工".equals(menuList.get(position))) {
                                    Intent intentworkPlan = new Intent(getActivity(), WorkPlanProcessQueue.class);
                                    startActivity(intentworkPlan);
                                }
                                if ("采购管理".equals(menuList.get(position))) {
                                    Intent itBuy = new Intent(getActivity(), GoOrderPurchase.class);
                                    startActivity(itBuy);
                                }
                                if ("订单管理".equals(menuList.get(position))) {
                                    Intent itOrder = new Intent(getActivity(), ComeOrder.class);
                                    startActivity(itOrder);
                                }
                                if ("排流程".equals(menuList.get(position))) {
                                    Intent intentFlow = new Intent(getActivity(), FlowOrder.class);
                                    startActivity(intentFlow);
                                }
                                if ("售后处理".equals(menuList.get(position))) {
                                    Intent intent = new Intent(getActivity(), AfterSaleQueue.class);
                                    startActivity(intent);

                                }
                                if ("我的售后".equals(menuList.get(position))) {
                                    Intent intent = new Intent(getActivity(), MyAfterSale.class);
                                    startActivity(intent);
                                }
                                if ("收货".equals(menuList.get(position))) {
                                    Intent intent = new Intent(getActivity(), ReceiveGoods.class);
                                    startActivity(intent);
                                }
                                if ("报表".equals(menuList.get(position))) {
                                    Intent intent_table = new Intent(getActivity(), ReportType.class);
                                    startActivity(intent_table);
                                }
                                if ("工作记录".equals(menuList.get(position))) {
                                    Intent intent = new Intent(getActivity(), WorkResponseHistory.class);
                                    startActivity(intent);
                                }
                                if ("仓库管理".equals(menuList.get(position))) {
                                    Intent intent = new Intent(getActivity(), StockManage.class);
                                    startActivity(intent);
                                }
                            }

                        }));

                    }

                });

            }
        });

    }


}




