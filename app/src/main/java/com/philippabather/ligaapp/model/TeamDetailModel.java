package com.philippabather.ligaapp.model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.philippabather.ligaapp.api.LaLigaApi;
import com.philippabather.ligaapp.api.LaLigaApiInterface;
import com.philippabather.ligaapp.contract.TeamDetailContract;
import com.philippabather.ligaapp.domain.Team;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamDetailModel implements TeamDetailContract.Model {

    private final LaLigaApiInterface api;

    public TeamDetailModel() {
        this.api = LaLigaApi.buildInstance();
    }

    @Override
    public void loadTeam(OnLoadTeamListener listener, long id) {
        Call<Team> callTeam = api.getTeamById(id);

        callTeam.enqueue(new Callback<Team>() {
            @Override
            public void onResponse(@NonNull Call<Team> call, @NonNull Response<Team> response) {
                Team team = response.body();
                listener.onLoadTeamSuccess(team);
            }

            @Override
            public void onFailure(@NonNull Call<Team> call, @NonNull Throwable t) {
                Log.e("teamDetail", Objects.requireNonNull(t.getMessage()));
                listener.onLoadTeamError(t.getMessage());
            }
        });
    }
}
