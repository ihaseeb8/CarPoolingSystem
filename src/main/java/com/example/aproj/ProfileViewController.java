package com.example.aproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ProfileViewController {

    @FXML
    private Button DriverProfileButton;

    @FXML
    private Button PassengerProfileButton;

    @FXML
    void DriverProfileButtonClicked(MouseEvent event) {

    }

    @FXML
    void PassengerProfileButtonClicked(MouseEvent event) {

    }

    @FXML
    void onDriverProfileButtonMouseMoved(MouseEvent event) {
        DriverProfileButton.setStyle("-fx-background-color: #455A64 ; -fx-background-radius : 25 ");
    }

    @FXML
    void onDriverProfileButtonMouseRemoved(MouseEvent event) {
        DriverProfileButton.setStyle("-fx-background-color: #BDBDBD; -fx-background-radius : 25 " );
    }

    @FXML
    void onPassengerProfileButtonMouseMoved(MouseEvent event) {
        PassengerProfileButton.setStyle("-fx-background-color:  #607D8B ; -fx-background-radius : 25 ");
    }

    @FXML
    void onPassengerProfileButtonMouseRemoved(MouseEvent event) {
        PassengerProfileButton.setStyle("-fx-background-color: #BDBDBD ; -fx-background-radius : 25 ");
    }

}
