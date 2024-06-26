package com.apidemo.restaussredtests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class TC04_Test_Delete_Request {
	

	HashMap<String, String> map = new HashMap<String, String>();
	String name;
	int emp_id =2;
	
	@Test
	public void putTest() {
		
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users/"+emp_id;
		
		Response response =
		
		given()
		
		.when().delete()
		
		.then().assertThat().statusCode(204).log().all().extract().response();
		
		String responseintostring = response.asString();
		Assert.assertEquals(responseintostring , "");   // body is deleted after delete command so reponse in the body is null
		System.out.println(responseintostring);
		
	}
	

}
