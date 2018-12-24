package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import page.EnterTImeTrackPageFragments.TaskManagement;

public class EnterTimeTrackPage extends BasePage{
	
	
	
	
	
	
	
	public EnterTimeTrackPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void ClickOnAddAddRecentTaskLnk(WebDriver driver) {
		TaskManagement tm = new TaskManagement(driver);
		tm.clickAddTask();
		
	}
	
	
	
	
	
	public void verifiedHomepageIsDisplayed(WebDriver driver, long ETO, String eTitle) {
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.titleIs(eTitle));
		String aTitle = driver.getTitle();
		Assert.assertEquals(aTitle,eTitle);
	}

	public void waitForTaskListOptions(WebDriver driver, long ETO) {
		TaskManagement tm = new TaskManagement(driver);
		tm.waitForTaskList(driver, ETO);		
	}

	public void AssertDDVisible(WebDriver driver) {
		TaskManagement tm = new TaskManagement(driver);
		tm.AssertDDIsVisible(driver);
		
	}

}
