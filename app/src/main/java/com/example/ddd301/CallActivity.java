package com.example.ddd301;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
    }

    public void aramaa_yap(View view) {
        EditText editText=(EditText)findViewById(R.id.ara_et);
        String phonenumber=editText.getText().toString();

        Intent intent= new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phonenumber));
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
}
