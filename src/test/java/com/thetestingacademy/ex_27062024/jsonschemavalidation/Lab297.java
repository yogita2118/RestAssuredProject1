package com.thetestingacademy.ex_27062024.jsonschemavalidation;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class Lab297 {

    @Test
    public void JSValidation(){

        String path = "src/test/resources/schema.json ";
        RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com/posts/2")
                .when().get().then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File(path)));
    }
}
