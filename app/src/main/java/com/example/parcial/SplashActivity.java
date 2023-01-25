package com.example.parcial;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(() ->{

            mostrarMain();

        }, 3000);
    }

    private void mostrarMain(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}