package com.example.yangxiaoyu.myviewdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
import android.view.animation.LinearInterpolator;

/**
 * Created by yangxy on 2018/5/4.
 */

public class MyCircle extends View {

    private float degree;
    public MyCircle(Context context) {
        super(context);
        startAnimator();
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        startAnimator();
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        startAnimator();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //画的不同颜色的圆形
        Paint paint = new Paint();
        paint.setStrokeWidth(20f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(100,100,500,500);

        if(degree <= 15){
            paint.setColor(Color.RED);
        } else if(degree <= 45){
            paint.setColor(Color.GREEN);
        } else if(degree <= 105){
            paint.setColor(Color.BLUE);
        } else if(degree <= 190){
            paint.setColor(Color.YELLOW);
        } else if(degree < 360 ){
            paint.setColor(Color.BLACK);
        }
        canvas.drawArc(rectF,degree,degree,false,paint);

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

    public void startAnimator(){
        ValueAnimator animator = ObjectAnimator.ofFloat(this,"rotation",0,360f);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.d("yxy", "onAnimationUpdate: "+animation.getAnimatedValue("rotation"));
                degree = (float) animation.getAnimatedValue("rotation");
                postInvalidate();
            }
        });
        animator.setDuration(20000);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }
}
