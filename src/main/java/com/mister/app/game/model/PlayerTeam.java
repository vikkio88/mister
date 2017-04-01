package com.mister.app.game.model;

import com.mister.lib.helpers.Randomizer;
import com.mister.lib.model.Team;

public class PlayerTeam {
    private Team team;
    private int morale = 0;
    private int trust = 0;

    public PlayerTeam(Team team) {
        this.team = team;
        init();
    }

    private void init() {
        trust = Randomizer.intVal(10, 50);
        morale = Randomizer.intVal(20, 70);
    }

    public void applyDeltaToTrust(int delta) {
        trust += delta;
        if (trust < 0) trust = 0;
        if (trust > 100) trust = 100;
    }

    public void applyDeltaToMorale(int delta) {
        morale += delta;
        if (morale < 0) morale = 0;
        if (morale > 100) morale = 100;
    }

    public int getTrust() {
        return trust;
    }

    public int getMorale() {
        return morale;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
