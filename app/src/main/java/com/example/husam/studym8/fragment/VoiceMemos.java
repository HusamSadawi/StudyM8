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
import com.example.husam.studym8.VoiceRecorder;

import java.util.ArrayList;
import java.util.List;


public class VoiceMemos extends ListFragment {
    public static List<String> voices = new ArrayList<>();
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(),
                android.R.layout.simple_list_item_1, voices);
        getListView().setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.main_menu_voice, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.menu_item_1) {
            addRecording();
            return true;
        }
        if (id == R.id.menu_item_2) {
            deleteRecording();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addRecording()
    {
        Intent intent = new Intent(getActivity(), VoiceRecorder.class);
        getActivity().startActivity(intent);
    }
    public void deleteRecording()
    {

    }
}


