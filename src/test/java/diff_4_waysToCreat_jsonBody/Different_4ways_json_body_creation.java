package diff_4_waysToCreat_jsonBody;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
public class Different_4ways_json_body_creation {
	String id=null;
	@Test
	void testPost_use_HashMap()
	{
		HashMap data = new HashMap();
		
		data.put("name", "Jenkins");
		data.put("Location", "8080");
		data.put("phone", "Build-delivery plugins");
	
		String tools[] = {"maven" , "docker"};
		
		data.put("softwares", tools);
		
		
		given()
				.contentType("application/json")
				.body(data)
			
			
			.when()
				.post("https://reqres.in/api/users")  //https://dummy.restapiexample.com/api/v1/create
			
				
			.then()
				.statusCode(201)
				.body("name", equalTo("Jenkins"))
				.body("Location", equalTo("8080"))
				.body("phone", equalTo("Build-delivery plugins"))
				.body("softwares[0]", equalTo("maven"))
				.body("softwares[1]", equalTo("docker"))
				.header("Content-Type","application/json; charset=utf-8")
				.log().all();
		
	}
	
	
	@Test
	void deleteRecord()
	{
		given()
		
		.when()
			.delete("https://dummy.restapiexample.com/api/v1/delete/2"+id)
			
		.then()
		.statusCode(200);
		
	}

}
