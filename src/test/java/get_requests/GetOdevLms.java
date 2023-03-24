package get_requests;

import base_urls.AutomationExerciseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.Assert;
import org.junit.Test;
import util.ObjectMapperUtils;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetOdevLms extends AutomationExerciseBaseUrl {

/*
	Given
		https://automationexercise.com/api/productsList
	When
		User sends Get request
	Then
		Assert that number of "Women" usertype is 12
		(Kadın usertype sayısının 12 olduğunu doğrulayın)

*/

    @Test
    public void test01() {
        spec.pathParams("first", "api", "second", "productsList");

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.jsonPath().prettyPrint(); //kodlar html formatinda geldigi icin bu sekilde json a cevirdik

        JsonPath jsonPath = response.jsonPath();

        int usertypeWomenSayisi = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}").size();
        assertEquals(12,usertypeWomenSayisi);
    }
}
