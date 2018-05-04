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

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20f);
        paint.setStyle(Paint.Style.STROKE);
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


    }
}
