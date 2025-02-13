package Reports;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnextentsReport {

	public static void main(String[] args) throws IOException {
		
		//Step 1
		ExtentHtmlReporter repo = new ExtentHtmlReporter("./EReports/extentReports.html");
		
		//Step 2
		repo.setAppendExisting(true);
		
		//Step 3
		ExtentReports er = new 	ExtentReports();
		er.attachReporter(repo);
		
		//Step 4
		ExtentTest test = er.createTest("LoginPage", "Test login data for leaftaps application");
		test.assignAuthor("Scoot");
		test.assignCategory("Sanity");
		
		//Step 5
		test.pass("Enter the username is Successful");
		test.pass("Enter the password is Successful");
		test.pass("Login is clicked Successful", MediaEntityBuilder.createScreenCaptureFromPath(".././SnapShot/image.png").build());
		test.pass("crmsfa is clicked", MediaEntityBuilder.createScreenCaptureFromPath(".././SnapShot/image1.png").build());
		
		//Step 6
		er.flush();
		System.out.println("done");
		
		
	}

}
