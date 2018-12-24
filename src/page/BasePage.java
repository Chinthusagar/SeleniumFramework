
package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
