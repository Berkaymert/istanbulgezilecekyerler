package com.example.berkaymert.stanbulgezilecekyerler;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private static int gosterim_suresi = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

             new Handler().postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     Intent i = new Intent(SplashActivity.this,KategoriActivity.class);
                    startActivity(i);
                    finish();
                 }
             },gosterim_suresi);

        }

    }