package com.example.yangxiaoyu.myviewdemo;


import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private MyCircle myCircle;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myCircle = findViewById(R.id.my_circle);
        btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);
    }

    public void loadMyCircle(View view){
        // 开启属性动画
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);;
        animator.setDuration(1800);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }

    @Override
    public void onClick(View v) {
        loadMyCircle(myCircle);
    }
}
