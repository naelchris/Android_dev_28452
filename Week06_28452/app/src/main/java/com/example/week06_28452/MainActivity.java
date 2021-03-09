package com.example.week06_28452;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.week06_28452.tutorialFisika.tutorialFisika;
import com.example.week06_28452.tutorialProperti.tutorialPropertyActivity;
import com.example.week06_28452.tutorialDrawable.drawableActivityKuda;

public class MainActivity extends AppCompatActivity {

    Button btnTutorialProperti, btnTutorialDrawable, btnTutorialFisika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTutorialProperti = findViewById(R.id.btnTutorialProperti);
        btnTutorialDrawable = findViewById(R.id.btnTutorialDrawable);
        btnTutorialFisika = findViewById(R.id.btnTutorialFisika);

        btnTutorialProperti.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, tutorialPropertyActivity.class));
            }
        });

        btnTutorialDrawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,drawableActivityKuda.class));
            }
        });

        btnTutorialFisika.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, tutorialFisika.class));
            }
        });




    }
}