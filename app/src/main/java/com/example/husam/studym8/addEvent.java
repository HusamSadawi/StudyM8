package com.example.husam.studym8;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;




public class addEvent extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addevent);
    }

    public void Done (View button)
    {
        finish();
    }


}
