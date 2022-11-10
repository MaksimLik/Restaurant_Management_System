package com.example.restaraunt;

import com.example.restaraunt.mysql.DB_Handler;
import com.example.restaraunt.mysql.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    @FXML
    void initialize() {


        registrationButtonTwo.setOnAction(event -> {
            signUPnewUser();
        });

        OutButton.setOnAction(event -> {
            openNewWindow("log_window.fxml");
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

    private void openNewWindow(String window) {
        registrationButtonTwo.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
   //     stage.close();
    }

}
