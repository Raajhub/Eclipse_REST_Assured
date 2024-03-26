package LOGGGG;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class Logging_types 
{
 @Test
 
 void logloglog()
{
	given()
	
	.when()
		.get("https://www.google.co.in/")
	
	.then()
		
		//.log().body()
		//.log().cookies();
		//.log().headers();
		 // .cookie("1P_JAR", "2024-03-26-18")
		.log().all();
		
	
}
}
