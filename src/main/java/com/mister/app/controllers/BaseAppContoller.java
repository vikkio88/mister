package com.mister.app.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class BaseAppContoller {
    @FXML
    protected Parent root;

    Stage getStage() {
        return (Stage) root.getScene().getWindow();
    }
}
