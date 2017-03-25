package com.mister.app;

import com.fxhelper.loader.SceneLoader;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Mister");
        mainWindow();
    }

    private void mainWindow() {
        primaryStage.setScene(SceneLoader.load("Main"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
