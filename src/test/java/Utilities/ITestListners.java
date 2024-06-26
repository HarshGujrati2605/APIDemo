package Utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;



public class ITestListners implements ITestListener{

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " is passed");
		
	}
}
