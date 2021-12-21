package com.example.aproj.Controllers;

import com.example.aproj.Classes.PassengerProfile;
import com.example.aproj.Classes.Ride;
import com.example.aproj.DBHandlers.DBConnection;
import com.example.aproj.HelloApplication;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PassengerCancelRideViewController implements Initializable {


    @FXML
    private Button BackButton;

    @FXML
    private Button CancelButton;

    @FXML
    private TableView<Ride> BookedRidesInfoTable;

    @FXML
    private TableColumn<?, ?> DropOffCol;

    @FXML
    private TableColumn<?, ?> FareCol;

    @FXML
    private TableColumn<?, ?> PassengerIdCol;

    @FXML
    private TableColumn<?, ?> PickUpCol;

    @FXML
    private TableColumn<?, ?> VehicleIdCol;

    @FXML
    private Text promptText;

    @FXML
    void onCancelButtonMouseMoved(MouseEvent event) {
        CancelButton.setStyle("-fx-background-color: #F44336");
        CancelButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onCancelButtonMouseRemoved(MouseEvent event) {
        CancelButton.setStyle("-fx-background-color: #ff725e");
        CancelButton.setTextFill(Paint.valueOf("#000000"));
    }

    @FXML
    void CancelButtonPressed(MouseEvent event) {
        if(BookedRidesInfoTable.getSelectionModel().isEmpty())
        {
            promptText.setText("Please Select A Ride First");
        }
        else {
            Ride temp = BookedRidesInfoTable.getSelectionModel().getSelectedItem();
            DBConnection.getDBConnection().cancelRide(temp.getRideId());
            //System.out.println(temp.vehicleId);
            BookedRidesInfoTable.getItems().remove(temp);
            promptText.setText("Ride Cancelled !");
        }
    }


    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/passenger-profile-view.fxml"));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Ride> rides = DBConnection.getDBConnection().getPassengerBookedRides(PassengerProfile.getPassengerProfile().getPassengerCnic());
        PickUpCol.setCellValueFactory(new PropertyValueFactory<>("pickUp"));
        DropOffCol.setCellValueFactory(new PropertyValueFactory<>("dropOff"));
        PassengerIdCol.setCellValueFactory(new PropertyValueFactory<>("passengerId"));
        VehicleIdCol.setCellValueFactory(new PropertyValueFactory<>("vehicleId"));
        FareCol.setCellValueFactory(new PropertyValueFactory<>("fare"));

        BookedRidesInfoTable.setItems(rides);

    }
}