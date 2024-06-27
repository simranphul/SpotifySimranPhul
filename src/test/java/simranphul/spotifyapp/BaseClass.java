package simranphul.spotifyapp;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException
	{
		 if (service != null && service.isRunning()) {
		        service.stop();
		    }
		
				//start appium server programmatically instead of terminal everytime, Create and configure the Appium service
				service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js")) // Path to Appium's main.js file
						.withIPAddress("127.0.0.1").usingPort(4723).build();  // IP address to bind the server to localhost and Port number to listen on
				service.start();  // Build the Appium service

				UiAutomator2Options options = new UiAutomator2Options();  // Create and configure UiAutomator2 options, UiAutomator2 is a powerful framework for automating UI tests on Android devices, providing the capability to simulate user interactions, and access system utilities. 
				options.setDeviceName("Simranemulator");  //Android studio emulator name
				options.setApp("//Users//sar//eclipse-workspace//spotifyapp//src//test//java//resources//Spotify_ Music and Podcasts_8.9.48.575_APKPure.apk"); 
				
				// Initialize the AndroidDriver with the Appium server URL and the configured options		
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options); 
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  //setting implicit wait for elements to be visible

	}
	
	
	
	
	@AfterClass
	public void tearDown()
	{
		if (driver != null) {
            driver.quit();
            service.stop();
		}
		
		 //stop appium server
	}
	
}
