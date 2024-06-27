package com.thetestingacademy.ex_22062024.CRUD.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab274 {

    RequestSpecification request = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token = "2cbbdd41dfa5f48";
   // String token = getToken();

    private String getToken() {
        return  null;
    }

    String bookingid = "1476";

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";


    @Test
    public void testPatchREQUESTNonBDD(){

        String BASE_PATH_UPDATED = BASE_PATH+"/"+bookingid;
        System.out.println(BASE_PATH_UPDATED);

        String payload = "{\n" +
                "    \"firstname\" : \"Pramod\"}";


        request.baseUri(BASE_URL);
        request.basePath(BASE_PATH_UPDATED);
        request.contentType(ContentType.JSON);
        request.cookie("token",token);
        request.body(payload).log().all();

        response = request.when().log().all().patch();

        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Pramod"));



    }
}
