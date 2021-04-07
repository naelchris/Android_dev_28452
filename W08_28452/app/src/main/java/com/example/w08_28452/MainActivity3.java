package com.example.w08_28452;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.w08_28452.MainActivity;

public class MainActivity3 extends AppCompatActivity {

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn1 = (Button) findViewById(R.id.btnTutorial1);
        btn2 = (Button) findViewById(R.id.btnTutorial2);
        Intent intentTutorial1 = new Intent(this, MainActivity.class);
        Intent intentTutorial2 = new Intent(this, MainActivity2.class);

        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(intentTutorial1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(intentTutorial2);
            }
        });
    }
}