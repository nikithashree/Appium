package helper;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class Helper {

	private WebDriverWait wait;

	public Helper(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public WebElement createElement(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public boolean isElementvisible(By locator) {
		return waitForElement(locator).isDisplayed();
	}

	public String extractText(WebElement e) {
		return e.getText();
	}

	public void clickElement(By locator) {
		WebElement Element = waitForElement(locator);
		Element.click();
	}

	public void sendkeys(By locator, String text) {
		WebElement Element = waitForElement(locator);
		Element.clear();
		Element.sendKeys(text);
	}

}
