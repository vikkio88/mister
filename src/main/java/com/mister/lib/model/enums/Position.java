package com.mister.lib.model.enums;

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
}
