package api.test.pages;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;

import java.io.IOException;
import java.util.List;

import org.hamcrest.Matchers;

import api.test.utils.BasePage;
import api.test.utils.Hooks;
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

	
	

}
