package com.serpider.github.retrofit_sample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.serpider.github.retrofit_sample.R;

/*
Developed for users by @Serpider
Please read the comments thoroughly before use
*/

public class SplashActivity extends AppCompatActivity {

    /*Use the Handler class to pause and run*/
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*Go to home page after 3 seconds*/
        handler.postDelayed(() -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        },3000);

    }
}