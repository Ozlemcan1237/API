package get_request_odev;

import base_urls.SwaggerBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class OdevPetStoreLms extends SwaggerBaseUrl {
    /*
   https://petstore.swagger.io/ dokumanını kullanarak statüsü "available" olan "pet" sayısını bulup
    100'den fazla olduğunu assert eden bir otomasyon testi yazınız.
    https://petstore.swagger.io/v2/pet/findByStatus?status=available
     */

    @Test
    public void petStore01() {
        spec.pathParams("first", "pet", "second", "findByStatus").queryParams("status", "available");

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        List<Object> petSayisi = jsonPath.getList("findAll{it.status='available'}.status");

        System.out.println("petSayisi = " + petSayisi);
        System.out.println("petSayisi.size() = " + petSayisi.size());

        assertTrue(petSayisi.size() > 100);
    }
}
