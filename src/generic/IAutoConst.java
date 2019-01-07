package generic;

public interface IAutoConst {
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_VALUE="./driver/chromedriver.exe";
	
	String FIREFOX_KEY="webdriver.gecko.driver";
	String FIREFOX_VALUE="./driver/geckodriver.exe";
	
	String IE_KEY="webdriver.ie.driver";
	String IE_VALUE="./driver/IEDriverServer.exe";
	
	String URL="https://demo.actitime.com/login.do";
	
	String XL_PATH="./data/input.xlsx";
	String PHOTO_PATH="./photos/";
	String LOG_PATH="./logs/";
	String REPORT_PATH="./result/report.xlsx";
	String EXTENT_REPORT_PATH="./result/extentreport.html";
	
	long ITO=10;
	long ETO=8;
}
