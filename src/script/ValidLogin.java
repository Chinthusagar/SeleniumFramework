package script;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import generic.BaseTest;
import generic.FWUtil;
import listener.ListenersImplementation;
import page.EnterTimeTrackPage;
import page.LoginPage;

@Listeners(listener.ListenersImplementation.class)
public class ValidLogin extends BaseTest{
	


	private Logger logger;

	@Test(priority=1, description="Valid Login Scenario")
	public void testValidLogin() {
		logger = Logger.getLogger(ValidLogin.class.getName());
		PropertyConfigurator.configure("log4j.properties");
		
		
		
		logger.info("Reading UN From Input Excel File");
		String UN = FWUtil.getXLData(XL_PATH, "ValidLogin",1,0);
		logger.info("Username Used : "+UN);
		logger.info("Reading PW From Input Excel File");
		String PW = FWUtil.getXLData(XL_PATH, "ValidLogin",1,1);
		logger.info("Password Used : "+PW);
		String title = FWUtil.getXLData(XL_PATH, "ValidLogin",1,2);
		logger.info("Home Page Title : "+title);
		
		
		
		LoginPage l = new LoginPage(driver);
		l.setUserName(UN);
		logger.info("Entering UN");
		
		
		l.setPassword(PW);
		logger.info("Entering PW");
		
		l.ClickLoginBTN();
		logger.info("Clicking LoginBTN");
		//validate load home page
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.verifiedHomepageIsDisplayed( ETO, title);
		logger.info("Verifying Home Page Title Post Login");
	}

}
