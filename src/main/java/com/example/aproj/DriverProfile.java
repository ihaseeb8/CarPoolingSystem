package com.example.aproj;

import javafx.collections.ObservableList;

public class DriverProfile {

    private int driverCnic;
    private ObservableList<Vehicle> vehicles;

    private static DriverProfile driverProfile = new DriverProfile();

    private DriverProfile() {
        driverCnic = 0;
    }

    public static DriverProfile getDriverProfile(){
        return driverProfile;
    }

    public DriverProfile(int driverCnic) {
        this.driverCnic = driverCnic;
    }

    public int getDriverCnic() {
        return driverCnic;
    }

    public void setDriverCnic(int driverCnic) {
        this.driverCnic = driverCnic;
    }

    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    public void deleteVehicle(Vehicle v){
        vehicles.remove(v);
    }

    public ObservableList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ObservableList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}