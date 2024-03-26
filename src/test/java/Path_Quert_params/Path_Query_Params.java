package Path_Quert_params;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class Path_Query_Params {
	
	@Test
	void PathParams_queryParams()
	{
		// https://regres.in/api/users?page=2&id=5
		
		
		given()
			.pathParam("mypath", "users" )  //path para
			.queryParam("page", 2)			//query para
			.queryParam("id", 5)			//query para
			
		
		.when()
			.get("https://regres.in/api/{mypath}")
		
		.then()
			.statusCode(429)
			.log().all();
		
	}

}
