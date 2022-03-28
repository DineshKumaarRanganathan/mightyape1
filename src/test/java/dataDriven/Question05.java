/*QUESTION 5
----------
URL :  http://www.adactin.com/HotelApp/

NOTE: Create an excel sheet with all details required for Hotel Booking . */


package dataDriven;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Question05 {
	public static void main(String[] args) throws IOException {
		File f = new File (".\\Sheets\\hotelbooking.xlsx");
		Workbook book = new XSSFWorkbook();
		Sheet s = book.createSheet("details");
			Object data[][] = {{"Location","Sydney"},
								{"Hotels","Hotel Creek"},
								{"Room Type","Standard"},
								{"No of Rooms","1-One"},
								{"Check in","27/03/2022"},
								{"Check out","28/03/2022"},
								{"Adults",2},
								{"Children",0},
								{"First Name","Dinesh"},
								{"Last Name","R"},
								{"Adress","Coimbatore"},
								{"Card no","9876543210987456"},
								{"Card type","Visa"},
								{"Expiry month","August"},
								{"Expiry year",2022},
								{"cvv",123},
			};
			
			int rowCount = 0;
			for (Object r []: data) {
				Row r1 = s.createRow(rowCount++);
				int cellCount =0;
				for (Object c : r) {
					Cell cell = r1.createCell(cellCount++);
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
