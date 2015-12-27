package sac.PracticeWeb.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DraggablePage {
	
	final WebDriver driver;
	
	public DraggablePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickDraggableInteraction()
	{
		WebElement draggableInteraction = driver.findElement(By.xpath("//div[@class='linkbox margin-bottom-20']/ul/li[1]/a/h2[contains(.,'Draggable')]/following-sibling::figure"));
		draggableInteraction.click();
	}
}