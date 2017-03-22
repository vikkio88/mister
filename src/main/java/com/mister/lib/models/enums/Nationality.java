package com.mister.lib.models.enums;

public enum Nationality {
    IT("Italy"),
    ES("Spain"),
    EN("England"),
    BR("Brazil"),
    DE("Germany");

    private String nationName;

    Nationality(String nationName) {
        this.nationName = nationName;
    }

    public String getNationName() {
        return nationName;
    }
}
