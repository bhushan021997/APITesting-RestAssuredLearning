package ex_22062024.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab272 {

    RequestSpecification rs=RestAssured.given();

    Response r;

    ValidatableResponse valresp;


    @Test
    public void testNonBDDStylePOSTPositive() {

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
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


                rs.baseUri(BASE_URL)
                .basePath(BASE_PATH)
                .contentType(ContentType.JSON)
                        .body(payload);

                r=rs.when().log().all().post();
                System.out.print("Response we are printing");
                String responseString= r.asString();
                System.out.println(responseString);


        valresp = r.then().log().all();
        valresp.statusCode(200);




    }

    @Description("TC#2 - Verify that create booking not working, with 500 Error")
    @Test
    public void testNonBDDStylePOSTNegative() {

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        String payload = "{}";

        rs.baseUri(BASE_URL)
                .basePath(BASE_PATH)
                .contentType(ContentType.JSON)
                .body(payload);

        r= rs.when().log().all().post();
        String responseString1=r.asString();
        System.out.println(responseString1);


        valresp=r.then().log().all();
        valresp.statusCode(200);

    }
}
