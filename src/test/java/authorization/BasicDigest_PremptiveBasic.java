package authorization;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

public class BasicDigest_PremptiveBasic 
{
	@Test(priority = 0)
	void Basic_auth()
	{
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
			
			
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true));
	}
	
	@Test(priority = 0)
	void DIgest_auth()
	{
		given()
			.auth().digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
			
			
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true));
	}
	@Test
	void PreEmptive_auth()
	{
		given()
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
			
			
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true));
	}
}
