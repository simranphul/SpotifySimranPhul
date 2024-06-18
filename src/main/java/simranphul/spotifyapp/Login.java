package simranphul.spotifyapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import simranphul.spotifyapp.utils.AndroidActions;

public class Login extends AndroidActions {
	
AndroidDriver driver;
	
	//creating constructor
	public Login(AndroidDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	} //elements value initialization
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"Log in\"]")
	private WebElement homeLoginButton;
	
	public void clickHomeLoginButton()
	{
		homeLoginButton.click();
	}

	@AndroidFindBy(id="com.spotify.music:id/username_text")
	private WebElement emailField;
	
	public void setEmailField(String email)
	{
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	@AndroidFindBy(id="com.spotify.music:id/password_text")
	private WebElement passwordField;
	
	public void setPasswordField(String password)
	{
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	@AndroidFindBy(id="com.spotify.music:id/login_button")
	private WebElement loginButton;
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	@AndroidFindBy(id="com.spotify.music:id/button_positive")
	private WebElement okButton;
	
	public void clickOkButton()
	{
		okButton.click();
	}
	
	@AndroidFindBy(accessibility="Home")
	private WebElement homeTab;
	
	 public WebElement getHomeTab() {
	        return homeTab;
	    }
	
	
	
	
	
}
