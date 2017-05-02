package com.mister.lib.model;


import com.mister.lib.model.generic.GameModel;

import java.util.ArrayList;
import java.util.List;

public class LeagueRound extends GameModel {
    private List<Match> matches;
    private boolean simulated = false;

    public LeagueRound(List<Match> matches) {
        this.matches = matches;
    }

    public List<MatchResult> simulate() {
        List<MatchResult> results = new ArrayList<>();
        matches.forEach(match -> results.add(match.simulate()));
        simulated = true;
        return results;
    }

    public boolean wasPlayed() {
        return simulated;
    }
}
