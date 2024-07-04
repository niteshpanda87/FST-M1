package Project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity4 {
	
	WebDriver driver;

  @BeforeClass
  public void setUp() {
	  WebDriverManager.firefoxdriver().setup();
	  
	  driver = new FirefoxDriver();
	  
	  driver.get("https://alchemy.hguy.co/lms");
	  
  }
  
  @Test
  public void secondMostPopularCourse() {
	  String secondPopularCourse = driver.findElement(By.xpath("//*[@id=\"post-71\"]/div[2]/h3")).getText();
	  
	  System.out.println(secondPopularCourse);
	  
	  // Validate it matches with Email Marketing Strategies
	  Assert.assertEquals("Email Marketing Strategies", secondPopularCourse);
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
