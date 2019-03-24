package com.example.ddd301;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HaritaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harita);
    }

    public void haritaac(View view) {
        Uri istabulunkoordinatlari= Uri.parse("geo:37.0748,36.2466");
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setData(istabulunkoordinatlari);
        if(i.resolveActivity(getPackageManager())!=null){
        startActivity(i);}
    }
}
