package com.mister.app.helper;

import com.mister.lib.model.Team;
import com.mister.lib.model.enums.Nationality;
import javafx.collections.ObservableList;

public class Context {
    private final static Context instance = new Context();
    public ObservableList<Team> teamList;
    public ObservableList<Nationality> nationalities;
    public Team selectedTeam;

    public static Context getInstance() {
        return instance;
    }
}
