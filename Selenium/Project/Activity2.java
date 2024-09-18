package Project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2 {
	// Declare Global driver
	WebDriver driver;
	
  @BeforeClass
  public void setUp() {
	  // Setup Geko driver
	  WebDriverManager.firefoxdriver().setup();
	  
	  // Initialize the Browser
	  driver = new FirefoxDriver();	 
	  
	  // Open the Browser
	  driver.get("https://alchemy.hguy.co/lms");
  }
  
  @Test
  public void pageHeading() {
	  // Get the Page heading Name
	  String pageHeading = driver.findElement(By.className("uagb-ifb-title")).getText();
	  
	  // Print the page name
	  System.out.println("Page Name is: " +pageHeading);
	  
	  // Assertion for Page Heading
	  Assert.assertEquals("Learn from Industry Experts", pageHeading);
  }

  @AfterClass
  public void tearDown() {
	  
	  // Close the Browser
	  driver.quit();
  }

}
