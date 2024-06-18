package simranphul.spotifyapp;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;

public class LoginToApp extends BaseClass {
	
	@Test
	public void testInvalidPassword() {
	    // Test steps for invalid password login
		Login login =new Login(driver);
		login.clickHomeLoginButton();
		login.setEmailField("testing098765@gmail.com");	
		login.setPasswordField("testing023231");
		login.clickLoginButton();
		login.clickOkButton();	
	}
	
	@Test
	public void testSuccessfulLogin()
	{
		Login login =new Login(driver);
		login.clickHomeLoginButton();
		login.setEmailField("testing098765@gmail.com");	
		login.setPasswordField("testing098765");
		login.clickLoginButton();
        AssertJUnit.assertTrue(login.getHomeTab().isDisplayed());
		
	// driver.findElement(By.id("com.spotify.music:id/username_text")).clear();
	// 	driver.findElement(By.id("com.spotify.music:id/username_text")).sendKeys("testing098765@gmail.com");
	//	driver.findElement(By.id("com.spotify.music:id/password_text")).clear();
	//	driver.findElement(By.id("com.spotify.music:id/password_text")).sendKeys("testing098765");
	//	driver.findElement(By.id("com.spotify.music:id/login_button")).click();
	}
	
}
