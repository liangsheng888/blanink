package com.blanink.activity.flow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.activity.lastNext.LastDeleteRelationIsAgree;
import com.blanink.pojo.FlowData;
import com.blanink.pojo.FlowDetail;
import com.blanink.pojo.Process;
import com.blanink.pojo.RelFlowProcess;
import com.blanink.pojo.Response;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.ExampleUtil;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.SysConstants;
import com.blanink.view.CusRect;
import com.blanink.view.CustCanvas;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 使用本流程
 */
public class FlowUseTheFlow extends AppCompatActivity implements View.OnTouchListener {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order_detail_rl)
    RelativeLayout comeOrderDetailRl;
    @BindView(R.id.rl_flow)
    RelativeLayout rlFlow;
    @BindView(R.id.activity_flow_use_the_flow)
    RelativeLayout activityFlowUseTheFlow;
    @BindView(R.id.rl_flow_main)
    RelativeLayout rlFlowMain;
    @BindView(R.id.tv_save)
    TextView tvSave;
    private MyActivityManager myActivityManager;
    private SharedPreferences sp;
    private String id;
    private int _xDelta;
    private int _yDelta;
    private String productId;
    private Map<String, RelFlowProcess> relFlowProcessMap = new HashMap<>();
    Map<String, String> mapName=new HashMap<>();
    private AlertDialog alertDialog;
    private String flowData;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        }*/
        setContentView(R.layout.activity_flow_use_the_flow);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);

        ButterKnife.bind(this);
        receiveData();
        initData();

    }

    private void receiveData() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
    }

    private void initData() {
        rlFlow.setOnTouchListener(this);
        loadData();
        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlowUseTheFlow.this, FlowSave.class);
                intent.putExtra("orderProductId", getIntent().getStringExtra("orderProductId"));
                intent.putExtra("relFlowProcessMap", new Gson().toJson(relFlowProcessMap));
                intent.putExtra("flowData", flowData);
                startActivity(intent);


            }
        });
    }


    @Override
    protected void onDestroy() {
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        }
        super.onDestroy();
    }

    public void loadData() {
        if (!ExampleUtil.isConnected(this)) {
            Toast.makeText(this, "请检查你的网络！", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "flow/getCommon");
        rp.addBodyParameter("userId", sp.getString("USER_ID", null));
        rp.addBodyParameter("id", id);
        Log.e("FlowUse", NetUrlUtils.NET_URL + "flow/getCommon?userId=" + sp.getString("USER_ID", null) + "&id=" + id);
        x.http().post(rp, new Callback.CacheCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                FlowDetail flowDetail = gson.fromJson(result, FlowDetail.class);
                flowData = flowDetail.getResult().getFlowData();
                FlowData fd = gson.fromJson(flowData, FlowData.class);
                Log.e("Flow", "fd:" + fd.toString());

                Map<String, String> mapTransitions = fd.getTransitions();
                mapName = fd.getNames();
                Map<String, FlowData.FlowPosition> mapPositions = fd.getPositions();
                Log.e("Flow", "mapName:" + mapName.size());
                Log.e("Flow", "mapTransitions:" + mapTransitions.toString());
                Log.e("Flow", "fd:" + fd.toString());
                for (Map.Entry<String, String> trans : mapTransitions.entrySet()) {
                    //初始化两个圆点对象
                    final CusRect rect = new CusRect(FlowUseTheFlow.this);

                    //初始化线条
                    CustCanvas custCanvas = null;

                    final String key = trans.getKey();
                    String value = trans.getValue();
                    final String[] stValue = value.split(",");
                    Log.e("Flow", "key,value:{" + key + "," + value + "}");
                    //根据主键找位置
                    final FlowData.FlowPosition fow = mapPositions.get(key);
                    Log.e("Flow", "fow" + fow);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.topMargin = (int) Math.rint(fow.getTop()) * SysConstants.EXPAND_TIMES;
                    layoutParams.leftMargin = (int) Math.rint(fow.getLeft()) * SysConstants.EXPAND_TIMES;
                    rect.setLayoutParams(layoutParams);
                    rlFlow.addView(rect);
                    rect.setTile(mapName.get(key).split("\\(")[0]);
                    if (relFlowProcessMap.get(key) != null) {
                        rect.setNum("(" + relFlowProcessMap.get(key).getTarget() + ")");
                        rect.setTileColor(getResources().getColor(R.color.colorOrange));
                    }
                    // loadProcessName(rect, key);
                    //点击事件
                    rect.setOnButtonClickListener(new CusRect.OnButtonClickListener() {
                        @Override
                        public void onButtonClick(View v) {
                            Log.e("FlowUse", "点击了" + rect.getTile() + "----" + key);
                            Intent intent = new Intent(FlowUseTheFlow.this, FlowSet.class);
                            intent.putExtra("flowId", id);
                            intent.putExtra("processId", key);
                            intent.putExtra("orderProductId", getIntent().getStringExtra("orderProductId"));
                            intent.putExtra("processName", rect.getTile());
                            intent.putExtra("relFlowProcess", new Gson().toJson(relFlowProcessMap.get(key)));
                            startActivityForResult(intent, 2);
                        }
                    });
                    //根据vlaue 找位置 画图  value 可能是多个值
                    RelativeLayout.LayoutParams layoutParams2 = null;
                    CusRect rect2 = null;
                    FlowData.FlowPosition fow2 = null;
                    for (int i = 0; i < stValue.length; i++) {
                        custCanvas = new CustCanvas(FlowUseTheFlow.this);
                        fow2 = mapPositions.get(stValue[i]);
                        Log.e("Flow", "fow" + i + ":" + fow2);
                        rect2 = new CusRect(FlowUseTheFlow.this);
                        layoutParams2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        layoutParams2.topMargin = (int) Math.rint(fow2.getTop()) * SysConstants.EXPAND_TIMES;
                        layoutParams2.leftMargin = (int) Math.rint(fow2.getLeft()) * SysConstants.EXPAND_TIMES;
                        rect2.setLayoutParams(layoutParams2);
                        rlFlow.addView(rect2);
                        final CusRect finalRect = rect2;
                        final int finalI = i;
                        final CustCanvas finalCustCanvas = custCanvas;
                        rect2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            @Override
                            public void onGlobalLayout() {
                                int h = finalRect.findViewById(R.id.bt_flow).getMeasuredHeight();
                                int w = finalRect.findViewById(R.id.bt_flow).getMeasuredWidth();
                                int sx = rect.findViewById(R.id.bt_flow).getLeft() + rect.getLeft();
                                int sy = rect.getTop();
                                int ex = finalRect.findViewById(R.id.bt_flow).getLeft() + finalRect.getLeft();
                                int ey = finalRect.getTop();
                                Log.e("@@@", "i" + finalI);
                                getLinePoint(sx, sy, ex, ey, finalCustCanvas, h / 2, SysConstants.SHRINK_TIMES);
                                finalRect.getViewTreeObserver()
                                        .removeGlobalOnLayoutListener(this);
                            }
                        });
                        rlFlow.addView(custCanvas);
                        rect2.setTile(mapName.get(stValue[i]).split("\\(")[0]);
                        if (relFlowProcessMap.get(stValue[i]) != null) {
                            rect2.setNum("(" + relFlowProcessMap.get(stValue[i]).getTarget() + ")");
                            rect2.setTileColor(getResources().getColor(R.color.colorOrange));
                        }
                        //loadProcessName(rect2, stValue[i]);
                        final CusRect finalRect1 = rect2;
                        final int finalI1 = i;
                        final CusRect finalRect2 = rect2;
                        rect2.setOnButtonClickListener(new CusRect.OnButtonClickListener() {
                            @Override
                            public void onButtonClick(View v) {
                                Log.e("FlowUse", "点击了" + finalRect1.getTile() + "----" + stValue[finalI1]);
                                Intent intent = new Intent(FlowUseTheFlow.this, FlowSet.class);
                                intent.putExtra("flowId", id);
                                intent.putExtra("processId", stValue[finalI1]);
                                intent.putExtra("orderProductId", getIntent().getStringExtra("orderProductId"));
                                intent.putExtra("processName", finalRect2.getTile());
                                intent.putExtra("relFlowProcess", new Gson().toJson(relFlowProcessMap.get(stValue[finalI1])));
                                startActivityForResult(intent, 2);
                            }
                        });
                    }

                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("Flow",  ex.toString());

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

    @OnClick(R.id.iv_last)
    public void onClick() {
        if (relFlowProcessMap.size() == mapName.size()&&mapName.size()!=0) {
            showDialogExit();
        } else {
            finish();
        }
    }

    /*@Override
    protected void onPause() {
        super.onPause();
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);        }

    }*/

    @Override
    protected void onResume() {

        super.onResume();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//land
        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//port
        }
    }

    public void getLinePoint(float sx, float sy, float ex, float ey, CustCanvas canvas, int r, float expand) {
        float sxCenter = (sx + r);
        float syCenter = (sy + r);
        float exCenter = (ex + r);
        float eyCenter = (ey + r);
        Double lineStartX = 0.0;
        Double lineStartY = 0.0;
        Double lineEndX = 0.0;
        Double LineEndY = 0.0;
        if (exCenter - sxCenter > 0 && eyCenter - syCenter > 0) {//右下角
            lineStartX = sxCenter + (Math.abs(exCenter - sxCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
            lineStartY = syCenter + (Math.abs(eyCenter - syCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
            lineEndX = exCenter - (Math.abs(exCenter - sxCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
            LineEndY = eyCenter - (Math.abs(eyCenter - syCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
        } else if (exCenter - sxCenter >= 0 && eyCenter - syCenter <= 0) {//右上角
            lineStartX = sxCenter + (Math.abs(exCenter - sxCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
            lineStartY = syCenter - (Math.abs(eyCenter - syCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
            lineEndX = exCenter - (Math.abs(exCenter - sxCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
            LineEndY = eyCenter + (Math.abs(eyCenter - syCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);

        } else if (exCenter - sxCenter < 0 && eyCenter - syCenter > 0) {//左下角
            lineStartX = sxCenter - (Math.abs(exCenter - sxCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
            lineStartY = syCenter + (Math.abs(eyCenter - syCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
            lineEndX = exCenter + (Math.abs(exCenter - sxCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
            LineEndY = eyCenter - (Math.abs(eyCenter - syCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);

        } else if (exCenter - sxCenter <= 0 && eyCenter - syCenter <= 0) {//左上角
            lineStartX = sxCenter - (Math.abs(exCenter - sxCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
            lineStartY = syCenter - (Math.abs(eyCenter - syCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
            lineEndX = exCenter + (Math.abs(exCenter - sxCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
            LineEndY = eyCenter + (Math.abs(eyCenter - syCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r * expand);
        }
        canvas.setPath(Float.parseFloat(lineStartX + ""), Float.parseFloat("" + lineStartY), Float.parseFloat("" + lineEndX), Float.parseFloat("" + LineEndY));
    }

    public boolean onTouch(View view, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view
                        .getLayoutParams();
                _xDelta = X - lParams.leftMargin;
                _yDelta = Y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                        .getLayoutParams();
                layoutParams.leftMargin = X - _xDelta;
                layoutParams.topMargin = Y - _yDelta;
                layoutParams.rightMargin = -350;
                layoutParams.bottomMargin = -350;
                view.setLayoutParams(layoutParams);
                break;
        }
        rlFlowMain.invalidate();
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            rlFlow.removeAllViews();
            RelFlowProcess relFlowProcess = (RelFlowProcess) data.getExtras().getSerializable("RelFlowProcess");
            Log.e("FlowUse", relFlowProcess.toString());
            relFlowProcessMap.put(relFlowProcess.getProcessId(), relFlowProcess);
            loadData();
            if (relFlowProcessMap.size() == mapName.size()) {
                tvSave.setVisibility(View.VISIBLE);
            }
        }
    }

    public void loadProcessName(final CusRect rect, String processId) {
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "process/getOneProcess");
        rp.addBodyParameter("id", processId);
        x.http().post(rp, new Callback.CacheCallback<String>() {


            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Process process = gson.fromJson(result, Process.class);
                rect.setTile(process.getResult().getName());
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

    //监听菜单 防止用户不小心退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (relFlowProcessMap.size() == mapName.size()&&mapName.size()!=0) {
                showDialogExit();
            }else {
                finish();
            }
        }

        return false;

    }

    private void showDialogExit() {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_exit);
        final Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        window.setWindowAnimations(R.style.dialogAnimation);
        window.setAttributes(lp);

        ((TextView) window.findViewById(R.id.tv_content)).setText("你的数据没有保存，确定返回吗?");
        ((TextView) window.findViewById(R.id.tv_continue)).setText("取消");
        ((TextView) window.findViewById(R.id.tv_exit)).setText("确定");

        window.findViewById(R.id.tv_continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        window.findViewById(R.id.tv_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                finish();
            }
        });
    }


}