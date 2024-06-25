package Testng;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab261 {
@Description("Verifying the get Request 1")
@Test
    public void getRequest1()
    {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);

    }

    @Description("Verifying the get Request 2")
    @Test
    public void getRequest2()
    {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);

    }

}
