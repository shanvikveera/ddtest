package com.Vcentry.tnstc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Vcentry.tnstc.Initializer.Initializer;

public class RegPage extends Initializer{
	public static void enterUsername(String Username){
		getElementByName("REGPAGE_TYPE_USERNAME_NAME").sendKeys(Username);
	}
	public static void enterPassword(String Password){
		getElementByName("REGPAGE_TYPE_PASSWORD_NAME").sendKeys(Password);
	}
	public static void enterCpassword(String Cpassword){
		getElementByName("REGPAGE_TYPE_CPASSWORD_NAME").sendKeys(Cpassword);
	}
	public static void enterSecretQuestion(String SQ){
		WebElement dropdown=getElementByName("REGPAGE_SELECT_SECRETQUESTION_NAME");
		Select s=new Select(dropdown);
		s.selectByVisibleText(SQ);
	}
	public static void enterSQAnswer(String Answer){
		getElementByName("REGPAGE_TYPE_SANSWER_NAME").sendKeys(Answer);
		
	}

}
