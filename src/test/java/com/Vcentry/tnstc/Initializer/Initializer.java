package com.Vcentry.tnstc.Initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vcentry.tnstc.ReportGentrator.ReportOptimizer;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Initializer {
	/**
	 * Report variables
	 */
	public static ExtentReports reports;
	public static ExtentTest log;
	/**
	 * @author shanwik
	 * Declare webdriver variable
	 */
	public static WebDriver wd=null;
/**
 * @author shanwik
 * declare environment variables
 */
	public static FileInputStream envfis=null;
	public static Properties envprop=null;
/**
 * @author shanwik
 * Declare Locator Variables
 * @throws IOException
 */
	public static FileInputStream locfis=null;
	public static Properties locprop=null;
	
	public static boolean isReportExist=true;
	public static void initialize() throws IOException{
		if(isReportExist){
ReportOptimizer.optimizeReport();
		reports=new ExtentReports("C:\\Users\\shanwik\\workspace2\\DDDTest\\Reports\\report.html");
		isReportExist=false;
		}
	//File f=new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"Vcentry"+File.separator+"tnstc"+File.separator+"config"+File.separator+"env.properties");
	//FileInputStream envfis=new FileInputStream(f);
		
	envfis=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"Vcentry"+File.separator+"tnstc"+File.separator+"config"+File.separator+"env.properties"));
	
	envprop=new Properties();
	envprop.load(envfis);
	
locfis=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"Vcentry"+File.separator+"tnstc"+File.separator+"config"+File.separator+"locators.properties"));
	
	locprop=new Properties();
	locprop.load(locfis);
	
	if(wd==null){
	
	if(envprop.getProperty("BROWSER").equals("FIREFOX")){
	wd=new FirefoxDriver();
	}
	}
	wd.manage().window().maximize();
	wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	//wd.manage().deleteAllCookies();To delete all the cookies
	
	}
	public static WebElement getElementByName(String name){
		return wd.findElement(By.name(locprop.getProperty(name)));
	}
}
