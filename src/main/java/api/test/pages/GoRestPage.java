package api.test.pages;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;

import java.io.IOException;

import api.test.utils.BasePage;
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
		BasePage.takeScreenshot(response, endpoint);
	}

	public void validateResponsePageWithListUsers(String page) throws IOException {
		System.out.println("Validate Response Page List" + page);
		response.then().statusCode(200).log().body()
		.body("id", everyItem(notNullValue()))
	    .body("name", everyItem(notNullValue()))
	    .body("email", everyItem(notNullValue()))
	    .body("gender", everyItem(notNullValue()))
	    .body("status", everyItem(notNullValue()));
		BasePage.takeScreenshot(response, page);
	}
	
	

}
