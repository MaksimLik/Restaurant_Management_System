package com.example.restaraunt;

import com.example.restaraunt.mysql.DB_Handler;
import com.example.restaraunt.mysql.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

public class RegistrationController {

    @FXML
    private Button OutButton;

    @FXML
    private Button registrationButtonTwo;

    @FXML
    private DatePicker signUPbd;

    @FXML
    private TextField signUPname;

    @FXML
    private PasswordField signUPpassword;

    @FXML
    private TextField signUPsurname;

    @FXML
    private Label welcomeText;

    private Scene firstScene;

    public void setFirstScene(Scene scene) {
        firstScene = scene;
    }

    public void openFirstScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(firstScene);
    }

    @FXML
    void initialize() {

        registrationButtonTwo.setOnAction(event -> {
            signUPnewUser();
        });

    }

    private void signUPnewUser() {
        DB_Handler db_handler = new DB_Handler();

        String name = signUPname.getText();
        String surname = signUPsurname.getText();
        Date birthD = Date.valueOf(signUPbd.getValue());
        String password = signUPpassword.getText();
        User user = new User(name, surname, birthD, password);

        db_handler.registrationUsers(user);

    }

   /*  private void openNewWindow(String window) {
        /*  FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = null;
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();


        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(window));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Restaurant!");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();


    } */

}
