package com.eddelacruz.mvp_rest_example.Services;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    public static final String BASE_URL = "https://data.cityofnewyork.us/resource/s3k6-pzi2.json";

    @GET(".")
    Call<JsonArray> getSchools(@Query("specialized") String specialized);
}