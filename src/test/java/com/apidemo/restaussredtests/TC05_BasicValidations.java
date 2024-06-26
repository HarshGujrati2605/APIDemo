package com.apidemo.restaussredtests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class TC05_BasicValidations {
	
	

	@Test(testName = "Test API get request" , priority = 1)
	public void getEmployeeDetails() {
		
		given()
		.when()
		.get("http://localhost:3000/Student")
		.then().assertThat().statusCode(200).body("firstName", hasItems("Joe")).log().all();
		
		
		
	}
	
	@Test(testName = "Test API get request multiple data" , priority = 2)
	public void getEmployeeDetailsMultipledata() {
		
		given()
		.when()
		.get("http://localhost:3000/Student")
		.then().assertThat().statusCode(200).body("firstName", hasItems("Joe" , "Harsh")).log().all();
		
		
		
	}
	
	@Test(testName = "Test API get request to test headers and params" , priority = 3)
	public void validteParams() {
		
		given().param("firstName", "Harsh").header("header", "Indian")
		.when()
		.get("http://localhost:3000/Student")
		.then().log().all();
		
		
		
	}

}
