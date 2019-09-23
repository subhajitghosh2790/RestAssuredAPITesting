package firstPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Request_ValidationJSONResponse {

	@Test
	void verifyResponseBody() {
		
		//Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Create Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Create Response Object
		Response response = httpRequest.request(Method.GET, "Delhi");
		
		//Validate Response Code
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Validate Response Body
		String responseBody = response.getBody().asString();
		
		Assert.assertEquals(responseBody.contains("Hyderabad"), true);
	}
}
