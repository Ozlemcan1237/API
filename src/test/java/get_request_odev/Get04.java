package get_request_odev;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get04 extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Jane&lastname=Doe
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Jane" and lastname is "Doe"
     */

    @Test
    public void get04() {
        spec.pathParam("first","booking")
                .queryParams("firstname","Jane","lastname","Doe");

        Response response = given().spec(spec).when().get("{first}");
        response.prettyPrint();

        response.then().statusCode(200);

        assertTrue(response.asString().contains("bookingid")); // ?
    }
}
