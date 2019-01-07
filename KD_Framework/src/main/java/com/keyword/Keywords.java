package com.keyword;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.utils.Runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keywords {
        
	// 1. For selecting and launching browser
	public static void openBrowser(String browserName) {
		Constants.setLog(Logger.getLogger(Keywords.class));
		switch (browserName) {
		case "Chrome":
			/*System.setProperty("webdriver.chrome.driver",
					"E:\\TESTING SHASTRA\\JAVA VIDEOS\\WebDrivers\\chromedriver.exe");*/
			WebDriverManager.chromedriver().setup();
			Constants.setDriver( new ChromeDriver());
			
			 
			break;
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			/*System.setProperty("webdriver.gecko.driver",
					"E:\\TESTING SHASTRA\\JAVA VIDEOS\\WebDriver\\geckodriver.exe");*/
			Constants.setDriver( new FirefoxDriver());
			//System.out.println("FireFox browser launched succesfully..");
		case "IE":
			/*System.setProperty("webdriver.ie.driver",
					"E:\\TESTING SHASTRA\\JAVA VIDEOS\\Webdriver\\IEDriverServer.exe");*/
			WebDriverManager.iedriver().setup();
		default:
			System.out.println("Invalid browser name" + browserName
					+ "please select InternetExplorer OR Chome browser OR FireFox browser");
			break;
		}
		Constants.getLog().info(browserName+" launched Succesfully..");
	}

	// 2.For entering URL
	public static void enterURL(String uRL) {
		Constants.getDriver().get(uRL);
		Constants.getLog().info(uRL+" entered successfully.");
		//Constants.log.info(uRL+" entered successfully.");
	}

	// 3.For sending or entering text in TextBox(Require locator Type,
	// webelement,value to be send)
	public static void enterText(String locatorType, String webelement, String value) {
		Keywords.choice(locatorType, webelement).sendKeys(value);
		/*
		 * switch (locatorType) { case "id":
		 * Constants.driver.findElement(By.id(webelement)).sendKeys(value);
		 * System.out.println(""); break; case "name":
		 * Constants.driver.findElement(By.name(webelement)).sendKeys(value);
		 * System.out.println("Text enterd succesfully."); break; case
		 * "className":
		 * Constants.driver.findElement(By.className(webelement)).sendKeys(value
		 * ); System.out.println("Text enterd succesfully."); break; case
		 * "xpath":
		 * Constants.driver.findElement(By.xpath(webelement)).sendKeys(value);
		 * System.out.println("Text enterd succesfully."); break; case
		 * "cssSelector":
		 * Constants.driver.findElement(By.cssSelector(webelement)).sendKeys(
		 * value); System.out.println("Text enterd succesfully."); break; case
		 * "partialLinkText":
		 * Constants.driver.findElement(By.partialLinkText(webelement)).sendKeys
		 * (value); System.out.println("Text enterd succesfully."); break; case
		 * "linkText":
		 * Constants.driver.findElement(By.linkText(webelement)).sendKeys(value)
		 * ; System.out.println("Text enterd succesfully."); break; case
		 * "tagName":
		 * Constants.driver.findElement(By.tagName(webelement)).sendKeys(value);
		 * System.out.println("Text enterd succesfully."); default:
		 * System.out.println("Invalid Locator" + locatorType); break; }
		 */
	}

	// 4. TO get the Title of page
	public static void getTitle() {
		System.out.println("Page Title is" + Constants.getDriver().getTitle());
	}

	// 5. To get current URl.
	public static void getCurrentURL() {
		System.out.println("Cuurent URL is" + Constants.getDriver().getCurrentUrl());
	}

	// 6. To click on Webelement
	public static void click(String locatorType, String webelement) {

		Keywords.choice(locatorType, webelement).click();

		/*
		 * switch (locatorType) { case "id":
		 * Constants.driver.findElement(By.id(webelement)).click(); ;
		 * System.out.println("Click on webelement"); break; case "name":
		 * Constants.driver.findElement(By.name(webelement)).click();
		 * System.out.println("Click on webelement"); break; case "className":
		 * Constants.driver.findElement(By.className(webelement)).click(); ;
		 * System.out.println("Click on webelement"); break; case "xpath":
		 * Constants.driver.findElement(By.xpath(webelement)).click(); ;
		 * System.out.println("Click on webelement"); break; case "cssSelector":
		 * Constants.driver.findElement(By.cssSelector(webelement)).click();
		 * System.out.println("Click on webelement"); break; case
		 * "partialLinkText":
		 * Constants.driver.findElement(By.partialLinkText(webelement)).click();
		 * ; System.out.println("Click on webelement"); break; case "linkText":
		 * Constants.driver.findElement(By.linkText(webelement)).click();
		 * System.out.println("Click on webelement"); break; case "tagName":
		 * Constants.driver.findElement(By.tagName(webelement)).click();
		 * System.out.println("Click on webelement"); default:
		 * System.out.println("Invalid Locator" + locatorType); break; }
		 */
	}

	// 7.For getting Alert text
	public static void getAlertText() {
		Alert alert = Constants.getDriver().switchTo().alert();
		System.out.println("Alert message is :" + alert.getText());
	}

	// 8.For accepting Alert
	public static void acceptAlert() {
		Alert alert = Constants.getDriver().switchTo().alert();
		System.out.println("Alert message is :" + alert.getText());
		alert.accept();

	}

	// 9. For Dismissing Alert
	public static void dismissAlert() {
		Alert alert = Constants.getDriver().switchTo().alert();
		System.out.println("Alert message is : " + alert.getText());
		alert.dismiss();
	}

	// 10.To navigate on previous Page
	public static void moveToBack() {
		Constants.getDriver().navigate().back();
		System.out.println("Moved 1 step back");
	}

	// 11. To navigate forward
	public static void moveToForward() {
		Constants.getDriver().navigate().forward();
		System.out.println("Moved forward");
	}

	// 12. To refresh the page
	public static void refreshPage() {
		Constants.getDriver().navigate().refresh();
		System.out.println("Page refreshed..");
	}

	// 13.For moving to Specific URL
	public static void moveToURL(String uRL) {
		Constants.getDriver().navigate().to(uRL);
		System.out.println("Move on " + uRL);
	}

	// 14.For Maximizing window
	public static void maximizeWindow() {
		Constants.getDriver().manage().window().maximize();
		System.out.println("Window maximized..");
	}

	// 15.For Minimizing window
	public static void minimizeWindow() {
		Constants.getDriver().manage().window().setPosition(new Point(-2000, -1000));
		System.out.println("Window minimized..");
	}

	// 16.For clicking on element by JavaScript
	public static void clickElementByJavaScript(WebElement jScriptElement) {
		JavascriptExecutor js = (JavascriptExecutor) Constants.getDriver();
		js.executeScript("argument[0].click()", jScriptElement);
		System.out.println("Clicked by JavaScript on" + jScriptElement);
	}

	// 17. For drawing border
	public static void drawBorder(WebElement jScriptElement) {
		JavascriptExecutor js = (JavascriptExecutor) Constants.getDriver();
		js.executeScript("argument[0].style.border='3px solid red'", jScriptElement);
		System.out.println("Border drawn");
	}

	// 18.// For getting text
	public static void getText() {

	}

	// 19. For selecting value from DropDown on the basis of ID.
	public static void selectFromDropDown(String locatorType, String webelement, int id) {
		Constants.setElement(Keywords.choice(locatorType, webelement));
		//Constants.select = new Select(Constants.getElement());
		//Constants.select.selectByIndex(id);
		Constants.setSelect(new Select(Constants.getElement()));
		Constants.getSelect().selectByIndex(id);
		/*
		 * switch (locatorType) { case "xpath": { element =
		 * Constants.driver.findElement(By.xpath(webelement)); select = new
		 * Select(element); select.selectByIndex(id); System.out.println(
		 * "Select data from dropdown list"); break;
		 * 
		 * } case "cssSelector": { element =
		 * Constants.driver.findElement(By.xpath(webelement)); select = new
		 * Select(element); select.selectByIndex(id); System.out.println(
		 * "Select data from dropdown list"); break; } case "id": { element =
		 * Constants.driver.findElement(By.xpath(webelement)); select = new
		 * Select(element); select.selectByIndex(id); System.out.println(
		 * "Select data from dropdown list"); break; } case "name": { element =
		 * Constants.driver.findElement(By.xpath(webelement)); select = new
		 * Select(element); select.selectByIndex(id); System.out.println(
		 * "Select data from dropdown list"); break; } case "partialLinkText": {
		 * 
		 * element = Constants.driver.findElement(By.xpath(webelement)); select
		 * = new Select(element); select.selectByIndex(id); System.out.println(
		 * "Select data from dropdown list"); break; } case "className": {
		 * element = Constants.driver.findElement(By.xpath(webelement)); select
		 * = new Select(element); select.selectByIndex(id); System.out.println(
		 * "Select data from dropdown list"); break; } case "LinkText": {
		 * element = Constants.driver.findElement(By.xpath(webelement)); select
		 * = new Select(element); select.selectByIndex(id); System.out.println(
		 * "Select data from dropdown list"); break; } case "tagName": { element
		 * = Constants.driver.findElement(By.xpath(webelement)); select = new
		 * Select(element); select.selectByIndex(id); System.out.println(
		 * "Select data from dropdown list"); break; } default:
		 * System.out.println("Invalid LocatorType" + locatorType); break; }
		 */
		System.out.println("Selected" + id);
	}

	// 20. For selecting value from DropDown on the basis of value and visible
	// text.
	public static void selectFromDropDown(String locatorType, String webelement, String value) {
		WebElement element = null;
		Select select = null;
		switch (locatorType) {
		case "xpath": {
			element = Constants.getDriver().findElement(By.xpath(webelement));
			select = new Select(element);
			select.selectByVisibleText(value);
			System.out.println("Select data from dropdown list");
			break;

		}
		case "cssSelector": {
			element = Constants.getDriver().findElement(By.xpath(webelement));
			select = new Select(element);
			select.selectByVisibleText(value);
			System.out.println("Select data from dropdown list");
			break;
		}
		case "id": {
			element = Constants.getDriver().findElement(By.xpath(webelement));
			select = new Select(element);
			select.selectByVisibleText(value);
			System.out.println("Select data from dropdown list");
			break;
		}
		case "name": {
			element = Constants.getDriver().findElement(By.xpath(webelement));
			select = new Select(element);
			select.selectByVisibleText(value);
			System.out.println("Select data from dropdown list");
			break;
		}
		case "partialLinkText": {

			element = Constants.getDriver().findElement(By.xpath(webelement));
			select = new Select(element);
			select.selectByVisibleText(value);
			System.out.println("Select data from dropdown list");
			break;
		}
		case "className": {
			element = Constants.getDriver().findElement(By.xpath(webelement));
			select = new Select(element);
			select.selectByVisibleText(value);
			System.out.println("Select data from dropdown list");
			break;
		}
		case "LinkText": {
			element = Constants.getDriver().findElement(By.xpath(webelement));
			select = new Select(element);
			select.selectByVisibleText(value);
			System.out.println("Select data from dropdown list");
			break;
		}
		case "tagName": {
			element = Constants.getDriver().findElement(By.xpath(webelement));
			select = new Select(element);
			select.selectByVisibleText(value);
			System.out.println("Select data from dropdown list");
			break;
		}
		default:
			System.out.println("Invalid LocatorType" + locatorType);
			break;
		}

	}

	// 21.For generating level logs
	/*public static void generateLog(String level, String logMessage) {
		Constants.log = Logger.getLogger(Executor.class);
		switch (level) {
		case "debug": {
			Constants.log.debug(logMessage);

			break;
		}
		case "info": {
			Constants.log.info(logMessage);
			break;
		}

		case "error": {

			Constants.log.error(logMessage);
			break;
		}
		case "fatal": {
			Constants.log.fatal(logMessage);
			break;
		}
		default:

			System.out.println("Wrong level Selection:" + level);

			break;
		}
	}*/

	// 22. To apply Implicit wait in seconds
	public static void applyImplicitWait(long time) {
		Constants.getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// 23.For closing the browser
	public static void closeBrowser() {
		Constants.getDriver().close();
		System.out.println("Browser closed succesfully");
	}

	// 24.For quiting the browser
	public static void quitBrowser() {
		Constants.getDriver().quit();
		System.out.println("Browser quits succesfully..");
	}

	// 25. To delete all cookies.
	public static void clearCookies() {
		Constants.getDriver().manage().deleteAllCookies();
	}

	// 26. To take screenshot
	public static void takeScreenshot(String path) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) Constants.getDriver();
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(path));
	}

	// 27. TO take Screenshot using Ashot class
	public static void takeScreenShot(int timeOut, String formatType, String filePath) {
		AShot as = new AShot();
		Screenshot scshot = as.shootingStrategy(ShootingStrategies.viewportPasting(timeOut))
				.takeScreenshot(Constants.getDriver());
		try {
			ImageIO.write(scshot.getImage(), formatType, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 28 To select check box
	public static void Checkbox(String webElement, String value) {
		List<WebElement> checkbox = Constants.getDriver().findElements(By.xpath(webElement));
		int size = checkbox.size();
		for (int i = 0; i < size; i++) {
			String checkBoxvalue = checkbox.get(i).getAttribute("value");
			if (checkBoxvalue.equalsIgnoreCase(value)) {
				checkbox.get(i).click();
			}
		}
	}
   //29.TO read excel data
	public static String readExcelStringData(String filePath,int sheetNumber,int rowNumber,int cellNumber){
		File src = new File(filePath);
		
		try {
			Constants.setFis( new FileInputStream(src));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Constants.setWb( new XSSFWorkbook(Constants.getFis()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet1 = Constants.getWb().getSheetAt(sheetNumber);
		String data = sheet1.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		System.out.println("Data read from Excel successfully");
		return data;
	}
	//30. TO read integer value from excel sheet
	public static double readExcelNumericData(String filePath,int sheetNumber,int rowNumber,int cellNumber){
		Constants.setFile(new File(filePath));
		
		try {
			Constants.setFis(new FileInputStream(Constants.getFile()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Constants.setWb(new XSSFWorkbook(Constants.getFis()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet1 = Constants.getWb().getSheetAt(sheetNumber);
		double data= sheet1.getRow(rowNumber).getCell(cellNumber).getNumericCellValue();
		System.out.println("Data read from Excel successfully");
		return data;
	}
	//31. JDBC COnnection and fetching the data from database.
	 public static String getDataFromDatabase(String query, int cellNumber) throws SQLException
	 { 
		 String name=null;
		  String dbUrl = "jdbc:mysql://localhost:3307/resonantia";					

			//Database Username		
			String username = "root";	
	        
			//Database Password		
			String password = "root123";				

			//Query to Execute		
			String query1 = query;	
	        
	 	    //Load mysql jdbc driver		
	   	    try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	   
	   		//Create Connection to DB		
	    	Connection con = (Connection) DriverManager.getConnection(dbUrl,username,password);
	  
	  		//Create Statement Object		
		   Statement stmt = (Statement) con.createStatement();					

				// Execute the SQL Query. Store results in ResultSet		
	 		ResultSet rs= stmt.executeQuery(query);							
	 
	 		// While Loop to iterate through all data and print results		
			while (rs.next()){
		        		 name = rs.getString(cellNumber);	
		        		  
	            }		
				 // closing DB Connection		
				con.close();	
		return name;
		 
	 }
	 //32. Upload file using SendKeys Method
	 public static void uploadFileBySendKey(String locatortype, String filepath, String webelement)
	 {
		 Keywords.choice(locatortype,  webelement).sendKeys(filepath);	 
	 }
	// 33. Upload file using Robot class
	 public static void uploadFile(String locatortype, String filepath, String webelement)
	 {
		 Keywords.choice(locatortype, webelement).click();
		 StringSelection stringSelection = new StringSelection(filepath);
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(stringSelection, null);
	        Robot robot = null;
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	        robot.delay(250);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(150);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	 }
	// Common method for switching between locator type.
	private static WebElement choice(String locatorType, String webelement) {

		switch (locatorType) {
		case "xpath": {
			Constants.setElement(Constants.getDriver().findElement(By.xpath(webelement)));
			break;

		}
		case "cssSelector": {
			Constants.setElement(Constants.getDriver().findElement(By.cssSelector(webelement)));
			break;
		}
		case "id": {
			Constants.setElement(Constants.getDriver().findElement(By.id(webelement)));
			break;
		}
		case "name": {
			Constants.setElement(Constants.getDriver().findElement(By.name(webelement)));
			break;
		}
		case "partialLinkText": {
			Constants.setElement(Constants.getDriver().findElement(By.partialLinkText(webelement)));
			break;
		}
		case "className": {
			Constants.setElement(Constants.getDriver().findElement(By.className(webelement)));
			break;
		}
		case "LinkText": {
			Constants.setElement(Constants.getDriver().findElement(By.linkText(webelement)));
			break;
		}
		case "tagName": {
			Constants.setElement(Constants.getDriver().findElement(By.tagName(webelement)));
			break;
		}
		default:
			System.out.println("Invalid LocatorType" + locatorType);
			break;

		}
		return Constants.getElement();
	}
}
