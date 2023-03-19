package get_request_odev;

import base_urls.RegresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get06 extends RegresBaseUrl {
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
              (Tüm pantone_value değerlerini yazdırınız)
            3)Print all ids greater than 3 on the console
              (3'ten büyük id'leri yazdırınız)
              Assert that there are 3 ids greater than 3
              (3'ten büyük 3 adet id olduğunu doğrulayınız)
            4)Print all names whose ids are less than 3 on the console
              (id'si 3'ten küçük isimleri yazdırınız)
              Assert that the number of names whose ids are less than 3 is 2
              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
    */

    @Test
    public void get06() {
        spec.pathParam("first", "unknown");

        Response response = given().spec(spec).get("{first}");
        response.prettyPrint();

        assertEquals(200, response.statusCode());

//        Print all pantone_values
        JsonPath jsonPath = response.jsonPath();
        List<String> valueList = jsonPath.getList("data.findAll{it.id>0}.pantone_value");
        System.out.println("valueList = " + valueList);

//        Print all ids greater than 3 on the console
        List<Object> idUctenBuyukList = jsonPath.getList("data.findAll{it.id>3}");
        System.out.println("idUctenBuyukList = " + idUctenBuyukList);

//        Assert that there are 3 ids greater than 3
        assertEquals(3, idUctenBuyukList.size());

//        Print all names whose ids are less than 3 on the console
        List<String> idUctenKucukName = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("idUctenKucukName = " + idUctenKucukName);

//        Assert that the number of names whose ids are less than 3 is 2
        assertEquals(2, idUctenKucukName.size());
    }
}
