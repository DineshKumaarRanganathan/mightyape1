/*QUESTION 6
----------
URL : https://www.facebook.com/

NOTE: Create an excel sheet for facebook email and password.
      Login in to facebook by getting the input data  from excel sheet 
      using DataDriven and execute in maven*/

package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class Question06 {
	public static void main(String[] args) throws IOException {
		BaseClass b = new BaseClass ();
		b.configureChromeDriver();
		b.loadUrl("https://www.facebook.com/");
		String id = b.readingParticularCellXLSX("E:\\Selenium\\Mavenassignment\\dataDriven\\Sheets\\Question5.xlsx", "result", 0, 0);
		String id1 = b.readingParticularCellXLSX("E:\\Selenium\\Mavenassignment\\dataDriven\\Sheets\\Question5.xlsx", "result", 0, 1);
		WebElement locateById = b.locateById("email");
		WebElement locateById2 = b.locateById("pass");
		b.sendKeys(locateById, id);
		b.sendKeys(locateById2, id1);
		WebElement qw = b.locateByXpath("//button[@type='submit']");
		b.click(qw);
		
		//WebElement loc = b.locateByXpath("//span[text()='Dinesh Kumaar']");
		//String text = loc.getText();
		//System.out.println("gfd");
		
		//b.writeData("result", 5, 5, "gdf");
		
		File f = new File("E:\\Selenium\\Mavenassignment\\dataDriven\\Sheets\\Question5.xlsx");
		FileInputStream str = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(str);
		Sheet sheet = book.getSheet("result");
		Row row = sheet.getRow(0);
		Cell createCell = row.createCell(5);
		createCell.setCellValue("check");
		
		FileOutputStream o = new FileOutputStream(f);
		book.write(o);
		 
		System.out.println("**************");
				
		
		
		
}}
