package Project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 {
	WebDriver driver;
	
  @BeforeClass
  public void setUp() {
	  WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver(); 
	  
	  driver.get("https://alchemy.hguy.co/lms");
  }
  
  @Test
  public void myAccount() {
	  driver.findElement(By.id("menu-item-1507")).click();
	  
	  String myAccountPageVerify = driver.findElement(By.xpath("//*[@id='uagb-infobox-d9258720-3455-443e-b618-b57211636d84']/div/div/div/div[1]/h1")).getText();
	  System.out.println(myAccountPageVerify);
	  Assert.assertEquals("My Account", myAccountPageVerify);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
