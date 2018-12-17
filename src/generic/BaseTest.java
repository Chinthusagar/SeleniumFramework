package generic;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst{
	public WebDriver driver;
	public static int passCount=0,failCount=0;
	private static Instant start, end;
	private static long IntervalTime;
	
	static{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
	}
	
	@BeforeMethod
	public void openApp(){
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		String date = LocalDate.now().getDayOfMonth()+" "+LocalDate.now().getMonth()+" "+LocalDate.now().getYear();
		 start = Instant.now();
		driver.get(URL);
	}
	
	@AfterMethod
	public void closeApp(ITestResult res){
		end = Instant.now();
		IntervalTime =Duration.between(start, end).toMillis();
		System.out.println(IntervalTime);
		String testName=res.getName();
		int status=res.getStatus();
		if(status==1){
			passCount++;
		}
		else{
			failCount++;
			String path=PHOTO_PATH+testName+".png";
			Reporter.log("PhotoPath:"+path,true);
			FWUtil.getPhoto(driver, path);
		}
		driver.close();
	}
	
	
	@AfterSuite
	public void print(){
		Reporter.log("Pass:"+passCount,true);
		Reporter.log("Fail:"+failCount,true);
		FWUtil.setXLData(REPORT_PATH,"sheet1",1,0,passCount);
		FWUtil.setXLData(REPORT_PATH,"sheet1",1,1,failCount);
	}
}

