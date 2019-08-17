package com.Vcentry.tnstc.ReportGentrator;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class ReportOptimizer {
public static void optimizeReport() throws IOException{
	Date date=new Date();
	SimpleDateFormat df=new SimpleDateFormat("YYYY-MM-DD hh-mm-ss-mmm");
	String name=df.format(date);
	File src=new File("C:\\Users\\shanwik\\workspace2\\DDDTest\\Screenshot");
File dst=new File("C:\\Users\\shanwik\\workspace2\\DDDTest\\OldScreenshot\\"+name);
FileUtils.copyDirectory(src, dst);
FileUtils.cleanDirectory(src);

}
}
