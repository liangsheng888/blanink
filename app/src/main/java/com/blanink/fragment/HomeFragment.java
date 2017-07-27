package com.blanink.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.SeekActivity;
import com.blanink.activity.report.SaleAmountAnalysis;
import com.blanink.activity.bidTender.BidManage;
import com.blanink.activity.bidTender.TenderManage;
import com.blanink.activity.flow.FlowOrder;
import com.blanink.activity.lastNext.LastFamilyManageCustomer;
import com.blanink.activity.lastNext.NextFamilyManageCompanySupplierManage;
import com.blanink.activity.order.ComeOrder;
import com.blanink.activity.order.GoOrderPurchase;
import com.blanink.activity.order.ReceiveGoods;
import com.blanink.activity.task.TaskResponseProcessQueue;
import com.blanink.activity.task.WorkPlanProcessQueue;
import com.blanink.pojo.MenuControl;
import com.blanink.pojo.OrderProduct;
import com.blanink.pojo.ProcessFeedback;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.MyViewPager;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
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
    @BindView(R.id.tv_fr_tender)
    TextView tvFrTender;
    @BindView(R.id.tv_fr_bid)
    TextView tvFrBid;
    @BindView(R.id.tv_last_manage)
    TextView tvLastManage;
    @BindView(R.id.tv_next_manage)
    TextView tvNextManage;
    @BindView(R.id.tv_flow)
    TextView tvFlow;
    @BindView(R.id.tv_fr_task_response)
    TextView tvFrTaskResponse;
    @BindView(R.id.tv_workPlan)
    TextView tvWorkPlan;
    @BindView(R.id.tv_receive)
    TextView tvReceive;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.tv_after_sale_control)
    TextView tvAfterSaleControl;
    @BindView(R.id.tv_table)
    TextView tvTable;
    @BindView(R.id.my_sale)
    TextView mySale;
    @BindView(R.id.tv_history)
    TextView tvHistory;
    //private MyViewPager myViewPager;
    private ViewPager fra_task_viewPager;
    private EditText framgent_task_edt_query;
    private ImageView imageView;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = View.inflate(getActivity(), R.layout.fragment_task, null);
        sp = getActivity().getSharedPreferences("DATA", getActivity().MODE_PRIVATE);
        initView(view);
        loadMenuControl();
        ButterKnife.bind(this, view);
        return view;
    }

    private void initView(View view) {
        framgent_task_edt_query = ((EditText) view.findViewById(R.id.framgent_task_edt_query));
        // myTaskListView = ((ListView) view.findViewById(R.id.lv_task));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e("Home", "" + hidden);

    }

    private void initData() {
        framgent_task_edt_query.clearFocus();
        framgent_task_edt_query.setCursorVisible(false);
        framgent_task_edt_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                framgent_task_edt_query.setFocusable(true);
                framgent_task_edt_query.setCursorVisible(true);
            }
        });
        //设立焦点改变监听事件
        framgent_task_edt_query.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //跳到搜索界面
                    Log.e("HomeFragment", "焦点:" + hasFocus);
                    framgent_task_edt_query.setCursorVisible(true);
                    Intent intentSeek = new Intent(getActivity(), SeekActivity.class);
                    intentSeek.putExtra("DIRECT", 0);
                    startActivity(intentSeek);
                } else {
                    framgent_task_edt_query.setCursorVisible(false);
                }
            }
        });


        drawableLists = new ArrayList<>();
        drawableLists.add(R.drawable.guanggao);
        drawableLists.add(R.drawable.guanggao2);
        drawableLists.add(R.drawable.guanggao3);
        //广搞轮播
        framgmentTaskVpAdvertise.pictureRoll(drawableLists);

    }

    //刷新
    private void RefreshProcessData() {
        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/listProcess");
        requestParams.addBodyParameter("userId", sp.getString("USER_ID", null));
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("Home", "工序:" + result);
                Gson gson = new Gson();
                ProcessFeedback pf = gson.fromJson(result, ProcessFeedback.class);
                if (pf.result.size() > 0) {
                    for (int i = 0; i < pf.result.size(); i++) {
                        processList.add(pf.result.get(i).id);
                    }
                }
                Log.e("Home", "processList.size:" + processList.size() + "-------" + processList.toString());
                //   RefreshData(processList);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //swipeRefreshLayout.setRefreshing(false);

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
    public void onStart() {
        super.onStart();
        framgent_task_edt_query.clearFocus();
        framgent_task_edt_query.setCursorVisible(false);
    }

    //底部直线选中状态切换
    private void LineChange(List<Fragment> fragmentLists) {
        Log.e("@@@@", "LineChange: " + fragmentLists.size());
        int currentPage = fra_task_viewPager.getCurrentItem() % fragmentLists.size();
        for (int i = 0; i < fragmentLists.size(); i++) {
            ll_viewpager_bottom_line.getChildAt(i).setEnabled(currentPage == i);
        }
    }

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


    //加载工序
    public void loadProcessData() {
        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "processFeedback/listProcess");
        requestParams.addBodyParameter("userId", sp.getString("USER_ID", null));
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("Home", "工序:" + result);
                Gson gson = new Gson();
                ProcessFeedback pf = gson.fromJson(result, ProcessFeedback.class);
                if (pf.result.size() > 0) {
                    for (int i = 0; i < pf.result.size(); i++) {
                        processList.add(pf.result.get(i).id);
                    }
                }
                Log.e("Home", "processList.size:" + processList.size() + "-------" + processList.toString());
                //loadData(processList);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                // swipeRefreshLayout.setRefreshing(false);

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
    public void onDestroyView() {
        super.onDestroyView();

    }


    //菜单配置
    public void loadMenuControl() {
        String url = NetUrlUtils.NET_URL + "getMenu";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("id", sp.getString("USER_ID", null)).build();
        Request request = new Request.Builder().post(body).url(url).build();
        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                MenuControl menu = gson.fromJson(result, MenuControl.class);
                final List<String> menuList = menu.getResult();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String tenderName = tvFrTender.getText().toString();
                        String BidName = tvFrBid.getText().toString();
                        String lastManage = tvLastManage.getText().toString();
                        String nextManage = tvNextManage.getText().toString();
                        String TaskResponseName = tvFrTaskResponse.getText().toString();
                        String workPlanName = tvWorkPlan.getText().toString();
                        String afterSaleNmae = tvAfterSaleControl.getText().toString();
                        String FlowName = tvFlow.getText().toString();
                        String buyName = tvBuy.getText().toString();
                        String orderName = tvOrder.getText().toString();
                        String mySaleName = mySale.getText().toString();
                        String history = tvHistory.getText().toString();
                        String receiveName = tvReceive.getText().toString();
                        String tableName = tvTable.getText().toString();
                        String[] stringName = {tenderName, BidName, lastManage, nextManage, TaskResponseName, workPlanName, afterSaleNmae, FlowName, buyName, orderName,mySaleName, history, receiveName, tableName};
                        TextView[] textViews = {tvFrTender, tvFrBid, tvLastManage, tvNextManage, tvFrTaskResponse, tvWorkPlan, tvAfterSaleControl, tvFlow, tvBuy, tvOrder, mySale, tvHistory, tvReceive, tvTable};
                        if (menuList.size() > 0) {
                            for (int j = 0; j < stringName.length; j++) {
                                for (int i = 0; i < menuList.size(); i++) {

                                    if (menuList.get(i).equals(stringName[j])){
                                        textViews[j].setVisibility(View.VISIBLE);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                });

            }
        });

    }

    @OnClick({R.id.tv_fr_tender, R.id.tv_fr_bid, R.id.tv_last_manage, R.id.tv_next_manage, R.id.tv_fr_task_response, R.id.tv_workPlan, R.id.tv_buy, R.id.tv_order, R.id.tv_flow, R.id.tv_after_sale_control, R.id.tv_receive, R.id.tv_table, R.id.my_sale, R.id.tv_history})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_fr_tender:
                Intent intentTender = new Intent(getActivity(), TenderManage.class);
                startActivity(intentTender);
                break;
            case R.id.tv_fr_bid:
                Intent intentBid = new Intent(getActivity(), BidManage.class);
                startActivity(intentBid);
                break;
            case R.id.tv_last_manage:
                Intent intentLast = new Intent(getActivity(), LastFamilyManageCustomer.class);
                startActivity(intentLast);
                break;
            case R.id.tv_next_manage:
                Intent intentNext = new Intent(getActivity(), NextFamilyManageCompanySupplierManage.class);
                startActivity(intentNext);
                break;
            case R.id.tv_fr_task_response:
                Intent intentTaskResponse = new Intent(getActivity(), TaskResponseProcessQueue.class);
                startActivity(intentTaskResponse);
                break;
            case R.id.tv_workPlan:
                Intent intentworkPlan = new Intent(getActivity(), WorkPlanProcessQueue.class);
                startActivity(intentworkPlan);
                break;
            case R.id.tv_buy:
                Intent itBuy = new Intent(getActivity(), GoOrderPurchase.class);
                startActivity(itBuy);
                break;
            case R.id.tv_order:
                Intent itOrder = new Intent(getActivity(), ComeOrder.class);
                startActivity(itOrder);
                break;
            case R.id.tv_flow:
                Intent intentFlow = new Intent(getActivity(), FlowOrder.class);
                startActivity(intentFlow);
                break;
            case R.id.tv_after_sale_control:
                //售后
                break;
            case R.id.tv_receive:
                Intent intent = new Intent(getActivity(), ReceiveGoods.class);
                startActivity(intent);
                break;
            case R.id.tv_table:
                Intent intent_table = new Intent(getActivity(), SaleAmountAnalysis.class);
                startActivity(intent_table);
                //报表
                break;
            case R.id.my_sale:
                //我的售后
                break;
            case R.id.tv_history:
                //工作日志
                break;
        }

    }


}

