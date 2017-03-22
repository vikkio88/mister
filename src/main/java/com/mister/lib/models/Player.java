package com.mister.lib.models;

import com.mister.lib.models.enums.Nationality;

public class Player {

    private String name;
    private String surname;
    private int age;
    private Nationality nationality;

    public Player(String name, String surname, int age, Nationality nationality) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Nationality getNationality() {
        return nationality;
    }
}
