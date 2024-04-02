package serialization_deserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.path.json.JsonPath;
import diff_4_waysToCreat_jsonBody.Pojo_postRequest;
public class Serialization 
{
	@Test(enabled = true)
	void convert_POJO_Obj2_JSONObject() throws JsonProcessingException
	{
		
		Pojo_postRequest Ser_pojo = new Pojo_postRequest();
		Ser_pojo.setName("CICD");
		Ser_pojo.setLocation("localhost:8080");
		Ser_pojo.setPhone("git cred manager");
		
		String tech[] = {"vnc","brew","github" };
		Ser_pojo.setTech(tech);
		
		//converting java object into JSON object - Serialization
		
		ObjectMapper java2json = new ObjectMapper(); // import com.fasterxml.jackson.databind.ObjectMapper;
		String jsonData = java2json.writerWithDefaultPrettyPrinter().writeValueAsString(Ser_pojo);
		
		System.out.println(jsonData);					
}
	
	@Test(enabled = true)
	void convert_JSONObject2_PojoObject() throws JsonProcessingException
	{		
		String jsonData = "{\n"
				+ "  \"name\" : \"CICD\",\n"
				+ "  \"phone\" : \"git cred manager\",\n"
				+ "  \"tech\" : [ \"vnc\", \"brew\", \"github\" ],\n"
				+ "  \"location\" : \"localhost:8080\"\n"
				+ "}" ;
		
		
		//converting  JSON object into Pojo or JAVA object - De-Serialization
		ObjectMapper json2java = new ObjectMapper();
		
		Pojo_postRequest postData = json2java.readValue(jsonData,Pojo_postRequest.class);
		
		System.out.println(postData.getName()+"\t"+postData.getPhone());
		
		
	}
		
}
