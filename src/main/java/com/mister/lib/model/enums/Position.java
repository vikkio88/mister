package com.mister.lib.model.enums;

import java.util.HashMap;

public enum Position {
    GK("GK", "Goalkeeper", 1),
    D("D", "Defender", 2),
    LD("LD", "Left Defender", 3),
    RD("RD", "Right Defender", 4),
    M("CM", "Midfielder", 5),
    RM("RM", "Right Midfielder", 6),
    LM("LM", "Left Midfielder", 7),
    S("S", "Striker", 10),
    RS("RS", "Right Striker", 9),
    LS("LS", "Left Striker", 8);

    private String shortName;
    private String definition;
    private int weight;

    Position(String shortName, String definition, int weight) {
        this.shortName = shortName;
        this.definition = definition;
        this.weight = weight;
    }

    public String getShortName() {
        return shortName;
    }

    public String getDefinition() {
        return definition;
    }

    public static HashMap<Position, Integer> getEmptyRolesHash() {
        HashMap<Position, Integer> roles = new HashMap<>();
        for (Position position : Position.values()) {
            roles.put(position, 0);
        }
        return roles;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return definition;
    }
}
