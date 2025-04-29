package Utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Demo {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String localdate = LocalDate.parse(dtf.format(now)).plusDays(1).toString();
		System.out.println(localdate.substring(8).trim());
		if(localdate.substring(8).charAt(0) == '0') {
		  System.out.println("Local date has zero in the first place");
		  System.out.println(localdate.substring(9).trim());	

	}
	}

}
