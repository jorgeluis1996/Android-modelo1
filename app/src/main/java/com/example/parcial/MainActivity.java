package com.example.parcial;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.principal_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.nav_hbo:
                mostarHBO();
                return true;
            case R.id.nav_netflix:
                mostarNetflix();
                return true;
            case R.id.nav_prime:
                mostarPrime();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void mostarPrime() {
        startActivity(new Intent(this, jorge.class));
    }

    private void mostarNetflix() {
        startActivity(new Intent(this, ProductosActivity.class));
    }

    private void mostarHBO() {
        startActivity(new Intent(this, LosanillosActivity.class));
    }

}