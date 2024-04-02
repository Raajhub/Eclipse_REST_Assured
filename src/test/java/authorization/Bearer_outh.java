package authorization;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;
public class Bearer_outh 
{

	@Test
	void bearerToken_auth()
	{
		String bearerToken = "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";
		
		given()
			.header("Authorization", "Bearer "+bearerToken)
			
		.when()
			.get("https://api.github.com/user/repos")
			
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(enabled = false)
	void oAUTH_ONE()
	{
		given()
			.auth().oauth("consumerkey", "consumersecret","accToken","token secret")
		.when()
			.get("send get url")
			
			
		.then()
			.statusCode(200)
			.log().all();
	}
	@Test
	void oAUTH_two()
	{
		given()
		.auth().oauth2("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")
		
		.when()
			.get("https://api.github.com/user/repos")
			
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	//approach one
	@Test(enabled = true)
	void api_key_auth111()
	{
		given()
			.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
		.when()
			.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
			
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	
	//approach two
		@Test(dependsOnMethods = "api_key_auth111")
		void api_key_auth222()
		{
			given()
				.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
				.queryParam("cnt", "7")
				.queryParam("units", "metric")
				.queryParam("q", "Delhi")
				.pathParam("mypath", "data/2.5/forecast/daily")
				
			.when()
				.get("https://api.openweathermap.org/{mypath}")
				
				
			.then()
				.statusCode(200)
				.log().all();
		}
}
