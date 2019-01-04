
package page;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public abstract class BasePage {
	
	
	
	@FindBy(xpath ="//div[contains(text(),'Settings')]")
	private WebElement settingsBTN;
	
	@FindBy(xpath="//li/a[.='Licenses']")
	private WebElement licensesLNK;
	
	
	public void clickSettings() {
		settingsBTN.click();
	}
	
	public void clickLicenses() {
		licensesLNK.click();
	}

}
