package Activity;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;

public class Activity2 {
	
	// Initialize Driver Object
	AndroidDriver driver;
	
	@BeforeClass
	  public void setUp() throws MalformedURLException {
			// Desired Capabilities
			UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName("android");
			options.setAutomationName("UiAutomator2");
			options.setAppPackage("com.android.chrome");
			options.setAppActivity("com.google.android.apps.chrome.Main");
			options.noReset();

			// Server Address
			URL serverURL = new URL("http://localhost:4723/");
			
			// Driver Initialization
			driver = new AndroidDriver(serverURL, options);
			
			// Open the page in chrome
			driver.get("https://v1.trainig-support.net");
	  }
  @Test
  public void f() {
	//  String pageTitle = driver.findElement(null)
  }
  

  @AfterClass
  public void afterClass() {
  }

}
