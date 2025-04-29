package com.apidemo.restaussredtests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;


public class BasicAPI {
	
	@Test(priority = 1)
	public void validateAPITestOne() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		RestAssured.basePath = "maps/api/place/add/json";
	Response response	= given().queryParam("key", "qaclick123").header( "Content-Type" , "application/json").body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house Harsh\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09 new\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"Harsh park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}").when().post().then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", equalTo("Apache/2.4.52 (Ubuntu)")).extract().response();
		
		 String responsebody = response.body().asString();
		 JsonPath jsonpath = response.jsonPath();
		 String placeid = jsonpath.getString("place_id");
		 System.out.println(placeid+ "************");
		 
	}
	
	
	
	
	

}
