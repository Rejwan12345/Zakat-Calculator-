package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class Splash extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for full screen
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        lottieAnimationView = findViewById(R.id.load);
        // For Hide Action Bar
        // ActionBar actionBar = getSupportActionBar();
        //  actionBar.hide();
        //For Splash Screen

        lottieAnimationView.setVisibility(View.VISIBLE);


        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            //Code here
            Intent myIntent = new Intent(Splash.this, MainActivity.class);
            startActivity(myIntent);
            finish();
        }, 4000);


    }
}