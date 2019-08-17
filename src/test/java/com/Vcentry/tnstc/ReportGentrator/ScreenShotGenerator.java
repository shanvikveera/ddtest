
package com.Vcentry.tnstc.ReportGentrator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.Vcentry.tnstc.Initializer.Initializer;
import com.relevantcodes.extentreports.LogStatus;

public class ScreenShotGenerator extends Initializer{

	public static void generatScreenshot(ITestResult it) throws IOException{
		Object [] data=it.getParameters();
	   	 if(it.isSuccess())
	   	 {
	   	 String path=takeScreenshot(data[0].toString());
	   	 
	   	 log.log(LogStatus.PASS, "testcase pass", log.addScreenCapture(path));
	   	 }else 
	   	 {
	       	 String path=takeScreenshot(data[0].toString());
	       	 log.log(LogStatus.FAIL, "testcase pass", log.addScreenCapture(path));
	         }
	   	 reports.endTest(log);
	   	 reports.flush();
	    
	}
	public static String takeScreenshot(String name) throws IOException{
		File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		File dst=new File("C:\\Users\\shanwik\\workspace2\\DDDTest\\Screenshot\\"+name+".jpg");
		FileUtils.copyFile(src, dst);
		return dst.toString(); 	
	}
}
