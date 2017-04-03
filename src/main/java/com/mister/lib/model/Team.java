package com.mister.lib.model;

import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.comparators.PositionComparator;
import com.mister.lib.model.enums.Position;
import com.mister.lib.model.generic.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Team {
    public static final int FINANCE_MULTIPLIER = 1_000_000;
    private String name;
    private ArrayList<Player> roster;
    private Integer finance;
    private Coach coach;
    private Integer avgSkill = null;
    private Integer avgAge;
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

    public int getFinanceMillions() {
        return getFinance() / FINANCE_MULTIPLIER;
    }

    public String getFormattedFinance() {
        return String.format("%d m €", getFinanceMillions());
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

    public Integer getAvgAge() {
        if (avgAge == null) {
            int sum = getRoster().stream().mapToInt(Person::getAge).sum();
            avgAge = sum / (getRoster().size());
        }
        return avgAge;
    }

    public HashMap<Position, Integer> getPlayersPerRole() {
        if (playersPerRole == null) {
            playersPerRole = calculatePlayersPerRole();
        }
        return playersPerRole;
    }

    public String getPlayersPerRoleString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Position, Integer> rolesPlayer : getPlayersPerRole().entrySet()) {
            if (rolesPlayer.getValue() > 0) {
                stringBuilder.append(String.format(" %s:%d", rolesPlayer.getKey().getShortName(), rolesPlayer.getValue()));
            }
        }
        return stringBuilder.toString();
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

    public List<Player> getPossibleScorers() {
        List<Player> players = roster.stream().filter(player -> Position.GK != player.getPosition())
                .collect(Collectors.toList());
        players.sort((p, p1) -> Integer.compare(p1.getSkill(), p.getSkill()));
        Comparator<Player> comparator = Comparator.comparing(Player::getPosition, new PositionComparator());
        return players.stream().sorted(comparator).collect(Collectors.toList());
    }
}
