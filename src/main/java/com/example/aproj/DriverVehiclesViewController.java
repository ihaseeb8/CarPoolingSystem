package com.example.aproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class DriverVehiclesViewController implements Initializable {

    @FXML
    private Button BackButton;

    @FXML
    private TableColumn<Vehicle, Integer> MakeCol;

    @FXML
    private TextField MakeField;

    @FXML
    private TableColumn<Vehicle, String> ModelCol;

    @FXML
    private TextField ModelField;

    @FXML
    private TableColumn<Vehicle, String> NameCol;

    @FXML
    private TextField NameField;

    @FXML
    private TableView<Vehicle> DriverVehiclesInfoTable;

    @FXML
    private Button RegisterButton;

    @FXML
    private TableColumn<Vehicle, String> VehicleIdCol;

    @FXML
    private TextField VehicleIdField;

    @FXML
    private Text registerPrompt;

    @FXML
    private Text vehcexcep;

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("driver-profile-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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


    @FXML
    void RegisterButtonPressed(MouseEvent event) {

        if (VehicleIdField.getText().isEmpty()) {
            registerPrompt.setText("Vehicle Id Missing!");
        } else if (NameField.getText().isEmpty()) {
            registerPrompt.setText("Vehicle Name Missing!");
        } else if (ModelField.getText().isEmpty()) {
            registerPrompt.setText("Vehicle Model Missing!");
        } else if (MakeField.getText().isEmpty()) {
            registerPrompt.setText("Vehicle Make Missing!");
        }

        String vehicle1 = MakeField.getText();
        //int fareInt = parseInt(fare);
        try {
            int vehicleInt = parseInt(vehicle1);
            try{
                CheckVehicle(vehicleInt);
            }
            catch (Exception e)
            {
                vehcexcep.setText(e.getMessage());
            }

            if (vehicleInt == 2000 || vehicleInt == 2001 || vehicleInt == 2002 || vehicleInt == 2003 ||vehicleInt == 2004 || vehicleInt == 2005 || vehicleInt == 2006 || vehicleInt == 2007 ||
                    vehicleInt == 2008 || vehicleInt == 2009 || vehicleInt == 2010 || vehicleInt == 2011 || vehicleInt == 2012 ||vehicleInt == 2013 || vehicleInt == 2014 || vehicleInt == 2015 ||
                    vehicleInt == 2016 || vehicleInt == 2017 ||vehicleInt == 2018 || vehicleInt== 2019 ||vehicleInt == 2020)
            {
                CheckVehicle(vehicleInt);
            }

        else
            {
                boolean a = DBConnection.getDBConnection().searchVehicle(VehicleIdField.getText());

                if (a) {
                    registerPrompt.setText("Vehicle Id already Registered!");
                } else {
                    registerPrompt.setText("Vehicle Registered Successfully!");
                    Vehicle vehicle = new Vehicle(Integer.valueOf(VehicleIdField.getText()), DriverProfile.getDriverProfile().getDriverCnic(), NameField.getText(), ModelField.getText(), MakeField.getText());
                    DriverProfile.getDriverProfile().addVehicle(vehicle);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    @FXML
    void onRegisterButtonMouseMoved(MouseEvent event) {
        RegisterButton.setStyle("-fx-background-color: #F44336");
        RegisterButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onRegisterButtonMouseRemoved(MouseEvent event) {
        RegisterButton.setStyle("-fx-background-color: #ff725e");
        RegisterButton.setTextFill(Paint.valueOf("#000000"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (DriverProfile.getDriverProfile().getVehicles() == null) {
            System.out.println("haha");
        } else {
            ObservableList<Vehicle> data = DriverProfile.getDriverProfile().getVehicles();

            VehicleIdCol.setCellValueFactory(new PropertyValueFactory<>("vehicleId"));
            NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            ModelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
            MakeCol.setCellValueFactory(new PropertyValueFactory<>("make"));

            DriverVehiclesInfoTable.setItems(data);

        }
    }

    static int CheckVehicle(int vehicleInt) throws VehicleException {
        if (vehicleInt == 2000 || vehicleInt == 2001 || vehicleInt == 2002 || vehicleInt == 2003 ||vehicleInt == 2004 || vehicleInt == 2005 || vehicleInt == 2006 || vehicleInt == 2007 ||
                vehicleInt == 2008 || vehicleInt == 2009 || vehicleInt == 2010 || vehicleInt == 2011 || vehicleInt == 2012 ||vehicleInt == 2013 || vehicleInt == 2014 || vehicleInt == 2015 ||
                vehicleInt == 2016 || vehicleInt == 2017 ||vehicleInt == 2018 || vehicleInt== 2019 ||vehicleInt == 2020) {

        throw new VehicleException("Make Should Be Toyota or Something Else");


    }
    else

    {
        System.out.println("");
    }
    return vehicleInt;
}
}
