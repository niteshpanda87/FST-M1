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

public class Activity3 {
	// Delare Driver
	AndroidDriver driver;

	@BeforeClass
	  public void setup() throws MalformedURLException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andriod");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.calculator");
		options.setAppActivity("com.android.calculator2.Calculator");
		
		// Server Address
		URL serverURL = new URL("http://localhost:4723/");
		
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
	  }	
	
	
  @Test(priority=1)
  public void addTest() {
	  // Perform calculation 5 + 9
	  driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
	  driver.findElement(AppiumBy.accessibilityId("plus")).click();
	  driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();
	  driver.findElement(AppiumBy.accessibilityId("equals")).click();
	  
	  // Find the final result
	  String addResult = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
	  
	  // Assertion
	  Assert.assertEquals(addResult, "14");
	  
  }
  
  @Test(priority=2)
  public void substratTest() {
	  	  driver.findElement(AppiumBy.accessibilityId("clear")).click();
	// Perform calculation 10 - 5
		  driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
		  driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
		  driver.findElement(AppiumBy.accessibilityId("minus")).click();
		  driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
		  driver.findElement(AppiumBy.accessibilityId("equals")).click();
		  
		  // Find the final result
		  String addResult = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
		  
		  // Assertion
		  Assert.assertEquals(addResult, "5");
  }
  
  @Test(priority=3)
  public void multiplyTest() {
	  driver.findElement(AppiumBy.accessibilityId("clear")).click();
	// Perform calculation 5 * 100
	  driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
	  driver.findElement(AppiumBy.accessibilityId("multiply")).click();
	  driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
	  driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
	  driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
	  driver.findElement(AppiumBy.accessibilityId("equals")).click();
	  
	  // Find the final result
	  String addResult = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
	  
	  // Assertion
	  Assert.assertEquals(addResult, "500");
  }
  
  @Test(priority=4)
  public void divideTest() {
	  driver.findElement(AppiumBy.accessibilityId("clear")).click();
		// Perform calculation 50 / 2
	  driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
	  driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
	  driver.findElement(AppiumBy.accessibilityId("divide")).click();
	  driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
	  driver.findElement(AppiumBy.accessibilityId("equals")).click();
	  
	  // Find the final result
	  String addResult = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
	  
	  // Assertion
	  Assert.assertEquals(addResult, "25");
  }


  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}
