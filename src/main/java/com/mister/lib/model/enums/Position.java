package com.mister.lib.model.enums;

import java.util.HashMap;

public enum Position {
    GK("GK", "Goalkeeper"),
    D("D", "Defender"),
    LD("LD", "Left Defender"),
    RD("RD", "Right Defender"),
    M("CM", "Midfielder"),
    RM("RM", "Right Midfielder"),
    LM("LM", "Left Midfielder"),
    S("S", "Striker"),
    RS("RS", "Right Striker"),
    LS("LS", "Left Striker");

    private String shortName;
    private String definition;

    Position(String shortName, String definition) {
        this.shortName = shortName;
        this.definition = definition;
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
}
