import static org.testng.Assert.assertEquals;

import java.util.LinkedHashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredTests {
	private RequestSpecification httpRequest;
	
  @Test
  public void verifyJanetEmail() {
	  var expectedId = "2";
	  var expectedEmail = "janet.weaver@reqres.in";
	  
	  Response response = httpRequest.get("https://reqres.in/api/users/2");
	  JsonPath jsonPathEvaluator = response.jsonPath();
	  LinkedHashMap<String, String> data = jsonPathEvaluator.get("data");
	  
	  var actualId = String.valueOf(data.get("id"));
	  var actualEmail = data.get("email");
	  
	  assertEquals(actualId, expectedId, "Invalid id");
	  assertEquals(actualEmail, expectedEmail, "Invalid email");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  RestAssured.baseURI = "https://reqres.in/";
	  httpRequest = RestAssured.given();
  }
}
