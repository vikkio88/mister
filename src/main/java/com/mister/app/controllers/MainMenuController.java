package com.mister.app.controllers;


import com.fxhelper.alert.FxErrorAlert;
import javafx.event.ActionEvent;

public class MainMenuController {
    public void newGame(ActionEvent actionEvent) {
        System.out.println("NewGame");
    }

    public void loadGame(ActionEvent actionEvent) {
        if (!checkSavedGames()) {
            new FxErrorAlert("No Saved Games!");
        }
    }

    private boolean checkSavedGames() {
        return false;
    }
}
