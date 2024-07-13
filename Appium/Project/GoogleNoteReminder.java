package Project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class GoogleNoteReminder {
	// Declare driver and Wait
	AndroidDriver driver;
	WebDriverWait wait;
	
  @BeforeClass
  public void setUp() throws MalformedURLException {
	  // Desired Capabilities
	  UiAutomator2Options options = new UiAutomator2Options();
	  options.setPlatformName("android");
	  options.setAutomationName("UiAutomator2");
	  options.setAppPackage("com.google.android.keep");
	  options.setAppActivity(".activities.BrowseActivity");
	  
	  
	  // Server Address
	  URL serverURL = new URL("http://localhost:4723/");
	  
	  // Driver and wait initialization
	  driver = new AndroidDriver(serverURL, options);
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  
	  // Wait until continue button appears for Location Permission
	  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1")));
	  driver.findElement(AppiumBy.id("android:id/button1")).click();
	  
	  // Wait until continue button appears for Notification Permission
	  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")));
	  driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
	  
	  // Wait until App Load
	  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("New text note")));
  }
  @Test
  public void addNoteWithReminder() {
	// Add a New Note
		  driver.findElement(AppiumBy.accessibilityId("New text note")).click();
		  
		  // Wait until the Title page opens
		  wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/editor_toolbar")));
		  
		  // Enter the title
		  driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("FST Reminder");
		  
		  // Enter the description
		  driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("This is a FST Test notes with reminder");
		  
		  // Click on Reminder button
		  driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
		  
		  // Wait until the reminder options open
		  wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/bs_list_view")));
		  
		  // Select Later today option
		  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Later today\"]")).click();
		  
		// Press the back button
		  driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		  
		  // Wait until home page loads
		  wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/open_search_bar_text_view")));
		  
		  // Validate New Note Added
		  String note = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/index_note_title\" and @text=\"FST Reminder\"]\n"
		  		+ "")).getText();
		  Assert.assertEquals(note, "FST Reminder");
  }

  @AfterClass
  public void tearDown() {
	  // Quit driver
	  driver.quit();
  }

}
