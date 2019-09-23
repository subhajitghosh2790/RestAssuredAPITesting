package firstPractice;

import org.testng.annotations.Test;

import com.sun.tools.xjc.model.SymbolSpace;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {

	@Test
	public void googleMapsValidateHeader() {
		
		//Base URI
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//Validating Headers
		//(In ideal case we may not get the specifications, so run the URI in POSTMAN and get the Header contents for validation)
		String contentType = response.header("Content-Type");
		System.out.println("Content Type :"+contentType);
		
		String contentEncoding = response.header("Content-Encoding");
		System.out.println("Content Encoding :"+contentEncoding);
	}
}
