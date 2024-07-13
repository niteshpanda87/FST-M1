package Activity;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity1 {
	// Declare the Android Driver
	AndroidDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		UiAutomator2Options option = new UiAutomator2Options();
		option.setPlatformName("android");
		option.setAutomationName("UiAutomator2");
		option.setAppPackage("com.google.android.calculator");
		option.setAppActivity("com.android.calculator2.Calculator");
		
		// Server Address
		URL serverURL = new URL("http://localhost:4723/");
		
		//initialize the Driver
		driver = new AndroidDriver(serverURL, option);
	  }
	@Test
	public void multiplyTest() {
		// Perform the calculation
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		driver.findElement(AppiumBy.id("digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		// Find the result
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		
		// Assertion
		Assert.assertEquals(result, "45");
	}


	@AfterClass
	public void tearDown() {
		// close the device
		driver.quit();
	}

}
