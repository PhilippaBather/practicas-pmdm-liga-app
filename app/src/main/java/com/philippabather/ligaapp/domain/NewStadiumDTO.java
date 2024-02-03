package com.philippabather.ligaapp.domain;

import java.time.LocalDate;

public class NewStadiumDTO {

    private String name;
    private LocalDate constructionDate;
    private Boolean adaptedAccess;
    private float latitude;
    private float longitude;
    private Long teamId;

    public NewStadiumDTO(String name, LocalDate constructionDate, Boolean adaptedAccess, float latitude, float longitude, Long teamId) {
        this.name = name;
        this.constructionDate = constructionDate;
        this.adaptedAccess = adaptedAccess;
        this.latitude = latitude;
        this.longitude = longitude;
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getConstructionDate() {
        return constructionDate;
    }

    public void setConstructionDate(LocalDate constructionDate) {
        this.constructionDate = constructionDate;
    }

    public Boolean getAdaptedAccess() {
        return adaptedAccess;
    }

    public void setAdaptedAccess(Boolean adaptedAccess) {
        this.adaptedAccess = adaptedAccess;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
