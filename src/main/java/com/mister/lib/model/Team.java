package com.mister.lib.model;

import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.enums.Position;
import com.mister.lib.model.generic.Person;

import java.util.ArrayList;
import java.util.HashMap;

public class Team {
    private String name;
    private ArrayList<Player> roster;
    private Integer finance;
    private Coach coach;
    private Integer avgSkill = null;
    private HashMap<Position, Integer> playersPerRole;

    public Team(String name, Coach coach) {
        this.name = name;
        this.coach = coach;
        roster = new ArrayList<Player>();
        finance = null;
    }

    public Team(String name) {
        this.name = name;
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

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Integer getAvgSkill() {
        if (avgSkill == null) {
            int sum = getRoster().stream().mapToInt(Person::getSkill).sum();
            avgSkill = sum / (getRoster().size());
        }
        return avgSkill;
    }

    public HashMap<Position, Integer> getPlayersPerRole() {
        if (playersPerRole == null) {
            playersPerRole = calculatePlayersPerRole();
        }
        return playersPerRole;
    }

    private HashMap<Position, Integer> calculatePlayersPerRole() {
        HashMap<Position, Integer> playersPerRole = Position.getEmptyRolesHash();

        for (Player player : getRoster()) {
            Integer count = playersPerRole.get(player.getPosition());
            count++;
            playersPerRole.put(player.getPosition(), count);
        }
        return playersPerRole;
    }
}
