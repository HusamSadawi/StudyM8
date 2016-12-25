package com.example.husam.studym8;

/**
 * Created by Husam on 12/25/2016.
 */

public class Image {
    private String name;
    private String path;
    private Course course;

    Image(Course course){
        this.course = course;
        this.name = course.getName();
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    public String getPath() {
        return path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
