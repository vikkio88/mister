package com.mister.lib.model;


import com.mister.lib.model.generic.GameModel;

import java.util.HashMap;
import java.util.List;

public class League extends GameModel {

    private String name;
    private HashMap<Team, Integer> table;
    private List<Round> rounds;

    private int lastRoundPointer = -1;

    public League(String name, List<Team> teams, List<Round> rounds) {
        this.name = name;
        table = new HashMap<>();
        teams.forEach(t -> table.put(t, 0));
        this.rounds = rounds;
    }

    public int getLastRoundPointer() {
        return lastRoundPointer;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public Round getLastRound() {
        if (lastRoundPointer >= 0) {
            return rounds.get(lastRoundPointer);
        }
        return null;
    }

    public Round getNextRound() {
        if (lastRoundPointer + 1 < rounds.size()) {
            return rounds.get(lastRoundPointer + 1);
        }
        return null;
    }

    public List<MatchResult> simulateNextRound() {
        Round nextRound = getNextRound();
        if (nextRound != null) {
            lastRoundPointer++;
            nextRound.simulate();
            calculateResults();
            return nextRound.getResults();
        }
        return null;
    }

    private void calculateResults() {
        Round round = getLastRound();
        round.getMatches().forEach(m -> {
            Team winner = m.getHomeTeam();
            Team loser = m.getAwayTeam();
            int winnerPoints = 3, loserPoints = 0;
            if (m.getResult().isDraw()) {
                winnerPoints = loserPoints = 1;
            } else {
                winner = m.getResult().getWinner();
                loser = m.getResult().getLoser();
            }
            table.put(winner, table.get(winner) + winnerPoints);
            table.put(loser, table.get(loser) + loserPoints);
        });
    }

    private int getTotalRounds() {
        return rounds.size();
    }

    public boolean hasMatchLeft() {
        return lastRoundPointer < getTotalRounds() - 1;
    }

    public HashMap<Team, Integer> getTable() {
        return table;
    }
}
