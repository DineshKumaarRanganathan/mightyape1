package dataDriven;

import java.io.File;
import java.io.FileInputStream;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
static WebDriver driver;
	
	public void configureChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
		
	public void configureFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	public void configureIeDriver() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}
	
	public void configureEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
	public void loadUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void toMaximize() {
		driver.manage().window().maximize();
	}
	
	public String getUrl() {
		 String currentUrl = driver.getCurrentUrl();
		 return currentUrl;
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public String getWindowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	
	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("Value");
		return attribute;
	}
	
	public String getParentWindowHandle() {
		String parent = driver.getWindowHandle();
		return parent;
	}
	
	public Set<String> AllWindowHandles() {
		Set<String> allWindow = driver.getWindowHandles();
		return allWindow;
		
	}
	
	public void SwitchToChildWindowHandle(String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String x : allWindows) {
			if(!parent.equals(x)) {
				driver.switchTo().window(x);
			}
		}
	}
	
	public void navigateTo(String Url) {
		driver.navigate().to(Url);
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void navigateForward() {
		driver.navigate().forward();
	}
	
	public void refresh() {
		driver.navigate().refresh();
	}
	
	public void toQuitAllWindows() {
		driver.quit();
	}
	
	public void toCloseWindow() {
		driver.close();
	}
	
	public WebElement locateById(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;
	}
	
	public WebElement locatByName(String name) {
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;
	}
	
	public WebElement locateByClassName(String className) {
		WebElement findElement = driver.findElement(By.className(className));
		return findElement;
	}
	
	public WebElement locateByXpath(String xpathExpression) {
		WebElement findElement = driver.findElement(By.xpath(xpathExpression));
		return findElement;
	}
	
	public void sendKeys(WebElement element, String key) {
		element.sendKeys(key);
	}
	
	public void sendKeysAndEnter(WebElement element, String key) {
		element.sendKeys(key+ Keys.ENTER);
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void moveTo(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	public void dragAndDrop(WebElement s, WebElement d) {
		Actions a = new Actions(driver);
		a.dragAndDrop(s, d).perform();
	}
	
	public void doubleclick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	public void threadSleep(int millis) throws InterruptedException {
		Thread.sleep(millis);
	}
	
	public void ddnSelectByindex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void ddnSelectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void ddnSelectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public WebElement ddnFirstSelectedOption(WebElement element) {
		Select s = new Select (element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}
	
	public List<WebElement> ddnAllSelectedOptions(WebElement element) {
		Select s = new Select (element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;
	}
	
	public List<WebElement> ddnAllOptions(WebElement element) {
		Select s = new Select (element);
		List<WebElement> options = s.getOptions();
		return options;
	}
	
	public void ddnDeselectByindex(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}
	
	public void ddnDeselectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}
	
	public void ddnDeselectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}
	
	public void ddnDeselectAllSelectedOptions(WebElement element) {
		Select s = new Select (element);
		s.deselectAll();
	}
	
	public void acceptAlert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	public void promtAlert(String Text) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(Text);
	}
	
	public void screenshot(String location) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File defaultLocation = ss.getScreenshotAs(OutputType.FILE);
		File destination = new File(location);
		FileUtils.copyFile(defaultLocation, destination);
	}
	
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void returnToMainFrame() {
		driver.switchTo().defaultContent();
	}

	public void frameBack() {
		driver.switchTo().parentFrame();
	}
	
	public String readingParticularCellXLSX(String path, String sheetName, int row, int cell) throws IOException {
		File f = new File(path);
		FileInputStream str = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(str);
		Sheet s = book.getSheet(sheetName);
		Cell gettingCell = s.getRow(row).getCell(cell);
		CellType cellType = gettingCell.getCellType();
		String value = null;
		switch(cellType) {
		case STRING:
			value = gettingCell.getStringCellValue();
			break;
		
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(gettingCell)) {
				Date date = gettingCell.getDateCellValue();
				SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
				value=fmt.format(date);
				break;
				}
			else {
				double numericCellValue = gettingCell.getNumericCellValue();
				BigDecimal ba = BigDecimal.valueOf(numericCellValue);
				BigInteger bi = ba.toBigInteger();
			value = bi.toString();
			}
		default:
			break;
		}
		return value;
	}
	
	public void ReadingXLSX(String path, String sheetName) throws IOException {
		File f = new File(path);
		FileInputStream str = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(str);
		 Sheet s = book.getSheet(sheetName);
	}
	
	public String viewDataDate(String path, String sheetName, int rowNum, int cellNum) throws IOException {

		File file = new File(path);
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

	
	
	
	/*public void writingXLSXSheet(String path, String sheet, int row, int cell, String data) throws IOException {
		File f = new File (path);
		boolean exists = f.exists();
		if (exists==true) {
			Workbook book = new XSSFWorkbook();
			int numberOfSheets = book.getNumberOfSheets();
				if(numberOfSheets!=0) {
					for (int i = 1; i < book.getNumberOfSheets(); i++) {
						if(book.getSheetName(i).equals(sheet)) {
							Sheet sheet2 = book.getSheet(sheet);
							sheet2.createRow(row).createCell(cell).setCellValue(data);
							break;
						}
						else {
							continue;
							}
						}
					}
				else {
					book.createSheet(sheet).createRow(row).createCell(cell ).setCellValue(data);
					}
				FileOutputStream o = new FileOutputStream(f);
				book.write(o);
	}
		else {
			Workbook book = new XSSFWorkbook();
			book.createSheet(sheet).createRow(row).createCell(cell ).setCellValue(data);
			FileOutputStream o = new FileOutputStream(f);
			book.write(o);
		}*/
	
	public void writeData(String path, String SheetName, int RowNum, int cellNum, String data) throws IOException {
		File file = new File(path);
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
	
	public void jsValue(String input, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + input + "')", element);
 }
}
