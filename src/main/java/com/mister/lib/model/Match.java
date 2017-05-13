package com.mister.lib.model;

import com.mister.lib.helpers.Randomizer;
import com.mister.lib.model.enums.Module;
import com.mister.lib.model.generic.GameModel;

import java.util.ArrayList;
import java.util.List;

public class Match extends GameModel {
    private final Team home;
    private final Team away;
    private boolean simulated = false;
    private int goalHome = 0;
    private int goalAway = 0;

    private MatchResult result = null;

    public Match(Team home, Team away) {
        this.home = home;
        this.away = away;
    }

    public boolean wasPlayed() {
        return simulated;
    }

    public MatchResult simulate() {
        if (simulated) {
            return result;
        }

        int homePoints = home.getAvgSkill();
        int awayPoints = away.getAvgSkill();
        homePoints += this.malusModule(
                home.getCoach().getModule().teamCanPlay(home)
        );
        awayPoints += this.malusModule(
                away.getCoach().getModule().teamCanPlay(away)
        );
        if (Randomizer.chance(80)) {
            if ((homePoints - awayPoints) < 0) {
                goalAway = (awayPoints - homePoints) % 6;
                goalHome += fluke();
                goalAway += fluke();
                goalHome += bonusHome();
            } else {
                goalHome = (homePoints - awayPoints) % 6;
                goalAway += fluke();
                goalHome += bonusHome();
            }
        } else {
            goalHome += fluke();
            goalAway += fluke();
            goalHome += bonusHome();
        }
        goalHome += bonusAge(home.getAvgAge());
        goalAway += bonusAge(away.getAvgAge());

        Module homeModule = home.getCoach().getModule();
        Module awayModule = away.getCoach().getModule();
        if (homeModule.isOffensive()) {
            goalHome += Randomizer.chance(50) ? Randomizer.intVal(1, 2) : 0;
            goalAway += Randomizer.chance(20) ? 1 : 0;
        }
        if (awayModule.isOffensive()) {
            goalAway += Randomizer.chance(50) ? Randomizer.intVal(1, 2) : 0;
            goalHome += Randomizer.chance(20) ? 1 : 0;
        }
        if (awayModule.isDefensive()) {
            goalHome -= Randomizer.chance(50) ? 1 : 0;
        }
        if (homeModule.isDefensive()) {
            goalAway -= Randomizer.chance(50) ? 1 : 0;
        }
        goalHome = goalHome < 0 ? 0 : goalHome;
        goalAway = goalAway < 0 ? 0 : goalAway;
        simulated = true;
        result = new MatchResult(goalHome, goalAway, home, away, getScorersHome(), getScorersAway());
        return result;
    }

    private int malusModule(boolean teamCanPlay) {
        if (teamCanPlay) {
            return Randomizer.intVal(1, 10);
        }
        return (-1) * Randomizer.intVal(1, 10);
    }

    private int bonusAge(int avgAge) {
        if (avgAge < 24 || avgAge > 39) {
            return fluke();
        }
        return 0;
    }

    private int bonusHome() {
        return Randomizer.chance(66) ? 1 : 0;
    }

    List<Player> getScorersHome() {
        List<Player> possibleScorers = home.getPossibleScorers();
        return getScorersFromArray(goalHome, possibleScorers);
    }

    List<Player> getScorersAway() {
        List<Player> possibleScorers = away.getPossibleScorers();
        return getScorersFromArray(goalAway, possibleScorers);
    }

    private List<Player> getScorersFromArray(int goals, List<Player> possibleScorers) {
        List<Player> scorers = new ArrayList<>();
        for (int i = 0; i < goals; i++) {
            if (Randomizer.chance(70)) {
                scorers.add(possibleScorers.get(Randomizer.intVal(0, 3)));
            } else {
                scorers.add(possibleScorers.get(Randomizer.intVal(0, possibleScorers.size() - 1)));
            }
        }
        return scorers;
    }

    private int fluke() {
        return Randomizer.intVal(0, 3);
    }

    public MatchResult getResult() {
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", home.getName(), away.getName());
    }

    public Team getAwayTeam() {
        return away;
    }

    public Team getHomeTeam() {
        return home;
    }
}
