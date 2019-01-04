package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class FWUtil {
	
	static int date = LocalDate.now().getDayOfMonth();
	static int month = LocalDate.now().getMonthValue();
	static int year = LocalDate.now().getYear();
	static int hr = LocalTime.now().getHour();
	static int min = LocalTime.now().getMinute();
	
	public static String getXLData(String path,String sheet,int r,int c){
		String v="";
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e){
			}
		return v;
	}
	
	public static int getXLRowCount(String path,String sheet){
		int count=0;
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			count = wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e){ 
			e.printStackTrace();
			}
		return count;
	}
	
	public static void setXLData(String path,String sheet,int r,int c,int v){
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).getRow(r).getCell(c).setCellValue(v);
			wb.write(new FileOutputStream(path));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void getPhoto(WebDriver driver,String path){
		try{
			TakesScreenshot t=(TakesScreenshot)driver;
			File srcFile = t.getScreenshotAs(OutputType.FILE);
			File dstFile=new File(path);
			FileUtils.copyFile(srcFile,dstFile);
			System.out.println("Capture Screen");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Sleep(long Sec) {
		try {
			Thread.sleep(Sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void DeleteAllFilesInFolder(String path) {
	
		File dir = new File(path);
		try {
			FileUtils.cleanDirectory(dir);
			Reporter.log("Files are deleted", true);
		} catch (IOException e) {
			Reporter.log("Dir is empty", true);
		}
	}
	
	public static void MoveFileFromSrcToDst(String srcpath, String dstpath)  {
		
		File dscFile = new File(dstpath);
		File srcFile = new File(srcpath);
		try {
			FileUtils.moveDirectory(srcFile, dscFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void CreateFolderWithName(String path) {
		
		try {
			new File(path).mkdir();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void moveFolderToDstFolder(String srcpath, String dstpaht) {
		File srcDir = new File(srcpath);
		File dstDir = new File(dstpaht);
		
		try {
			FileUtils.copyDirectory(srcDir, dstDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	
}


