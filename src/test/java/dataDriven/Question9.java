/*QUESTION 9
----------
URL :  http://www.adactin.com/HotelApp/

NOTE: Create an excel sheet with all details required for Hotel Booking . */

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

public class Question9 {
	public static void main(String[] args) throws IOException {
		File f = new File(".//Sheets//AdactinDinesh.xlsx");
		//FileInputStream str = new FileInputStream(f);
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("Details");
		Object data[][] = {{"User Name","Password","Location","Hotel","Rome Type","No of Rooms","Checkin","CheckOut","Adult","Child","FName","LName","Address","Cardno","CardType","expmn","expyr","CVV"},
						{"dineshkumaar93","Dinesh@123","New York","Hotel Creek","Super Deluxe","1 - One","29/03/2022","02/04/2022","2 - Two","0 - None","John","Ser","Mars",9876543210789654l,"VISA","April",2022,123}                                            
						};
		int rowCount=0;
		for (Object r[] : data) {
			Row row = sheet.createRow(rowCount++);
			int cellCount=0;
					for (Object c : r) {
						Cell cell = row.createCell(cellCount++);
						if(c instanceof String)
							cell.setCellValue((String)c);
						if(c instanceof Integer)
							cell.setCellValue((Integer)c);
						if(c instanceof Long)
							cell.setCellValue((Long)c);
					}
		}
		FileOutputStream o = new FileOutputStream(f);
		book.write(o);
		o.close();
		
		System.out.println("*****Completed*****");
		
	}
	

}
