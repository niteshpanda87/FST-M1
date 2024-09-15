package Activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9 {
	
	public static void main(String args[]) {
		WebDriverManager.firefoxdriver().setup();		
		WebDriver driver = new FirefoxDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	//	Open a new browser to https://v1.training-support.net/selenium/dynamic-controls
		driver.get("https://v1.training-support.net/selenium/ajax");
		
	//	Get the title of the page and print it to the console.
		driver.findElement(By.className("violet")).click();
		
		String headingText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))).getText();
		System.out.println("New heading is: " + headingText);
	//	On the page, perform:
	//	Find the checkbox toggle button and click it.
		
	//	Wait for the text to change to contain "I'm late!". Print the new message on the page.
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
		
		String lateText = driver.findElement(By.tagName("h3")).getText();
		System.out.println("Late text is :" +lateText);
	//	Click the button again. Wait till it appears and check the checkbox.
	//	Close the browser.
			
		driver.quit();
	}

}
