
package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	private LoginPage loginPage;

	@BeforeClass
	public void setup() {
		loginPage = new LoginPage(helper);

	}

	@Test(priority = 1)
	public void visualVerification() {

		Assert.assertTrue(loginPage.isLogovisile(), "logo is not displayed");
		Assert.assertTrue(loginPage.isWelcomeTextVisible(), "welcome text is not displayed");
		Assert.assertTrue(loginPage.isSignInTextVisible(), "signin text is not displayed");
		Assert.assertTrue(loginPage.isUsernamefieldVisible(), "username field is not displayed");
		Assert.assertTrue(loginPage.isPasswordfieldVisible(), "password field is not displayed");
		Assert.assertTrue(loginPage.isshowbuttondVisible(), "show button is not displayed");
		Assert.assertTrue(loginPage.iscontinuebuttonVisible(), "continue button is not displayed");
	}

	@Test(priority = 2)
	public void FunctionalityTest() {

		loginPage.Enterusername(username);
		loginPage.EnterPassword(password);
		loginPage.clickshowbutton();

		String actualpassword = loginPage.getPasswordText();
		Assert.assertEquals(actualpassword, password, "Password mismatch after clicking Show button");

		loginPage.clickhidebutton();
		String maskedtext = loginPage.getPasswordText();
		Assert.assertNotEquals(maskedtext, password, "Password mismatch after clicking Show button");

		System.out.println("Password is hidden");

		loginPage.clickcontinuebutton();

	}

	@Test(priority = 3)
	public void NegativeTest() {
		loginPage.Enterusername(username);
		loginPage.clickcontinuebutton();

		String actualerrormessage = loginPage.geterrormessage();
		Assert.assertTrue(actualerrormessage.equalsIgnoreCase("Password is required"));

		System.out.println("Verified error message displayed");

		loginPage.Enterusername(username);
		loginPage.EnterPassword("whweif");
		loginPage.clickcontinuebutton();

		String actualalert = loginPage.alertmessage();
		Assert.assertEquals(actualalert, "OK");
		System.out.println("Verified error message displayed");

	}

}
