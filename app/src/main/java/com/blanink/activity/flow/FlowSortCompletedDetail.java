package com.blanink.activity.flow;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.FlowData;
import com.blanink.pojo.FlowDetail;
import com.blanink.utils.CommonUtil;
import com.blanink.utils.NetUrlUtils;
import com.blanink.utils.SysConstants;
import com.blanink.view.CusRect;
import com.blanink.view.CustCanvas;
import com.blanink.view.ScaleView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 已派流程 详情
 */
public class FlowSortCompletedDetail extends AppCompatActivity implements View.OnTouchListener {
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.flow_detail)
    RelativeLayout flowDetail;
    @BindView(R.id.flow)
    RelativeLayout flow;
    @BindView(R.id.flow_view)
    RelativeLayout flowView;
    private int _xDelta;
    private int _yDelta;
    ScaleView sg = new ScaleView();
    ScaleGestureDetector detector;
   FlowDetail fd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_sort_completed_detail);
        ButterKnife.bind(this);
        loadData();
        //移动
        //detector = new ScaleGestureDetector(flow.getContext(), sg);

        flow.setOnTouchListener(this);

    }

    public void loadData() {
        if (!CommonUtil.isConnected(this)) {
            Toast.makeText(this, "请检查你的网络！", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestParams rp = new RequestParams(NetUrlUtils.NET_URL + "flow/getFlow");
        rp.addBodyParameter("orderProduct.id", getIntent().getStringExtra("productId"));
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                final FlowDetail flowDetail = gson.fromJson(result, FlowDetail.class);
                String flowData = flowDetail.getResult().getFlowData();
                FlowData fd = gson.fromJson(flowData, FlowData.class);
                Map<String, String> mapTransitions = fd.getTransitions();
                Map<String, String> mapName = fd.getNames();
                Map<String, FlowData.FlowPosition> mapPositions = fd.getPositions();
                Log.e("Flow", "mapName:" + mapName.size());
                Log.e("Flow", "mapTransitions:" + mapTransitions.toString());
                Log.e("Flow", "fd:" + fd.toString());
                for (Map.Entry<String, String> trans : mapTransitions.entrySet()) {
                    //初始化两个圆点对象
                    final CusRect rect = new CusRect(FlowSortCompletedDetail.this);

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
                    flow.addView(rect);
                    rect.setTile(mapName.get(key));
                    rect.setOnButtonClickListener(new CusRect.OnButtonClickListener() {
                        @Override
                        public void onButtonClick(View v) {
                            Intent intent = new Intent(FlowSortCompletedDetail.this, FlowSeekProcessDetail.class);
                            intent.putExtra("flowId", flowDetail.getResult().getId());
                            intent.putExtra("processId", key);
                            startActivity(intent);
                        }
                    });
                    //根据vlaue 找位置 画图  value 可能是多个值
                    RelativeLayout.LayoutParams layoutParams2 = null;
                    CusRect rect2 = null;
                    FlowData.FlowPosition fow2 = null;
                    for (int i = 0; i < stValue.length; i++) {
                        custCanvas = new CustCanvas(FlowSortCompletedDetail.this);
                        fow2 = mapPositions.get(stValue[i]);
                        Log.e("Flow", "fow" + i + ":" + fow2);
                        rect2 = new CusRect(FlowSortCompletedDetail.this);
                        layoutParams2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        layoutParams2.topMargin = (int) Math.rint(fow2.getTop()) * SysConstants.EXPAND_TIMES;
                        layoutParams2.leftMargin = (int) Math.rint(fow2.getLeft() * SysConstants.EXPAND_TIMES);
                        rect2.setLayoutParams(layoutParams2);
                        flow.addView(rect2);
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
                        flow.addView(custCanvas);
                        rect2.setTile(mapName.get(stValue[i]));
                        final int finalI1 = i;
                        rect2.setOnButtonClickListener(new CusRect.OnButtonClickListener() {
                            @Override
                            public void onButtonClick(View v) {
                                Intent intent = new Intent(FlowSortCompletedDetail.this, FlowSeekProcessDetail.class);
                                intent.putExtra("flowId", flowDetail.getResult().getId());
                                intent.putExtra("processId", stValue[finalI1]);
                                startActivity(intent);
                            }
                        });
                    }

                }
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

    @OnClick(R.id.iv_last)
    public void onClick() {
        finish();
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
                layoutParams.rightMargin = -200;
                layoutParams.bottomMargin = -200;
                view.setLayoutParams(layoutParams);
                break;
        }
        flowView.invalidate();
        return true;
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

    /*

        //划线
        public void getLinePoint(float sx, float sy, float ex, float ey, CustCanvas canvas, int r) {
            float sxCenter = (sx + r);
            float syCenter = (sy + r);
            float exCenter = (ex + r);
            float eyCenter = (ey + r);
            Double lineStartX = sxCenter + ((exCenter - sxCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r);
            Double lineStartY = syCenter + ((eyCenter - syCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r);
            Double lineEndX = exCenter - ((exCenter - sxCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r);
            Double LineEndY = eyCenter - ((eyCenter - syCenter) / Math.sqrt(Math.pow((exCenter - sxCenter), 2) + Math.pow((eyCenter - exCenter), 2)) * r);
            canvas.setPath(Float.parseFloat(lineStartX + ""), Float.parseFloat("" + lineStartY), Float.parseFloat("" + lineEndX), Float.parseFloat("" + LineEndY));
        }
    */
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

    @Override
    protected void onDestroy() {
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        }
        super.onDestroy();
    }
}
