package com.example.w11_28452;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvPostList;
    PostAdapter adapter;
    helper helper;

    ArrayList<PostModel> posts ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("test","hello world");
        rvPostList = findViewById(R.id.rvPostList);
        rvPostList.setLayoutManager(new LinearLayoutManager(this));

        helper = apiClient.getClient().create(helper.class);

        getData();

    }

    private void getData() {
        //activity call the webservice with the help of interface
        Call<ArrayList<PostModel>> postCallback = helper.getPosts();

        postCallback.enqueue(new Callback<ArrayList<PostModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PostModel>> call, Response<ArrayList<PostModel>> response) {
                //take the response and use it
                //when the application receive response 404, 403, 200, etc.
                posts = response.body();
                Log.d("post", String.valueOf(posts));
                adapter = new PostAdapter(posts);
                rvPostList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<PostModel>> call, Throwable t) {
                //when connectivity is offline (no internet services)
                Log.d("post", "failed to post");
                Toast.makeText(MainActivity.this, "Internet not available", Toast.LENGTH_SHORT).show();
            }
        });

    }
}