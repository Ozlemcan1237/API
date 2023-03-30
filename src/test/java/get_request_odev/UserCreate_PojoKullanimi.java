package get_request_odev;

import base_urls.SwaggerBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.SwaggerPojo;
import pojos.SwaggerSonucPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserCreate_PojoKullanimi extends SwaggerBaseUrl {
    /*
   "https://petstore.swagger.io/" dökümanını kullanarak 'user' oluşturacak bir otomasyon testi yazınız
    Not: Test Case'i gherkin language ile yazınız.

        Given
            1) https://petstore.swagger.io/v2/user
            2) {
                  "username": "JohnDoe",
                  "firstName": "John,",
                  "lastName": "Doe",
                  "email": "john@doe.com",
                  "password": "1234",
                  "phone": "1234",
                  "userStatus": 123
                }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "code": 200,
                                                "type": "unknown",
                                                "message": "6874988058"
                                             }
     */

    @Test
    public void userCreateTest() {
        spec.pathParam("first", "user");

        SwaggerPojo expectedData = new SwaggerPojo("JohnDoe", "John", "Doe", "john@doe.com", "1234", "1234", 123);
        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec).when().body(expectedData).post("{first}");
        response.prettyPrint();

        SwaggerSonucPojo actualData = response.as(SwaggerSonucPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertTrue(actualData.getCode().toString().contains("200"));
        assertTrue(actualData.getType().contains("unknown"));
    }
}
