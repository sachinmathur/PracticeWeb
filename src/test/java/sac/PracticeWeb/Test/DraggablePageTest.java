package sac.PracticeWeb.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sac.PracticeWeb.PageObject.DraggablePage;
import sac.PracticeWeb.baseSetUp.TestBaseSetUp;

public class DraggablePageTest extends TestBaseSetUp
{
	private WebDriver driver;
	private DraggablePage draggablePage;
	
	@BeforeClass
	public void beforeClass()
	{
		driver = setDriver();
	}
	
	@BeforeMethod
	public void waitBeforeCallingTestMethod()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void draggablePageFactory()
	{
		this.draggablePage = PageFactory.initElements(driver, DraggablePage.class);
		return;
	}
	
	@Test
	public void testClickDraggableInteraction()
	{
		this.draggablePageFactory();
		draggablePage.clickDraggableInteraction();
	}
}