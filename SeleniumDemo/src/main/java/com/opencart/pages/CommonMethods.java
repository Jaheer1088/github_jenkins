package com.opencart.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.opencart.pages.BaseClass;

// delete the utility package and addd class under utility to pages package


public class CommonMethods extends BaseClass {
	
	public static FileInputStream fileinputstream;
	public static FileOutputStream fileoutstream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static int rowcount;
	public static int colcount;
	
	public static void FileReader(String path, String Sheetname) throws Exception {
		
		fileinputstream =new FileInputStream(path);
		workbook =new XSSFWorkbook(fileinputstream);
		sheet=workbook.getSheet(Sheetname);
		rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		colcount=sheet.getRow(0).getLastCellNum();
		
		//cell.setCellType(CellType.STRING);
	}
	
	public static void Filewriter(String FilePath) throws Exception {
		fileoutstream=new FileOutputStream(FilePath);
		
		workbook.write(fileoutstream);
		
		workbook.close();
	}
	
	public static void DropDown(WebElement web,String text) {
		
		Select sc=new Select(web);
		sc.selectByVisibleText(text);
	}
	
	public static void Scroll() {
		
		JavascriptExecutor js= (JavascriptExecutor)d;
		js.executeScript("window.scrollBy(0,500)");
		
	}
	
	public static void ScreenShot() throws IOException {
		
	File file=	((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	
	//use user.dir ;
	File dest=new File("D:\\java-2022-03\\eclipse\\SeleniumDemo\\Screenshots");
	
	FileUtils.copyDirectory(file, dest);
	
	}
	
	public static String CaptureScreenShot(String Filename) throws IOException {
		
	File src=	((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	File dst=new File(System.getProperty("user.dir")+"//Screenshots"+Filename+".png");
	
	String absPath=dst.getAbsolutePath();
	
	FileUtils.copyFile(src, dst);
	
	return absPath;
		
	}

}