package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest{
	
	@Test(priority=1)
	public void testValidLogin() {
		String UN = FWUtil.getXLData(XL_PATH, "ValidLogin",1,0);
		String PW = FWUtil.getXLData(XL_PATH, "ValidLogin",1,1);
		String title = FWUtil.getXLData(XL_PATH, "ValidLogin",1,2);
		
		LoginPage l = new LoginPage(driver);
		//enter valid UN
		l.setUserName(UN);
		//enter value
		l.setPassword(PW);
		//click login btn
		l.ClickLoginBTN();
		//validate load home page
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.verifiedHomepageIsDisplayed(driver, ETO, title);
	}

}
