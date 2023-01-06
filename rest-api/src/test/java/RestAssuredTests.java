import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Set;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RestAssuredTests<JSONSuccessResponse> {

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
		// code 204 indicates that the server has successfully fulfilled the request and that there 
		// is no content to send in the response payload body.
		var expectedCode = 204;

		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.delete("https://reqres.in/api/users/2");

		int actualCode = response.getStatusCode();

		assertEquals(actualCode, expectedCode, "Invalid code");
	}

	@Test
	public void morpheusPatch() {
		String requestBody = "{\n" +
				"  \"name\": \"Morpheus2\" \n}";

		RequestSpecification request = RestAssured.given();

		Response responseBefore = request.patch("/api/users/2");
		JsonPath jsonPathEvaluator = responseBefore.jsonPath();
		
		var nameBefore = jsonPathEvaluator.get("name");
		var updatedBefore = jsonPathEvaluator.get("updatedAt");

		Response responseAfter = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.patch("https://reqres.in/api/users/2")
				.then()
				.extract().response();

		var nameAfter = responseAfter.jsonPath().getString("name");
		var updatedAfter = responseAfter.jsonPath().getString("updatedAt");
		
		assertTrue(nameBefore != nameAfter, "Invalid name change");
		assertTrue(((String)updatedBefore).compareTo(updatedAfter) < 0, "Invalid timestamp change");
	}

	@Test
	public void morpheusPut() {
		String requestBody = "{\n" +
	            "  \"name\": \"Morpehus2\",\n" +
	            "  \"job\": \"zion resident\" \n}";
		
		RequestSpecification request = RestAssured.given();

		Response responseBefore = request.patch("/api/users/2");
		JsonPath jsonPathEvaluator = responseBefore.jsonPath();
		
		var nameBefore = jsonPathEvaluator.get("name");
		var updatedBefore = jsonPathEvaluator.get("updatedAt");
		
		Response responseAfter = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .extract().response();
		
		var nameAfter = responseAfter.jsonPath().getString("name");
		var updatedAfter = responseAfter.jsonPath().getString("updatedAt");
		
		assertTrue(nameBefore != nameAfter, "Invalid name change");
		assertTrue(((String)updatedBefore).compareTo(updatedAfter) < 0, "Invalid timestamp change");
	}
	
	@Test
	public void deserializeSingleUser() {
		var expectedId = "2";
		var expectedEmail = "janet.weaver@reqres.in";
		var expectedFirstName = "Janet";
		var expectedLastName = "Weaver";
		var expectedAvatar = "https://reqres.in/img/faces/2-image.jpg";
		
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("https://reqres.in/api/users/2");
		JsonPath jsonPathEvaluator = response.jsonPath();
		LinkedHashMap<String, String> userData = jsonPathEvaluator.get("data");
		
		Data data = new Data(String.valueOf(userData.get("id")),
				userData.get("email"),
				userData.get("first_name"),
				userData.get("last_name"),
				userData.get("avatar"));
		
		assertEquals(data.getId(), expectedId, "Invalid id");
		assertEquals(data.getEmail(), expectedEmail, "Invalid email");
		assertEquals(data.getFirstName(), expectedFirstName, "Invalid first name");
		assertEquals(data.getLastName(), expectedLastName, "Invalid last name");
		assertEquals(data.getAvatar(), expectedAvatar, "Invalid avatar");
	}
	
	@Test
	public void deserializeMultiUsers() {
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		RestAssured.baseURI = "https://reqres.in/";
	}
}
