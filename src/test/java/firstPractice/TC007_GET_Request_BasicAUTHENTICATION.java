package firstPractice;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_Request_BasicAUTHENTICATION {

	@Test
	void basicAuthentication() {

		// Without authoratization we get status '401 Unauthorised'

		// With proper Authorization we get '200 OK'

		// Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Basic Authentication
		PreemptiveBasicAuthScheme authScheme  = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("ToolsQA");
		authScheme.setPassword("TestPassword");
		
		RestAssured.authentication = authScheme; // define what kin of authencation it is --> in our case 'authScheme' is object of Basic Authentication
		
		//Response Object
		Response response = httpRequest.request(Method.GET, "/");
		
		// Chedck status code to see its 200 and not 401 because of authentocation
		
		Assert.assertEquals(response.getStatusCode(),200);

	}

}
