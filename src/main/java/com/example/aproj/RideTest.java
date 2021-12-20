package com.example.aproj;

import org.junit.Test;

import static org.junit.Assert.*;

public class RideTest {

   // @Test
  //  public void getPassengerId() {


   // }

    @Test
    public void getRideId () {
        Ride min=new Ride ();
        min.setRideId ( 1 );
       assertEquals(1,min.getRideId ());
    }
   // public void setPassengerId() {
   // }
}