package com.example.w11_28452;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface helper {
    @GET("posts")
    Call <ArrayList<PostModel>> getPosts();
    //interface will take the gson and change it to object

}
