package com.example.restaraunt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader firstPaneLoader = new FXMLLoader(MainApplication.class.getResource("log_window.fxml"));
        Parent firstPane = firstPaneLoader.load();
        Scene firstscene = new Scene(firstPane, 520, 440);

        FXMLLoader secondPageLoader  = new FXMLLoader(MainApplication.class.getResource("reg_window.fxml"));
        Parent secondPane = secondPageLoader.load();
        Scene secondScene = new Scene(secondPane, 519, 412);

        LogController firstPaneController = (LogController) firstPaneLoader.getController();
        firstPaneController.setSecondScene(secondScene);

        RegistrationController secondPaneController = (RegistrationController) secondPageLoader.getController();
        secondPaneController.setFirstScene(firstscene);

        stage.setTitle("Restaurant!");
        stage.setScene(firstscene);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}