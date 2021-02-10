package com.example.w02_28452;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText angka1, angka2;
    TextView hasil;
    Button btnTambah, btnKurang, btnBagi, btnKali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angka1 = this.findViewById(R.id.edtTxt1);
        angka2 = this.findViewById(R.id.edtTxt2);
        hasil = this.findViewById(R.id.txtHasil);
        btnTambah = this.findViewById(R.id.btnTambah);
        btnKali = this.findViewById(R.id.btnKali);
        btnKurang = this.findViewById(R.id.btnKurang);
        btnBagi = this.findViewById(R.id.btnBagi);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('+');
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('-');
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('/');
            }
        });


        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('*');
            }
        });


    }

    protected void hitung(char operator){
        double operand1 = Double.parseDouble(angka1.getText().toString());
        double operand2 = Double.parseDouble(angka2.getText().toString());
        double result = 0.0;

        switch(operator){
            case('+'): result = operand1 + operand2;break;
            case('-'): result = operand1 - operand2;break;
            case('*'): result = operand1 * operand2; break;
            case('/'): result = operand1 / operand2;break;
        }
        hasil.setText("Hasil : "+String.valueOf(result));
    }
}