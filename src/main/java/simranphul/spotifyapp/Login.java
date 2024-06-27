package simranphul.spotifyapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import simranphul.spotifyapp.utils.AndroidActions;

public class Login extends AndroidActions {
	
AndroidDriver driver; //declaring an instance variable driver of type AndroidDriver. This is the driver object used to communicate with the Android device or emulator.
	
	//creating constructor
	public Login(AndroidDriver driver)
	{
		super(driver); //Super Constructor Call - calls the constructor of the superclass AndroidActions, passing the driver instance to it. This initializes the superclass with the driver.
		this.driver= driver; //assigning the driver passed to the constructor to the driver field of the CreateAccount class, ensuring it's accessible throughout the class.
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);  //initializes elements in the CreateAccount class using the Page Object Model approach
		
	} //elements value initialization
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"Log in\"]")
	private WebElement homeLoginButton;
	
	@AndroidFindBy(id="com.spotify.music:id/username_text")
	private WebElement emailField;
	
	@AndroidFindBy(id="com.spotify.music:id/password_text")
	private WebElement passwordField;
	
	@AndroidFindBy(id="com.spotify.music:id/login_button")
	private WebElement loginButton;
	
	@AndroidFindBy(id="com.spotify.music:id/button_positive")
	private WebElement okButton;
	
	@AndroidFindBy(accessibility="Home")
	private WebElement homeTab;
	 
	@AndroidFindBy(accessibility="Profile")
	private WebElement profile;
	 
	@AndroidFindBy(xpath="(//android.view.ViewGroup[@resource-id=\"com.spotify.music:id/link_row_sidedrawer_root\"])[3]")
	private WebElement settingsAndPrivacyButton;
	 
	@AndroidFindBy(className="android.widget.Button")
	private WebElement logoutButton;

	
	public void clickHomeLoginButton()
	{
		homeLoginButton.click();
	}
	
	
	public void setEmailField(String email)
	{
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	
	public void setPasswordField(String password)
	{
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	
	public void clickOkButton()
	{
		okButton.click();
	}
	
	public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
	
	
	public boolean isHomeTabDisplayed() {
        return homeTab.isDisplayed();
    }

	 
	 
	 public boolean isUserLoggedIn() {
	        try {
	            return homeTab.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	 
	 public void logoutUser() {
		    profile.click();
		    settingsAndPrivacyButton.click();
		    scrollToText("Log out");
		    logoutButton.click();
	    }
	
	
}
