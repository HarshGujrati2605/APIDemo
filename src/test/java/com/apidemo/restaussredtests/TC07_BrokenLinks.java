package com.apidemo.restaussredtests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC07_BrokenLinks {
	public static WebDriver driver;

	public static void VerifyBrokenLinksandPrint(WebDriver driver) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allURLs = driver.findElements(By.tagName("a"));
		System.out.println("The number of URLs on page is " + allURLs.size());
		System.out.println("***********************************************");
		System.out.println();
		System.out.println("The all URLs on the page is:");
		for (int i = 0; i < allURLs.size(); i++) {

			WebElement url = allURLs.get(i);
			String urlname = url.getAttribute("href");
			// System.out.println(urlname);
			verifyLinks(urlname);

		}
	}

	public static void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			// Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
			}

			// Fetching and Printing the response code obtained
			else {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.geeksforgeeks.org/selenium-interview-questions/");

		Thread.sleep(2000);

		Thread.sleep(4000);
		driver.findElement(By.xpath("(//span[contains (text() , 'Selenium')]/ancestor::a)[1]")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text() = 'testing web-based applications']/ancestor::a")).click();

		Set<String> handles = driver.getWindowHandles();

		String windowhandleparent = driver.getWindowHandle();

		System.out.println(handles);
		for (String handle : handles) {

			if (!handle.equals(windowhandleparent)) {
				Thread.sleep(1000);
				String titleofnewwindow = driver.switchTo().window(handle).getTitle();
				System.out.println(titleofnewwindow);
				if(titleofnewwindow.contains("Web Based Testing")) {
				}

			}

		}

	}

}
