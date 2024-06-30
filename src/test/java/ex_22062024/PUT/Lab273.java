package ex_22062024.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab273 {

    RequestSpecification rs= RestAssured.given();
    Response res;
    ValidatableResponse valresp;
    String BASE_URL = "http://restful-booker.herokuapp.com";

    String payload= "{\n" +
            "    \"firstname\" : \"Bhushan\",\n" +
            "    \"lastname\" : \"Choudhary\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    String  bookingID="/2925";
    String token="46c0013c13f594c";
    String BASE_PATH= "/booking"+bookingID;

@Description("Verifying the patch Request using non BDD Style")
    @Test
    public void testpatchrequestnonbddstyle(){

    rs.baseUri(BASE_URL);
            rs.basePath(BASE_PATH);
                    rs.contentType(ContentType.JSON);
                            rs.cookie("token",token);
                                    rs.body(payload).log().all();
                                    res=rs.when().log().all().put();
    valresp=res.then().log().all();
    valresp.statusCode(200);

    valresp.body("firstname", Matchers.equalTo("Bhushan"));
    valresp.body("lastname", Matchers.equalTo("Choudhary"));


}


}
