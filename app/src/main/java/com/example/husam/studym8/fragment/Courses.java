package com.example.husam.studym8.fragment;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.husam.studym8.R;
import com.example.husam.studym8.addCourseActivity;

import java.util.ArrayList;
import java.util.List;


public class Courses extends ListFragment {
    private String name;
    private String ID;
    private int credits;
    public static List<String> courses = new ArrayList<>();


        Courses(String name, String ID, int credits){
            this.credits = credits;
            this.name = name;
            this.ID = ID;
        }

        Courses(String name, String ID){
            this.name = name; this.ID = ID;
        }

    public Courses() {

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




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.courses, container, false);

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.menu_item_1)
        {
            addCourse();
            return true;
        }
        if (id == R.id.menu_item_2)
        {
            deleteCourse();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(),
                android.R.layout.simple_list_item_1, courses);
        getListView().setAdapter(adapter);
    }
    public void addCourse()
    {
        Intent intent = new Intent(getActivity(), addCourseActivity.class);
        getActivity().startActivity(intent);
    }
    public void deleteCourse(){

    }
    public List<String> getcourses()
    {
        return courses;
    }
    public static void setCourse(String course)
    {
        courses.add(course);
    }

}
