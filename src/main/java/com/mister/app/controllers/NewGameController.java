package com.mister.app.controllers;

import com.fxhelper.loader.SceneLoader;
import com.mister.app.helper.Context;
import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.Team;
import com.mister.lib.model.enums.Nationality;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class NewGameController extends BaseAppController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private ComboBox<Nationality> nationality;
    @FXML
    private TableView<Team> teamsTable;
    @FXML
    private TableColumn<Team, String> teamName;
    @FXML
    private TableColumn<Team, String> playersNumber;
    @FXML
    private TableColumn<Team, Float> avgSkill;
    @FXML
    private TableColumn<Team, Integer> finances;
    @FXML
    private Button detailsButton;
    @FXML
    private Button nextButton;
    @FXML
    private TextField selectedTeamName;

    private Team selected = null;

    @Override
    public void initialize() {
        if (Context.getInstance().teamList == null) {
            ArrayList<Team> teams = RandomFiller.getTeams(18);
            Context.getInstance().teamList = FXCollections.observableList(teams);
        }
        if (Context.getInstance().nationalities == null) {
            Nationality[] nationalities = Nationality.values();
            Context.getInstance().nationalities = FXCollections.observableArrayList(nationalities);
        }
        nationality.setItems(Context.getInstance().nationalities);

        teamName.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getName()));
        playersNumber.setCellValueFactory(p -> new SimpleStringProperty(Integer.toString(p.getValue().getRoster().size())));
        avgSkill.setCellValueFactory(p -> new SimpleObjectProperty<>(Float.parseFloat("1.0")));
        finances.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getFinance()));
        teamsTable.setItems(Context.getInstance().teamList);
        teamsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->
        {
            if (newSelection != null) {
                selected = newSelection;
                selectedTeamName.setText(selected.getName());
                detailsButton.setDisable(false);
                nextButton.setDisable(false);
            }
        });
    }

    public void next(ActionEvent actionEvent) {
        System.out.println("Next");
    }

    public void viewDetails(ActionEvent actionEvent) {
        Context.getInstance().selectedTeam = selected;
        getStage().setScene(SceneLoader.load("TeamDetails"));
    }
}
