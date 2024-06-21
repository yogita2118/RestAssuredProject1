package com.thetestingacademy.testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab267 {


    // CRUD
    // Create Booking, -> ID
    // Create Auth --> Token
    // Delete -> ID
    // GET -> ID -- Verify it should not exist.

    String token;
    Integer bookingID;

    public String getToken(){
        token = "123";
        return token;
    }

    @BeforeTest
    public void getTokenAndBookingID(){
        token = getToken();
        // POST Req-
        // POST code
        bookingID = 123;
    }

    @Test
    public void testPUTReq(){
        System.out.println(token);
        System.out.println(bookingID);
        // PUT code
    }

    @Test
    public void testDeleteReq(){
        System.out.println(token);
        System.out.println(bookingID);
        // DELETE code
    }

    @Test
    public void testGETReq(){
        System.out.println(token);
        System.out.println(bookingID);
        // GET code
    }



}
