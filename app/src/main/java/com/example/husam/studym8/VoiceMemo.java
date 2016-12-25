package com.example.husam.studym8;

/**
 * Created by Husam on 12/25/2016.
 */

import android.media.*;
import android.os.*;
import android.content.*;
import android.support.*;




public class VoiceMemo  {
    private String path;
    private Course course;
    private String name;

    VoiceMemo(Course course) {
        this.course = course;
        this.name = course.getName();
    }

    public String getPath() {
        return path;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setName(String name) {
        this.name = name;
    }
}
