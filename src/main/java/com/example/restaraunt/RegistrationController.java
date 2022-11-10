package com.example.restaraunt;

import com.example.restaraunt.mysql.DB_Handler;
import com.example.restaraunt.mysql.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;

public class RegistrationController {

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
}
