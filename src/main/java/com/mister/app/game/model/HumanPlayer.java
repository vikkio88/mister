package com.mister.app.game.model;

import com.mister.lib.model.enums.Nationality;

public class HumanPlayer {
    private String name;
    private String surname;
    private Nationality nationality;

    public HumanPlayer(String name, String surname, Nationality nationality) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return String.format("%s %s", surname, name);
    }

    public Nationality getNationality() {
        return nationality;
    }
}
