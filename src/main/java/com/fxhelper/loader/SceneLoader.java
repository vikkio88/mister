package com.fxhelper.loader;

import com.mister.app.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneLoader {
    public static Scene load(String viewName) {
        String viewPath = String.format("/views/%s.fxml", viewName);
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(viewPath));
            Parent root = (Parent) loader.load();
            return new Scene(root);
        } catch (IOException e) {
            System.err.println(String.format("Scene %s not found on %s", viewName, viewPath));
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }

}
