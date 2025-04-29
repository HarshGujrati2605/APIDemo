package Utilities;

import java.util.LinkedHashMap;

public class TestClass {

	public static void main(String[] args) {
		LinkedHashMap<Integer, String> li_hash_map =  
		        new LinkedHashMap<Integer, String>(); 
		  
		        // Mapping string values to int keys 
		        li_hash_map.put(10, "Geeks"); 
		        li_hash_map.put(15, "4"); 
		        li_hash_map.put(20, "Geeks"); 
		        li_hash_map.put(25, "Welcomes"); 
		        li_hash_map.put(30, "You"); 
		  
		        // Displaying the LinkedHashMap 
		        System.out.println("Initial Mappings are: " + li_hash_map); 
		  
		        // Checking for the key_element '20' 
		        System.out.println("Is the key '20' present? " +  
		        li_hash_map.containsKey(20)); 
		  
		        // Checking for the key_element '5' 
		        System.out.println("Is the key '5' present? " +  
		        li_hash_map.containsKey(5));

	}

}
