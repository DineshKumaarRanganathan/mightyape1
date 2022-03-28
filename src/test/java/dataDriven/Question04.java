/*QUESTION 4
----------
URL : https://demoqa.com/registration/

NOTE: Create an excel sheet with all required details for registration . */

package dataDriven;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Question04 {
	public static void main(String[] args) throws IOException {
		File f = new File ("E:\\Selenium\\Mavenassignment\\dataDriven\\Sheets\\Demo Register.xlsx");
		Workbook book = new XSSFWorkbook();
		Sheet s =book.createSheet("User Details");
			Object details[][] = { {1,"First Name","Dinesh"},
								{2,"Last Name","R"},
								{3,"email","dinesh@gmail.com"},
								{4,"Phone No","9876543210"},
								{5,"Country","India"},
								{6,"City","Coimbatore"},
			};
			int rowCount = 0;
			for (Object r[]:details) {
				Row row = s.createRow(rowCount++);
				int cellCount = 0;
				for(Object value:r){
					Cell cell = row.createCell(cellCount++);
						if(value instanceof String)
							cell.setCellValue((String)value);
						if(value instanceof Integer)
							cell.setCellValue((Integer)value);
				}
			}
			FileOutputStream o = new FileOutputStream(f);
			book.write(o);
			o.close();
			System.out.println("****Completed****");
	}

}
