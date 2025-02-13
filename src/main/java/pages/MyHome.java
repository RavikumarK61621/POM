package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class MyHome extends ProjectSpecificMethod{
	
//	public MyHome(ChromeDriver driver) {
//		this.driver=driver;
//	}

	public MyLead clickOnLeads() throws IOException {
		try {
			getDriver().findElement(By.linkText(pro.getProperty("MyHome.Lead"))).click();
			reportStep("Leads button is clicked", "pass");
		} catch (Exception e) {
			reportStep("Leads button is not clicked", "fail");
		}
	return new MyLead();
	}
	
}
