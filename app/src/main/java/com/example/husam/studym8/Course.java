package com.example.husam.studym8;

/**
 * Created by Husam on 12/25/2016.
 */

public class Course {

    private String name;
    private String ID;
    private int credits;

     Course(String name, String ID, int credits){
        this.credits = credits;
        this.name = name;
        this.ID = ID;
    }

     Course(String name){
        this.name = name;
    }
     Course(String ID){
        this.ID = ID;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
}
