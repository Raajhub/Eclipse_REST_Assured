package file_Upload_n_Download;
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
import io.restassured.path.json.JsonPath;
public class Files_Upload_Download 
{
	@Test(enabled=false)
	void single_file_upload()
	{
		File myfile = new File("/Users/rajeshvn/Downloads/RaJEsH/images.png");
		given()
			.multiPart("file",myfile)
			.contentType("multipart/form-data")
		
		.when()
			.post("https://api.escuelajs.co/api/v1/files/upload")
		
		.then()
			.statusCode(201)
			.log().all();
			//.body(null, null)
		
		
	}
	
	@Test
	void multiple_files_upload()
	{
		File file1 = new File("/Users/rajeshvn/Downloads/RaJEsH/images.png");
		File file2 = new File("/Users/rajeshvn/Downloads/RaJEsH/raaj.png");
		given()
			.multiPart("files",file1)
			.multiPart("files",file2)
			.contentType("multipart/form-data")
		
		.when()
			.post("https://api.escuelajs.co/api/v1/files/upload")
		
		.then()
			.statusCode(201)
			.log().all();
			//.body(null, null)
		
		
	}

}
