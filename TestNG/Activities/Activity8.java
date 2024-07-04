package Project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity8 {
	WebDriver driver;
	
  @BeforeClass
  public void setUp() {
	  WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver(); 
	  
	  driver.get("https://alchemy.hguy.co/lms");
  }
  
  @Test
  public void contactUs() {
	  // Locate Contact and click
	  driver.findElement(By.id("menu-item-1506")).click();
	  
	  // Fill the information
	  driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Nitesh Panda");
	  driver.findElement(By.id("wpforms-8-field_1")).sendKeys("nitesh.panda@xyz.com");
	  driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Testing Query");
	  driver.findElement(By.id("wpforms-8-field_2")).sendKeys("This is a testing demo query.");
	  
	  // Click on Send Message to submit message
	  driver.findElement(By.id("wpforms-submit-8")).click();
  }
  
  @Test(dependsOnMethods = {"contactUs"})
  public void validateSubmission() {
	  // Validate the submission Message
	  String submissionMessage = driver.findElement(By.id("wpforms-confirmation-8")).getText();
	  Assert.assertEquals("Thanks for contacting us! We will be in touch with you shortly.", submissionMessage);
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
