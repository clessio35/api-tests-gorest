package api.test.pages;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.json.JSONObject;

import com.github.javafaker.Faker;

import api.test.utils.BasePage;
import api.test.utils.Hooks;
import api.test.utils.Token;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GoRestPage {
	
	private Response response;

	public void accessApi(String url) throws IOException {
		System.out.println("ACCESS API");
		RestAssured.baseURI = url;
	}

	public void requestGETMethod(String endpoint) throws IOException {
		System.out.println("REQUEST GET METHOD");
		response = RestAssured.given().log().all()
			.contentType(ContentType.JSON)
			.when().get(endpoint);
		BasePage.takeScreenshot(response, Hooks.getScenarioName());
	}

	public void validateResponsePageWithListUsers(String page) throws IOException {
		System.out.println("Validate Response Page List" + page);
		response.then().statusCode(200).log().body()
		.body("id", everyItem(notNullValue()))
	    .body("name", everyItem(notNullValue()))
	    .body("email", everyItem(notNullValue()))
	    .body("gender", everyItem(notNullValue()))
	    .body("status", everyItem(notNullValue()));
		BasePage.takeScreenshot(response, Hooks.getScenarioName());
	}
	
	public int getFirstUserId() {
		response = RestAssured.given().log().all().contentType(ContentType.JSON).when()
				.get("/users");
		response.then().statusCode(200);
		List<Integer> ids = response.jsonPath().getList("id");
		System.out.println("ids List" + ids);
		return ids.stream().findFirst().orElse(-1);
	}

	public void requestGETMethodWithId(String endpoint) throws IOException {
		System.out.println("REQUEST GET METHOD");
		int userId = getFirstUserId();
		response = RestAssured.given().log().all()
			.contentType(ContentType.JSON)
			.when().get(endpoint + userId);
		BasePage.takeScreenshot(response, Hooks.getScenarioName());
	}

	public void validateResponseUserSpecific() throws IOException {
		int id = response.jsonPath().getInt("id");
		System.out.println("Validate Response User specific -> " + id);
		response.then().statusCode(200).log().body()
		.body("id", Matchers.equalTo(id));
		BasePage.takeScreenshot(response, Hooks.getScenarioName());
	}

	public void validateResponseWithErrorUserNonExistent(String status) throws IOException {
		System.out.println("Validate user nonExistent");
		int sc = Integer.parseInt(status);
		response.then().log().body().statusCode(sc)
			.body("message", Matchers.equalTo("Resource not found"));
		BasePage.takeScreenshot(response, Hooks.getScenarioName());
	}
	
	public JSONObject payload() {
		System.out.println("DATA FAKE");
		Faker fake = new Faker();
		HashMap<String, Object> user = new HashMap<String, Object>();
		user.put("name", fake.name().fullName());
		user.put("email", fake.internet().emailAddress());
		String gender = fake.options().option("male", "female");
		user.put("gender", gender);
		user.put("status", "active");
		JSONObject json = new JSONObject(user);
		return json;
	}

	public void sendPostRequestWithData(String endpoint) throws IOException {
		System.out.println("Send Post request with fixed userdata");
		String token = Token.getApiToken();
		
		response = RestAssured.given().log().all().header("Authorization", "Bearer " + token)
			.contentType(ContentType.JSON)
			.body(payload().toString())
			.when().post(endpoint);
		BasePage.takeScreenshot(response, Hooks.getScenarioName());
	}

	public void validateResponseOfRequestPostWithFixedUserData() throws IOException {
		System.out.println("Validate Request Post with fixed user data");
		response.then().statusCode(201).log().body()
			.body("name", Matchers.not(Matchers.emptyOrNullString()))
			.body("email", Matchers.not(Matchers.emptyOrNullString()))
			.body("gender", Matchers.not(Matchers.emptyOrNullString())).extract().body();
		int id = response.jsonPath().getInt("id");
		response.then().body("id", Matchers.equalTo(id));
		BasePage.takeScreenshot(response, Hooks.getScenarioName());
	}

	public void sendPostRequestWithFixedUserData(String endpoint, String name, String email, String gender,
			String status) {
		// TODO Auto-generated method stub
		
	}
	
	public void validateReturnOfResponseWithError() {
		// TODO Auto-generated method stub
		
	}


	
	

}
