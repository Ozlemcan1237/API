package get_request_odev;

import base_urls.ZippopotamBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ZippopotamPlacesPojo;
import pojos.ZippopotamPojo;
import util.ObjectMapperUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetCanOdev extends ZippopotamBaseUrl {
    /*
        Given
            http://api.zippopotam.us/ES/01001
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrula
            {
    "post code": "01001",
    "country": "Spain",
    "country abbreviation": "ES",
    "places": [
        {
            "place name": "Vitoria-Gasteiz",
            "longitude": "-2.6667",
            "state": "Pais Vasco",
            "state abbreviation": "PV",
            "latitude": "42.85"
        }
    ]
}
     */

    @Test
    public void conOdev01() {

        spec.pathParams("first", "ES", "second", "01001");

        ZippopotamPlacesPojo zippopotamPlacesPojo = new ZippopotamPlacesPojo("Vitoria-Gasteiz", "-2.6667", "Pais Vasco", "PV", "42.85");
        ZippopotamPojo expectedData = new ZippopotamPojo("01001", "Spain", "ES", zippopotamPlacesPojo);
        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

//        ZippopotamPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),ZippopotamPojo.class); // [] PARANTEZI OLDUGU ICIN BU KISIM CALISMADI

        Map<String, Object> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getPost_code(), actualData.get("post code"));
        assertEquals(expectedData.getCountry(), actualData.get("country"));
        assertEquals(expectedData.getCountry_abbreviation(), actualData.get("country abbreviation"));

        assertEquals(zippopotamPlacesPojo.getPlace_name(), ((Map) ((List) actualData.get("places")).get(0)).get("place name"));
        assertEquals(zippopotamPlacesPojo.getLongitude(), ((Map) ((List) actualData.get("places")).get(0)).get("longitude"));
        assertEquals(zippopotamPlacesPojo.getState(), ((Map) ((List) actualData.get("places")).get(0)).get("state"));
        assertEquals(zippopotamPlacesPojo.getState_abbreviation(), ((Map) ((List) actualData.get("places")).get(0)).get("state abbreviation"));
        assertEquals(zippopotamPlacesPojo.getLatitude(), ((Map) ((List) actualData.get("places")).get(0)).get("latitude"));
    }
}
