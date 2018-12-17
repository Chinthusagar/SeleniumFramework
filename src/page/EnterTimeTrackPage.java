package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EnterTimeTrackPage {
	
	@FindBy(xpath ="//div[contains(text(),'Settings')]")
	private WebElement settingsBTN;
	
	@FindBy(xpath="//li/a[.='Licenses']")
	private WebElement licensesLNK;
	
	
	public EnterTimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickSettings() {
		settingsBTN.click();
	}
	
	public void clickLicenses() {
		licensesLNK.click();
	}
	
	public void verifiedHomepageIsDisplayed(WebDriver driver, long ETO, String eTitle) {
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.titleIs(eTitle));
		String aTitle = driver.getTitle();
		Assert.assertEquals(aTitle,eTitle);
	}

}
