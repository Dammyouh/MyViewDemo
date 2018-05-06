package com.example.yangxiaoyu.myviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by yangxy on 2018/5/4.
 */

public class MyCircle extends View {


    public MyCircle(Context context) {
        super(context);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(800, 800);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        //画的不同颜色的圆形
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(100,100,500,500);
        int degree;
        for(degree = 0 ;degree <= 360;degree += 15){
            if(degree <= 15){
                canvas.drawArc(rectF,0,15,false,paint);
                Log.d("yxy", "onDraw: "+degree);
            } else if(degree <= 45){
                paint.setColor(Color.GREEN);
                canvas.drawArc(rectF,15,30,false,paint);
            } else if(degree <= 105){
                paint.setColor(Color.BLUE);
                canvas.drawArc(rectF,45,60,false,paint);
            } else if(degree <= 190){
                paint.setColor(Color.YELLOW);
                canvas.drawArc(rectF,105,85,false,paint);
            } else if(degree < 360 ){
                paint.setColor(Color.BLACK);
                canvas.drawArc(rectF,190,170,false,paint);
            }
        }

        //画字
        Paint textPaint = new Paint();
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(50);
        textPaint.setColor(Color.BLACK);
        canvas.drawText("1,453 calories",170,250,textPaint);
        canvas.drawText("burned",250,300,textPaint);
        textPaint.setColor(Color.GRAY);
        textPaint.setTextSize(25);
        canvas.drawText("Your avg is 2399 calories ",170,350,textPaint);
        //画一连串的点
        textPaint.setColor(Color.GRAY);
        textPaint.setStrokeWidth(15);
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeCap(Paint.Cap.ROUND);
        float points[]= {250,400,300,400,350,400};
        canvas.drawPoints(points,textPaint);
    }
}
