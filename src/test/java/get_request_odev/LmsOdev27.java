package get_request_odev;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponseBodyPojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class LmsOdev27 extends DummyRestApiBaseUrl {

     /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language

           Assert:  i) Status code is 200
                    ii) There are 24 employees
                   (HamcrestMatcher kullanarak 24 employees olduğunu doğrulayınız)
                    iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   (HamcrestMatcher kullanarak "Tiger Nixon" ve "Garrett Winters"'ın employees arasında olduğunu doğrulayınız' )
                    iv) The greatest age is 66
                   (En büyük yaşın 66 olduğunu doğrulayınız)
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   (En düşük yaşın isminin Tatyana Fitzpatrick olduğunu doğrulayınız)
                    vi) Total salary of all employees is 6,644,770
                   (Tüm employees salary toplamının  6,644,770 olduğunu doğrulayınız)

    Given
        https://dummy.restapiexample.com/api/v1/employees
    Then
        Status code is 200
    Then
       There are 24 employees
    And
       "Tiger Nixon" and "Garrett Winters" are among the employees
   And
        The greatest age is 66
    And
        The name of the lowest age is "Tatyana Fitzpatrick"
    And
        Total salary of all employees is 6,644,770

        {
    "status": "success",
    "data": [
        {
            "id": 1,
            "employee_name": "Tiger Nixon",
            "employee_salary": 320800,
            "employee_age": 61,
            "profile_image": ""
        },
{
            "id": 2,
            "employee_name": "Garrett Winters",
            "employee_salary": 170750,
            "employee_age": 63,
            "profile_image": ""
        },
    */

    @Test
    public void dummyTest() {
        spec.pathParams("first", "api", "second", "v1", "third", "employees");

        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        assertEquals(200, response.statusCode());

        JsonPath jsonPath = response.jsonPath();

        List<Integer> ids = response.jsonPath().getList("data.id");

        int idSayisi = 0;
        for (Integer w : ids) {
            idSayisi++;
        }
        System.out.println("idSayisi = " + idSayisi);

//        response.then()
//                .contentType(ContentType.JSON)
//                .body("data.employee_name",equalTo("Tiger Nixon"));
//
//        response.then()
//                .contentType(ContentType.JSON)
//                .body("data.employee_name",equalTo("Garrett Winters"));

    }
}
/*
 response.
                then().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(2));

 */