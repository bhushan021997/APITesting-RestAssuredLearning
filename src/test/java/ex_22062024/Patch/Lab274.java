package ex_22062024.Patch;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab274 {

    RequestSpecification rs= RestAssured.given();
    Response res;
    ValidatableResponse valresp;

    @Test
    public void testingpatchrequestusingnonbddstyle(){

        String token = "eb70727fc241dc6";
        String bookingid = "/1218";

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        String payload="{\n" +
                "    \"firstname\": \"Mahesh\",\n" +
                "    \"lastname\": \"Paradkar\",\n" +
                "}";

        String basepath_Updated=BASE_PATH+bookingid;
        System.out.println(basepath_Updated);

        rs.baseUri(BASE_URL);
        rs.basePath(basepath_Updated);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload);

        res=rs.when().log().all().patch();

        valresp =res.then().log().all();
        valresp.statusCode(200);

        valresp.body("firstname", Matchers.equalTo("Mahesh"));
        valresp.body("firstname", Matchers.equalTo("Paradkar"));



    }













































}
