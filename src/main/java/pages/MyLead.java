package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class MyLead extends ProjectSpecificMethod{
	
//	
//	public LoginPage(ChromeDriver driver) {
//		this.driver=driver;
//	}

	public CreateLead clickOnCreateLead() throws IOException {
		try {
			getDriver().findElement(By.linkText("Create Lead")).click();
			reportStep("Createlead button is clicked", "pass");
		} catch (Exception e) {
			reportStep("Createlead button is not clicked", "fail");
		}	
		return new CreateLead();
	}
	
}
