package com.mister.lib.model;

import com.mister.lib.helpers.RandomFiller;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> roster;
    private Integer finance;

    public Team(String name) {
        this.name = name;
        roster = new ArrayList<Player>();
        finance = null;
    }

    public String getName() {
        return name;
    }

    public int getPlayersNumber() {
        return roster.size();
    }

    public int getFinance() {
        if (finance == null) {
            finance = RandomFiller.finance();
        }
        return finance;
    }

    public void setRoster(ArrayList<Player> roster) {
        this.roster = roster;
    }
}
