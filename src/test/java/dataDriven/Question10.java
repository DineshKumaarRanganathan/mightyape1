/*QUESTION 10
--------------
URL :  http://www.adactin.com/HotelApp/

NOTE: Create an excel sheet with all details required for Hotel Booking .
      Create a maven project. 
      Book a hotel using above url by getting the input data  from excel sheet.
      Update the orderNo generated after hotel booking in excel sheet using DataDriven.*/
      

package dataDriven;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Question10 {
	public static void main(String[] args) throws IOException {
		BaseClass b =new BaseClass();
		b.configureChromeDriver();
		b.loadUrl("http://www.adactin.com/HotelApp/");
		
		String no = b.viewDataDate(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 6);
		System.out.println(no);
		
		WebElement userName = b.locateById("username");
		String userValue = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 0);
		b.sendKeys(userName, userValue);
		
		WebElement userPass = b.locateById("password");
		String passValue = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 1);
		b.sendKeys(userPass, passValue);
		
		WebElement btnLogin = b.locateById("login");
		b.click(btnLogin);
		
		WebElement location = b.locateById("location");
		String locationValue = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 2);
		b.sendKeys(location, locationValue);
		
		WebElement hotels = b.locateById("hotels");
		String hotelsValue = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 3);
		b.sendKeys(hotels, hotelsValue);
		
		WebElement room = b.locateById("room_type");
		String roomValue = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 4);
		b.sendKeys(room, roomValue);
		
		WebElement roomNo = b.locateById("room_nos");
		String roomNoValue = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 5);
		b.sendKeys(roomNo, roomNoValue);
		
		WebElement dateIn = b.locateById("datepick_in");
		String dateInValue = b.viewDataDate(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 6);
		b.jsValue(dateInValue, dateIn);
		
		WebElement dateOut = b.locateById("datepick_out");
		String dateOutValue = b.viewDataDate(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 7);
		System.out.println();
		b.jsValue(dateOutValue, dateOut);
		
		WebElement adult = b.locateById("adult_room");
		String adultValue = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 8);
		b.sendKeys(adult, adultValue);
		
		WebElement child = b.locateById("child_room");
		String childValue = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 9);
		b.sendKeys(child, childValue);
		
		WebElement btnSearch = b.locateById("Submit");
		b.click(btnSearch);
		
		WebElement radio = b.locateById("radiobutton_0");
		b.click(radio);
		
		WebElement btnContinue = b.locateById("continue");
		b.click(btnContinue);
		
		WebElement firstName = b.locateById("first_name");
		String fN = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 10);
		b.sendKeys(firstName, fN);
		

		WebElement lastName = b.locateById("last_name");
		String lN = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 11);
		b.sendKeys(lastName, lN);
		
		WebElement address = b.locateById("address");
		String aD = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 12);
		b.sendKeys(address, aD);
		
		WebElement card = b.locateById("cc_num");
		String cardNo = b.viewDataDate(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 13);
		b.jsValue(cardNo, card);
		//b.sendKeys(address, aD);
		
		WebElement cardt = b.locateById("cc_type");
		String cardte = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 14);
		b.sendKeys(cardt, cardte);
		
		WebElement expmon = b.locateById("cc_exp_month");
		String expm = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 15);
		b.sendKeys(expmon, expm);
		
		WebElement expyr = b.locateById("cc_exp_year");
		String expy = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 16);
		b.sendKeys(expyr, expy);
		
		WebElement cvv = b.locateById("cc_cvv");
		String cvvno = b.readingParticularCellXLSX(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 17);
		b.sendKeys(cvv, cvvno);
		
		WebElement book = b.locateById("book_now");
		b.click(book);
		
		WebElement order = b.locateById("order_no");
		String orderNo = b.getAttribute(order);
		System.out.println(orderNo);
		b.writeData(".\\Sheets\\AdactinDinesh.xlsx", "Details", 1, 18, orderNo);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
