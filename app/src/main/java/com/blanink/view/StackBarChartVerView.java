/**
 * Copyright 2014  XCL-Charts
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @Project XCL-Charts
 * @Description Android图表基类库
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 * @Copyright Copyright (c) 2014 XCL-Charts (www.xclcharts.com)
 * @license http://www.apache.org/licenses/  Apache v2 License
 * @version 1.0
 */
package com.blanink.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import org.xclcharts.chart.BarData;
import org.xclcharts.chart.StackBarChart;
import org.xclcharts.common.DensityUtil;
import org.xclcharts.common.IFormatterDoubleCallBack;
import org.xclcharts.common.IFormatterTextCallBack;
import org.xclcharts.event.click.BarPosition;
import org.xclcharts.renderer.XEnum;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 * @ClassName StackBarChart01View
 * @Description 堆叠图  垂直
 */
public class StackBarChartVerView extends DemoView {

    private String TAG = "StackBarChart01View";
    private StackBarChart chart = new StackBarChart();
    //标签轴
    List<String> chartLabels;
    List<BarData> BarDataSet;

    Paint pToolTip = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String leftTitle;
    private String title;

    public StackBarChartVerView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        initView();
    }

    public StackBarChartVerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public StackBarChartVerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
         /*chartLabels();
         chartDataSet();	*/
        chartRender();

        //綁定手势滑动事件
        this.bindTouch(this, chart);
    }

    public void setTitle(String title) {
        if (chart != null) {
            chart.setTitle(title);
        }
    }

    public void setLeftTitle(String leftTitle) {
        if (chart != null) {
            chart.getAxisTitle().setLeftTitle(leftTitle);
        }
    }
   public void setBarDataSet(List<BarData> barDataSet){
       this.BarDataSet=barDataSet;
       chart.setDataSource(barDataSet);
   }

    public void setChartLabels(List<String> chartLabels){
        this.chartLabels=chartLabels;
        chart.setCategories(chartLabels);

    }
    //设置范围
    public void setYAxis(double min, double max, double step) {
        if (chart != null) {
            chart.getDataAxis().setAxisMax(max);
            chart.getDataAxis().setAxisMin(min);
            chart.getDataAxis().setAxisSteps(step);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //图所占范围大小
        chart.setChartRange(w, h);
    }


    private void chartRender() {
        try {

            //设置绘图区默认缩进px值,留置空间显示Axis,Axistitle....
            int[] ltrb = getBarLnDefaultSpadding();
            chart.setPadding(ltrb[0], ltrb[1], ltrb[2], DensityUtil.dip2px(getContext(), 55));

            //显示边框
          //  chart.showRoundBorder();

            chart.setChartDirection(XEnum.Direction.VERTICAL);
            //数据源


            //坐标系

            //指定数据轴标签旋转-45度显示
            chart.getCategoryAxis().setTickLabelRotateAngle(-45f);
            Paint labelPaint = chart.getCategoryAxis().getTickLabelPaint();
            labelPaint.setTextAlign(Align.RIGHT);
            labelPaint.setColor(Color.rgb(0, 75, 106));
            chart.setTotalLabelVisible(false);
            chart.showDyLine();
            //标题
            chart.setTitleAlign(XEnum.HorizontalAlign.CENTER);
            chart.setTitleVerticalAlign(XEnum.VerticalAlign.MIDDLE);

            //背景网格
           // chart.getPlotGrid().showEvenRowBgColor();
          //  chart.getPlotGrid().showOddRowBgColor();

            //定义数据轴标签显示格式
            chart.getDataAxis().setLabelFormatter(new IFormatterTextCallBack() {

                @Override
                public String textFormatter(String value) {
                    // TODO Auto-generated method stub

                    DecimalFormat df = new DecimalFormat("#0");
                    Double tmp = Double.parseDouble(value);
                    String label = df.format(tmp).toString();
                    return label;
                }

            });

            //定义标签轴标签显示格式
            chart.getCategoryAxis().setLabelFormatter(new IFormatterTextCallBack() {

                @Override
                public String textFormatter(String value) {
                    // TODO Auto-generated method stub
                    String label =  value;
                    return label;
                }

            });

            //定义柱形上标签显示格式
            chart.getBar().setItemLabelVisible(true);
            chart.setItemLabelFormatter(new IFormatterDoubleCallBack() {
                @Override
                public String doubleFormatter(Double value) {
                    // TODO Auto-generated method stub
                    DecimalFormat df = new DecimalFormat("0.00");
                    String label = df.format(value).toString();
                    return label;
                }
            });

            //定义柱形上标签显示颜色
            chart.getBar().getItemLabelPaint().setColor(Color.rgb(77, 184, 73));
            chart.getBar().getItemLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);

            //激活点击监听
            chart.ActiveListenItemClick();
            chart.showClikedFocus();
            chart.setPlotPanMode(XEnum.PanMode.FREE);

            chart.setBarCenterStyle(XEnum.BarCenterStyle.TICKMARKS);

            //chart.disablePanMode();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e(TAG, e.toString());
        }
    }



    @Override
    public void render(Canvas canvas) {
        try {

            //chart.setChartRange(this.getMeasuredWidth(), this.getMeasuredHeight());
            chart.render(canvas);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        super.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_UP) {
            triggerClick(event.getX(), event.getY());
        }
        return true;
    }


    //触发监听
    private void triggerClick(float x, float y) {

        BarPosition record = chart.getPositionRecord(x, y);
        if (null == record) return;

        if (record.getDataID() >= BarDataSet.size()) return;
        BarData bData = BarDataSet.get(record.getDataID());

        int cid = record.getDataChildID();
        Double bValue = bData.getDataSet().get(cid);
        String label = chartLabels.get(cid);
        String labelTitle= bData.getKey();
        chart.showFocusRectF(record.getRectF());
        chart.getFocusPaint().setStyle(Style.FILL);
        chart.getFocusPaint().setStrokeWidth(3);
        chart.getFocusPaint().setColor(Color.GREEN);
        chart.getFocusPaint().setAlpha(100);

        //在点击处显示tooltip
        pToolTip.setColor(Color.BLACK);
        chart.getToolTip().setAlign(Align.CENTER);
        chart.getToolTip().setInfoStyle(XEnum.DyInfoStyle.CIRCLE);
            chart.getToolTip().getBackgroundPaint().setColor(Color.rgb(0,255,255));

        //chart.getToolTip().setCurrentXY(record.getRectF().centerX(),record.getRectF().centerY());
        chart.getToolTip().setCurrentXY(x, y);
        chart.getToolTip().addToolTip("("+label+")" + labelTitle+":" + Double.toString(bValue), pToolTip);

        this.invalidate();

    }

}
