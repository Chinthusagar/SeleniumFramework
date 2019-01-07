package generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public abstract class BaseTest implements IAutoConst{
	public static WebDriver driver;
	public static int passCount=0,failCount=0;
	private Logger beforemethodlogger, aftermethodlogger;
	private Logger beforesuitlogger, aftersuitlogger;

	
	@BeforeSuite
	
	public void PreSetup() {
		FWUtil.DeleteAllFilesInFolder(LOG_PATH);
		FWUtil.DeleteAllFilesInFolder(PHOTO_PATH);
		
		
		beforesuitlogger=Logger.getLogger("PreSetup");
        PropertyConfigurator.configure("Log4j.properties");
        
        beforesuitlogger.info("Creating Backup Folders");
		
		FWUtil.CreateFolderWithName("./DataBackupLogs/"+FWUtil.date+"_"+FWUtil.month+"_"+FWUtil.year);
		FWUtil.CreateFolderWithName("./DataBackupPhotos/"+FWUtil.date+"_"+FWUtil.month+"_"+FWUtil.year);
		
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void openApp(ITestResult res, String browser){
		System.out.println("Before Method");
		beforemethodlogger = Logger.getLogger("OpenApp");
		PropertyConfigurator.configure("Log4j.properties");
		
		String str = browser;
		switch(str)
		{
		case "firefox":
			System.out.println("firefox"); 
			System.setProperty(FIREFOX_KEY,FIREFOX_VALUE);
			driver=new FirefoxDriver();
			
			break;
			
		case "chrome":
			System.out.println("chrome");
			System.setProperty(CHROME_KEY,CHROME_VALUE);
			driver=new ChromeDriver();
			
			break;
			
		case "IE":
			System.out.println("IE");
			System.setProperty(IE_KEY,IE_VALUE);
			driver=new InternetExplorerDriver();
			
			break;
		}
		beforemethodlogger.info("Launching the browser");

			

		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.get(URL);
		beforemethodlogger.info("Loding URL");
		
		}
	
	@AfterMethod
	public void closeApp(ITestResult res){
		System.out.println("After Method");
		aftermethodlogger = Logger.getLogger("closeApp");
		PropertyConfigurator.configure("Log4j.properties");
		
		String testName=res.getName();
		aftermethodlogger.info(testName);
		
		
		
		int status=res.getStatus();
		if(status==ITestResult.SUCCESS){
			passCount++;
			aftermethodlogger.info("Passed");

		}else if(status==ITestResult.FAILURE){
			failCount++;
			aftermethodlogger.warn("Failed");
			aftermethodlogger.error(res.getThrowable().getMessage().toString());
			String path=PHOTO_PATH+testName+".png";
			
			FWUtil.getPhoto(driver, path);
			
		}else if(status==ITestResult.SKIP) {
			aftermethodlogger.warn("Skipped");
		}
			
			
		driver.close();
		
	}
	
	
	@AfterSuite
	public void print(){
		aftersuitlogger = Logger.getLogger("closeTest");
		PropertyConfigurator.configure("Log4j.properties");
		aftersuitlogger.warn("Pass:"+passCount);
		aftersuitlogger.warn("Fail:"+failCount);
		String FullDate = FWUtil.date+"_"+FWUtil.month+"_"+FWUtil.year;
		String FullTime = FWUtil.hr+"_"+FWUtil.min;
		FWUtil.moveFolderToDstFolder("./logs", "./DataBackupLogs/"+FullDate+"/"+FullTime);
		FWUtil.moveFolderToDstFolder("./photos", "./DataBackupPhotos/"+FullDate+"/"+FullTime);
		
		
		
		FWUtil.setXLData(REPORT_PATH,"sheet1",1,0,passCount);
		FWUtil.setXLData(REPORT_PATH,"sheet1",1,1,failCount);
	}
}

