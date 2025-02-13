package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilis.DataSheet;

public class ProjectSpecificMethod extends AbstractTestNGCucumberTests{
	
	private static final ThreadLocal<RemoteWebDriver> cdDriver=new ThreadLocal<RemoteWebDriver>();
	
	public void setDriver() {
		cdDriver.set(new ChromeDriver());
	}
	
	public RemoteWebDriver getDriver() {
		return cdDriver.get();
	}
	
	
//	public ChromeDriver driver;
	
	public String datasheet;
	public static Properties pro;
	public static ExtentHtmlReporter repo;
	public static ExtentReports er;
	public static ExtentTest test;
	public static String testName, testDescription, testAuthor, testCategory;
	
	
	@BeforeMethod
	public void preCondition() throws IOException{
		
		FileInputStream fis = new FileInputStream("src/main/resources/English.properties");
		
		pro = new Properties();
		
		pro.load(fis);
		
//		driver = new ChromeDriver();
		setDriver();
		getDriver().manage().window().maximize();
		getDriver().get("http://leaftaps.com/opentaps/");
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterMethod
	public void postCondition() {
		getDriver().close();
	}

	@DataProvider(name = "xdata")
	public String[][] fetchData() throws IOException{
		return DataSheet.readExcel(datasheet);
	}
	
	
	@BeforeSuite
	public void startReport() {
		
		repo = new ExtentHtmlReporter("./EReports/extentReports.html");
		repo.setAppendExisting(true);
		er = new 	ExtentReports();
		er.attachReporter(repo);
	}
	
	@BeforeClass 
	public void testDetails() {
		test = er.createTest("testName", "testDescription");
		test.assignAuthor("testAuthor");
		test.assignCategory("testCategory");
	}
	
	
	public void reportStep(String stepDetails, String status) throws IOException {
		if (status.equalsIgnoreCase("pass")) {
			test.pass(stepDetails, MediaEntityBuilder.createScreenCaptureFromPath(".././SnapShot/Image"+takeSnap()+".png").build());
					
        } else if (status.equalsIgnoreCase("fail")) {
        	test.fail(stepDetails, MediaEntityBuilder.createScreenCaptureFromPath(".././SnapShot/Image"+takeSnap()+".png").build());
        }
		
	}
	
	public int takeSnap() throws IOException {
		int random = (int)(Math.random()*99999);
		File scr = getDriver().getScreenshotAs(OutputType.FILE);
		File dst=new File("./SnapShot/image"+random+".png");
		FileUtils.copyFile(scr, dst);
		
		return random;
	}
	
	
	@AfterSuite 
	public void stopReport() {
		er.flush();
	}
	
	
	
	
}
