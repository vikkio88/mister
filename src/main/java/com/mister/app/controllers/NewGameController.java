package com.mister.app.controllers;

import com.mister.lib.model.Team;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

import java.awt.*;

public class NewGameController extends BaseAppController {
    @FXML
    TextField name;
    @FXML
    TextField age;
    @FXML
    ComboBox<String> nationality;
    @FXML
    TableView<Team> teamsTable;

    @Override
    public void initialize(){

    }


}
