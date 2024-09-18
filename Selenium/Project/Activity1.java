package Project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity1 {
	//Declare a Global Driver
	WebDriver driver;
	

  @BeforeClass
  public void setUp() {
	  // Setup Geko driver
	  WebDriverManager.firefoxdriver().setup();
	  
	  // Initialize the Driver
	  driver = new FirefoxDriver();
	  
	  // Open the Browser
	  driver.get("https://alchemy.hguy.co/lms");
	  
  }
  
  @Test
  public void homePage() {
	  // get the title of the page
	  String pageName = driver.getTitle();
	  
	  // Validate the Page title
	  Assert.assertEquals("Alchemy LMS – An LMS Application", pageName);
  }

  @AfterClass
  public void tearDown() {
	  // Close the browser
	  driver.quit();
  }

}
