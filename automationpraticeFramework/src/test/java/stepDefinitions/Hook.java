package stepDefinitions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Base.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import excel.ExcelHandle;
import property.PropertyReader;
import screenshot.ScreenShot;

public class Hook extends BaseClass {
	
	private BaseClass baseUtil;
//	public static ExtentReports extentreport;
//	public static ExtentTest extentTest;
	public static String reportName;
	public Hook(BaseClass baseUtil){
		this.baseUtil = baseUtil;
	}
	
	static{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
		reportName = (System.getProperty("user.dir")+"/report/extentReport/" + formater.format(calendar.getTime())+".html");
		extentreport = new ExtentReports(reportName,false);
		try {
			ExcelHandle.createExcelFile("Result_" + formater.format(calendar.getTime()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Before
	public void initializeTest(Scenario scenario){
		extentTest = extentreport.startTest(scenario.getName());
		selectBrowser();
	}
	
	@After
	public void tearDown(Scenario scenario) throws IOException{
		if (scenario.isFailed()){
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
			String screenShotName = scenario.getName() + formater.format(calendar.getTime());
			String screenShotPath = ScreenShot.screenCapture(baseUtil.driver, screenShotName);
			System.out.println(scenario.getName() + " is failed");
			extentTest.log(LogStatus.FAIL, scenario.getName() + " is failed");
			extentTest.log(LogStatus.FAIL, "snapshot below: " + extentTest.addScreenCapture(screenShotPath));
			ExcelHandle.updateResultInExcelSheet(scenario.getName(), "Failed");
			baseUtil.driver.close();
			baseUtil.driver.quit();
		}
		else{
			System.out.println(scenario.getName() + " is passed");
			extentTest.log(LogStatus.PASS, scenario.getName() + " is passed");
			ExcelHandle.updateResultInExcelSheet(scenario.getName(), "Passed");
			baseUtil.driver.close();
			baseUtil.driver.quit();
		}
		extentreport.endTest(extentTest);
		extentreport.flush();
	}
	
	public void selectBrowser(){
		String browser = new PropertyReader().readProperty("browser");
		String webDriverPath = new PropertyReader().readProperty("webDriverPath");
		System.out.println(browser);

        //For Firefox browser
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", webDriverPath);
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            baseUtil.driver = new FirefoxDriver();
        }

        //For Chrome browser
        else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",webDriverPath);
            baseUtil.driver = new ChromeDriver();
            baseUtil.driver.manage().window().maximize();
        }

        //For Internet Explorer browser
        else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver",webDriverPath);
            baseUtil.driver = new InternetExplorerDriver();
            baseUtil.driver.manage().window().maximize();
        }

        //For Edge browser
        else if (browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver",webDriverPath);
            baseUtil.driver = new EdgeDriver();
            baseUtil.driver.manage().window().maximize();
        }
	}
}
