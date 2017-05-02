package com.mister.lib.model;


import com.mister.lib.model.generic.GameModel;

import java.util.List;

public class League extends GameModel {

    private String name;
    private List<Team> teams;
    private List<Round> rounds;
    private int currentRoundPointer = 0;

    public League(String name, List<Team> teams, List<Round> rounds) {
        this.name = name;
        this.teams = teams;
        this.rounds = rounds;
    }

    public int getCurrentRound() {
        return currentRoundPointer + 1;
    }

    public int getTotalRounds() {
        return rounds.size();
    }

}
