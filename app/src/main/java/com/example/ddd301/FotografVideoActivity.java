package com.example.ddd301;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class FotografVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotograf_video);
    }

    public void fotografcek(View view) {
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);//kamera açılımı ve foto çekimi, request 0 farklı olabilir ama foto ve video için farklı olmalı
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 0:
                Bitmap bitmap=(Bitmap) data.getExtras().get("data");//çekilen fotosunun datasını bitmap a dönüştürüyor
                ImageView imageview=(ImageView)findViewById(R.id.image_foto);//fotoyu image viewde oluşturuyo
                imageview.setImageBitmap(bitmap);
            case 1:
                VideoView videoView=(VideoView)findViewById(R.id.VideoView);
                videoView.setVideoURI(data.getData());
                videoView.setMediaController(new MediaController(this));
                videoView.requestFocus();
                videoView.start();
        }

    }

    public void videocek(View view) {
        Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(i,1);
    }
}
