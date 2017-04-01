package com.mister.app.controllers;

import com.fxhelper.alert.FxErrorAlert;
import com.fxhelper.alert.FxOkCancelDialog;
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
            generateTeams();
        }
        if (Context.getInstance().nationalities == null) {
            Nationality[] nationalities = Nationality.values();
            Context.getInstance().nationalities = FXCollections.observableArrayList(nationalities);
        }
        nationality.setItems(Context.getInstance().nationalities);
        teamName.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getName()));
        playersNumber.setCellValueFactory(p -> new SimpleStringProperty(Integer.toString(p.getValue().getRoster().size())));
        avgSkill.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getAvgSkill()));
        finances.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getFinanceMillions()));
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

    private void generateTeams() {
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

    public void next(ActionEvent actionEvent) {
        if (!validUserInfo()) {
            new FxErrorAlert("Some info are missing...");
            nameField.requestFocus();
            return;
        }
        FxOkCancelDialog dialog = new FxOkCancelDialog(String.format("You selected %s as your team, are you sure?", selected.getName()));
        if (!dialog.ask()) {
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
