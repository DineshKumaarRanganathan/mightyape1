/*Details for question 1 to 3
---------------------------
Create excel sheet with details of  10 students name and  courses.
QUESTION 1
-----------
NOTE: Find the Total number of Rows and Total number of cells in excel sheet.
QUESTION 2
----------
NOTE: Print all the data present  in excel sheet.
QUESTION 3
----------
NOTE: Insert one new row in the excel sheet. */

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
import org.apache.poi.xssf.usermodel.extensions.XSSFCellAlignment;

public class Question01to03 {
	public static void main(String[] args) throws IOException {
		File f = new File("E:\\Selenium\\Mavenassignment\\dataDriven\\Sheets\\Student Details.xlsx");
		FileInputStream str = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(str);
		Sheet sheet = book.getSheet("Course");
		int lastRowNum = sheet.getLastRowNum();
		System.out.println(sheet.getPhysicalNumberOfRows());
		Row row = sheet.getRow(0);
		System.out.println(row.getPhysicalNumberOfCells());
		
		
			
		System.out.println("*************************");	
			
		/*sheet.createRow(5);
		FileOutputStream o = new FileOutputStream(f);
		book.write(o);
		
		System.out.println("*************************");*/
		
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i <physicalNumberOfRows; i++) {
			Row r = sheet.getRow(i);
			int physicalNumberOfCells = r.getPhysicalNumberOfCells();
			for (int j = 0; j < physicalNumberOfCells; j++) {
				Cell c = r.getCell(j);
				System.out.println(c);
			}
		}
		
	}

}
