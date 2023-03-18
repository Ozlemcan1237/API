package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get10 extends GoRestBaseUrl {
/*
        Given
            https://gorest.co.in/public/v1/users/128529
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like

{
    "meta": null,
    "data": {
        "id": 156660,
        "name": "Ms. Ahalya Prajapat",
        "email": "ahalya_prajapat_ms@hand-reilly.biz",
        "gender": "female",
        "status": "inactive"
    }
}
 */

    @Test
    public void get10() {
        spec.pathParams("first", "users", "second", 156660);

        GoRestTestData obj = new GoRestTestData();
        Map<String, String> dataMap = obj.dataMapMethod("Ms. Ahalya Prajapat", "ahalya_prajapat_ms@hand-reilly.biz", "female", "inactive");

        Map<String, Object> expectedData = obj.expectedDataMapMethod(null, dataMap);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("name"), actualData.get("name"));
        assertEquals(expectedData.get("email"), actualData.get("email"));
        assertEquals(expectedData.get("gender"), actualData.get("gender"));
        assertEquals(expectedData.get("status"), actualData.get("status"));
        assertEquals(expectedData.get("meta"), actualData.get("meta"));
    }
}
