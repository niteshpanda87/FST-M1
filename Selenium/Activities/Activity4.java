package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4 {
	public static void main(String args[]) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
// Open a new browser to https://v1.training-support.net/selenium/target-practice
		driver.get("https://v1.training-support.net/selenium/target-practice");
		
//Get the title of the page and print it to the console.
		System.out.println("Title of the Page Is: " +driver.getTitle());
		
//Using xpath:
//      Find the 3rd header on the page and print it's text to the console.
		String thirdHeader = driver.findElement(By.xpath("//h3[@id = 'third-header']")).getText();
		System.out.println("Text on the third header is: " +thirdHeader);
		
//		Find the 5th header on the page and print it's color.
		String fifthHeader = driver.findElement(By.xpath("//h5[text() = 'Fifth header']")).getCssValue("color");
		System.out.println("Color on the Fifth header is: " +fifthHeader);
		
//Using any other locator:
//		Find the violet button and print all it's classes.
		String violetButtonClass = driver.findElement(By.xpath("//button[text() = 'Violet']")).getAttribute("class");
		System.out.println("Class of Violet is: " +violetButtonClass);
		
//		Find the grey button and print it's text.
		String textGreyButton = driver.findElement(By.xpath("//button[text() = 'Grey']")).getText();
		System.out.println("Tex of Grey Button is: " +textGreyButton);

//		Close the browser.
		driver.quit();
	}

}
