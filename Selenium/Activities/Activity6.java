package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {
	public static void main(String args[]) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);
		
		
// Open a new browser to https://v1.training-support.net/selenium/input-events
		driver.get("https://v1.training-support.net/selenium/input-events");
		
// Get the title of the page and print it to the console.
		System.out.println("Page Titel Is: " +driver.getTitle());
	
// On the page, perform:
//     Press the key of first letter of your name in caps
		builder.sendKeys("N").build().perform();
		
//     Press CTRL+a and the CTRL+c to copy all the text on the page.
//	   (Paste the text in a text editor to verify results.)
		builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();

// Close the browser.
		driver.quit();
	}

}
