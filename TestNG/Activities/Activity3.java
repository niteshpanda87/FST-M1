package Project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	
	// Declare Global Driver
	WebDriver driver;

  @BeforeClass
  public void setUp() {
	  // Set up Geko Driver
	  WebDriverManager.firefoxdriver().setup();
	  
	  // Initialize the  Driver
	  driver = new FirefoxDriver();
	  
	  // Navigate to Alchamy Home page
	  driver.get("https://alchemy.hguy.co/lms");
  }
  
  @Test
  public void firstInfoBox() {
	  
	  String titleInfoBox = driver.findElement(By.tagName("h3")).getText();
	  
	  System.out.println(titleInfoBox);
	  
	  // Validate the element match "Actionable Training"
	  Assert.assertEquals("Actionable Training", titleInfoBox);
	  
  }

  @AfterClass
  public void tearDown() {
	  
	  // Quit the Browser
	  driver.quit();
  }

}
