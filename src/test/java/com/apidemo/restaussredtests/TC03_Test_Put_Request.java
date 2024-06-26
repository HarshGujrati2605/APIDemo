package com.apidemo.restaussredtests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class TC03_Test_Put_Request {

	HashMap<String, String> map = new HashMap<String, String>();
	String name;
	int emp_id =2;

	@BeforeClass
	public void putData() {
		name = RestUtils.getName();
		System.out.println(name);
		map.put("name", name);	
		map.put("email", RestUtils.getEmail());	
		map.put("job", "QA");
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users/"+emp_id;
	}
	
	@Test
	public void putTest() {
		
		given().contentType(ContentType.JSON).body(map)
		
		.when().put()
		
		.then().assertThat().statusCode(200).body("name", equalTo(name)).log().all();
		
	}

}
