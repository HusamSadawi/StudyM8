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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.voicememos, container, false);
        return rootView;
    }
}
