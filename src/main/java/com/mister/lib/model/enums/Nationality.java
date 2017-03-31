package com.mister.lib.model.enums;

public enum Nationality {
    IT("it", "Italy"),
    ES("es", "Spain"),
    FR("fr", "France"),
    EN("en", "England"),
    PT("pt", "Portugal"),
    DE("de", "Germany");

    private String nationCode;
    private String nationName;

    Nationality(String nationCode, String nationName) {
        this.nationCode = nationCode;
        this.nationName = nationName;
    }

    public String getNationName() {
        return nationName;
    }

    @Override
    public String toString() {
        return nationName;
    }

    public String getNationCode() {
        return nationCode;
    }
}
