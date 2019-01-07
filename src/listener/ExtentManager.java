package listener;

import java.io.File;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;
    private static String reportFileName = "ExtentReports.html";
    private static String windowsPath = "./result";
    private static String winReportFileLoc = windowsPath + "/" + reportFileName;
 
   
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
       
        String fileName = winReportFileLoc;
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Automation Results");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Test Sanity Suit");
 
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
 
        return extent;
    }
 
    
 
  
 
    
}
