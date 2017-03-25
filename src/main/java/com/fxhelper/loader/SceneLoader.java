package com.fxhelper.loader;

import com.mister.app.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneLoader {
    public static Scene load(String viewName) {
        try {
            String viewPath = String.format("/views/%s.fxml", viewName);
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(viewPath));
            return new Scene((Parent) loader.load());
        } catch (IOException e) {
            System.out.println("ciao");
            return null;
        }
    }

}
