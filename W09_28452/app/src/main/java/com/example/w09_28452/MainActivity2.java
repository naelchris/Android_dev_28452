package com.example.w09_28452;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView rv;
    private MahasiswaViewModel mhsVM;
    private static final int REQUEST_TAMBAH = 1;
    private static final int REQUEST_EDIT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(MainActivity2.this,
                        DetilActivity.class);
                startActivityForResult(addIntent,REQUEST_TAMBAH);
            }
        });

        rv = (RecyclerView) findViewById(R.id.rvMahasiswa);
        final MahasiswaListAdapter adapter = new MahasiswaListAdapter(this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        mhsVM = ViewModelProviders.of(this).get(MahasiswaViewModel.class);
        mhsVM.getDaftarMahasiswa().observe(this,
                new Observer<List<Mahasiswa>>() {
                    @Override
                    public void onChanged(List<Mahasiswa> mhss) {
                        adapter.setDaftarMahasiswa(mhss);
                    }
        });
        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT |
                        ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView,
                                          @NonNull RecyclerView.ViewHolder viewHolder,
                                          @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }
                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder
                                                 viewHolder, int direction) {
                        int posisi = viewHolder.getAdapterPosition();
                        Mahasiswa mhs =
                                adapter.getMahasiswaAtPosition(posisi);
                        if(direction == ItemTouchHelper.LEFT){
                            Toast.makeText(MainActivity2.this,
                                    "Mahasiswa dengan NIM = "+mhs.getNim()+
                                            " dihapus",Toast.LENGTH_LONG).show();
                            mhsVM.delete(mhs);
                        }
                        else if(direction == ItemTouchHelper.RIGHT) {
                            Intent editIntet =
                                    new Intent(MainActivity2.this,
                                            DetilActivity.class);
                            editIntet.putExtra("MAHASISWA", mhs);
                            startActivityForResult(editIntet,
                                    REQUEST_EDIT);
                        }
                    }
                }
        );
        helper.attachToRecyclerView(rv);
    }

}