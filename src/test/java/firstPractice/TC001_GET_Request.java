package firstPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {

	@Test
	void getWeatherCondition() {

		//just changed on git
		
		// Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Response Object
		Response response = httpRequest.request(Method.GET, "/Hyderabad"); //Hyderabad is path parameter

		// Response Body
		String body = response.getBody().asString();
		System.out.println("Body is:" + body);

		// Verify Status Code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		// Verify Status Line
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		// Header
		
		String responseHeader = response.getHeader(body);
		System.out.println("Header :"+responseHeader);
		
		
		// Tiem Taken
		long responseTime = response.getTime();
		System.out.println("response time :"+responseTime);
	}
}
