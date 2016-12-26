package com.example.husam.studym8.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.husam.studym8.Image;
import com.example.husam.studym8.R;

import java.util.LinkedList;


public class Gallery extends ListFragment {
    public Gallery() {
    }
    private static LinkedList<Image> galleryDB = new LinkedList<Image>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.gallery, container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        String[] courses = new String[2];
        courses[0] = "gallery1";
        courses[1] = "Gallery2";
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1, courses);
        getListView().setAdapter(adapter);
    }
}
