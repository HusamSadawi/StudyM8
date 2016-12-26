package com.example.husam.studym8.fragment;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.husam.studym8.R;
import com.example.husam.studym8.addEvent;

import java.util.ArrayList;
import java.util.List;


public class Calendar extends ListFragment {
    public static List<String> events = new ArrayList<>();

    public Calendar(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.calendar, container, false);
        events.add("Exam 2");
        Button button = (Button) rootView.findViewById(R.id.addevent);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View button)
            {
                Intent intent = new Intent(getActivity(), addEvent.class);
                getActivity().startActivity(intent);
            }
        });

        return rootView;

    }
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(),
                android.R.layout.simple_list_item_1, events);
        getListView().setAdapter(adapter);
    }

    public void addEvent1 (View button)
    {
        Intent intent = new Intent(getActivity(), addEvent.class);
        getActivity().startActivity(intent);
    }
}
