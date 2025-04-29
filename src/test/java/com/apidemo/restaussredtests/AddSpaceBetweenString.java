package com.apidemo.restaussredtests;

public class AddSpaceBetweenString {

	public static void main(String[] args) {
		String s = "MyNameIsChaitra";
		String s1 = "I love ";
		String s3 = "IAmHarsh";

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {

				System.out.print(" " + s.charAt(i));
			} else {
				System.out.print(s.charAt(i));
			}
		}

//		System.out.println(s1.replaceAll(" ", "").length());
		System.out.println();

		int partsize = s3.length() / 2;

		for (int i = 0; i < s3.length(); i += partsize) {
			System.out.println(s3.substring(i, i + partsize));
		}

		String s4 = "a1b2c3";

		char[] arr = s4.toCharArray();

		String words = "";
		String numbers = "";
		System.out.println(arr.length);

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == '1' | arr[i] == '2' | arr[i] == '3') {
				numbers += arr[i];

			} else {

				words += arr[i];

			}

		}

		System.out.println(numbers);
		System.out.println(words);

		// Non repeated character

		String s5 = "AABCDECD";

		char[] arr1 = s5.toCharArray();
		char nonrept = ' ';
		boolean found;

		for (int i = 0; i < arr1.length; i++) {
			found = false; // Reset flag for each character

			for (int j = 0; j < arr1.length; j++) {
				if (i != j && arr1[i] == arr1[j]) {
					found = true; // Character is repeated
					break;
				}
			}

			if (!found) { // If not repeated
				nonrept = arr1[i];
				break; // Stop at the first non-repeating character
			}
		}

		if (nonrept != ' ') {
			System.out.println(nonrept + " is the first non-repeated character.");
		} else {
			System.out.println("No unique character found.");
		}
		
		int number = 389;
		String reversenewnum ="";
		String newnum = Integer.toString(number);
		for(int i= newnum.length()-1; i>=0; i--) {
			reversenewnum+= newnum.charAt(i);
			
		}
		
		System.out.println(reversenewnum);
		
		
		String sentence = "Indore is a cleanest city";
		
		String[] arrsent = sentence.split(" ");
		
		String reversenewstr = "";
		
		for(int i = 0 ; i<arrsent.length ;i++) {
			
			
			for(int j= arrsent[i].length()-1 ; j>=0; j--) {
				
				reversenewstr+= arrsent[i].charAt(j);
					
			}
			
			reversenewstr = reversenewstr + " ";
			
			
		}
		
		System.out.println(reversenewstr);

	}

}
