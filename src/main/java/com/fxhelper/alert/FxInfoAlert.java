package com.fxhelper.alert;

import com.fxhelper.generic.FxAlert;
import javafx.scene.control.Alert;

public class FxInfoAlert extends FxAlert {
    private static final String title = "Info";

    public FxInfoAlert(String message) {
        super(Alert.AlertType.INFORMATION, message, title);
    }
}
