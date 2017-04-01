package com.mister.app.controllers;

import com.mister.app.game.model.HumanPlayer;
import com.mister.app.game.model.PlayerTeam;
import com.mister.app.helper.Context;
import com.mister.lib.model.Player;
import com.mister.lib.model.Team;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class GameMainController extends BaseAppController {
    @FXML
    public Label teamName;
    @FXML
    public Label playerName;
    @FXML
    public Label messageLabel;
    @FXML
    public ProgressBar trustBar;
    @FXML
    public ProgressBar moraleBar;

    @Override
    public void initialize() {
        PlayerTeam playerTeam = Context.getInstance().humanTeam;
        HumanPlayer player = Context.getInstance().humanPlayer;
        teamName.setText(playerTeam.getTeam().getName());
        trustBar.progressProperty().bind(new SimpleIntegerProperty(playerTeam.getTrust()));
        moraleBar.progressProperty().bind(new SimpleIntegerProperty(playerTeam.getMorale()));
        playerName.setText(player.getFullName());
    }

    public void advance(ActionEvent actionEvent) {
        System.out.println("Simulate");
    }
}
