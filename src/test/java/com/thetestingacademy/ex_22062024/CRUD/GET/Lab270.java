package com.thetestingacademy.ex_22062024.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab270 {

    @Test
    public void getRequest(){


        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/2002").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);



    }
    @Test
    public void getRequestNegative(){


        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);



    }
}
