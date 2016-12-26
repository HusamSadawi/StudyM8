package com.example.husam.studym8;

/**
 * Created by Husam on 12/25/2016.
 */

import android.media.*;
import android.os.*;
import android.content.*;
import android.support.*;

import com.example.husam.studym8.fragment.Courses;


public class VoiceMemo  {
    private String path;
    private Courses course;
    private String name;

    VoiceMemo(Courses course) {
        this.course = course;
        this.name = course.getName();
    }

    public String getPath() {
        return path;
    }

    public Courses getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public void setName(String name) {
        this.name = name;
    }
}
