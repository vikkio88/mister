package com.mister.lib.model;

import com.mister.lib.model.enums.Nationality;
import com.mister.lib.model.enums.Position;
import com.mister.lib.model.generic.Person;

public class Player extends Person {
    private Position position;

    public Player(String name, String surname, int age, Nationality nationality, Position position) {
        super(name, surname, age, nationality);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
