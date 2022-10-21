package com.example.lab07;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
    Button btnAll,btnDoraemon,btnNobita,btnBai3;
    ImageView ivAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnAll = findViewById(R.id.btnAll);
        btnDoraemon = findViewById(R.id.btnDoraemon);
        btnNobita = findViewById(R.id.btnNobita);
        btnBai3 = findViewById(R.id.btnBai3);
        ivAll = findViewById(R.id.ivAll);
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImage("All");
            }
        });
        btnDoraemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImage("Doraemon");
            }
        });
        btnNobita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImage("Nobita");
            }
        });
        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });
    }
    public void showImage(String img){
        ObjectAnimator anim = ObjectAnimator.ofFloat(ivAll,"translationX",0f,500f);
        anim.setDuration(2000);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(ivAll,"alpha",1f,0f);
        anim1.setDuration(2000);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(ivAll,"translationX",-500f,0f);
        anim2.setDuration(2000);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(ivAll,"alpha",0f,1f);
        anim3.setDuration(2000);
        AnimatorSet ans = new AnimatorSet();
        ans.play(anim2).with(anim3).after(anim).after(anim1);
        ans.start();
        final String imgName = img;
        anim1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if(imgName=="Nobita"){
                    ivAll.setImageResource(R.drawable.nobita);
                }
                if(imgName=="Doraemon"){
                    ivAll.setImageResource(R.drawable.doraemon);
                }
                if(imgName=="All"){
                    ivAll.setImageResource(R.drawable.all);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}