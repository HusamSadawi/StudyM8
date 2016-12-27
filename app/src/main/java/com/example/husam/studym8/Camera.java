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

import com.example.husam.studym8.fragment.Courses;

import java.io.File;
import java.util.*;

import java.io.IOException;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class Camera extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    protected static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 0;
    String SavePathInDevice = null;
    private Image image;
    private Courses course = new Courses("SE322", "SE322");
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
    }

    public void takePicture(){
        image = new Image(course);
        SavePathInDevice = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"
                +createRandomFileName(3)+ image.getCourse().getID()+".jpg";
        image.setPath(SavePathInDevice);
        delegateTakingPicture();
    }

   private void delegateTakingPicture(){
       // this method will delegate taking pictures task to android's built in camera app
       Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, image.getPath());
       startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
   }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {



                Bundle extras = data.getExtras();

                Log.e("URI",image.getPath());

                Bitmap photo = (Bitmap) extras.get("data");
                imageView.setImageBitmap(photo);


            }

        }


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
}
