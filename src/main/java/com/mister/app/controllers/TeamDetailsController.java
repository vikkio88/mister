package com.mister.app.controllers;

import com.mister.app.helper.Context;
import com.mister.lib.model.Player;
import com.mister.lib.model.Team;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TeamDetailsController extends BaseAppController {
    @FXML
    private TableView<Player> roster;
    @FXML
    private TableColumn<Player, String> name;
    @FXML
    private TableColumn<Player, Integer> age;
    @FXML
    private TableColumn<Player, Integer> skill;
    @FXML
    private TableColumn<Player, String> position;
    @FXML
    private TableColumn<Player, String> nationality;
    @FXML
    private Label teamName;
    @FXML
    private Button backButton;

    private Team selectedTeam = null;

    @Override
    public void initialize() {
        selectedTeam = Context.getInstance().selectedTeam;
        teamName.setText(selectedTeam.getName());
        ObservableList<Player> roster = FXCollections.observableArrayList(selectedTeam.getRoster());
        name.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getFullName()));
        age.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getAge()));
        skill.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getSkill()));
        position.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getPosition().getDefinition()));
        nationality.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getNationality().getNationName()));
        this.roster.setItems(roster);
    }
}
