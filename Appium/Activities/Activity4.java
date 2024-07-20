package Activity;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity4 {
	// Declare Driver
	AndroidDriver driver;
	WebDriverWait wait;
	
  @BeforeClass
  public void setUp() throws MalformedURLException {
	// Desired Capabilities
	  UiAutomator2Options options = new UiAutomator2Options();
	  options.setPlatformName("android");
	  options.setAutomationName("UiAutomator2");
	  options.setAppPackage("com.google.android.contacts");
	  options.setAppActivity("com.android.contacts.activities.PeopleActivity");

	  // Server Address
	  URL serverURL = new URL("http://localhost:4723/");
	  // Driver Initialization
	  driver = new AndroidDriver(serverURL, options);
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
//	  // Wait for Notification Allow button
//	  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")));
//	  driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
//	  
	  // wait for contact page to load
	  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Create contact")));
  }
	  
  @Test
  public void addContact() {
	  // click on Add button
	  driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
	  
	  // Add detail
	  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"First name\"]")).sendKeys("Appium");
	  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Last name\"]")).sendKeys("Test");
	  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Phone\"]")).sendKeys("8420158062");
	  
	  // Click on save
	  driver.findElement(AppiumBy.id("com.google.android.contacts:id/toolbar_button")).click();
	  
	  // Validate assertion
	  String addPage = driver.findElement(AppiumBy.id("com.google.android.contacts:id/large_title")).getText();
	  Assert.assertEquals("Appium Test", addPage);
  }


  @AfterClass
  public void tearDown() {
	  //Quit driver
	  driver.quit();
  }

}
