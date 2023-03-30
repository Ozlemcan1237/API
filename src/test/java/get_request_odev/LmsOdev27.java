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
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

//        There are 24 employees
        JsonPath jsonPath = response.jsonPath();

        List<Integer> ids = response.jsonPath().getList("data.id");

        int idSayisi = 0;
        for (Integer w : ids) {
            idSayisi++;
        }
        System.out.println("idSayisi = " + idSayisi);

//        Assertion 1
        List<String> names = response.jsonPath().getList("data.employee_name");
        System.out.println("names = " + names);
        assertTrue(names.contains("Tiger Nixon"));
        assertTrue(names.contains("Garrett Winters"));

//        Assertion 2
        response.then()
                .contentType(ContentType.JSON)
                .body("data.employee_name",hasItem("Tiger Nixon"));

        response.then()
                .contentType(ContentType.JSON)
                .body("data.employee_name",hasItem("Garrett Winters"));

//        The greatest age is 66
        List<Integer> ages = response.jsonPath().getList("data.findAll{it.employee_age>65}.employee_age");
        System.out.println("ages = " + ages);

//        The name of the lowest age is "Tatyana Fitzpatrick"
        List<Integer> enKucukYas = response.jsonPath().getList("data.findAll{it.employee_age<20}.employee_age");
        System.out.println("enKucukYas = " + enKucukYas);

//        Total salary of all employees is 6,644,770
        List<Integer> salary = response.jsonPath().getList("data.employee_salary");
        System.out.println("salary = " + salary);

        int toplam=0;
        for (Integer w:salary){
            toplam+=w;
        }
        System.out.println(toplam);
    }
}
