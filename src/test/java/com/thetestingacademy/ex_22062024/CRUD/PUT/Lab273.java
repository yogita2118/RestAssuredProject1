package com.thetestingacademy.ex_22062024.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab273 {

    RequestSpecification request = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token = "c397f0c56ed04f2";
   // String token = getToken();

    private String getToken() {
        return  null;
    }

    String bookingid = "449";

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";


    @Test
    public void testPutREQUESTNonBDD(){

        String BASE_PATH_UPDATED = BASE_PATH+"/"+bookingid;
        System.out.println(BASE_PATH_UPDATED);

        String payload = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-05-01\",\n" +
                "        \"checkout\" : \"2024-08-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        request.baseUri(BASE_URL);
        request.basePath(BASE_PATH_UPDATED);
        request.contentType(ContentType.JSON);
        request.cookie("token",token);
        request.body(payload).log().all();

        response = request.when().log().all().put();

        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("James"));
        vr.body("lastname", Matchers.equalTo("Brown"));


    }
}
