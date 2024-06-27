package com.thetestingacademy.ex_22062024.CRUD.GET.NonBDDStyle;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab270 {

    @Test
    public void getRequestNonBDDStyle(){


        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/396370");

        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);


    }
}
