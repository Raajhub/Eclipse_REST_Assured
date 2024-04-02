package schema_validations;
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

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
public class JSON_schema_validation {

	@Test
	void json_schema()
	{
		given()
		
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")	// https://jsonplaceholder.typicode.com/users -json_schema.json
		
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath
					("JsonSchem.json"));
		
		
		
	}
}
