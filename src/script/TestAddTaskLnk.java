package script;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.EnterTimeTrackPage;
import page.LoginPage;

@Listeners(listener.ListenersImplementation.class)
public class TestAddTaskLnk extends BaseTest {
	
	private Logger logger;

	@Test(priority =5, description="Validating the Add Task Link To List The Options")
	public void AddTaskLnk(){
			logger = Logger.getLogger(TestAddTaskLnk.class.getName());
			PropertyConfigurator.configure("log4j.properties");
			
			logger.info("Reading UN From Input Excel File");
			String UN = FWUtil.getXLData(XL_PATH, "TestLissueDate", 1, 0);
			logger.info("Username Used : "+UN);
			logger.info("Reading PW From Input Excel File");
			String PW = FWUtil.getXLData(XL_PATH, "TestLissueDate", 1, 1);
			logger.info("Password Used : "+PW);
			
			
			LoginPage l = new LoginPage(driver);
			
			
			l.setUserName(UN);
			logger.info("Entering UN");
			
			
			l.setPassword(PW);
			logger.info("Entering PW");
			
			l.ClickLoginBTN();
			logger.info("Clicking LoginBTN");
			
			EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
			
			e.ClickOnAddAddRecentTaskLnk();
			logger.info("Clicking On Add Recent Task Lnk");
			
			e.waitForTaskListOptions(ETO);
			logger.info("Waiting For TaskList Option TO be Visible");
			
			e.AssertDDVisible();
			logger.info("Asserting Task List Options Displayed");
	}

}
