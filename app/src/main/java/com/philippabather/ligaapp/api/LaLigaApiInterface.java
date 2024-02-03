package com.philippabather.ligaapp.api;

import com.philippabather.ligaapp.domain.NewStadiumDTO;
import com.philippabather.ligaapp.domain.Stadium;
import com.philippabather.ligaapp.domain.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LaLigaApiInterface {

    @Headers({"Accept: application/json"})
    @GET("/stadiums")
    Call<List<Stadium>> getStadiums();

    @Headers({"Accept: application/json"})
    @POST("/stadiums")
    Call<Stadium> addStadium(@Body NewStadiumDTO stadium);

    @Headers({"Accept: application/json"})
    @GET("/teams")
    Call<List<Team>> getTeams();

    @Headers({"Accept: application/json"})
    @GET("/team/{id}")
    Call<Team> getTeamById(@Path(value = "id") long id);

    @Headers({"Accept: application/json"})
    @PUT("/team/{id}")
    Call<Team> updateTeamById(@Path(value = "id") long id, @Body Team team);

    @Headers({"Accept: application/json"})
    @DELETE("team/{id}")
    Call<Void> deleteTeamById(@Path(value = "id") long id);

}
