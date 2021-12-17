package com.example.aproj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class PassengerProfileViewController {

    @FXML
    private Button AvailableRidesButton;

    @FXML
    private Button BackButton;

    @FXML
    private Button ProfileButton;

    @FXML
    private Button RideHistoryButton;

    @FXML
    void AvailableRidesButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("passenger-ride-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profiles-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ProfileButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("passenger-details-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void RideHistoryButtonPressed(MouseEvent event) {

    }

    @FXML
    void onAvailableRidesButtonMouseMoved(MouseEvent event) {
        AvailableRidesButton.setStyle("-fx-background-color: #F44336");
        AvailableRidesButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onAvailableRidesButtonMouseRemoved(MouseEvent event) {
        AvailableRidesButton.setStyle("-fx-background-color: #ff725e");
        AvailableRidesButton.setTextFill(Paint.valueOf("#000000"));
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

    @FXML
    void onProfileButtonMouseMoved(MouseEvent event) {
        ProfileButton.setStyle("-fx-background-color: #F44336");
        ProfileButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onProfileButtonMouseRemoved(MouseEvent event) {
        ProfileButton.setStyle("-fx-background-color: #ff725e");
        ProfileButton.setTextFill(Paint.valueOf("#000000"));
    }

    @FXML
    void onRideHistoryButtonMouseMoved(MouseEvent event) {
        RideHistoryButton.setStyle("-fx-background-color: #F44336");
        RideHistoryButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onRideHistoryButtonMouseRemoved(MouseEvent event) {
        RideHistoryButton.setStyle("-fx-background-color: #ff725e");
        RideHistoryButton.setTextFill(Paint.valueOf("#000000"));
    }

}
