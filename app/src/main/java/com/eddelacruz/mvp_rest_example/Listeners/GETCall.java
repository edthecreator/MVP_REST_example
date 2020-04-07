package com.eddelacruz.mvp_rest_example.Listeners;

import com.eddelacruz.mvp_rest_example.Models.School_Item;
import com.eddelacruz.mvp_rest_example.Services.Service;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GETCall implements PVContract.GetSchoolInteractor {

    @Override
    public void getSchoolList(final OnFinishedListener onFinishedListener) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://data.cityofnewyork.us/resource/s3k6-pzi2.json/").callbackExecutor(Executors.newSingleThreadExecutor()).addConverterFactory(GsonConverterFactory.create()).build();
        Service service = retrofit.create(Service.class);
        Call<JsonArray> jsonCall = service.getSchools("1");

        jsonCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                String jsonString = response.body().toString();
                Type listType = new TypeToken<List<School_Item>>() {}.getType();
                List<School_Item> yourList = new Gson().fromJson(jsonString, listType);
                onFinishedListener.onFinished(yourList);

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}
