package com.example.w04_28452;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etIsian, etUrl;
    private Button btnKirim, btnBrowse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIsian = findViewById(R.id.isian);
        etUrl = findViewById(R.id.url);
        btnBrowse = findViewById(R.id.buttonBrowse);

        //browse btn to open webpage (default :umn.ac.id) -> implicit intent !
        btnBrowse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String urlText = etUrl.getText().toString();
                if(urlText.isEmpty()){
                    urlText = "http://www.umn.ac.id";
                }
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(urlText));
                if(browserIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(browserIntent);
                }

            }
        });

    }
}