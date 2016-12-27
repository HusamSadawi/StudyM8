package com.example.husam.studym8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Course1 extends AppCompatActivity {

    public Course1() {

    }
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setContentView(R.layout.course1);
        super.onCreate(savedInstanceState);
        lv = (ListView) findViewById(R.id.list);
        List<String> events = new ArrayList<String>(Arrays.asList("Major 1", "Quiz 2", "Deliverable 1"));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, events);
        lv.setAdapter(arrayAdapter);

    }



}
