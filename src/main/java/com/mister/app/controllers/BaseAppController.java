package com.mister.app.controllers;

import com.fxhelper.loader.SceneLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.stage.Stage;

abstract class BaseAppController {
    @FXML
    protected Parent root;

    String viewName;

    BaseAppController() {
        this.viewName = getViewFromClass();
    }

    private String getViewFromClass() {
        return this.getClass().getSimpleName().replace("Controller","");
    }

    public void initialize() {

    }

    void showView(String viewName) {
        getStage().setScene(SceneLoader.load(viewName));
    }

    Stage getStage() {
        return (Stage) root.getScene().getWindow();
    }
}
