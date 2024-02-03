package com.philippabather.ligaapp.domain;

public class Stadium {
    private long id;
    private String name;
    private String constructionDate;
    private Boolean adaptedAccess;
    private float latitude;
    private float longitude;
    private Team team;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConstructionDate() {
        return constructionDate;
    }

    public void setConstructionDate(String constructionDate) {
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
}
