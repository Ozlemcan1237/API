package get_requests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get02_NegatifSenaryo {
/*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */
    @Test
    public void get02(){
//        1. Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/0";

//        2. Set the expected data -->post,put,patch

//        3. Send the request get the response
        try {
            Response response= given().when().get(url);
        } catch (Exception e) {
            assert e.getMessage().contains("404");
            assert e.getMessage().contains("Not Found");
            Assert.assertFalse(e.getMessage().contains("TechProEd"));
        }
//        Response response = given().with().get(url);
//        response.prettyPrint();
//
////        4. Do Assertion
//        response.
//                then().
//                statusCode(404).
//                statusLine("HTTP/1.1 404 Not Found");
//
////        Response body contains "Not Found"
//        assertTrue(response.asString().contains("Not Found"));
//
////        Response body does not contain "TechProEd"
//        assertFalse(response.asString().contains("TechProEd"));
//
////        Server is "Cowboy"
//        assertEquals("Cowboy",response.header("Server"));
//
  }

}
