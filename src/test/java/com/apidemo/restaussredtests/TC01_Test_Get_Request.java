package com.apidemo.restaussredtests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class TC01_Test_Get_Request {
	
	@Test(testName = "Test API get request")
	public void getEmployeeDetails() {
		
		given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.assertThat()
		.header("X-Powered-By", "Express").log().all();
		
	}

}
