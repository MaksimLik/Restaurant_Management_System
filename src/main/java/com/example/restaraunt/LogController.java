package com.example.restaraunt;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import javafx.scene.image.ImageView;

public class LogController {

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
    private Scene secondScene;

    public void setSecondScene(Scene scene) {
        secondScene = scene;
    }
    public void openSecondScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(secondScene);
    }

    @FXML
    void initialize() {

        logINbutton.setOnAction(event -> {
            String loginText = log_field.getText().trim();
            String loginPassword = password_field.getText().trim();
            if(!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else
               alertWarning();
        });

    }

    private void alertWarning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("Please check your username and/or password.");
        alert.setContentText("Maybe you are not registered.");
        alert.showAndWait();
    }

    private void loginUser(String loginText, String loginPassword) {
        DB_Handler db_handler = new DB_Handler();
        User user = new User();
        user.setName(loginText);
        user.setPassword(loginPassword);
        ResultSet resultSet = db_handler.getUser(user);

       int counter = 0;

       while(true) {
           try {
               if (!resultSet.next()) break;
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
           counter++;
       }
       if(counter >= 1){
           openNewScene("control_window.fxml");
       }
    }

    private void openNewScene(String window) {
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
    }

}
