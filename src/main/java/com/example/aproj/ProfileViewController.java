package com.example.aproj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileViewController {

    @FXML
    private Button DriverProfileButton;

    @FXML
    private Button PassengerProfileButton;

    @FXML
    void DriverProfileButtonClicked(MouseEvent event) {

    }

    @FXML
    void PassengerProfileButtonClicked(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("passenger-profile-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

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
