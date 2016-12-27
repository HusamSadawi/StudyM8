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

import com.example.husam.studym8.Camera;
import com.example.husam.studym8.Image;
import com.example.husam.studym8.R;

import java.util.LinkedList;


public class Gallery extends ListFragment {
    public static String[] gallery = new String[2];
    public Gallery() {
    }
    private static LinkedList<Image> galleryDB = new LinkedList<Image>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.gallery, container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        gallery[0] = "gallery1";
        gallery[1] = "Gallery2";
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1, gallery);
        getListView().setAdapter(adapter);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.main_menu_gallery, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.menu_item_1) {
            takePicture();
            return true;
        }
        if (id == R.id.menu_item_2) {
            deletePicture();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void takePicture()
    {
        Camera cam = new Camera();
        cam.takePicture();
       // Intent intent = new Intent(getActivity(), Camera.class);
        //getActivity().startActivity(intent);
    }
    public void deletePicture()
    {

    }
}
