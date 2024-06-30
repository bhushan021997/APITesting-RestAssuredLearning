package ex_22062024.FullRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Lab277 {



    @BeforeTest
    @Test
    public void getBookingID() {

        RequestSpecification rs= RestAssured.given();
        Response res;

        String payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("booking");
        rs.contentType(ContentType.JSON);
        rs.body(payload);

        res = rs.when().log().all().post();
        System.out.println("Printing after Post Request");
        System.out.println(res.asString());

        ValidatableResponse v1=res.then();
        System.out.println("Printing after Then Request");
        System.out.println(res);

        v1.statusCode(200);


    }
}
