package ex_27062024;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Lab290 {

    @Test
    public void preparingrequestpayload() {

        Map<String, Object> payload = new LinkedHashMap<>();

        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        Integer totalprice = faker.random().nextInt(100);
        Boolean depoistpaid = faker.random().nextBoolean();

        payload.put("firstname", firstname);
        payload.put("lastname", lastname);
        payload.put("totalprice", totalprice);
        payload.put("depositpaid", depoistpaid);

        Map<String, Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin", "2024-01-01");
        bookingDatesMap.put("checkout", "2014-01-05");
        payload.put("bookingdates", bookingDatesMap);
        payload.put("additionalneeds", "Breakfast, lunch");


        RequestSpecification rs = RestAssured.given();

        Response r;

        ValidatableResponse vlaresp;

        Lab290 l = new Lab290();


        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(payload);
        r = rs.when().log().all().post();

        String responseBody = r.asString();
        System.out.println(responseBody);

        vlaresp = r.then().log().all();
        vlaresp.statusCode(200);


    }


}
