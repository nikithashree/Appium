package tests;

import org.openqa.selenium.By;
import helper.Helper;

public class ProfileTest {

    private Helper helper;

    // Constructor
    public ProfileTest(Helper helper) {
        this.helper = helper;
    }

    // Locators
    private By profileTab = By.xpath("//android.widget.TextView[@text='Profile']");
    private By profileIcon = By.xpath("//android.widget.ImageView");
    private By agentName = By.xpath("//android.widget.TextView[@text='Sharat']");
    private By dpdZeroText = By.xpath("//android.widget.TextView[@text='DPDZero']");
    private By phoneLabel = By.xpath("//android.widget.TextView[@text='Phone Number']");
    private By usernameLabel = By.xpath("//android.widget.TextView[@text='Username']");
    private By emailLabel = By.xpath("//android.widget.TextView[@text='Email']");
    private By genderLabel = By.xpath("//android.widget.TextView[@text='Gender']");
    private By logoutButton = By.xpath("//android.widget.TextView[@text='Logout']");

    // Actions 

    public void clickProfileTab() {
        helper.clickElement(profileTab);
    }

    public boolean isProfileIconVisible() {
        return helper.isElementvisible(profileIcon);
    }

    public boolean isAgentNameVisible() {
        return helper.isElementvisible(agentName);
    }

    public boolean isDPDZeroVisible() {
        return helper.isElementvisible(dpdZeroText);
    }

    public boolean isPhoneLabelVisible() {
        return helper.isElementvisible(phoneLabel);
    }

    public boolean isUsernameLabelVisible() {
        return helper.isElementvisible(usernameLabel);
    }

    public boolean isEmailLabelVisible() {
        return helper.isElementvisible(emailLabel);
    }

    public boolean isGenderLabelVisible() {
        return helper.isElementvisible(genderLabel);
    }

    public boolean isLogoutButtonVisible() {
        return helper.isElementvisible(logoutButton);
    }

    public void clickLogout() {
        helper.clickElement(logoutButton);
    }
}
