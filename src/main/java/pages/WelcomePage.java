package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.Then;

public class WelcomePage extends ProjectSpecificMethod{

//	public WelcomePage(ChromeDriver driver) {
//		this.driver=driver;
//	}
	
	@Then ("Verify the title of the page")
	public WelcomePage welcomePageVerify() {
		try {
			String title = getDriver().getTitle();
			if(title.contains("Leaftaps")) {
				System.out.println("Login is Successful");
			}else
			{
				System.out.println("Login is not Successful");
			}test.info("pass");
		} catch (Exception e) {
			test.info("fail");
		}
		return this;
	}
	
	public MyHome clickCrmsfa() throws IOException {
		try {
			getDriver().findElement(By.linkText("CRM/SFA")).click();
			reportStep("Crmsfa is clicked successful", "pass");
		} catch (Exception e) {
			reportStep("Crmsfa is not clicked successful", "fail");
		}
		return new MyHome();
	}
	
		public LoginPage ClickSubmit() throws IOException {
			try {
				getDriver().findElement(By.xpath("//input[@type='submit']")).click();
				reportStep("Logout is successful", "pass");
			} catch (Exception e) {
				reportStep("Logout is not successful", "fail");
			}
			return new LoginPage();
		}
}
