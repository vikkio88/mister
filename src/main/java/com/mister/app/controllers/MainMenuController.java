package com.mister.app.controllers;


import com.fxhelper.alert.FxErrorAlert;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class MainMenuController extends BaseAppController {

    public void newGame(ActionEvent actionEvent) {
        showView("NewGame");
    }

    public void loadGame(ActionEvent actionEvent) {
        System.out.println(this.viewName);
        if (!checkSavedGames()) {
            new FxErrorAlert("No Saved Games!");
        }
    }

    private boolean checkSavedGames() {
        return false;
    }

    public void exit(ActionEvent actionEvent) {
        Stage stage = getStage();
        stage.close();
    }

}
