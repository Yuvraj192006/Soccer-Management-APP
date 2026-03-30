package com.example.soccerteammanager.model;

public class Team implements SoccerEntity {
    private String name, country, league, stadium;
    private int foundedYear;

    public Team(String name, String country, String league, String stadium, int foundedYear) {
        this.name = name;
        this.country = country;
        this.league = league;
        this.stadium = stadium;
        this.foundedYear = foundedYear;
    }

    @Override
    public String getName() {
        return name;
    }

    // getters
}
