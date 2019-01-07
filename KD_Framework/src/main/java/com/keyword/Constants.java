package com.keyword;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import lombok.Getter;
import lombok.Setter;

//POJO plane old Java objects
//https://projectlombok.org/downloads/lombok.jar to generate getter setter method.
//


public class Constants {
	/*public static WebDriver driver;
	public static Logger log;
	public static WebElement element;
	public static Select select;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static Properties property;
	*/
	private static WebDriver driver;
	private static Logger log;
	private static WebElement element;
	private static Select select;
	private static FileInputStream fis;
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	private static Properties property;
	private static File file;
	public static File getFile() {
		return file;
	}
	public static void setFile(File file) {
		Constants.file = file;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		Constants.driver = driver;
	}
	public static Logger getLog() {
		return log;
	}
	public static void setLog(Logger log) {
		Constants.log = log;
	}
	public static WebElement getElement() {
		return element;
	}
	public static void setElement(WebElement element) {
		Constants.element = element;
	}
	public static Select getSelect() {
		return select;
	}
	public static void setSelect(Select select) {
		Constants.select = select;
	}
	public static FileInputStream getFis() {
		return fis;
	}
	public static void setFis(FileInputStream fis) {
		Constants.fis = fis;
	}
	public static XSSFWorkbook getWb() {
		return wb;
	}
	public static void setWb(XSSFWorkbook wb) {
		Constants.wb = wb;
	}
	public static Properties getProperty() {
		return property;
	}
	public static void setProperty(Properties property) {
		Constants.property = property;
	}
	public static XSSFSheet getSheet() {
		return sheet;
	}
	public static void setSheet(XSSFSheet sheet) {
		Constants.sheet = sheet;
	}
	
	
}
