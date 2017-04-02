package com.mister.lib.model;

import java.util.List;

public class MatchResult {
    private final int goalHome;
    private final int goalAway;
    private final List<Player> scorersHome;
    private final List<Player> scorersAway;

    public MatchResult(int goalHome, int goalAway, List<Player> scorersHome, List<Player> scorersAway) {
        this.goalHome = goalHome;
        this.goalAway = goalAway;
        this.scorersHome = scorersHome;
        this.scorersAway = scorersAway;
    }

    public int getGoalHome() {
        return goalHome;
    }

    public int getGoalAway() {
        return goalAway;
    }
}
