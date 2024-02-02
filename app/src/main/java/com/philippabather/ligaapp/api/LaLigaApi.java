package com.philippabather.ligaapp.api;

import static com.philippabather.ligaapp.api.ApiConstants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LaLigaApi {

    public static LaLigaApiInterface buildInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(LaLigaApiInterface.class);
    }
}