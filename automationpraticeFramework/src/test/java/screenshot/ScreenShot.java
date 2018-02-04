package screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class ScreenShot {

	public static String screenCapture(WebDriver driver, String screenShotName) throws IOException{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String path = (System.getProperty("user.dir")+"/report/FailedCapture/");
	String dest = path+screenShotName+".png";
	File destination = new File(dest);
	FileUtils.copyFile(source, destination);
	
	return dest;
	}
	
	public static void captureScreen(WebDriver driver, String screenShotName) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
		String path = (System.getProperty("user.dir")+"/report/Screenshot/");
		String dest = path+screenShotName+"_"+formater.format(calendar.getTime())+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
	}
}
