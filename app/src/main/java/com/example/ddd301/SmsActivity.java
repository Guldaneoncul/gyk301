package com.example.ddd301;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
    }

    public void gonder(View view) {
        EditText phoneNumber=(EditText)findViewById(R.id.tel_no);
        String telephone=phoneNumber.getText().toString();

        EditText mesaj=(EditText)findViewById(R.id.mesaj);
        String mesajınız=mesaj.getText().toString();


        Uri uri= Uri.parse("smsto:"+telephone);
        Intent i=new Intent(Intent.ACTION_SENDTO,uri);
        i.putExtra("sms_body",mesajınız);
        startActivity(i);
    }
}
