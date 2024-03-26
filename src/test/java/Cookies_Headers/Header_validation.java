package Cookies_Headers;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class Header_validation {

	@Test(enabled = false)
	void header_info()
	{
		given()
		
		.when()
		.get("https://postman-echo.com/get?foo1=bar1&foo2=bar2") 
		
		.then()
		.statusCode(200)
		.log().all()
			.header("Content-Type", "application/json; charset=utf-8")
			.and()
			.header("Connection", "keep-alive")
			.and();
			//.header("Content-Length", "579");				
	}
	
	@Test
	void all_headers_info()
	{
		Response res = given()
		
		.when()
			.get("https://postman-echo.com/get?foo1=bar1&foo2=bar2");
		
		//get single header info
		
		String singleHeader =  res.getHeader("Content-Type");
		System.out.println("Content-Type : "+singleHeader);
		
		//get all headers info
		
		Headers myHeaders = res.getHeaders();
		
		for (Header head : myHeaders)
		{
			System.out.println(head.getName()+"-->"+head.getValue());
		}
				
	}
	
	
	
}
