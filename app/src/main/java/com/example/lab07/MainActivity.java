package com.example.lab07;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnRotation,btnMoving,btnZoom,btnBai2;
    ImageView ivAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRotation = findViewById(R.id.btnRotation);
        btnMoving = findViewById(R.id.btnMoving);
        btnZoom = findViewById(R.id.btnZoom);
        btnBai2 = findViewById(R.id.btnBai2);
        ivAll = findViewById(R.id.ivAll);
        btnRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dest = 360;
                if(ivAll.getRotation() == 360){
                    System.out.println(ivAll.getAlpha());
                    dest = 0;
                }
                ObjectAnimator animator = ObjectAnimator.ofFloat(ivAll,"rotation",dest);
                animator.start();
            }
        });
        btnMoving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.move);
                ivAll.startAnimation(animation);
            }
        });
        btnZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom);
                ivAll.startAnimation(animation);
            }
        });
        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}