import static org.testng.Assert.assertEquals;

import java.util.LinkedHashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredTests {

	@Test
	public void verifyJanetEmail() {
		var expectedId = "2";
		var expectedEmail = "janet.weaver@reqres.in";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("https://reqres.in/api/users/2");
		JsonPath jsonPathEvaluator = response.jsonPath();
		LinkedHashMap<String, String> data = jsonPathEvaluator.get("data");

		var actualId = String.valueOf(data.get("id"));
		var actualEmail = data.get("email");

		assertEquals(actualId, expectedId, "Invalid id");
		assertEquals(actualEmail, expectedEmail, "Invalid email");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void verifyTokenReturnValue() {
		var expectedToken = "QpwL5tke4Pnpja7X4";

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject(); 
		requestParams.put("email", "eve.holt@reqres.in"); 
		requestParams.put("password", "cityslicka");

		request.header("Content-Type", "application/json"); 
		request.body(requestParams.toJSONString());

		Response response = request.post("https://reqres.in/api/login");
		JsonPath jsonPathEvaluator = response.jsonPath();

		var actualToken = jsonPathEvaluator.get("token");

		assertEquals(actualToken, expectedToken, "Invalid token");
	}

	@Test
	public void verifyDeleteResponseCode() {
		var expectedCode = 204;

		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.delete("https://reqres.in/api/users/2");

		int actualCode = response.getStatusCode();

		assertEquals(actualCode, expectedCode, "Invalid code");
	}

	@BeforeMethod
	public void beforeMethod() {
		RestAssured.baseURI = "https://reqres.in/";
	}
}
