package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import helper.Helper;
import pages.ProfilePage;
import org.openqa.selenium.By;

public class ProfileTest extends BaseTest {

    private ProfilePage profilePage;
    private Helper helper;

    @BeforeClass
    public void setUpPage() {
        helper = new Helper(driver);
        profilePage = new ProfilePage(helper);
        profilePage.clickProfileTab();
    }

    @Test(priority = 1)
    public void verifyProfileElements() {
        Assert.assertTrue(profilePage.isProfileIconVisible(), "Profile icon not visible");
        Assert.assertEquals(profilePage.getAgentName(), "Sharat", "Agent Name mismatch");
        Assert.assertEquals(profilePage.getDPDZeroText(), "DPDZero", "DPDZero text mismatch");
        Assert.assertEquals(profilePage.getPhoneNumber(), "Phone Number", "Phone Number mismatch");
        Assert.assertEquals(profilePage.getUsername(), "Username", "Username mismatch");
        Assert.assertEquals(profilePage.getEmail(), "Email", "Email mismatch");
        Assert.assertEquals(profilePage.getGender(), "Gender", "Gender mismatch");
    }

    @Test(priority = 2)
    public void verifyLogoutButton() {
        profilePage.clickLogoutButton();
        By loginButton = By.id("com.outsystemsenterprise.dpdzero_app:id/btn_login");
        Assert.assertTrue(helper.isElementvisible(loginButton), "Logout failed");
    }
}
