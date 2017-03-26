package com.mister.app.controllers;

import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

import java.awt.*;
import java.util.ArrayList;

public class NewGameController extends BaseAppController {
    @FXML
    TextField nameField;
    @FXML
    TextField ageField;
    @FXML
    ComboBox<String> nationality;
    @FXML
    TableView<Team> teamsTable;
    @FXML
    TableColumn<Team, String> teamName;
    @FXML
    TableColumn<Team, String> playersNumber;
    @FXML
    TableColumn<Team, Float> avgSkill;
    @FXML
    TableColumn<Team, Integer> finances;

    ObservableList<Team> teamList = null;


    @Override
    public void initialize() {
        ArrayList<Team> teams = RandomFiller.getTeams(5);
        teamList = FXCollections.observableList(teams);
    }
}
