package sac.PracticeWeb.PageObject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoSitePage {

	final WebDriver driver;

	public DemoSitePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public DraggablePage logintoDemoSite()
	{
		String handle = driver.getWindowHandle();
		
		WebElement draggableInteraction = driver.findElement(By.xpath("//div[@class='linkbox margin-bottom-20']/ul/li[1]/a/h2[contains(.,'Draggable')]/following-sibling::figure"));
		draggableInteraction.click();
		switchWindow();
		WebDriverWait wait;
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='load_box']/form[@id='load_form']")));
		WebElement signIn = driver.findElement(By.xpath("//div[@class='bottom row']/div/p/a[contains(.,'Signin')]"));
		signIn.click();
		WebElement usernameTextbox = driver.findElement(By.xpath("//div[@id='login']/form[@id='load_form']/fieldset/input[@name='username']"));
		usernameTextbox.sendKeys("sachin.mathur");
		WebElement passwordTextbox = driver.findElement(By.xpath("//div[@id='login']/form[@id='load_form']/fieldset/input[@name='password']"));
		passwordTextbox.sendKeys("India@123");
		WebElement submitButton = driver.findElement(By.xpath("//div[@id='login']/form[@id='load_form']/div[@class='bottom row']/div/input[@value='Submit']"));
		submitButton.click();
		
		return PageFactory.initElements(driver, DraggablePage.class);
	}	
	
	
	public void switchWindow()
	{
		Set handles = driver.getWindowHandles();
		
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
	}
}