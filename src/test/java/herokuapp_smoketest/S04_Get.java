package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static herokuapp_smoketest.S01_Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S04_Get extends HerOkuAppBaseUrl {

    @Test
    public void get01() {
        spec.pathParams("first", "booking", "second", bookingId);

        String expectedData = "Not Found";

        Response response = given().
                spec(spec).
                when().
                get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(404, response.statusCode());
        assertEquals(expectedData, response.asString());
    }
}
