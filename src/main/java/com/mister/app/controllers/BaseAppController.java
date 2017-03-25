package com.mister.app.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.stage.Stage;

abstract class BaseAppController {
    @FXML
    protected Parent root;

    public void initialize() {

    }

    Stage getStage() {
        return (Stage) root.getScene().getWindow();
    }
}
