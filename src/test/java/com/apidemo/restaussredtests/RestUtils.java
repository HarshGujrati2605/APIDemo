package com.apidemo.restaussredtests;



import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	

	public static String getName() {

		String name = RandomStringUtils.randomAlphabetic(6);
		return "Gopi " +name;
	}
	
	
	public static String getEmail() {

		String name = RandomStringUtils.randomAlphabetic(10);
		return name+"@gopi.com";
	}
	
	
	
	
	
	
	
	
	
	

}
