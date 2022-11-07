package com.example.restaraunt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class MainController {

    @FXML
    private ImageView image_cafe;

    @FXML
    private Button logINbutton;

    @FXML
    private TextField log_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button registrationButton;

    @FXML
    private Label welcomeText;

    @FXML
    void initialize() {


        logINbutton.setOnAction(event -> {
            String loginText = log_field.getText().trim();
            String loginPassword = logINbutton.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else
                System.out.println("Login or/and password is empty!");
        });


       registrationButton.setOnAction(event -> {
           registrationButton.getScene().getWindow().hide();
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("reg_window.fxml"));

           try {
               loader.load();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }

           Parent root = loader.getRoot();
           Stage stage = new Stage();
           stage.setScene(new Scene(root));
           stage.showAndWait();
       });

    }

    private void loginUser(String loginText, String loginPassword) {

    }

}
