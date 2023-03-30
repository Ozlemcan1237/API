package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get03_HamcrestMacher {
/*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
 */

    //          i)    Set the URL
    //           ii)   Set the expected data
    //           iii)  Send the request and get the response
    //           iv)   Do assertion

    @Test
    public void get03(){
        String url = " https://jsonplaceholder.typicode.com/todos/23";
        Response response = given().when().get(url);
        response.prettyPrint();

//        1.yol hard assertion
        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(2));

//        2.yol soft assertion
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("Xet itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                        "userId",equalTo(21));

//        Tek body icerisinde coklu assertion yaparak soft assertion olusturabilirsiniz.
//        Fail durumunda body() icerisinde Java calismayi durdurmaz
//        Coklu body() method'u ile asserion yapildiginda fail durumunda Java
//        birsonraki body() method'u oncesi calismayi durdurur
    }
}
/*
   Api üzerinde Body içerisinde yer almayan değerler için herhangi bir ekstra methoda gerek duymadan assert yapılırken,
   Body içerisinde yer alan değerler için body() methodu ile birlikte Matchers kullanılarak assert yapılır.
*/