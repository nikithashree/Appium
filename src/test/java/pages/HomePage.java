package pages;


import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helper.Helper;
 
public class HomePage {
  private AndroidDriver driver;
  private Helper helper; 
  
 private By otptext= By.xpath("//android.widget.TextView[@text='Verify OTP']");
 private By verificationcode= By.xpath("//android.widget.TextView[@text=\"We've sent a 6-digit verification code to\"]");
 
 
}
