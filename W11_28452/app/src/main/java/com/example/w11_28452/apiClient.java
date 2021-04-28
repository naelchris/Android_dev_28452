package com.example.w11_28452;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiClient {
    private static String BASE_URL= "http://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit  = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
