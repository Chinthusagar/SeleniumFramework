package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.FWUtil;

public class LoginPage {
	
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement LoginBTN;
	
	@FindBy(xpath="//span[contains(text(),'invalid')]")
	private WebElement errorMDG;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void setUserName(String UN) {
		unTB.clear();
		unTB.sendKeys(UN);
	}
	
	public void setPassword(String PW) {
		pwTB.clear();
		pwTB.sendKeys(PW);
	}
	
	public void ClickLoginBTN() {
		LoginBTN.click();
	}
	
	public void verifyErrMsgIsDisplayed() {
		FWUtil.Sleep(1000);
		Assert.assertTrue(errorMDG.isDisplayed());
	}
	

}
