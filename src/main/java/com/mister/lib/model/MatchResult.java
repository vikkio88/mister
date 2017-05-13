package com.mister.lib.model;

import com.mister.lib.model.generic.GameModel;

import java.util.List;

public class MatchResult extends GameModel {
    private final int goalHome;
    private final int goalAway;
    private final Team homeTeam;
    private final Team awayTeam;
    private final List<Player> scorersHome;
    private final List<Player> scorersAway;

    public MatchResult(int goalHome, int goalAway, Team homeTeam, Team awayTeam, List<Player> scorersHome, List<Player> scorersAway) {
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
        return String.format("%s %d - %d %s", homeTeam.getName(), goalHome, goalAway, awayTeam.getName());
    }

    public List<Player> getScorersHome() {
        return scorersHome;
    }

    public List<Player> getScorersAway() {
        return scorersAway;
    }

    public boolean isDraw() {
        return goalHome == goalAway;
    }

    public Team getWinner() {
        if (!isDraw() && goalHome > goalAway) {
            return homeTeam;
        }
        return awayTeam;
    }

    public Team getLoser() {
        if (!isDraw() && goalHome > goalAway) {
            return awayTeam;
        }
        return homeTeam;
    }
}
