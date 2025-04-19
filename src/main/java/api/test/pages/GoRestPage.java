package api.test.pages;

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

	public void validateResponsePageWithListUsers(String page) {
		System.out.println("Validate Response Page List");
		response.then().log().all().statusCode(200);
	}
	
	

}
