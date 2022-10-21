package com.example.lab07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity3 extends AppCompatActivity {
    ImageView ivHour,ivMinute,ivSecond;
    Button btnRun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ivHour = findViewById(R.id.ivHour);
        ivMinute = findViewById(R.id.ivMinute);
        ivSecond = findViewById(R.id.ivSecond);
        btnRun = findViewById(R.id.btnRun);
        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animationHour = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.hour);
                Animation animationMinute = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.minute);
                Animation animationSecond = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.second);
                ivHour.startAnimation(animationHour);
                ivMinute.startAnimation(animationMinute);
                ivSecond.startAnimation(animationSecond);
            }
        });
    }
}