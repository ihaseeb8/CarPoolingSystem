package com.example.aproj;

import com.example.aproj.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class PassengerDetailsViewController {

    @FXML
    private Button BackButton;

    @FXML
    private TextField CnicField;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField PhoneNoField;

    @FXML
    private TextField RatingField;

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("passenger-profile-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    void onBackButtonMouseMoved(MouseEvent event) {
        BackButton.setStyle("-fx-background-color: #F44336");
        BackButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onBackButtonMouseRemoved(MouseEvent event) {
        BackButton.setStyle("-fx-background-color: #ff725e");
        BackButton.setTextFill(Paint.valueOf("#000000"));
    }

}
