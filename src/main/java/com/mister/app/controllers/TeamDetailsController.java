package com.mister.app.controllers;

import com.mister.app.game.model.HumanPlayer;
import com.mister.app.helper.Context;
import com.mister.lib.model.Coach;
import com.mister.lib.model.Player;
import com.mister.lib.model.Team;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    private TextField avgSkill;
    @FXML
    private TextField finance;
    @FXML
    private TextField playersPerRole;
    @FXML
    private TextField coachName;
    @FXML
    public TextField coachNationality;
    @FXML
    private TextField coachAge;
    @FXML
    private TextField coachSkill;
    @FXML
    private TextField coachModule;

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


        avgSkill.setText(String.valueOf(selectedTeam.getAvgSkill()));
        finance.setText(String.valueOf(selectedTeam.getFinance()));
        playersPerRole.setText("");

        Coach coach = selectedTeam.getCoach();
        coachName.setText(coach.getFullName());
        coachNationality.setText(coach.getNationality().getNationName());
        coachAge.setText(String.valueOf(coach.getAge()));
        coachSkill.setText(String.valueOf(coach.getSkill()));
        coachModule.setText(selectedTeam.getCoach().getModule().getName());
    }

    public void back(ActionEvent actionEvent) {
        String previousView = Context.getInstance().previousView;
        showView(previousView);
    }
}
