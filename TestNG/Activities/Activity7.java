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

public class Activity7 {
	WebDriver driver;
	
  @BeforeClass
  public void setUp() {
	  WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver(); 
	  
	  driver.get("https://alchemy.hguy.co/lms");
  }
  
  @Test
  public void allCourses() {
	  // Locate All courses and click
	  driver.findElement(By.id("menu-item-1508")).click();
	  
	  // Find All Courses on the Page
	  int allCourses = driver.findElements(By.className("col-sm-8")).size();
	  
	  // Print the Number of Courses on the page
	  System.out.println("Total Number of the Courses on the page is: " +allCourses);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
