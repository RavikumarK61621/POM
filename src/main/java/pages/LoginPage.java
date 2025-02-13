package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;


public class LoginPage extends ProjectSpecificMethod{
//	
//	public LoginPage(ChromeDriver driver) {
//		this.driver=driver;
//	}

//	@When ("Enter the username as {string}")
	public LoginPage userName() throws IOException {
		try {
			getDriver().findElement(By.id("username")).sendKeys(pro.getProperty("username"));
			reportStep("Entered UserName as Successful", "pass");
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("Entered UserName as not Successful", "fail");
		}
		return this;
	}
	
//	@And ("Enter the password as {string}")
	public LoginPage passWord() throws IOException {
		try {
			getDriver().findElement(By.id("password")).sendKeys(pro.getProperty("password"));
			reportStep("Entered Password as Successful", "pass");
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("Entered Password as not Successful", "fail");
		}
		return this;
	}
//	@And ("Click on LoginButton")
	public WelcomePage clickLoginButton() throws IOException {
		try {
			getDriver().findElement(By.className("decorativeSubmit")).click();
			reportStep("Login as Successful", "pass");
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("Login as not Successful", "fail");
		}	
		return new WelcomePage();
	}
}
