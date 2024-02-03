package com.philippabather.ligaapp.model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.philippabather.ligaapp.api.LaLigaApi;
import com.philippabather.ligaapp.api.LaLigaApiInterface;
import com.philippabather.ligaapp.contract.TeamsContract;
import com.philippabather.ligaapp.domain.Team;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsModel implements TeamsContract.Model {

    private final LaLigaApiInterface api;

    public TeamsModel() {
        this.api = LaLigaApi.buildInstance();
    }

    @Override
    public void loadTeams(OnLoadTeamsListener listener) {
        Call<List<Team>> callTeamList = api.getTeams();

        callTeamList.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(@NonNull Call<List<Team>> call, @NonNull Response<List<Team>> response) {
                List<Team> teamsList = response.body();
                listener.onLoadTeamsSuccess(teamsList);
            }

            @Override
            public void onFailure(@NonNull Call<List<Team>> call, @NonNull Throwable t) {
                Log.e("getTeams", Objects.requireNonNull(t.getMessage()));
                listener.onLoadTeamsError("Error getting teams data.");
            }
        });
    }
}
