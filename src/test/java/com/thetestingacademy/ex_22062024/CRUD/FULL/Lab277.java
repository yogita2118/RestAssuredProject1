package com.thetestingacademy.ex_22062024.CRUD.FULL;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Lab277 {

    String token;
    Integer bookingID;
    RequestSpecification requestSpecification = RestAssured.given() ;
    ValidatableResponse validatableResponse;
    Response response;

    @BeforeTest
    public void getAToken(){

       String payload = "{\n" +
               "    \"username\" : \"admin\",\n" +
               "    \"password\" : \"password123\"\n" +
               "}";

       requestSpecification.baseUri("https://restful-booker.herokuapp.com");
       requestSpecification.basePath("auth");
       requestSpecification.contentType(ContentType.JSON);
       requestSpecification.body(payload);

       response = requestSpecification.post();

       validatableResponse = response.then();
       validatableResponse.statusCode(200);

       // Extract the Token from this

        token = response.then().log().all().extract().path("token");

        Assert.assertNotNull(token);

    }
    @BeforeTest
    public void getBookingID(){

        String payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-05\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().post();

        ValidatableResponse validatableResponse =response.then();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);

        bookingID = response.then().log().all().extract().path("bookingid");
        String firstName = response.then().log().all().extract().path("booking.firstname");
        System.out.println(firstName);
        System.out.println(bookingID);
        Assert.assertNotNull(bookingID);

    }

    @Test
    public void testPUTRequestPositive(){
        // Token and BookingID
        System.out.println(" - Test Case PUT Request ");

        String payload = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-05\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        // PUT Request

        requestSpecification.body(payload).log().all();

        response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        String fullResponseJSONString = response.asString();
        System.out.println(fullResponseJSONString);

        // Verify all the keys and value pairs in the response
        // firstname, lastname, deposit, total,. checking


        // 3 Ways You can verify the response

        // 1. RA - Matchers
        validatableResponse.body("firstname", Matchers.equalTo("Pramod"));
        validatableResponse.body("lastname", Matchers.equalTo("Brown"));


        // 2. TestNG Asserts -
        // Assert.assertEquals(firstNameResponse,"Pramod");

        String firstNameResponse = response.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstNameResponse,"Pramod");

        // 3. TestNG Assertion with JSON PAth Lib
        JsonPath jsonPath =new JsonPath(fullResponseJSONString);
        String firstNameJSONPathExtracted = jsonPath.getString("firstname");
        String lastNameJSONPathExtracted = jsonPath.getString("lastname");
        Integer totalpriceJSONPathExtracted = jsonPath.getInt("totalprice");
        String chekinDate = jsonPath.getString("bookingdates.checkin");




        Assert.assertEquals(firstNameResponse,"Pramod");
        Assert.assertEquals(lastNameJSONPathExtracted,"Brown");
        Assert.assertEquals(totalpriceJSONPathExtracted,111);
        Assert.assertEquals(chekinDate,"2024-01-01");


        // 4.AssertJ Matching

        assertThat(firstNameJSONPathExtracted)
                .isEqualTo("Pramod")
                .isNotBlank().isNotEmpty();

        assertThat(totalpriceJSONPathExtracted).isNotZero().isNotNegative();





    }

}
