package com.example.husam.studym8;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.*;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.view.View;
import android.media.*;
import android.os.Environment;
import android.content.*;
import android.support.*;
import android.widget.Button;
import android.widget.Toast;

import com.example.husam.studym8.fragment.Courses;
import com.example.husam.studym8.fragment.VoiceMemos;

import java.util.*;

import java.io.IOException;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.R.id.button2;

public class VoiceRecorder extends AppCompatActivity {


    String AudioSavePathInDevice = null;
    public static final int RequestPermissionCode = 1;
    private MediaPlayer mediaPlayer;
    private MediaRecorder mediaRecorder = new MediaRecorder();
    public VoiceMemos recording;
    public Courses course = new Courses("SE322","SE322");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addrecording);
            final Button play = (Button) findViewById(R.id.play);
            final Button stop = (Button) findViewById(R.id.stop);
            final Button record = (Button) findViewById(R.id.record);
            play.setEnabled(false);
            stop.setEnabled(true);
            record.setEnabled(false);
            //VoiceRecorderReady();
            record.setOnClickListener(new View.OnClickListener(){
                public void onClick(View button)
                {

                    startRecording();
                    record.setEnabled(false);
                    stop.setEnabled(true);
                }

            });
            stop.setOnClickListener(new View.OnClickListener() {
                public void onClick(View button2) {
                    stopRecording();
                    record.setEnabled(true);
                    stop.setEnabled(false);
                    play.setEnabled(true);
                }
            });
            play.setOnClickListener(new View.OnClickListener() {
                public void onClick(View button2) {
                    record.setEnabled(false);
                    startPlayer();
                    stop.setEnabled(true);
                    play.setEnabled(false);
                }
            });

    }

    public void startRecording(){
        if(checkPermission()){
            recording = new VoiceMemos(course);
            AudioSavePathInDevice = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"
                    +createRandomFileName(3)+ recording.getCourse().getID()+".3gp";
            recording.setPath(AudioSavePathInDevice);

            VoiceRecorderReady();
            try {
                mediaRecorder.prepare();
                mediaRecorder.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            requestPermission();
        }

    }

    public void stopRecording(){
        mediaRecorder.stop();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void pauseRecording(){
        mediaRecorder.pause();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void resumeRecording(){
        mediaRecorder.resume();
    }

    public void startPlayer(){
        mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(recording.getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void pausePlayer(){
        if(mediaPlayer != null){
            mediaPlayer.pause();
        }
    }

    public void resumePlayer(){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }
    public void stopPlayer(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            VoiceRecorderReady();
        }
    }

    public void VoiceRecorderReady(){
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(recording.getPath());
        System.out.println("VoiceRecorderReady");
    }

    public String createRandomFileName(int string){
        String RandomAudioFileName = "ABCDEFGHIJKLMNOP";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder( string );
        int i = 0 ;
        while(i < string ) {
            stringBuilder.append(RandomAudioFileName.
                    charAt(random.nextInt(RandomAudioFileName.length())));

            i++ ;
        }
        return stringBuilder.toString();
    }
    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new
                String[]{WRITE_EXTERNAL_STORAGE, RECORD_AUDIO}, RequestPermissionCode);
    }
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length> 0) {
                    boolean StoragePermission = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean RecordPermission = grantResults[1] ==
                            PackageManager.PERMISSION_GRANTED;
                }
                break;
        }
    }

    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(),
                WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(),
                RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED &&
                result1 == PackageManager.PERMISSION_GRANTED;
    }
}


