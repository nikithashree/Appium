package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Helper;

public class LoginPage {

	private Helper helper;

	private By logo = By.xpath("//android.widget.ImageView");
	private By welcomeText = By.xpath("//android.widget.TextView[@text='Welcome']");
	private By signInText = By.xpath("//android.widget.TextView[@text='Sign in to continue']");
	private By usernameField = By.xpath("(//android.widget.EditText)[1]");
	private By passwordField = By.xpath("(//android.widget.EditText)[2]");
	private By showButton = By.xpath("//android.widget.TextView[@text='Show']");
	private By hideButton = By.xpath("//android.widget.TextView[@text='Hide']");
	private By continueButton = By.xpath("//android.view.ViewGroup[@content-desc='Continue']");
	private By errorMessage = By.xpath("//android.widget.TextView[@text='Password is required']");
	// private By alert= By.id("com.dpdzero.pathfinder.uat:id/alert_title");
	private By otptext = By.xpath("//android.widget.TextView[contains(@text,'Verify OTP')]");
	private By alertOkButton = By.id("android:id/button1");

	public LoginPage(Helper helper) {

		this.helper = helper;

	}

	public boolean isLogovisile() {
		return helper.isElementvisible(logo);
	}

	public boolean isWelcomeTextVisible() {
		return helper.isElementvisible(welcomeText);
	}

	public boolean isSignInTextVisible() {
		return helper.isElementvisible(signInText);
	}

	public boolean isUsernamefieldVisible() {
		return helper.isElementvisible(usernameField);
	}

	public boolean isPasswordfieldVisible() {
		return helper.isElementvisible(passwordField);
	}

	public boolean isshowbuttondVisible() {
		return helper.isElementvisible(showButton);
	}

	public boolean iscontinuebuttonVisible() {
		return helper.isElementvisible(continueButton);
	}

	public boolean isotptextvisible() {
		return helper.isElementvisible(otptext);
	}

	public void Enterusername(String username) {
		WebElement usernameElement = helper.createElement(usernameField);
		usernameElement.sendKeys(username);
	}

	public void EnterPassword(String password) {
		WebElement passwordElement = helper.createElement(passwordField);
		passwordElement.sendKeys(password);
	}

	public void clickshowbutton() {
		helper.clickElement(showButton);
	}

	public String getPasswordText() {
		WebElement passwordElement = helper.createElement(passwordField);
		return helper.extractText(passwordElement);

	}

	public void clickhidebutton() {
		helper.clickElement(hideButton);
	}

	public void clickcontinuebutton() {
		helper.clickElement(continueButton);

	}

	public String geterrormessage() {
		WebElement errorElement = helper.createElement(errorMessage);
		return helper.extractText(errorElement);
	}

	public String alertmessage() {
		WebElement alertElement = helper.createElement(alertOkButton);
		return helper.extractText(alertElement);
	}

}