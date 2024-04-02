package faker_data_generator;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

import com.github.javafaker.Faker;
public class Faker_lib 
{
	@Test
	void testData_generator()
	{
		Faker fake = new Faker();
		
		String fname = fake.name().fullName();
		String last = fake.name().lastName();
		String flag = fake.nation().flag();
		String bothify = fake.bothify(fname);
		String safeEmailAddress = fake.internet().safeEmailAddress();
		String phoneNumber = fake.phoneNumber().phoneNumber();
		String malt = fake.beer().malt();
				String chuckNorris = fake.chuckNorris().fact();
				String weather = fake.weather().description();
				String currency = fake.currency().name();
		
				System.out.print(flag);
				System.out.print(last);
				System.out.print(bothify);
				System.out.print(safeEmailAddress);
				System.out.print(phoneNumber);
				System.out.print(malt);
				System.out.print(chuckNorris);
				System.out.print(weather);
				System.out.print(currency);
				
				
				
				
						//fname,last,bothify,safeEmailAddress, phoneNumber,
						//malt,chuckNorris, weather, currency);
		
	}
}
