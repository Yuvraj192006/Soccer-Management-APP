package com.example.soccerteammanager.model;

public class Player implements SoccerEntity {
    private String name, nationality, position, team;
    private int age, number;

    public Player(String name, int age, String nationality,
                  String position, String team, int number) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.position = position;
        this.team = team;
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPosition() { return position; }
    public String getTeam() { return team; }
}
