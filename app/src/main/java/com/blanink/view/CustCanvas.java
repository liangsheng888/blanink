package com.blanink.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.blanink.R;

/**
 * Created by Administrator on 2017/6/7.
 */

public class CustCanvas extends View {

    private Canvas myCanvas;
    private Paint myPaint = new Paint();
    private float sx,sy,ex,ey;

    public CustCanvas(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public CustCanvas(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public CustCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        this.myCanvas = canvas;
        setPaintDefaultStyle();
        drawAL(sx, sy, ex, ey);
    }
     public void setPath(float sx,float sy,float ex,float ey){
         this.sx=sx;
         this.sy=sy;
         this.ex=ex;
         this.ey=ey;
     }
    /**
     * 设置画笔默认样式
     */
    public void setPaintDefaultStyle() {
        myPaint.setAntiAlias(true);
        myPaint.setColor(Color.RED);
        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(2);
    }


    /**
     * 画圆
     *
     * @param x      x坐标
     * @param y      y坐标
     * @param radius 圆的半径
     */
    public void drawCircle(float x, float y, float radius) {
        myCanvas.drawCircle(x, y, radius, myPaint);
        invalidate();
    }

    /**
     * 画一条直线
     *
     * @param fromX 起点x坐标
     * @param fromY 起点Y坐标
     * @param toX   终点X坐标
     * @param toY   终点Y坐标
     */
    public void drawLine(float fromX, float fromY, float toX, float toY) {
        Path linePath = new Path();
        linePath.moveTo(fromX, fromY);
        linePath.lineTo(toX, toY);
        linePath.close();
        myCanvas.drawPath(linePath, myPaint);
        invalidate();
    }


    /**
     * 画箭头
     *
     * @param sx
     * @param sy
     * @param ex
     * @param ey
     */
    public void drawAL(float sx, float sy, float ex, float ey) {
        double H = 8; // 箭头高度
        double L = 3.5; // 底边的一半
        int x3 = 0;
        int y3 = 0;
        int x4 = 0;
        int y4 = 0;
        double awrad = Math.atan(L / H); // 箭头角度
        double arraow_len = Math.sqrt(L * L + H * H); // 箭头的长度
        double[] arrXY_1 = rotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
        double[] arrXY_2 = rotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
        double x_3 = ex - arrXY_1[0]; // (x3,y3)是第一端点
        double y_3 = ey - arrXY_1[1];
        double x_4 = ex - arrXY_2[0]; // (x4,y4)是第二端点
        double y_4 = ey - arrXY_2[1];
        Double X3 = new Double(x_3);
        x3 = X3.intValue();
        Double Y3 = new Double(y_3);
        y3 = Y3.intValue();
        Double X4 = new Double(x_4);
        x4 = X4.intValue();
        Double Y4 = new Double(y_4);
        y4 = Y4.intValue();
        myCanvas.drawLine(sx, sy, ex, ey, myPaint);
        Path triangle = new Path();
        triangle.moveTo(ex, ey);
        triangle.lineTo(x3, y3);
        triangle.lineTo(x4, y4);
        triangle.close();
        myCanvas.drawPath(triangle, myPaint);

    }

    public void drawBl(float sx, float sy, float ex, float ey, Paint myPaint) {
        myPaint.reset();
        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setColor(Color.GREEN);
        Path path2 = new Path();
        path2.moveTo(sx, sy);//设置Path的起点
        path2.quadTo(sx, sy, ex, ey); //设置贝塞尔曲线的控制点坐标和终点坐标
        myCanvas.drawPath(path2, this.myPaint);//画出贝塞尔曲线
    }

    // 计算
    public double[] rotateVec(float px, float py, double ang, boolean isChLen, double newLen) {
        double mathstr[] = new double[2];
        // 矢量旋转函数，参数含义分别是x分量、y分量、旋转角、是否改变长度、新长度
        double vx = px * Math.cos(ang) - py * Math.sin(ang);
        double vy = px * Math.sin(ang) + py * Math.cos(ang);
        if (isChLen) {
            double d = Math.sqrt(vx * vx + vy * vy);
            vx = vx / d * newLen;
            vy = vy / d * newLen;
            mathstr[0] = vx;
            mathstr[1] = vy;
        }
        return mathstr;
    }


}

