package com.mister.lib.model;

import com.mister.lib.model.enums.Nationality;
import com.mister.lib.model.enums.Position;

public class Player {

    private static final int SKILL_MAX = 100;
    private static final int SKILL_MIN = 30;
    private Position position;
    private String name;
    private String surname;
    private int age;
    private int skill;
    private Nationality nationality;

    public Player(String name, String surname, int age, Nationality nationality, Position position) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nationality = nationality;
        this.position = position;
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

    public int getAge() {
        return age;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public Position getPosition() {
        return position;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = (skill < SKILL_MIN) ? SKILL_MIN : skill;
        this.skill = (skill > SKILL_MAX) ? SKILL_MAX : this.skill;
    }
}
