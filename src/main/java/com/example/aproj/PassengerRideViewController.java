package com.example.aproj;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PassengerRideViewController implements Initializable {

    @FXML
    private Button BackButton;

    @FXML
    private Button BookButton;

    @FXML
    private TableColumn<Ride, Integer> CarNoCol;

    @FXML
    private TableColumn<Ride, Integer> DriverNameCol;

    @FXML
    private TableColumn<Ride, String> DropOffCol;

    @FXML
    private TableColumn<Ride, Double> FareCol;

    @FXML
    private TableView<Ride> PassengerRideInfoTable;

    @FXML
    private TableColumn<Ride, String> PickUpCol;

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
    void BookButtonPressed(MouseEvent event) {

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
    void onBookButtonMouseMoved(MouseEvent event) {
        BookButton.setStyle("-fx-background-color: #F44336");
        BookButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onBookButtonMouseRemoved(MouseEvent event) {
        BookButton.setStyle("-fx-background-color: #ff725e");
        BookButton.setTextFill(Paint.valueOf("#000000"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

      /*  ObservableList<Ride> data = FXCollections.observableArrayList(
                new Ride("F7", "F11", 9988,7732 , 456 ),
                new Ride("F7", "F11", 9988,7742 , 456 ),
                new Ride("F7", "F11", 9988,7732 , 456 ),
                new Ride("F7", "F11", 9988,7732 , 456 ),
                new Ride("F7", "F11", 9988,7732 , 456 ));

        CarNoCol.setCellValueFactory(new PropertyValueFactory<>("CarID"));
        DriverNameCol.setCellValueFactory(new PropertyValueFactory<>("DriverID"));
        DropOffCol.setCellValueFactory(new PropertyValueFactory<>("Dropoff"));
        FareCol.setCellValueFactory(new PropertyValueFactory<>("fare"));
        PickUpCol.setCellValueFactory(new PropertyValueFactory<>("Pickup"));
        //add your data to the table here.
        //tbData.setItems(studentsModels);

        PassengerRideInfoTable.setItems(data);*/

    }
}
