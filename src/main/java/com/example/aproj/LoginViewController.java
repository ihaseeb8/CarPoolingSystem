package com.example.aproj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

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

    @FXML
    void LoginButtonPressed(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profiles-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}
