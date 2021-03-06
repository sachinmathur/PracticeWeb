package sac.PracticeWeb.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sac.PracticeWeb.PageObject.DemoSitePage;
import sac.PracticeWeb.PageObject.DraggablePage;
import sac.PracticeWeb.baseSetUp.TestBaseSetUp;

public class DemoSitePageTest extends TestBaseSetUp {

	private WebDriver driver;
	private DemoSitePage demoSitePage;
	private DraggablePage draggablepage;
	
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
	
	public void demoSitePageFactory()
	{
		this.demoSitePage = PageFactory.initElements(driver, DemoSitePage.class);
		return;
	}
	
	@Test
	public void testLoginToDemoSite()
	{
		this.demoSitePageFactory();
		this.draggablepage = demoSitePage.logintoDemoSite();
	}
	
}