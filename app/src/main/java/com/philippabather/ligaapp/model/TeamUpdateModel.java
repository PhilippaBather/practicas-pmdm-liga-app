package com.philippabather.ligaapp.model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.philippabather.ligaapp.api.LaLigaApi;
import com.philippabather.ligaapp.api.LaLigaApiInterface;
import com.philippabather.ligaapp.contract.TeamsUpdateContract;
import com.philippabather.ligaapp.domain.Team;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamUpdateModel implements TeamsUpdateContract.Model {

    private final LaLigaApiInterface api;

    public TeamUpdateModel() {
        this.api = LaLigaApi.buildInstance();
    }

    @Override
    public void updateTeamById(OnUpdateTeamListener updateTeamListener, long id, Team team) {
        Call<Team> callTeam = api.updateTeamById(id, team);

        callTeam.enqueue(new Callback<Team>() {
            @Override
            public void onResponse(@NonNull Call<Team> call, @NonNull Response<Team> response) {
                Team team = response.body();
                updateTeamListener.onUpdateTeamSuccess(team);
            }

            @Override
            public void onFailure(@NonNull Call<Team> call, @NonNull Throwable t) {
                Log.e("updateTeam", Objects.requireNonNull(t.getMessage()));
                updateTeamListener.onUpdateTeamError(t.getMessage());
            }
        });

    }

    @Override
    public void deleteTeamById(OnDeleteTeamListener deleteTeamListener, long id) {
        Call<Void> call = api.deleteTeamById(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                deleteTeamListener.onDeleteTeamSuccess();
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                Log.e("deleteTeam", Objects.requireNonNull(t.getMessage()));
                deleteTeamListener.onDeleteTeamError("Error connecting to the server.");
            }
        });
    }
}
