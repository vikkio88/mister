package com.mister.lib.model;

import java.util.List;

public class MatchResult {
    private final int goalHome;
    private final int goalAway;
    private final String homeTeam;
    private final String awayTeam;
    private final List<Player> scorersHome;
    private final List<Player> scorersAway;

    public MatchResult(int goalHome, int goalAway, String homeTeam, String awayTeam, List<Player> scorersHome, List<Player> scorersAway) {
        this.goalHome = goalHome;
        this.goalAway = goalAway;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.scorersHome = scorersHome;
        this.scorersAway = scorersAway;
    }

    public int getGoalHome() {
        return goalHome;
    }

    public int getGoalAway() {
        return goalAway;
    }

    @Override
    public String toString() {
        return String.format("%s %d - %d %s", homeTeam, goalHome, goalAway, awayTeam);
    }

    public List<Player> getScorersHome() {
        return scorersHome;
    }

    public List<Player> getScorersAway() {
        return scorersAway;
    }
}
