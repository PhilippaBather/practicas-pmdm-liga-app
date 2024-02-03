package com.philippabather.ligaapp.domain;

public class Team {
    private long id;
    private String name;
    private String foundationDate;
    private Boolean areChampions;
    private int leaguePoints;

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

    public String getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(String foundationDate) {
        this.foundationDate = foundationDate;
    }

    public Boolean getAreChampions() {
        return areChampions;
    }

    public void setAreChampions(Boolean areChampions) {
        this.areChampions = areChampions;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foundationDate='" + foundationDate + '\'' +
                ", areChampions=" + areChampions +
                ", leaguePoints=" + leaguePoints +
                '}';
    }
}
