package Praveen;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public class AdactinAppWithBaseClass {
	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		BaseClass baseClass = new BaseClass();
		
		baseClass.confChrome();
		baseClass.loadUrl("http://adactinhotelapp.com/");
		
		baseClass.windowMaximize();
		baseClass.wait(5);
		
		WebElement txtUserName = baseClass.locateById("username");
		baseClass.sendKeys(txtUserName, "appraveen005");
		
		WebElement txtPassword = baseClass.locateById("password");
		baseClass.sendKeys(txtPassword, "greensdemo");
		
		WebElement btnLogin = baseClass.locateById("login");
		baseClass.click(btnLogin);
		
		String location = baseClass.viewData("Sheet1", 1, 1);
		WebElement dDnLocation = baseClass.locateById("location");
		baseClass.dDnByVisibleText(dDnLocation, location);
		
		String hotels = baseClass.viewData("Sheet1", 1, 2);
		WebElement dDnHotels = baseClass.locateById("hotels");
		baseClass.dDnByVisibleText(dDnHotels, hotels);
		
		String roomType = baseClass.viewData("Sheet1", 1, 3);
		WebElement dDnRomType = baseClass.locateById("room_type");
		baseClass.dDnByVisibleText(dDnRomType, roomType);
		
		String roomNo = baseClass.viewData("Sheet1", 1, 4);
		WebElement dDnNoOfRooms = baseClass.locateById("room_nos");
		baseClass.dDnByVisibleText(dDnNoOfRooms, roomNo);
		
		String ckInDate = baseClass.viewDataDate("Sheet1", 1, 5);
		WebElement txtCheckInDate = baseClass.locateById("datepick_in");
		baseClass.jsValue(ckInDate, txtCheckInDate);
		
		String ckOutDate = baseClass.viewDataDate("Sheet1", 1, 6);
		WebElement txtCheckOutDate = baseClass.locateById("datepick_out");
		baseClass.jsValue(ckOutDate, txtCheckOutDate);
	
		String adults = baseClass.viewData("Sheet1", 1, 7);
		WebElement dDnAdults = baseClass.locateById("adult_room");
		baseClass.dDnByVisibleText(dDnAdults, adults);
		
		String child = baseClass.viewData("Sheet1", 1, 8);
		WebElement dDnChild = baseClass.locateById("child_room");
		baseClass.dDnByVisibleText(dDnChild, child);
		
		WebElement btnSearch = baseClass.locateById("Submit");
		baseClass.click(btnSearch);
		
		WebElement btnRadio = baseClass.locateByXpath("//input[@type='radio']");
		baseClass.click(btnRadio);
		
		WebElement btnContinue = baseClass.locateById("continue");
		baseClass.click(btnContinue);
		
		String name = baseClass.viewData("Sheet1", 1, 9);
		WebElement txtName = baseClass.locateById("first_name");
		baseClass.sendKeys(txtName, name);
		
		String lastName = baseClass.viewData("Sheet1", 1, 10);
		WebElement txtLastName = baseClass.locateById("last_name");
		baseClass.sendKeys(txtLastName, lastName);
		
		String address = baseClass.viewData("Sheet1", 1, 11);
		WebElement txtAddress = baseClass.locateById("address");
		baseClass.sendKeys(txtAddress, address);
		
		String ccNo = baseClass.viewDataInt("Sheet1", 1, 12);
		WebElement txtCcNo = baseClass.locateById("cc_num");
		baseClass.sendKeys(txtCcNo, ccNo);
		
		String ccTypeData = baseClass.viewData("Sheet1", 1, 13);
		WebElement ccType = baseClass.locateById("cc_type");
		baseClass.sendKeys(ccType, ccTypeData);
		
		String ccMonth = baseClass.viewData("Sheet1", 1, 14);
		WebElement dDnMonth = baseClass.locateById("cc_exp_month");
		baseClass.dDnByVisibleText(dDnMonth, ccMonth);
		
		String ccYear = baseClass.viewDataInt("Sheet1", 1, 15);
		WebElement dDnCcYear = baseClass.locateById("cc_exp_year");
		baseClass.dDnByVisibleText(dDnCcYear, ccYear);
		
		String cvv = baseClass.viewDataInt("Sheet1", 1, 16);
		WebElement txtCvv = baseClass.locateById("cc_cvv");
		baseClass.sendKeys(txtCvv, cvv);
		WebElement btnBookNow = baseClass.locateById("book_now");
		baseClass.click(btnBookNow);
		
		WebElement orderNo = baseClass.locateById("order_no");
		String orderId = baseClass.getAttribute(orderNo);
		System.out.println(orderId);
		baseClass.writeData("Sheet1", 1, 17, orderId);
		
		baseClass.closeWindow();
	}
}
