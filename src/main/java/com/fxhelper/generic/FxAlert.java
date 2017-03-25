package com.fxhelper.generic;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class FxAlert {

    public FxAlert(AlertType alertType, String message, String title) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(message);
        alert.show();
    }
}
