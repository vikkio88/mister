package com.mister.lib.model;

import java.util.List;

public class Match {
    private final Team home;
    private final Team away;
    private boolean simulated = false;
    private int goalHome = 0;
    private int goalAway = 0;

    public Match(Team home, Team away) {
        this.home = home;
        this.away = away;
    }

    public boolean wasPlayed() {
        return simulated;
    }

    public MatchResult simulate() {
        simulated = true;
        return new MatchResult(goalHome, goalAway, getScorersHome(), getScorersAway());
    }

    List<Player> getScorersHome() {
        List<Player> possibleScorers = home.getPossibleScorers();
        return possibleScorers;
    }

    List<Player> getScorersAway() {
        List<Player> possibleScorers = away.getPossibleScorers();
        return possibleScorers;
    }
}
