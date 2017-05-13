package com.mister.lib.model;


import com.mister.lib.model.generic.GameModel;

import java.util.ArrayList;
import java.util.List;

public class Round extends GameModel {
    private List<Match> matches;
    private boolean simulated = false;
    private int matchDay;

    private List<MatchResult> results;

    public Round(int matchDay) {
        this.matchDay = matchDay;
        matches = new ArrayList<>();
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public List<MatchResult> simulate() {
        results = new ArrayList<>();
        matches.forEach(match -> results.add(match.simulate()));
        simulated = true;
        return results;
    }

    public List<MatchResult> getResults() {
        if (simulated) {
            return results;
        }
        return null;
    }

    public boolean wasPlayed() {
        return simulated;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public int getMatchDay() {
        return matchDay;
    }
}
