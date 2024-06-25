package ex_RestAssuredRA01;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab263 {

    @Description("TC#1 - Verify 263 GET Request 2")
    @Test
    public void getRequest2() {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);
//                .given()
//                .baseUri("https://restful-booker.herokuapp.com")
//                .basePath("/ping")
//                .when().get()
//                .then().statusCode(201);
    }


}
