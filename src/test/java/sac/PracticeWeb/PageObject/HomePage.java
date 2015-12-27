package sac.PracticeWeb.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	final WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean assertPageTitle(String expectedPageTitle)
	{
		boolean onCorrectPage = false;
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		if(expectedPageTitle.equals(pageTitle))
		{
			onCorrectPage = true;
		}
		
		else
		{
			onCorrectPage = false;
		}
		return onCorrectPage;
	}
	
	public DemoSitePage navigateToDemoSite()
	{
		WebElement menu = driver.findElement(By.linkText("Demo Site"));
		
		Actions builder = new Actions(driver);		
		builder.moveToElement(menu).build().perform();
		WebElement subMenu = driver.findElement(By.linkText("Test Demo Site"));
		builder.moveToElement(subMenu).click().build().perform();
		
		WebElement draggableInteraction = driver.findElement(By.xpath("//div[@class='linkbox margin-bottom-20']/ul/li[1]/a/h2[contains(.,'Draggable')]/following-sibling::figure"));
		WebDriverWait wait;
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(draggableInteraction));
		
		return PageFactory.initElements(driver, DemoSitePage.class);
	}
}