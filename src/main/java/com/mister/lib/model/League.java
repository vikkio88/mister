package com.mister.lib.model;


import com.mister.lib.model.generic.GameModel;

import java.util.List;

public class League extends GameModel {

    private String name;
    private List<Team> teams;
    private List<Round> rounds;
    private int lastRoundPointer = 0;

    public League(String name, List<Team> teams, List<Round> rounds) {
        this.name = name;
        this.teams = teams;
        this.rounds = rounds;
    }

    public Round getNextRound() {
        if (lastRoundPointer < getTotalRounds() - 1) {
            lastRoundPointer++;
            return rounds.get(lastRoundPointer);
        }
        return rounds.get(lastRoundPointer);
    }

    private int getTotalRounds() {
        return rounds.size();
    }

    public boolean hasMatchLeft() {
        return lastRoundPointer < getTotalRounds() - 1;
    }
}
