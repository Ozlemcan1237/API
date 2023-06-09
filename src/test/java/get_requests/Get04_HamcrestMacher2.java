package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get04_HamcrestMacher2 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

    //           i)    Set the URL
    //           ii)   Set the expected data
    //           iii)  Send the request and get the response
    //           iv)   Do assertion

    @Test
    public void get04(){
//        String url ="https://jsonplaceholder.typicode.com/todos";
        spec.pathParam("first","todos");

        Response response  = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id",hasSize(200),
                        "title",hasItem("quis eius est sint explicabo"),
                        "userId",hasItems(2,7,9));
//        hasSize() --> Eleman sayisini assert eder
//        hasItem --> contains() gibi objenin icerilip icerilmedigini assert eder
//        hasItems --> containsAll() gibi birden fazla objenin icerilip icerilmedigini assert eder
    }
}
