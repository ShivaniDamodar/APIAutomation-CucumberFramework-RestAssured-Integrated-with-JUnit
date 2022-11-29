package stepDefinations;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.juneau.json.JsonSerializer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import users.pojo.GeneratePayload;
import users.pojo.Users;
import utilities.CommonUtilities;

public class StepDefination1 extends CommonUtilities {

	RequestSpecification reqspec;

	ResponseSpecification resp;

	Response response;

	@Given("Add users payload {string}")

	public void add_users_payload (String name) throws IOException {
		GeneratePayload addpayload = new GeneratePayload();
		reqspec = RestAssured.given().spec(RequestSpecification()).body(addpayload.GeneratePayloadForUser(name));

	}
	
	
	 

	@When("userAPI calls users with post http request")
	public void user_api_calls_users_with_post_http_request() throws IOException {
		response = reqspec.when().post(getPropertyValue("postAPI")).then().spec(ResponseSpecification()).extract()
				.response();

	}

	@Then("the userAPI call is success with status code {int}")
	public void the_user_api_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 201);
		System.out.println(response.asPrettyString());
	}

	@Then("Then test {string} is {string}")
	public void then_test_is(String key, String value) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		assertEquals(js.get(key).toString(), value);
		System.out.println(js.get(key) + " " + value);
	}

}
