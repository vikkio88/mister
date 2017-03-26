package com.mister.lib.model;

import com.mister.lib.model.enums.Module;
import com.mister.lib.model.enums.Nationality;
import com.mister.lib.model.generic.Person;

public class Coach extends Person {
    private Module module;

    public Coach(String name, String surname, int age, Nationality nationality, Module module) {
        super(name, surname, age, nationality);
        this.module = module;
    }

    public Module getModule() {
        return module;
    }
}
