package com.fxhelper.generic;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public abstract class FxDialog {
    Alert alert;

    public FxDialog(AlertType alertType, String message, String title) {
        alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(message);
    }

    protected Optional<ButtonType> showAndWait() {
        return alert.showAndWait();
    }


}
