package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.EnterTimeTrackPage;
import page.LicensesPage;
import page.LoginPage;

public class TestLissueDate extends BaseTest{
	
	@Test(priority=3)
	public void CheckLicenseDate() {
		String UN = FWUtil.getXLData(XL_PATH, "TestLissueDate", 1, 0);
		String PW = FWUtil.getXLData(XL_PATH, "TestLissueDate", 1, 1);
		String LicIssueDate = FWUtil.getXLData(XL_PATH, "TestLissueDate", 1, 2);
		
		
		LoginPage l = new LoginPage(driver);
		l.setUserName(UN);
		l.setPassword(PW);
		l.ClickLoginBTN();
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.clickSettings();
		e.clickLicenses();
		LicensesPage c =  new LicensesPage(driver);
		c.verifyIssueDate(LicIssueDate);
		c.clickLogout();
	}

}
