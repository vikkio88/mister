package com.mister.lib.model;


import com.mister.lib.model.generic.GameModel;

import java.util.List;

public class League extends GameModel {

    private final String name;
    private final List<Team> teams;
    private final List<Round> rounds;

    public League(String name, List<Team> teams, List<Round> rounds) {
        this.name = name;
        this.teams = teams;
        this.rounds = rounds;
    }

}
