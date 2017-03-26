package com.mister.app.controllers;

import com.mister.app.helper.Context;
import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.Team;
import com.mister.lib.model.enums.Nationality;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.util.ArrayList;

public class NewGameController extends BaseAppController {
    @FXML
    TextField nameField;
    @FXML
    TextField ageField;
    @FXML
    private
    ComboBox<Nationality> nationality;
    @FXML
    private
    TableView<Team> teamsTable;
    @FXML
    private
    TableColumn<Team, String> teamName;
    @FXML
    private
    TableColumn<Team, String> playersNumber;
    @FXML
    private
    TableColumn<Team, Float> avgSkill;
    @FXML
    private
    TableColumn<Team, Integer> finances;

    @Override
    public void initialize() {
        ArrayList<Team> teams = RandomFiller.getTeams(18);
        Context.getInstance().teamList = FXCollections.observableList(teams);
        Nationality[] nationalities = Nationality.values();
        Context.getInstance().nationalities = FXCollections.observableArrayList(nationalities);
        nationality.setItems(Context.getInstance().nationalities);

        teamName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Team, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Team, String> p) {
                return new SimpleStringProperty(p.getValue().getName());
            }
        });
        playersNumber.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Team, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Team, String> p) {
                return new SimpleStringProperty(Integer.toString(p.getValue().getRoster().size()));
            }
        });
        avgSkill.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Team, Float>, ObservableValue<Float>>() {
            public ObservableValue<Float> call(TableColumn.CellDataFeatures<Team, Float> p) {
                return new SimpleObjectProperty<Float>(Float.parseFloat("1.0"));
            }
        });
        finances.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Team, Integer>, ObservableValue<Integer>>() {
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Team, Integer> p) {
                return new SimpleObjectProperty<Integer>(p.getValue().getFinance());
            }
        });

        teamsTable.setItems(Context.getInstance().teamList);
    }
}
