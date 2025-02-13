package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import base.ProjectSpecificMethod;

public class CreateLead extends ProjectSpecificMethod{
	
//	public CreateLead(ChromeDriver driver) {
//		this.driver=driver;
//	}
	
	public CreateLead clickOnCompanyName(String Cname) throws IOException {
		try {
			getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys(Cname);
			reportStep("Company name is entered in company name field", "pass");
		} catch (Exception e) {
			reportStep("Company name is not entered in company name field", "fail");
		}
		return this;
	} 
	
	public CreateLead clickOnFirstName(String Fname) throws IOException {
		try {
			getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys(Fname);
			reportStep("First name is entered in first name field", "pass");
		} catch (Exception e) {
			reportStep("First name is not entered in first name field", "fail");
		}
		return this;
	} 
	
	public CreateLead clickOnLastName(String Lname) throws IOException {
		try {
			getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys(Lname);
			reportStep("Last name is entered in last name field", "pass");
		} catch (Exception e) {
			reportStep("Last name is noy entered in last name field", "fail");;
		}
		return this;
	}

	public ViewLead clickOnCreateLead() throws IOException {
		try {
			getDriver().findElement(By.name("submitButton")).click();
			reportStep("CreateLead button is clicked", "pass");
		} catch (Exception e) {
			reportStep("CreateLead button is not clicked", "fail");
		}
		return new ViewLead();
	}

}
