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

public class GoogleTask {
	// Declare the Driver
	AndroidDriver driver;
	WebDriverWait wait;
	
  @BeforeClass
  public void setUp() throws MalformedURLException{
		// Desired Capabilities	
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andriod");
		options.setAutomationName("UiAutomator2");
		options.setAppActivity(".ui.TaskListsActivity");
		options.setAppPackage("com.google.android.apps.tasks");
		
		// Server Address
		URL serverURL = new URL("http://localhost:4723/");
		
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Wait until the app loads
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Next page")));		
		// click on Next after opening Task
		driver.findElement(AppiumBy.accessibilityId("Next page")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/npr_allow_button")));
		// Click on Got it
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/npr_allow_button")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")));
		// Click on Allow
		driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		
  }	
	
  @Test(priority=1)
  public void createTask1() {
	  // Wait until new task create button appears
	  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Create new task")));
	  // Create a New Task
	  driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
	  // Task1
	  driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
	  driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
	  
	  // Wait until task added
	  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\" and @text=\"Complete Activity with Google Tasks\"]")));
	  // String Task1 = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name")).getText();
	  String Task1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\" and @text=\"Complete Activity with Google Tasks\"]")).getText();
	  // Assertion
	  Assert.assertEquals(Task1, "Complete Activity with Google Tasks");
  }
  
  @Test(priority=2)
  public void createTask2() {
	  // Create a New Task
	  driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
	  // Task1
	  driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
	  driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
	  
	  // Wait until Task added
	  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\" and @text=\"Complete Activity with Google Keep\"]")));
	  // String Task2 = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name")).getText();
	  String Task2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\" and @text=\"Complete Activity with Google Keep\"]")).getText();
	  // Assertion
	  Assert.assertEquals(Task2, "Complete Activity with Google Keep");
  }
  
  @Test(priority=3)
  public void createTask3() {
	  // Create a New Task
	  driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
	  // Task1
	  driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
	  driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
	  
//	  String Task3 = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name")).getText();
	  
	  // Wait until Task added
	  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\" and @text=\"Complete the second Activity Google Keep\"]")));
	  
	  String Task3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\" and @text=\"Complete the second Activity Google Keep\"]")).getText();
	  // Assertion
	  Assert.assertEquals(Task3, "Complete the second Activity Google Keep");
  }


  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}
