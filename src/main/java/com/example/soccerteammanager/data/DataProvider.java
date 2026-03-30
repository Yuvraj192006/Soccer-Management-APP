package com.example.soccerteammanager.data;

import com.example.soccerteammanager.model.Match;
import com.example.soccerteammanager.model.Player;
import com.example.soccerteammanager.model.Team;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("FC Barcelona", "Spain", "La Liga", "Camp Nou", 1899));
        teams.add(new Team("Manchester United", "England", "Premier League", "Old Trafford", 1878));
        teams.add(new Team("FC Barcelona", "Spain", "La Liga", "Camp Nou", 1899));
        teams.add(new Team("Real Madrid", "Spain", "La Liga", "Santiago Bernabeu", 1902));
        teams.add(new Team("Bayern Munich", "Germany", "Bundesliga", "Allianz Arena", 1900));
        teams.add(new Team("Paris Saint-Germain", "France", "Ligue 1", "Parc des Princes", 1970));
        teams.add(new Team("Liverpool", "England", "Premier League", "Anfield", 1892));
        teams.add(new Team("Manchester City", "England", "Premier League", "Etihad Stadium", 1880));
        teams.add(new Team("Juventus", "Italy", "Serie A", "Allianz Stadium", 1897));
        teams.add(new Team("Chelsea", "England", "Premier League", "Stamford Bridge", 1905));
        return teams;
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Lionel Messi", 34, "Argentina", "Forward", "FC Barcelona", 10));
        players.add(new Player("Cristiano Ronaldo", 36, "Portugal", "Forward", "Manchester United", 7));
        players.add(new Player("Neymar Jr", 29, "Brazil", "Forward", "Paris Saint-Germain", 11));
        players.add(new Player("Kylian Mbappe", 22, "France", "Forward", "Paris Saint-Germain", 7));
        players.add(new Player("Kevin De Bruyne", 30, "Belgium", "Midfielder", "Manchester City", 17));
        players.add(new Player("Robert Lewandowski", 33, "Poland", "Forward", "Bayern Munich", 9));
        players.add(new Player("Virgil van Dijk", 30, "Netherlands", "Defender", "Liverpool", 4));
        players.add(new Player("Luka Modric", 36, "Croatia", "Midfielder", "Real Madrid", 10));
        players.add(new Player("Erling Haaland", 21, "Norway", "Forward", "Borussia Dortmund", 9));
        return players;
    }

    public List<Match> getMatches() {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("FC Barcelona", "Real Madrid", "2-1", "La Liga", "2023-04-10", "Camp Nou"));
        matches.add(new Match("Manchester United", "Liverpool", "1-1", "Premier League", "2023-03-05", "Old Trafford"));
        matches.add(new Match("Bayern Munich", "Borussia Dortmund", "3-2", "Bundesliga", "2023-03-18", "Allianz Arena"));
        matches.add(new Match("Paris Saint-Germain", "Lyon", "2-0", "Ligue 1", "2023-03-12", "Parc des Princes"));
        matches.add(new Match("Chelsea", "Arsenal", "0-2", "Premier League", "2023-03-20", "Stamford Bridge"));
        matches.add(new Match("Juventus", "AC Milan", "1-0", "Serie A", "2023-03-25", "Allianz Stadium"));
        matches.add(new Match("Manchester City", "Tottenham", "4-1", "Premier League", "2023-04-02", "Etihad Stadium"));
        matches.add(new Match("Real Madrid", "Atletico Madrid", "2-2", "La Liga", "2023-04-01", "Santiago Bernabeu"));
        return matches;
    }
}
