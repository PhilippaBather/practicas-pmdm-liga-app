package com.philippabather.ligaapp.model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.philippabather.ligaapp.api.LaLigaApi;
import com.philippabather.ligaapp.api.LaLigaApiInterface;
import com.philippabather.ligaapp.contract.AddStadiumContract;
import com.philippabather.ligaapp.domain.NewStadiumDTO;
import com.philippabather.ligaapp.domain.Stadium;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddStadiumModel implements AddStadiumContract.Model {

    private final LaLigaApiInterface api;

    public AddStadiumModel() {
        this.api = LaLigaApi.buildInstance();
    }

    @Override
    public void addStadium(OnAddStadiumListener onAddStadiumListener, NewStadiumDTO stadium) {
        Call<Stadium> callStadium = api.addStadium(stadium);

        callStadium.enqueue(new Callback<Stadium>() {
            @Override
            public void onResponse(@NonNull Call<Stadium> call, @NonNull Response<Stadium> response) {
                Stadium stadium = response.body();
                onAddStadiumListener.onAddStadiumSuccess(stadium);
            }

            @Override
            public void onFailure(@NonNull Call<Stadium> call, @NonNull Throwable t) {
                Log.e("addStadium", Objects.requireNonNull(t.getMessage()));
                onAddStadiumListener.onAddStadiumError(t.getMessage());
            }
        });

    }
}
