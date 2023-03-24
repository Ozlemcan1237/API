package delete_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import util.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Delete01 extends JsonPlaceHolderBaseUrl {
    /*
     Given
         https://jsonplaceholder.typicode.com/todos/198
     When
         I send DELETE Request to the Url
     Then
         Status code is 200
     And Response body is { }
  */

    @Test
    public void delete01() {
        spec.pathParams("first", "todos", "second", 198);

        Map<String, String> expectedData = new HashMap<>();

        Response response = given().spec(spec).delete("/{first}/{second}");
        response.prettyPrint();

        Map<String, String> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(200, response.statusCode());

        assertEquals(expectedData, actualData); //1.YOL

        assertTrue(actualData.isEmpty()); //2.YOL
    }
}
