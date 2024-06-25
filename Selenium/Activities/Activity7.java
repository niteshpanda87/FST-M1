package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7 {
	public static void main(String args[]) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);
		
// Open a new browser to https://v1.training-support.net/selenium/drag-drop
		driver.get("https://v1.training-support.net/selenium/drag-drop");
				
// Get the title of the page and print it to the console.
		System.out.println("Page Titel Is: " +driver.getTitle());
		
// On the page, perform:
//		Find the ball 
		WebElement football = driver.findElement(By.id("draggable"));
//      Find dropzone1
		WebElement dropzone1 = driver.findElement(By.id("droppable"));
//		Find dropzone2
		WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
		
//		and simulate a click and drag to move it into "Dropzone 1".
		builder.clickAndHold(football).moveToElement(dropzone1).pause(2000).release().build().perform();
		
//		Verify that the ball has entered Dropzone 1.
		String verifyDropzone1 = dropzone1.findElement(By.tagName("p")).getText();
		if(verifyDropzone1.equals("Dropped!")) {
			System.out.println("Ball is in Dropzone1.");
		}
//		Once verified, move the ball into "Dropzone 2".
		builder.dragAndDrop(football, dropzone2).build().perform();
		
//		Verify that the ball has entered Dropzone 2.
		String verifyDropzone2 = dropzone2.findElement(By.tagName("p")).getText();
		if(verifyDropzone2.equals("Dropped!")) {
			System.out.println("Ball is in Dropzone2.");
		}
//Close the browser.
		driver.quit();
	}

}
