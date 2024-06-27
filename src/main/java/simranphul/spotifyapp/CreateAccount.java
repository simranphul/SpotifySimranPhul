package simranphul.spotifyapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import simranphul.spotifyapp.utils.AndroidActions;

public class CreateAccount extends AndroidActions {
	
	AndroidDriver driver;  //declaring an instance variable driver of type AndroidDriver. This is the driver object used to communicate with the Android device or emulator.
	
	//constructor executes a block of code whenever an object is created, will not return any values and name same as classname
	public CreateAccount(AndroidDriver driver)
	{
		super(driver);  //Super Constructor Call - super brings value from parent class. calls the constructor of the superclass AndroidActions, passing the driver instance to it. This initializes the superclass with the driver. 
		this.driver= driver;  //assigning the driver passed to the constructor to the driver field of the CreateAccount class, ensuring it's accessible throughout the class. this brings value from class/object level
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);  //initializes elements in the CreateAccount class using the Page Object Model approach
		
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"Sign up free\"]")
	private WebElement signUpButton;
	
	@AndroidFindBy(id="com.spotify.music:id/email")
	private WebElement emailField;
	
	@AndroidFindBy(id="com.spotify.music:id/gender_button_male")
	private WebElement maleOption;
	
	@AndroidFindBy(id="com.spotify.music:id/gender_button_female")
	private WebElement femaleOption;
	
	@AndroidFindBy(id="com.spotify.music:id/email_next_button")
	private WebElement emailNextButton;

	
	@AndroidFindBy(id="com.spotify.music:id/input_password")
	private WebElement passwordField;
	
	@AndroidFindBy(id="com.spotify.music:id/password_next_button")
	private WebElement passwordNextButton;
	
	@AndroidFindBy(id="com.spotify.music:id/age_next_button")
	private WebElement ageNextButton;
	
	@AndroidFindBy(id="com.spotify.music:id/name_next_button")
	private WebElement nameNextButton;
	
	@AndroidFindBy(id="com.spotify.music:id/button_negative")
	private WebElement closeButton;
	
	
	@AndroidFindBy(id="com.spotify.music:id/button_positive")
	private WebElement goToLoginButton;
	
	@AndroidFindBy(id="com.spotify.music:id/password_error_message")
	private WebElement passwordErrorMessage;
	
	
	
	
	public void clickSignUpButton()
	{
		signUpButton.click();
	}
	
	
	public void clickEmailNextButton()
	{
		emailNextButton.click();
	}
	
	
	public void setEmailField(String email)
	{
		emailField.sendKeys(email);
	}
	
	public void setGender(String gender)
	{
		if(gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
	}
	
	public void setPasswordField(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void clickPasswordNextButton()
	{
		passwordNextButton.click();
	}
	
	public void clickAgeNextButton()
	{
		ageNextButton.click();
	}
	
	public void clickNameNextButton()
	{
		nameNextButton.click();
	}
	
	public void clickCloseButton()
	{
		closeButton.click();
	}
	
	public void clickGoToLoginButton()
	{
		goToLoginButton.click();
	}
	
	public String getErrorMessage() {
        return passwordErrorMessage.getText();
    }
	
	public void scrollToDate(String month, String day, String year) {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().className(\"android.widget.NumberPicker\").index(0)).scrollIntoView(new UiSelector().text(\"" + month + "\"));" +
            "new UiScrollable(new UiSelector().className(\"android.widget.NumberPicker\").index(1)).scrollIntoView(new UiSelector().text(\"" + day + "\"));" +
            "new UiScrollable(new UiSelector().className(\"android.widget.NumberPicker\").index(2)).scrollIntoView(new UiSelector().text(\"" + year + "\"));"
        ));
	
}
}
