package com.serpider.github.retrofit_sample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.serpider.github.retrofit_sample.R;

/*
Developed for users by @Serpider
Please read the comments thoroughly before use
*/

public class MainActivity extends AppCompatActivity {
    MaterialButton btnLoadData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*function to call the view to Java code*/
        initView();

        btnLoadData.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);
        });

    }
    private void initView() {
        btnLoadData = findViewById(R.id.btn_load_data);
    }
}