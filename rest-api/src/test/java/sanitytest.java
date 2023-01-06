import java.util.LinkedHashMap;

import javax.print.attribute.standard.DateTimeAtProcessing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class sanitytest {
  @Test
  public void f() {
	  RestAssured.baseURI = "https://reqres.in/";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.get("https://reqres.in/api/users/2");
	  ResponseBody body = response.getBody();
	  String bodyAsString = body.asString();
	  System.out.println(bodyAsString);
	  JsonPath jsonPathEvaluator = response.jsonPath();
	  LinkedHashMap<String, String> data = jsonPathEvaluator.get("data");
	  String id = jsonPathEvaluator.get("id");
	  String email = jsonPathEvaluator.get("email");
	  System.out.println(data);
	  System.out.println(id + " " + email);
	  System.out.println("answer-email=" + data.get("email"));
	  System.out.println("answer-id=" + String.valueOf(data.get("id")));
  }
}
