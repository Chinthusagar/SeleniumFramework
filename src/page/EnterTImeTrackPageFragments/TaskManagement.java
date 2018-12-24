package page.EnterTImeTrackPageFragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TaskManagement {

	@FindBy(xpath="//span[.='Add Recent Task']")
	private WebElement AddTaskDDLnk;
	
	@FindBy(xpath="(//div[@class='taskList'])[2]")
	private WebElement AddTaskDD;
	
	
	
	
	public TaskManagement(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

	

	public void clickAddTask() {
		
		AddTaskDDLnk.click();
		
	}



	public void waitForTaskList(WebDriver driver, long eTO) {
		WebDriverWait wait = new WebDriverWait(driver, eTO);
		wait.until(ExpectedConditions.visibilityOf(AddTaskDD));
	}



	public void AssertDDIsVisible(WebDriver driver) {
		Assert.assertTrue(AddTaskDD.isDisplayed());
		
	}
	
	
	

}
