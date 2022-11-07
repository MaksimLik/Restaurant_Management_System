package com.example.restaraunt;

import com.example.restaraunt.mysql.DB_Handler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrationController {

    @FXML
    private Button registrationButtonTwo;

    @FXML
    private TextField signUPbd;

    @FXML
    private TextField signUPname;

    @FXML
    private PasswordField signUPpassword;

    @FXML
    private TextField signUPsurname;

    @FXML
    private Label welcomeText;


    void intialize () {

        DB_Handler db_handler = new DB_Handler();
        registrationButtonTwo.setOnAction(event -> {
            db_handler.registrationUsers(signUPname.getText(),
                    signUPsurname.getText(), signUPbd.getText(), signUPpassword.getText());
        });
    }
}
