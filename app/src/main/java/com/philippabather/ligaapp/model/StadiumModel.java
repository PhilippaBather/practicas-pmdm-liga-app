package com.philippabather.ligaapp.model;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.philippabather.ligaapp.api.LaLigaApi;
import com.philippabather.ligaapp.api.LaLigaApiInterface;
import com.philippabather.ligaapp.contract.StadiumsContract;
import com.philippabather.ligaapp.domain.Stadium;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StadiumModel implements StadiumsContract.Model {
    private final LaLigaApiInterface api;

    public StadiumModel() {
        this.api = LaLigaApi.buildInstance();
    }

    @Override
    public void loadStadiums(OnLoadStadiumsListener listener) {
        Call<List<Stadium>> callStadiums = api.getStadiums();

        callStadiums.enqueue(new Callback<List<Stadium>>() {
            @Override
            public void onResponse(@NonNull Call<List<Stadium>> call, @NonNull Response<List<Stadium>> response) {
                List<Stadium> stadiums = response.body();
                listener.onLoadStadiumsSuccess(stadiums);
            }

            @Override
            public void onFailure(@NonNull Call<List<Stadium>> call, @NonNull Throwable t) {
                Log.e("getStadiums", Objects.requireNonNull(t.getMessage()));
                listener.onLoadStadiumsError("Error loading stadium data.");
            }
        });
    }
}
