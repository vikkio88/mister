package com.mister.app.controllers;


import com.fxhelper.alert.FxErrorAlert;
import com.fxhelper.loader.SceneLoader;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class MainMenuController extends BaseAppContoller {
    public void newGame(ActionEvent actionEvent) {
        getStage().setScene(SceneLoader.load("NewGame"));
    }

    public void loadGame(ActionEvent actionEvent) {
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
