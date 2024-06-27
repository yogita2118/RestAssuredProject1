package com.thetestingacademy.ex_22062024.CRUD.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab275 {

    RequestSpecification request = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token = "1918a55e0fac637";
   // String token = getToken();

    private String getToken() {
        return  null;
    }

    String bookingid = "2760";

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";


    @Test
    public void testDeleteREQUESTNonBDD(){

        String BASE_PATH_UPDATED = BASE_PATH+"/"+bookingid;
        System.out.println(BASE_PATH_UPDATED);




        request.baseUri(BASE_URL);
        request.basePath(BASE_PATH_UPDATED);
        request.contentType(ContentType.JSON);
        request.cookie("token",token);
        request.log().all();

        response = request.when().log().all().delete();

        vr = response.then().log().all();
        vr.statusCode(201);




    }
}
