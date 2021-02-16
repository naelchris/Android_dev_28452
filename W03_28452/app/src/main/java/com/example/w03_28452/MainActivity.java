package com.example.w03_28452;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mDaftarKata = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private DaftarKataAdapter mAdapter;

    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menambahkan data linkedlist
        for(int i = 1; i < 21;i++){
            mDaftarKata.add("kata "+ i);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new DaftarKataAdapter(this,mDaftarKata);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int jumlahKata = mDaftarKata.size();
                mDaftarKata.addLast("kata " + (jumlahKata+1) + " telah ditambahkan");
                Objects.requireNonNull(mRecyclerView.getAdapter()).notifyItemInserted(jumlahKata);
                mRecyclerView.smoothScrollToPosition(jumlahKata);
            }
        });
    }//end onCreate()
}