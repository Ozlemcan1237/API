package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {
/*
      Given
          https://restful-booker.herokuapp.com/booking/2279
      When
          I send GET Request to the url
      Then
          Response body should be like that;
           {
            "firstname": "John",
            "lastname": "Smith",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": "Breakfast"
            }
   */

    @Test
    public void get09() {
//        1.Adim
        spec.pathParams("first", "booking", "second", 794);

//        2.Adim
        Map<String, String> bookingdatesMap = new HashMap<>(); // once icteki map i yazmamiz gerekiyor INNER MAP
        bookingdatesMap.put("checkin", "2018-01-01");
        bookingdatesMap.put("checkout", "2019-01-01");

        Map<String, Object> ecpectedData = new HashMap<>();
        ecpectedData.put("firstname", "John");
        ecpectedData.put("lastname", "Smith");
        ecpectedData.put("totalprice", 111);
        ecpectedData.put("depositpaid", true);
        ecpectedData.put("bookingdates", bookingdatesMap);
        ecpectedData.put("additionalneeds", "Breakfast");

//        3.Adim
        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

//        4.Adim
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(ecpectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(ecpectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(ecpectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(ecpectedData.get("depositpaid"), actualData.get("depositpaid"));

//        bookingdates icindekiler obje oldugu icin nokta koyunca metotlar gelmiyor.O yuzden once map e ceviriyoruz
//        cevirdikten sonra nokta koyunca map metotlari geliyor ve islem yapabiliyoruz
        assertEquals(bookingdatesMap.get("checkin"), ((Map) actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"), ((Map) actualData.get("bookingdates")).get("checkout"));

        assertEquals(ecpectedData.get("additionalneeds"), actualData.get("additionalneeds"));
    }

    @Test // DINAMIK YONTEM
    public void get09b() {
//        1.Adim
        spec.pathParams("first", "booking", "second", 794);

//        2.Adim
        HerOkuAppTestData obj1 = new HerOkuAppTestData();
        Map<String, String> bookingdatesMap = obj1.bookingdatesMapMethod("2018-01-01","2019-01-01");

        Map<String, Object> ecpectedData = obj1.ecpectedDataMethod("John","Smith",111,true,bookingdatesMap,"Breakfast");

//        3.Adim
        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

//        4.Adim
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(ecpectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(ecpectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(ecpectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(ecpectedData.get("depositpaid"), actualData.get("depositpaid"));

//        bookingdates icindekiler obje oldugu icin nokta koyunca metotlar gelmiyor.O yuzden once map e ceviriyoruz
//        cevirdikten sonra nokta koyunca map metotlari geliyor ve islem yapabiliyoruz
        assertEquals(bookingdatesMap.get("checkin"), ((Map) actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"), ((Map) actualData.get("bookingdates")).get("checkout"));

        assertEquals(ecpectedData.get("additionalneeds"), actualData.get("additionalneeds"));
    }
}
