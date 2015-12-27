package sac.PracticeWeb.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sac.PracticeWeb.PageObject.DemoSitePage;
import sac.PracticeWeb.PageObject.HomePage;
import sac.PracticeWeb.baseSetUp.TestBaseSetUp;

public class HomePageTest extends TestBaseSetUp{

	private WebDriver driver;
	private HomePage homePage;
	private DemoSitePage demoSitePage;
	
	@BeforeClass
	public void beforeClass()
	{
		this.driver = setDriver();
	}
	
	@BeforeMethod
	public void waitBeforeCallingTestMethod()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void homePageFactory()
	{
		this.homePage = PageFactory.initElements(driver, HomePage.class);
		return;
	}
	
	@Test
	public void testAssetPageTitle()
	{
		this.homePageFactory();
		String expectedPageTitle = "Selenium Training,Selenium Tutorial,Automation Testing Training";
		Assert.assertTrue(homePage.assertPageTitle(expectedPageTitle));
	}
	
	@Test
	public void testNavigateToDemoSite()
	{
		this.homePageFactory();
		this.demoSitePage = homePage.navigateToDemoSite();
	}
}