package com.example.aproj.TestCases;

import com.example.aproj.Classes.Ride;
import com.example.aproj.Classes.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

import static org.junit.Assert.*;

public class DriverProfileTest {

    @Test
    public void addVehicle () {
        ObservableList<Vehicle> vehicles= FXCollections.observableArrayList(); ;
        Vehicle v=new Vehicle();
        vehicles.add (v);
        assertTrue ( vehicles.contains (v) );
    }

    @Test
    public void addRide () {
        ObservableList<Ride> rides=FXCollections.observableArrayList();
        Ride r=new Ride ();
        rides.add(r);
        assertTrue ( rides.contains ( r ) );


    }

    @Test
    public void deleteVehicle () {
        ObservableList<Vehicle> vehicles= FXCollections.observableArrayList(); ;
        Vehicle v=new Vehicle();
        vehicles.add (v);
        vehicles.remove ( v );
        assertFalse ( vehicles.contains (v) );
    }

    @Test
    public void deleteRides () {
        ObservableList<Ride> rides=FXCollections.observableArrayList();
        Ride r=new Ride ();
        rides.add(r);
        rides.remove ( r );
        assertFalse ( rides.contains ( r ) );

    }
}