package ex_22062024.GET.NonBDDStyle;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab270 {


    @Test
    public void getRequestPositive(){

        RequestSpecification req= RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/2773").log().all();
        req.when().get();
        req.then().log().all().statusCode(200);
    }


    @Test
    public void getRequestNegative(){

        RequestSpecification req= RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/-1").log().all();
        req.when().log().all().get();
        req.then().log().all().statusCode(200);
    }
}
