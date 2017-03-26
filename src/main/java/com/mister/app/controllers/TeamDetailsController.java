package com.mister.app.controllers;

import com.mister.app.helper.Context;
import com.mister.lib.model.Team;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TeamDetailsController extends BaseAppController {
    @FXML
    private TableView<Team> roster;
    @FXML
    private TableColumn<Team, String> name;
    @FXML
    private TableColumn<Team, Integer> age;
    @FXML
    private TableColumn<Team, Integer> skill;
    @FXML
    private TableColumn<Team, String> position;
    @FXML
    private TableColumn<Team, String> nationality;
    @FXML
    private Label teamName;
    @FXML
    private Button backButton;

    Team selectedTeam = null;
    @Override
    public void initialize() {
        selectedTeam = Context.getInstance().selectedTeam;
        teamName.setText(selectedTeam.getName());
    }
}
