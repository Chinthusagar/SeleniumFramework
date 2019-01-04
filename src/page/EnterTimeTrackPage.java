package page;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import generic.BaseTest;

public class EnterTimeTrackPage extends BasePage{
	
	
	
	WebDriver driver;
	
	@FindBy(xpath="//span[.='Add Recent Task']")
	private WebElement AddTaskDDLnk;
	
	@FindBy(xpath="(//div[@class='taskList'])[2]")
	private WebElement AddTaskDD;

	
	public EnterTimeTrackPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void ClickOnAddAddRecentTaskLnk() {
		AddTaskDDLnk.click();
		
	}
	
	
	
	
	
	public void verifiedHomepageIsDisplayed(long ETO, String eTitle) {
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.titleIs(eTitle));
		String aTitle = driver.getTitle();
		Assert.assertEquals(aTitle,eTitle);
		
	}

	public void waitForTaskListOptions(long ETO) {
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.visibilityOf(AddTaskDD));		
	}

	public void AssertDDVisible() {
		Assert.assertTrue(AddTaskDD.isDisplayed());
		
	}

}
