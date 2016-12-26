package com.example.husam.studym8.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.husam.studym8.R;


public class Courses extends ListFragment {
        private String name;
        private String ID;
        private int credits;

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

        if (id == R.id.menu_item_1) {

            return true;
        }
        if (id == R.id.menu_item_2)
        {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        String[] courses = new String[2];
        courses[0] = "course1";
        courses[1] = "course2";
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1, courses);
        getListView().setAdapter(adapter);
    }

}
