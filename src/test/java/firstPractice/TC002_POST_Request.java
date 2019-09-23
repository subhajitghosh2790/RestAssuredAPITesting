package firstPractice;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC002_POST_Request {

	@Test
	void RegistrationSuccessful() {

		// BaseURI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// Create request object
		RequestSpecification httpRequest = RestAssured.given();

		// Create Request Payload
		JSONObject reqestParams = new JSONObject();

		reqestParams.put("FirstName", "John11W"); // 'put' because its key-value
												// like MAP
		reqestParams.put("LastName", "XYZ");
		reqestParams.put("UserName", "Johddn XYZ");
		reqestParams.put("Password", "Joddhn");
		reqestParams.put("Email", "Johnddf@gmail.com");

		httpRequest.header("Content-Type", "application/json"); // request k
																// saath header
																// pass kiya

		httpRequest.body(reqestParams.toJSONString());// request k body mai JSON
														// pass karna hai
														// isiliye
		// aur 'reqestParams' humne upar hi values key-value pair mai store kiya
		// hai

		// Response Object
		Response response = httpRequest.request(Method.POST, "/register");

		// Verify status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);

		// Verify response body mai kya aaya (Success Code Validation)
		String successMessage = response.jsonPath().get("SuccessCode"); // get method because Map se value extract hum 'get' method se karte hai
		System.out.println("Success message is :" + successMessage);
	}

}
