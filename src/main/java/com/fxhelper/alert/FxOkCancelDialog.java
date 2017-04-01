package com.fxhelper.alert;

import com.fxhelper.generic.FxDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class FxOkCancelDialog extends FxDialog {
    private static final String title = "Do you wish to continue?";

    public FxOkCancelDialog(String message) {
        super(Alert.AlertType.CONFIRMATION, message, title);
    }

    public boolean ask(){
        return showAndWait().get() == ButtonType.OK;
    }
}
