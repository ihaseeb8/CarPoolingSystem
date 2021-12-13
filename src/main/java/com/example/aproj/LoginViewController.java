package com.example.aproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

public class LoginViewController {

    @FXML
    private TextField CnicField;

    @FXML
    private Button LogInButton;

    @FXML
    private AnchorPane PasswordField;

    @FXML
    void LoginButtonClicked(MouseEvent event) {

    }

    @FXML
    void onLoginButtonMouseMoved(MouseEvent event) {
        LogInButton.setStyle("-fx-background-color: #F44336");
        LogInButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onLoginButtonMouseRemoved(MouseEvent event) {
        LogInButton.setStyle("-fx-background-color: #ff725e");
        LogInButton.setTextFill(Paint.valueOf("#000000"));

    }

}
