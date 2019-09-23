package firstPractice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request_GetAllHeaders {

	@Test
	void getAllHeaders() {

		// Base URI
		RestAssured.baseURI = "https://maps.googleapis.com";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Response Object

		Response response = httpRequest.request(Method.GET,
				"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

		// Get Response Body
		String responseBody = response.getBody().asString();

		// Get all Headers
		Headers allHeaders = response.headers(); // as its key-value pair,
													// internally it implements
													// HashMap

		for (Header header : allHeaders) {
			// to extract key-value in map we write Map.entry<K,V> =
			// allHeaders.entrySet()
			System.out.println(header.getName() + "      " + header.getValue());

			// Map usually has getKey and getName method
		}

	}

}
