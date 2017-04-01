package com.mister.app.helper;

import com.mister.app.game.model.HumanPlayer;
import com.mister.app.game.model.PlayerTeam;
import com.mister.lib.model.Team;
import com.mister.lib.model.enums.Nationality;
import javafx.collections.ObservableList;

public class Context {
    private final static Context instance = new Context();
    public ObservableList<Team> teamList;
    public ObservableList<Nationality> nationalities;
    public Team selectedTeam;
    public String previousView;
    public HumanPlayer humanPlayer;
    public PlayerTeam humanTeam;

    public static Context getInstance() {
        return instance;
    }
}
