package com.fxhelper.alert;

import com.fxhelper.generic.FxAlert;
import javafx.scene.control.Alert;

public class FxWarningAlert extends FxAlert {
    private static final String title = "Warning";

    public FxWarningAlert(String message) {
        super(Alert.AlertType.WARNING, message, title);
    }
}
