package com.mister.lib.model;

import com.mister.lib.helpers.RandomFiller;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> roster;
    private Integer finance;
    private Coach coach;

    public Team(String name, Coach coach) {
        this.name = name;
        this.coach = coach;
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

    public ArrayList<Player> getRoster() {
        return roster;
    }

    public Coach getCoach() {
        return coach;
    }
}
