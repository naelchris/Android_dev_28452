package com.example.week06_28452.tutorialDrawable;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.week06_28452.R;

public class drawableActivityKuda extends AppCompatActivity {
    AnimationDrawable animasiKuda;
    ImageView gambarkuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_kuda);
        this.setTitle("Tutorial Drawable Kuda");

        gambarkuda = findViewById(R.id.gambarKuda);
        gambarkuda.setBackgroundResource(R.drawable.kuda_lari);
//        gambarkuda.setImageResource(R.drawable.kuda_lari);
        animasiKuda = (AnimationDrawable) gambarkuda.getBackground();

        gambarkuda.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                animasiKuda.start();
            }
        });


    }
}