package get_request_odev;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import util.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetCanOdev3 extends GoRestBaseUrl {
    /*
        Given
           https://gorest.co.in/public/v2/posts/4647
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrula
{
        "id": 4647,
        "user_id": 366048,
        "title": "Triumphus usus tantillus abscido usque et facilis.",
        "body": "Vultuosus delectatio vergo. Vomito demo appono. Nam dolorum coerceo. Ut ullam appono. Culpo adstringo deduco. Degusto conscendo crepusculum. Crinis canto nulla. Arbitro quia condico. Mollitia ut temperantia. Cuppedia stultus volubilis. Ante totus arto. Toties tener pecunia. Tristis commodo sub. Apto calamitas amaritudo. Aduro curo consuasor. Callide pecco venia. Delego tergeo adsuesco. Tabula aestus decerno. Virtus adflicto deripio."
    },
    {
    "id": 174,
    "user_id": 612,
    "title": "Tertius valeo sint est vesica doloribus rerum casus cetera nisi sapiente vigor pecus voluptas asperiores et sto vapulus.",
    "body": "Et demens tergo. Cohors copia adeptio. Cotidie speciosus coaegresco. Concido crastinus degero. Tristis fugit supellex. Sustineo cogo odit. Pel patria crur. Amplus comitatus modi. Ater omnis solutio. Voluptatem acies unde. Taceo delinquo ustilo. Alo possimus vaco. Sit cognomen thesaurus. Appositus vel amicitia. Cetera textus defungo."
}
     */

    @Test
    public void name() {
        spec.pathParams("first", "posts", "second", 4647);

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("user_id", 366048);
        expectedData.put("title", "Triumphus usus tantillus abscido usque et facilis.");
        expectedData.put("body", "Vultuosus delectatio vergo. Vomito demo appono. Nam dolorum coerceo. " +
                "Ut ullam appono. Culpo adstringo deduco. Degusto conscendo crepusculum." +
                " Crinis canto nulla. Arbitro quia condico. Mollitia ut temperantia. Cuppedia stultus volubilis." +
                " Ante totus arto. Toties tener pecunia. Tristis commodo sub. Apto calamitas amaritudo. Aduro curo consuasor." +
                " Callide pecco venia. Delego tergeo adsuesco. Tabula aestus decerno. Virtus adflicto deripio.");
        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("user_id"), ((Map)actualData.get("data")).get("user_id"));
        assertEquals(expectedData.get("title"),((Map)actualData.get("data")).get("title"));
        assertEquals(expectedData.get("body"), ((Map)actualData.get("data")).get("body"));

    }
}
