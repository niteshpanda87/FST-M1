package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {
	public static void main(String args[]) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);
		
		
// Open a new browser to https://v1.training-support.net/selenium/input-events
		driver.get("https://v1.training-support.net/selenium/input-events");
		
// Get the title of the page and print it to the console.
		System.out.println("Page Titel Is: " +driver.getTitle());
		
//On the page, perform:
//	Left click 
		builder.click().pause(1000).build().perform();
//  and print the value of the side in the front.
		String frontText = driver.findElement(By.className("active")).getText();
		System.out.println(frontText);

//	Double click to show a random side
		builder.doubleClick().pause(1000).build().perform();
//  and print the number.
		frontText = driver.findElement(By.className("active")).getText();
		System.out.println(frontText);
			
		
//	Right click 
		builder.contextClick().pause(1000).build().perform();
//  and print the value shown on the front of the cube.
		frontText = driver.findElement(By.className("active")).getText();
		System.out.println(frontText);
			
// Close the browser.
		driver.quit();
	}

}
