package com.Vcentry.tnstc.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vcentry.tnstc.Initializer.Initializer;
import com.Vcentry.tnstc.ReportGentrator.ScreenShotGenerator;
import com.Vcentry.tnstc.inputreader.inputReader;
import com.Vcentry.tnstc.pages.RegPage;
import com.relevantcodes.extentreports.LogStatus;

public class RegPageTest extends Initializer {
	@Test(dataProvider = "RegPageTest")
	public void validateRegpage(String tcName, String Username, String Password, String Cpassword,
			String SecretQuestion, String SQAnswer) throws IOException {
		initialize();
		log = reports.startTest(tcName + " Initiated");
		wd.get(envprop.getProperty("URL"));
		/*
		 * wd.findElement(By.name("txtUserLoginID")).sendKeys("Shanvik");
		 * wd.findElement(By.name("txtPassword")).sendKeys("1234");
		 * wd.findElement(By.name("txtConfirmPassword")).sendKeys("1234");
		 * 
		 * WebElement dropdown=wd.findElement(By.name("txtSecretQuestion"));
		 * Select s=new Select(dropdown);
		 * s.selectByVisibleText("High school name?");
		 * wd.findElement(By.name("txtSecretAnswer")).sendKeys("ABC");
		 */

		/*
		 * wd.findElement(By.name(locprop.getProperty(
		 * "REGPAGE_TYPE_USERNAME_NAME"))).sendKeys("Shanvik");
		 * wd.findElement(By.name(locprop.getProperty(
		 * "REGPAGE_TYPE_PASSWORD_NAME"))).sendKeys("1234");
		 * wd.findElement(By.name(locprop.getProperty(
		 * "REGPAGE_TYPE_CPASSWORD_NAME"))).sendKeys("1234");
		 * 
		 * WebElement dropdown=wd.findElement(By.name(locprop.getProperty(
		 * "REGPAGE_SELECT_SECRETQUESTION_NAME"))); Select s=new
		 * Select(dropdown); s.selectByVisibleText("High school name?");
		 * wd.findElement(By.name(locprop.getProperty(
		 * "REGPAGE_TYPE_SANSWER_NAME"))).sendKeys("ABC");
		 */
		/*
		 * getElementByName("REGPAGE_TYPE_USERNAME_NAME").sendKeys("shanvik");
		 * getElementByName("REGPAGE_TYPE_PASSWORD_NAME").sendKeys("1234");
		 * getElementByName("REGPAGE_TYPE_CPASSWORD_NAME").sendKeys("1234");
		 * WebElement
		 * dropdown=getElementByName("REGPAGE_SELECT_SECRETQUESTION_NAME");
		 * Select s=new Select(dropdown);
		 * s.selectByVisibleText("High school name?");
		 * getElementByName("REGPAGE_TYPE_SANSWER_NAME").sendKeys("abcd");
		 */

		RegPage.enterUsername(Username);
		RegPage.enterPassword(Password);
		RegPage.enterCpassword(Cpassword);
		RegPage.enterSecretQuestion(SecretQuestion);
		RegPage.enterSQAnswer(SQAnswer);

	}

	@DataProvider(name = "RegPageTest")
	public static Object[][] getData() throws Exception {
		if (inputReader.RunModeVerification("RegPageTest")) {

			Object[][] data = inputReader.selectSingleDataOrMulitiData("RegPageTest");
			return data;
		}
		return null;

	}

	@AfterMethod
	public void teardown(ITestResult it) throws IOException {
		ScreenShotGenerator.generatScreenshot(it);
	}

}
