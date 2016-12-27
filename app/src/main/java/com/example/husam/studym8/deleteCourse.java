package com.example.husam.studym8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.husam.studym8.fragment.Courses;

/**
 * Created by ASUS on 12/27/2016.
 */

public class deleteCourse extends AppCompatActivity {
    public deleteCourse()
    {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletecourse);
    }
    public void delete(View button)
    {
        finish();
        Courses.courses.remove("Project Management");
    }
}
