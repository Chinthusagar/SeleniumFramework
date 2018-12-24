package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LicensesPage extends BasePage{
	
	
	@FindBy(xpath="//nobr[.='Issue Date:']/../../td[2]")
	private WebElement issueDate;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	@FindBy(xpath="//nobr[.='Product Edition:']/../../td[2]/b")
	private WebElement PrdEditionNum;
	
	public LicensesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	public void verifyIssueDate(String LicDate) {
		String actual = issueDate.getText();
		Assert.assertEquals(actual, LicDate);
	}

	public void clickLogout() {
		logoutLink.click();
		
	}

	public void verifyProductEdition(String ExpectedproductEdition) {
		String actualProductEdition = PrdEditionNum.getText();
		Assert.assertEquals(actualProductEdition, ExpectedproductEdition);
		
	}

}
