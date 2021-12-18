package com.example.aproj;


public class Ride {

    int rideId;
    String dropOff;
    String pickUp;
    int driverID;
    int passengerId;
    int vehicleId;
    double fare;

    public Ride(int rideId, String dropOff, String pickUp, int driverID, int passengerId, int carID, double fare) {
        this.rideId = rideId;
        this.dropOff = dropOff;
        this.pickUp = pickUp;
        this.driverID = driverID;
        this.passengerId = passengerId;
        this.vehicleId = carID;
        this.fare = fare;
    }


    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public String getDropOff() {
        return dropOff;
    }

    public void setDropOff(String dropOff) {
        this.dropOff = dropOff;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
