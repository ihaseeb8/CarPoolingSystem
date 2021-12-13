package com.example.aproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

public class SignUpViewController {

    @FXML
    private TextField CnicField;

    @FXML
    private PasswordField ConfirmPassField;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField NameField;

    @FXML
    private PasswordField PassField;

    @FXML
    private TextField PhoneNoField;

    @FXML
    private Button SignUpButton;


    @FXML
    void onSignUpButtonMouseMoved(MouseEvent event) {
        SignUpButton.setStyle("-fx-background-color: #F44336");
        SignUpButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onSignUpButtonMouseRemoved(MouseEvent event) {
        SignUpButton.setStyle("-fx-background-color: #ff725e");
        SignUpButton.setTextFill(Paint.valueOf("#000000"));
    }
    @FXML
    void SignUpButtonClicked(MouseEvent event) {

    }
}
