package get_request_odev;

import base_urls.Covid19BaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import util.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetCanOdev2_MapObjectMapper extends Covid19BaseUrl {
    /*
        Given
           https://api.covid19api.com/world/total
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrula
 {
    "TotalConfirmed": 674300771,
    "TotalDeaths": 6793224,
    "TotalRecovered": 0
}
     */

    @Test
    public void get01() {
        spec.pathParams("first", "world", "second", "total");

        Map<String, Integer> expectedData = new HashMap<>();
        expectedData.put("TotalConfirmed", 674300771);
        expectedData.put("TotalDeaths", 6793224);
        expectedData.put("TotalRecovered", 0);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String, Integer> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("TotalConfirmed"), actualData.get("TotalConfirmed"));
        assertEquals(expectedData.get("TotalDeaths"), actualData.get("TotalDeaths"));
        assertEquals(expectedData.get("TotalRecovered"), actualData.get("TotalRecovered"));
    }
}
