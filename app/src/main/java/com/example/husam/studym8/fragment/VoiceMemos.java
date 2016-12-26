package com.example.husam.studym8.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.husam.studym8.R;


public class VoiceMemos extends ListFragment {
    public VoiceMemos() {
    }

    private String path;
    private Courses course;
    private String name;

    public VoiceMemos(Courses course) {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.voicememos, container, false);
        return rootView;
    }
}
