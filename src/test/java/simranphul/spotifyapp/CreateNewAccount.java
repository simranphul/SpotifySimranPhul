package simranphul.spotifyapp;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class CreateNewAccount extends BaseClass {
	
	@BeforeMethod
	public void preSetup()
	{
		    ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
		        "appPackage", "com.spotify.music",
		        "appActivity", "com.spotify.login.loginflowimpl.LoginActivity"
		    ));
	}
		/* Activity activity= new Activity("com.spotify.music","com.spotify.login.loginflowimpl.LoginActivity");
		((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.spotify.music/com.spotify.login.loginflowimpl.LoginActivity")); */  //intent that specifies which activity to start
	

	@Test
	public void invalidPassword()
	{
		CreateAccount createAccount = new CreateAccount(driver); 
		createAccount.clickSignUpButton();	
		createAccount.setEmailField("testing1242421@gmail.com");
		createAccount.clickEmailNextButton();
		createAccount.setPasswordField("testing");
		String actualErrorMessage = createAccount.getErrorMessage();
        String expectedErrorMessage = "Use at least 10 characters."; 
        AssertJUnit.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match");
    }   
 	
	
	@Test
	public void existingAccountCloseClick()
	{
		CreateAccount createAccount = new CreateAccount(driver); 
		createAccount.clickSignUpButton();	
		createAccount.setEmailField("testing098765@gmail.com");
		createAccount.clickEmailNextButton();
		createAccount.clickCloseButton();	
	}
	
	@Test
	public void existingAccountGoToLoginClick()
	{
		CreateAccount createAccount = new CreateAccount(driver); 
		createAccount.clickSignUpButton();	
		createAccount.setEmailField("testing098765@gmail.com");
		createAccount.clickEmailNextButton();
		createAccount.clickGoToLoginButton();
	}
	
	@Test
	public void createAccountSuccess()
	{
		CreateAccount createAccount = new CreateAccount(driver); 
		createAccount.clickSignUpButton();	
		createAccount.setEmailField("testing9876543@gmail.com");
		createAccount.clickEmailNextButton();
		createAccount.setPasswordField("testing@123");
		createAccount.clickPasswordNextButton();
		createAccount.scrollToDate("Feb", "18", "1998");	
		createAccount.clickAgeNextButton();
		createAccount.setGender("female");
		createAccount.clickNameNextButton();			
     }
				
}
	

