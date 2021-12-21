package com.example.aproj.TestCases;

import com.example.aproj.Classes.Ride;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerProfileTest {

    @Test
    public void addRide () {
        ObservableList<Ride> rides= FXCollections.observableArrayList();
        Ride r=new Ride();
        rides.add ( r );
        assertTrue ( rides.contains (r ));
    }

    @Test
    public void deleteRides () {
        ObservableList<Ride> rides= FXCollections.observableArrayList();
        Ride r=new Ride();
        rides.add ( r );
        rides.remove (r );
        assertFalse ( rides.contains (r ));
    }
}