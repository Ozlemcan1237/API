package get_request_odev;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCreate {
    /*
   "https://petstore.swagger.io/" dökümanını kullanarak 'user' oluşturacak bir otomasyon testi yazınız
    Not: Test Case'i gherkin language ile yazınız.
*/


        @Test
        public void userCreateTest() {
                RestAssured.baseURI="https://petstore.swagger.io/v2";

                RequestSpecification request = given().contentType(ContentType.JSON).body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"Van Kedisi\",\n" +
                        "  \"firstName\": \"Van\",\n" +
                        "  \"lastName\": \"Kedisi\",\n" +
                        "  \"email\": \"cat@cats.com\",\n" +
                        "  \"password\": \"54321\",\n" +
                        "  \"phone\": \"987654321\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}");
        }

        //    Feature: User Creation
//    As a user of the Swagger Petstore API
//    I want to be able to create a new user account
//    So that I can use the API to manage my pets
//
//    Scenario: Create a new user account
//    Given I have access to the Swagger Petstore API
//    When I submit a request to create a new user with the following details:
//            | Field         | Value        |
//            | id            | 12345        |
//            | username      | testuser     |
//            | firstName     | Test         |
//            | lastName      | User         |
//            | email         | test@test.com|
//            | password      | password123 |
//            | phone         | 1234567890   |
//            | userStatus    | 0            |
//    Then the API should respond with a success status code of 200
//    And the response should include the created user's details
//            | Field         | Value        |
//            | id            | 12345        |
//            | username      | testuser     |
//            | firstName     | Test         |
//            | lastName      | User         |
//            | email         | test@test.com|
//            | phone         | 1234567890   |
//            | userStatus    | 0            |
//
//
//            import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//    public class UserCreationTest {
//
//        @Test
//        public void testCreateNewUser() {
//            // Base URL for the Swagger Petstore API
//            RestAssured.baseURI = "https://petstore.swagger.io/v2";
//
//            // Request Specification
//            RequestSpecification request = RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .body("{\n" +
//                            "  \"id\": 12345,\n" +
//                            "  \"username\": \"testuser\",\n" +
//                            "  \"firstName\": \"Test\",\n" +
//                            "  \"lastName\": \"User\",\n" +
//                            "  \"email\": \"test@test.com\",\n" +
//                            "  \"password\": \"password123\",\n" +
//                            "  \"phone\": \"1234567890\",\n" +
//                            "  \"userStatus\":

        }
