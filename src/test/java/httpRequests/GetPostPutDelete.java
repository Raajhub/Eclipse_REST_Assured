package httpRequests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class GetPostPutDelete {
	int id;
	@Test
	void  getUser()
	{
		given()
		
		.when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("page", equalTo(2)).log().all();		
		
	}
	
	
	@Test(priority = 1)
	void creatUser()
	{
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "ecllipse");
		data.put("job", "coding");
		
		id=given()
			.contentType("application/json")
			.body(data)
		
		
		.when()
			.post("https://reqres.in/api/users") 	// we get id after execute this used that id to update the data
			.jsonPath().getInt("id");
		
//		.then()
//			.statusCode(201)
//			.log().all(); // we get id after execute this used that id to update the data
//		
	}
	
	@Test(dependsOnMethods = "creatUser")
	void updateUser()
	{
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "eclipse");
		data.put("job", "helping");
		
		given()
			.contentType("application/json")
			.body(data)
		
		
		.when()
			.put("https://reqres.in/api/users/"+id)
			
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void deletUser()
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
		
		
		
	}

}
