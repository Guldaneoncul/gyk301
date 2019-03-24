package com.example.ddd301;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fotovideocekk(View view) {
        Intent i= new Intent(MainActivity.this,FotografVideoActivity.class);
        startActivity(i);
    }

    public void SMS_gonder(View view) {
        Intent i= new Intent(MainActivity.this,SmsActivity.class);
        startActivity(i);
    }

    public void arama_yap(View view) {
        Intent i=new Intent(MainActivity.this,CallActivity.class);
        startActivity(i);
    }

    public void websayfasınagit(View view) {
        Intent i=new Intent(MainActivity.this,WebSayfaActivity.class);
        startActivity(i);
    }

    public void harita_git(View view) {
        Intent i=new Intent(MainActivity.this,HaritaActivity.class);
        startActivity(i);
    }

    public void sesKayit(View view) {
        Intent i=new Intent(MainActivity.this,SesKayitActivity.class);
        startActivity(i);
    }
}
