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
		
				//start appium server programmatically instead of terminal everytime
				service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();

				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("Simranemulator");  //Android studio emulator name
				options.setApp("//Users//sar//eclipse-workspace//spotifyapp//src//test//java//resources//Spotify_ Music and Podcasts_8.9.48.575_APKPure.apk"); 
				
							
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options); 
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  //setting implicit wait for elements to be visible

	}
	
	
	
	
	@AfterMethod
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop(); //stop appium server
	}
	
}
