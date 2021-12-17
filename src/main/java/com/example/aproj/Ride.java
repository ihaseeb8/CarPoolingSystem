package com.example.aproj;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Ride {
    String Dropoff;
    String Pickup;
    int DriverID;
    int CarID;
    double fare;



    public Ride(String dropoff, String pickup, int driverID, int carID, double fare) {

        Dropoff = dropoff;
        Pickup = pickup;
        DriverID = driverID;
        CarID = carID;
        this.fare = fare;


    }


    public String getDropoff() {
        return Dropoff;
    }

    public void setDropoff(String dropoff) {
        Dropoff = dropoff;
    }

    public String getPickup() {
        return Pickup;
    }

    public void setPickup(String pickup) {
        Pickup = pickup;
    }

    public int getDriverID() {
        return DriverID;
    }

    public void setDriverID(int driverID) {
        DriverID = driverID;
    }

    public int getCarID() {
        return CarID;
    }

    public void setCarID(int carID) {
        CarID = carID;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
