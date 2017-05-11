package com.mister.lib.model;


import com.mister.lib.model.generic.GameModel;

import java.awt.geom.RoundRectangle2D;
import java.util.List;

public class League extends GameModel {

    private String name;
    private List<Team> teams;
    private List<Round> rounds;

    private int lastRoundPointer = -1;

    public League(String name, List<Team> teams, List<Round> rounds) {
        this.name = name;
        this.teams = teams;
        this.rounds = rounds;
    }

    public int getLastRoundPointer() {
        return lastRoundPointer;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public Round getLastRound() {
        if (lastRoundPointer > 0) {
            return rounds.get(lastRoundPointer - 1);
        }
        return null;
    }

    public Round getNextRound() {
        if (lastRoundPointer < rounds.size()) {
            return rounds.get(lastRoundPointer + 1);
        }
        return null;
    }

    public List<MatchResult> simulateNextRound() {
        Round next = getNextRound();
        if (next != null) {
            lastRoundPointer++;
            return next.simulate();
        }
        return null;
    }

    private int getTotalRounds() {
        return rounds.size();
    }

    public boolean hasMatchLeft() {
        return lastRoundPointer < getTotalRounds() - 1;
    }
}
