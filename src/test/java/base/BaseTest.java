package base;

import helper.ConfigReader;
import java.net.URI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import helper.Helper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

	public AndroidDriver driver;
	public Helper helper;
	public static String username;
	public static String password;

	@BeforeSuite
	public void logincredentials() {
		username = ConfigReader.getProperty("app.username");
		password = ConfigReader.getProperty("app.password");
	}

	@BeforeClass
	public void setUp() throws MalformedURLException {

		String USERNAME = ConfigReader.getProperty("browserstack.user");
		String ACCESS_KEY = ConfigReader.getProperty("browserstack.key");
		String APP_ID = ConfigReader.getProperty("app.id");
		String DEVICE_NAME = ConfigReader.getProperty("device.name");
		String PLATFORM_VERSION = ConfigReader.getProperty("platform.version");
		String PROJECT = ConfigReader.getProperty("project.name");
		String BUILD = ConfigReader.getProperty("build.name");
		String TEST_NAME = ConfigReader.getProperty("test.name");

		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		BUILD = BUILD + "_" + timestamp;
		TEST_NAME = TEST_NAME + "_" + timestamp;

		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("browserstack.user", USERNAME);
		options.setCapability("browserstack.key", ACCESS_KEY);
		options.setApp(APP_ID);
		options.setDeviceName(DEVICE_NAME);
		options.setPlatformVersion(PLATFORM_VERSION);
		options.setCapability("project", PROJECT);
		options.setCapability("build", BUILD);
		options.setCapability("name", TEST_NAME);

		String browserstackURL = String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", USERNAME, ACCESS_KEY);
		URL url = URI.create(browserstackURL).toURL();

		driver = new AndroidDriver(url, options);
		helper = new Helper(driver);

		System.out.println("App launched successfully on BrowserStack");

	}

	@BeforeMethod
	public void resetAppBeforeTest() {
		if (driver != null) {
			System.out.println("Resetting app to initial state");

			driver.resetApp();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("App reset complete");
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Driver closed successfully");
		}
	}
}