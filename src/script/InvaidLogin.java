package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.LoginPage;

public class InvaidLogin  extends BaseTest{
	
	@Test(priority =2)
	public void InVaidLogin(){
		int RC = FWUtil.getXLRowCount(XL_PATH, "InVaidLogin");
		for(int i=1;i<=RC;i++) {
			String UN = FWUtil.getXLData(XL_PATH, "InVaidLogin",i,0);
			String PW = FWUtil.getXLData(XL_PATH, "InVaidLogin",i,1);
					
			LoginPage l = new LoginPage(driver);
			//enter valid UN
			l.setUserName(UN);
			//enter value
			l.setPassword(PW);
			//click login btn
			l.ClickLoginBTN();
			//validate load home page
			l.verifyErrMsgIsDisplayed();
	
		}
	}



}
