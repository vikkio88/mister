package com.mister.app.controllers;

import com.fxhelper.alert.FxErrorAlert;
import com.mister.app.game.model.HumanPlayer;
import com.mister.app.helper.Context;
import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.Team;
import com.mister.lib.model.enums.Nationality;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class NewGameController extends BaseAppController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private ComboBox<Nationality> nationality;
    @FXML
    private TableView<Team> teamsTable;
    @FXML
    private TableColumn<Team, String> teamName;
    @FXML
    private TableColumn<Team, String> playersNumber;
    @FXML
    private TableColumn<Team, Integer> avgSkill;
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
            teamsTable.setPlaceholder(new Label("Generating Teams..."));
            final Task<ObservableList<Team>> teamsGenerator = new Task<ObservableList<Team>>() {
                @Override
                protected ObservableList<Team> call() throws Exception {
                    Context.getInstance().teamList = FXCollections.observableList(RandomFiller.getTeams(18));
                    teamsTable.setItems(Context.getInstance().teamList);
                    return Context.getInstance().teamList;
                }
            };
            new Thread(teamsGenerator).start();
        }
        if (Context.getInstance().nationalities == null) {
            Nationality[] nationalities = Nationality.values();
            Context.getInstance().nationalities = FXCollections.observableArrayList(nationalities);
        }
        nationality.setItems(Context.getInstance().nationalities);
        teamName.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getName()));
        playersNumber.setCellValueFactory(p -> new SimpleStringProperty(Integer.toString(p.getValue().getRoster().size())));
        avgSkill.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getAvgSkill()));
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
        if (!validUserInfo()) {
            new FxErrorAlert("Wrong player info");
            nameField.requestFocus();
            return;
        }
        Context.getInstance().humanPlayer = new HumanPlayer(nameField.getText(), surnameField.getText(), nationality.getValue());
        Context.getInstance().selectedTeam = selected;
        showView("GameMain");
    }

    private boolean validUserInfo() {
        return nameField.getText().length() > 1 && surnameField.getText().length() > 1 && nationality.getValue() != null;
    }

    public void viewDetails(ActionEvent actionEvent) {
        Context.getInstance().selectedTeam = selected;
        Context.getInstance().previousView = "NewGame";
        showView("TeamDetails");
    }
}
