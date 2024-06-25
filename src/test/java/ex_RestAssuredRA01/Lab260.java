package ex_RestAssuredRA01;

import io.restassured.RestAssured;

public class Lab260 {
        public static void main(String[] args) {
                // Rest Assured Hello World Program
                // Rest Assured Hello World Program
                // Rest Assured Hello World Program
                RestAssured
                        .given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("/ping")

                        .when().get()

                        .then().statusCode(201);

        }
}
