package com.example.testapiagain.api;

import com.example.testapiagain.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String url = "http://apilayer.net/";

    Gson gson = new GsonBuilder()
        .setDateFormat("yyyy-MM-dd HH:mm:ss")
        .create();

    ApiService apiService = new Retrofit.Builder()
        .baseUrl("http://apilayer.net/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ApiService.class);

    @GET("api/live")
    Call<User> convertUsdToVnd(
        @Query("access_key") String access_key,
        @Query("currencies") String currencies,
        @Query("source") String source,
        @Query("format") int format
    );
}
