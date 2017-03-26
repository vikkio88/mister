package com.mister.lib.model;

import com.mister.lib.model.enums.Module;
import com.mister.lib.model.enums.Nationality;
import com.mister.lib.model.enums.Position;

public class Coach {

    private static final int SKILL_MAX = 100;
    private static final int SKILL_MIN = 30;
    private Module module;
    private String name;
    private String surname;
    private int age;
    private int skill;
    private Nationality nationality;

    public Coach(String name, String surname, int age, Nationality nationality, Module module) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nationality = nationality;
        this.module = module;
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


    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = (skill < SKILL_MIN) ? SKILL_MIN : skill;
        this.skill = (skill > SKILL_MAX) ? SKILL_MAX : this.skill;
    }

    public Module getModule() {
        return module;
    }
}
