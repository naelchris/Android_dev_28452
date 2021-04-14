package com.example.w09_28452;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetilActivity extends AppCompatActivity {
    private EditText etNim, etNama, etEmail, etNomorHP;
    private Button btnSimpan, btnBatal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil);
        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);
        etEmail = findViewById(R.id.etEmail);
        etNomorHP = findViewById(R.id.etNomorHp);

        btnSimpan = findViewById(R.id.button2);
        btnBatal = findViewById(R.id.button);

        Intent intent = getIntent();
        if(intent.hasExtra("MAHASISWA")) {
            Mahasiswa mhs = (Mahasiswa)
                    intent.getSerializableExtra("MAHASISWA");
            etNim.setText(mhs.getNim());
            etNama.setText(mhs.getNama());
            etEmail.setText(mhs.getEmail());
            etNomorHP.setText(mhs.getNomorhp());
            etNim.setEnabled(false);
        } else {
            etNim.setEnabled(true);
        }

//        btnSimpan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"test",
//                        Toast.LENGTH_LONG).show();
//            }
//        });
    }
    public void simpanData(View view){
        String mNIM = etNim.getText().toString();
        String mNama = etNama.getText().toString();
        String mEmail = etEmail.getText().toString();
        String mNoHp = etNomorHP.getText().toString();
        if(mNIM.length() <= 0 || mNama.length() <= 0 ||
                mEmail.length() <= 0 || mNoHp.length() <= 0){
            Toast.makeText(this,"Semua harus Diisi",
                    Toast.LENGTH_LONG).show();
        } else {
            Intent intentJawab = new Intent();
            Mahasiswa mhs = new Mahasiswa(mNIM, mNama, mEmail, mNoHp);
            Toast.makeText(this,"Test",
                    Toast.LENGTH_LONG).show();
            intentJawab.putExtra("MAHASISWA",mhs);
            setResult(RESULT_OK,intentJawab);
            finish();
        }
    }
    public void batal(View view){
        Intent intentJawab = new Intent();
        setResult(RESULT_CANCELED,intentJawab);
        Log.d("testing","batal");
        finish();
    }
}