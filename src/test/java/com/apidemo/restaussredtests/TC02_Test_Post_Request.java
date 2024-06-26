package com.apidemo.restaussredtests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class TC02_Test_Post_Request {
	
	public static HashMap map = new HashMap();
	public static String name;
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void postData() {
		 name = RestUtils.getName();
		 System.out.println(name);
		map.put("name", name );
		map.put("email", RestUtils.getEmail());	
		map.put("job", "QA");
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users";
	}
	
	@Test(testName = "Validating get request")
	public void testPostData() {
		
		given().contentType(ContentType.JSON).body(map)
		.when().post()
		.then().assertThat().statusCode(201).body("name", equalTo(name)).body("job", equalTo("QA"))
		.header("Server", "cloudflare");
		
	}
	

	
	

}
