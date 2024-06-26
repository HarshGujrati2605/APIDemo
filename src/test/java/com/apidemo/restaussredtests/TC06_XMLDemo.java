package com.apidemo.restaussredtests;

import org.testng.annotations.Test;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class TC06_XMLDemo {
	
//	**//1) Verifying Single content in XML Response
//2) Verifying Multiple contents in XML Response
//3) Verifying all the content in XML response in one go
//4) XPath with text() function
//5) Find values using XML Path in XML response 
////**
	
	//Validating single 
	
	@Test(priority = 1)
	public void singleCOntentTest() {
		
		given()
		.when().get("https://mocktarget.apigee.net/xml")
		.then().assertThat().statusCode(200).body("root.city", equalTo("San Jose")).log().all();
		
		
	}
	
	
	@Test(priority = 2)
	public void multipleCOntentTest() {
		
		given()
		.when().get("https://mocktarget.apigee.net/xml")
		.then().assertThat().statusCode(200).body("root.city", equalTo("San Jose")).body("root.firstName" , equalTo("John")).log().all();
		
		
	}
	
	

	@Test(priority = 3)
	public void testUsingXpath() {
		
		given()
		.when().get("https://mocktarget.apigee.net/xml")
		.then().assertThat().statusCode(200).body(hasXPath("/root/city", containsString("San")));
		
		
	}
	

	@Test(priority = 4)
	public void testUsingXpathNew() {
		
		given()
		.when().get("https://mocktarget.apigee.net/xml")
		.then().assertThat().statusCode(200).body(hasXPath("/root/city[contains(text() , 'San')]"));
		
		
	}

}
