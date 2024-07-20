package Activity;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 {
	// Initialize Driver
	AndroidDriver driver;
	WebDriverWait wait;
	
  @BeforeClass
  public void setUp() throws MalformedURLException {
	// Desired Capabilities
      UiAutomator2Options options = new UiAutomator2Options();
      options.setPlatformName("android");
      options.setAutomationName("UiAutomator2");
      options.setAppPackage("com.google.android.apps.messaging");
      options.setAppActivity(".ui.ConversationListActivity");
      
      // Server Address
      URL serverURL = new URL("http://localhost:4723/");

      // Driver Initialization
      driver = new AndroidDriver(serverURL, options);
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      
      // Select secondary button
      wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.messaging:id/secondary_action_button")));
      driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/secondary_action_button")).click();
      
      // Wait until message page loads
      wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Start chat")));
  }
  
  @Test
  public void sendMessage() {
	  // Click on Start Chart
	  driver.findElement(AppiumBy.accessibilityId("Start chat")).click();
	  
	  // Wait for the page to load
	  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.messaging:id/recipient_text_view")));
	  
	  // Search for the Name
	  driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/recipient_text_view")).sendKeys("8420158062");
	  
	  //Press Enter
	  driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	  
//	  String composePage = driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text")).getText();
//	  Assert.assertEquals("Text message", composePage);
//	  // wait for page to load
	  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text")));
	  
	  // Add message
	  driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text")).sendKeys("Hello From Appium");
	  
	  // Click on send
	  driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
	  
  }
  

  @AfterClass
  public void tearDown() {
	  // Quit Driver
	  driver.quit();
  }

}
