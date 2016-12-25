package com.example.husam.studym8;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.*;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.util.Log;
import android.view.View;
import android.media.*;
import android.os.Environment;
import android.content.*;
import android.support.*;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.*;

import java.io.IOException;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class Camera extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    protected static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 0;

    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

   private void delegateTakingPicture(){
       // this method will delegate taking pictures task to android's built in camera app
       Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"fname_" +
               String.valueOf(System.currentTimeMillis()) + ".jpg"));
       intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageUri);
       startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
   }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {

                //use imageUri here to access the image

                Bundle extras = data.getExtras();

                Log.e("URI",imageUri.toString());

                Bitmap bmp = (Bitmap) extras.get("data");

                // here you will get the image as bitmap


            }

        }


    }
}
