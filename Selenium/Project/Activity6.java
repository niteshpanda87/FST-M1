package Project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity6 {
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
	  
	  // Locate the My Account Link and click on it
	  String myAccountPageVerify = driver.findElement(By.xpath("//*[@id='uagb-infobox-d9258720-3455-443e-b618-b57211636d84']/div/div/div/div[1]/h1")).getText();
	  System.out.println(myAccountPageVerify);
	  Assert.assertEquals("My Account", myAccountPageVerify);
  }
  
  @Test (dependsOnMethods = {"myAccount"})
  public void logIn() {
	  
	  // Locate the Login Button and click on It
	  driver.findElement(By.xpath("//*[@id=\"uagb-column-e9d225cb-cee9-4e02-a12d-073d5f051e91\"]/div[2]/div[2]/a")).click();
	  
	  // Locate the Username Box and enter username
	  driver.findElement(By.id("user_login")).sendKeys("root");
	  
	  // Locate the Password box and enter password 
	  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	  
	  // Click on the Login Button
	  driver.findElement(By.id("wp-submit")).click();
	  
	  // Verify You have login sucessfully
	  String loginSuccessMessage = driver.findElement(By.xpath("//*[@id=\"uagb-infobox-d9258720-3455-443e-b618-b57211636d84\"]/div/div/div/div[1]/h1")).getText();
	  
	  System.out.println(loginSuccessMessage);
	  Assert.assertEquals("My Account", loginSuccessMessage);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
