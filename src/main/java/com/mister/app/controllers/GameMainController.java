package com.mister.app.controllers;

import com.mister.app.helper.Context;
import com.mister.lib.model.Team;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameMainController extends BaseAppController {
    @FXML
    public Label teamName;

    @Override
    public void initialize() {
        Team playerTeam = Context.getInstance().selectedTeam;
        teamName.setText(playerTeam.getName());
    }
}
