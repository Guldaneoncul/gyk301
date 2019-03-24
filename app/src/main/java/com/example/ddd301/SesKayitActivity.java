package com.example.ddd301;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class SesKayitActivity extends AppCompatActivity implements View.OnClickListener{

    Button kaydet;
    Button dur;
    Button cal;

    private MediaRecorder recorder;
    private MediaPlayer player;
    private final String filepath= Environment.getExternalStorageDirectory().getPath()+"/record.gp";
    private static final int REQUEST_AUDIO_PERMISSION_CODE=200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ses_kayit);
        kaydet=(Button)findViewById(R.id.kaydet);
        dur=(Button)findViewById(R.id.dur);
        cal=(Button)findViewById(R.id.cal);

        kaydet.setOnClickListener(this);
        dur.setOnClickListener(this);
        cal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v== kaydet){
            if(checkPermissions()){
                startRecording();
            }else{
                requestPermissions();
                startRecording();
            }

        }else if(v==dur){

            stopRecording();
        }
        else if(v==cal){
            startPlaying();
        }
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(SesKayitActivity.this,new String[]{RECORD_AUDIO,WRITE_EXTERNAL_STORAGE},REQUEST_AUDIO_PERMISSION_CODE);
    }

    private boolean checkPermissions() {
        int result= ContextCompat.checkSelfPermission(getApplicationContext(),WRITE_EXTERNAL_STORAGE);
        int result1= ContextCompat.checkSelfPermission(getApplicationContext(),RECORD_AUDIO);
        boolean sonuc=(result== PackageManager.PERMISSION_GRANTED && result1==PackageManager.PERMISSION_GRANTED);
        return sonuc;

    }

    private void startPlaying() {
        player=new MediaPlayer();
        player.setVolume(1.0f,1.0f);


        try {
            player.setDataSource(filepath);
            player.prepare();
            player.start();
            Toast.makeText(this,"kayıt çalıyor",Toast.LENGTH_SHORT).show();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.stop();
                    player.release();
                    player=null;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopRecording() {
        if(recorder !=null){
            recorder.stop();
            recorder.reset();
            recorder.release();
            recorder=null;
            Toast.makeText(getApplicationContext(),"kayıt durduruldu",Toast.LENGTH_SHORT).show();
        }
    }

    private void startRecording() {
        recorder= new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(filepath);
        try {
            recorder.prepare();
            recorder.start();
            Toast.makeText(this,"kayıt yapılıyor",Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_AUDIO_PERMISSION_CODE:
                if(grantResults.length>0){
                    boolean permissionToRecord=grantResults[0]==PackageManager.PERMISSION_GRANTED;
                    boolean permissionToStore=grantResults[1]==PackageManager.PERMISSION_GRANTED;
                    if(permissionToRecord && permissionToStore){
                        Toast.makeText(getApplicationContext(),"permission grated",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"permission denied",Toast.LENGTH_SHORT).show();
                    }
                }
        }
    }
}
