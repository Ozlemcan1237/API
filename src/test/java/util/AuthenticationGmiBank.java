package util;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationGmiBank {
    /*
          {
          "password": "string",
          "rememberMe": true,
          "username": "string"
          }
           */
    public static String generateToken() {

        String url = "https://gmibank.com/api/authenticate";

        Map<String, Object> tokenBody = new HashMap<>();
        tokenBody.put("password", "Batch.103");
        tokenBody.put("rememberMe",true);
        tokenBody.put("username", "batch_yuzuc");

        Response response = given().contentType(ContentType.JSON).body(tokenBody).when().post(url);

        return response.jsonPath().getString("id_token");
    }
}
