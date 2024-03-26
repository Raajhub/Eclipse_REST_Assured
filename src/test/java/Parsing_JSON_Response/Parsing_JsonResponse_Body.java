package Parsing_JSON_Response;
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

public class Parsing_JsonResponse_Body {

	//APPROACH 1
	@Test(enabled = false)
	void parsing_JsonBody_usingJsonFinder_using_THEN()
	{
		
		
		given()
			.contentType("ContentType.JSON")
			
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.header("Content-Type", "application/json; charset=utf-8")
			.body("data[5].last_name", equalTo("Howell"));		
		
	}	
	//APPROACH 2
		@Test(enabled = false)
		void parsing_JsonBody_using_Respnse()
		{
					
		Response res = given()
				.contentType(ContentType.JSON)
				
			.when()
				.get("https://reqres.in/api/users?page=2");
		
			Assert.assertEquals(res.getStatusCode(), 200);
			Assert.assertEquals(res.header("Content-type"), "application/json; charset=utf-8");
			
			String lname  = res.jsonPath().get("data[5].last_name").toString();
			Assert.assertEquals(lname, "Howell");
			System.out.println(lname);		
		}
		//Approach 3
		@Test(enabled = false)
		void parsing_JsonBody_using_JSONObject_class()
		{
					
		Response res = given()
				.contentType(ContentType.JSON)
				
			.when()//
				.get("https://reqres.in/api/users?page=2");
		
			JSONObject json = new JSONObject(res.asString()); 	//converting response to json object type
			boolean status = false;
			
			for (int i=0; i<json.getJSONArray("data").length(); i++)
			{
					String fname = json.getJSONArray("data").getJSONObject(i).get("first_name").toString(); //converted to string for easy validations
					System.out.println(fname);
					
					//Assert.assertEquals("jackSon",fname);
								
					if(fname.equals("Michael"))
					{
						status = true;
						break;
					}
					Assert.assertEquals(status, true);
			}
		}	
//			for (int i=0; i<json.getJSONArray("data").length(); i++)
//			{
//					String email = json.getJSONArray("data").getJSONObject(i).get("email").toString();
//					System.out.println(email);
//			}
			
			
			//Approach 4 - adding values of json array elements
		
			@Test
			void parsing_JsonBody_to_add_values_in_jsonObj()
			{
						
			Response res = given()
					.contentType(ContentType.JSON)
					
				.when()//
					.get("https://reqres.in/api/users?page=2");
			
				JSONObject json = new JSONObject(res.asString()); 	//converting response to json object type
				int total_id=0;
				
				for (int i=0; i<json.getJSONArray("data").length(); i++)
				{
						String id = json.getJSONArray("data").getJSONObject(i).get("id").toString(); //converted to string for easy validations
						
						total_id = total_id + Integer.parseInt(id);						
				}	
				System.out.println("Total id's :"+total_id);
				
				Assert.assertEquals(total_id, 57);
		}	
}
