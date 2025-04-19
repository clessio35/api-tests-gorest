package api.test.pages;

import java.io.IOException;

import api.test.utils.BasePage;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GoRestPage {
	
	private Response response;

	public void accessApi(String url) throws IOException {
		System.out.println("ACCESS API");
		RestAssured.baseURI = url;
		BasePage.takeScreenshot(response, url);
	}

	public void requestGETMethod(String endpoint) {
		// TODO Auto-generated method stub
		
	}
	
	

}
