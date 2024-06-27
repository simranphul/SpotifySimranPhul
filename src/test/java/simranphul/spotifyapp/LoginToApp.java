package simranphul.spotifyapp;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;

public class LoginToApp extends BaseClass {
	
	Login login;
	
    @BeforeMethod  //this method will run before each test method
    public void setUp() {
        login = new Login(driver);  //Login object created using driver from baseclass
        if (login.isUserLoggedIn()) {
            login.logoutUser();
        }
    }
    
	
	@Test
	public void testInvalidPassword() {
	    // Test steps for invalid password login
		login.clickHomeLoginButton();
		login.setEmailField("testing098765@gmail.com");	
		login.setPasswordField("testing023231");
		login.clickLoginButton();
		login.clickOkButton();	
		
		// Verify that the user is not logged in by checking the presence of the login button again
        Assert.assertTrue(login.isLoginButtonDisplayed(), "Login button should be displayed after failed login attempt");
    }
	
	
	@Test
	public void testSuccessfulLogin()
	{
		login.clickHomeLoginButton();
		login.setEmailField("testing098765@gmail.com");	
		login.setPasswordField("testing098765");
		login.clickLoginButton();
		
		// Verify that the home tab is displayed, indicating a successful login
        Assert.assertTrue(login.isHomeTabDisplayed(), "Home tab should be displayed after successful login");
    }
    
	/* AssertJUnit.assertTrue(login.getHomeTab().isDisplayed());	
	 driver.findElement(By.id("com.spotify.music:id/username_text")).clear();
	 	driver.findElement(By.id("com.spotify.music:id/username_text")).sendKeys("testing098765@gmail.com");
		driver.findElement(By.id("com.spotify.music:id/password_text")).clear();
		driver.findElement(By.id("com.spotify.music:id/password_text")).sendKeys("testing098765");
		driver.findElement(By.id("com.spotify.music:id/login_button")).click(); */
		
	
}
