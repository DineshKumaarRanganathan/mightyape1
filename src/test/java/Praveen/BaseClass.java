package Praveen;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void confChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void closeWindow() {
		driver.close();
	}

	public static void closeAllWindows() {
		driver.quit();
	}

	public String getUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	public boolean contains(String text, String value) {
		boolean c = text.contains(value);
		return c;
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public WebElement locateById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	public WebElement locateByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	public WebElement locateByClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;
	}

	public WebElement locateByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public void sendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void click(WebElement element) {
		element.click();
	}

	public void threadSleep(int millis) throws InterruptedException {
		Thread.sleep(millis);
	}

	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void dragAndDrop(WebElement s, WebElement d) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(s, d).perform();
	}

	public List<WebElement> listTagName(String tagName) {
		List<WebElement> elements = driver.findElements(By.tagName(tagName));
		return elements;
	}

	public void contextClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

//	public void robot() throws AWTException {
		// Robot robot = new Robot();
	//}

	//;

	public void simpleAlertAccept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void confirmAlertDismiss() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	public void promptAlertSendText(String text) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(text);
	}

	public String promptAlertGetText() {
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		return text;
	}

	public void takeScreenshot(String destination) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File(destination);
		FileUtils.copyFile(s, d);
	}

	public void dDnByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void dDnByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void dDnByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public List<WebElement> dDnGetOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	public List<WebElement> dDnGetAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public WebElement dDnGetFirstSelectedOptions(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}

	public boolean dDnIsMultiple(WebElement element) {
		Select select = new Select(element);
		boolean b = select.isMultiple();
		return b;
	}

	public void dDnDeselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public void dDnDeselectByvalue(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByValue(text);
	}

	public void dDnDeselectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	public void dDnDeselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public void frameSwitchId(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public void frameSwitchIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void frameSwitchWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void frameReturnToMainFrame() {
		driver.switchTo().defaultContent();
	}

	public void frameBack() {
		driver.switchTo().parentFrame();
	}

	public String parentWindowId() {
		String parentWindowId = driver.getWindowHandle();
		return parentWindowId;
	}

	public Set<String> allWindowId() {
		Set<String> allWindowsId = driver.getWindowHandles();
		return allWindowsId;
	}

	public void switchToChildWindow(String parentWindowId, Set<String> allWindowsId) {
		for (String eachWindowId : allWindowsId) {
			if (!parentWindowId.equals(eachWindowId)) {
				driver.switchTo().window(eachWindowId);
			}
		}
	}

	public String viewData(String sheetName, int rowNum, int cellNum) throws IOException {

		File file = new File("E:\\Selenium\\Mavenassignment\\dataDriven\\Sheets\\Adactin.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String cellValue = cell.getStringCellValue();
		return cellValue;
	}

	public void jsValue(String input, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + input + "')", element);

	}

	public static void wait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public String viewDataInt(String sheetName, int rowNum, int cellNum) throws IOException {

		File file = new File("E:\\Selenium\\Mavenassignment\\dataDriven\\Sheets\\Adactin.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		String s = null;
		switch (type) {

		case STRING:
			s = cell.getStringCellValue();

			break;
		case NUMERIC:
			double numericCellValue = cell.getNumericCellValue();
			BigDecimal b = BigDecimal.valueOf(numericCellValue);
			BigInteger bi = b.toBigInteger();
			s = bi.toString();

			break;
		default:
			break;
		}
		return s;
		// String cellValue = cell.getStringCellValue();
		// return cellValue;
	}

	public void writeData(String SheetName, int RowNum, int cellNum, String data) throws IOException {
		File file = new File("E:\\Selenium\\Mavenassignment\\dataDriven\\Sheets\\Adactin.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(RowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fout = new FileOutputStream(file);
		workbook.write(fout);
	}

	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String viewDataDate(String sheetName, int rowNum, int cellNum) throws IOException {

		File file = new File("E:\\Selenium\\Mavenassignment\\dataDriven\\Sheets\\Adactin.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		String s = null;
		switch (type) {

		case STRING:
			s = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				s = dateFormat.format(date);
				break;

			} else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal b = BigDecimal.valueOf(numericCellValue);
				BigInteger bi = b.toBigInteger();
				s = bi.toString();
			}
		default:
			//break;
		}
		return s;
	}

}
