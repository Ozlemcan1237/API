package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13 extends GoRestBaseUrl {
   /*
        Given
            https://gorest.co.in/public/v1/users/247158
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
         {
    "meta": null,
    "data": {
        "id": 247152,
        "name": "Ujjwal Bandopadhyay",
        "email": "ujjwal_bandopadhyay@mueller-schoen.net",
        "gender": "male",
        "status": "active"
       }
          }
    */

    @Test
    public void get13() {
        spec.pathParams("first", "users", "second", 247152);

//        SET THE EXPECTED DATA
        GoRestDataPojo goRestDataPojo = new GoRestDataPojo("Ujjwal Bandopadhyay", "ujjwal_bandopadhyay@mueller-schoen.net", "male", "active");
        GoRestPojo expectedData = new GoRestPojo(null, goRestDataPojo);
        System.out.println("expectedData = " + expectedData);

//        send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

//        Do Assertion
        GoRestPojo actualData = response.as(GoRestPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(goRestDataPojo.getName(), actualData.getData().getName());
        assertEquals(goRestDataPojo.getEmail(), actualData.getData().getEmail());
        assertEquals(goRestDataPojo.getGender(), actualData.getData().getGender());
        assertEquals(goRestDataPojo.getStatus(), actualData.getData().getStatus());
        assertEquals(expectedData.getMeta(), actualData.getMeta());


    }
}
