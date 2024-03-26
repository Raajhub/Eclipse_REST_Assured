package Cookies_Headers;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class Cookies_Validation {

	@Test(enabled = false)
	void cookiee()   
	{
		given()
		
		.when()
			.get("https://www.google.co.in/")  //https://postman-echo.com/get?foo1=bar1&foo2=bar2
			
		.then()
			.statusCode(200)
			.log().all();
			//.cookie("sails.sid", "s%3AYax4AVO6pQnnetOky0uTt27zhlEmzYze.gyoutqjMP2Pd6BQCkubI3XR9e2bVq1VgYSZO53HVvbk");
		
	}
	
	@Test
	void cookiess_Response()   
	{
		Response res= given()
		
		.when()
			.get("https://www.google.co.in/");
		
		//get single cookie info
		
		String cookie_val = res.getCookie("1P_JAR");
		System.out.println("Cookie value ===> "+cookie_val);
					
		//get ALL cookie info
		Map<String, String> allCookies = res.getCookies();
		
		System.out.println(allCookies.keySet());
		
		for (Map.Entry<String, String> ent : allCookies.entrySet())
		{
			System.out.println(ent.getKey()+"--->"+ent.getValue());
		}
		
		for(String cookies_key : allCookies.keySet())
		{
			System.out.println(cookies_key+"-->"+res.getCookie(cookies_key));
			
		}
		
	}
}
