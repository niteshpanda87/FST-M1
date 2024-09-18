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

public class Activity9 {
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
	  
	  // select any Course any open it

  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
