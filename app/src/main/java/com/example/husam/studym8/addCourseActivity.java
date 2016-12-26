package com.example.husam.studym8;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.husam.studym8.fragment.Courses;

public class addCourseActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courseform);
    }

    public void addCourse(View button)
    {
        //Intent intent = getIntent();
        Courses.setCourse("abdullah");
        finish();
        //startActivity(intent);

    }
}

