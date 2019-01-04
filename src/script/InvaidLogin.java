package script;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import generic.BaseTest;
import generic.FWUtil;
import generic.Log;
import page.LoginPage;

@Listeners(listener.ListenersImplementation.class)
public class InvaidLogin  extends BaseTest{
	

	private Logger logger;

	@Test(priority =2, description="Validate Invalid Login")
	public void InVaidLogin(){
		logger = Logger.getLogger(InvaidLogin.class.getName());
		PropertyConfigurator.configure("log4j.properties");
		
//		ExtentLogger =extent.createTest("Invalid Login");
		
		logger.info("Reading Number of Test Data Set From Input Excel File");
		int RC = FWUtil.getXLRowCount(XL_PATH, "InVaidLogin");
		for(int i=1;i<=RC;i++) {
			logger.info("Reading UN From Input Excel File");
			String UN = FWUtil.getXLData(XL_PATH, "InVaidLogin",i,0);
			logger.info("Username Used : "+UN);
			logger.info("Reading PW From Input Excel File");
			String PW = FWUtil.getXLData(XL_PATH, "InVaidLogin",i,1);
			logger.info("Password Used : "+PW);
					
			LoginPage l = new LoginPage(driver);
			//enter valid UN
			l.setUserName(UN);
			logger.info("Entering UN");
			
			//enter value pw
			l.setPassword(PW);
			logger.info("Entering PW");
			
			//click login btn
			l.ClickLoginBTN();
			logger.info("Clicking LoginBTN");
			
			//validate load home page
			l.verifyErrMsgIsDisplayed();
			logger.info("Verify Error MSG Is Displayed");
			
			driver.navigate().refresh();
			logger.info("Refreshing The Page");
			
		}
	}

}
