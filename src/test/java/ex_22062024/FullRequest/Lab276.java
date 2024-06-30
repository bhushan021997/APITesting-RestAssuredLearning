package ex_22062024.FullRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Optional;

public class Lab276 {

    RequestSpecification rs= RestAssured.given();
    Response res;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;

    @BeforeTest
    public void  GenerateToken(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("auth");
        rs.contentType(ContentType.JSON);
        rs.body(payload);

        res=rs.when().log().all().post();
        validatableResponse=res.then();
        validatableResponse.statusCode(200);

        token = res.then().log().all().extract().path("token");
        System.out.println(token);
       Assert.assertNotNull(token);
    }

    @BeforeTest
    @Test
    public void getBookingID(){

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
        String responseBody=res.asString();
        System.out.println(responseBody);

        validatableResponse=res.then();
        validatableResponse.statusCode(200);

        bookingID=res.then().log().all().extract().path("bookingid");
        String firstname = res.then().log().all().extract().path("booking.firstname");

        System.out.println(bookingID);
        System.out.println(firstname);





    }

    @Test
    public void testPUTRequestPositive() {
        // token and BookingID
        System.out.println(" - Test Case PUT Request ");

        String payload = "{\n" +
                "    \"firstname\" : \"Bhushan\",\n" +
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
        rs.basePath("booking/" + bookingID);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload);

        res = rs.put();
        String responsebodyupdated = res.asString();
        System.out.println(responsebodyupdated);

        validatableResponse = res.then();
        validatableResponse.statusCode(200);

        String firstname1 = res.then().extract().path("firstname");
        System.out.println(firstname1);

//        // 3 Ways You can verify the response
//
//        // 1. RA - Matchers
//
//        validatableResponse.body("firstname", Matchers.equalTo("Bhushan"));
//        validatableResponse.body("lastname", Matchers.equalTo("Brown"));

        //  2. TestNG Asserts -
        //  Assert.assertEquals(firstNameResponse,"Pramod");
        String firstNameResponse = res.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstNameResponse,"Bhushan");

        // 3 TestNG Assertion with JSON Path Lib
        JsonPath jp=new JsonPath(responsebodyupdated);
        String firstnameextracted = jp.getString("firstname");
        String lastnameextracted = jp.getString("lastname");
        Integer totalpriceJSONPathExtracted = jp.getInt("totalprice");
        String bookingdates = jp.getString("bookingdates.checkin");

        Assert.assertEquals(firstnameextracted, "Bhushan");
        Assert.assertEquals(lastnameextracted, "Brown");

        Assert.assertEquals((Object) bookingdates, (Object) "2018-01-01");









    }





    }
