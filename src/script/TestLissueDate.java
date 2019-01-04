package script;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.EnterTimeTrackPage;
import page.LicensesPage;
import page.LoginPage;

@Listeners(listener.ListenersImplementation.class)
public class TestLissueDate extends BaseTest{
	
	private Logger logger;

	@Test(priority=3, description="Validating the Correct Product Licence Issue Date")
	public void CheckLicenseDate() {
		logger = Logger.getLogger(TestAddTaskLnk.class.getName());
		PropertyConfigurator.configure("log4j.properties");
		
		logger.info("Reading UN From Input Excel File");
		String UN = FWUtil.getXLData(XL_PATH, "TestLissueDate", 1, 0);
		logger.info("Username Used : "+UN);
		logger.info("Reading PW From Input Excel File");
		String PW = FWUtil.getXLData(XL_PATH, "TestLissueDate", 1, 1);
		logger.info("Password Used : "+PW);
		String LicIssueDate = FWUtil.getXLData(XL_PATH, "TestLissueDate", 1, 2);
		logger.info("LicIssueDate Is:"+LicIssueDate);
		
		LoginPage l = new LoginPage(driver);
		
		l.setUserName(UN);
		logger.info("Entering UN");
		
		
		l.setPassword(PW);
		logger.info("Entering PW");
		
		l.ClickLoginBTN();
		logger.info("Clicking LoginBTN");
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		
		e.clickSettings();
		logger.info("Click on Setting");
		e.clickLicenses();
		logger.info("Click on Licenses");
		LicensesPage c =  new LicensesPage(driver);
		c.verifyIssueDate(LicIssueDate);
		logger.info("Verify Licenses Issue Date");
		c.clickLogout();
		logger.info("Click On Logout");
	}

}
