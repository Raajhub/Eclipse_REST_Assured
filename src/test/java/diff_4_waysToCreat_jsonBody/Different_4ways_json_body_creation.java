package diff_4_waysToCreat_jsonBody;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
public class Different_4ways_json_body_creation {
	int id;
	//@Test(enabled = false)
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
			.delete("https://reqres.in/api/users/"+id)
			
		.then()
		.statusCode(204);
		
	}
	
	@Test(enabled = false)
	void testPost_use_JsonLibrary()
	{
		JSONObject data = new JSONObject();
		
		data.put("name", "docker");
		data.put("Location", "4444");
		data.put("phone", "selenium/hub/chrome/safari:15.0");
		data.put("email", "docker -e HUB_HOST");
	
		String cmds[] = {"pslink" , "prune", "pulldochub"};
		
		data.put("Docker", cmds);
		
		
		given()
				.contentType("application/json")
				.body(data.toString())	
			
			
			.when()
				.post("https://reqres.in/api/users")  //https://dummy.restapiexample.com/api/v1/create
			
				
			.then()
				.statusCode(201)
				.body("name", equalTo("docker"))
				.body("Location", equalTo("4444"))
				.body("phone", equalTo("selenium/hub/chrome/safari:15.0"))
				
				.body("Docker[0]", equalTo("pslink"))
				.body("Docker[1]", equalTo("prune"))
				.body("Docker[2]", equalTo("pulldochub"))
				
				
				.header("Content-Type","application/json; charset=utf-8")
				.log().all();
		
	}


	@Test(enabled = false)
	void test_Post_use_POJO()
	{
		
		Pojo_postRequest pojo = new Pojo_postRequest();
		pojo.setName("CICD");
		pojo.setLocation("localhost:8080");
		pojo.setPhone("git cred manager");
		
		String tech[] = {"vnc","brew","github" };
		pojo.setTech(tech);
		
		id=given()
				.contentType("application/json")
				.body(pojo)
		
		.when()
			.post("https://reqres.in/api/users/")
			.jsonPath().getInt("id");		
	}
	
	@Test
	void test_Post_use_ExtJSON_file()
	{
		
		File file =new File("/Users/rajeshvn/eclipse-RestAssured/Rest_Assured/Body.json");
		try 
		{
			FileReader fr =new FileReader(file);
			JSONTokener jt = new JSONTokener(fr);
			JSONObject job = new JSONObject(jt);
			
			given()
			
			.when()
				.contentType("application/json")
				.body(job.toString());
			
			
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}		
		
	}

}
