package com.example.ddd301;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebSayfaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_sayfa);


        WebView vw=(WebView)findViewById(R.id.web);
        vw.getSettings().getJavaScriptEnabled();
        vw.loadUrl("https://gelecegiyazanlar.turkcell.com.tr");


    }

}
