package com.thetestingacademy.ex_22062024.CRUD.GET.BDDStyle;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab269 {


    // Given -->
    // URL
    // HEADER /, Cookies
    // base url = https://api.zippopotam.us
    // basePath = /IN/560037
    // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 ? = No

    // When -->
    // Payload - ? No/Yes - JSON. XML --> String, Hashmap, Object class
    // GET Method


    // Then()
    // Response Validation
    // Status Code
    // Response Body
    // Time, Headers, Cookies

    @Test
    public void getRequestBDDStyle(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/396370")

                .when().log().all().get()

                .then()
                .log().all()
                .statusCode(200);


    }

}
