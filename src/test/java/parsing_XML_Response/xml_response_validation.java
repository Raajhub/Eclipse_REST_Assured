package parsing_XML_Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.http.Status;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class xml_response_validation 
{
	@Test(enabled = false)
	void xml_validation_inside_THEN()
	
	{
		given()
		
		.when()
			.get("http://www.w3schools.com/xml/plant_catalog.xml")
		
		.then()
			.statusCode(200)
			.header("Content-Type", "text/xml")
			.body("CATALOG.PLANT[1].ZONE",equalTo("3"));
		
		
	}
	
	@Test
	void xml_validation_with_Response()
	
	{
		Response res = given()
		
		.when()
			.get("http://www.w3schools.com/xml/plant_catalog.xml");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"),"text/xml");
		
		String zone = res.xmlPath().get("CATALOG.PLANT[1].ZONE").toString();
		
		Assert.assertEquals(zone,"3");
		
		
		
		
	}
}
