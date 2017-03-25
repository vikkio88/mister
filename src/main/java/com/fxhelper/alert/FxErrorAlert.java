package com.fxhelper.alert;

import com.fxhelper.generic.FxAlert;
import javafx.scene.control.Alert;

public class FxErrorAlert extends FxAlert {
    private static final String title = "Error";

    public FxErrorAlert(String message) {
        super(Alert.AlertType.ERROR, message, title);
    }
}
