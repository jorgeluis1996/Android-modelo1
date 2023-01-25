package com.example.parcial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.parcial.databinding.ActivityLosanillosBinding;
import com.example.parcial.fragments.peli1;
import com.example.parcial.fragments.peli2;
import com.example.parcial.fragments.peli3;
import com.example.parcial.fragments.peli4;

public class LosanillosActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityLosanillosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLosanillosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Button mbtnTheboys = findViewById(R.id.btnTheboys);
        Button mbtnMHC = findViewById(R.id.btnMHC);
        Button mbtnpeli3 = findViewById(R.id.btnpeli3);
        Button mbtnpeli4 = findViewById(R.id.btnpeli4);
        mbtnTheboys.setOnClickListener(this);
        mbtnMHC.setOnClickListener(this);
        mbtnpeli3.setOnClickListener(this);
        mbtnpeli4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnTheboys:
                mostrarTheBoys();
                break;case R.id.btnMHC:
                mostrarMHC();
                break;case R.id.btnpeli3:
                mostrarpeli3();
                break;case R.id.btnpeli4:
                mostrarpeli4();
                break;


        }
    }

    private void mostrarMHC() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new peli1())
                .commit();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    }

    private void mostrarTheBoys() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new peli2())
                .commit();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    }
    private void mostrarpeli3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new peli3())
                .commit();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    }
    private void mostrarpeli4() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new peli4())
                .commit();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    }

}