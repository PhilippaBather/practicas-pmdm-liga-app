package com.philippabather.ligaapp.api;

import com.philippabather.ligaapp.domain.Stadium;
import com.philippabather.ligaapp.domain.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface LaLigaApiInterface {

    @Headers({"Accept: application/json"})
    @GET("/stadiums")
    Call<List<Stadium>> getStadiums();

    @Headers({"Accept: application/json"})
    @GET("/teams")
    Call<List<Team>> getTeams();

    @Headers({"Accept: application/json"})
    @GET("/team/{id}")
    Call<Team> getTeamById(@Path(value = "id") long id);



}
