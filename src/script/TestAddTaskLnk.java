package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class TestAddTaskLnk extends BaseTest {
	
	@Test(priority =4)
	public void AddTaskLnk(){
			String UN = FWUtil.getXLData(XL_PATH, "TestLissueDate", 1, 0);
			String PW = FWUtil.getXLData(XL_PATH, "TestLissueDate", 1, 1);
			
			
			
			LoginPage l = new LoginPage(driver);
			l.setUserName(UN);
			l.setPassword(PW);
			l.ClickLoginBTN();
			EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
			e.ClickOnAddAddRecentTaskLnk(driver);
			e.waitForTaskListOptions(driver, ETO);
			e.AssertDDVisible(driver);
	}

}
