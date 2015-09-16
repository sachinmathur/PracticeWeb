package sac.PracticeWeb.baseSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBaseSetUp {

	protected static WebDriver driver;
	String appURL = "http://www.way2automation.com";

	@BeforeSuite
	public void setUp()
	{
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile firefoxProfile = profile.getProfile("FirefoxAutomationProfile");
		driver = new FirefoxDriver(firefoxProfile);
		driver.manage().window().maximize();
		driver.get(appURL);
		TestBaseSetUp.setDriver();
	}
	
	public static WebDriver setDriver()
	{
		return driver;
	}

	@AfterSuite
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

}