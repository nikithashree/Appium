package pages;

import org.openqa.selenium.By;
import helper.Helper;

public class ProfilePage {

    private Helper helper;

    // LOCATORS 
    private By profileTab = By.xpath("//android.widget.TextView[@text='Profile']");
    private By agentName = By.xpath("//android.widget.TextView[@resource-id='com.outsystemsenterprise.dpdzero_app:id/tv_agent_name']");
    private By dpdZeroText = By.xpath("//android.widget.TextView[@resource-id='com.outsystemsenterprise.dpdzero_app:id/tv_dpdzero']");
    private By phoneNumber = By.xpath("//android.widget.TextView[contains(@text,'Phone Number')]/following-sibling::android.widget.TextView");
    private By username = By.xpath("//android.widget.TextView[contains(@text,'Username')]/following-sibling::android.widget.TextView");
    private By email = By.xpath("//android.widget.TextView[contains(@text,'Email')]/following-sibling::android.widget.TextView");
    private By gender = By.xpath("//android.widget.TextView[contains(@text,'Gender')]/following-sibling::android.widget.TextView");

    private By logoutButton = By.xpath("//android.widget.TextView[@text='Logout']");

    // CONSTRUCTOR 
    public ProfilePage(Helper helper) {
        this.helper = helper;
    }

    // ACTION METHODS 
    public void clickProfileTab() {
        helper.clickElement(profileTab);
    }

    public String getAgentName() {
        return helper.extractText(helper.waitForElement(agentName));
    }

    public String getDPDZeroText() {
        return helper.extractText(helper.waitForElement(dpdZeroText));
    }

    public String getPhoneNumber() {
        return helper.extractText(helper.waitForElement(phoneNumber));
    }

    public String getUsername() {
        return helper.extractText(helper.waitForElement(username));
    }

    public String getEmail() {
        return helper.extractText(helper.waitForElement(email));
    }

    public String getGender() {
        return helper.extractText(helper.waitForElement(gender));
    }

    public void clickLogout() {
        helper.clickElement(logoutButton);
    }
}
