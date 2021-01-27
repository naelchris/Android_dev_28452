package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

//learning to import material -> 1. update the build gradle module 2. import correspon with the name of the module
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.radiobutton.MaterialRadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}